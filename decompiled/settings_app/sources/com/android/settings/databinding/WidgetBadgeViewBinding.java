package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import com.obric.oui.badge.OBadgeView;

/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBadgeViewBinding implements ViewBinding {
    private final OBadgeView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WidgetBadgeViewBinding(OBadgeView r1) {
        this.rootView = r1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OBadgeView getRoot() {
        return this.rootView;
    }

    public static WidgetBadgeViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WidgetBadgeViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.widget_badge_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WidgetBadgeViewBinding bind(View r1) {
        if (r1 == null) goto L6;
        return new WidgetBadgeViewBinding((OBadgeView) r1);
    L6:
        throw new NullPointerException("rootView");
    }
}
