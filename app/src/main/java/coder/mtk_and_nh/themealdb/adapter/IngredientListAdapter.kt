package coder.mtk_and_nh.themealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.model.MealX
import coder.mtk_and_nh.themealdb.model.MealXXX
import kotlinx.android.synthetic.main.item_listrecycler.view.*

class IngredientListAdapter (var ingredientList : List<MealXXX> = ArrayList<MealXXX>()) : RecyclerView.Adapter<IngredientListAdapter.IngredientListViewHolder>() {

    var clickListener : ClickListener? = null

    fun setOnClickListener (clickListener : ClickListener){
        this.clickListener = clickListener
    }

    fun updateIngredient(ingredientList : List<MealXXX>) {
        this.ingredientList = ingredientList
    }

    inner class IngredientListViewHolder (itemView : View) : RecyclerView.ViewHolder (itemView) , View.OnClickListener{

        init {
            itemView.setOnClickListener(this)
        }

        lateinit var ingredient: MealXXX

        fun bind (ingredient: MealXXX) {
            this.ingredient = ingredient
            itemView.listItem.text = ingredient.strIngredient
        }

        override fun onClick(p0: View?) {
            clickListener?.onClick(ingredient)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientListViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_listrecycler,parent,false)
        return IngredientListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }

    override fun onBindViewHolder(holder: IngredientListViewHolder, position: Int) {
        return holder.bind(ingredientList[position])
    }
    interface ClickListener {
        fun onClick (ingredient: MealXXX)
    }

}