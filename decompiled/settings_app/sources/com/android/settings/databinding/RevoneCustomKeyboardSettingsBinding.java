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
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneCustomKeyboardSettingsBinding implements ViewBinding {
    public final SettingItemText btnKeyAlbumDrawer;
    public final SettingItemText btnKeyAppDrawer;
    public final SettingItemText btnKeyCloseAll;
    public final SettingItemText btnKeyCloseOtherWindow;
    public final SettingItemText btnKeyCloseWindow;
    public final SettingItemText btnKeyDesktop;
    public final SettingItemText btnKeyExitApp;
    public final SettingItemText btnKeyFileDrawer;
    public final SettingItemText btnKeyFullscreen;
    public final SettingItemText btnKeyFullscreenToTheLeft;
    public final SettingItemText btnKeyFullscreenToTheRight;
    public final SettingItemText btnKeyHideAppAllWindows;
    public final SettingItemText btnKeyHideOtherAppWindow;
    public final SettingItemText btnKeyLock;
    public final SettingItemText btnKeyMinimizeCurrentWindow;
    public final SettingItemText btnKeyMinimizeOtherWindow;
    public final SettingItemText btnKeyMultiTasks;
    public final SettingItemText btnKeyMultiTasksWithinApp;
    public final SettingItemText btnKeyNotificationCenter;
    public final SettingItemText btnKeyOpenNewFileManagerWindow;
    public final SettingItemText btnKeyOrganizeSmallWindow;
    public final SettingItemText btnKeyQuickSwitchCenter;
    public final SettingItemText btnKeyResumeWindow;
    public final SettingItemText btnKeyScrapbookDrawer;
    public final SettingItemText btnKeyScreenShot;
    public final SettingItemText btnKeyScreenShotFull;
    public final SettingItemText btnKeyTitleBarSwitch;
    public final OButton btnResetAllKeys;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneCustomKeyboardSettingsBinding(RelativeLayout r3, SettingItemText r4, SettingItemText r5, SettingItemText r6, SettingItemText r7, SettingItemText r8, SettingItemText r9, SettingItemText r10, SettingItemText r11, SettingItemText r12, SettingItemText r13, SettingItemText r14, SettingItemText r15, SettingItemText r16, SettingItemText r17, SettingItemText r18, SettingItemText r19, SettingItemText r20, SettingItemText r21, SettingItemText r22, SettingItemText r23, SettingItemText r24, SettingItemText r25, SettingItemText r26, SettingItemText r27, SettingItemText r28, SettingItemText r29, SettingItemText r30, OButton r31, LinearLayout r32, OScrollView r33, OFloatingTitleBar r34) {
        this.rootView = r3;
        this.btnKeyAlbumDrawer = r4;
        this.btnKeyAppDrawer = r5;
        this.btnKeyCloseAll = r6;
        this.btnKeyCloseOtherWindow = r7;
        this.btnKeyCloseWindow = r8;
        this.btnKeyDesktop = r9;
        this.btnKeyExitApp = r10;
        this.btnKeyFileDrawer = r11;
        this.btnKeyFullscreen = r12;
        this.btnKeyFullscreenToTheLeft = r13;
        this.btnKeyFullscreenToTheRight = r14;
        this.btnKeyHideAppAllWindows = r15;
        this.btnKeyHideOtherAppWindow = r16;
        this.btnKeyLock = r17;
        this.btnKeyMinimizeCurrentWindow = r18;
        this.btnKeyMinimizeOtherWindow = r19;
        this.btnKeyMultiTasks = r20;
        this.btnKeyMultiTasksWithinApp = r21;
        this.btnKeyNotificationCenter = r22;
        this.btnKeyOpenNewFileManagerWindow = r23;
        this.btnKeyOrganizeSmallWindow = r24;
        this.btnKeyQuickSwitchCenter = r25;
        this.btnKeyResumeWindow = r26;
        this.btnKeyScrapbookDrawer = r27;
        this.btnKeyScreenShot = r28;
        this.btnKeyScreenShotFull = r29;
        this.btnKeyTitleBarSwitch = r30;
        this.btnResetAllKeys = r31;
        this.pageContainer = r32;
        this.pageScrollview = r33;
        this.viewTitle = r34;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevoneCustomKeyboardSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneCustomKeyboardSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_custom_keyboard_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneCustomKeyboardSettingsBinding bind(View r36) {
        int r1 = R.id.btn_key_album_drawer;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_album_drawer);
        if (r5 == null) goto L67;
        r1 = R.id.btn_key_app_drawer;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_app_drawer);
        if (r6 == null) goto L67;
        r1 = R.id.btn_key_close_all;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_close_all);
        if (r7 == null) goto L67;
        r1 = R.id.btn_key_close_other_window;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_close_other_window);
        if (r8 == null) goto L67;
        r1 = R.id.btn_key_close_window;
        SettingItemText r9 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_close_window);
        if (r9 == null) goto L67;
        r1 = R.id.btn_key_desktop;
        SettingItemText r10 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_desktop);
        if (r10 == null) goto L67;
        r1 = R.id.btn_key_exit_app;
        SettingItemText r11 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_exit_app);
        if (r11 == null) goto L67;
        r1 = R.id.btn_key_file_drawer;
        SettingItemText r12 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_file_drawer);
        if (r12 == null) goto L67;
        r1 = R.id.btn_key_fullscreen;
        SettingItemText r13 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_fullscreen);
        if (r13 == null) goto L67;
        r1 = R.id.btn_key_fullscreen_to_the_left;
        SettingItemText r14 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_fullscreen_to_the_left);
        if (r14 == null) goto L67;
        r1 = R.id.btn_key_fullscreen_to_the_right;
        SettingItemText r15 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_fullscreen_to_the_right);
        if (r15 == null) goto L67;
        r1 = R.id.btn_key_hide_app_all_windows;
        SettingItemText r16 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_hide_app_all_windows);
        if (r16 == null) goto L67;
        r1 = R.id.btn_key_hide_other_app_window;
        SettingItemText r17 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_hide_other_app_window);
        if (r17 == null) goto L67;
        r1 = R.id.btn_key_lock;
        SettingItemText r18 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_lock);
        if (r18 == null) goto L67;
        r1 = R.id.btn_key_minimize_current_window;
        SettingItemText r19 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_minimize_current_window);
        if (r19 == null) goto L67;
        r1 = R.id.btn_key_minimize_other_window;
        SettingItemText r20 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_minimize_other_window);
        if (r20 == null) goto L67;
        r1 = R.id.btn_key_multi_tasks;
        SettingItemText r21 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_multi_tasks);
        if (r21 == null) goto L67;
        r1 = R.id.btn_key_multi_tasks_within_app;
        SettingItemText r22 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_multi_tasks_within_app);
        if (r22 == null) goto L67;
        r1 = R.id.btn_key_notification_center;
        SettingItemText r23 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_notification_center);
        if (r23 == null) goto L67;
        r1 = R.id.btn_key_open_new_file_manager_window;
        SettingItemText r24 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_open_new_file_manager_window);
        if (r24 == null) goto L67;
        r1 = R.id.btn_key_organize_small_window;
        SettingItemText r25 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_organize_small_window);
        if (r25 == null) goto L67;
        r1 = R.id.btn_key_quick_switch_center;
        SettingItemText r26 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_quick_switch_center);
        if (r26 == null) goto L67;
        r1 = R.id.btn_key_resume_window;
        SettingItemText r27 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_resume_window);
        if (r27 == null) goto L67;
        r1 = R.id.btn_key_scrapbook_drawer;
        SettingItemText r28 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_scrapbook_drawer);
        if (r28 == null) goto L67;
        r1 = R.id.btn_key_screen_shot;
        SettingItemText r29 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_screen_shot);
        if (r29 == null) goto L67;
        r1 = R.id.btn_key_screen_shot_full;
        SettingItemText r30 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_screen_shot_full);
        if (r30 == null) goto L67;
        r1 = R.id.btn_key_title_bar_switch;
        SettingItemText r31 = (SettingItemText) ViewBindings.findChildViewById(r36, R.id.btn_key_title_bar_switch);
        if (r31 == null) goto L67;
        r1 = R.id.btn_reset_all_keys;
        OButton r32 = (OButton) ViewBindings.findChildViewById(r36, R.id.btn_reset_all_keys);
        if (r32 == null) goto L67;
        r1 = R.id.page_container;
        LinearLayout r33 = (LinearLayout) ViewBindings.findChildViewById(r36, R.id.page_container);
        if (r33 == null) goto L67;
        r1 = R.id.page_scrollview;
        OScrollView r34 = (OScrollView) ViewBindings.findChildViewById(r36, R.id.page_scrollview);
        if (r34 == null) goto L67;
        r1 = R.id.view_title;
        OFloatingTitleBar r35 = (OFloatingTitleBar) ViewBindings.findChildViewById(r36, R.id.view_title);
        if (r35 == null) goto L67;
        return new RevoneCustomKeyboardSettingsBinding((RelativeLayout) r36, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35);
    L67:
        throw new NullPointerException("Missing required view with ID: ".concat(r36.getResources().getResourceName(r1)));
    }
}
