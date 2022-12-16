package uz.lutfullayevmuhammad.lesson46
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.lutfullayevmuhammad.lesson46.core.adapter.CategoryAdapter
import uz.lutfullayevmuhammad.lesson46.core.models.category.CategoryResponse
import uz.lutfullayevmuhammad.lesson46.core.models.category.MealCategories
import uz.lutfullayevmuhammad.lesson46.core.network.NetworkConnection
import uz.lutfullayevmuhammad.lesson46.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter = CategoryAdapter()
    lateinit var httpBtn:Button

    lateinit var binding: ActivityMainBinding

    private lateinit var data:MealCategories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.categoryList.adapter=adapter
        binding.categoryList.layoutManager = GridLayoutManager(this, 2)

        loadCategories()

        adapter.onItemClicka = {
            val intent = Intent(this,SubCategoryActivity::class.java)

            intent.putExtra("sub_category",it.strCategory)

            startActivity(intent)
        }

    }

    fun OnClick(meal: MealCategories){

    }

    fun loadCategories() {

        val call = NetworkConnection.getApiMethods(this).getCategories("list")

        call.enqueue(object :Callback<CategoryResponse>{
            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                if (response.isSuccessful) {
                    adapter.setCategories(response.body()!!.categories)
                }
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {

            }

        })

    }

}