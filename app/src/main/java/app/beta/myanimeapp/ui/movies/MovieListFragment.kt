package app.beta.myanimeapp.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import app.beta.myanimeapp.databinding.MovieListFragmentBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MovieListFragment : Fragment() {

    companion object {
        fun newInstance() = MovieListFragment()
    }

    private val viewModel: MovieViewModel by viewModels()
    private lateinit var viewBinding: MovieListFragmentBinding
    private lateinit var movieNowPlayingListAdapter: MovieNowPlayingListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = MovieListFragmentBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieNowPlayingListAdapter = MovieNowPlayingListAdapter()
        viewBinding.listNowPlaying.adapter = movieNowPlayingListAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.nowPlaying.collect {
                    movieNowPlayingListAdapter.movies = it.body()?.results!!
                }
            }
        }
    }
}