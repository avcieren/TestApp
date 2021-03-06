package com.erenavci.testapplication.view

import android.app.Application
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erenavci.testapplication.R
import com.erenavci.testapplication.model.Device
import com.erenavci.testapplication.model.Model
import kotlinx.android.synthetic.main.fragment_second.view.*
import kotlinx.android.synthetic.main.list_row.view.*

class MyDevicesAdaptor (val devices:ArrayList<Device>): RecyclerView.Adapter<MyDevicesAdaptor.MyViewHolder>() {


    /*val deviceList: ArrayList<Model>*/
//val firstTest : TextView = ViefindViewById(R.id.textView1)
    class MyViewHolder( var view : View) : RecyclerView.ViewHolder(view){
           // val firstTest : TextView = view.findViewById(R.id.textView1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       when(devices[position].Platform){
           "Sercomm G450" -> holder.view.imageView1.setImageResource(R.drawable.vera_plus_big)
           "Sercomm G550" -> holder.view.imageView1.setImageResource(R.drawable.vera_secure_big)
           else -> holder.view.imageView1.setImageResource(R.drawable.vera_edge_big)
       }

       // holder.view.imageView2.setImageDrawable(getDrawable(holder.view.context,R.drawable.vera_plus_big))
       // Glide.with(holder.view.context)
           // .load(holder.view.context,R.drawable.vera_plus_big)
           // .into(holder.view.imageView1)

        holder.view.textView1.text = "Home Number ${position+1}"//devices[position].MacAddress
        holder.view.textView2.text= "SN: ${devices[position].PK_Device.toString()}"
        holder.itemView.setOnClickListener {
            val action= FirstFragmentDirections.actionFirstFragmentToSecondFragment(devices[position].PK_Device.toString(),devices[position].MacAddress.toString(),devices[position].Firmware.toString(),devices[position].Platform.toString(),holder.view.textView1.text.toString())
        Navigation.findNavController(it).navigate(action)}

    }


    override fun getItemCount(): Int {
        return devices.size //deviceList.get(1).Devices.size
    }

    fun updateDeviceList (newDeviceList:List<Device>)
    {
        devices.clear()
        devices.addAll(newDeviceList)
        notifyDataSetChanged()

    }
}