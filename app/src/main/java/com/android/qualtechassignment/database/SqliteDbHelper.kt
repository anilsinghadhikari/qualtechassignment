package com.android.qualtechassignment.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.android.qualtechassignment.data.UserBean
import com.android.qualtechassignment.myapplication.MyApplication

/**
 * Created by t on 9/23/2017.
 */
class SqliteDbHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        private val DB_NAME = MyApplication.getInstance()?.packageName
        private val DB_VERSION = 1
        private val ID: String = "_id"
        private val NAME: String = "name"
        private val EMAIL: String = "email"
        private val MOBILE: String = "mobile"
        private val TABLE_USER = "user_table"

        private var dbInstance: SqliteDbHelper? = null
        public fun getInstance(): SqliteDbHelper? {
            if (dbInstance == null) {
                dbInstance = SqliteDbHelper(MyApplication.getInstance()?.applicationContext)
            }
            return dbInstance
        }

    }

    val DATABASE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_USER +
                    "${NAME} text," +
                    "${EMAIL} text" + "${MOBILE} text" + ")"

//    val DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_USER + " (state_id text, state_name text)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        // Create tables again
        onCreate(db);
    }


    fun saveUserData(userBean: UserBean?) {

        writableDatabase.delete(TABLE_USER, null, null)

        val insertValues = ContentValues()
        insertValues.put(NAME, userBean?.userName)
        insertValues.put(EMAIL, userBean?.email)
        insertValues.put(MOBILE, userBean?.mobileNo)
        writableDatabase.insert(TABLE_USER, null, insertValues)
    }


    fun getUserData(): UserBean? {

        val selectQuery = "SELECT  * FROM " + TABLE_USER
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor == null || cursor.count == 0) {
            return null
        }
        val userBean = UserBean()
        userBean.userName = cursor.getString(cursor.getColumnIndex(NAME))
        userBean.email = cursor.getString(cursor.getColumnIndex(EMAIL))
        userBean.userName = cursor.getString(cursor.getColumnIndex(MOBILE))
        return userBean
    }
}