package com.nanda.retrofitwithsoap.app;

import com.nanda.retrofitwithsoap.datamodel.Movies;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nandagopal on 12/26/16.
 */

public interface AppApi {

  @GET(AppConstants.GET_MOVIES_LIST) Call<List<Movies>> getMoviesList();
}
