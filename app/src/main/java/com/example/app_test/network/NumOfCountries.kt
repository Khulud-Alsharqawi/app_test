package com.example.app_test.network


import com.squareup.moshi.Json
data class retravedata(val error :Boolean,
                       val msg:String ,
                       val data: List<NumberOfCountries>)
data class NumberOfCountries (
    @Json (name = "name") val cname: String,
    @Json(name = "flag") val flagSrcUrl: String
)