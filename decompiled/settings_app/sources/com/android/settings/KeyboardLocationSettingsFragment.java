package com.android.settings;

import android.os.Bundle;
import android.view.View;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class KeyboardLocationSettingsFragment extends BaseFragment implements View.OnClickListener {
    public static final int DEFAULT_LOCATION_SETTING_DEFAULT = 1;
    public static final int DEFAULT_LOCATION_SETTING_LEFT = 0;
    public static final int DEFAULT_LOCATION_SETTING_RIGHT = 2;
    public static final String KEYBOARD_DIALOG_DEFAULT_LOCATION = "keyboard_dialog_default_location";
    private ListContentItemCheck locationDefault;
    private ListContentItemCheck locationLeft;
    private ListContentItemCheck locationRight;

    public void com_android_settings_KeyboardLocationSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_KeyboardLocationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_KeyboardLocationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public KeyboardLocationSettingsFragment() {
        super(R.layout.keyboard_default_location_settings);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        initView();
        this.locationLeft.setOnClickListener(this);
        this.locationDefault.setOnClickListener(this);
        this.locationRight.setOnClickListener(this);
        updateListItem(android.provider.Settings.Global.getInt(getContentResolver(), KEYBOARD_DIALOG_DEFAULT_LOCATION, 1));
    }

    public void com_android_settings_KeyboardLocationSettingsFragment__onResume$___twin___() {
        super.onResume();
        updateListItem(android.provider.Settings.Global.getInt(getContentResolver(), KEYBOARD_DIALOG_DEFAULT_LOCATION, 1));
    }

    private void initView() {
        this.locationLeft = (ListContentItemCheck) findViewByIdNullable(R.id.default_location_setting_left);
        this.locationDefault = (ListContentItemCheck) findViewByIdNullable(R.id.default_location_setting_default);
        this.locationRight = (ListContentItemCheck) findViewByIdNullable(R.id.default_location_setting_right);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r6) {
        int r0 = 0;
        switch(r6.getId()) {
            case 2131428331: goto L7;
            case 2131428332: goto L6;
            case 2131428333: goto L5;
            default: goto L4;
        };
    L4:
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.VIRTUAL_KEYBOARD_POSITION, 0);
    L8:
        r0 = 1;
    L9:
        updateListItem(r0);
        android.provider.Settings.Global.putInt(getContentResolver(), KEYBOARD_DIALOG_DEFAULT_LOCATION, r0);
        finish();
        return;
    L5:
        r0 = 2;
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.VIRTUAL_KEYBOARD_POSITION, 2);
        goto L9
    L6:
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.VIRTUAL_KEYBOARD_POSITION, 1);
        goto L9
    L7:
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.VIRTUAL_KEYBOARD_POSITION, 0);
        goto L8
    }

    private void updateListItem(int r5) {
        ListContentItemCheck r0 = this.locationLeft;
        boolean r1 = false;
        if (r5 != 0) goto L5;
        boolean r3 = true;
    L6:
        r0.setChecked(r3);
        ListContentItemCheck r2 = this.locationDefault;
        if (r5 != 1) goto L9;
        boolean r4 = true;
    L10:
        r2.setChecked(r4);
        ListContentItemCheck r6 = this.locationRight;
        if (r5 != 2) goto L13;
        r1 = true;
    L13:
        r6.setChecked(r1);
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_KeyboardLocationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(KeyboardLocationSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_KeyboardLocationSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_KeyboardLocationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(KeyboardLocationSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_KeyboardLocationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_KeyboardLocationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(KeyboardLocationSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_KeyboardLocationSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
