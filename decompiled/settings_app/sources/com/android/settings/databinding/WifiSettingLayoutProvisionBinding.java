package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.wifi.ObservableScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.divider.ODivider;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiSettingLayoutProvisionBinding implements ViewBinding {
    public final RelativeLayout bottomActionBar;
    public final OButton bottomButton;
    public final View fixedBottomView;
    public final View fixedTopRedView;
    public final LinearLayout introLayout;
    public final OTextView laterSetting;
    public final ODivider listViewDivider;
    public final OFloatingTitleBar phoneSetupTitleBar;
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;
    public final ObservableScrollView scrollView;
    public final LinearLayout syncContainer;
    public final OTextView titleText;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiSettingLayoutProvisionBinding(RelativeLayout r1, RelativeLayout r2, OButton r3, View r4, View r5, LinearLayout r6, OTextView r7, ODivider r8, OFloatingTitleBar r9, RecyclerView r10, ObservableScrollView r11, LinearLayout r12, OTextView r13) {
        this.rootView = r1;
        this.bottomActionBar = r2;
        this.bottomButton = r3;
        this.fixedBottomView = r4;
        this.fixedTopRedView = r5;
        this.introLayout = r6;
        this.laterSetting = r7;
        this.listViewDivider = r8;
        this.phoneSetupTitleBar = r9;
        this.recyclerView = r10;
        this.scrollView = r11;
        this.syncContainer = r12;
        this.titleText = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiSettingLayoutProvisionBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiSettingLayoutProvisionBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_setting_layout_provision, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiSettingLayoutProvisionBinding bind(View r17) {
        int r1 = R.id.bottom_action_bar;
        RelativeLayout r5 = (RelativeLayout) ViewBindings.findChildViewById(r17, R.id.bottom_action_bar);
        if (r5 == null) goto L29;
        r1 = R.id.bottom_button;
        OButton r6 = (OButton) ViewBindings.findChildViewById(r17, R.id.bottom_button);
        if (r6 == null) goto L29;
        r1 = R.id.fixed_bottom_view;
        View r7 = ViewBindings.findChildViewById(r17, R.id.fixed_bottom_view);
        if (r7 == null) goto L29;
        r1 = R.id.fixed_top_red_view;
        View r8 = ViewBindings.findChildViewById(r17, R.id.fixed_top_red_view);
        if (r8 == null) goto L29;
        r1 = R.id.intro_layout;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.intro_layout);
        if (r9 == null) goto L29;
        r1 = R.id.later_setting;
        OTextView r10 = (OTextView) ViewBindings.findChildViewById(r17, R.id.later_setting);
        if (r10 == null) goto L29;
        r1 = R.id.list_view_divider;
        ODivider r11 = (ODivider) ViewBindings.findChildViewById(r17, R.id.list_view_divider);
        if (r11 == null) goto L29;
        r1 = R.id.phone_setup_title_bar;
        OFloatingTitleBar r12 = (OFloatingTitleBar) ViewBindings.findChildViewById(r17, R.id.phone_setup_title_bar);
        if (r12 == null) goto L29;
        r1 = R.id.recycler_view;
        RecyclerView r13 = (RecyclerView) ViewBindings.findChildViewById(r17, R.id.recycler_view);
        if (r13 == null) goto L29;
        r1 = R.id.scroll_view;
        ObservableScrollView r14 = (ObservableScrollView) ViewBindings.findChildViewById(r17, R.id.scroll_view);
        if (r14 == null) goto L29;
        r1 = R.id.sync_container;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.sync_container);
        if (r15 == null) goto L29;
        r1 = R.id.title_text;
        OTextView r16 = (OTextView) ViewBindings.findChildViewById(r17, R.id.title_text);
        if (r16 == null) goto L29;
        return new WifiSettingLayoutProvisionBinding((RelativeLayout) r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
