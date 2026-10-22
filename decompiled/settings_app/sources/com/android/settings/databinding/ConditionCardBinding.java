package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.internal.widget.ButtonBarLayout;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ConditionCardBinding implements ViewBinding {
    public final ButtonBarLayout buttonBar;
    public final LinearLayout collapsedGroup;
    public final LinearLayout content;
    public final LinearLayout detailGroup;
    public final View divider;
    public final ImageView expandIndicator;
    public final Button firstAction;
    public final ImageView icon;
    private final FrameLayout rootView;
    public final Button secondAction;
    public final TextView summary;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ConditionCardBinding(FrameLayout r1, ButtonBarLayout r2, LinearLayout r3, LinearLayout r4, LinearLayout r5, View r6, ImageView r7, Button r8, ImageView r9, Button r10, TextView r11, TextView r12) {
        this.rootView = r1;
        this.buttonBar = r2;
        this.collapsedGroup = r3;
        this.content = r4;
        this.detailGroup = r5;
        this.divider = r6;
        this.expandIndicator = r7;
        this.firstAction = r8;
        this.icon = r9;
        this.secondAction = r10;
        this.summary = r11;
        this.title = r12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ConditionCardBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ConditionCardBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.condition_card, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ConditionCardBinding bind(View r15) {
        int r0 = R.id.buttonBar;
        ButtonBarLayout r4 = ViewBindings.findChildViewById(r15, R.id.buttonBar);
        if (r4 == null) goto L27;
        r0 = R.id.collapsed_group;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.collapsed_group);
        if (r5 == null) goto L27;
        r0 = R.id.content;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.content);
        if (r6 == null) goto L27;
        r0 = R.id.detail_group;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.detail_group);
        if (r7 == null) goto L27;
        r0 = R.id.divider;
        View r8 = ViewBindings.findChildViewById(r15, R.id.divider);
        if (r8 == null) goto L27;
        r0 = R.id.expand_indicator;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r15, R.id.expand_indicator);
        if (r9 == null) goto L27;
        r0 = R.id.first_action;
        Button r10 = (Button) ViewBindings.findChildViewById(r15, R.id.first_action);
        if (r10 == null) goto L27;
        r0 = android.R.id.icon;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r15, android.R.id.icon);
        if (r11 == null) goto L27;
        r0 = R.id.second_action;
        Button r12 = (Button) ViewBindings.findChildViewById(r15, R.id.second_action);
        if (r12 == null) goto L27;
        r0 = android.R.id.summary;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r15, android.R.id.summary);
        if (r13 == null) goto L27;
        r0 = android.R.id.title;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r15, android.R.id.title);
        if (r14 == null) goto L27;
        return new ConditionCardBinding((FrameLayout) r15, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
