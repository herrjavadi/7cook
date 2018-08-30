package mehdi.android.com.a7cook.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import data.Categories;
import mehdi.android.com.a7cook.R;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder> {

    private List<Categories> categoriesList;

    public CategoriesAdapter(List<Categories> categoriesList) {

        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public CategoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);

        return new CategoriesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesHolder holder, int position) {
            holder.onBindCategories(categoriesList.get(position));
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class CategoriesHolder extends RecyclerView.ViewHolder {
        private ImageView circleImageView;
        private TextView textView;

        public CategoriesHolder(View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.circleImageView_category);
            textView = itemView.findViewById(R.id.tv_category_title);


        }

        public void onBindCategories(Categories categories) {
            Picasso.get().load(categories.getImg()).into(circleImageView);
            textView.setText(categories.getTitle());
        }
    }
}
