package com.erenavci.testapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.erenavci.testapplication.R
import com.erenavci.testapplication.databinding.FragmentFirstBinding
import com.erenavci.testapplication.model.Device
import com.erenavci.testapplication.model.Model
import com.erenavci.testapplication.viewmodel.FirstFragmentViewModel
import kotlinx.android.synthetic.main.fragment_first.*
import retrofit2.Retrofit


class FirstFragment : Fragment() {
private lateinit var viewModel : FirstFragmentViewModel
private lateinit var recyclerViewAdaptor : MyDevicesAdaptor


private var _binding: FragmentFirstBinding? = null
   private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // val test = Model(ArrayList<Device>())
        recyclerViewAdaptor=MyDevicesAdaptor(arrayListOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    //return inflater.inflate(R.layout.fragment_first, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
           viewModel = ViewModelProviders.of(this).get(FirstFragmentViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(context)

        val dividerDecore = DividerItemDecoration(context,DividerItemDecoration.VERTICAL)
        dividerDecore.setDrawable(resources.getDrawable(R.drawable.recyclerview_divider))
        recyclerView.addItemDecoration(dividerDecore)

        recyclerView.adapter = recyclerViewAdaptor
       viewModel.getDataAPI()
         getObserveLiveData()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun getObserveLiveData(){

        viewModel.devices.observe(viewLifecycleOwner, Observer {devices ->
        devices?.let {
             recyclerViewAdaptor.updateDeviceList(it)
        }

        })
    }

}