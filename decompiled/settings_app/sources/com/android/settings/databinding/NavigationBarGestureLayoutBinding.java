package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.MovieView;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class NavigationBarGestureLayoutBinding implements ViewBinding {
    public final OCardListItem appSwitchView;
    public final OCardListItem hideNavHandle;
    public final MovieView movieViewBack;
    public final MovieView movieViewOverview;
    public final MovieView movieViewSwitch;
    public final LinearLayout navigationBarGestureLayout;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NavigationBarGestureLayoutBinding(LinearLayout r1, OCardListItem r2, OCardListItem r3, MovieView r4, MovieView r5, MovieView r6, LinearLayout r7) {
        this.rootView = r1;
        this.appSwitchView = r2;
        this.hideNavHandle = r3;
        this.movieViewBack = r4;
        this.movieViewOverview = r5;
        this.movieViewSwitch = r6;
        this.navigationBarGestureLayout = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NavigationBarGestureLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NavigationBarGestureLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.navigation_bar_gesture_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NavigationBarGestureLayoutBinding bind(View r10) {
        int r0 = R.id.app_switch_view;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.app_switch_view);
        if (r4 == null) goto L15;
        r0 = R.id.hide_nav_handle;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.hide_nav_handle);
        if (r5 == null) goto L15;
        r0 = R.id.movie_view_back;
        MovieView r6 = (MovieView) ViewBindings.findChildViewById(r10, R.id.movie_view_back);
        if (r6 == null) goto L15;
        r0 = R.id.movie_view_overview;
        MovieView r7 = (MovieView) ViewBindings.findChildViewById(r10, R.id.movie_view_overview);
        if (r7 == null) goto L15;
        r0 = R.id.movie_view_switch;
        MovieView r8 = (MovieView) ViewBindings.findChildViewById(r10, R.id.movie_view_switch);
        if (r8 == null) goto L15;
        LinearLayout r9 = (LinearLayout) r10;
        return new NavigationBarGestureLayoutBinding(r9, r4, r5, r6, r7, r8, r9);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
