package coder.mtk_and_nh.themealdb.api

import coder.mtk_and_nh.themealdb.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("categories.php")
    fun getCategories () : Call<Categories>

    @GET("random.php")
    fun getRandomMeal (): Call <Random>

    @GET("list.php")
    fun getCountryList (
        @Query("a") list : String = "list"
    ): Call<Country>

    @GET("filter.php")
    fun getAreaFilter (
        @Query("a") country: String
    ) : Call<Area>

    @GET("list.php")
    fun getIngredientList (
        @Query("i") list : String = "list"
    ): Call<Ingredient>

    @GET("filter.php")
    fun getIngredientFilter (
        @Query("i") ingredient : String
    ) : Call <IngredientFilter>

    @GET("filter.php")
    fun getCategroyFilter (
        @Query("c") category : String
    ) : Call <CategoryFilter>
}