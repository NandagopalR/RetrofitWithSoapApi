package com.nanda.retrofitwithsoap.app;

import android.app.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nanda.retrofitwithsoap.helper.SSLHelper;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nandagopal on 12/26/16.
 */
public class AppController extends Application {

  private static AppController appController;
  private SSLHelper sslHelper;
  private Gson gson;
  private AppRepo appRepo;

  @Override public void onCreate() {
    super.onCreate();

    appController = this;
    sslHelper = new SSLHelper(this);

    gson = new GsonBuilder().create();
  }

  public static AppController getInstance() {
    return appController;
  }

  public AppRepo getAppRepo() {
    if (appRepo == null) appRepo = createAppRepo();
    return appRepo;
  }

  private AppRepo createAppRepo() {
    OkHttpClient httpClient = new OkHttpClient.Builder().sslSocketFactory(sslHelper.getSSlContext())
        .addInterceptor(sslHelper.getHttpLoggingInterceptor())
        .hostnameVerifier(sslHelper.getHostNameVerifier())
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build();

    Retrofit retrofit = new Retrofit.Builder().client(httpClient)
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
    return new AppRepo(retrofit.create(AppApi.class));
  }
}
