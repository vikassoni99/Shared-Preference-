package com.example.sharedpreferenceex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref=PreferenceManager.getDefaultSharedPreferences(this)
        pref.apply {
            val name =getString("NAME","")
            val email=getString("EMAIL","")
            editName.setText(name)
            editEmail.setText(email)

        }
    }

    fun saveData(){
        val pref =PreferenceManager.getDefaultSharedPreferences(this)
        val editor=pref.edit()

        editor
            .putString("NAME",editName.text.toString())
            .putString("EMAIL",editName.text.toString())
            .apply()

        val toast =Toast.makeText(this,"Saved",Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP,0,160)
        toast.show()

    }
}
