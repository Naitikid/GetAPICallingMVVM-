package com.example.retrofitwithkotlincoroutineinandroid.main.model

data class MainModel(
    val Message: String = "",
    val RecordCount: String = "",
    val Result: List<ResultX>,
    val Status: Int = 0
){
    data class ResultX(
        val CategName: String,
        val CurrencySymbol: String,
        val DealCategoryID: String,
        val DealID: String,
        val DealType: String,
        val Description: String,
        val Discount: String,
        val Image: String,
        val MemberTier: String,
        val PromoCode: String,
        val StoreID: String,
        val StoreName: String,
        val TOC: String,
        val Title: String,
        val TowerNumber: String,
        val ValidityEnd: String,
        val ValidityStart: String,
        val isFav: String
    )
}