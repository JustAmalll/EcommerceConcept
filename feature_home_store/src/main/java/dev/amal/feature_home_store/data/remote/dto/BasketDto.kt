package dev.amal.feature_home_store.data.remote.dto

data class BasketDto(
    val basket: List<BasketInfoDto>,
    val delivery: String,
    val id: String,
    val total: Int
)
