package uz.lutfullayevmuhammad.lesson46

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import retrofit2.Call
import retrofit2.HttpException
import retrofit2.Response
import uz.lutfullayevmuhammad.lesson46.core.adapter.SubCategoryAdapter
import uz.lutfullayevmuhammad.lesson46.core.models.subCategory.SubCategoryResponse
import uz.lutfullayevmuhammad.lesson46.core.network.NetworkConnection
import uz.lutfullayevmuhammad.lesson46.databinding.ActivitySubCategoryBinding
import java.net.UnknownHostException

class SubCategoryActivity : AppCompatActivity() {

    lateinit var binding: ActivitySubCategoryBinding

    private val adapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubCategoryBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val subStrCategory = intent.getStringExtra("sub_category")

        binding.mealsList.adapter = adapter
        binding.mealsList.layoutManager = GridLayoutManager(this,2)

        loadSubCategory(subStrCategory)


        adapter.onItemClicka = {
            val intent = Intent(this,MealsActivity::class.java)

            intent.putExtra("sub_meals",it.idMeal)

            startActivity(intent)
        }

    }

    private fun loadSubCategory(subStrCategory:String?) {

        val call =subStrCategory?.let { NetworkConnection.getApiMethods(this).getSubCategories(it) }

        call?.enqueue(object : retrofit2.Callback<SubCategoryResponse> {
            override fun onResponse(call: Call<SubCategoryResponse>, response: Response<SubCategoryResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()

                    data?.let {
                        adapter.setCategories(it.meals)
                    }
                }
            }

            override fun onFailure(call: Call<SubCategoryResponse>, t: Throwable) {
                if (t is UnknownHostException){

                }else if (t is HttpException){

                }
            }

        })

    }

}