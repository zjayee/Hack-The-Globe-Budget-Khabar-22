package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NutritionalValueFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NutritionalValueFragment : Fragment() {

    lateinit var rootView: View

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
        rootView = inflater.inflate(R.layout.fragment_nutritional_value, container, false)

        val bananaCard = rootView.findViewById<View>(R.id.banana)
        val carrotCard = rootView.findViewById<View>(R.id.carrot)
        val eggCard = rootView.findViewById<View>(R.id.eggs)

        bananaCard.findViewById<TextView>(R.id.food_name_textview).text = "Banana"
        bananaCard.findViewById<TextView>(R.id.price_textview).text = "Price: ৳35"
        bananaCard.findViewById<TextView>(R.id.price_meal_textview).text = "Price/Meal: ৳8.75"
        bananaCard.findViewById<TextView>(R.id.rec_num_textview).text = "Rec #: 4"
        bananaCard.findViewById<CheckBox>(R.id.checkbox).visibility = View.GONE

        carrotCard.findViewById<TextView>(R.id.food_name_textview).text = "Carrot"
        carrotCard.findViewById<TextView>(R.id.price_textview).text = "Price: ৳17"
        carrotCard.findViewById<TextView>(R.id.price_meal_textview).text = "Price/Meal: ৳2.83"
        carrotCard.findViewById<TextView>(R.id.rec_num_textview).text = "Rec #: 2"
        carrotCard.findViewById<CheckBox>(R.id.checkbox).visibility = View.GONE

        eggCard.findViewById<TextView>(R.id.food_name_textview).text = "Eggs"
        eggCard.findViewById<TextView>(R.id.price_textview).text = "Price: ৳62"
        eggCard.findViewById<TextView>(R.id.price_meal_textview).text = "Price/Meal: ৳10.33"
        eggCard.findViewById<TextView>(R.id.rec_num_textview).text = "Rec #: 2"
        eggCard.findViewById<CheckBox>(R.id.checkbox).visibility = View.GONE

        return rootView
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment NutritionalValueFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            NutritionalValueFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}