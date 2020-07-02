package edu.uc.kansakpb.ikeahjalpare3.dto

import com.google.gson.annotations.SerializedName

data class Furniture(@SerializedName("furniture_name") var furnitureName: String, @SerializedName("intructions_manuel")var instructionsManuel: String, @SerializedName("video_link")var videoLink: String) {
    //formated like Furniture Name, link and intructions link
    override fun toString(): String {
        return videoLink
    }
}