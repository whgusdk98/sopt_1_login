package com.example.loginapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signin.*

class SignInActivity : AppCompatActivity() {

    private lateinit var getId: EditText
    private lateinit var getPassword: EditText
    private lateinit var signup: Button
    private lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)


        getId = findViewById(R.id.edtId)
        getPassword = findViewById(R.id.edtPassword)
        signup = findViewById(R.id.btnSignup)
        login = findViewById(R.id.btnLogin)

        signup.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, 1)
        }

        login.setOnClickListener {
            val id = getId.text.toString()
            val pw = getPassword.text.toString()

            if(id.isEmpty() || pw.isEmpty()){
                Toast.makeText(this,"아이디나 비밀번호를 입력해주세요.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val response = requestLogin(id,pw)
                if(response){
                    val intent = Intent(this, SignUpActivity::class.java) //로그인되면 어떤 액티비티로 가야하는지
                    Toast.makeText(this,"로그인이 성공적으로 진행되었습니다.",Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                edtId.setText(data?.getStringExtra("id").toString())
                edtPassword.setText(data?.getStringExtra("pw").toString())
            }
        }
    }

    private fun requestLogin(id: String, pw: String): Boolean {
        return true
    }
}
