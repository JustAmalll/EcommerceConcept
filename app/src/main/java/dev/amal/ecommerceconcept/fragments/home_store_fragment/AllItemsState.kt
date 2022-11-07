package dev.amal.ecommerceconcept.fragments.home_store_fragment

import dev.amal.ecommerceconcept.data.remote.dto.AllItems

data class AllItemsState(
    val isLoading: Boolean = false,
    val allItems: AllItems? = null,
    val error: String = ""
)