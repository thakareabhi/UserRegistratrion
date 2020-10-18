package com.example.userregistratrion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import kotlinx.android.synthetic.main.activity_edit_given_text.*

class EditGivenText : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_given_text)
        var id= intent.getStringExtra("ID")

        var i=id.toInt()

        var name=MainActivity.named.get(i);
        var email=MainActivity.emaild.get(i);

        editName.setText(name)
        editEmail.setText(email)

        //MainActivity.named[i]="pablo"
        //MainActivity.emaild[i]="pablodada1231"
        buttondone.setOnClickListener {

            if (editName.text.toString().trim().isNotEmpty() ||
                editEmail.text.toString().trim().isNotBlank()) {
                val Name: String = editName.text.toString().trim();
                val email: String = editEmail.text.toString().trim();

                MainActivity.named[i]=Name
                MainActivity.emaild[i]=email
                val intent = Intent(this, ViewAll::class.java)
                startActivity(intent)
            }

        }



    }
    override fun onBackPressed() {
        val intent = Intent(this, ViewAll::class.java)
        startActivity(intent)
    }
}
