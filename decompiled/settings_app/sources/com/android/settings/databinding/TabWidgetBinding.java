package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabWidget;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class TabWidgetBinding implements ViewBinding {
    private final HorizontalScrollView rootView;
    public final TabWidget tabs;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TabWidgetBinding(HorizontalScrollView r1, TabWidget r2) {
        this.rootView = r1;
        this.tabs = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public HorizontalScrollView getRoot() {
        return this.rootView;
    }

    public static TabWidgetBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TabWidgetBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.tab_widget, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TabWidgetBinding bind(View r2) {
        TabWidget r1 = (TabWidget) ViewBindings.findChildViewById(r2, android.R.id.tabs);
        if (r1 == null) goto L7;
        return new TabWidgetBinding((HorizontalScrollView) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(android.R.id.tabs)));
    }
}
