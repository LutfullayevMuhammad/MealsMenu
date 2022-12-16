package uz.lutfullayevmuhammad.lesson46.core.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import uz.lutfullayevmuhammad.lesson46.core.models.category.CategoryResponse
import uz.lutfullayevmuhammad.lesson46.core.models.meals.MealsResponse
import uz.lutfullayevmuhammad.lesson46.core.models.subCategory.SubCategoryResponse

interface ApiMethods {

    @GET("api/json/v1/1/categories.php")
    fun getCategories(
        @Query("c") category: String
    ): Call<CategoryResponse>

    @GET("api/json/v1/1/filter.php")
    fun getSubCategories(
        @Query("c") category: String
    ): Call<SubCategoryResponse>

    @GET("api/json/v1/1/lookup.php")
    fun getMeals(
        @Query("i") category: String
    ): Call<MealsResponse>

    @GET("api/json/v1/1/filter.php?c=Seafood")
    fun getMeal():Call<Any>

}