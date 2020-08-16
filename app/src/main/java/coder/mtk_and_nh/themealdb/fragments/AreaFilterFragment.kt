package coder.mtk_and_nh.themealdb.fragments

import android.hardware.Camera
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.adapter.AreaAdapter
import coder.mtk_and_nh.themealdb.viewmodel.MealViewModel
import kotlinx.android.synthetic.main.fragment_area_filter.*


class AreaFilterFragment : Fragment() {

    lateinit var viewModel: MealViewModel
    lateinit var areaAdapter : AreaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_area_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        var messagearg = arguments?.let {
            AreaFilterFragmentArgs.fromBundle(it)
        }

        var area : String = messagearg?.area.toString()

        titleFilter.text = area

        viewModel.loadArea(area)

        areaFilterRecycler.layoutManager = GridLayoutManager(context,2)

        areaAdapter = AreaAdapter()

        viewModel.getArea().observe(
            viewLifecycleOwner, Observer {
                areaAdapter.updateAreaList(it.meals)
                areaFilterRecycler.adapter = areaAdapter
            }
        )




    }
}