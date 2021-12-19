package org.sopt.androidsemina_week1.ui.home

import org.sopt.androidsemina_week1.data.RequestLoginData
import org.sopt.androidsemina_week1.data.ResponseLoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SampleService {
    @Headers("Content-Type:application/json")
    @POST("user/login")
    fun postLogin(
        @Body body : RequestLoginData
    ) : Call<ResponseLoginData>
}