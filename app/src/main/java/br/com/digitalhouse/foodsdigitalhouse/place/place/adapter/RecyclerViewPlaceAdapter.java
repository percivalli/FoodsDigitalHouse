package br.com.digitalhouse.foodsdigitalhouse.place.place.adapter;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.foodsdigitalhouse.R;
import br.com.digitalhouse.foodsdigitalhouse.model.Place;
import br.com.digitalhouse.foodsdigitalhouse.place.place.listener.RecyclerViewPlaceClickListener;

public class RecyclerViewPlaceAdapter extends RecyclerView.Adapter<RecyclerViewPlaceAdapter.ViewHolder> {

    private List<Place> places;
    private RecyclerViewPlaceClickListener listener;

    public RecyclerViewPlaceAdapter(List<Place> place, RecyclerViewPlaceClickListener listener) {
        this.places = place;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pos) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.place_recycler_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
        final Place place = places.get(pos);
        viewHolder.bind(place);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(place);
            }
        });
    }

    @Override
    public int getItemCount() {
        return places.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView placeImageViewImage;
        private TextView placeTextViewName;
        private TextView placeTextViewAddress;
        private TextView placeTextViewCloseTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            placeImageViewImage = itemView.findViewById(R.id.placeImageViewImage);
            placeTextViewName = itemView.findViewById(R.id.placeTextViewName);
            placeTextViewAddress = itemView.findViewById(R.id.placeTextViewAddress);
            placeTextViewCloseTime = itemView.findViewById(R.id.placeTextViewCloseAt);
        }

        public void bind(Place place) {
            placeImageViewImage.setImageDrawable(ContextCompat.getDrawable(placeImageViewImage.getContext(), place.getImage()));
            placeTextViewName.setText(place.getName());
            placeTextViewAddress.setText(place.getAddress());
            placeTextViewCloseTime.setText(place.getClose());
        }
    }
}