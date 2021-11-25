package com.example.app_test.network


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//Add the constant for the base URL for the web service.
const val BASE_URL="https://countriesnow.space"

private val moshi =Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
// add a Retrofit builder to build and create a Retrofit object.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
// interface that defines how Retrofit talks to the web server using HTTP requests.
interface ApiService{
    // add a function called getPhotos() to get the response string from the web service.
//Use the @GET annotation to tell Retrofit that this is GET request and specify endpoint, for that web service method.
    @GET("/api/v0.1/countries/flag/images") // endpoint -> http://fghjkl.fghj-hdgfsd-../photos
//make fun a suspend,So that you can call this method from within a coroutine.

    suspend fun getImag():retravedata

}
// define a public object called MarsApi to initialize the Retrofit service.
object countriseApi {
    //add a lazily initialized retrofit object property.WHY??  to make sure it is initialized at its first usage
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
        //Initialize the retrofitService variable using the retrofit.create() method with the MarsApiService interface.
    }
}