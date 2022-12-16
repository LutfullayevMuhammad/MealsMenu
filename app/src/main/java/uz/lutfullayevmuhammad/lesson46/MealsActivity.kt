package uz.lutfullayevmuhammad.lesson46

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import coil.load
import retrofit2.Call
import retrofit2.HttpException
import retrofit2.Response
import uz.lutfullayevmuhammad.lesson46.core.models.meals.MealsResponse
import uz.lutfullayevmuhammad.lesson46.core.network.NetworkConnection
import java.net.UnknownHostException

class MealsActivity : AppCompatActivity() {

    lateinit var mealsImage: ImageView
    lateinit var mealsName: TextView
    lateinit var mealsCategory: TextView
    lateinit var mealsArea: TextView
    lateinit var mealsYoutube: TextView
    lateinit var ingredients1: TextView
    lateinit var ingredients2: TextView
    lateinit var ingredients3: TextView
    lateinit var ingredients4: TextView
    lateinit var ingredients5: TextView
    lateinit var ingredients6: TextView
    lateinit var ingredients7: TextView
    lateinit var ingredients8: TextView
    lateinit var ingredients9: TextView
    lateinit var ingredients10: TextView
    lateinit var ingredients11: TextView
    lateinit var ingredients12: TextView
    lateinit var ingredients13: TextView
    lateinit var ingredients14: TextView
    lateinit var ingredients15: TextView
    lateinit var ingredients16: TextView
    lateinit var ingredients17: TextView
    lateinit var ingredients18: TextView
    lateinit var ingredients19: TextView
    lateinit var ingredients20: TextView
    lateinit var measure1: TextView
    lateinit var measure2: TextView
    lateinit var measure3: TextView
    lateinit var measure4: TextView
    lateinit var measure5: TextView
    lateinit var measure6: TextView
    lateinit var measure7: TextView
    lateinit var measure8: TextView
    lateinit var measure9: TextView
    lateinit var measure10: TextView
    lateinit var measure11: TextView
    lateinit var measure12: TextView
    lateinit var measure13: TextView
    lateinit var measure14: TextView
    lateinit var measure15: TextView
    lateinit var measure16: TextView
    lateinit var measure17: TextView
    lateinit var measure18: TextView
    lateinit var measure19: TextView
    lateinit var measure20: TextView

