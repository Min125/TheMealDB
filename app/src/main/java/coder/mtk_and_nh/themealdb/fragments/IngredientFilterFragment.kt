package coder.mtk_and_nh.themealdb.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.adapter.IngredientFilterAdapter
import coder.mtk_and_nh.themealdb.model.MealXXXX
import coder.mtk_and_nh.themealdb.viewmodel.MealViewModel
import kotlinx.android.synthetic.main.fragment_area_filter.*
import kotlinx.android.synthetic.main.fragment_ingredient_filter.*

class IngredientFilterFragment : Fragment() , IngredientFilterAdapter.ClickListener {

    lateinit var ingredientFilerAdapter : IngredientFilterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingredient_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var viewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        var messagearg =arguments?.let {
            IngredientFilterFragmentArgs.fromBundle(it)
        }

        var ingredient : String  = messagearg?.ingredient.toString()

        titleIngredientFilter.text = ingredient

        viewModel.loadIngredientFilter(ingredient)

        ingredientFilterRecycler.layoutManager = GridLayoutManager(context,2)
        ingredientFilerAdapter = IngredientFilterAdapter()

        viewModel.getIngredientFilter().observe(
            viewLifecycleOwner, Observer {
                ingredientFilerAdapter.updateIngredientFilter(it.meals)
                ingredientFilterRecycler.adapter = ingredientFilerAdapter
            }
        )

        ingredientFilerAdapter.setOnClickListener(this)

    }

    override fun onClick(meal: MealXXXX) {
        var action = IngredientFilterFragmentDirections.actionIngredientFilterFragmentToDetailFragment(meal.idMeal)
        findNavController().navigate(action)
    }
}