package com.romakumari.fragmentui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.romakumari.fragmentui.databinding.FragmentFitnessBinding
import com.romakumari.fragmentui.databinding.FragmentSignInBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignInFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var fragmentSignInBinding: FragmentSignInBinding
    lateinit var mainActivity: MainActivity
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
       fragmentSignInBinding = FragmentSignInBinding.inflate(inflater, container, false)
        return fragmentSignInBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSignInBinding.tvsignup.setOnClickListener{
            findNavController().navigate(R.id.signUpFragment)
        }
        fragmentSignInBinding.hbtnsignin.setOnClickListener {
            if (fragmentSignInBinding.etemail.text.toString().isNullOrEmpty()) {
                fragmentSignInBinding.etemail.error = "enter Your Email "
            } else if (fragmentSignInBinding.etpassword.text.toString().isNullOrEmpty()) {
                fragmentSignInBinding.etpassword.error = "enter Your password "
            }else {
                val bundle = Bundle()
                bundle.putString("email",fragmentSignInBinding.etemail.text.toString())
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
         * @return A new instance of fragment SignInFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignInFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}