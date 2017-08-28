package com.song.core.net;

import android.content.Context;
import com.song.core.net.callback.IError;
import com.song.core.net.callback.IFailure;
import com.song.core.net.callback.IRequest;
import com.song.core.net.callback.ISuccess;
import java.io.File;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by zhaojp on 17-8-23.
 */

public class RestClientBuilder {

    private String URL;
    private String name;
    private IError iError;
    private ISuccess iSuccess;
    private IRequest iRequest;
    private Map<String, Object> params;
    private RequestBody body;
    private Context context;
    private IFailure iFailure;
    private File file;
    private String downloadDir;
    private String extention;

    public RestClientBuilder setFile(File file) {
        this.file = file;
        return this;

    }

    public RestClientBuilder setDownloadDir(String downloadDir) {
        this.downloadDir = downloadDir;
        return this;

    }

    public RestClientBuilder setExtention(String extention) {
        this.extention = extention;
        return this;

    }

    public RestClientBuilder url(String URL) {
        this.URL = URL;
        return this;

    }

    public RestClientBuilder name(String name) {
        this.name = name;
        return this;
    }

    public RestClientBuilder error(IError iError) {
        this.iError = iError;
        return this;
    }

    public RestClientBuilder success(ISuccess iSuccess) {
        this.iSuccess = iSuccess;
        return this;
    }

    public RestClientBuilder request(IRequest iRequest) {
        this.iRequest = iRequest;
        return this;
    }

    public RestClientBuilder params(Map<String, Object> params) {
        this.params = params;
        return this;
    }

    public RestClientBuilder rowBody(String body) {
        this.body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), body);
        return this;
    }

    public RestClientBuilder context(Context context) {
        this.context = context;
        return this;
    }

    public RestClientBuilder setiFailure(IFailure iFailure) {
        this.iFailure = iFailure;
        return this;
    }

    public RestClient build() {
        return new RestClient(URL, name, iError, iSuccess, iFailure, iRequest, params,file, downloadDir,extention,body,
                context);
    }

}
