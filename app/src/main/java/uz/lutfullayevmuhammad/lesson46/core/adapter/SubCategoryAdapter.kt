package uz.lutfullayevmuhammad.lesson46.core.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.lutfullayevmuhammad.lesson46.core.models.subCategory.Meal
import uz.lutfullayevmuhammad.lesson46.databinding.ItemSubCategoryBinding

class SubCategoryAdapter : RecyclerView.Adapter<SubCategoryAdapter.ViewHolder>() {

    private val data = ArrayList<Meal>()

    var onItemClicka: ((meal: Meal) -> Unit)? = null

    fun setCategories(data: List<Meal>) {
        this.data.addAll(data)
        notifyItemRangeInserted(this.data.size - data.size, data.size)

    }

    class ViewHolder(val itemSubCategoryBinding: ItemSubCategoryBinding) :
        RecyclerView.ViewHolder(itemSubCategoryBinding.root) {

        fun bindData(d: Meal) {

            itemSubCategoryBinding.title.text = d.strMeal

            itemSubCategoryBinding.mealImage.load(d.strMealThumb)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSubCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data[position])

        holder.itemSubCategoryBinding.root.setOnClickListener {
            onItemClicka?.invoke(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}