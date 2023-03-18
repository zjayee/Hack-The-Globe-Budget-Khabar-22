package com.example.myapplication

import FamilyMember
import android.widget.LinearLayout
import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup



class FamilyMemberInput(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    lateinit var nameEditText: EditText
    lateinit var ageEditText: EditText
    lateinit var sexRadioGroup: RadioGroup
    lateinit var allergiesEditText: EditText


    init{
        setupViews()
    }

    fun setupViews(){
        nameEditText = findViewById(R.id.member_name_textview)
        ageEditText = findViewById(R.id.member_age_textview)
        sexRadioGroup = findViewById(R.id.member_sex_radiogroup)
        allergiesEditText = findViewById(R.id.allergies_textview)
    }

    fun returnValues(): FamilyMember {
        val selectedSexid = sexRadioGroup.checkedRadioButtonId
        val selectedSexButton = findViewById<RadioButton>(selectedSexid)

        return FamilyMember(
            name = nameEditText.text.toString(),
            age = ageEditText.text.toString().toInt(),
            sex = selectedSexButton.text.toString(),
            allergies = allergiesEditText.text.toString()
        )
    }
}
