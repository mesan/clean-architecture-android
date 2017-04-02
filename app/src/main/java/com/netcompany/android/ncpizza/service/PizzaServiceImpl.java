package com.netcompany.android.ncpizza.service;

import com.netcompany.android.ncpizza.domain.Pizza;

import java.util.Arrays;
import java.util.List;

public class PizzaServiceImpl implements PizzaService {
    @Override
    public List<Pizza> getPizzas() {
        Pizza no1 = new Pizza("No 1", "pizza_no_1");
        Pizza margherita = new Pizza("Margherita", "pizza_margherita");
        Pizza losBandidos = new Pizza("Los Bandidos", "pizza_los_bandidos");
        Pizza kos = new Pizza("Kos", "pizza_kos");
        Pizza beefEater = new Pizza("Beef Eater", "pizza_beef_eater");

        return Arrays.asList(no1, margherita, losBandidos, kos, beefEater);
    }
}
