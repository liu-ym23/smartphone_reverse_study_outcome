package com.android.settings;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HighlightingFragment extends InstrumentedFragment {
    private static final int DELAY_HIGHLIGHT_DURATION_MILLIS = 400;
    private static final String SAVE_HIGHLIGHTED_KEY = "android:view_highlighted";
    private static final String TAG = "HighlightSettingsFragment";
    private Drawable mHighlightDrawable;
    private boolean mViewHighlighted;
    private String mViewKey;

    public HighlightingFragment() {
        this.mViewHighlighted = false;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (r2 == null) goto L6;
        this.mViewHighlighted = r2.getBoolean(SAVE_HIGHLIGHTED_KEY);
        return;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putBoolean(SAVE_HIGHLIGHTED_KEY, this.mViewHighlighted);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L6;
        this.mViewKey = r3.getString(SettingsActivity.EXTRA_FRAGMENT_ARG_KEY);
        highlightViewIfNeeded();
        return;
    }

    public void highlightViewIfNeeded() {
        if (this.mViewHighlighted == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.mViewKey) == true) goto L9;
        highlightView(this.mViewKey);
        return;
    }

    private Drawable getHighlightDrawable() {
        if (this.mHighlightDrawable != null) goto L6;
        this.mHighlightDrawable = getActivity().getDrawable(R.drawable.preference_highlight);
    L6:
        return this.mHighlightDrawable;
    }

    private void highlightView(String r6) {
        final Drawable r0 = getHighlightDrawable();
        final View r7 = findViewForKey(getView(), r6);
        if (r7 == null) goto L6;
        r7.setBackground(r0);
        getView().postDelayed(new AnonymousClass1(this, r7, r0), 400);
        this.mViewHighlighted = true;
        return;
    }

    private View findViewForKey(View r4, String r5) {
        if (checkTag(r4, r5) == false) goto L6;
        return r4;
    L6:
        if ((r4 instanceof ViewGroup) == false) goto L13;
        ViewGroup r6 = (ViewGroup) r4;
        int r0 = r6.getChildCount();
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L17;
        View r2 = findViewForKey(r6.getChildAt(r1), r5);
        if (r2 != null) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return r2;
    L17:
        return null;
    L13:
        return null;
    }

    private boolean checkTag(View r2, String r3) {
        Object r1 = r2.getTag(R.id.preference_highlight_key);
        if (r1 != null) goto L5;
        return false;
    L5:
        if ((r1 instanceof String) == false) goto L16;
        String r4 = (String) r1;
        if (TextUtils.isEmpty(r4) == false) goto L10;
        return false;
    L10:
        if (r4.equals(r3) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }
}
