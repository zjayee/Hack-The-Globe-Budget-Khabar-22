package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * A simple [Fragment] subclass.
 * Use the [FoodChoiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FoodChoiceFragment : Fragment() {

    lateinit var rootView: View

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
        rootView = inflater.inflate(R.layout.fragment_food_choice, container, false)
        nextFab = rootView.findViewById(R.id.next_button)

        nextFab.setOnClickListener {
            findNavController().navigate(R.id.action_foodChoiceFragment_to_nutritionalValueFragment)
        }

        return rootView
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @return A new instance of fragment FoodChoiceFragment.
//         */
//
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            FoodChoiceFragment().apply {
//                arguments = Bundle().apply {
//
//                }
//            }
//    }
}