/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.countries;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import se.rebtel.countriesinfo.R;
import se.rebtel.countriesinfo.app.MainApplication;
import se.rebtel.countriesinfo.data.models.Country;
import se.rebtel.countriesinfo.scenes.common.BaseFragment;
import se.rebtel.countriesinfo.scenes.countries.injection.DaggerDiCountriesComponent;
import se.rebtel.countriesinfo.scenes.countries.injection.DiCountriesComponent;
import se.rebtel.countriesinfo.scenes.countries.injection.DiCountriesPresenterModule;
import se.rebtel.countriesinfo.scenes.details.DetailsActivity;
import se.rebtel.countriesinfo.scenes.details.DetailsFragment;

/**
 * Countries fragment. This is the 'View' in MVP
 */
public class CountriesFragment extends BaseFragment
        implements SwipeRefreshLayout.OnRefreshListener, CountriesAdapter.OnItemClickListener, CountriesContract.View {
    public static String TAG = CountriesFragment.class.getSimpleName();

    @Inject
    @NonNull
    public CountriesContract.Presenter mCountriesPresenter;

    DiCountriesComponent mDiCountriesActivityComponent;

    private CountriesAdapter mCountriesAdapter;
    private SwipeRefreshLayout mSwipeRefresh;
    private RecyclerView mRecyclerView;
    private List<Country> mCountries = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Dependency Injection
        MainApplication application = (MainApplication) getActivity().getApplication();
        mDiCountriesActivityComponent = DaggerDiCountriesComponent.builder()
                .diCountriesPresenterModule(new DiCountriesPresenterModule(this))
                .diRepositoryComponent(application.getDiRepositoryComponent())
                .build();

        mDiCountriesActivityComponent.injectCountriesActivity(this);
        Log.d(TAG, "DI successful: View (CountriesActivity) got mCountriesPresenter : " + mCountriesPresenter);

        mCountriesPresenter.onCreate();
        mCountriesPresenter.getCountries();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_countries, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerCountries);
        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshCountries);

        mSwipeRefresh.setOnRefreshListener(this);

        mCountriesAdapter = new CountriesAdapter(getActivity(), mCountries, this);
        mRecyclerView.setAdapter(mCountriesAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefresh.setRefreshing(true);
                mCountriesPresenter.getCountries();
            }
        });
    }

    @Override
    public void onRefresh() {
        mCountriesPresenter.getCountries();
    }

    @Override
    public void onItemClick(View view, CountriesAdapter.ViewHolder holder, int position) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(DetailsFragment.ARGUMENT_COUNTRY, mCountries.get(position));

        intent.putExtras(bundle);

        startActivity(intent);
    }

    /**
     * Called by Details Presenter to display list of countries data it received
     *
     * @param countries list fo countries
     */
    public void setCountries(List<Country> countries) {
        mSwipeRefresh.setRefreshing(false);

        mCountries = countries;

        mRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                if (mCountriesAdapter != null) {
                    mCountriesAdapter.setCountries(mCountries);
                }
            }
        });
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCountriesPresenter.onDestroy();
    }
}
