package com.android.qualtechassignment.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.android.qualtechassignment.data.UserBean
import com.android.qualtechassignment.myapplication.MyApplication
import com.android.qualtechassignment.utilities.Logger
import com.android.qualtechassignment.utilities.Utility

/**
 * Created by t on 9/23/2017.
 */
class SqliteDbHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        private val DB_NAME = Utility.getPackageName()
        private val DB_VERSION = 1
        private val ID: String = "_id"
        private val NAME: String = "name"
        private val EMAIL: String = "email"
        private val MOBILE: String = "mobile"
        private val PROFILE_IMG_PATH: String = "profile_image_path"
        private val REF_CONTACT: String = "ref_contact"
        private val TABLE_USER = "user_table"

        private var dbInstance: SqliteDbHelper? = null

        @Synchronized
        fun getInstance(): SqliteDbHelper? {
            if (dbInstance == null) {
                dbInstance = SqliteDbHelper(MyApplication.getInstance()?.applicationContext)
            }
            return dbInstance
        }

    }

    val DATABASE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_USER + "(" +
                    "${NAME} text," +
                    "${EMAIL} text," + "${MOBILE} text, " + "${PROFILE_IMG_PATH} text, " + "${REF_CONTACT} text" + ")"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        // Create tables again
        onCreate(db);
    }


    fun saveUserData(userBean: UserBean?) {

        writableDatabase.delete(TABLE_USER, null, null) // we are deleting existing entries as we'll have only single user entry i this table

        val insertValues = ContentValues()
        insertValues.put(NAME, userBean?.userName)
        insertValues.put(EMAIL, userBean?.email)
        insertValues.put(MOBILE, userBean?.mobileNo)
        insertValues.put(PROFILE_IMG_PATH, userBean?.profileImagePath)
        insertValues.put(REF_CONTACT, userBean?.refContactNo)
        writableDatabase.insert(TABLE_USER, null, insertValues)
        writableDatabase?.close()
    }

    fun updateData(userBean: UserBean?): Int {

        val updateValues = ContentValues()
        updateValues.put(NAME, userBean?.userName)
        updateValues.put(EMAIL, userBean?.email)
        updateValues.put(MOBILE, userBean?.mobileNo)
        updateValues.put(PROFILE_IMG_PATH, userBean?.profileImagePath)
        updateValues.put(REF_CONTACT, userBean?.refContactNo)
        writableDatabase.insert(TABLE_USER, null, updateValues)
        var affected = writableDatabase.update(TABLE_USER, updateValues, null, null);
        Logger.d("No of rows affected " + affected)
        writableDatabase?.close()
        return affected
    }


    fun getUserData(): UserBean? {

        val selectQuery = "SELECT  * FROM " + TABLE_USER
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor == null || cursor.count == 0) {
            return null
        }
        val userBean = UserBean()
        cursor.moveToFirst()
        userBean.userName = cursor.getString(cursor.getColumnIndex(NAME))
        userBean.email = cursor.getString(cursor.getColumnIndex(EMAIL))
        userBean.mobileNo = cursor.getString(cursor.getColumnIndex(MOBILE))
        userBean.profileImagePath = cursor.getString(cursor.getColumnIndex(PROFILE_IMG_PATH))
        userBean.refContactNo = cursor.getString(cursor.getColumnIndex(REF_CONTACT))
        db?.close()
        return userBean
    }

    fun clearUserTable() {
        writableDatabase.delete(TABLE_USER, null, null) // we are deleting existing entries as we'll have only single user entry i this table
        writableDatabase.close()

    }
}