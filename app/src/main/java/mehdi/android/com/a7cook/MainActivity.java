package mehdi.android.com.a7cook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.android.volley.Response;

import java.util.List;

import data.Banners;
import data.Categories;
import data.Recipe;
import mehdi.android.com.a7cook.Adapters.BannerAdapter;
import mehdi.android.com.a7cook.Adapters.CategoriesAdapter;
import mehdi.android.com.a7cook.Adapters.RecipeAdapter;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiService = new ApiService(this);

        setUpViews();
    }

    private void setUpViews() {


        getBanners();
        getCategories();
        getRecipe();
    }

    private void getRecipe() {
        apiService.getRecipe(new Response.Listener<List<Recipe>>() {
            @Override
            public void onResponse(List<Recipe> response) {
                RecyclerView rvRecipe = findViewById(R.id.rv_main_recipes);
                rvRecipe.setNestedScrollingEnabled(false);
                rvRecipe.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL
                ));
                rvRecipe.setAdapter(new RecipeAdapter(response));
            }
        });
    }

    private void getCategories() {
        apiService.getCategories(new Response.Listener<List<Categories>>() {
            @Override
            public void onResponse(List<Categories> categories) {
                RecyclerView rvCategories = findViewById(R.id.rv_main_categories);
                rvCategories.setNestedScrollingEnabled(false);
                rvCategories.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                        LinearLayoutManager.HORIZONTAL, false));
                rvCategories.setAdapter(new CategoriesAdapter(categories));
            }
        });

    }

    public void getBanners() {
        apiService.getBanners(new Response.Listener<List<Banners>>() {
            @Override
            public void onResponse(List<Banners> banners) {
                RecyclerView bannersRv = findViewById(R.id.rv_main_slider);
                bannersRv.setNestedScrollingEnabled(false);
                bannersRv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL,
                        false));
                bannersRv.setAdapter(new BannerAdapter(banners));


                SnapHelper snapHelper = new PagerSnapHelper();
                snapHelper.attachToRecyclerView(bannersRv);
            }
        });
    }
}
