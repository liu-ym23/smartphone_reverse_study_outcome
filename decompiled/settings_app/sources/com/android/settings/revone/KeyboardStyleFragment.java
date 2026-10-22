package com.android.settings.revone;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class KeyboardStyleFragment extends BaseFragment implements View.OnClickListener {
    private SettingItemCheck mStyleLarge;
    private SettingItemCheck mStyleSmall;

    public void com_android_settings_revone_KeyboardStyleFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_KeyboardStyleFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_KeyboardStyleFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_KeyboardStyleFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public KeyboardStyleFragment() {
        super(R.layout.keyboard_style_settings);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        this.mStyleLarge = (SettingItemCheck) findViewByIdNullable(R.id.keyboard_large);
        this.mStyleSmall = (SettingItemCheck) findViewByIdNullable(R.id.keyboard_small);
        updateView(Settings.Global.getInt(getContentResolver(), "keyboard_style", 0));
        this.mStyleLarge.setOnClickListener(this);
        this.mStyleSmall.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        int r4 = r3.getId();
        int r1 = 0;
        if (r4 != R.id.keyboard_large) goto L5;
    L8:
        updateView(r1);
        Settings.Global.putInt(getContentResolver(), "keyboard_style", r1);
        return;
    L5:
        if (r4 != R.id.keyboard_small) goto L8;
        r1 = 1;
        goto L8
    }

    private void updateView(int r5) {
        SettingItemCheck r0 = this.mStyleLarge;
        boolean r1 = false;
        if (r5 != 0) goto L5;
        boolean r3 = true;
    L6:
        r0.setChecked(r3);
        SettingItemCheck r4 = this.mStyleSmall;
        if (r5 != 1) goto L9;
        r1 = true;
    L9:
        r4.setChecked(r1);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_KeyboardStyleFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(KeyboardStyleFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_KeyboardStyleFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_KeyboardStyleFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(KeyboardStyleFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_KeyboardStyleFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_KeyboardStyleFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(KeyboardStyleFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_KeyboardStyleFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
