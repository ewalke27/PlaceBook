import android.content.Context
import androidx.lifecycle.LiveData

// 1
class BookmarkRepo(context: Context) {
    // 2
    private val db = PlaceBookDatabase.getInstance(context)
    private val bookmarkDao: BookmarkDao = db.bookmarkDao()
    // 3
    fun addBookmark(bookmark: Bookmark): Long? {
        val newId = bookmarkDao.insertBookmark(bookmark)
        bookmark.id = newId
        return newId
    }
    // 4
    fun createBookmark(): Bookmark {
        return Bookmark()
    }
    // 5
    val allBookmarks: LiveData<List<Bookmark>>
        get() {
            return bookmarkDao.loadAll()
        }
}