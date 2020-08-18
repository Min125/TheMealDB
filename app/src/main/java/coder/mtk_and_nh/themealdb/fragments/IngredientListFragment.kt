package coder.mtk_and_nh.themealdb.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.adapter.IngredientListAdapter
import coder.mtk_and_nh.themealdb.model.Meal
import coder.mtk_and_nh.themealdb.model.MealXXX
import coder.mtk_and_nh.themealdb.viewmodel.MealViewModel
import kotlinx.android.synthetic.main.fragment_ingredient_list.*


class IngredientListFragment : Fragment() , IngredientListAdapter.ClickListener{

    lateinit var viewModel : MealViewModel
    lateinit var ingredientListAdapter: IngredientListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingredient_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        viewModel.loadIngredientList()

        IngredientListRecycler.layoutManager = LinearLayoutManager(context)

        ingredientListAdapter = IngredientListAdapter()

        viewModel.getIngredient().observe(
            viewLifecycleOwner, Observer {
                ingredientListAdapter.updateIngredient(it.meals)
                IngredientListRecycler.adapter = ingredientListAdapter
            }
        )

        ingredientListAdapter.setOnClickListener(this)

    }

    override fun onClick(ingredient: MealXXX) {
        var action = IngredientListFragmentDirections.actionIngredientListFragmentToIngredientFilterFragment(ingredient.strIngredient)
        findNavController().navigate(action)
    }

}