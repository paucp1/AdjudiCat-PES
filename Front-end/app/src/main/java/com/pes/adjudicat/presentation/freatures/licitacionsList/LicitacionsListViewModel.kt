package com.pes.adjudicat.presentation.freatures.licitacionsList

import android.net.Uri
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pes.adjudicat.data.models.ShortLicitacio
import com.pes.adjudicat.network.APIservices
import kotlinx.coroutines.launch

/**
 * View Model que conte i controla la llista de licitacions
 */
class LicitacionsListViewModel:ViewModel() {

    //Llista de licitacions privada i mutable
    //private val _licitacionsList : MutableState<MutableList<ShortLicitacio>> = mutableStateOf(
    //    mutableListOf()
    //)

    //Llista de licitacions publica
    //al licitacionsList : State<List<ShortLicitacio>> = _licitacionsList

    private val _licitacions = mutableStateListOf<ShortLicitacio>()
    var errorMessage: String by mutableStateOf("")
    val licitacions: List<ShortLicitacio>
        get() = _licitacions

    var offset: String? = null
    var limit: String? = null

    init {
        getLicitacions()
    }

    //This function gets the api services and
    fun getLicitacions() {
        viewModelScope.launch {
            val apiService = APIservices.getInstance()
            try {
                _licitacions.clear()
                val response = apiService.getLicitacions()

                _licitacions.addAll(response.results)
                val tempNext: Uri = Uri.parse(response.next)
                offset = tempNext.getQueryParameter("offset")
                limit = tempNext.getQueryParameter("limit")


            } catch (e: Exception) {
                println(e.message.toString())
                errorMessage = e.message.toString()
            }
        }
    }

    fun loadMore() {
        viewModelScope.launch {
            val apiService = APIservices.getInstance()
            try {
                val response = apiService.loadMore(offset, limit)
                //print(temp_lici)

                val tempNext: Uri = Uri.parse(response.next)
                offset = tempNext.getQueryParameter("offset")
                limit = tempNext.getQueryParameter("limit")

                _licitacions.addAll(response.results)

            } catch (e: Exception) {
                println(e.message.toString())
                errorMessage = e.message.toString()
            }
        }
    }
}