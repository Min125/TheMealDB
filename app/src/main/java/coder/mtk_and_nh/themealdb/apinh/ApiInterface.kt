package coder.mtk_and_nh.themealdb.apinh

import coder.mtk_and_nh.themealdb.model.nhmodel.Alphabet
import coder.mtk_and_nh.themealdb.model.nhmodel.Detail
import coder.mtk_and_nh.themealdb.model.nhmodel.Meal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("search.php")
    fun getAzList(

        @Query("f")f:String
    ):Call<Meal>


    @GET("search.php")
    fun getAlphabet(

        @Query("f")f:String
    ):Call<Alphabet>


    @GET("lookup.php")
    fun getDetail(
        @Query("i")i:String
    ):Call<Detail>


}