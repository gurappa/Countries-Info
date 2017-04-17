/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.scenes.countries;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.v7.widget.CardView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import se.rebtel.countriesinfo.R;
import se.rebtel.countriesinfo.app.MainApplication;
import se.rebtel.countriesinfo.data.models.Country;
import se.rebtel.countriesinfo.utils.Constants;

/**
 * Created by gurappachenchugari on 2017-04-14.
 */
class CountriesAdapter extends RecyclerView.Adapter {
    private static String TAG = CountriesAdapter.class.getSimpleName();

    private Context mContext;
    private List<Country> mCountries;
    private OnItemClickListener mOnItemClickListener;

    CountriesAdapter(Context context, List<Country> countries, OnItemClickListener onItemClickListener) {
        mContext = context;
        mCountries = countries;
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new ViewHolder(inflater.inflate(R.layout.item_country, parent, false), mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolder holder = (ViewHolder) viewHolder;

        Country country = mCountries.get(position);

        holder.mText.setText(country.getCountryName());
        holder.mImage.setImageDrawable(null);

        Log.d(TAG, "image url : " + Constants.BASE_COUNTRIES_URL + String.format(Constants.IMAGE_COUNTRY_ENDPOINT, country.getCountryCode().toLowerCase()));
        ImageLoader.getInstance().displayImage(
                Constants.BASE_COUNTRIES_URL + String.format(Constants.IMAGE_COUNTRY_ENDPOINT, country.getCountryCode().toLowerCase()),
                holder.mImage,
                MainApplication.getDisplayImageLoaderOptions(mContext));
    }

    @Override
    public int getItemCount() {
        return mCountries.size();
    }

    /**
     * Sets country list
     *
     * @param countries list of countries
     */
    public void setCountries(List<Country> countries) {
        mCountries = countries;

        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView mCardView;
        ImageView mImage;
        TextView mText;
        OnItemClickListener mItemClickListener;

        ViewHolder(View itemView, OnItemClickListener itemClickListener) {
            super(itemView);

            mCardView = (CardView) itemView.findViewById(R.id.cardView);
            mImage = (ImageView) itemView.findViewById(R.id.imageFlag);
            mText = (TextView) itemView.findViewById(R.id.textCountryName);
            mItemClickListener = itemClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, this, getAdapterPosition());
            }
        }
    }

    interface OnItemClickListener {
        void onItemClick(View view, ViewHolder viewHolder, int position);
    }
}
