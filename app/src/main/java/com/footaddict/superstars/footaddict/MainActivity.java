package com.footaddict.superstars.footaddict;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    LeagueAdapter leagueAdapter;
    LiveAdapter liveAdapter;
    boolean isConnected;
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        listView = findViewById(R.id.listView);
        viewLiveWithCache("Lives.json");
        viewLiveWithRequest("http://livescore-api.com/api-client/scores/live.json?key=yEcqTDm6UkJ51IqJ&secret=zVPESkhMLdIJENucrGCljZrekbjmTK5t", "Lives.json");
        //playSound(this, R.raw.uefa);
        //connectedToTheNetwork(this);

        BDDOpenHelper openHelper = new BDDOpenHelper(this);
        openHelper.getWritableDatabase().close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.spinner_menu, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) item.getActionView();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_list_item_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                if (arg2 == 1)  {
                    League league = new League();
                    List<League> leagues = Arrays.asList(new League(), new League());
                    listView.setAdapter(new LeagueAdapter(MainActivity.this,leagues));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });
        spinner.setAdapter(adapter);
        return super.onCreateOptionsMenu(menu);
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

    private DataLive getData(String data) {
        return getData(new ByteArrayInputStream(data.getBytes()));
    }

    private DataLive getData(InputStream result){
        DataLive dataLive = new DataLive();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            dataLive = objectMapper.readValue(result, DataLive.class);
        }catch (IOException e ) {
            e.printStackTrace();
        }
        return dataLive;
    }

    //Writing also in cache
    private void viewLiveWithRequest(String url, final String fileName) {
        OkHttpClient client = MyApplication.getClient();
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
                    String data = response.body().string();
                    writeToFile(data, fileName);
                    DataLive dataLive = getData(data);
                    setLiveView(dataLive);
                }
            }
        });
    }

    private void viewLiveWithCache(final String fileName) {
        File file = new File(getCacheDir(), fileName);
        if (file.exists()) {
            try {
                DataLive dataLive = getData(new FileInputStream(file));
                setLiveView(dataLive);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Log.e("Login Activity: ", "Error with FileInputStream");
            }
        }
        else {
            Log.e("Login Activity: ", "File doesn't exist in cache");
        }
    }

    private void setLiveView(DataLive dataLive){
        Live[] list = dataLive.getData().getMatch();
        final List<Live> lives = Arrays.asList(list);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // instantiate the custom list adapter
                liveAdapter = new LiveAdapter(MainActivity.this, lives);
                // get the ListView and attach the adapter
                listView.setAdapter(liveAdapter);
            }
        });
    }

    private void writeToFile(final String data, final String fileName) {
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
}