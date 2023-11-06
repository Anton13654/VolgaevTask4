package com.aeincprojects.volgaevtask4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val messageFragment = MessageFragment()
        fragmentTransaction.replace(R.id.fragmentContainerView, messageFragment)
        fragmentTransaction.commit()
    }
}