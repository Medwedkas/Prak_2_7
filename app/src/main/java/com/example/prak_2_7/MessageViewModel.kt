package com.example.prak_2_7

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessageViewModel : ViewModel() {
    val msg: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun getAllState(EditText: Editable?, CheckBox: String, ToggleButton: String, RadioGroup: String): String {
        msg.value = "EditText :${EditText ?: ""}\n" +
                "CheckBox: ${CheckBox}\n" +
                "ToggleButton: ${ToggleButton}\n" +
                "RadioGroup: $RadioGroup"

        return msg.value.toString()
    }

}