package com.erenavci.testapplication.service

import com.erenavci.testapplication.model.Device
import com.erenavci.testapplication.model.Model
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface DeviceAPI {

    //https://veramobile.mios.com/test_android/items.test

    @GET("test_android/items.test")
    fun getDeviceItems(): Call<List<Device>>
}