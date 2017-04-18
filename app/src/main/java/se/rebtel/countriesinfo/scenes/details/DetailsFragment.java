/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import se.rebtel.countriesinfo.R;
import se.rebtel.countriesinfo.app.MainApplication;
import se.rebtel.countriesinfo.data.models.Country;
import se.rebtel.countriesinfo.data.models.CountryDetails;
import se.rebtel.countriesinfo.scenes.common.BaseFragment;
import se.rebtel.countriesinfo.scenes.details.injection.DaggerDiDetailsComponent;
import se.rebtel.countriesinfo.scenes.details.injection.DiDetailsComponent;
import se.rebtel.countriesinfo.scenes.details.injection.DiDetailsPresenterModule;
import se.rebtel.countriesinfo.utils.Constants;

/**
 * Details Fragment, 'View' in MVP.
 */
public class DetailsFragment extends BaseFragment implements DetailsContract.View, SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = DetailsActivity.class.getSimpleName();

    public static final String ARGUMENT_COUNTRY = "country_";

    @Inject
    @NonNull
    public DetailsContract.Presenter mDetailsPresenter;

    DiDetailsComponent mDiDetailsActivityComponent;

    String mCountryName;
    private Country mCountry;
    private CountryDetails mCountryDetails;

    private SwipeRefreshLayout mSwipeRefresh;
    private ImageView mImage;
    private TextView mCountryText;
    private TextView mCapitalText;
    private TextView mRegionText;
    private TextView mPopulationText;
    private TextView mDemonym;
    private TextView mLanguage;
    private TextView mLatlngText;
    private TextView mAreaText;
    private TextView mTimezonesText;
    private TextView mBordersText;
    private TextView mCallingCodesText;
    private TextView mCurrenciesText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainApplication application = (MainApplication) getActivity().getApplication();
        mDiDetailsActivityComponent = DaggerDiDetailsComponent.builder()
                .diDetailsPresenterModule(new DiDetailsPresenterModule(this))
                .diRepositoryComponent(application.getDiRepositoryComponent())
                .build();

        mDiDetailsActivityComponent.injectDetailsActivity(this);

        Log.d(TAG, "DI successful: View (DetailsActivity) got mDetailsPresenter : " + mDetailsPresenter);

        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle != null) {
            mCountry = bundle.getParcelable(DetailsFragment.ARGUMENT_COUNTRY);
        }

        mDetailsPresenter.onCreate();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshDetail);
        mImage = (ImageView) view.findViewById(R.id.imageDetail);
        mCountryText = (TextView) view.findViewById(R.id.textCountryDetails);
        mCapitalText = (TextView) view.findViewById(R.id.textCapitalDetails);
        mRegionText = (TextView) view.findViewById(R.id.textRegionDetails);
        mPopulationText = (TextView) view.findViewById(R.id.textPopulaionDetails);
        mDemonym = (TextView) view.findViewById(R.id.textDemonym);
        mLanguage = (TextView) view.findViewById(R.id.textLanguage);
        mLatlngText = (TextView) view.findViewById(R.id.textLatlngDetails);
        mAreaText = (TextView) view.findViewById(R.id.textAreaDetails);
        mTimezonesText = (TextView) view.findViewById(R.id.textTimezonesDetails);
        mBordersText = (TextView) view.findViewById(R.id.textBordersDetails);
        mCallingCodesText = (TextView) view.findViewById(R.id.textCallingCodesDetails);
        mCurrenciesText = (TextView) view.findViewById(R.id.textCurrenciesDetails);

        mSwipeRefresh.setOnRefreshListener(this);

        ImageLoader.getInstance().displayImage(
                Constants.BASE_COUNTRIES_URL + String.format(Constants.IMAGE_COUNTRY_ENDPOINT, mCountry.getCountryCode().toLowerCase()),
                mImage,
                MainApplication.getDisplayImageLoaderOptions(getActivity()));

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefresh.setRefreshing(true);

                mDetailsPresenter.getCountryDetails(mCountry.getCountryName());
            }
        });

    }

    @Override
    public void onRefresh() {
        mSwipeRefresh.setRefreshing(true);
        mDetailsPresenter.getCountryDetails(mCountry.getCountryName());
    }

    /**
     * Called by Details Presenter to display country details data it received
     *
     * @param countryDetails country details
     */
    @Override
    public void updateCountryDetails(CountryDetails countryDetails) {
        mSwipeRefresh.setRefreshing(false);

        mCountryDetails = countryDetails;

        if (mCountryDetails != null) {
            mCountryText.setText(String.format("%s (%s)", mCountryDetails.getName(), mCountryDetails.getNativeName()));
            mCapitalText.setText(mCountryDetails.getCapital());
            mRegionText.setText(mCountryDetails.getRegion());
            mPopulationText.setText(String.valueOf(mCountryDetails.getPopulation()));
            mDemonym.setText(String.valueOf(mCountryDetails.getDemonym()));

            List<String> languages = new ArrayList<>();
            for (CountryDetails.Language language : mCountryDetails.getLanguages()) {
                languages.add(language.getName());
            }
            mLanguage.setText(mCountryDetails.getLanguages() != null ? TextUtils.join(", ", languages) : "");
            mLatlngText.setText(mCountryDetails.getLatlng() != null ? TextUtils.join(" ", mCountryDetails.getLatlng()) : "");
            mAreaText.setText(String.valueOf(mCountryDetails.getArea()));
            mTimezonesText.setText(mCountryDetails.getTimezones() != null ? TextUtils.join("\n", mCountryDetails.getTimezones()) : "");
            mBordersText.setText(mCountryDetails.getBorders() != null ? TextUtils.join("\n", mCountryDetails.getBorders()) : "");
            mCallingCodesText.setText(mCountryDetails.getCallingCodes() != null ? TextUtils.join("\n", mCountryDetails.getCallingCodes()) : "");

            List<String> currencies = new ArrayList<>();
            for (CountryDetails.Currency currency : mCountryDetails.getCurrencies()) {
                currencies.add(currency.getName());
            }
            mCurrenciesText.setText(mCountryDetails.getCurrencies() != null ? TextUtils.join("\n", currencies) : "");
        }
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mDetailsPresenter.onDestroy();
    }
}
