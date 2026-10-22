package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class AutostartItemScrollLayoutBinding implements ViewBinding {
    public final ListContentItemSwitch appInfo;
    public final FrameLayout appLayout;
    public final CheckBox checkBox;
    private final RelativeLayout rootView;
    public final TextView status;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AutostartItemScrollLayoutBinding(RelativeLayout r1, ListContentItemSwitch r2, FrameLayout r3, CheckBox r4, TextView r5) {
        this.rootView = r1;
        this.appInfo = r2;
        this.appLayout = r3;
        this.checkBox = r4;
        this.status = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AutostartItemScrollLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AutostartItemScrollLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.autostart_item_scroll_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AutostartItemScrollLayoutBinding bind(View r8) {
        int r0 = R.id.app_info;
        ListContentItemSwitch r4 = (ListContentItemSwitch) ViewBindings.findChildViewById(r8, R.id.app_info);
        if (r4 == null) goto L13;
        r0 = R.id.app_layout;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.app_layout);
        if (r5 == null) goto L13;
        r0 = R.id.checkBox;
        CheckBox r6 = (CheckBox) ViewBindings.findChildViewById(r8, R.id.checkBox);
        if (r6 == null) goto L13;
        r0 = R.id.status;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.status);
        if (r7 == null) goto L13;
        return new AutostartItemScrollLayoutBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
