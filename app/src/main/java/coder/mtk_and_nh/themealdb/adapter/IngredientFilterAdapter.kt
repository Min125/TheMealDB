package coder.mtk_and_nh.themealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.model.MealXX
import coder.mtk_and_nh.themealdb.model.MealXXXX
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_filter.view.*

class IngredientFilterAdapter (var areaList : List<MealXXXX> = ArrayList<MealXXXX>()) : RecyclerView.Adapter<IngredientFilterAdapter.IngredientFilterViewHolder>(){

    fun updateIngredientFilter (areaList : List<MealXXXX>) {
        this.areaList = areaList
    }

    class IngredientFilterViewHolder (itemView : View) : RecyclerView.ViewHolder (itemView) {
        fun bind (meal : MealXXXX){
            itemView.filterName.text = meal.strMeal
            Picasso.get()
                .load(meal.strMealThumb)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.filterPhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientFilterViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_filter,parent,false)
        return IngredientFilterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return areaList.size
    }

    override fun onBindViewHolder(holder: IngredientFilterViewHolder, position: Int) {
        holder.bind(areaList[position])
    }

}