package com.footaddict.superstars.footaddict;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static int[] images = {R.drawable.splash_screen};
    ListView listView;
    LeagueAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);             //,"Leagues.json"
        run("http://livescore-api.com/api-client/leagues/list.json?key=yEcqTDm6UkJ51IqJ&secret=zVPESkhMLdIJENucrGCljZrekbjmTK5t");
        //playSound(this, R.raw.uefa);
    }

    private static void playSound(Context context, int soundID){
        MediaPlayer mp = MediaPlayer.create(context, soundID);
        mp.start();
    }
 //final String fileName
    private void run(String url) {
        OkHttpClient client = MyApplication.getClient();
        final ObjectMapper objectMapper = new ObjectMapper();
        listView = findViewById(R.id.listView);

        // Request for get list of all league
        Request request = new Request.Builder()
                .url(url)
                .build();

        //Call http request
        client.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.e("Exception", "Http connection failed ");
            }

            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    // do something wih the result
                    //writeToFile(response.body().string(), fileName);
                    //String JsonLeague = readFromFile("Leagues.json");
                    //Log.i("JSonInCache",readFromFile("Leagues.json"));
                    String result = response.body().string();
                    // Setup the data source
                    //List<ListLeague> itemsArrayList = ListLeague.getLeague() ; // calls function to get items list

                   DataLeague dataLeague = objectMapper.readValue(result, DataLeague.class);
                        //ListLeague leagues = league.getData();
                        League[] list = dataLeague.getData().getLeague();
                        final List<League> leagues = Arrays.asList(list);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // instantiate the custom list adapter
                                adapter = new LeagueAdapter(MainActivity.this, leagues);

                                // get the ListView and attach the adapter
                                listView.setAdapter(adapter);
                            }
                        });
                }
            }
        });
    }

    private void writeToFile(String data, String fileName) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(getCacheDir(), fileName)));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile(String fileName) {
        String result = "";
        String receiveString = "";

        try {
            InputStream inputStream = openFileInput(fileName);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                result = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        return result;
    }
}