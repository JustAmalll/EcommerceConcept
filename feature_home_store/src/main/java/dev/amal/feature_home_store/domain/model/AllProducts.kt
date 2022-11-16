package dev.amal.feature_home_store.domain.model

data class AllProducts(
    val bestSeller: List<BestSeller>,
    val homeStore: List<HomeStore>
)