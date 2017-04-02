package com.netcompany.android.ncpizza.view.pizzalist.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.netcompany.android.ncpizza.R;
import com.netcompany.android.ncpizza.domain.Pizza;
import com.netcompany.android.ncpizza.service.PizzaServiceImpl;
import com.netcompany.android.ncpizza.view.BaseActivity;
import com.netcompany.android.ncpizza.view.pizzalist.interactor.PizzaListInteractor;
import com.netcompany.android.ncpizza.view.pizzalist.interactor.PizzaListInteractorImpl;
import com.netcompany.android.ncpizza.view.pizzalist.presenter.PizzaListPresenterImpl;
import com.netcompany.android.ncpizza.view.pizzalist.router.PizzaListRouter;
import com.netcompany.android.ncpizza.view.pizzalist.router.PizzaListRouterImpl;
import com.netcompany.android.ncpizza.view.pizzalist.view.PizzaListView;

import java.lang.Override;
import java.util.List;

public class PizzaListActivity extends BaseActivity implements PizzaListView, PizzaClickListener {
    private PizzaListInteractor interactor;
    private PizzaListRouter router;

    private PizzaAdapter pizzaAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_pizza_list;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupRecyclerView();

        interactor = new PizzaListInteractorImpl(new PizzaListPresenterImpl(this),
                new PizzaServiceImpl());
        router = new PizzaListRouterImpl();

        interactor.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        interactor = null;
    }

    @Override
    public void showPizzas(List<Pizza> pizzas) {
        pizzaAdapter.setPizzas(pizzas);
    }

    @Override
    public void showFailedToGetPizzas() {
        // TODO
    }

    private void setupRecyclerView() {
        RecyclerView recyclerViewPizzas = (RecyclerView) findViewById(R.id.recyclerViewPizzas);

        pizzaAdapter = new PizzaAdapter();
        pizzaAdapter.setClickListener(this);
        recyclerViewPizzas.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewPizzas.setAdapter(pizzaAdapter);
    }

    @Override
    public void onPizzaClick(Pizza pizza) {
        router.goToPizza(this, pizza);
    }
}
