package coder.mtk_and_nh.themealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.model.MealX
import kotlinx.android.synthetic.main.item_listrecycler.view.*

class CountryAdapter (var countryList : List<MealX> = ArrayList<MealX>()) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    var clickListener : ClickListener? = null

    fun setOnClickListener (clickListener : ClickListener){
        this.clickListener = clickListener
    }

    fun updateCountry(countryList : List<MealX>) {
        this.countryList = countryList
    }

    inner class CountryViewHolder (itemView : View) : RecyclerView.ViewHolder (itemView) , View.OnClickListener{

        init {
            itemView.setOnClickListener(this)
        }

        lateinit var country: MealX

        fun bind (country : MealX) {
            this.country = country
            itemView.listItem.text = country.strArea
        }

        override fun onClick(p0: View?) {
            clickListener?.onClick(country)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_listrecycler,parent,false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        return holder.bind(countryList[position])
    }
    interface ClickListener {
        fun onClick (country: MealX)
    }

}