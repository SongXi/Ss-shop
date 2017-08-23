package com.song.core.net.callback;

import com.song.core.app.ConfigType;
import com.song.core.app.SsUtils;
import com.song.core.net.RestService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.w3c.dom.ProcessingInstruction;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ljs on 17-8-23.
 */

public class RestCreator {

  public static RestService getService(){
    return RestServiceHolder.REST_SERVICE;
  }

  private static class RestServiceHolder{
     private static final RestService REST_SERVICE=RetrofitHolder.RETROFIT.create(RestService.class);
  }
  //构建Retrofit的单例
  private  static class RetrofitHolder{
    private static final String BASE_URL=SsUtils.getConfig(ConfigType.API_HOST);
    private static final  Retrofit RETROFIT=new Retrofit.Builder().baseUrl(BASE_URL).client(OkhttpHolder.OK_HTTP_CLIENT)
        .addConverterFactory(ScalarsConverterFactory.create()).build();
  }

  //构建okhttp单例
  private static class OkhttpHolder{
    private static final int TIME_OUT=60;
    private static final OkHttpClient.Builder BUILDER=new OkHttpClient.Builder();
    private static final List<Interceptor> INTERCEPTORS= SsUtils.getConfig(ConfigType.INTERCEPTS);

    private static OkHttpClient.Builder addInterceptor() {
      if (INTERCEPTORS != null && !INTERCEPTORS.isEmpty()) {
        for (Interceptor interceptor : INTERCEPTORS) {
          BUILDER.addInterceptor(interceptor);
        }
      }
      return BUILDER;
    }

    private static final OkHttpClient OK_HTTP_CLIENT=addInterceptor().connectTimeout(TIME_OUT,
        TimeUnit.SECONDS).build();
  }

}
