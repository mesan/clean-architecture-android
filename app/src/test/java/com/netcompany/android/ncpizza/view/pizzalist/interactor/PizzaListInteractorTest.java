package com.netcompany.android.ncpizza.view.pizzalist.interactor;

import com.netcompany.android.ncpizza.domain.Pizza;
import com.netcompany.android.ncpizza.service.PizzaService;
import com.netcompany.android.ncpizza.view.pizzalist.PizzaTest;
import com.netcompany.android.ncpizza.view.pizzalist.presenter.PizzaListPresenter;
import com.netcompany.android.ncpizza.view.pizzalist.router.PizzaListRouter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PizzaListInteractorTest extends PizzaTest {
    private PizzaListInteractorImpl interactor;

    @Mock
    private PizzaListPresenter presenter;

    @Mock
    private PizzaService pizzaService;

    @Mock
    private List<Pizza> pizzas;

    @Before
    public void setUp() {
        interactor = new PizzaListInteractorImpl(presenter, pizzaService);
    }

    @Test
    public void onCreate_callsGotPizzas_whenPizzasFromService() {
        when(pizzaService.getPizzas()).thenReturn(pizzas);

        interactor.onCreate();

        verify(presenter).gotPizzas(pizzas);
    }

    @Test
    public void onCreate_callsFailedToGetPizzas_whenNullFromService() {
        when(pizzaService.getPizzas()).thenReturn(null);

        interactor.onCreate();

        verify(presenter).failedToGetPizzas();
    }
}
