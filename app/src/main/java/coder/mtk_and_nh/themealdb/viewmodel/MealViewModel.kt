package coder.mtk_and_nh.themealdb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coder.mtk_and_nh.themealdb.apinh.ApiClient
import coder.mtk_and_nh.themealdb.model.nhmodel.Alphabet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealViewModel : ViewModel( ){


    var getAz : MutableLiveData<Alphabet> = MutableLiveData()
    fun getAz() : LiveData<Alphabet> = getAz

    fun loadViewModel(msg:String){

        var apiClient = ApiClient()
        var apiCall = apiClient.getAlphabet(msg)

        apiCall.enqueue(object : Callback<Alphabet> {
            override fun onFailure(call: Call<Alphabet>, t: Throwable) {

            }

            override fun onResponse(call: Call<Alphabet>, response: Response<Alphabet>) {

                getAz.value = response.body()
            }


        })




        }



}