package com.theim.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.theim.demo.helper.JacksonUtils;
import com.theim.demo.models.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class NewsActivity extends AppCompatActivity implements NewsAdapter.OnItemClickListener {

    private AsyncHttpClient client;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("News List");

        client = new AsyncHttpClient();
        progressBar = findViewById(R.id.progressBar);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        this.loadData();
    }

    private void loadData(){
        Log.d("DEMO_DEBUG","loadData:"+"https://www-stg.aagold-th.com/api/news-event/");
        client.get("https://www-stg.aagold-th.com/api/news-event/?page_size=100",new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                try {

                    Log.d("DEMO_DEBUG",response.toString());
                    List<News> news = null;
                    try {
                        news = JacksonUtils.parseArray(response.getJSONArray("results").toString(), News.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    mAdapter = new NewsAdapter(news,NewsActivity.this);
                    recyclerView.setAdapter(mAdapter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStart() {
                super.onStart();
                Log.d("DEMO_DEBUG","onStart:");
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                Log.d("DEMO_DEBUG","onFinish:");
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d("DEMO_DEBUG","onFailure:"+errorResponse.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);

                Log.d("DEMO_DEBUG","onFailure:"+responseString);
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
    public void onItemClick(News item) {

        Intent intent = new Intent(this,NewsDetailActivity.class);
        intent.putExtra("news_id",item.getId());
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
