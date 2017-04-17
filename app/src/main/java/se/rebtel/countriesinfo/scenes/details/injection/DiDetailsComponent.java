/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.details.injection;

import dagger.Component;
import se.rebtel.countriesinfo.data.source.injection.DiRepositoryComponent;
import se.rebtel.countriesinfo.scenes.details.DetailsFragment;

/**
 * Dagger component that triggers Details Presenter module and Repository module (if not created already)
 */
@DetailsScope
@Component(dependencies = DiRepositoryComponent.class, modules = DiDetailsPresenterModule.class)
public interface DiDetailsComponent {
    void injectDetailsActivity(DetailsFragment detailsFragment);
}