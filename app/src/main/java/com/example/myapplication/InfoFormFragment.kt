package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [InfoFormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InfoFormFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

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
        addMember()

        addMemberFab.setOnClickListener{
            addMember()
        }

        nextFab.setOnClickListener{
            saveMembers()
            findNavController().navigate(R.id.action_infoFormFragment_to_dashboardFragment)
        }

        return rootview
    }

    fun addMember(){
        val memberCard = FamilyMemberInput(context, null)
        familyMembersLinearLayout.addView(memberCard)
    }

    fun saveMembers(){
        for (i in 0 until familyMembersLinearLayout.childCount){
            val member = familyMembersLinearLayout.getChildAt(i) as FamilyMemberInput
            viewModel.familyMemberArrayList.add(member.returnValues())
        }
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