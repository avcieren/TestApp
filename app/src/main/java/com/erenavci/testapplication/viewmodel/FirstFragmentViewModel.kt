package com.erenavci.testapplication.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erenavci.testapplication.model.Device
import com.erenavci.testapplication.model.Model
import com.erenavci.testapplication.service.DeviceAPIService
import com.erenavci.testapplication.view.FirstFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.coroutineContext

class FirstFragmentViewModel: ViewModel() {
    private   val TAG = "API_RESPONSE"
    private val deviceApiService = DeviceAPIService()
    private val disposable = CompositeDisposable()
    val devices = MutableLiveData <List<Device>>()
   //val devices =  List<Model>()
    fun refreshData() {
       /* val device = Device("firm","ip","lap","mcAd",10,
            1,2,3,"test",
            "str","devc","event")
        val device1 = Device("firm1","ip1","lap1","mcAd1",10,
            11,21,31,"test",
            "str","devc","event")
        val device2 = Device("firm2","ip2","lap2","mcAd2",10,
            12,22,32,"test2",
            "str","devc","event")
        val device5 = Device("firm2","ip2","lap2","mcAd2",10,
            12,22,32,"test2",
            "str","devc","event")
        val device6 = Device("firm2","ip2","lap2","mcAd2",10,
            12,22,32,"test2",
            "str","devc","event")
        val devices3 =  arrayListOf<Device>(device,device1,device2,device5,device6)
        devices.value = devices3*/
    }
    fun getDataAPI(){
        val call =deviceApiService.getData()  
        call.enqueue(object : Callback<Model>{
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
               val body = response?.body()
             val devices1 =   body?.Devices
                devices.value= devices1!!
                Log.d(TAG, "onResponse: ${devices1}")
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                println("eren onFailure")

                Log.d(TAG, "onFailure: Hata alindi")
            }

        }
           )
       /*disposable.add(deviceApiService.getData()
           .subscribeOn(Schedulers.newThread())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribeWith(object: DisposableSingleObserver<List<Model>>(){
               override fun onSuccess(t: List<Model> ) {
                   devices.value=t
                
                
               }

               override fun onError(e: Throwable) {
                //   Toast.makeText(context,"Error var aga",Toast.LENGTH_LONG).show()
               }

           }))*/


    }
}