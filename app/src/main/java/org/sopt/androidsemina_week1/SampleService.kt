package org.sopt.androidsemina_week1

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