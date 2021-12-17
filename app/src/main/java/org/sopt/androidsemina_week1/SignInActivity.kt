package org.sopt.androidsemina_week1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.androidsemina_week1.databinding.ActivitySigninBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySigninBinding.inflate(layoutInflater)

        val signupIntent = Intent(this, SignUpActivity::class.java)
        val homeIntent = Intent(this, HomeActivity::class.java)

        binding.longinBtn.setOnClickListener {
            initNetwork()
        }

        binding.signupBtn.setOnClickListener {
            Toast.makeText(this, "root, message", Toast.LENGTH_SHORT);
            startActivity(signupIntent)
        }

        setContentView(binding.root)
    }

    private fun initNetwork() {
        val requestLoginData = RequestLoginData(
            binding.idEditText.text.toString(),
            binding.pwEditText.text.toString()
        )
        val call : Call<ResponseLoginData> = ServiceCreator.sampleService.postLogin(requestLoginData)
        call.enqueue(object : Callback<ResponseLoginData>{
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if(response.isSuccessful) {
                    val data = response.body()?.data

                    Toast.makeText(this@SignInActivity,"${response.body()?.data?.name}님 환영합니다", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java ))
                } else
                    Toast.makeText(this@SignInActivity, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }
}