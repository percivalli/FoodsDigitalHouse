package br.com.digitalhouse.foodsdigitalhouse.place.adapter;

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
import br.com.digitalhouse.foodsdigitalhouse.model.Options;

public class RecyclerViewOptionsAdapter extends RecyclerView.Adapter<RecyclerViewOptionsAdapter.ViewHolder> {

    private List<Options> options;
    private RecyclerViewOptionsAdapter listener;

    public RecyclerViewOptionsAdapter(List<Options> options, RecyclerViewOptionsAdapter listener) {
        this.options = options;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pos) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.options_recycler_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
        final Options option = options.get(pos);
        viewHolder.bind(option);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(option);
            }
        });
    }

    private void onClick(Options option) {
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView dishImageViewImage;
        private TextView dishTextViewName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dishImageViewImage = itemView.findViewById(R.id.optionImageViewImage);
            dishTextViewName = itemView.findViewById(R.id.optionTextViewName);
        }

        public void bind(Options option) {
            dishImageViewImage.setImageDrawable(ContextCompat.getDrawable(dishImageViewImage.getContext(), option.getImage()));
            dishTextViewName.setText(option.getName());
        }
    }
}

