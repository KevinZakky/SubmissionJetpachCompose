package com.dicoding.mjetpack.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name:String,
    val description:String,
    val photo: Int
):Parcelable
