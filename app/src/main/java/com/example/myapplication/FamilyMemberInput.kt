package com.example.myapplication

import FamilyMember
import android.widget.LinearLayout
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
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
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.family_member_input, this, true)

        nameEditText = findViewById(R.id.member_name_edittext)
        ageEditText = findViewById(R.id.member_age_edittext)
        sexRadioGroup = findViewById(R.id.member_sex_radiogroup)
        allergiesEditText = findViewById(R.id.allergies_textview)
    }

//    fun onRadioButtonClicked(view: View) {
//        if (view is RadioButton) {
//            // Is the button now checked?
//            val checked = view.isChecked
//
//            // Check which radio button was clicked
//            when (view.getId()) {
//                R.id.radio_pirates ->
//                    if (checked) {
//                        // Pirates are the best
//                    }
//                R.id.radio_ninjas ->
//                    if (checked) {
//                        // Ninjas rule
//                    }
//            }
//        }
//    }

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
