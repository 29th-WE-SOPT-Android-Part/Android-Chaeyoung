package org.sopt.androidsemina_week1

import android.content.Context
import android.widget.Toast

// cotext 확장
fun Context.shortToast(message : String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    // 이미 상속받아서 this를 쓸 수 있음.

    // mainActivity에 가서 어떻게 쓰냐...
    // shortToast("텍스트") 쓰면 됨.
}