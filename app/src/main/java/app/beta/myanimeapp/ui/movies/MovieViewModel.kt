package app.beta.myanimeapp.ui.movies

import androidx.lifecycle.ViewModel

class MovieViewModel : ViewModel() {

    private val movieRepository = MovieRepository()
    val nowPlaying = movieRepository.moviesNowPlaying

//    fun loadNowPlaying() {
//        viewModelScope.launch(Dispatchers.IO) {
//            movieRepository.moviesNowPlaying.collect { movies ->
//                {
//
//                }
//            }
//        }
//    }
}