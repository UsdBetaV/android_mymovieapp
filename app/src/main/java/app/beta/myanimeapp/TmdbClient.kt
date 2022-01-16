package app.beta.myanimeapp

import app.beta.myanimeapp.model.Movie
import app.beta.myanimeapp.model.TmdbResponse
import retrofit2.Response

class TmdbClient(private val tmdbService: TmdbService) {

    suspend fun getNowPlaying(): Response<TmdbResponse<List<Movie>>> {
        return tmdbService.getNowPlaying()
    }
}