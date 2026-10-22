package com.android.settingslib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.R;

/* JADX INFO: loaded from: classes.dex */
public class LayoutPreference extends Preference {
    private boolean mAllowDividerAbove;
    private boolean mAllowDividerBelow;
    private final View.OnClickListener mClickListener;
    private View mRootView;

    /* JADX INFO: renamed from: lambda$new$0$com-android-settingslib-widget-LayoutPreference, reason: not valid java name */
    /* synthetic */ void m836lambda$new$0$comandroidsettingslibwidgetLayoutPreference(View r1) {
        performClick(r1);
    }

    public LayoutPreference(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mClickListener = new LayoutPreference$$ExternalSyntheticLambda0(this);
        init(r2, r3, 0);
    }

    public LayoutPreference(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.mClickListener = new LayoutPreference$$ExternalSyntheticLambda0(this);
        init(r2, r3, r4);
    }

    public LayoutPreference(Context r4, int r5) {
        this(r4, LayoutInflater.from(r4).inflate(r5, null, false));
    }

    public LayoutPreference(Context r1, View r2) {
        super(r1);
        this.mClickListener = new LayoutPreference$$ExternalSyntheticLambda0(this);
        setView(r2);
    }

    private void init(Context r4, AttributeSet r5, int r6) {
        TypedArray r0 = r4.obtainStyledAttributes(r5, R.styleable.Preference);
        this.mAllowDividerAbove = TypedArrayUtils.getBoolean(r0, 16, 16, false);
        this.mAllowDividerBelow = TypedArrayUtils.getBoolean(r0, 17, 17, false);
        r0.recycle();
        TypedArray r7 = r4.obtainStyledAttributes(r5, R.styleable.Preference, r6, 0);
        int r8 = r7.getResourceId(3, 0);
        if (r8 == 0) goto L7;
        r7.recycle();
        setView(LayoutInflater.from(getContext()).inflate(r8, null, false));
        return;
    L7:
        throw new IllegalArgumentException("LayoutPreference requires a layout to be defined");
    }

    private void setView(View r2) {
        setLayoutResource(com.android.settings.R.layout.layout_preference_frame);
        this.mRootView = r2;
        setShouldDisableView(false);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        r3.itemView.setOnClickListener(this.mClickListener);
        boolean r0 = isSelectable();
        r3.itemView.setFocusable(r0);
        r3.itemView.setClickable(r0);
        r3.setDividerAllowedAbove(this.mAllowDividerAbove);
        r3.setDividerAllowedBelow(this.mAllowDividerBelow);
        FrameLayout r4 = (FrameLayout) r3.itemView;
        r4.removeAllViews();
        ViewGroup r1 = (ViewGroup) this.mRootView.getParent();
        if (r1 == null) goto L5;
        r1.removeView(this.mRootView);
    L5:
        r4.addView(this.mRootView);
    }

    public <T extends View> T findViewById(int r1) {
        return (T) this.mRootView.findViewById(r1);
    }

    public void setAllowDividerBelow(boolean r1) {
        this.mAllowDividerBelow = r1;
    }

    public boolean isAllowDividerBelow() {
        return this.mAllowDividerBelow;
    }
}
