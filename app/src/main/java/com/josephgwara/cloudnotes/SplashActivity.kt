package com.josephgwara.cloudnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth


private lateinit var firebaseAuth: FirebaseAuth

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

            firebaseAuth = FirebaseAuth.getInstance()

            if(firebaseAuth.currentUser == null){
                Handler().postDelayed({
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }, 1200)

            }
        else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

        }



    }


    }
