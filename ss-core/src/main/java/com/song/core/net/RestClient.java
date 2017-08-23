package com.song.core.net;

import android.content.Context;
import com.song.core.net.callback.IError;
import com.song.core.net.callback.IRequest;
import com.song.core.net.callback.ISuccess;
import com.song.core.net.callback.RestCreator;
import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by ljs on 17-8-23.
 */

public class RestClient {

    private String URL;
    private String Name;
    private IError iError;
    private ISuccess iSuccess;
    private IRequest iRequest;
    private Map<String, Object> params;
    private RequestBody body;
    private Context context;

    public RestClient(String URL, String name, IError iError, ISuccess iSuccess, IRequest iRequest,
            Map<String, Object> params, RequestBody body, Context context) {
        this.URL = URL;
        Name = name;
        this.iError = iError;
        this.iSuccess = iSuccess;
        this.iRequest = iRequest;
        this.params = params;
        this.body = body;
        this.context = context;
    }

    public void get() {
        request(RestMethod.GET);

    }

    public void post() {
        request(RestMethod.POST);
    }

    public void postRaw() {
        request(RestMethod.POST_RAW);
    }

    public void put() {
        request(RestMethod.PUT);
    }

    public void putRaw() {
        request(RestMethod.PUT_RAW);
    }

    public void delete() {
        request(RestMethod.DELETE);
    }

    public void download() {
        request(RestMethod.DOWNLOAD);
    }

    public void upload() {
        request(RestMethod.UPLOAD);
    }

    private void request(RestMethod method) {

        RestService service = RestCreator.getService();
      Call<String> call;
      switch (method) {
            case GET:
              call= service.get(URL, params);
              break;
            case POST:
              call= service.post(URL,params);
                break;
            case POST_RAW:
              call=service.postRaw(URL,body);
                break;
            case PUT:
              call=service.put(URL,params);
                break;
            case PUT_RAW:
              call=service.putRaw(URL,body);
                break;
            case DELETE:
              call=service.delete(URL,params);
                break;
            case DOWNLOAD:
                break;
            case UPLOAD:
                break;

        }
    }



}
