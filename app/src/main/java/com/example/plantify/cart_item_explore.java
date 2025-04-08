package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class cart_item_explore extends RecyclerView.Adapter<cart_item_explore.cart_itemHolder> {

    static ArrayList<Integer> item_images;
    static ArrayList<Integer> item_prices;
    static ArrayList<String> item_names;
    static ArrayList<Integer> item_quantities;

    public static int count = 0;

    public cart_item_explore(ArrayList<Integer> item_images, ArrayList<Integer> item_prices, ArrayList<String> item_names, ArrayList<Integer> item_quantities) {
        this.item_images = item_images;
        this.item_prices = item_prices;
        this.item_names = item_names;
        this.item_quantities = item_quantities;
    }

    @NonNull
    @Override
    public cart_itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cart_item_explore, parent, false);
        return new cart_itemHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull cart_itemHolder holder, int position) {
        holder.item_name.setText(item_names.get(position));
        holder.item_price.setText("₹" + item_prices.get(position));
        holder.item_image.setImageResource(item_images.get(position));
        holder.txtCount.setText(String.valueOf(item_quantities.get(position)));
    }

    @Override
    public int getItemCount() {
        return item_names.size();
    }

    public class cart_itemHolder extends RecyclerView.ViewHolder {
        ImageView item_image,remove_btn;
        TextView item_name,item_price;

        TextView txtCount;

        AppCompatButton btnMinus, btnPlus;

        public cart_itemHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.item_price);
            item_image = itemView.findViewById(R.id.item_img);
            txtCount = itemView.findViewById(R.id.txtCount);
            btnMinus = itemView.findViewById(R.id.btnMinus);
            btnPlus = itemView.findViewById(R.id.btnPlus);
            remove_btn = itemView.findViewById(R.id.remove_btn);


            btnMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        int count = item_quantities.get(position);

                        if (count > 1) {
                            count--;
                            item_quantities.set(position, count);
                            txtCount.setText(String.valueOf(count));

                            if (listener != null) {
                                listener.onQuantityChanged();
                            }
                        }
                    }
                }
            });

            btnPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        int count = item_quantities.get(position);

                        if (count < 5) {
                            count++;
                            item_quantities.set(position, count);
                            txtCount.setText(String.valueOf(count));

                            if (listener != null) {
                                listener.onQuantityChanged();
                            }
                        }
                    }
                }
            });

            remove_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        item_images.remove(position);
                        item_prices.remove(position);
                        item_names.remove(position);
                        item_quantities.remove(position);

                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, item_names.size());
                    }
                }
            });

        }
    }

    public interface OnQuantityChangeListener {
        void onQuantityChanged();
    }

    private OnQuantityChangeListener listener;

    public void setOnQuantityChangeListener(OnQuantityChangeListener listener) {
        this.listener = listener;
    }

}