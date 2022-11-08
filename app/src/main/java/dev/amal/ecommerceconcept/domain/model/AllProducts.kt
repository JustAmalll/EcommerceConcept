package dev.amal.ecommerceconcept.domain.model

data class AllProducts(
    val bestSeller: List<BestSeller>,
    val homeStore: List<HomeStore>
)