package coder.mtk_and_nh.themealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.model.MealXX
import coder.mtk_and_nh.themealdb.model.MealXXXXX
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_filter.view.*

class CategoryFilterAdapter (var categoyList : List<MealXXXXX> = ArrayList<MealXXXXX>()) : RecyclerView.Adapter<CategoryFilterAdapter.CategroyFilterViewModel>(){

    fun update (categoyList : List<MealXXXXX>) {
        this.categoyList = categoyList
    }

    class CategroyFilterViewModel (itemView : View) : RecyclerView.ViewHolder (itemView) {
        fun bind (meal : MealXXXXX){
            itemView.filterName.text = meal.strMeal
            Picasso.get()
                .load(meal.strMealThumb)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.filterPhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategroyFilterViewModel {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_filter,parent,false)
        return CategroyFilterViewModel(view)
    }

    override fun getItemCount(): Int {
        return categoyList.size
    }

    override fun onBindViewHolder(holder: CategroyFilterViewModel, position: Int) {
        holder.bind(categoyList[position])
    }

}