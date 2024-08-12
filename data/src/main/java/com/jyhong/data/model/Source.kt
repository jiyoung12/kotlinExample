package com.jyhong.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkSource(
    val id: String,
    val name: String
)