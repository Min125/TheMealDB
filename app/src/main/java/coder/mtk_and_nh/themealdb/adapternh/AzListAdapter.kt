package coder.mtk_and_nh.themealdb.adapternh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.model.nhmodel.AzListClass
import kotlinx.android.synthetic.main.item_azlist.view.txtAzList


class AzListAdapter (var azList:ArrayList<AzListClass>):RecyclerView.Adapter<AzListAdapter.AzListViewHolder>() {
    var clickListener: ClickListener? = null

    fun adapterClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }


   inner class AzListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

    lateinit var azList: AzListClass

        fun bindAzList(azList: AzListClass) {
            this.azList=azList
            itemView.txtAzList.text=azList.AzList.toString()

        }

       override fun onClick(view: View?) {
           clickListener?.click(azList)
       }

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AzListViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_azlist,parent,false)
        return AzListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return azList.size
    }

    override fun onBindViewHolder(holder: AzListViewHolder, position: Int) {
        holder.bindAzList(azList[position])
    }
    interface ClickListener {

        fun click(azList: AzListClass)
    }
}