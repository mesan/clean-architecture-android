package com.netcompany.android.ncpizza.view.pizzalist.presenter;

import com.netcompany.android.ncpizza.domain.Pizza;

import java.util.List;

public interface PizzaListPresenter {
    void gotPizzas(List<Pizza> pizzas);
    void failedToGetPizzas();
}
