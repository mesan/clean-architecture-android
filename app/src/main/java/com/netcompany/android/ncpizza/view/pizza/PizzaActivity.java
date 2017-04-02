package com.netcompany.android.ncpizza.view.pizza;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.netcompany.android.ncpizza.R;
import com.netcompany.android.ncpizza.view.BaseActivity;

public class PizzaActivity extends BaseActivity {
    public final static String EXTRA_PIZZA_IMAGE_SRC = "imageSrc";
    public final static String EXTRA_PIZZA_NAME = "name";

    @Override
    protected int getContentView() {
        return R.layout.activity_pizza;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView imageViewPizza = (ImageView) findViewById(R.id.imageViewPizza);
        TextView textViewName = (TextView) findViewById(R.id.textViewName);

        String imageSrc = getIntent().getStringExtra(EXTRA_PIZZA_IMAGE_SRC);
        String name =  getIntent().getStringExtra(EXTRA_PIZZA_NAME);

        int drawable = getResources().getIdentifier(imageSrc, "drawable", getPackageName());
        imageViewPizza.setImageDrawable(getResources().getDrawable(drawable));
        textViewName.setText(name);
    }
}
