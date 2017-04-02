package com.netcompany.android.ncpizza.view.pizzalist.router;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.netcompany.android.ncpizza.domain.Pizza;
import com.netcompany.android.ncpizza.view.pizza.PizzaActivity;

import static com.netcompany.android.ncpizza.view.pizza.PizzaActivity.EXTRA_PIZZA_IMAGE_SRC;
import static com.netcompany.android.ncpizza.view.pizza.PizzaActivity.EXTRA_PIZZA_NAME;

public class PizzaListRouterImpl implements PizzaListRouter {
    @Override
    public void goToPizza(Context context, Pizza pizza) {
        Intent intent = new Intent(context, PizzaActivity.class);
        intent.putExtra(EXTRA_PIZZA_IMAGE_SRC, pizza.getImageSrc());
        intent.putExtra(EXTRA_PIZZA_NAME, pizza.getName());

        context.startActivity(intent);
    }
}
