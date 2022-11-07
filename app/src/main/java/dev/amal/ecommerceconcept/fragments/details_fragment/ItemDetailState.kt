package dev.amal.ecommerceconcept.fragments.details_fragment

import dev.amal.ecommerceconcept.domain.model.ItemDetails

data class ItemDetailState(
    val isLoading: Boolean = false,
    val item: ItemDetails? = null,
    val error: String = ""
)