package com.dicoding.mjetpack.route

sealed class ScreenNavigation(
    val route:String
){
    object DetailFood: ScreenNavigation("home/{detailFood}"){
        fun createRoute(detailFood: Long) = "home/$detailFood"
    }
}
