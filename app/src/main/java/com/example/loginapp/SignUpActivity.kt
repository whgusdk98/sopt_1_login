package com.example.loginapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signin.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var getName: EditText
    private lateinit var getId: EditText
    private lateinit var getPassword: EditText
    private lateinit var getPwCheck: EditText
    private lateinit var signup: Button
    private val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        getName = findViewById(R.id.edtName)
        getId = findViewById(R.id.edtId)
        getPassword = findViewById(R.id.edtPassword)
        getPwCheck = findViewById(R.id.editPwCheck)
        signup = findViewById(R.id.btnSignUp)


        signup.setOnClickListener {
            val id = getId.text.toString()
            val name = getName.text.toString()
            val pw = getPassword.text.toString()
            val pwCheck = getPwCheck.text.toString()


            if(id.isEmpty() || name.isEmpty() || pw.isEmpty() || pwCheck.isEmpty()){
                Toast.makeText(this,"빠짐없이 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val response = requestLogin(id,name,pw,pwCheck)
            if(response){
                if(pw != pwCheck){
                    Toast.makeText(this,"비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                else {
                    val intent = Intent()
                    intent.putExtra("id",id)
                    intent.putExtra("pw", pw)
                    setResult(Activity.RESULT_OK,intent)
                    finish()
                }
            }
        }
    }


    private fun requestLogin(id: String,name: String , pw: String, pwCheck: String): Boolean {
        return true
    }
}
