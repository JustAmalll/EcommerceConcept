package dev.amal.feature_home_store.data.remote.dto

import dev.amal.feature_home_store.domain.model.AllProducts

data class AllProductsDto(
    val best_seller: List<BestSellerDto>,
    val home_store: List<HomeStoreDto>
)

fun AllProductsDto.toAllProductItems(): AllProducts = AllProducts(
    bestSeller = best_seller.map { it.toBestSeller() },
    homeStore = home_store.map { it.toHomeStore() }
)