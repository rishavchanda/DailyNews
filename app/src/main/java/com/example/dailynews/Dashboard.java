package com.example.dailynews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Dashboard extends AppCompatActivity {

    RecyclerView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        content=findViewById(R.id.content);
        RequestQueue requestQueue = Volley.newRequestQueue(Dashboard.this);

        final ArrayList<NewsHolder> newsHolder = new ArrayList<>();
        final NewsAdapter adapter = new NewsAdapter(Dashboard.this,newsHolder);

        String url = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=208e9e56bf954a6eb1e3f9eac830f3b9";
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray newsJasonArray = response.getJSONArray("articles");
                            ArrayList<NewsHolder> newsArray = new ArrayList<>();
                            for(int i=0;i<newsJasonArray.length();i++){
                                JSONObject newsjsonObject = newsJasonArray.getJSONObject(i);
                                NewsHolder news = new NewsHolder();
                                news.setNewsHeadline(newsjsonObject.getString("title"));
                                news.setNewsLines(newsjsonObject.getString("description"));
                                news.setNewsImage(newsjsonObject.getString("urlToImage"));
                                newsHolder.add(news);
                                newsArray.add(news);
                            }
                            newsHolder.clear();
                            adapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            Toast.makeText(Dashboard.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Dashboard.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
        content.setLayoutManager(new GridLayoutManager(Dashboard.this,1));
        content.setAdapter(adapter);
    }
}