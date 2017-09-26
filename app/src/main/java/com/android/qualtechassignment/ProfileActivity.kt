package com.android.qualtechassignment

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import com.android.qualtechassignment.data.UserBean
import com.android.qualtechassignment.database.SqliteDbHelper
import com.android.qualtechassignment.utlities.ErrorMsg
import com.android.qualtechassignment.utlities.NavigationUtil
import com.android.qualtechassignment.utlities.Utility
import com.android.watchoveryou.utility.ErrorViewUtil
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_profile.*
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException

class ProfileActivity : BaseActivity() {
    private val SELECT_PICTURE_CAMERA = 1
    private val MY_PERMISSIONS_REQUEST_WRITE_TOEXTERNAL_STORAGE: Int = 1003
    private val MY_PERMISSIONS_REQUEST_READ_CONTACT: Int = 1002
    private var PICK_CONTACT_CODE: Int = 1001

    override fun setContent() {
        setContentView(R.layout.activity_profile)

    }

    override fun getToolBarTitle(): String {

        return Utility.getStringFromResource(R.string.title_profile)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchProfileDataAndPrepareUI()

        userProfileImageView.setOnClickListener {
            askForWriteToExternalStoragePermission()

        }

        refMobileEditTextProfile.setOnClickListener {
            checkForContactPermissionAndOpenPhoneBook()

        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_profile, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.getItemId() == R.id.action_edit) {

            if (item.title.equals("Edit")) {
                enableDisableFileds(true)
                item.setTitle("Update")
            } else {

                val userBean = UserBean(nameEditTextProfile.text.toString(), emailEditTextProfile.text.toString(), mobileEditTextProfile.text.toString(), imageUri.toString(), refMobileEditTextProfile.text.toString())
                val affetctedRows = SqliteDbHelper.getInstance()?.updateData(userBean)
                if (affetctedRows != -1) {
                    ErrorViewUtil.showToast(this, ErrorMsg.Profile_update_success)
                }
            }


            enableDisableFileds(true)

        }

        if (item?.getItemId() == R.id.action_logout) {
            NavigationUtil.openProfileActivity(this)

        }
        return super.onOptionsItemSelected(item)


    }

    private var imageUri: Uri? = null


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {

            PICK_CONTACT_CODE -> {
                if (data == null) {
                    return
                }

                val contactData = data?.getData()
                val c = getContentResolver().query(contactData, null, null, null, null)
                if (c.moveToFirst()) {
                    val id = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID))

                    val hasPhone = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))

                    if (hasPhone.equals("1", ignoreCase = true)) {
                        val phones = contentResolver.query(
                                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null)
                        phones!!.moveToFirst()
                        var phn_no = phones.getString(phones.getColumnIndex("data1"))
                        if (TextUtils.isEmpty(phones.toString())) {
                            ErrorViewUtil.showErrorDialog(this@ProfileActivity, ErrorMsg.ERROR_TITLE, ErrorMsg.PHONE_NO_NOT_AVAILABLE)
                        } else {
                            refMobileEditTextProfile.setText(phn_no)
                        }
                    }
                }


            }

            SELECT_PICTURE_CAMERA -> {

                if (resultCode == Activity.RESULT_OK) {
                    if (data == null) {
                        return;
                    }
                    try {
                        var bitmap: Bitmap = data.extras.get("data") as Bitmap
                        imageUri = getImageUri(this, bitmap!!)
                        userProfileImageView.setImageURI(imageUri)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            MY_PERMISSIONS_REQUEST_WRITE_TOEXTERNAL_STORAGE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera()
                } else {
                    ErrorViewUtil.showErrorDialog(this@ProfileActivity, "Permission Required", "This permission is required for changing your profile pic",
                            object : DialogInterface.OnClickListener {
                                override fun onClick(p0: DialogInterface?, p1: Int) {
                                    p0?.dismiss()
                                }

                            })

                }
            }

            MY_PERMISSIONS_REQUEST_READ_CONTACT -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openPhoneBook()
                } else {
                    ErrorViewUtil.showErrorDialog(this@ProfileActivity, "Permission Required", "This permission is required for changing your profile pic",
                            object : DialogInterface.OnClickListener {
                                override fun onClick(p0: DialogInterface?, p1: Int) {
                                    p0?.dismiss()
                                }

                            })

                }
            }
        }


        return
    }

    private fun fetchProfileDataAndPrepareUI() {

        val userData = SqliteDbHelper.getInstance()?.getUserData()
        nameEditTextProfile.setText(userData?.userName)
        emailEditTextProfile.setText(userData?.email)
        mobileEditTextProfile.setText(userData?.mobileNo)

        if (!TextUtils.isEmpty(userData?.profileImagePath)) {
            userProfileImageView.setImageURI(Uri.parse(userData?.profileImagePath))
        }
        enableDisableFileds(false)
    }

    private fun enableDisableFileds(isEnabled: Boolean) {
        nameEditTextProfile.isEnabled = isEnabled
        emailEditTextProfile.isEnabled = isEnabled
        mobileEditTextProfile.isEnabled = isEnabled
        refMobileEditTextProfile.isClickable = isEnabled
        refMobileEditTextProfile.isFocusableInTouchMode = true
    }

    private fun askForWriteToExternalStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE), MY_PERMISSIONS_REQUEST_WRITE_TOEXTERNAL_STORAGE)
            return
        } else {
            openCamera()
        }

    }

    fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(takePictureIntent, SELECT_PICTURE_CAMERA)


    }


    fun getImageUri(inContext: Context, inImage: Bitmap): Uri {
        var bytes: ByteArrayOutputStream = ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        var path: String = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }


    fun checkForContactPermissionAndOpenPhoneBook() {
        if (ContextCompat.checkSelfPermission(this@ProfileActivity, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@ProfileActivity, arrayOf<String>(Manifest.permission.READ_CONTACTS), MY_PERMISSIONS_REQUEST_READ_CONTACT)

        } else {
            openPhoneBook()
        }

    }

    fun openPhoneBook() {

        val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        startActivityForResult(intent, PICK_CONTACT_CODE)

    }


}
