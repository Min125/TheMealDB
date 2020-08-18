package coder.mtk_and_nh.themealdb.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.adapternh.AzListAdapter
import coder.mtk_and_nh.themealdb.model.nhmodel.AzListClass
import coder.mtk_and_nh.themealdb.model.nhmodel.Meal
import kotlinx.android.synthetic.main.fragment_az_list.*

class AzListFragment : Fragment(),AzListAdapter.ClickListener {
    lateinit var meal: Meal
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_az_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var azList = ArrayList<AzListClass>()

        azList.add(AzListClass("A"))
        azList.add(AzListClass("B"))
        azList.add(AzListClass("C"))
        azList.add(AzListClass("D"))
        azList.add(AzListClass("E"))
        azList.add(AzListClass("F"))
        azList.add(AzListClass("G"))
        azList.add(AzListClass("H"))
        azList.add(AzListClass("I"))
        azList.add(AzListClass("J"))
        azList.add(AzListClass("K"))
        azList.add(AzListClass("L"))
        azList.add(AzListClass("M"))
        azList.add(AzListClass("N"))
        azList.add(AzListClass("O"))
        azList.add(AzListClass("P"))
        azList.add(AzListClass("Q"))
        azList.add(AzListClass("R"))
        azList.add(AzListClass("S"))
        azList.add(AzListClass("T"))
        azList.add(AzListClass("U"))
        azList.add(AzListClass("V"))
        azList.add(AzListClass("W"))
        azList.add(AzListClass("X"))
        azList.add(AzListClass("Y"))
        azList.add(AzListClass("Z"))


        var azListAdapter = AzListAdapter(azList)
        recyclerAzList.layoutManager = LinearLayoutManager(context)
        recyclerAzList.adapter = azListAdapter

        azListAdapter.adapterClickListener(this)



    }

    override fun click(azList: AzListClass) {

        var action = AzListFragmentDirections.actionAzListFragmentToAzShowFragment(azList.AzList)
        findNavController().navigate(action)
    }


}