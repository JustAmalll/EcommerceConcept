package dev.amal.ecommerceconcept.data.remote.dto

data class AllItems(
    val best_seller: List<BestSeller>,
    val home_store: List<HomeStore>
)