package mehdi.android.com.a7cook.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import data.Recipe;
import mehdi.android.com.a7cook.R;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    private List<Recipe> recipeList;

    public RecipeAdapter(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecipeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.onBindViewholder(recipeList.get(position));
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView iconTitle;
        private TextView description;
        private TextView author;
        private RatingBar ratingBar;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_recipe_title);
            iconTitle = itemView.findViewById(R.id.iv_recip);
            description = itemView.findViewById(R.id.tv_recipe_description);
            author = itemView.findViewById(R.id.tv_recipe_author);
            ratingBar=itemView.findViewById(R.id.RatingBar_recip);
        }

        public void onBindViewholder(Recipe recipe) {
            title.setText(recipe.getTitle());
            Picasso.get().load(recipe.getImg()).into(iconTitle);
            description.setText(recipe.getDesc());
            author.setText("By " + recipe.getBy());
            ratingBar.setRating(recipe.getRate());
        }
    }
}
