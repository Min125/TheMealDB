package coder.mtk_and_nh.themealdb.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.adapter.CountryAdapter
import coder.mtk_and_nh.themealdb.model.MealX
import coder.mtk_and_nh.themealdb.viewmodel.MealViewModel
import kotlinx.android.synthetic.main.fragment_country_list.*


class CountryListFragment : Fragment() , CountryAdapter.ClickListener{
    lateinit var viewModel : MealViewModel
    lateinit var countryAdapter: CountryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)  {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        viewModel.loadCountryList()

        countryAdapter = CountryAdapter()

        countryListRecycler.layoutManager = LinearLayoutManager(context)

        viewModel.getCountryList().observe(
            viewLifecycleOwner, Observer {
                countryAdapter.updateCountry(it.meals)
                countryListRecycler.adapter = countryAdapter
            }
        )

        countryAdapter.setOnClickListener(this)

    }

    override fun onClick(country: MealX) {
        var action = CountryListFragmentDirections.actionCountryListFragmentToAreaFilterFragment(country.strArea)
        findNavController().navigate(action)
    }


}