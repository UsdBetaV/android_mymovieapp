package app.beta.myanimeapp.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import app.beta.myanimeapp.R
import app.beta.myanimeapp.databinding.MovieNowPlayingItemBinding
import app.beta.myanimeapp.model.Movie
import coil.load

class MovieNowPlayingListAdapter :
    RecyclerView.Adapter<MovieNowPlayingListAdapter.MovieNowPlayingListViewHolder>() {

    inner class MovieNowPlayingListViewHolder(val viewBinding: MovieNowPlayingItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    private val asyncDiffer = AsyncListDiffer(this, diffCallback)
    var movies: List<Movie>
        get() = asyncDiffer.currentList
        set(value) {
            asyncDiffer.submitList(value)
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieNowPlayingListViewHolder {
        val viewHolder = MovieNowPlayingListViewHolder(
            MovieNowPlayingItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
        viewHolder.viewBinding.root.setOnClickListener {
            Navigation.findNavController(viewHolder.viewBinding.root)
                .navigate(MovieListFragmentDirections.doOpenDetail(movies[viewHolder.layoutPosition]))
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: MovieNowPlayingListViewHolder, position: Int) {
        val item = movies[position]
        holder.viewBinding.apply {
            movieTitle.text = item.title
            moviePoster.load(this.root.context.getString(R.string.poster_link) + item.poster_path)
            movieBackdrop.load(this.root.context.getString(R.string.backdrop_link) + item.backdrop_path)
        }

    }

    override fun getItemCount(): Int = movies.size


}