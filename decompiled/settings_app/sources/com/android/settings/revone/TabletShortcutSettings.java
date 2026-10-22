package com.android.settings.revone;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.SettingsTracker;
import com.android.settings.TrackerConstants;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class TabletShortcutSettings extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    private SettingItemSwitch mGlobalSwitch;
    private int mShortcutValue;
    private View mSwitchContainer;
    private SettingItemSwitch mSwitchL1;
    private SettingItemSwitch mSwitchL2;
    private SettingItemSwitch mSwitchL3;
    private SettingItemSwitch mSwitchL4;
    private SettingItemSwitch mSwitchL5;
    private ArrayList<SettingItemSwitch> mSwitchList;
    private SettingItemSwitch mSwitchR1;
    private SettingItemSwitch mSwitchR2;
    private SettingItemSwitch mSwitchR3;
    private SettingItemSwitch mSwitchR4;
    private SettingItemSwitch mSwitchR5;

    public void com_android_settings_revone_TabletShortcutSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_TabletShortcutSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_TabletShortcutSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_TabletShortcutSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TabletShortcutSettings() {
        super(R.layout.tablet_shortcut_layout);
        this.mSwitchList = new ArrayList();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        this.mGlobalSwitch = (SettingItemSwitch) findViewByIdNullable(R.id.global_toggle);
        this.mSwitchL1 = (SettingItemSwitch) findViewByIdNullable(R.id.btn_l1);
        this.mSwitchL2 = (SettingItemSwitch) findViewByIdNullable(R.id.btn_l2);
        this.mSwitchL3 = (SettingItemSwitch) findViewByIdNullable(R.id.btn_l3);
        this.mSwitchL4 = (SettingItemSwitch) findViewByIdNullable(R.id.btn_l4);
        this.mSwitchL5 = (SettingItemSwitch) findViewByIdNullable(R.id.btn_l5);
        this.mSwitchR1 = (SettingItemSwitch) findViewByIdNullable(R.id.btn_r1);
        this.mSwitchR2 = (SettingItemSwitch) findViewByIdNullable(R.id.btn_r2);
        this.mSwitchR3 = (SettingItemSwitch) findViewByIdNullable(R.id.btn_r3);
        this.mSwitchR4 = (SettingItemSwitch) findViewByIdNullable(R.id.btn_r4);
        this.mSwitchR5 = (SettingItemSwitch) findViewByIdNullable(R.id.btn_r5);
        this.mSwitchL1.setTag(1);
        this.mSwitchL2.setTag(2);
        this.mSwitchL3.setTag(4);
        this.mSwitchL4.setTag(8);
        this.mSwitchL5.setTag(16);
        this.mSwitchR1.setTag(32);
        this.mSwitchR2.setTag(64);
        this.mSwitchR3.setTag(128);
        this.mSwitchR4.setTag(256);
        this.mSwitchR5.setTag(512);
        this.mSwitchList.clear();
        this.mSwitchList.add(this.mSwitchL1);
        this.mSwitchList.add(this.mSwitchL2);
        this.mSwitchList.add(this.mSwitchL3);
        this.mSwitchList.add(this.mSwitchL4);
        this.mSwitchList.add(this.mSwitchL5);
        this.mSwitchList.add(this.mSwitchR1);
        this.mSwitchList.add(this.mSwitchR2);
        this.mSwitchList.add(this.mSwitchR3);
        this.mSwitchList.add(this.mSwitchR4);
        this.mSwitchList.add(this.mSwitchR5);
        Iterator<SettingItemSwitch> r4 = this.mSwitchList.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        SettingItemSwitch r5 = r4.next();
        r5.setOnCheckedChangeListener(this);
        r5.getSwitch().setTag(Integer.valueOf(r5.getId()));
        goto L4
    L6:
        this.mSwitchContainer = findViewByIdNullable(R.id.switch_list_views);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mGlobalSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void updateViews() {
        boolean r2 = true;
        if (Settings.Global.getInt(getContentResolver(), "tablet_shortcut_button_switch", 1) == 1) goto L6;
        r2 = false;
    L6:
        this.mGlobalSwitch.setChecked(r2);
        View r0 = this.mSwitchContainer;
        if (r2 == false) goto L9;
        int r3 = 0;
    L10:
        r0.setVisibility(r3);
        this.mShortcutValue = Settings.Global.getInt(getContentResolver(), "tablet_enabled_shortcut_buttons", 0);
        Iterator<SettingItemSwitch> r1 = this.mSwitchList.iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        updateSwitchState(r1.next());
        goto L12
    L14:
        return;
    L9:
        r3 = 8;
        goto L10
    }

    private void updateSwitchState(SettingItemSwitch r2) {
        int r0 = ((Integer) r2.getTag()).intValue();
        if ((this.mShortcutValue & r0) <= 0) goto L5;
        boolean r1 = true;
    L6:
        r2.setChecked(r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r4, boolean r5) {
        int r6 = ((Integer) r4.getTag()).intValue();
        if (r6 == R.id.global_toggle) goto L16;
        switch(r6) {
            case 2131427899: goto L7;
            case 2131427900: goto L7;
            case 2131427901: goto L7;
            case 2131427902: goto L7;
            case 2131427903: goto L7;
            default: goto L5;
        };
    L5:
        switch(r6) {
            case 2131427912: goto L7;
            case 2131427913: goto L7;
            case 2131427914: goto L7;
            case 2131427915: goto L7;
            case 2131427916: goto L7;
            default: goto L25;
        };
    L25:
        return;
    L7:
        int r0 = ((Integer) findViewByIdNullable(r6).getTag()).intValue();
        if (r0 <= 0) goto L14;
        this.mShortcutValue = r0 ^ this.mShortcutValue;
        Settings.Global.putInt(getContentResolver(), "tablet_enabled_shortcut_buttons", this.mShortcutValue);
        Iterator<SettingItemSwitch> r1 = this.mSwitchList.iterator();
    L11:
        if (r1.hasNext() == false) goto L14;
        updateSwitchState(r1.next());
    L14:
        if (r6 != R.id.btn_l3) goto L23;
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.LOCAL_SEARCH, r5);
        return;
    L23:
        return;
    L16:
        Settings.Global.putInt(getContentResolver(), "tablet_shortcut_button_switch", r5 ? 1 : 0);
        View r3 = this.mSwitchContainer;
        if (r5 == false) goto L19;
        int r7 = 0;
    L20:
        r3.setVisibility(r7);
        return;
    L19:
        r7 = 8;
        goto L20
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_TabletShortcutSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TabletShortcutSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TabletShortcutSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TabletShortcutSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TabletShortcutSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_TabletShortcutSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TabletShortcutSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TabletShortcutSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TabletShortcutSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
