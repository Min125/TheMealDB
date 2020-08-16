package coder.mtk_and_nh.themealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.model.Meal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.item_random.view.*

class RandomAdapter (var randomList : List<Meal> = ArrayList<Meal>()) : RecyclerView.Adapter<RandomAdapter.RandomViewHolder>(){

    fun updateRandom (randomList : List<Meal> ){
        this.randomList = randomList
    }

    class RandomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(meal : Meal){
            itemView.randomName.text = meal.strMeal
            Picasso.get()
                .load(meal.strMealThumb)
                .placeholder(R.drawable.ic_launcher_background)
                .fit()
                .into(itemView.randomPhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_random,parent,false)
        return RandomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return randomList.size
    }

    override fun onBindViewHolder(holder: RandomViewHolder, position: Int) {
        holder.bind(randomList[position])
    }
}
