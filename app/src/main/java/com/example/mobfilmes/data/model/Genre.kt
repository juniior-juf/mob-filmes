package com.example.mobfilmes.data.model

import com.google.gson.annotations.SerializedName

class Genre {

    companion object {
        const val columnId = "id"
        const val columnName = "name"
    }

    @SerializedName(columnId)
    private var _id = 0
    var id: Int
        get() = _id
        set(value) {
            _id = value
        }

    @SerializedName(columnName)
    private var _name = ""
    var name: String
        get() = _name
        set(value) {
            _name = value
        }
}