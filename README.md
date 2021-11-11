# Android-Chaeyoung
![github_심채영_ver1-20](https://user-images.githubusercontent.com/70698151/135754368-dd561815-3fc3-4a74-9586-0167392937d5.png)


### week1

- 필수과제
1. Sopthub 로그인 페이지 만들기
2. Sopthub 회원가입 페이지 만들기
3. Sopthub 자기소개 페이지 만들기


#### 전체 화면 구성
|로그인|회원가입|자기소개|
|---|---|---|
|![image](https://user-images.githubusercontent.com/62435316/136698162-4cdaf717-40bb-4674-9efa-4ad61e6ca93d.png)|![image](https://user-images.githubusercontent.com/62435316/136698211-583318a4-0d8c-4fb2-902e-24f5819c28d2.png)|![image](https://user-images.githubusercontent.com/62435316/136698217-4aec7a94-6a8c-4779-9e08-1293e1e46b03.png)|


|이미지|설명|
|:-:|-----|
|<img src="https://user-images.githubusercontent.com/62435316/136698443-9f9cd0b6-ddde-492e-ad7d-4687f2252b89.png"  width="50%" height="50%"/>|아이디와 비밀번호 중 하나라도 입력되지 않아도 "로그인 실패" 토스트 메시지 띄우기|
|<img src="https://user-images.githubusercontent.com/62435316/136698486-8da5fe38-1782-4ea6-ab3c-ea288f2ab48c.png" width="50%" height="50%"/>|아이디와 비밀번호를 모두 입력하면 자기소개 페이지로 이동|
|<img src="https://user-images.githubusercontent.com/62435316/136698519-f9a13aae-c7e7-4d2b-be8b-50336bfe1bf8.png" width="50%" height="50%"/>|회원가입 버튼을 누를 시 회원가입 페이지로 이동|
|<img src="https://user-images.githubusercontent.com/62435316/136698531-458b376c-88c6-43ac-accb-6dfb42d88ab2.png" width="50%" height="50%"/>|하나라도 입력되지 않아도 "입력되지 않은 정보가 있습니다" 토스트 메시지 띄우기|
|<img src="https://user-images.githubusercontent.com/62435316/136698560-a6c68b83-6156-40ad-8416-d36ccccf72e5.png" width="50%" height="50%"/>|모든 정보가 입력되었을 경우 "회원가입 성공" 토스트 메시지 띄우기|



### week2

- 필수 과제

1. 자기소개 페이지에서 FollowerRecyclerView, RepositoryRecyclerView 만들기
2. 하나의 RecyclerView는 Grid Layout으로 만들기



자기소개 페이지


|이미지|설명|
|:-:|-----|
|<img src="https://user-images.githubusercontent.com/62435316/138473996-aba90e18-3c8f-428a-af5e-159ef78c8289.jpg"  width="50%" height="50%"/>|- FollowerRecyclerView : LinearLayout으로 뷰|
|<img src="https://user-images.githubusercontent.com/62435316/138474041-6fefb820-4aed-4e88-8159-008303602d4f.jpg"  width="50%" height="50%"/>|- RepositoryRecyclerView : GridLayout으로 뷰|


### week3

- 필수 과제
1. 로그인 화면
![로그인](https://user-images.githubusercontent.com/62435316/141349147-1808c90b-c0e7-43ee-a7a7-b0fd36c1c70c.gif)
2. 회원가입 화면
![회원가입](https://user-images.githubusercontent.com/62435316/141349935-32e2b307-88ef-4b5f-bad9-1163ef3f3d1a.gif)
3. ProfileFragment.kt!
![프로필](https://user-images.githubusercontent.com/62435316/141350063-05f5f9f0-4d07-4d3d-9bc6-c04afadb5224.gif)


### week4

- 필수 과제
- ![서버통신](https://user-images.githubusercontent.com/62435316/141350231-66056889-7fbf-4bd1-82a0-7e305ed96ea2.gif)

1. POSTMAN 테스트
  - 회원가입 완료
![회원가입](https://user-images.githubusercontent.com/62435316/141344198-5dd79eb9-b210-46f4-8a0a-d5233dccc7db.JPG)
  - 로그인 완료
![로그인](https://user-images.githubusercontent.com/62435316/141344242-bc1e61a2-2144-492a-8044-798304265297.JPG)

2. retrofit interface와 구현체, Requset/Response 객체에  대한 코드

  - retrofit interface : SampleService.kt

  ```kotlin
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
  ```
  
  - retrofit 구현체 : ServiceCreator.kr

  ```kotlin
  import retrofit2.Retrofit
  import retrofit2.converter.gson.GsonConverterFactory

  object ServiceCreator {
    private const val BASE_URL = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"

    private val retrofit : Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val sampleService: SampleService = retrofit.create(SampleService::class.java)
  }
  ```
  
  - Request : RequestLoginData.kt

  ```Kotlin
  import com.google.gson.annotations.SerializedName

  data class RequestLoginData(
      @SerializedName("email")
      val email : String,
      val password : String
  )
  ```
  
  - Response : ResponseLoginData.kr
  
  ```Kotlin
  data class ResponseLoginData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Data
  ) {
    data class Data(
        val id : Int,
        val name : String,
        val email : String
    )
  }
  ```
