package com.erenavci.testapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.erenavci.testapplication.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        //return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

         arguments?.let{
             binding.textView3.text= SecondFragmentArgs.fromBundle(it).homeNum
             binding.textView4.text= "SN: ${SecondFragmentArgs.fromBundle(it).snID}"
             binding.textView5.text= "MAC Address: ${SecondFragmentArgs.fromBundle(it).macAdress}"
             binding.textView6.text= "Firmware: ${SecondFragmentArgs.fromBundle(it).firmware}"
             binding.textView7.text= "Platform: ${SecondFragmentArgs.fromBundle(it).model}"
         }

    }

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null

    }
}