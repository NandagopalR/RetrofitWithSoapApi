package com.nanda.retrofitwithsoap.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nanda.retrofitwithsoap.R;
import com.nanda.retrofitwithsoap.model.MoviesItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandagopal on 1/8/17.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

  private Context context;
  private LayoutInflater inflater;
  private List<MoviesItem> moviesItemsList;

  public MovieAdapter(Context context) {
    this.context = context;
    inflater = LayoutInflater.from(context);
    moviesItemsList = new ArrayList<>();
  }

  public void setMoviesItemsList(List<MoviesItem> itemsList) {
    if (itemsList == null) {
      return;
    }

    moviesItemsList.clear();
    moviesItemsList.addAll(itemsList);
    notifyDataSetChanged();
  }

  @Override public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.item_movies, parent, false);
    return new MovieViewHolder(view);
  }

  @Override public void onBindViewHolder(MovieViewHolder holder, int position) {
    MoviesItem item = moviesItemsList.get(position);
    holder.setDataToView(item);
  }

  @Override public int getItemCount() {
    return moviesItemsList.size();
  }

  class MovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.movie_cover) ImageView imgMovieCover;
    @BindView(R.id.movie_title) TextView movieTitle;
    @BindView(R.id.movie_year) TextView movieYear;

    public MovieViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    public void setDataToView(MoviesItem item) {
      movieTitle.setText(
          (!TextUtils.isEmpty(item.getTitle()) || item.getTitle() != null) ? item.getTitle()
              : "NA");
      movieYear.setText(
          (!TextUtils.isEmpty(item.getYear()) || item.getYear() != null) ? item.getYear() : "NA");
      setThumbnailImage(item.getCover());
    }

    public void setThumbnailImage(String coverurl) {
      Glide.with(context)
          .load(coverurl)
          .placeholder(R.drawable.ic_placeholder_error)
          .error(R.drawable.ic_placeholder_error)
          .diskCacheStrategy(DiskCacheStrategy.ALL)
          .into(imgMovieCover);
    }
  }
}
