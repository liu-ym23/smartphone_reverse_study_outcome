package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemCheckbox;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class DockSettingsLayoutBinding implements ViewBinding {
    public final SettingItemCheckbox idDockBarToolsBingBang;
    public final SettingItemCheckbox idDockBarToolsGlobalSearch;
    public final SettingItemCheckbox idDockBarToolsMultiTasks;
    public final SettingItemCheckbox idDockBarToolsRecentFiles;
    public final SettingItemCheckbox idDockBarToolsScreenshot;
    public final SettingItemCheckbox idDockBarToolsWhitePad;
    public final TextView idDockTitleBarVideoIntro;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final View videoBackground;
    public final ImageView videoDefault;
    public final FrameLayout videoLayout;
    public final VideoView videoView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DockSettingsLayoutBinding(RelativeLayout r1, SettingItemCheckbox r2, SettingItemCheckbox r3, SettingItemCheckbox r4, SettingItemCheckbox r5, SettingItemCheckbox r6, SettingItemCheckbox r7, TextView r8, LinearLayout r9, OScrollView r10, View r11, ImageView r12, FrameLayout r13, VideoView r14, OFloatingTitleBar r15) {
        this.rootView = r1;
        this.idDockBarToolsBingBang = r2;
        this.idDockBarToolsGlobalSearch = r3;
        this.idDockBarToolsMultiTasks = r4;
        this.idDockBarToolsRecentFiles = r5;
        this.idDockBarToolsScreenshot = r6;
        this.idDockBarToolsWhitePad = r7;
        this.idDockTitleBarVideoIntro = r8;
        this.pageContainer = r9;
        this.pageScrollview = r10;
        this.videoBackground = r11;
        this.videoDefault = r12;
        this.videoLayout = r13;
        this.videoView = r14;
        this.viewTitle = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DockSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DockSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.dock_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DockSettingsLayoutBinding bind(View r19) {
        int r1 = R.id.id_dock_bar_tools_bing_bang;
        SettingItemCheckbox r5 = (SettingItemCheckbox) ViewBindings.findChildViewById(r19, R.id.id_dock_bar_tools_bing_bang);
        if (r5 == null) goto L33;
        r1 = R.id.id_dock_bar_tools_global_search;
        SettingItemCheckbox r6 = (SettingItemCheckbox) ViewBindings.findChildViewById(r19, R.id.id_dock_bar_tools_global_search);
        if (r6 == null) goto L33;
        r1 = R.id.id_dock_bar_tools_multi_tasks;
        SettingItemCheckbox r7 = (SettingItemCheckbox) ViewBindings.findChildViewById(r19, R.id.id_dock_bar_tools_multi_tasks);
        if (r7 == null) goto L33;
        r1 = R.id.id_dock_bar_tools_recent_files;
        SettingItemCheckbox r8 = (SettingItemCheckbox) ViewBindings.findChildViewById(r19, R.id.id_dock_bar_tools_recent_files);
        if (r8 == null) goto L33;
        r1 = R.id.id_dock_bar_tools_screenshot;
        SettingItemCheckbox r9 = (SettingItemCheckbox) ViewBindings.findChildViewById(r19, R.id.id_dock_bar_tools_screenshot);
        if (r9 == null) goto L33;
        r1 = R.id.id_dock_bar_tools_white_pad;
        SettingItemCheckbox r10 = (SettingItemCheckbox) ViewBindings.findChildViewById(r19, R.id.id_dock_bar_tools_white_pad);
        if (r10 == null) goto L33;
        r1 = R.id.id_dock_title_bar_video_intro;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r19, R.id.id_dock_title_bar_video_intro);
        if (r11 == null) goto L33;
        r1 = R.id.page_container;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.page_container);
        if (r12 == null) goto L33;
        r1 = R.id.page_scrollview;
        OScrollView r13 = (OScrollView) ViewBindings.findChildViewById(r19, R.id.page_scrollview);
        if (r13 == null) goto L33;
        r1 = R.id.video_background;
        View r14 = ViewBindings.findChildViewById(r19, R.id.video_background);
        if (r14 == null) goto L33;
        r1 = R.id.video_default;
        ImageView r15 = (ImageView) ViewBindings.findChildViewById(r19, R.id.video_default);
        if (r15 == null) goto L33;
        r1 = R.id.video_layout;
        FrameLayout r16 = (FrameLayout) ViewBindings.findChildViewById(r19, R.id.video_layout);
        if (r16 == null) goto L33;
        r1 = R.id.video_view;
        VideoView r17 = (VideoView) ViewBindings.findChildViewById(r19, R.id.video_view);
        if (r17 == null) goto L33;
        r1 = R.id.view_title;
        OFloatingTitleBar r18 = (OFloatingTitleBar) ViewBindings.findChildViewById(r19, R.id.view_title);
        if (r18 == null) goto L33;
        return new DockSettingsLayoutBinding((RelativeLayout) r19, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
