package com.example.maccomposetest.android.model

import org.threeten.bp.format.DateTimeFormatter


data class CalendarUiModel(
    val selectedDate: Date, // 目前所選日期
    val visibleDates: List<Date> // 呈現於畫面的日期
) {

    val startDate: Date = visibleDates.first() // 畫面上第一天
    val endDate: Date = visibleDates.last() // 畫面上最後一天

    data class Date(
        val date: org.threeten.bp.LocalDate,
        val isSelected: Boolean,
        val isToday: Boolean
    ) {
        val day: String = date.format(DateTimeFormatter.ofPattern("E")) // get the day by formatting the date
    }
}