package org.sopt.androidsemina_week1.ui.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.androidsemina_week1.ui.home.HomeActivity
import org.sopt.androidsemina_week1.ui.home.ServiceCreator
import org.sopt.androidsemina_week1.data.RequestLoginData
import org.sopt.androidsemina_week1.data.ResponseLoginData
import org.sopt.androidsemina_week1.databinding.ActivitySigninBinding
import org.sopt.androidsemina_week1.ui.home.shortToast
import org.sopt.androidsemina_week1.ui.signup.SignUpActivity
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
            initAutoLogin()
            checkAutoLogin()
        }

        binding.signupBtn.setOnClickListener {
            Toast.makeText(this, "root, message", Toast.LENGTH_SHORT);
            startActivity(signupIntent)
        }

        setContentView(binding.root)
    }

    private fun checkAutoLogin() {
        shortToast("자동로그인 되었습니다.")
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun initAutoLogin() {
        binding.clAutoLogin.setOnClickListener {
            binding.ivCheck.isSelected = !binding.ivCheck.isSelected
        }
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