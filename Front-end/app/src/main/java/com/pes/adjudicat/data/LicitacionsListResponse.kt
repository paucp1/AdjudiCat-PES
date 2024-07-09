package com.pes.adjudicat.data

import com.google.gson.annotations.SerializedName
import com.pes.adjudicat.data.models.ShortLicitacio

data class LicitacionsListResponse(
    val status: String,

    val count: Int,
    val next: String,
    val previous: String?,

    @field:SerializedName("results")
    val results: List<ShortLicitacio>,
)
