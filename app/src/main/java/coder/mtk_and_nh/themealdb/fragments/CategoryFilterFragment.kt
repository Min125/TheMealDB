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
import coder.mtk_and_nh.themealdb.adapter.AreaAdapter
import coder.mtk_and_nh.themealdb.adapter.CategoryFilterAdapter
import coder.mtk_and_nh.themealdb.model.MealXXXXX
import coder.mtk_and_nh.themealdb.viewmodel.MealViewModel
import kotlinx.android.synthetic.main.fragment_category_filter.*

class CategoryFilterFragment : Fragment() , CategoryFilterAdapter.ClickListener{

    lateinit var viewModel: MealViewModel
    lateinit var categoryFilterAdapter: CategoryFilterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        var messagearg = arguments?.let {
            CategoryFilterFragmentArgs.fromBundle(it)
        }

        var category = messagearg?.category.toString()

        titleCategoryFilter.text = category

        viewModel.loadCategoryFilter(category)

        categoryFilterRecycler.layoutManager = GridLayoutManager(context,2)

        categoryFilterAdapter = CategoryFilterAdapter()

        viewModel.getCategoryFilter().observe(
            viewLifecycleOwner, Observer {
                categoryFilterAdapter.update(it.meals)
                categoryFilterRecycler.adapter = categoryFilterAdapter
            }
        )

        categoryFilterAdapter.setOnClickListener(this)
    }

    override fun onClick(meal: MealXXXXX) {
        var action = CategoryFilterFragmentDirections.actionCategoryFilterFragmentToDetailFragment(meal.idMeal)
        findNavController().navigate(action)
    }
}