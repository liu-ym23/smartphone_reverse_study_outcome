package com.android.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class MenuMoveDownSettingFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static final int MOVE_DOWN_ALWAYS = 0;
    public static final int MOVE_DOWN_AT_LAUNCHER = 1;
    public static final int MOVE_DOWN_IN_APP = 2;
    private int keyCurrentSelected;
    private SettingItemSwitch mMenuMoveDownNc;
    private boolean mMenuMovedownEnabled;
    private SettingItemCheck mMovedownAlways;
    private SettingItemCheck mMovedownAtLauncher;
    private SettingItemCheck mMovedownInApp;

    public void com_android_settings_MenuMoveDownSettingFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_MenuMoveDownSettingFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_MenuMoveDownSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_MenuMoveDownSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public MenuMoveDownSettingFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.menu_movedown_setting_layout, r3, false);
        this.mMenuMoveDownNc = (SettingItemSwitch) findViewByIdNullable(R.id.move_down_nc);
        this.mMovedownAlways = (SettingItemCheck) findViewByIdNullable(R.id.move_down_always);
        this.mMovedownAtLauncher = (SettingItemCheck) findViewByIdNullable(R.id.move_down_when_in_launcher);
        this.mMovedownInApp = (SettingItemCheck) findViewByIdNullable(R.id.move_down_when_in_app);
        this.mMovedownAlways.setOnClickListener(this);
        this.mMovedownAtLauncher.setOnClickListener(this);
        this.mMovedownInApp.setOnClickListener(this);
        loadOriginalPrefer();
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r3) {
        super.onViewStateRestored(r3);
        updateSelectedItemView();
        boolean r1 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "menu_move_down_nc", 0) != 1) goto L5;
        r1 = true;
    L5:
        this.mMenuMovedownEnabled = r1;
        this.mMenuMoveDownNc.setChecked(r1);
        this.mMenuMoveDownNc.setOnCheckedChangeListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        boolean r2 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "menu_move_down_nc", 0) != 1) goto L5;
        r2 = true;
    L5:
        this.mMenuMovedownEnabled = r2;
        this.mMenuMoveDownNc.setChecked(r2);
        updateSelectedItemView();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mMenuMoveDownNc.getSwitch()) goto L6;
        this.mMenuMovedownEnabled = r3;
        updateSelectedItemView();
        android.provider.Settings.Global.putInt(getContentResolver(), "menu_move_down_nc", this.mMenuMovedownEnabled ? 1 : 0);
        return;
    }

    public void loadOriginalPrefer() {
        this.keyCurrentSelected = android.provider.Settings.Global.getInt(getContentResolver(), "menu_move_down_when", 0);
        updateSelectedItemView();
    }

    private void updateSelectedItemView() {
        this.mMovedownAlways.setChecked(false);
        this.mMovedownAtLauncher.setChecked(false);
        this.mMovedownInApp.setChecked(false);
        int r0 = this.keyCurrentSelected;
        if (r0 == 0) goto L10;
        if (r0 != 1) goto L6;
        this.mMovedownAtLauncher.setChecked(true);
    L11:
        this.mMovedownAlways.setEnabled(this.mMenuMovedownEnabled);
        this.mMovedownAtLauncher.setEnabled(this.mMenuMovedownEnabled);
        this.mMovedownInApp.setEnabled(this.mMenuMovedownEnabled);
        return;
    L6:
        if (r0 != 2) goto L11;
        this.mMovedownInApp.setChecked(true);
        goto L11
    L10:
        this.mMovedownAlways.setChecked(true);
        goto L11
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if ((r2 instanceof SettingItemCheck) == true) goto L5;
        return;
    L5:
        switch(r2.getId()) {
            case 2131429986: goto L9;
            case 2131429987: goto L6;
            case 2131429988: goto L8;
            case 2131429989: goto L7;
            default: goto L6;
        };
    L6:
        int r3 = -1;
    L11:
        if (this.keyCurrentSelected == r3) goto L15;
        this.keyCurrentSelected = r3;
        updateSelectedItemView();
        android.provider.Settings.Global.putInt(getContentResolver(), "menu_move_down_when", this.keyCurrentSelected);
        return;
    L15:
        return;
    L7:
        r3 = 1;
        goto L11
    L8:
        r3 = 2;
        goto L11
    L9:
        r3 = 0;
        goto L11
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_MenuMoveDownSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(MenuMoveDownSettingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_MenuMoveDownSettingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MenuMoveDownSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(MenuMoveDownSettingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_MenuMoveDownSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MenuMoveDownSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(MenuMoveDownSettingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_MenuMoveDownSettingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
