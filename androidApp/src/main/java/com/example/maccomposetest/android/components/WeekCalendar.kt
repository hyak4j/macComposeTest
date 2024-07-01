package com.example.maccomposetest.android.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.maccomposetest.android.R
import com.example.maccomposetest.android.model.CalendarUiModel
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle


@Composable
fun Header(
    data: CalendarUiModel,
    onPrevClickListener: (LocalDate) -> Unit,
    onNextClickListener: (LocalDate) -> Unit,
) {
    Row (horizontalArrangement = Arrangement.End){
        Text(
            // show "Today" if user selects today's date
            // else, show the full format of the date
            text = if (data.selectedDate.isToday) {
                "Today"
            } else {
                data.selectedDate.date.format(
                    DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                )
            },
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        Icon(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(8.dp),
            painter = painterResource(R.drawable.icon_date),
            tint = Color(0xFF8B8B8B),
            contentDescription = "calendar"
        )
        IconButton(onClick = {
            onPrevClickListener(data.startDate.date)
        }) {
            Icon(
                imageVector = Icons.Filled.ChevronLeft,
                contentDescription = "Previous"
            )
        }
        IconButton(onClick = {
            onNextClickListener(data.endDate.date)
        }) {
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = "Next"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentItem(
    date: CalendarUiModel.Date,
    onDateClickListener: (CalendarUiModel.Date) -> Unit
) {
    Column {
        Card(
            modifier = Modifier
                .width(48.dp)
                .height(69.dp)
                .clip(RoundedCornerShape(50.dp))
                .clickable {
                    onDateClickListener(date)
                },
            colors = CardDefaults.cardColors(
                // background colors of the selected date
                // and the non-selected date are different
                containerColor = if (date.isSelected) {
                    //                MaterialTheme.colorScheme.primary
                    Color(0xFFEFC517)
                } else {
                    Color.Transparent
                }
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Spacer(modifier = Modifier.padding(top = 8.dp))
                // 週 M T W T F S S
                Text(
                    text = date.day.substring(0, 1), // day "Mon", "Tue" =>  "M", "T"
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    //  style = MaterialTheme.typography.bodySmall,
                    style = TextStyle(
                        //fontFamily = FontFamily(Font(Res.font.NotoSansTC_Regular)),
                        fontWeight = FontWeight.W700,
                        fontSize = 12.sp,
                        color = if (date.isSelected) {
                            Color.White
                        } else {
                            Color(0xFF8B8B8B)
                        }
                    ),
                )
                Spacer(modifier = Modifier.padding(top = 4.dp))
                // 日期
                Box (
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                        .background(Color.White, shape = CircleShape)
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = date.date.dayOfMonth.toString(), // date "15", "16"
                        style = TextStyle(
                            //                    fontFamily = FontFamily(Font(Res.font.NotoSansTC_Regular)),
                            fontWeight = FontWeight.W700,
                            fontSize = 12.sp,
                            color = if (date.isSelected) {
                                Color(0xFF333333)
                            } else {
                                Color(0xFF8B8B8B)
                            },
                        )
                    )
                }
            }
        }
        // 記錄標誌
        Box(modifier = Modifier
            .width(8.dp)
            .height(8.dp)
            .background(Color(0xFFEFC517), shape = CircleShape)
            .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun Content(
    data: CalendarUiModel,
    onDateClickListener: (CalendarUiModel.Date) -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 3.dp)
            .height(109.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // pass the visibleDates to the UI
        items(items = data.visibleDates) { date ->
            ContentItem(
                date = date,
                onDateClickListener
            )
        }
    }
}