/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.eventbus;

import com.squareup.otto.Bus;

/**
 * Otto Event Bus
 */
public class Eventbus {
    private static Bus instance = null;

    private Eventbus() {
        instance = new Bus();
    }

    public static Bus getInstance() {
        if (instance == null) {
            instance = new Bus();
        }
        return instance;
    }
}