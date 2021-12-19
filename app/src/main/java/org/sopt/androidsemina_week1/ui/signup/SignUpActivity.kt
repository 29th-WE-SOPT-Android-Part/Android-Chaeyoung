package org.sopt.androidsemina_week1.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidsemina_week1.ui.home.HomeActivity
import org.sopt.androidsemina_week1.databinding.ActivityHomeBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        val signupIntent = Intent(this, HomeActivity::class.java)
        val homeIntent = Intent(this, SignUpActivity::class.java)

        binding.signUpbtn.setOnClickListener {
            val id_str = binding.idEt.getText().toString();
            val name_str = binding.nameEt.getText().toString();
            val pw_str = binding.pwEt.getText().toString();
            if(!name_str.isEmpty() && !id_str.isEmpty() && !pw_str.isEmpty()){
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                finish();
            }
            else{
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show();
            }
        }
        setContentView(binding.root)
    }
}