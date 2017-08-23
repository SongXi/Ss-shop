package com.song.core.net.download;

import android.os.AsyncTask;
import com.song.core.net.callback.IError;
import com.song.core.net.callback.IFailure;
import com.song.core.net.callback.IRequest;
import com.song.core.net.callback.ISuccess;
import com.song.core.net.callback.RestCreator;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zhaojp on 17-8-23.
 */
public class DownloadHandler {
  private final String URL;
  private  final Map<String, Object> PARAMS;
  private final IRequest REQUEST;
  private final String DOWNLOAD_DIR;
  private final String EXTENSION;
  private final String NAME;
  private final ISuccess SUCCESS;
  private final IFailure FAILURE;
  private final IError ERROR;
  public DownloadHandler(String url, Map<String ,Object> params, IRequest iRequest, String downloadDir, String extention,
      String name, ISuccess iSuccess,IFailure iFailure, IError iError) {
    URL=url;
    REQUEST=iRequest;
    DOWNLOAD_DIR=downloadDir;
    EXTENSION=extention;
    NAME=name;
    SUCCESS=iSuccess;
    FAILURE=iFailure;
    ERROR=iError;
    PARAMS=params;
  }

  public final void handleDownload() {
    if (REQUEST != null) {
      REQUEST.onRequestStart();
    }

    RestCreator
        .getService()
        .downLoad(URL, PARAMS)
        .enqueue(new Callback<ResponseBody>() {
          @Override
          public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.isSuccessful()) {
              final ResponseBody responseBody = response.body();
              final SaveFileTask task = new SaveFileTask(REQUEST, SUCCESS);
              task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                  DOWNLOAD_DIR, EXTENSION, responseBody, NAME);

              //这里一定要注意判断，否则文件下载不全
              if (task.isCancelled()) {
                if (REQUEST != null) {
                  REQUEST.onRequestEnd();
                }
              }
            } else {
              if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
              }
            }
          }

          @Override
          public void onFailure(Call<ResponseBody> call, Throwable t) {
            if (FAILURE != null) {
              FAILURE.onFailure();
            }
          }
        });
  }
}
