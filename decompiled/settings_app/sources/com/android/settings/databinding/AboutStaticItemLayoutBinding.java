package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class AboutStaticItemLayoutBinding implements ViewBinding {
    public final ImageView arrow;
    private final View rootView;
    public final LinearLayout separator;
    public final TextView summary;
    public final TextView title;

    private AboutStaticItemLayoutBinding(View r1, ImageView r2, LinearLayout r3, TextView r4, TextView r5) {
        this.rootView = r1;
        this.arrow = r2;
        this.separator = r3;
        this.summary = r4;
        this.title = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static AboutStaticItemLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.about_static_item_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static AboutStaticItemLayoutBinding bind(View r8) {
        int r0 = R.id.arrow;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r8, R.id.arrow);
        if (r4 == null) goto L13;
        r0 = R.id.separator;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.separator);
        if (r5 == null) goto L13;
        r0 = R.id.summary;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.summary);
        if (r6 == null) goto L13;
        r0 = R.id.title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.title);
        if (r7 == null) goto L13;
        return new AboutStaticItemLayoutBinding(r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
