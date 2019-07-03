package com.test.logitech.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.test.logitech.R;

import java.lang.ref.WeakReference;

public class DialogUtils {

    private static WeakReference<ProgressDialog> progressDialog;

    public static void showErrorMessage(Activity activity, String message) {
        if (activity == null)
            return;
        if (message == null)
            message = activity.getString(R.string.unknown_error);
        View contentView = activity.findViewById(android.R.id.content);
        if (contentView != null && contentView.getRootView() != null) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
            alertDialog.setMessage(message);
            alertDialog.setTitle(activity.getString(R.string.error));
            alertDialog.setPositiveButton(activity.getString(R.string.close), null).create().show();
        } else
            Toast.makeText(activity, message, Toast.LENGTH_LONG).show();

    }

    public static void showMessage(Activity activity, String message) {
        if (activity == null)
            return;
        View contentView = activity.findViewById(android.R.id.content);
        if (contentView != null && contentView.getRootView() != null) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
            alertDialog.setMessage(message);
            alertDialog.setPositiveButton(activity.getString(R.string.close), null).create().show();
        } else
            Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }


    public static void showProgressDialog(Activity activity) {
        if (activity == null)
            return;
        if (progressDialog != null && progressDialog.get() != null)
            hideProgressDialog();
        String message = activity.getString(R.string.loading);
        ProgressDialog dialog = new ProgressDialog(activity);
        dialog.setCancelable(false);
        dialog.setMessage(message);
        dialog.show();
        progressDialog = new WeakReference<>(dialog);
    }

    public static void hideProgressDialog() {
        try {
            if (progressDialog != null) {
                ProgressDialog dialog = progressDialog.get();
                if (dialog != null)
                    dialog.dismiss();
            }
        } catch (IllegalArgumentException e) {
        }
    }

    public static void showLoading(Context context) {
        if (context != null)
            showProgressDialog((Activity) context);
    }

    public static void hideLoading() {
        hideProgressDialog();
    }
}