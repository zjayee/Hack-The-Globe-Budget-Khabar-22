package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * A simple [Fragment] subclass.
 * Use the [StartPlanFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartPlanFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    lateinit var rootview: View
    lateinit var budgetEditText: EditText
    lateinit var numMealsEditText: EditText
    lateinit var membersLinearLayout: LinearLayout
    lateinit var nextFab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_start_plan, container, false)
        budgetEditText = rootview.findViewById(R.id.budget_edittext)
        numMealsEditText = rootview.findViewById(R.id.num_meals_edittext)
        membersLinearLayout = rootview.findViewById(R.id.member_checkbox_linear_layout)
        nextFab = rootview.findViewById(R.id.next_button)

        //add checkboxes for each family member
        val members = viewModel.familyMemberArrayList
        for (i in 0 until members.size){
            val checkBox = CheckBox(context)
            checkBox.text = members[i].name
            membersLinearLayout.addView(checkBox)
        }

        nextFab.setOnClickListener {
            //TODO: save
            findNavController().navigate(R.id.action_startPlanFragment_to_foodChoiceFragment)
        }

        return rootview
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @return A new instance of fragment StartPlanFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            StartPlanFragment().apply {
//                arguments = Bundle().apply {
//
//                }
//            }
//    }
}