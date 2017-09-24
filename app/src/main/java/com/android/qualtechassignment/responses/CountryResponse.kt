package com.android.qualtechassignment.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CountryResponse {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("topLevelDomain")
    @Expose
    var topLevelDomain: List<String>? = null
    @SerializedName("alpha2Code")
    @Expose
    var alpha2Code: String? = null
    @SerializedName("alpha3Code")
    @Expose
    var alpha3Code: String? = null
    @SerializedName("callingCodes")
    @Expose
    var callingCodes: List<String>? = null
    @SerializedName("capital")
    @Expose
    var capital: String? = null
    @SerializedName("altSpellings")
    @Expose
    var altSpellings: List<String>? = null
    @SerializedName("relevance")
    @Expose
    var relevance: String? = null
    @SerializedName("region")
    @Expose
    var region: String? = null
    @SerializedName("subregion")
    @Expose
    var subregion: String? = null
    @SerializedName("population")
    @Expose
    var population: Int? = null
    @SerializedName("latlng")
    @Expose
    var latlng: List<Int>? = null
    @SerializedName("demonym")
    @Expose
    var demonym: String? = null
    @SerializedName("area")
    @Expose
    var area: Int? = null
    @SerializedName("gini")
    @Expose
    var gini: Double? = null
    @SerializedName("timezones")
    @Expose
    var timezones: List<String>? = null
    @SerializedName("borders")
    @Expose
    var borders: List<String>? = null
    @SerializedName("nativeName")
    @Expose
    var nativeName: String? = null
    @SerializedName("numericCode")
    @Expose
    var numericCode: String? = null
    @SerializedName("currencies")
    @Expose
    var currencies: List<String>? = null
    @SerializedName("languages")
    @Expose
    var languages: List<String>? = null
    @SerializedName("translations")
    @Expose
    var translations: Translations? = null

}
