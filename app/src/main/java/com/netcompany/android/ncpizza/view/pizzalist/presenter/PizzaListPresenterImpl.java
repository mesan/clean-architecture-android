package com.netcompany.android.ncpizza.view.pizzalist.presenter;

import com.netcompany.android.ncpizza.domain.Pizza;
import com.netcompany.android.ncpizza.view.pizzalist.view.PizzaListView;

import java.util.List;

public class PizzaListPresenterImpl implements PizzaListPresenter {
    private final PizzaListView view;

    public PizzaListPresenterImpl(PizzaListView view) {
        this.view = view;
    }

    @Override
    public void gotPizzas(List<Pizza> pizzas) {
        view.showPizzas(pizzas);
    }

    @Override
    public void failedToGetPizzas() {
        view.showFailedToGetPizzas();
    }
}
