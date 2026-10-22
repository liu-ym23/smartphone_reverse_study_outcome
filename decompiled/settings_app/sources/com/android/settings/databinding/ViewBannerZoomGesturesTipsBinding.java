package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewBannerZoomGesturesTipsBinding implements ViewBinding {
    public final OCardListItem accessibilityScreenMagnificationEnable;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ViewBannerZoomGesturesTipsBinding(LinearLayout r1, OCardListItem r2) {
        this.rootView = r1;
        this.accessibilityScreenMagnificationEnable = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewBannerZoomGesturesTipsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewBannerZoomGesturesTipsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.view_banner_zoom_gestures_tips, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ViewBannerZoomGesturesTipsBinding bind(View r2) {
        OCardListItem r1 = (OCardListItem) ViewBindings.findChildViewById(r2, R.id.accessibility_screen_magnification_enable);
        if (r1 == null) goto L7;
        return new ViewBannerZoomGesturesTipsBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.accessibility_screen_magnification_enable)));
    }
}
