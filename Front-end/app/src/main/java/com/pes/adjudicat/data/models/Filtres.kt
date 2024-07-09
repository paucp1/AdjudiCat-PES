package com.pes.adjudicat.data.models

import java.util.Date

/**
 * Classe de data que guarde unicament la informacio del filtre
 */
data class Filtres (
    var ambit: String,
    var tipus_licitacio_publica: Boolean,
    var tipus_licitacio_privada: Boolean,
    var tipus_contracte: MutableList<String>,
    var pressupost: Int,
    var duracio_en_dies: Int,
    var data_inici_interval: String,
    var data_fi_interval: String,
    var localitzacio: String,
    var fi_presentacio: String

)