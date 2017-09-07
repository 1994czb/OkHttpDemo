package com.okhttp.demo.app;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/9/7.
 */

public class App extends Application {

    private static OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        okHttpClient = new OkHttpClient();
        okHttpClient =okHttpClient.newBuilder()
                .connectTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000,TimeUnit.SECONDS)
                //拦截器
//                .addInterceptor(new MyLogInterceptor())
                .build();
    }

    public static OkHttpClient okHttpClient(){
        return okHttpClient;
    }

    //拦截器,可以修改header,可以通过拦截器打印日志
//    public class MyLogInterceptor implements Interceptor {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request().newBuilder()
//                    .header("shenfen", "chinesse")
//                    .build();
//            HttpUrl url = request.url();
//            String httpUrl = url.url().toString();
//            Log.e("TAG", "============" + httpUrl);
//            Response response = chain.proceed(request);
//            int code = response.code();
//            Log.e("TAG", "============response.code() == " + code);
//
//            return response;
//        }
//    }


}
