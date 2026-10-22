package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.widget.SettingListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentMultiSimRingtoneSettingBinding implements ViewBinding {
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final SettingListItem ringtone;
    public final SettingListItem ringtoneSim2;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentMultiSimRingtoneSettingBinding(RelativeLayout r1, LinearLayout r2, OScrollView r3, SettingListItem r4, SettingListItem r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.pageContainer = r2;
        this.pageScrollview = r3;
        this.ringtone = r4;
        this.ringtoneSim2 = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMultiSimRingtoneSettingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentMultiSimRingtoneSettingBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_multi_sim_ringtone_setting, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentMultiSimRingtoneSettingBinding bind(View r9) {
        int r0 = R.id.page_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.page_container);
        if (r4 == null) goto L15;
        r0 = R.id.page_scrollview;
        OScrollView r5 = (OScrollView) ViewBindings.findChildViewById(r9, R.id.page_scrollview);
        if (r5 == null) goto L15;
        r0 = R.id.ringtone;
        SettingListItem r6 = (SettingListItem) ViewBindings.findChildViewById(r9, R.id.ringtone);
        if (r6 == null) goto L15;
        r0 = R.id.ringtone_sim_2;
        SettingListItem r7 = (SettingListItem) ViewBindings.findChildViewById(r9, R.id.ringtone_sim_2);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new FragmentMultiSimRingtoneSettingBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
