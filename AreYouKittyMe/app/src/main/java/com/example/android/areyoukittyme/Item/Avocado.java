package com.example.android.areyoukittyme.Item;

import com.example.android.areyoukittyme.R;

/**
 * Created by PrGxw on 4/16/2017.
 */

public class Avocado implements Item{
    private int price;
    private int icon;
    private static int id;

    public Avocado() {
        setPrice(25);
        this.id = R.drawable.avocado;
        setIcon(id);
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public int getPrice() {
        return price;
    }
}
