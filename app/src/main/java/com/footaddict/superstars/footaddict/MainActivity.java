package com.footaddict.superstars.footaddict;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private JSONObject test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        run("http://livescore-api.com/api-client/scores/history.json?key=yEcqTDm6UkJ51IqJ&secret=zVPESkhMLdIJENucrGCljZrekbjmTK5t");
    }

    private void run(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "0859e454-1a16-41bb-bcab-9d034f0594c2")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("Thread",Thread.currentThread().toString());
                Log.e("Data", "Erreur lors de la récupération des données", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("Thread",Thread.currentThread().toString());
                final String body = response.body().string();
                Log.i("Data", body);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
    }
}
