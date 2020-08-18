package coder.mtk_and_nh.themealdb.apinh

import coder.mtk_and_nh.themealdb.model.nhmodel.Alphabet
import coder.mtk_and_nh.themealdb.model.nhmodel.Detail
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    val apiInterface : ApiInterface

    init {

        var retrofit:Retrofit
        retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        apiInterface=retrofit.create(ApiInterface::class.java)
    }


    fun getAlphabet(f:String):Call<Alphabet>{

        return apiInterface.getAlphabet(f)
    }

    fun getDetail(i:String):Call<Detail>{

        return apiInterface.getDetail(i)
    }
}