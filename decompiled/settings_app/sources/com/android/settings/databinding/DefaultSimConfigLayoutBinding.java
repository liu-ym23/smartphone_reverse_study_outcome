package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultSimConfigLayoutBinding implements ViewBinding {
    public final OCardListItem askEveryTime;
    public final OCardListItem autoSwitch;
    public final OSectionTitleBar defaultSimTitle;
    public final RelativeLayout rootContainerRl;
    private final RelativeLayout rootView;
    public final OCardListItem sub1;
    public final OCardListItem sub2;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DefaultSimConfigLayoutBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, OSectionTitleBar r4, RelativeLayout r5, OCardListItem r6, OCardListItem r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.askEveryTime = r2;
        this.autoSwitch = r3;
        this.defaultSimTitle = r4;
        this.rootContainerRl = r5;
        this.sub1 = r6;
        this.sub2 = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DefaultSimConfigLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DefaultSimConfigLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.default_sim_config_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DefaultSimConfigLayoutBinding bind(View r11) {
        int r0 = R.id.ask_every_time;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.ask_every_time);
        if (r4 == null) goto L17;
        r0 = R.id.auto_switch;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.auto_switch);
        if (r5 == null) goto L17;
        r0 = R.id.default_sim_title;
        OSectionTitleBar r6 = (OSectionTitleBar) ViewBindings.findChildViewById(r11, R.id.default_sim_title);
        if (r6 == null) goto L17;
        RelativeLayout r7 = (RelativeLayout) r11;
        r0 = R.id.sub_1;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.sub_1);
        if (r8 == null) goto L17;
        r0 = R.id.sub_2;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.sub_2);
        if (r9 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L17;
        return new DefaultSimConfigLayoutBinding(r7, r4, r5, r6, r7, r8, r9, r10);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
