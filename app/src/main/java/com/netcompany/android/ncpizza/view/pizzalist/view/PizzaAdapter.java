package com.netcompany.android.ncpizza.view.pizzalist.view;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netcompany.android.ncpizza.R;
import com.netcompany.android.ncpizza.domain.Pizza;

import java.util.List;

interface PizzaClickListener {
    void onPizzaClick(Pizza pizza);
}

class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder> {

    private List<Pizza> pizzas;
    private PizzaClickListener pizzaClickListener;

    @Override
    public PizzaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pizza, parent, false);
        return new PizzaViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return pizzas.size();
    }

    @Override
    public void onBindViewHolder(PizzaViewHolder holder, int position) {
        holder.bindTo(pizzas.get(position));
    }

    void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
        notifyDataSetChanged();
    }

    void setClickListener(PizzaClickListener pizzaClickListener) {
        this.pizzaClickListener = pizzaClickListener;
    }

    class PizzaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewPizza;
        private TextView textViewName;

        PizzaViewHolder(View itemView) {
            super(itemView);

            imageViewPizza = (ImageView) itemView.findViewById(R.id.imageViewPizza);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pizzaClickListener.onPizzaClick(pizzas.get(getAdapterPosition()));
                }
            });
        }

        void bindTo(Pizza pizza) {
            Resources resources = itemView.getResources();
            final int resourceId = resources.getIdentifier(pizza.getImageSrc(), "drawable",
                    itemView.getContext().getPackageName());

            imageViewPizza.setImageDrawable(resources.getDrawable(resourceId));
            textViewName.setText(pizza.getName());
        }
    }
}
