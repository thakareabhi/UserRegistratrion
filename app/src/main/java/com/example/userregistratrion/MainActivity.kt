package com.example.userregistratrion

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        public var named = ArrayList<String>()
        public var emaild= ArrayList<String>()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference


        button.setOnClickListener {

            if (editText1.text.toString().trim().isNotEmpty() ||
                editText2.text.toString().trim().isNotBlank())
            {
                val Name:String=editText1.text.toString().trim();
                val email:String=editText2.text.toString().trim();

                named.add(Name)
                emaild.add(email)

                Toast.makeText(applicationContext, "Data Added", Toast.LENGTH_SHORT).show()
                /*val base:String=email.replace("@","")
                val base1:String=base.replace(".","")

                val demoRef: DatabaseReference = rootRef.child("Record").child(base1)


                demoRef.child("Name").setValue(Name)
                demoRef.child("Email").setValue(email)*/

            }
            else
            {
                Toast.makeText(applicationContext, "Enter Data First", Toast.LENGTH_SHORT).show()
            }
        }
        button1.setOnClickListener {
            val intent = Intent(this, ViewAll::class.java)
            startActivity(intent)
        }


    }

    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}
