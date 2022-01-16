package app.beta.myanimeapp

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object TmdbCall {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    private val tmdbApi: TmdbService by lazy {
        retrofit.create(TmdbService::class.java)
    }

    val api = TmdbClient(tmdbApi)
}