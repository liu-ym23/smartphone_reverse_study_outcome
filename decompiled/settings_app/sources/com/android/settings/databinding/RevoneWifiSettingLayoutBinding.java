package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneWifiSettingLayoutBinding implements ViewBinding {
    public final View bottomLine;
    public final Button btnBack;
    public final Button btnContinue;
    public final LinearLayout btnGroup;
    public final Button btnPre;
    public final FrameLayout layoutParent;
    public final OListView listView;
    private final FrameLayout rootView;
    public final View topLine;
    public final TextView viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneWifiSettingLayoutBinding(FrameLayout r1, View r2, Button r3, Button r4, LinearLayout r5, Button r6, FrameLayout r7, OListView r8, View r9, TextView r10) {
        this.rootView = r1;
        this.bottomLine = r2;
        this.btnBack = r3;
        this.btnContinue = r4;
        this.btnGroup = r5;
        this.btnPre = r6;
        this.layoutParent = r7;
        this.listView = r8;
        this.topLine = r9;
        this.viewTitle = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static RevoneWifiSettingLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneWifiSettingLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_wifi_setting_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneWifiSettingLayoutBinding bind(View r12) {
        int r0 = R.id.bottom_line;
        View r3 = ViewBindings.findChildViewById(r12, R.id.bottom_line);
        if (r3 == null) goto L21;
        r0 = R.id.btn_back;
        Button r4 = (Button) ViewBindings.findChildViewById(r12, R.id.btn_back);
        if (r4 == null) goto L21;
        r0 = R.id.btn_continue;
        Button r5 = (Button) ViewBindings.findChildViewById(r12, R.id.btn_continue);
        if (r5 == null) goto L21;
        r0 = R.id.btn_group;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.btn_group);
        if (r6 == null) goto L21;
        r0 = R.id.btn_pre;
        Button r7 = (Button) ViewBindings.findChildViewById(r12, R.id.btn_pre);
        if (r7 == null) goto L21;
        FrameLayout r8 = (FrameLayout) r12;
        r0 = R.id.listView;
        OListView r9 = (OListView) ViewBindings.findChildViewById(r12, R.id.listView);
        if (r9 == null) goto L21;
        r0 = R.id.top_line;
        View r10 = ViewBindings.findChildViewById(r12, R.id.top_line);
        if (r10 == null) goto L21;
        r0 = R.id.view_title;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r11 == null) goto L21;
        return new RevoneWifiSettingLayoutBinding(r8, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
