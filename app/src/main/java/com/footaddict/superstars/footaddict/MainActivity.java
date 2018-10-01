package com.footaddict.superstars.footaddict;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static int[] images = {R.drawable.splash_screen};
    ListView listView;
    LeagueAdapter leagueAdapter;
    LiveAdapter liveAdapter;
    boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //viewLiveWithRequest("http://livescore-api.com/api-client/scores/live.json?key=yEcqTDm6UkJ51IqJ&secret=zVPESkhMLdIJENucrGCljZrekbjmTK5t", "Lives.json");
        viewLiveWithCache("Lives.json");
        //playSound(this, R.raw.uefa);
        //connectedToTheNetwork(this);
        BDDOpenHelper openHelper = new BDDOpenHelper(this);
        openHelper.getWritableDatabase().close();
        Country country = new Country(this,13,"Afrique","liguesAfrique","3-3","13-13");
        League league = new League(this,16,"Ligue1","3-17","6-12",13);
        Match match = new Match(this,2011,new Date(2015,10,31,12,13),new Date(2017,13,12,18,15),"2-2","Mancherter City","Lyon",16,13 );
        BDDInserter insert = new BDDInserter();
        insert.insertCountry(country);
        insert.insertLeague(league);
        insert.insertMatch(match);
    }

    public void connectedToTheNetwork(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if(activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        HttpURLConnection urlc = (HttpURLConnection)
                                (new URL("http://clients3.google.com/generate_204")
                                        .openConnection());
                        urlc.setRequestProperty("User-Agent", "Android");
                        urlc.setRequestProperty("Connection", "close");
                        urlc.setConnectTimeout(1500);
                        urlc.connect();
                        if (urlc.getResponseCode() == 204 && urlc.getContentLength() == 0)
                            isConnected = true;
                        else
                            isConnected = false;
                    } catch (IOException e) {
                        Log.e("Login Activity: ", "Error checking internet connection", e);
                    }
                }
            });
        }
    }

    private static void playSound(Context context, int soundID){
        MediaPlayer mp = MediaPlayer.create(context, soundID);
        mp.start();
    }

    //Writing also in cache
    private void viewLiveWithRequest(String url, final String fileName) {
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
                    //String jsonCache = readFromFile(fileName);
                    //Log.i("JSonInCache",jsonCache);
                    final String result = response.body().string();
                    // Setup the data source

                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           writeToFile(result, fileName);
                           try {
                               DataLive dataLive = objectMapper.readValue(result, DataLive.class);
                               Live[] list = dataLive.getData().getMatch();
                               final List<Live> lives = Arrays.asList(list);
                               // instantiate the custom list adapter
                               liveAdapter = new LiveAdapter(MainActivity.this, lives);
                               // get the ListView and attach the adapter
                               listView.setAdapter(liveAdapter);
                           }
                           catch (IOException e ) {
                               e.printStackTrace();
                           }
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
        try {
            File file = new File(getCacheDir(), fileName);
            FileInputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            if (inputStreamReader != null) {
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String result = "";
                for (result = reader.readLine(); result != null; result = reader.readLine()) {
                    System.out.println(result);
                }
                reader.close();
                return result;
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        return "";
    }

    private void viewLiveWithCache(final String fileName){
        final ObjectMapper objectMapper = new ObjectMapper();
        listView = findViewById(R.id.listView);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //String Json = readFromFile(fileName);
                try {
                    File file = new File(getCacheDir(), fileName);
                    DataLive dataLive = objectMapper.readValue(file, DataLive.class);
                    Live[] list = dataLive.getData().getMatch();
                    final List<Live> lives = Arrays.asList(list);
                    // instantiate the custom list adapter
                    liveAdapter = new LiveAdapter(MainActivity.this, lives);
                    // get the ListView and attach the adapter
                    listView.setAdapter(liveAdapter);
                }
                catch (IOException e ) {
                    e.printStackTrace();
                }
            }
        });
    }
}