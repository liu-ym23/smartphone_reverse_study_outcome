package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreviewSeekBarViewPagerBinding implements ViewBinding {
    public final ViewPager previewPager;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreviewSeekBarViewPagerBinding(LinearLayout r1, ViewPager r2) {
        this.rootView = r1;
        this.previewPager = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreviewSeekBarViewPagerBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreviewSeekBarViewPagerBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preview_seek_bar_view_pager, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreviewSeekBarViewPagerBinding bind(View r2) {
        ViewPager r1 = (ViewPager) ViewBindings.findChildViewById(r2, R.id.preview_pager);
        if (r1 == null) goto L7;
        return new PreviewSeekBarViewPagerBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.preview_pager)));
    }
}
