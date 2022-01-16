package app.beta.myanimeapp.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import app.beta.myanimeapp.R
import app.beta.myanimeapp.databinding.MovieDetailFragmentBinding
import coil.load

class MovieDetailFragment : Fragment(R.layout.movie_detail_fragment) {

    companion object {
        fun newInstance() = MovieDetailFragment()
    }

    //    private val viewModel: MovieViewModel by activityViewModels()
    private val args: MovieDetailFragmentArgs by navArgs()
    private lateinit var viewBinding: MovieDetailFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = MovieDetailFragmentBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = args.movies
        viewBinding.apply {
            detailBackdrop.load(getString(R.string.backdrop_link) + movie.backdrop_path)
            detailPoster.load(getString(R.string.poster_link) + movie.poster_path)
            detailTitle.text = movie.title
            detailReleaseDate.text = movie.release_date
            detailOverview.text = movie.overview
        }
    }

}