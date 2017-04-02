package com.netcompany.android.ncpizza.view.pizzalist.router;

import android.content.Context;

import com.netcompany.android.ncpizza.domain.Pizza;

public interface PizzaListRouter {
    void goToPizza(Context context, Pizza pizza);
}
