package com.netcompany.android.ncpizza.view.pizzalist.presenter;

import com.netcompany.android.ncpizza.domain.Pizza;
import com.netcompany.android.ncpizza.view.pizzalist.PizzaTest;
import com.netcompany.android.ncpizza.view.pizzalist.view.PizzaListActivity;
import com.netcompany.android.ncpizza.view.pizzalist.view.PizzaListView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.verify;

public class PizzaListPresenterTest extends PizzaTest {
    private PizzaListPresenterImpl presenter;

    @Mock
    private PizzaListView view;

    @Mock
    private List<Pizza> pizzas;

    @Before
    public void setUp() {
        presenter = new PizzaListPresenterImpl(view);
    }

    @Test
    public void gotPizzas_callsShowPizzas() {
        presenter.gotPizzas(pizzas);

        verify(view).showPizzas(pizzas);
    }

    @Test
    public void failedToGetPizzas_callsShowFailedToGetPizzas() {
        presenter.failedToGetPizzas();

        verify(view).showFailedToGetPizzas();
    }
}
