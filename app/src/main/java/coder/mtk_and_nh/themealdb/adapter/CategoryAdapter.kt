package coder.mtk_and_nh.themealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk_and_nh.themealdb.R
import coder.mtk_and_nh.themealdb.model.Category
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter (var categoryList : List<Category> = ArrayList<Category>() ) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    var clickListener :ClickListener? = null

    fun setOnClickListenerCategory (clickListener: ClickListener){
        this.clickListener = clickListener
    }

    fun updateCategoryList  (categoryList : List<Category>){
        this.categoryList =categoryList
    }

    inner class CategoryViewHolder (itemView : View) : RecyclerView.ViewHolder (itemView), View.OnClickListener{

        init {
            itemView.setOnClickListener(this)
        }

        lateinit var category  :Category

        fun bind(category: Category){
            this.category =category
            itemView.categoriesName.text = category.strCategory
            Picasso.get()
                .load(category.strCategoryThumb)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.categoriesPhoto)
        }

        override fun onClick(p0: View?) {
           clickListener?.onClickCategroy(category)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    interface ClickListener {
        fun onClickCategroy  (category: Category)
    }

}
