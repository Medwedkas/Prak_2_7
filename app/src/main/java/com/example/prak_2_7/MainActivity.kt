package com.example.prak_2_7

import android.os.Bundle
import android.text.Editable
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.prak_2_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    private lateinit var viewModel:MessageViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(bind.root)

        val provider = ViewModelProvider(this)
        viewModel = provider.get(MessageViewModel::class.java)
            val radioGroup = findViewById<RadioGroup>(R.id.radioioGrp)
            bind.button.setOnClickListener {
                val editTextCondition: Editable? = bind.editText.text
                val checkBoxCondition: String =  if (bind.checkBox.isChecked) "ON" else "OFF".toString()
                val toggleButtonCondition: String = if (bind.toggleButton.isChecked) "ON" else "OFF".toString()
                val radioGroupCondition = findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text
                viewModel.getAllState(editTextCondition, checkBoxCondition ,toggleButtonCondition, radioGroupCondition as String)
            }

            observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.msg.observe(this, Observer { bind.solution.text = it.toString() })
    }
}