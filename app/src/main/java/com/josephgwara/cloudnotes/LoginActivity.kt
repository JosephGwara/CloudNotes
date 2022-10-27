package com.josephgwara.cloudnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.josephgwara.cloudnotes.databinding.ActivityCreateAccountBinding
import com.josephgwara.cloudnotes.databinding.ActivityLoginBinding


private lateinit var binding: ActivityLoginBinding
private lateinit var firebaseAuth: FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()


        binding.loginBtn.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
//checking for empty fields
            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {

                        //Opening MAin screen when auth is successful
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)


                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
                            .show()

                    }

                }

            } else {
                Toast.makeText(this, "Fill in all fields", Toast.LENGTH_SHORT).show()
            }


        }
        binding.registerTextViewBtn.setOnClickListener {
            //taking the user to the register page if they don't have an account
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }
}