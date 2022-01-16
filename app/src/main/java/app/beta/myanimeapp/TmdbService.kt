package app.beta.myanimeapp

import app.beta.myanimeapp.model.Movie
import app.beta.myanimeapp.model.TmdbResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface TmdbService {

//    companion object {
//        operator fun invoke() {
//            Retrofit.Builder()
//                .baseUrl("https://api.themoviedb.org/3/")
//                .addConverterFactory(MoshiConverterFactory.create())
//                .build()
//                .create(TmdbService::class.java)
//        }
//    }

    @GET("movie/now_playing")
    suspend fun getNowPlaying(@Query("api_key") api_key: String = "9bffb51ae01ac9564f9a1a741568b2fd"): Response<TmdbResponse<List<Movie>>>
}