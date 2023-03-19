package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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

        val bananaCard = rootView.findViewById<View>(R.id.banana)
        val pineappleCard = rootView.findViewById<View>(R.id.pineapple)
        val carrotCard = rootView.findViewById<View>(R.id.carrot)
        val tomatoCard = rootView.findViewById<View>(R.id.tomato)
        val cabbageCard = rootView.findViewById<View>(R.id.cabbage)
        val eggCard = rootView.findViewById<View>(R.id.eggs)

        bananaCard.findViewById<TextView>(R.id.food_name_textview).text = "Banana"
        bananaCard.findViewById<TextView>(R.id.price_textview).text = "Price: ৳35"
        bananaCard.findViewById<TextView>(R.id.price_meal_textview).text = "Price/Meal: ৳8.75"
        bananaCard.findViewById<TextView>(R.id.rec_num_textview).text = "Rec #: 4"

        pineappleCard.findViewById<TextView>(R.id.food_name_textview).text = "Pineapple"
        pineappleCard.findViewById<TextView>(R.id.price_textview).text = "Price: ৳53"
        pineappleCard.findViewById<TextView>(R.id.price_meal_textview).text = "Price/Meal: ৳13.25"
        pineappleCard.findViewById<TextView>(R.id.rec_num_textview).text = "Rec #: 4"

        carrotCard.findViewById<TextView>(R.id.food_name_textview).text = "Carrot"
        carrotCard.findViewById<TextView>(R.id.price_textview).text = "Price: ৳17"
        carrotCard.findViewById<TextView>(R.id.price_meal_textview).text = "Price/Meal: ৳2.83"
        carrotCard.findViewById<TextView>(R.id.rec_num_textview).text = "Rec #: 2"

        tomatoCard.findViewById<TextView>(R.id.food_name_textview).text = "Tomato"
        tomatoCard.findViewById<TextView>(R.id.price_textview).text = "Price: ৳17"
        tomatoCard.findViewById<TextView>(R.id.price_meal_textview).text = "Price/Meal: ৳4.25"
        tomatoCard.findViewById<TextView>(R.id.rec_num_textview).text = "Rec #: 4"

        cabbageCard.findViewById<TextView>(R.id.food_name_textview).text = "Cabbage"
        cabbageCard.findViewById<TextView>(R.id.price_textview).text = "Price: ৳35"
        cabbageCard.findViewById<TextView>(R.id.price_meal_textview).text = "Price/Meal: ৳17.5"
        cabbageCard.findViewById<TextView>(R.id.rec_num_textview).text = "Rec #: 8"

        eggCard.findViewById<TextView>(R.id.food_name_textview).text = "Eggs"
        eggCard.findViewById<TextView>(R.id.price_textview).text = "Price: ৳62"
        eggCard.findViewById<TextView>(R.id.price_meal_textview).text = "Price/Meal: ৳10.33"
        eggCard.findViewById<TextView>(R.id.rec_num_textview).text = "Rec #: 2"

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