package com.nanda.retrofitwithsoap.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.nanda.retrofitwithsoap.R;
import com.nanda.retrofitwithsoap.adapter.MovieAdapter;
import com.nanda.retrofitwithsoap.app.AppController;
import com.nanda.retrofitwithsoap.app.AppRepo;
import com.nanda.retrofitwithsoap.datamodel.Movies;
import com.nanda.retrofitwithsoap.datamodel.mapper.MovieMapper;
import com.nanda.retrofitwithsoap.model.MoviesItem;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.recyclerview) RecyclerView recyclerView;

  private AppRepo appRepo;
  private MovieAdapter adapter;
  private ProgressDialog progressDialog;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    appRepo = AppController.getInstance().getAppRepo();

    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    adapter = new MovieAdapter(this);
    recyclerView.setAdapter(adapter);

    getMoviesResponse();
  }

  private void getMoviesResponse() {
    progressDialog = new ProgressDialog(this);
    progressDialog.setMessage("Loading...");
    progressDialog.show();
    Call<List<Movies>> call = appRepo.getApi().getMoviesList();
    call.enqueue(new Callback<List<Movies>>() {
      @Override public void onResponse(Call<List<Movies>> call, Response<List<Movies>> response) {

        if (response.isSuccessful()) {
          if (response.body() == null) return;
          List<MoviesItem> moviesItemList = MovieMapper.convertDataModelToItem(response.body());
          adapter.setMoviesItemsList(moviesItemList);
          if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
        }
      }

      @Override public void onFailure(Call<List<Movies>> call, Throwable throwable) {
        Log.e("Exception", "onFailure: " + throwable.getMessage());
        if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
      }
    });
  }
}
