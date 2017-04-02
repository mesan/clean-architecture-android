package com.netcompany.android.ncpizza.view.pizzalist.view;

import com.netcompany.android.ncpizza.domain.Pizza;

import java.util.List;

public interface PizzaListView {
    void showPizzas(List<Pizza> pizzas);
    void showFailedToGetPizzas();
}
