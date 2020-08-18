package coder.mtk_and_nh.themealdb.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.apinh.ApiClient
import coder.mtk_and_nh.themealdb.model.nhmodel.Detail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
lateinit var ingredient :String

        var arg = arguments.let { DetailFragmentArgs.fromBundle(it!!) }
        var msg = arg.ArgToDetail

        var apiClient = ApiClient()
        var apiCall = apiClient.getDetail(msg)

        apiCall.enqueue(object : Callback<Detail> {
            override fun onFailure(call: Call<Detail>, t: Throwable) {
                textView2.text=t.toString()
            }

            override fun onResponse(call: Call<Detail>, response: Response<Detail>) {

                textView.text = response.body()!!.meals[0].strMeal
                textView2.text = response.body()!!.meals[0].strCategory
                textView3.text = response.body()!!.meals[0].strArea
                Picasso.get().load(response.body()!!.meals[0].strMealThumb).into(imageView)
                textView4.text = response.body()!!.meals[0].strInstructions
                var ingredients = response.body()!!.meals[0].strIngredient1




              ingredient = ingredients
//                var mealxx = response.body()!!.meals
//                var meal = mealxx[msg.toInt()]
//                textView2.text = meal.strCategory.toString()
            }


        })

        cd1.setOnClickListener{

            val builder = AlertDialog.Builder(context)
            builder.setTitle("Ingredients")
            builder.setMessage(ingredient)

            val alertDialog:AlertDialog = builder.create()
            alertDialog.show()
//            builder.setPositiveButton("Yes"){
//
//                dialogInterface, which -> Toast.makeText(context,"clicked yes",Toast.LENGTH_LONG).show()
//
//            }
//
//            builder.setNeutralButton("Cancel"){
//                dialogInterface, which -> Toast.makeText(context,"clicked cancel",Toast.LENGTH_LONG).show()
//            }


        }

    }

//    fun detailCall() {
//
//    }
}