package com.theim.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;
import com.theim.demo.helper.JacksonUtils;
import com.theim.demo.models.News;

import org.json.JSONObject;

import java.io.IOException;

import cz.msebera.android.httpclient.Header;

public class NewsDetailActivity extends AppCompatActivity {

    private AsyncHttpClient client;
    private int news_id;
    private ImageView imageView;
    private TextView textViewTitle,textViewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("News Detail");

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewDetail = findViewById(R.id.textViewDetail);
        imageView = findViewById(R.id.imageView);

        news_id = getIntent().getIntExtra("news_id",0);
        client = new AsyncHttpClient();

        this.loadDetail();
    }

    private void loadDetail(){

        client.get("https://www-stg.aagold-th.com/api/news-event/"+news_id+"/",new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                try {
                    News item = JacksonUtils.parse(response.toString(), News.class);
                    textViewTitle.setText(item.getTitle());
                    textViewDetail.setText(Html.fromHtml(item.getDetail()));

                    Picasso.get().load(item.getImage()).into(imageView);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(client!=null)
            client.cancelAllRequests(true);
    }

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
