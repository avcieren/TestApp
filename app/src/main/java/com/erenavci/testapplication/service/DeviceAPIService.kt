package com.erenavci.testapplication.service

import com.erenavci.testapplication.model.Device
import com.erenavci.testapplication.model.Model
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DeviceAPIService {

    private val BASE_URL ="https://veramobile.mios.com/"
    private val api = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(DeviceAPI::class.java)


    fun getData() : Call<List<Device>> {
        return api.getDeviceItems()
    }



}