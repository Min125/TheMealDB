package coder.mtk_and_nh.themealdb.api

import coder.mtk_and_nh.themealdb.model.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    private val apiInterface : ApiInterface

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getCategoryList () : Call<Categories>{
        return apiInterface.getCategories()
    }

    fun getRandomMeal (): Call<Random> {
        return apiInterface.getRandomMeal()
    }

    fun getCountryList ():Call<Country>{
        return  apiInterface.getCountryList()
    }

    fun getAreaFilter(area : String):Call<Area>{
        return apiInterface.getAreaFilter(area)
    }

    fun getIngredientList ():Call<Ingredient>{
        return  apiInterface.getIngredientList()
    }

    fun getIngredientFilter (ingredient : String) : Call<IngredientFilter>{
        return apiInterface.getIngredientFilter(ingredient)
    }

    fun getCategoryFilter (category : String) : Call <CategoryFilter>{
        return apiInterface.getCategroyFilter(category)
    }
}