    lateinit var instructionText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals)

        mealsImage = findViewById(R.id.meals_image)
        mealsName = findViewById(R.id.meal_name)
        mealsCategory = findViewById(R.id.category_name)
        mealsArea = findViewById(R.id.area_name)
        mealsYoutube = findViewById(R.id.youtube_name)

        ingredients1 = findViewById(R.id.ingredient1)
        ingredients2 = findViewById(R.id.ingredient2)
        ingredients3 = findViewById(R.id.ingredient3)
        ingredients4 = findViewById(R.id.ingredient4)
        ingredients5 = findViewById(R.id.ingredient5)
        ingredients6 = findViewById(R.id.ingredient6)
        ingredients7 = findViewById(R.id.ingredient7)
        ingredients8 = findViewById(R.id.ingredient8)
        ingredients9 = findViewById(R.id.ingredient9)
        ingredients10 = findViewById(R.id.ingredient10)
        ingredients11 = findViewById(R.id.ingredient11)
        ingredients12 = findViewById(R.id.ingredient12)
        ingredients13 = findViewById(R.id.ingredient13)
        ingredients14 = findViewById(R.id.ingredient14)
        ingredients15 = findViewById(R.id.ingredient15)
        ingredients16 = findViewById(R.id.ingredient16)
        ingredients17 = findViewById(R.id.ingredient17)
        ingredients18 = findViewById(R.id.ingredient18)
        ingredients19 = findViewById(R.id.ingredient19)
        ingredients20 = findViewById(R.id.ingredient20)
        measure1 = findViewById(R.id.measure1)
        measure2 = findViewById(R.id.measure2)
        measure3 = findViewById(R.id.measure3)
        measure4 = findViewById(R.id.measure4)
        measure5 = findViewById(R.id.measure5)
        measure6 = findViewById(R.id.measure6)
        measure7 = findViewById(R.id.measure7)
        measure8 = findViewById(R.id.measure8)
        measure9 = findViewById(R.id.measure9)
        measure10 = findViewById(R.id.measure10)
        measure11 = findViewById(R.id.measure11)
        measure12 = findViewById(R.id.measure12)
        measure13 = findViewById(R.id.measure13)
        measure14 = findViewById(R.id.measure14)
        measure15 = findViewById(R.id.measure15)
        measure16 = findViewById(R.id.measure16)
        measure17 = findViewById(R.id.measure17)
        measure18 = findViewById(R.id.measure18)
        measure19 = findViewById(R.id.measure19)
        measure20 = findViewById(R.id.measure20)

        instructionText = findViewById(R.id.meals_instruction)

        val subMealsCategory = intent.getStringExtra("sub_meals")

        loadMealsCategory(subMealsCategory)

    }

    private fun loadMealsCategory(subMealsCategory: String?) {
        val call = subMealsCategory?.let { NetworkConnection.getApiMethods(this).getMeals(it) }

        call?.enqueue(object : retrofit2.Callback<MealsResponse> {
            override fun onResponse(call: Call<MealsResponse>, response: Response<MealsResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()

                    data?.let {
                        for (item in it.meals) {
                            mealsImage.load(item.strMealThumb)
                            mealsName.text = item.strMeal
                            mealsCategory.text = item.strCategory
                            mealsArea.text = item.strArea
                            instructionText.text = item.strInstructions

                            ingredients1.text = item.strIngredient1
                            ingredients2.text = item.strIngredient2
                            ingredients3.text = item.strIngredient3
                            ingredients4.text = item.strIngredient4
                            ingredients5.text = item.strIngredient5
                            ingredients6.text = item.strIngredient6
                            ingredients7.text = item.strIngredient7
                            ingredients8.text = item.strIngredient8
                            ingredients9.text = item.strIngredient9
                            ingredients10.text = item.strIngredient10
                            ingredients11.text = item.strIngredient11
                            ingredients12.text = item.strIngredient12
                            ingredients13.text = item.strIngredient13
                            ingredients14.text = item.strIngredient14
                            ingredients15.text = item.strIngredient15
                            ingredients16.text = item.strIngredient16
                            ingredients17.text = item.strIngredient17
                            ingredients18.text = item.strIngredient18
                            ingredients19.text = item.strIngredient19
                            ingredients20.text = item.strIngredient20

                            measure1.text = item.strMeasure1
                            measure2.text = item.strMeasure2
                            measure3.text = item.strMeasure3
                            measure4.text = item.strMeasure4
                            measure5.text = item.strMeasure5
                            measure6.text = item.strMeasure6
                            measure7.text = item.strMeasure7
                            measure8.text = item.strMeasure8
                            measure9.text = item.strMeasure9
                            measure10.text = item.strMeasure10
                            measure11.text = item.strMeasure11
                            measure12.text = item.strMeasure12
                            measure13.text = item.strMeasure13
                            measure14.text = item.strMeasure14
                            measure15.text = item.strMeasure15
                            measure16.text = item.strMeasure16
                            measure17.text = item.strMeasure17
                            measure18.text = item.strMeasure18
                            measure19.text = item.strMeasure19
                            measure20.text = item.strMeasure20

                            mealsYoutube.setOnClickListener {
                                var intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.strYoutube))

                                startActivity(intent)
                            }

                            if (ingredients1.text == "" || ingredients1 == null){
                                ingredients1.isVisible = false
                            }
                            if (ingredients2.text == "" || ingredients2 == null){
                                ingredients2.isVisible = false
                            }
                            if (ingredients3.text == "" || ingredients3 == null){
                                ingredients3.isVisible = false
                            }
                            if (ingredients4.text == "" || ingredients4 == null){
                                ingredients4.isVisible = false
                            }
                            if (ingredients5.text == "" || ingredients5 == null){
                                ingredients5.isVisible = false
                            }
                            if (ingredients6.text == "" || ingredients6 == null){
                                ingredients6.isVisible = false
                            }
                            if (ingredients7.text == "" || ingredients7 == null){
                                ingredients7.isVisible = false
                            }
                            if (ingredients8.text == "" || ingredients8 == null){
                                ingredients8.isVisible = false
                            }
                            if (ingredients9.text == "" || ingredients9 == null){
                                ingredients9.isVisible = false
                            }
                            if (ingredients10.text == "" || ingredients10 == null){
                                ingredients10.isVisible = false
                            }
                            if (ingredients11.text == "" || ingredients11 == null){
                                ingredients11.isVisible = false
                            }
                            if (ingredients12.text == "" || ingredients12 == null){
                                ingredients12.isVisible = false
                            }
                            if (ingredients13.text == "" || ingredients13 == null){
                                ingredients13.isVisible = false
                            }
                            if (ingredients14.text == "" || ingredients14 == null){
                                ingredients14.isVisible = false
                            }
                            if (ingredients15.text == "" || ingredients15 == null){
                                ingredients15.isVisible = false
                            }
                            if (ingredients16.text == "" || ingredients16 == null){
                                ingredients16.isVisible = false
                            }
                            if (ingredients17.text == "" || ingredients17 == null){
                                ingredients17.isVisible = false
                            }
                            if (ingredients18.text == "" || ingredients18 == null){
                                ingredients18.isVisible = false
                            }
                            if (ingredients19.text == "" || ingredients19 == null){
                                ingredients19.isVisible = false
                            }
                            if (ingredients20.text == "" || ingredients20 == null){
                                ingredients20.isVisible = false
                            }





                            if (measure1.text == "" || measure1 == null){
                                measure1.isVisible = false
                            }
                            if (measure2.text == "" || measure2 == null){
                                measure2.isVisible = false
                            }
                            if (measure3.text == "" || measure3 == null){
                                measure3.isVisible = false
                            }
                            if (measure4.text == "" || measure4 == null){
                                measure4.isVisible = false
                            }
                            if (measure5.text == "" || measure5 == null){
                                measure5.isVisible = false
                            }
                            if (measure6.text == "" || measure6 == null){
                                measure6.isVisible = false
                            }
                            if (measure7.text == "" || measure7 == null){
                                measure7.isVisible = false
                            }
                            if (measure8.text == "" || measure8 == null){
                                measure8.isVisible = false
                            }
                            if (measure9.text == "" || measure9 == null){
                                measure9.isVisible = false
                            }
                            if (measure10.text == "" || measure10 == null){
                                measure10.isVisible = false
                            }
                            if (measure11.text == "" || measure11 == null){
                                measure11.isVisible = false
                            }
                            if (measure12.text == "" || measure12 == null){
                                measure12.isVisible = false
                            }
                            if (measure13.text == "" || measure13 == null){
                                measure13.isVisible = false
                            }
                            if (measure14.text == "" || measure14 == null){
                                measure14.isVisible = false
                            }
                            if (measure15.text == "" || measure15 == null){
                                measure15.isVisible = false
                            }
                            if (measure16.text == "" || measure16 == null){
                                measure16.isVisible = false
                            }
                            if (measure17.text == "" || measure17 == null){
                                measure17.isVisible = false
                            }
                            if (measure18.text == "" || measure18 == null){
                                measure18.isVisible = false
                            }
                            if (measure19.text == "" || measure19 == null){
                                measure19.isVisible = false
                            }
                            if (measure20.text == "" || measure20 == null){
                                measure20.isVisible = false
                            }

                        }


                    }
                }
            }

            override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                if (t is UnknownHostException) {

                } else if (t is HttpException) {

                }
            }

        })
    }

}