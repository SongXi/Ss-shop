package com.song.core.net;

import android.content.Context;
import com.song.core.net.callback.IError;
import com.song.core.net.callback.IFailure;
import com.song.core.net.callback.IRequest;
import com.song.core.net.callback.ISuccess;
import com.song.core.net.callback.RestCreator;
import com.song.core.net.callback.RetrofitCallBack;
import com.song.core.net.download.DownloadHandler;
import java.io.File;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by ljs on 17-8-23.
 */

public class RestClient {

    private String URL;
    private String name;
    private IError iError;
    private ISuccess iSuccess;
    private IRequest iRequest;
    private IFailure iFailure;

    private Map<String, Object> params;
    private RequestBody body;
    private Context context;
    private File file;
    private String downloadDir;
    private String extention;

    public RestClient(String URL, String name, IError iError, ISuccess iSuccess, IFailure iFailure,
            IRequest iRequest, Map<String, Object> params, File file, String downloadDir,
            String extention, RequestBody body, Context context) {
        this.URL = URL;
        this.name = name;
        this.iError = iError;
        this.iSuccess = iSuccess;
        this.iRequest = iRequest;
        this.params = params;
        this.body = body;
        this.context = context;
        this.iFailure = iFailure;
        this.file = file;
        this.downloadDir = downloadDir;
        this.extention = extention;
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
        new DownloadHandler(URL,params, iRequest, downloadDir, extention, name, iSuccess, iFailure, iError)
                .handleDownload();
    }

    public void upload() {
        request(RestMethod.UPLOAD);
    }

    private void request(RestMethod method) {

        RestService service = RestCreator.getService();
        Call<String> call = null;
        switch (method) {
            case GET:
                call = service.get(URL, params);
                break;
            case POST:
                call = service.post(URL, params);
                break;
            case POST_RAW:
                call = service.postRaw(URL, body);
                break;
            case PUT:
                call = service.put(URL, params);
                break;
            case PUT_RAW:
                call = service.putRaw(URL, body);
                break;
            case DELETE:
                call = service.delete(URL, params);
                break;
            case UPLOAD:
                final RequestBody requestBody =
                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), file);
                final MultipartBody.Part body =
                        MultipartBody.Part.createFormData("file", file.getName(), requestBody);
                call = service.upload(URL, body);
                break;
        }
        call.enqueue(new RetrofitCallBack(iRequest, iSuccess, iError, iFailure));
    }



}
