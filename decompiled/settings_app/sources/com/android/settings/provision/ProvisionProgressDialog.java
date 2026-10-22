package com.android.settings.provision;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class ProvisionProgressDialog extends Dialog {
    private View contentView;
    private Context mContext;
    private String mMessage;
    private int mMessageColor;
    private TextView mPageStatus;
    private int mSystemUiVisibility;
    private String mTitle;
    private int mTitleColor;

    public void setBackground(Drawable r1) {
    }

    public void setBackgroundResource(int r1) {
    }

    public void setProgress(int r1) {
    }

    public ProvisionProgressDialog(Context r3) {
        super(r3);
        this.mTitleColor = -1677721600;
        this.mMessageColor = -1677721600;
        this.mContext = r3;
        View r4 = LayoutInflater.from(r3).inflate(R.layout.provision_progress_dialog, null);
        this.contentView = r4;
        this.mPageStatus = (TextView) r4.findViewById(R.id.tv_processing_1);
        String r5 = (String) this.mContext.getText(R.string.provision_device_activating);
        this.mMessage = r5;
        this.mPageStatus.setText(r5);
    }

    public static ProvisionProgressDialog show(Context r0, CharSequence r1, CharSequence r2) {
        ProvisionProgressDialog r3 = new ProvisionProgressDialog(r0);
        r3.setMessage(r2);
        r3.show();
        return r3;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle r2) {
        super.onCreate(r2);
        getWindow().requestFeature(1);
        getWindow().setFlags(131072, 131072);
        getWindow().setContentView(this.contentView);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
    }

    @Override // android.app.Dialog
    public void onStart() {
        this.mPageStatus.getRootView().setSystemUiVisibility(this.mSystemUiVisibility);
    }

    @Override // android.app.Dialog
    public void setTitle(int r2) {
        setTitle(this.mContext.getText(r2));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence r1) {
        this.mTitle = r1.toString();
    }

    public void setMessage(int r2) {
        setMessage(this.mContext.getText(r2));
    }

    public void setMessage(CharSequence r1) {
        this.mMessage = r1.toString();
    }

    public void setSystemUiVisibility(int r1) {
        this.mSystemUiVisibility = r1;
    }

    public void setTitleColor(int r1) {
        this.mTitleColor = r1;
    }

    public void setMessageColor(int r1) {
        this.mMessageColor = r1;
    }
}
