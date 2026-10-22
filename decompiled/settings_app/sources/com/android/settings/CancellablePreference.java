package com.android.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class CancellablePreference extends Preference implements View.OnClickListener {
    private boolean mCancellable;
    private OnCancelListener mListener;

    public interface OnCancelListener {
        void onCancel(CancellablePreference r1);
    }

    public CancellablePreference(Context r1) {
        super(r1);
        setWidgetLayoutResource(R.layout.cancel_pref_widget);
    }

    public CancellablePreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        setWidgetLayoutResource(R.layout.cancel_pref_widget);
    }

    public void setCancellable(boolean r1) {
        this.mCancellable = r1;
        notifyChanged();
    }

    public void setOnCancelListener(OnCancelListener r1) {
        this.mListener = r1;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        ImageView r3 = (ImageView) r2.findViewById(R.id.cancel);
        if (this.mCancellable == false) goto L5;
        int r0 = 0;
    L6:
        r3.setVisibility(r0);
        r3.setOnClickListener(this);
        return;
    L5:
        r0 = 4;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        OnCancelListener r2 = this.mListener;
        if (r2 == null) goto L6;
        r2.onCancel(this);
        return;
    }
}
