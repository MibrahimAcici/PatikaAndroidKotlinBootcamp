package com.ibrahim.week4.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlanetListItem(

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("img_src")
	val imgSrc: String? = null
):Parcelable
