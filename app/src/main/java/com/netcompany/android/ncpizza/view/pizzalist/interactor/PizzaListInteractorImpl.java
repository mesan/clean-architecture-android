package com.netcompany.android.ncpizza.view.pizzalist.interactor;

import com.netcompany.android.ncpizza.domain.Pizza;
import com.netcompany.android.ncpizza.service.PizzaService;
import com.netcompany.android.ncpizza.view.pizzalist.presenter.PizzaListPresenter;

import java.util.List;

public class PizzaListInteractorImpl implements PizzaListInteractor {
    private final PizzaListPresenter presenter;
    private final PizzaService pizzaService;

    public PizzaListInteractorImpl(PizzaListPresenter presenter, PizzaService pizzaService) {
        this.presenter = presenter;
        this.pizzaService = pizzaService;
    }

    @Override
    public void onCreate() {
        List<Pizza> pizzas = pizzaService.getPizzas();

        if (pizzas == null) {
            presenter.failedToGetPizzas();
        } else {
            presenter.gotPizzas(pizzas);
        }
    }
}
