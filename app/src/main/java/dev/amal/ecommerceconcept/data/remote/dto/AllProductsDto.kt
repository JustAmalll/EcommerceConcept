package dev.amal.ecommerceconcept.data.remote.dto

import dev.amal.ecommerceconcept.domain.model.AllProducts

data class ProductsDto(
    val best_seller: List<BestSellerDto>,
    val home_store: List<HomeStoreDto>
)

fun ProductsDto.toAllProductItems(): AllProducts = AllProducts(
    bestSeller = best_seller.map { it.toBestSeller() },
    homeStore = home_store.map { it.toHomeStore() }
)