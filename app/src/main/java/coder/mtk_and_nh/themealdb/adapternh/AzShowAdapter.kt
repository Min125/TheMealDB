package coder.mtk_and_nh.themealdb.adapternh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.model.nhmodel.Meal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_azshow.view.*

class AzShowAdapter (var meal:List<Meal>):RecyclerView.Adapter<AzShowAdapter.AzShowViewHolder>() {
    var clickListener: ClickListener? = null

    fun adapterClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

//    fun updateAzShow(mealList : List<Meal>){
//        this.meal=mealList
//    }


    inner class AzShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        lateinit var meal: Meal

        fun bindAzShow(meal: Meal) {
            this.meal=meal
            itemView.txtAzShow.text = meal.strMeal
            Picasso.get().load(meal.strMealThumb).into(itemView.imgAzShow)

        }

        override fun onClick(view: View?) {
            clickListener?.click(meal)
        }


    }

    interface ClickListener {

        fun click(meal: Meal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AzShowViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_azshow,parent,false)
        return AzShowViewHolder(view)

    }

    override fun getItemCount(): Int {
        return  meal.size
    }

    override fun onBindViewHolder(holder: AzShowViewHolder, position: Int) {
        holder.bindAzShow(meal[position])
    }
}