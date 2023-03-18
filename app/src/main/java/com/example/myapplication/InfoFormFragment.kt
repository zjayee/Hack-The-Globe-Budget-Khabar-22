package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * A simple [Fragment] subclass.
 * Use the [InfoFormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InfoFormFragment : Fragment() {

    lateinit var rootview: View
    lateinit var familyMembersLinearLayout: LinearLayout
    lateinit var addMemberFab: FloatingActionButton
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
        rootview = inflater.inflate(R.layout.fragment_info_form, container, false)
        familyMembersLinearLayout = rootview.findViewById(R.id.family_members_linear_layout)
        addMemberFab = rootview.findViewById(R.id.add_member_button)
        nextFab = rootview.findViewById(R.id.next_button)
        return rootview
    }

    fun addMember(){

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment InfoFormFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InfoFormFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}