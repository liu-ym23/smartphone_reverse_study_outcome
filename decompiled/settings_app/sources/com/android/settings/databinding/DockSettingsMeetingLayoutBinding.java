package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemCheckbox;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class DockSettingsMeetingLayoutBinding implements ViewBinding {
    public final TextView idDockBarTools;
    public final SettingItemCheckbox idDockBarToolsAllApps;
    public final SettingItemCheckbox idDockBarToolsBingBang;
    public final SettingItemCheckbox idDockBarToolsFunctionKey;
    public final SettingItemCheckbox idDockBarToolsMultiTasks;
    public final SettingItemCheckbox idDockBarToolsShowLauncher;
    public final SettingItemCheckbox idDockBarToolsWindowTidy;
    public final SettingItemCheckbox idDockBarToolsWordChoosePattern;
    public final TextView idStatusBarTools;
    public final SettingItemCheckbox idStatusBarToolsLocalSearch;
    public final SettingItemCheckbox idStatusBarToolsNetworkSearch;
    public final SettingItemCheckbox idStatusBarToolsScreenRecord;
    public final SettingItemCheckbox idStatusBarToolsSearchWord;
    public final SettingItemText idWindowTitleBarStyle;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DockSettingsMeetingLayoutBinding(RelativeLayout r3, TextView r4, SettingItemCheckbox r5, SettingItemCheckbox r6, SettingItemCheckbox r7, SettingItemCheckbox r8, SettingItemCheckbox r9, SettingItemCheckbox r10, SettingItemCheckbox r11, TextView r12, SettingItemCheckbox r13, SettingItemCheckbox r14, SettingItemCheckbox r15, SettingItemCheckbox r16, SettingItemText r17, LinearLayout r18, OScrollView r19, OFloatingTitleBar r20) {
        this.rootView = r3;
        this.idDockBarTools = r4;
        this.idDockBarToolsAllApps = r5;
        this.idDockBarToolsBingBang = r6;
        this.idDockBarToolsFunctionKey = r7;
        this.idDockBarToolsMultiTasks = r8;
        this.idDockBarToolsShowLauncher = r9;
        this.idDockBarToolsWindowTidy = r10;
        this.idDockBarToolsWordChoosePattern = r11;
        this.idStatusBarTools = r12;
        this.idStatusBarToolsLocalSearch = r13;
        this.idStatusBarToolsNetworkSearch = r14;
        this.idStatusBarToolsScreenRecord = r15;
        this.idStatusBarToolsSearchWord = r16;
        this.idWindowTitleBarStyle = r17;
        this.pageContainer = r18;
        this.pageScrollview = r19;
        this.viewTitle = r20;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DockSettingsMeetingLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DockSettingsMeetingLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.dock_settings_meeting_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DockSettingsMeetingLayoutBinding bind(View r22) {
        int r1 = R.id.id_dock_bar_tools;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r22, R.id.id_dock_bar_tools);
        if (r5 == null) goto L39;
        r1 = R.id.id_dock_bar_tools_all_apps;
        SettingItemCheckbox r6 = (SettingItemCheckbox) ViewBindings.findChildViewById(r22, R.id.id_dock_bar_tools_all_apps);
        if (r6 == null) goto L39;
        r1 = R.id.id_dock_bar_tools_bing_bang;
        SettingItemCheckbox r7 = (SettingItemCheckbox) ViewBindings.findChildViewById(r22, R.id.id_dock_bar_tools_bing_bang);
        if (r7 == null) goto L39;
        r1 = R.id.id_dock_bar_tools_function_key;
        SettingItemCheckbox r8 = (SettingItemCheckbox) ViewBindings.findChildViewById(r22, R.id.id_dock_bar_tools_function_key);
        if (r8 == null) goto L39;
        r1 = R.id.id_dock_bar_tools_multi_tasks;
        SettingItemCheckbox r9 = (SettingItemCheckbox) ViewBindings.findChildViewById(r22, R.id.id_dock_bar_tools_multi_tasks);
        if (r9 == null) goto L39;
        r1 = R.id.id_dock_bar_tools_show_launcher;
        SettingItemCheckbox r10 = (SettingItemCheckbox) ViewBindings.findChildViewById(r22, R.id.id_dock_bar_tools_show_launcher);
        if (r10 == null) goto L39;
        r1 = R.id.id_dock_bar_tools_window_tidy;
        SettingItemCheckbox r11 = (SettingItemCheckbox) ViewBindings.findChildViewById(r22, R.id.id_dock_bar_tools_window_tidy);
        if (r11 == null) goto L39;
        r1 = R.id.id_dock_bar_tools_word_choose_pattern;
        SettingItemCheckbox r12 = (SettingItemCheckbox) ViewBindings.findChildViewById(r22, R.id.id_dock_bar_tools_word_choose_pattern);
        if (r12 == null) goto L39;
        r1 = R.id.id_status_bar_tools;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r22, R.id.id_status_bar_tools);
        if (r13 == null) goto L39;
        r1 = R.id.id_status_bar_tools_local_search;
        SettingItemCheckbox r14 = (SettingItemCheckbox) ViewBindings.findChildViewById(r22, R.id.id_status_bar_tools_local_search);
        if (r14 == null) goto L39;
        r1 = R.id.id_status_bar_tools_network_search;
        SettingItemCheckbox r15 = (SettingItemCheckbox) ViewBindings.findChildViewById(r22, R.id.id_status_bar_tools_network_search);
        if (r15 == null) goto L39;
        r1 = R.id.id_status_bar_tools_screen_record;
        SettingItemCheckbox r16 = (SettingItemCheckbox) ViewBindings.findChildViewById(r22, R.id.id_status_bar_tools_screen_record);
        if (r16 == null) goto L39;
        r1 = R.id.id_status_bar_tools_search_word;
        SettingItemCheckbox r17 = (SettingItemCheckbox) ViewBindings.findChildViewById(r22, R.id.id_status_bar_tools_search_word);
        if (r17 == null) goto L39;
        r1 = R.id.id_window_title_bar_style;
        SettingItemText r18 = (SettingItemText) ViewBindings.findChildViewById(r22, R.id.id_window_title_bar_style);
        if (r18 == null) goto L39;
        r1 = R.id.page_container;
        LinearLayout r19 = (LinearLayout) ViewBindings.findChildViewById(r22, R.id.page_container);
        if (r19 == null) goto L39;
        r1 = R.id.page_scrollview;
        OScrollView r20 = (OScrollView) ViewBindings.findChildViewById(r22, R.id.page_scrollview);
        if (r20 == null) goto L39;
        r1 = R.id.view_title;
        OFloatingTitleBar r21 = (OFloatingTitleBar) ViewBindings.findChildViewById(r22, R.id.view_title);
        if (r21 == null) goto L39;
        return new DockSettingsMeetingLayoutBinding((RelativeLayout) r22, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r22.getResources().getResourceName(r1)));
    }
}
