package com.arqdsis.baixarimagemtheard;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity {

    private EditText cidadeEditText;
    private TextView descricaoTextView;
    private TextView minTextView;
    private TextView maxTextView;
    private TextView humidityTextView;

    private SimpleDateFormat sdf = new SimpleDateFormat("EE");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cidadeEditText = findViewById(R.id.cidadeEditText);
        descricaoTextView = findViewById(R.id.descricaoTextView);
        maxTextView = findViewById(R.id.maxTextView);
        minTextView = findViewById(R.id.minTextView);
        humidityTextView = findViewById(R.id.humidityTextView);
    }

    public void buscar(View view) {
        String cidade = cidadeEditText.getEditableText().toString();

        StringBuilder sb = new StringBuilder("");
        sb.append(getString(R.string.url_ws));
        sb.append(cidade);
        sb.append("&appid=");
        sb.append(getString(R.string.chave));

        new BuscaJSON().execute(sb.toString());

        /*final OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(sb.toString()).build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = client.newCall(request).execute();
                    String corpo = response.body().string();
                    runOnUiThread(()->{
                        Toast.makeText(MainActivity.this,
                                corpo,
                                Toast.LENGTH_SHORT).show();
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });*/


    }

    private class BuscaJSON extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... url) {
            OkHttpClient client = new OkHttpClient();

            final Request request = new Request.Builder()
                    .url(url[0]).build();

            try {
                return client.newCall(request).execute().body().string();
            } catch (IOException e) {
                e.printStackTrace();

                return String.format("{%s : %s}","erro",e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String json) {

            try {
                JSONObject previsao = new JSONObject(json);
                JSONArray list = previsao.getJSONArray("list");
                JSONObject dia = list.getJSONObject(0);

                long dt = dia.getLong("dt");
                double min = dia.getJSONObject("temp").getDouble("min");
                double max = dia.getJSONObject("temp").getDouble("max");
                int humidade = dia.getInt("humidity");
                String descricao = dia.getJSONArray("weather").getJSONObject(0)
                        .getString("description");
                sdf.format(new Date(dt));

                descricaoTextView.setText(
                        String.format("%s : %s",sdf.format(new Date(dt)), descricao));
                minTextView.setText(Double.toString(min));
                maxTextView.setText(Double.toString(max));

                humidityTextView.setText(Integer.toString(humidade));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
