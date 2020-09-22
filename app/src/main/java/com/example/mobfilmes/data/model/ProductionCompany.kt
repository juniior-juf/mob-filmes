package com.example.mobfilmes.data.model

import com.google.gson.annotations.SerializedName

class ProductionCompany{

    companion object{
        const val columnId = "id"
        const val columnLogoPath = "logo_path"
        const val columnName = "name"
        const val columnOriginCountry = "origin_country"
    }

    @SerializedName(columnId)
    private var _id = 0
    var id: Int
        get() = _id
        set(value) {
            _id = value
        }

    @SerializedName(columnLogoPath)
    private var _logoPath = ""
    var logoPath: String
        get() = _logoPath
        set(value) {
            _logoPath = value
        }

    @SerializedName(columnName)
    private var _name = ""
    var name: String
        get() = _name
        set(value) {
            _name = value
        }

    @SerializedName(columnOriginCountry)
    private var _originCountry = ""
    var originCountry: String
        get() = _originCountry
        set(value) {
            _originCountry = value
        }
}