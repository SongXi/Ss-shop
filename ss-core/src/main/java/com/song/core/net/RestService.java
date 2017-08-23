package com.song.core.net;


import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by ljs on 17-8-23.
 * 用于封装不同形式请求的api
 */
public interface RestService  {

  @GET
  Call<String> get(@Url String url,@QueryMap Map<String,Object> map);

  @FormUrlEncoded
  @POST
  Call<String> post(@Url String url,@FieldMap Map<String,Object> map);

  @POST
  Call<String> postRaw(@Url String url,@Body RequestBody body);

  @FormUrlEncoded
  @PUT
  Call<String> put(@Url String url,@FieldMap Map<String,Object> map);

  @POST
  Call<String> putRaw(@Url String url,@Body RequestBody body);

  @DELETE
  Call<String> delete(@Url String url, @QueryMap Map<String, Object> params);

  //下载
  @Streaming  //用于设置不把响应的内容一次夹在完.
  @GET
  Call<ResponseBody> downLoad(@Url String url,@QueryMap Map<String,Object> params);

  //上载
  @Multipart
  @POST
  Call<String> upload(@Url String url,@Part MultipartBody.Part body);
}
