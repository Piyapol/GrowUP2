package com.example.xeus_labmacbook.growup.network;

import com.squareup.otto.Bus;

/**
 * Created by DuckWalkZ on 10/3/2560.
 */

public class BusProvider {
    private static final Bus BUS = new Bus();

    public static Bus getInstance(){
        return BUS;
    }

    public BusProvider(){}
}
