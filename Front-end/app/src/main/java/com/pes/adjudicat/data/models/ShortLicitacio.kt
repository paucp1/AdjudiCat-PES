package com.pes.adjudicat.data.models

import com.google.gson.annotations.SerializedName

/**
 * Classe de data que guarde unicament la informacio de una licitacio dins de la llista
 */
data class ShortLicitacio (
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("denominacio")
    val denominacio: String? = null,

    @field:SerializedName("tipus_contracte")
    val tipusContracte: String = "",

    @field:SerializedName("lloc_execucio")
    val llocExecucio: String? = null,

    @field:SerializedName("pressupost")
    val pressupost: String? = null,

    val saved: Boolean = false

)