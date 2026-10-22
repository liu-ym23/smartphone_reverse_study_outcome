package com.android.settingslib.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class CustomDialogHelper {
    public static final int BACK_BUTTON = 4;
    public static final int ICON = 0;
    public static final int LAYOUT = 3;
    public static final int MESSAGE = 2;
    public static final int NEGATIVE_BUTTON = 5;
    public static final int POSITIVE_BUTTON = 6;
    public static final int TITLE = 1;
    private Button mBackButton;
    private Context mContext;
    private LinearLayout mCustomLayout;
    private Dialog mDialog;
    private View mDialogContent;
    private ImageView mDialogIcon;
    private TextView mDialogMessage;
    private TextView mDialogTitle;
    private LayoutInflater mLayoutInflater;
    private Button mNegativeButton;
    private Button mPositiveButton;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LayoutButton {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LayoutComponent {
    }

    public CustomDialogHelper(Context r3) {
        this.mContext = r3;
        LayoutInflater r4 = LayoutInflater.from(r3);
        this.mLayoutInflater = r4;
        View r5 = r4.inflate(com.android.settingslib.R.layout.dialog_with_icon, null);
        this.mDialogContent = r5;
        this.mDialogIcon = (ImageView) r5.findViewById(com.android.settingslib.R.id.dialog_with_icon_icon);
        this.mDialogTitle = (TextView) this.mDialogContent.findViewById(com.android.settingslib.R.id.dialog_with_icon_title);
        this.mDialogMessage = (TextView) this.mDialogContent.findViewById(com.android.settingslib.R.id.dialog_with_icon_message);
        this.mCustomLayout = (LinearLayout) this.mDialogContent.findViewById(com.android.settingslib.R.id.custom_layout);
        this.mPositiveButton = (Button) this.mDialogContent.findViewById(com.android.settingslib.R.id.button_ok);
        this.mNegativeButton = (Button) this.mDialogContent.findViewById(com.android.settingslib.R.id.button_cancel);
        this.mBackButton = (Button) this.mDialogContent.findViewById(com.android.settingslib.R.id.button_back);
        createDialog();
    }

    private void createDialog() {
        AlertDialog r0 = new AlertDialog.Builder(this.mContext).setView(this.mDialogContent).setCancelable(true).create();
        this.mDialog = r0;
        r0.getWindow().setSoftInputMode(4);
    }

    public CustomDialogHelper setPositiveButton(int r2, View.OnClickListener r3) {
        setButton(6, r2, r3);
        return this;
    }

    public CustomDialogHelper setPositiveButtonText(int r2) {
        this.mPositiveButton.setText(r2);
        return this;
    }

    public CustomDialogHelper setNegativeButton(int r2, View.OnClickListener r3) {
        setButton(5, r2, r3);
        return this;
    }

    public CustomDialogHelper setNegativeButtonText(int r2) {
        this.mNegativeButton.setText(r2);
        return this;
    }

    public CustomDialogHelper setBackButton(int r2, View.OnClickListener r3) {
        setButton(4, r2, r3);
        return this;
    }

    public CustomDialogHelper setBackButtonText(int r2) {
        this.mBackButton.setText(r2);
        return this;
    }

    private void setButton(int r3, int r4, View.OnClickListener r5) {
        if (r3 != 4) goto L5;
        this.mBackButton.setText(r4);
        this.mBackButton.setVisibility(0);
        this.mBackButton.setOnClickListener(r5);
        return;
    L5:
        if (r3 != 5) goto L7;
        this.mNegativeButton.setText(r4);
        this.mNegativeButton.setVisibility(0);
        this.mNegativeButton.setOnClickListener(r5);
        return;
    L7:
        if (r3 != 6) goto L15;
        this.mPositiveButton.setText(r4);
        this.mPositiveButton.setVisibility(0);
        this.mPositiveButton.setOnClickListener(r5);
        return;
    }

    public CustomDialogHelper setButtonEnabled(boolean r2) {
        this.mPositiveButton.setEnabled(r2);
        return this;
    }

    public CustomDialogHelper setTitle(int r2) {
        this.mDialogTitle.setText(r2);
        return this;
    }

    public CustomDialogHelper setMessage(int r2) {
        this.mDialogMessage.setText(r2);
        return this;
    }

    public CustomDialogHelper setMessagePadding(int r2) {
        this.mDialogMessage.setPadding(r2, r2, r2, r2);
        return this;
    }

    public CustomDialogHelper setIcon(Drawable r2) {
        this.mDialogIcon.setImageDrawable(r2);
        return this;
    }

    public CustomDialogHelper clearCustomLayout() {
        this.mCustomLayout.removeAllViews();
        return this;
    }

    public void hideCustomLayout() {
        this.mCustomLayout.setVisibility(8);
    }

    public void showCustomLayout() {
        this.mCustomLayout.setVisibility(0);
    }

    public CustomDialogHelper addCustomView(View r2) {
        this.mCustomLayout.addView(r2);
        return this;
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public CustomDialogHelper setVisibility(int r2, boolean r3) {
        if (r3 == false) goto L4;
        int r4 = 0;
    L5:
        if (r2 != 0) goto L7;
        this.mDialogIcon.setVisibility(r4);
    L23:
        return this;
    L7:
        if (r2 != 1) goto L9;
        this.mDialogTitle.setVisibility(r4);
        goto L23
    L9:
        if (r2 != 2) goto L11;
        this.mDialogMessage.setVisibility(r4);
        goto L23
    L11:
        if (r2 != 4) goto L13;
        this.mBackButton.setVisibility(r4);
        goto L23
    L13:
        if (r2 != 5) goto L15;
        this.mNegativeButton.setVisibility(r4);
        goto L23
    L15:
        if (r2 != 6) goto L23;
        this.mPositiveButton.setVisibility(r4);
        goto L23
    L4:
        r4 = 8;
        goto L5
    }

    public void requestFocusOnTitle() {
        this.mDialogTitle.requestFocus();
        this.mDialogTitle.sendAccessibilityEvent(8);
    }
}
