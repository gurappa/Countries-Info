/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

import se.rebtel.countriesinfo.R;

/**
 * App's util methods
 */
public class Utils {

    public static final String TAG = Utils.class.getSimpleName();

    /**
     * Checks if a network connection is available - wifi or cellular.
     *
     * @param context context
     * @return true if wifi or cellular network is available.
     * false if no network.
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * Show no network dialog. On pressing ok, it takes user to setting screen to turn on network.
     *
     * @param context context
     */
    public static AlertDialog showNoNetworkDialog(final Context context) {

        return getAlertDialog(context,
                context.getString(R.string.title_no_network),
                context.getString(R.string.message_no_network),
                true,
                R.string.ok,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
                    }
                }, 0, null).show();
    }

    /**
     * Show no network dialog. On pressing ok, it takes user to setting screen to turn on network.
     *
     * @param context context
     */
    public static AlertDialog showNoNetworkDialog(final Context context,
                                                  final String title,
                                                  final String message,
                                                  final DialogInterface.OnClickListener positiveButtonListener) {
        return getAlertDialog(context, title, message, true, R.string.ok, positiveButtonListener, 0, null).show();
    }

    /**
     * Get Dialog
     *
     * @param context                  context
     * @param title                    title
     * @param message                  dialog message
     * @param isCancelable             true if dialog is cancelable
     *                                 false if not
     * @param positiveButtonTextRes    text for positive button
     * @param onPositiveButtonListener listener for positive button
     * @param negativeButtonTextRes    text for negative button
     * @param onNegativeButtonListener listener for positive button
     * @return
     */
    public static AlertDialog.Builder getAlertDialog(Context context, String title, String message,
                                                     boolean isCancelable, int positiveButtonTextRes,
                                                     DialogInterface.OnClickListener onPositiveButtonListener,
                                                     int negativeButtonTextRes,
                                                     DialogInterface.OnClickListener onNegativeButtonListener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (title != null) {
            builder.setTitle(title);
        }

        if (message != null) {
            builder.setMessage(message);
        }

        builder.setCancelable(isCancelable);

        if (positiveButtonTextRes != 0 && onPositiveButtonListener != null) {
            builder.setPositiveButton(positiveButtonTextRes, onPositiveButtonListener);
        }

        if (negativeButtonTextRes != 0 && onNegativeButtonListener != null) {
            builder.setNegativeButton(negativeButtonTextRes, onNegativeButtonListener);
        }
        return builder;
    }
}
