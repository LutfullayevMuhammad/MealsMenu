package uz.lutfullayevmuhammad.lesson46.core.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.lutfullayevmuhammad.lesson46.core.models.category.MealCategories
import uz.lutfullayevmuhammad.lesson46.databinding.ItemCategoryBinding

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val data = ArrayList<MealCategories>()

    var onItemClicka: ((meal: MealCategories) -> Unit)? = null

    fun setCategories(data: List<MealCategories>) {
        this.data.addAll(data)
        notifyItemRangeInserted(this.data.size - data.size, data.size)

    }

    class ViewHolder(val itemCategoryBinding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(itemCategoryBinding.root) {

        fun bindData(d: MealCategories) {

            itemCategoryBinding.title.text = d.strCategory

            itemCategoryBinding.mealImage.load(d.strCategoryThumb)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data[position])

        holder.itemCategoryBinding.root.setOnClickListener {
            onItemClicka?.invoke(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}