import com.example.maccomposetest.model.PostModel
import com.example.maccomposetest.service.ApiService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PostRepository : KoinComponent {
    private val apiService: ApiService by inject()

    suspend fun getPosts(): List<PostModel> {
        return apiService.getPosts()
    }

    suspend fun getPostsByPost(): List<PostModel> {
        return apiService.getPostsByPost()
    }
}

