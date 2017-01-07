package com.nanda.retrofitwithsoap.app;

/**
 */
public class AppRepo {

  private static final String TAG = AppRepo.class.getSimpleName();
  private AppApi appApi;

  public AppRepo(AppApi appApi) {
    this.appApi = appApi;
  }

  public AppApi getApi() {
    return appApi;
  }
}
