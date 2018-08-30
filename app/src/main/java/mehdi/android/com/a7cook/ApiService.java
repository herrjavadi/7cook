package mehdi.android.com.a7cook;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

import data.Banners;
import data.Categories;
import data.Recipe;

public class ApiService {
    private Context context;


    public ApiService(Context context) {
        this.context = context;
    }

    public void getRecipe(Response.Listener<List<Recipe>> listListener) {

        GsonRequest<List<Recipe>> request = new GsonRequest<>(Request.Method.GET,
                "https://api.myjson.com/bins/n7bxs",
                new TypeToken<List<Recipe>>() {
                }.getType(),
                listListener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "your Network is busy", Toast.LENGTH_LONG);

                    }
                });
        Volley.newRequestQueue(context).add(request);

    }

    public void getCategories(Response.Listener<List<Categories>> listListener) {

        GsonRequest<List<Categories>> request = new GsonRequest<>(Request.Method.GET,
                "https://api.myjson.com/bins/v0bog",
                new TypeToken<List<Categories>>() {
                }.getType(),
                listListener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "your Network is busy", Toast.LENGTH_LONG);

                    }
                }
        );
        Volley.newRequestQueue(context).add(request);


    }

    public void getBanners(Response.Listener<List<Banners>> listListener) {

        GsonRequest<List<Banners>> request = new GsonRequest<>(Request.Method.GET,
                "https://api.myjson.com/bins/110sw0",
                new TypeToken<List<Banners>>() {
                }.getType(),
                listListener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "your Network is busy", Toast.LENGTH_LONG);
                    }
                });
        Volley.newRequestQueue(context).add(request);

    }

}

