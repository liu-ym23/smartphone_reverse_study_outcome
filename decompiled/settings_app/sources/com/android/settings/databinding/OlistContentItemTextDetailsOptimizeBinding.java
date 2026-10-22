package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class OlistContentItemTextDetailsOptimizeBinding implements ViewBinding {
    public final ImageView ivTrailing;
    private final RelativeLayout rootView;
    public final LinearLayout trailingContainer;
    public final TextView tvContentSubtitle;
    public final TextView tvContentTitle;
    public final TextView tvTrailing;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OlistContentItemTextDetailsOptimizeBinding(RelativeLayout r1, ImageView r2, LinearLayout r3, TextView r4, TextView r5, TextView r6) {
        this.rootView = r1;
        this.ivTrailing = r2;
        this.trailingContainer = r3;
        this.tvContentSubtitle = r4;
        this.tvContentTitle = r5;
        this.tvTrailing = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OlistContentItemTextDetailsOptimizeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OlistContentItemTextDetailsOptimizeBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.olist_content_item_text_details_optimize, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OlistContentItemTextDetailsOptimizeBinding bind(View r9) {
        int r0 = R.id.iv_trailing;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r9, R.id.iv_trailing);
        if (r4 == null) goto L15;
        r0 = R.id.trailing_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.trailing_container);
        if (r5 == null) goto L15;
        r0 = R.id.tv_content_subtitle;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, R.id.tv_content_subtitle);
        if (r6 == null) goto L15;
        r0 = R.id.tv_content_title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, R.id.tv_content_title);
        if (r7 == null) goto L15;
        r0 = R.id.tv_trailing;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, R.id.tv_trailing);
        if (r8 == null) goto L15;
        return new OlistContentItemTextDetailsOptimizeBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
