package dev.amal.ecommerceconcept.data.remote.dto

import dev.amal.ecommerceconcept.domain.model.ItemDetails

data class ProductDetailsDto(
    val CPU: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val id: String,
    val images: List<String>,
    val isFavorites: Boolean,
    val price: Int,
    val rating: Double,
    val sd: String,
    val ssd: String,
    val title: String
)

fun ProductDetailsDto.toProductDetails(): ItemDetails = ItemDetails(
    CPU = CPU,
    camera = camera,
    capacity = capacity,
    color = color,
    id = id,
    images = images,
    isFavorites = isFavorites,
    price = price,
    rating = rating,
    sd = sd,
    ssd = ssd,
    title = title
)