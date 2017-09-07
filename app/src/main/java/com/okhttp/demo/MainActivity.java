package com.okhttp.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.okhttp.demo.app.App;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okHttpClient = App.okHttpClient();
    }

    //get请求同步加载数据
    public void get(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url("http://www.baidu.com")
                        .build();
                try {

//                    Call call = okHttpClient.newCall(request);
                    Response response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()){
                        //通过response.body().string()拿到服务器给我们的json
//                        String json = response.body().string();

                        //通过response.body().inputStream拿到服务器给我们的输入流 -- 主要用在大文件
//                        InputStream inputStream = response.body().byteStream();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "get同步成功", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "get同步失败", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //get请求异步加载数据
    public void getAsyc(View view) {
        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "get异步失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.isSuccessful()){
                    //通过response.body().string()拿到服务器给我们的json
//                        String json = response.body().string();

                    //通过response.body().inputStream拿到服务器给我们的输入流 -- 主要用在大文件
//                        InputStream inputStream = response.body().byteStream();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "get异步成功", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });
    }

    //post请求同步加载数据
    public void post(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                RequestBody formBody = new FormBody.Builder()
                        .add("type", "yuantong")
                        .add("postid", "11111111111")
                        .build();
                Request request = new Request.Builder()
                        .url("http://www.kuaidi100.com/query")
                        .post(formBody)
                        .build();
                try {

//                    Call call = okHttpClient.newCall(request);
                    Response response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()){
                        //通过response.body().string()拿到服务器给我们的json
//                        String json = response.body().string();

                        //通过response.body().inputStream拿到服务器给我们的输入流 -- 主要用在大文件
//                        InputStream inputStream = response.body().byteStream();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "post同步成功", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "post同步失败", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //post请求异步加载数据
    public void postAsyc(View view) {
        RequestBody formBody = new FormBody.Builder()
                .add("type", "yuantong")
                .add("postid", "11111111111")
                .build();
        Request request = new Request.Builder()
                .url("http://www.kuaidi100.com/query")
                .post(formBody)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "post异步失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.isSuccessful()){
                    //通过response.body().string()拿到服务器给我们的json
//                        String json = response.body().string();

                    //通过response.body().inputStream拿到服务器给我们的输入流 -- 主要用在大文件
//                        InputStream inputStream = response.body().byteStream();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "post异步成功", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });
    }
}
