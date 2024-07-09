package com.pes.adjudicat.network

import com.pes.adjudicat.data.LicitacionsListResponse
import com.pes.adjudicat.data.models.Licitacio
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

//url del server
const val BASE_URL = "http://nattech.fib.upc.edu:40410/api/"

/**
 * Interficie que fa les peticions al server
 */
interface APIservices {

    //obte una llista de licitacions

    @GET("licitacions_publiques")
    suspend fun getLicitacions(): LicitacionsListResponse

    @GET("licitacions_publiques")
    suspend fun loadMore(
        @Query("offset") offset: String?,
        @Query("limit") limit: String?,
    ): LicitacionsListResponse


    @Headers("Accept: application/json")
    @GET("licitacions_publiques/{id}")
    suspend fun getLicitacioInfo(
        @Path("id") id: Int,
    ): Licitacio?



    //TODO: afegir resta de crides i crear una classe que cridi a la funcio i retorni l'error

    //objecte que te la conneccio amb el server
    companion object {
        var apiService: APIservices? = null
        fun getInstance(): APIservices {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIservices::class.java)
            }
            return apiService!!
        }
    }

}