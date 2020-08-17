package coder.mtk_and_nh.themealdb.viewmodel

import android.hardware.biometrics.BiometricPrompt
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coder.mtk_and_nh.themealdb.api.ApiClient
import coder.mtk_and_nh.themealdb.model.*
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response


class MealViewModel : ViewModel(){

    private var category : MutableLiveData<Categories> = MutableLiveData()
    private var random : MutableLiveData<Random> = MutableLiveData()
    private var countryList : MutableLiveData<Country> = MutableLiveData()
    private var area : MutableLiveData<Area> = MutableLiveData()
    private var ingredientList : MutableLiveData<Ingredient> = MutableLiveData()
    private var ingredientFilter : MutableLiveData<IngredientFilter> = MutableLiveData()
    private var categoryFilter : MutableLiveData<CategoryFilter> = MutableLiveData()

    fun getCategory () : LiveData <Categories> = category
    fun getRandom() : LiveData<Random> = random
    fun getCountryList () : LiveData<Country> = countryList
    fun getArea () : LiveData<Area> = area
    fun getIngredient () : LiveData<Ingredient> = ingredientList
    fun getIngredientFilter () : LiveData<IngredientFilter> = ingredientFilter
    fun getCategoryFilter () : LiveData<CategoryFilter> = categoryFilter

    fun loadCategory () {
        val apiClient = ApiClient()
        var apiCall = apiClient.getCategoryList()

        apiCall.enqueue(
            object : Callback<Categories>{
                override fun onFailure(call: Call<Categories>, t: Throwable) {

                }

                override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                    category.value = response.body()
                }

            }
        )
    }

    fun loadRandom () {
        val apiClient = ApiClient()
        var apiCall = apiClient.getRandomMeal()

        apiCall.enqueue(
            object : Callback<Random>{
                override fun onFailure(call: Call<Random>, t: Throwable) {

                }

                override fun onResponse(call: Call<Random>, response: Response<Random>) {
                    random.value = response.body()
//                    Log.d("Random>>>>>>>>>>>",response.body().toString())
                }

            }
        )
    }

    fun loadCountryList (){
        val apiClient = ApiClient()
        var apiCall = apiClient.getCountryList()

        apiCall.enqueue(
            object : Callback<Country>{
                override fun onFailure(call: Call<Country>, t: Throwable) {

                }

                override fun onResponse(call: Call<Country>, response: Response<Country>) {
                   countryList.value = response.body()
//                    Log.d("Random>>>>>>>>>>>",response.body().toString())
                }
            }
        )
    }

    fun loadArea (a : String){
        val apiClient =ApiClient()
        var apiCall = apiClient.getAreaFilter(a)

        apiCall.enqueue(
            object : Callback <Area>{
                override fun onFailure(call: Call<Area>, t: Throwable) {

                }

                override fun onResponse(call: Call<Area>, response: Response<Area>) {
                    area.value = response.body()
                    Log.d ("area>>>>>>>>>>>>>>>>>>",response.body().toString())
                }

            }
        )
    }

    fun loadIngredientList (){
        val apiClient = ApiClient ()
        var apiCall = apiClient.getIngredientList()

        apiCall.enqueue(
            object : Callback<Ingredient>{
                override fun onFailure(call: Call<Ingredient>, t: Throwable) {

                }

                override fun onResponse(call: Call<Ingredient>, response: Response<Ingredient>) {
                    ingredientList.value = response.body()
                }

            }
        )
    }

    fun loadIngredientFilter (ingredient : String){
        val apiClient = ApiClient()
        var apiCall = apiClient.getIngredientFilter(ingredient)

        apiCall.enqueue(
            object : Callback <IngredientFilter> {
                override fun onFailure(call: Call<IngredientFilter>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<IngredientFilter>,
                    response: Response<IngredientFilter>
                ) {
                    ingredientFilter.value = response.body()
                }

            }
        )
    }

    fun loadCategoryFilter (category : String){
        val apiClient = ApiClient()
        var apiCall = apiClient.getCategoryFilter(category)

        apiCall.enqueue(
            object : Callback<CategoryFilter>{
                override fun onFailure(call: Call<CategoryFilter>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<CategoryFilter>,
                    response: Response<CategoryFilter>
                ) {
                   categoryFilter.value = response.body()
                }

            }
        )
    }

}
