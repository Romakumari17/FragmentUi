package com.romakumari.fragmentui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.romakumari.fragmentui.databinding.FragmentSignInBinding
import com.romakumari.fragmentui.databinding.FragmentSignUpBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var fragmentSignUpBinding: FragmentSignUpBinding
    lateinit var mainActivity:MainActivity
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        fragmentSignUpBinding= FragmentSignUpBinding.inflate(inflater, container, false)
        return fragmentSignUpBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSignUpBinding.tvsignIn.setOnClickListener {
            findNavController().navigate(R.id.signInFragment)
        }
        fragmentSignUpBinding.Csignupbtn.setOnClickListener {
            if (fragmentSignUpBinding.etname.text.toString().isNullOrEmpty()) {
                fragmentSignUpBinding.etname.error = ("name")
            } else if (fragmentSignUpBinding.etemail.text.toString().isNullOrEmpty()) {
                fragmentSignUpBinding.etemail.error = "enter Your Email "
            } else if (fragmentSignUpBinding.etpassword.text.toString().isNullOrEmpty()) {
                fragmentSignUpBinding.etpassword.error = "enter Your password "
            } else if (fragmentSignUpBinding.etconfirmpassword.text.toString().isNullOrEmpty()) {
                fragmentSignUpBinding.etconfirmpassword.error = "enter Your password again "
            }  else if (fragmentSignUpBinding.etpassword.text.toString() != fragmentSignUpBinding.etconfirmpassword.text.toString()) {
                Toast.makeText(mainActivity, "Passwords are not matched", Toast.LENGTH_SHORT).show()
            } else {
                val bundle = Bundle()
                bundle.putString("name",  fragmentSignUpBinding.etname.text.toString())
                bundle.putString("email",fragmentSignUpBinding.etemail.text.toString())
                findNavController().navigate(R.id.homeFragment,bundle)
            }

        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignUpFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUpFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}