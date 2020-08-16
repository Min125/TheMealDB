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
import androidx.recyclerview.widget.LinearLayoutManager
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.adapter.CategoryAdapter
import coder.mtk_and_nh.themealdb.adapter.RandomAdapter
import coder.mtk_and_nh.themealdb.model.Category
import coder.mtk_and_nh.themealdb.viewmodel.MealViewModel
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() , CategoryAdapter.ClickListener{

    lateinit var viewModel : MealViewModel

    lateinit var randomAdapter: RandomAdapter
    lateinit var categoryAdapter: CategoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        viewModel.loadCategory()

        categoryAdapter = CategoryAdapter()

        categoriesRecycler.layoutManager = GridLayoutManager(context,3)

        viewModel.getCategory().observe(
            viewLifecycleOwner, Observer {
                categoryAdapter.updateCategoryList(it.categories)
                categoriesRecycler.adapter = categoryAdapter
            }
        )

        categoryAdapter.setOnClickListenerCategory(this)


        //load Random
        viewModel.loadRandom()
        randomAdapter = RandomAdapter()
        randomCard.layoutManager = LinearLayoutManager(context)
        viewModel.getRandom().observe(
            viewLifecycleOwner, Observer {
               randomAdapter.updateRandom(it.meals)
                randomCard.adapter = randomAdapter
            }
        )


        btnCountry.setOnClickListener{
            var action = MainFragmentDirections.actionMainFragmentToCountryListFragment()
            findNavController().navigate(action)
        }

         btnIngredient.setOnClickListener{
            var action = MainFragmentDirections.actionMainFragmentToIngredientListFragment()
             findNavController().navigate(action)
         }
    }

    override fun onClickCategroy(category: Category) {
        var action = MainFragmentDirections.actionMainFragmentToCategoryFilterFragment(category.strCategory)
        findNavController().navigate(action)
    }


}