package coder.mtk_and_nh.themealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.model.Area
import coder.mtk_and_nh.themealdb.model.MealXX
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_filter.view.*

class AreaAdapter (var areaList : List<MealXX> = ArrayList<MealXX>()) : RecyclerView.Adapter<AreaAdapter.AreaViewModel>(){

    fun updateAreaList (areaList : List<MealXX>) {
        this.areaList = areaList
    }

    class AreaViewModel (itemView : View) : RecyclerView.ViewHolder (itemView) {
        fun bind (meal : MealXX){
            itemView.filterName.text = meal.strMeal
            Picasso.get()
                .load(meal.strMealThumb)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.filterPhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaViewModel {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_filter,parent,false)
        return AreaViewModel(view)
    }

    override fun getItemCount(): Int {
        return areaList.size
    }

    override fun onBindViewHolder(holder: AreaViewModel, position: Int) {
        holder.bind(areaList[position])
    }

}