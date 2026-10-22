package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextViewsBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView widgetText1;
    public final TextView widgetText2;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WidgetTextViewsBinding(LinearLayout r1, TextView r2, TextView r3) {
        this.rootView = r1;
        this.widgetText1 = r2;
        this.widgetText2 = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WidgetTextViewsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WidgetTextViewsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.widget_text_views, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WidgetTextViewsBinding bind(View r3) {
        int r0 = R.id.widget_text1;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.widget_text1);
        if (r1 == null) goto L9;
        r0 = R.id.widget_text2;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.widget_text2);
        if (r2 == null) goto L9;
        return new WidgetTextViewsBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
