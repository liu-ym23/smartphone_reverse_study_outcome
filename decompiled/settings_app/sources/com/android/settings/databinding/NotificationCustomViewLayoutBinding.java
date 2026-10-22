package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationCustomViewLayoutBinding implements ViewBinding {
    public final TextView bottomTips;
    public final LinearLayout candidateContainer;
    private final RelativeLayout rootView;
    public final HorizontalScrollView scrollCandidate;
    public final View viewSeparator;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotificationCustomViewLayoutBinding(RelativeLayout r1, TextView r2, LinearLayout r3, HorizontalScrollView r4, View r5) {
        this.rootView = r1;
        this.bottomTips = r2;
        this.candidateContainer = r3;
        this.scrollCandidate = r4;
        this.viewSeparator = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NotificationCustomViewLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotificationCustomViewLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.notification_custom_view_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotificationCustomViewLayoutBinding bind(View r8) {
        int r0 = R.id.bottom_tips;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, R.id.bottom_tips);
        if (r4 == null) goto L13;
        r0 = R.id.candidate_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.candidate_container);
        if (r5 == null) goto L13;
        r0 = R.id.scroll_candidate;
        HorizontalScrollView r6 = (HorizontalScrollView) ViewBindings.findChildViewById(r8, R.id.scroll_candidate);
        if (r6 == null) goto L13;
        r0 = R.id.view_separator;
        View r7 = ViewBindings.findChildViewById(r8, R.id.view_separator);
        if (r7 == null) goto L13;
        return new NotificationCustomViewLayoutBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
