package com.raywenderlich.placebook.repository


//import Bookmark
//import BookmarkDao
//import PlaceBookDatabase
import Bookmark
import BookmarkDao
import PlaceBookDatabase
import android.content.Context
import androidx.lifecycle.LiveData
/*import com.raywenderlich.placebook.db
import com.raywenderlich.placebook.db.PlaceBookDatabase
import com.raywenderlich.placebook.model.Bookmark*/

class BookmarkRepo(private val context: Context) {

    private val db: PlaceBookDatabase = PlaceBookDatabase.getInstance(context)
    private val bookmarkDao: BookmarkDao = db.bookmarkDao()

    fun addBookmark(bookmark: Bookmark): Long? {
        val newId = bookmarkDao.insertBookmark(bookmark)
        bookmark.id = newId
        return newId
    }

    fun createBookmark(): Bookmark {
        return Bookmark()
    }

    val allBookmarks: LiveData<List<Bookmark>>
        get() {
            return bookmarkDao.loadAll()
        }
}
