package mehdi.android.com.a7cook.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import data.Banners;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.MyViewHolder> {
    private List<Banners> bannersList;

    public BannerAdapter(List<Banners> bannersList) {
        this.bannersList = bannersList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        imageView.setAdjustViewBounds(true);
        return new MyViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBindViewHolder(bannersList.get(position));

    }

    @Override
    public int getItemCount() {
        return bannersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView bannerImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            bannerImageView = (ImageView) itemView;
        }

        public void onBindViewHolder(Banners banners) {
            Picasso.get().load(banners.getImg()).into(bannerImageView);

        }
    }
}
