package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.MovieView;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemCustom;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneFragmentStylusSearchBinding implements ViewBinding {
    public final TextView avalaibleDevice;
    public final SettingItemSwitch bluetoothSwitch;
    public final TextView btTips;
    public final SettingItemText doubleClickItem;
    public final SettingItemSwitch idPointer;
    public final View idPointerGap;
    public final TextView keyTips;
    public final SettingItemSwitch locationSwitch;
    public final SettingItemText longPressItem;
    public final ListContentItemCustom movieViewContainer;
    public final MovieView movieViewOverview;
    public final SettingItemText oneClickItem;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final TextView pointerTips;
    private final RelativeLayout rootView;
    public final RecyclerView stylusListView;
    public final View stylusListViewGap;
    public final TextView stylusMovieTips;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneFragmentStylusSearchBinding(RelativeLayout r3, TextView r4, SettingItemSwitch r5, TextView r6, SettingItemText r7, SettingItemSwitch r8, View r9, TextView r10, SettingItemSwitch r11, SettingItemText r12, ListContentItemCustom r13, MovieView r14, SettingItemText r15, LinearLayout r16, OScrollView r17, TextView r18, RecyclerView r19, View r20, TextView r21, OFloatingTitleBar r22) {
        this.rootView = r3;
        this.avalaibleDevice = r4;
        this.bluetoothSwitch = r5;
        this.btTips = r6;
        this.doubleClickItem = r7;
        this.idPointer = r8;
        this.idPointerGap = r9;
        this.keyTips = r10;
        this.locationSwitch = r11;
        this.longPressItem = r12;
        this.movieViewContainer = r13;
        this.movieViewOverview = r14;
        this.oneClickItem = r15;
        this.pageContainer = r16;
        this.pageScrollview = r17;
        this.pointerTips = r18;
        this.stylusListView = r19;
        this.stylusListViewGap = r20;
        this.stylusMovieTips = r21;
        this.viewTitle = r22;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevoneFragmentStylusSearchBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneFragmentStylusSearchBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_fragment_stylus_search, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneFragmentStylusSearchBinding bind(View r24) {
        int r1 = R.id.avalaible_device;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r24, R.id.avalaible_device);
        if (r5 == null) goto L43;
        r1 = R.id.bluetooth_switch;
        SettingItemSwitch r6 = (SettingItemSwitch) ViewBindings.findChildViewById(r24, R.id.bluetooth_switch);
        if (r6 == null) goto L43;
        r1 = R.id.bt_tips;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r24, R.id.bt_tips);
        if (r7 == null) goto L43;
        r1 = R.id.double_click_item;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r24, R.id.double_click_item);
        if (r8 == null) goto L43;
        r1 = R.id.id_pointer;
        SettingItemSwitch r9 = (SettingItemSwitch) ViewBindings.findChildViewById(r24, R.id.id_pointer);
        if (r9 == null) goto L43;
        r1 = R.id.id_pointer_gap;
        View r10 = ViewBindings.findChildViewById(r24, R.id.id_pointer_gap);
        if (r10 == null) goto L43;
        r1 = R.id.key_tips;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r24, R.id.key_tips);
        if (r11 == null) goto L43;
        r1 = R.id.location_switch;
        SettingItemSwitch r12 = (SettingItemSwitch) ViewBindings.findChildViewById(r24, R.id.location_switch);
        if (r12 == null) goto L43;
        r1 = R.id.long_press_item;
        SettingItemText r13 = (SettingItemText) ViewBindings.findChildViewById(r24, R.id.long_press_item);
        if (r13 == null) goto L43;
        r1 = R.id.movie_view_container;
        ListContentItemCustom r14 = (ListContentItemCustom) ViewBindings.findChildViewById(r24, R.id.movie_view_container);
        if (r14 == null) goto L43;
        r1 = R.id.movie_view_overview;
        MovieView r15 = (MovieView) ViewBindings.findChildViewById(r24, R.id.movie_view_overview);
        if (r15 == null) goto L43;
        r1 = R.id.one_click_item;
        SettingItemText r16 = (SettingItemText) ViewBindings.findChildViewById(r24, R.id.one_click_item);
        if (r16 == null) goto L43;
        r1 = R.id.page_container;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r24, R.id.page_container);
        if (r17 == null) goto L43;
        r1 = R.id.page_scrollview;
        OScrollView r18 = (OScrollView) ViewBindings.findChildViewById(r24, R.id.page_scrollview);
        if (r18 == null) goto L43;
        r1 = R.id.pointer_tips;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r24, R.id.pointer_tips);
        if (r19 == null) goto L43;
        r1 = R.id.stylus_listView;
        RecyclerView r20 = (RecyclerView) ViewBindings.findChildViewById(r24, R.id.stylus_listView);
        if (r20 == null) goto L43;
        r1 = R.id.stylus_listView_gap;
        View r21 = ViewBindings.findChildViewById(r24, R.id.stylus_listView_gap);
        if (r21 == null) goto L43;
        r1 = R.id.stylus_movie_tips;
        TextView r22 = (TextView) ViewBindings.findChildViewById(r24, R.id.stylus_movie_tips);
        if (r22 == null) goto L43;
        r1 = R.id.view_title;
        OFloatingTitleBar r23 = (OFloatingTitleBar) ViewBindings.findChildViewById(r24, R.id.view_title);
        if (r23 == null) goto L43;
        return new RevoneFragmentStylusSearchBinding((RelativeLayout) r24, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r24.getResources().getResourceName(r1)));
    }
}
