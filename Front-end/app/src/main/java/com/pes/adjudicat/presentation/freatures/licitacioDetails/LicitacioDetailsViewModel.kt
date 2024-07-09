package com.pes.adjudicat.presentation.freatures.licitacioDetails

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pes.adjudicat.data.models.Licitacio
import com.pes.adjudicat.network.APIservices
import kotlinx.coroutines.launch

class LicitacioDetailsViewModel(
    id : Int
) : ViewModel()  {

    //var licitacio : Licitacio? = getLicitacioDetails(id)
    private val _licitacio = MutableLiveData<Licitacio>()
    val licitacio: LiveData<Licitacio>
        get() = _licitacio


    var errorMessage: String by mutableStateOf("")

    private fun getLicitacioDetails(
        id:Int
    ) {
        viewModelScope.launch {
            val apiService = APIservices.getInstance()
            _licitacio.value = apiService.getLicitacioInfo(id)
        }
    }

    init {
        getLicitacioDetails(id)
    }
}