package com.android.qualtechassignment.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Translations {

    @SerializedName("de")
    @Expose
    var de: String? = null
    @SerializedName("es")
    @Expose
    var es: String? = null
    @SerializedName("fr")
    @Expose
    var fr: String? = null
    @SerializedName("ja")
    @Expose
    var ja: String? = null
    @SerializedName("it")
    @Expose
    var it: String? = null

}
