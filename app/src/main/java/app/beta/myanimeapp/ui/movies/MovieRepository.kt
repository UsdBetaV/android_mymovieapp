package app.beta.myanimeapp.ui.movies

import app.beta.myanimeapp.TmdbCall
import app.beta.myanimeapp.model.Movie
import app.beta.myanimeapp.model.TmdbResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MovieRepository {

//
//    val moviesNowPlaying: Flow<Response<TmdbResponse<List<Movie>>>> = flow {
//        val movies = tmdbService.getNowPlaying()
//        emit(movies)
//    }

    val moviesNowPlaying: Flow<Response<TmdbResponse<List<Movie>>>> = flow {
        val request = TmdbCall.api.getNowPlaying()
        emit(request)
    }
}