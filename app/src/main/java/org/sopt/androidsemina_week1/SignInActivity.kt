package org.sopt.androidsemina_week1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidsemina_week1.databinding.ActivitySigninBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySigninBinding.inflate(layoutInflater)

        val signupIntent = Intent(this, SignUpActivity::class.java)
        val homeIntent = Intent(this, HomeActivity::class.java)

        binding.longin.setOnClickListener {
            val id_str = binding.editTextId.getText().toString();
            val pw_str = binding.editTextPw.getText().toString();
            if(id_str.isEmpty() || pw_str.isEmpty()){
                Toast.makeText(this, "로그인실패", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, id_str.plus("님 환영합니다"), Toast.LENGTH_SHORT).show();
                startActivity(homeIntent)
            }
        }

        binding.signup.setOnClickListener {
            Toast.makeText(this, "root, message", Toast.LENGTH_SHORT);
            startActivity(signupIntent)
        }

        setContentView(binding.root)
    }
}