package edu.uc.kansakpb.ikeahjalpare3.dto

import com.google.gson.annotations.SerializedName

data class Furniture(
    @SerializedName("id")var id:Int,
    @SerializedName("video_link")var videoLink: String,
    @SerializedName("article_number")var articleNumber: String,
    @SerializedName("furniture_name") var furnitureName: String,
    @SerializedName("instructions_manual")var instructionsManual: String
) {
    //formatted like Furniture Name, link and instructions link
    override fun toString(): String {
        return "$furnitureName $id $videoLink $articleNumber $instructionsManual"
    }
}