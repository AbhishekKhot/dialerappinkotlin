package com.example.phone

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_dialer.*
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest


class DialerActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialer)

        Dexter.withContext(this)
            .withPermission(android.Manifest.permission.CALL_PHONE)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse) {

                }

                override fun onPermissionDenied(response: PermissionDeniedResponse) {

                }

                override fun onPermissionRationaleShouldBeShown(p0: PermissionRequest?, p1: PermissionToken?,) {

                }

            }).check()


        Button_zero.setOnClickListener {
            val no=TextViewPhone.text.toString()
            TextViewPhone.text = "${no}0"
        }
        Button_one.setOnClickListener {
            val no=TextViewPhone.text.toString()
            TextViewPhone.text = "${no}1"
        }
        Button_two.setOnClickListener {
            val no=TextViewPhone.text.toString()
            TextViewPhone.text = "${no}2"
        }
        Button_three.setOnClickListener {
            val no=TextViewPhone.text.toString()
            TextViewPhone.text = "${no}3"
        }
        Button_four.setOnClickListener {
            val no=TextViewPhone.text.toString()
            TextViewPhone.text = "${no}4"
        }
        Button_five.setOnClickListener {
            val no=TextViewPhone.text.toString()
            TextViewPhone.text = "${no}5"
        }
        Button_six.setOnClickListener {
            val no=TextViewPhone.text.toString()
            TextViewPhone.text = "${no}6"
        }
        Button_seven.setOnClickListener {
            val no=TextViewPhone.text.toString()
            TextViewPhone.text = "${no}7"
        }
        Button_eight.setOnClickListener {
            val no=TextViewPhone.text.toString()
            TextViewPhone.text = "${no}8"
        }
        Button_nine.setOnClickListener {
            val no=TextViewPhone.text.toString()
            TextViewPhone.text = "${no}9"
        }
        Button_star.setOnClickListener {
            val no=TextViewPhone.text.toString()
            TextViewPhone.text = "${no}*"
        }
        Button_hash.setOnClickListener {
            val no=TextViewPhone.text.toString()
            TextViewPhone.text = "${no}#"
        }

        Button_Call.setOnClickListener {
            setupCall()
        }
        ImageView_cancel.setOnClickListener{
            val StringBuilder = StringBuffer(TextViewPhone.text.toString())
            StringBuilder.deleteCharAt(TextViewPhone.text.length-1)
            TextViewPhone.text = StringBuilder.toString()
        }
    }

    private fun setupCall() {
        val phoneNumber = TextViewPhone.text.toString()
        val dial = "tel:$phoneNumber"

//            if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
//                return
//            }
//            val callIntent: Intent = Uri.parse(dial).let { number ->
//                Intent(Intent.ACTION_DIAL, number)
//            }
//            startActivity(callIntent)

       startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial)))
    }
}
