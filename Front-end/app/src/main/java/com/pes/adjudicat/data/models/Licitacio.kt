package com.pes.adjudicat.data.models

import com.google.gson.annotations.SerializedName

data class Licitacio(
    @SerializedName("ambit")
    val ambit: String? = "",
    @SerializedName("codi_cpv")
    val codiCpv: String = "598392",
    @SerializedName("data_adjudicacio_contracte")
    val dataAdjudicacioContracte: String? = "",
    @SerializedName("data_formalitzacio_contracte")
    val dataFormalitzacioContracte: String? = "",
    @SerializedName("data_publicacio_adjudicacio")
    val dataPublicacioAdjudicacio: String? = "",
    @SerializedName("data_publicacio_anunci")
    val dataPublicacioAnunci: String = "",
    @SerializedName("denominacio")
    val denominacio: String = "",
    @SerializedName("departament")
    val departament: String? = "",
    @SerializedName("duracio_contracte")
    val duracioContracte: String = "",
    @SerializedName("enllaç")
    val enllaç: String = "",
    @SerializedName("fase_publicacio")
    val fasePublicacio: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("import_adjudicacio_amb_iva")
    val importAdjudicacioAmbIva: String = "",
    @SerializedName("import_adjudicacio_sense_iva")
    val importAdjudicacioSenseIva: String = "",
    @SerializedName("lloc_execucio")
    val llocExecucio: String = "",
    @SerializedName("objecte_contracte")
    val objecteContracte: String = "",
    @SerializedName("ofertes_rebudes")
    val ofertesRebudes: Int? = 0,
    @SerializedName("organ")
    val organ: String? = "",
    @SerializedName("pressupost")
    val pressupost: String = "",
    @SerializedName("procediment")
    val procediment: String = "",
    @SerializedName("resultat")
    val resultat: String? = "",
    @SerializedName("termini_presentacio_ofertes")
    val terminiPresentacioOfertes: String = "",
    @SerializedName("tipus_contracte")
    val tipusContracte: String? = "",
    @SerializedName("valor_estimat_contracte")
    val valorEstimatContracte: String = ""
)