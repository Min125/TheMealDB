package coder.mtk_and_nh.themealdb.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.adapternh.AzShowAdapter
import coder.mtk_and_nh.themealdb.apinh.ApiClient
import coder.mtk_and_nh.themealdb.model.nhmodel.Alphabet
import coder.mtk_and_nh.themealdb.model.nhmodel.Meal
import kotlinx.android.synthetic.main.fragment_az_show.*
import kotlinx.android.synthetic.main.item_azshow.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AzShowFragment : Fragment(), AzShowAdapter.ClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_az_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var meal:List<Meal>
        var arg = arguments.let {
            AzShowFragmentArgs?.fromBundle(it!!)
        }
        var msg = arg?.Arg

//        var mealViewModel:MealViewModel
//        mealViewModel = ViewModelProvider(this).get(MealViewModel::class.java)
//        mealViewModel.loadViewModel(msg)
//        mealViewModel.getAz().observe(viewLifecycleOwner, Observer {
//             meal = it.meals
//        })
//
//        var azShowAdapter = AzShowAdapter(meal)
//                recyclerAzShow.adapter = azShowAdapter
//                recyclerAzShow.layoutManager = GridLayoutManager(context, 2)
//              azShowAdapter.adapterClickListener(this)
//

        var apiClient = ApiClient()
        var apiCall = apiClient.getAlphabet(msg)

        apiCall.enqueue(object : Callback<Alphabet> {
            override fun onFailure(call: Call<Alphabet>, t: Throwable) {
                txtAzShow.text = t.toString()
            }

            override fun onResponse(call: Call<Alphabet>, response: Response<Alphabet>) {
                var meal = response.body()!!.meals

                var azShowAdapter = AzShowAdapter(meal)
                recyclerAzShow.adapter = azShowAdapter
                recyclerAzShow.layoutManager = GridLayoutManager(context, 2)
                azShowAdapter.adapterClickListener(this@AzShowFragment)



            }

        })



    }

//    fun callDetail() {
//
//    }

    override fun click(meal: Meal) {
        var action = AzShowFragmentDirections.actionAzShowFragmentToDetailFragment(meal.idMeal)
        findNavController().navigate(action)
    }


}

