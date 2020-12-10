package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var nickNameEditText: EditText;
    lateinit var nicknameTextView: TextView;
    lateinit var doneButton: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nickNameEditText = findViewById(R.id.nickname_edit);
        nicknameTextView = findViewById(R.id.nickname_text);
        doneButton = findViewById(R.id.done_button);

        doneButton.setOnClickListener { addNickname() };
        nicknameTextView.setOnClickListener { updateNickname() };
    }

    private fun addNickname() {
        nicknameTextView.text = nickNameEditText.text;
        nickNameEditText.visibility = View.GONE;
        doneButton.visibility = View.GONE;
        nicknameTextView.visibility = View.VISIBLE;

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager;
        inputMethodManager.hideSoftInputFromWindow(nicknameTextView.windowToken, 0);
    }

    private fun updateNickname () {
        nicknameTextView.visibility = View.GONE;
        doneButton.visibility = View.VISIBLE;
        nickNameEditText.visibility = View.VISIBLE;
        nickNameEditText.requestFocus();

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nickNameEditText, 0)


    }
}