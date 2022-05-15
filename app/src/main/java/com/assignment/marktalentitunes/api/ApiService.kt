package com.assignment.marktalentitunes.api

import com.assignment.marktalentitunes.model.ResultSongListing

interface ApiService {

    @GET("search?term=country&amp;media=music&entity=song&limit=50")
    fun getSongListing(
        //@Query("results") results: Int = 50
    ): Call<ResultSongListing>


    companion object {
        private var instance: Retrofit? = null


        fun createRetrofit(): Retrofit {
            if (instance == null) {
                instance =
                    Retrofit.Builder()
                        .baseUrl("https://itunes.apple.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return instance!!
        }
    }


}