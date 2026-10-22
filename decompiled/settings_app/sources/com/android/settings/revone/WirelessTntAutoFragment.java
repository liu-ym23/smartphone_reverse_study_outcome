package com.android.settings.revone;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.SettingsProviderUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class WirelessTntAutoFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    private static final int UPDATE_VIEW_DELAY_TIME = 100;
    private Handler mHandler;
    private ContentObserver mSideDialTypeObserver;
    private SettingItemSwitch mWirelessLighten;
    private View mWirelessLightenTips;
    private SettingItemSwitch mWirelessTntAuto;
    private ContentObserver mWirelessTntAutoObserver;

    /* JADX INFO: renamed from: com.android.settings.revone.WirelessTntAutoFragment$1, reason: invalid class name */
    class AnonymousClass1 extends ContentObserver {
        final /* synthetic */ WirelessTntAutoFragment this$0;

        AnonymousClass1(WirelessTntAutoFragment r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r4) {
            WirelessTntAutoFragment.access$000(this.this$0).postDelayed(new WirelessTntAutoFragment$1$$ExternalSyntheticLambda0(this), 100);
        }

        /* JADX INFO: renamed from: lambda$onChange$0$com-android-settings-revone-WirelessTntAutoFragment$1, reason: not valid java name */
        /* synthetic */ void m562x1115d112() {
            WirelessTntAutoFragment.access$100(this.this$0);
        }
    }

    /* JADX INFO: renamed from: com.android.settings.revone.WirelessTntAutoFragment$2, reason: invalid class name */
    class AnonymousClass2 extends ContentObserver {
        final /* synthetic */ WirelessTntAutoFragment this$0;

        AnonymousClass2(WirelessTntAutoFragment r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r4) {
            WirelessTntAutoFragment.access$000(this.this$0).postDelayed(new WirelessTntAutoFragment$2$$ExternalSyntheticLambda0(this), 100);
        }

        /* JADX INFO: renamed from: lambda$onChange$0$com-android-settings-revone-WirelessTntAutoFragment$2, reason: not valid java name */
        /* synthetic */ void m563x1115d113() {
            WirelessTntAutoFragment.access$100(this.this$0);
        }
    }

    public void com_android_settings_revone_WirelessTntAutoFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_WirelessTntAutoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_WirelessTntAutoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ Handler access$000(WirelessTntAutoFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$100(WirelessTntAutoFragment r0) {
        r0.updateViews();
    }

    public WirelessTntAutoFragment() {
        super(R.layout.wireless_tnt_auto_layout);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mSideDialTypeObserver = new AnonymousClass1(this, null);
        this.mWirelessTntAutoObserver = new AnonymousClass2(this, null);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mWirelessTntAuto = (SettingItemSwitch) findViewByIdNullable(R.id.wireless_tnt_auto);
        this.mWirelessLighten = (SettingItemSwitch) findViewByIdNullable(R.id.wireless_lighten);
        this.mWirelessLightenTips = findViewByIdNullable(R.id.wireless_lighten_tips);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mWirelessTntAuto.setOnCheckedChangeListener(this);
        this.mWirelessLighten.setOnCheckedChangeListener(this);
    }

    public void com_android_settings_revone_WirelessTntAutoFragment__onResume$___twin___() {
        super.onResume();
        registerContentObserver();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unRegisterContentObserver();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r4, boolean r5) {
        if (r4 != this.mWirelessTntAuto.getSwitch()) goto L14;
        Settings.Global.putInt(getContentResolver(), "wireless_tnt_auto", r5 ? 1 : 0);
        SettingItemSwitch r6 = this.mWirelessLighten;
        int r0 = 0;
        if (r5 == false) goto L7;
        int r2 = 0;
    L8:
        r6.setVisibility(r2);
        View r3 = this.mWirelessLightenTips;
        if (r5 == true) goto L12;
        r0 = 8;
    L12:
        r3.setVisibility(r0);
        return;
    L7:
        r2 = 8;
        goto L8
    L14:
        if (r4 != this.mWirelessLighten.getSwitch()) goto L18;
        Settings.Global.putInt(getContentResolver(), "wireless_lighten_auto", r5 ? 1 : 0);
        return;
    }

    private void updateViews() {
        if (Settings.Global.getInt(getContentResolver(), "wireless_tnt_auto", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        this.mWirelessTntAuto.setChecked(r0);
        SettingItemSwitch r3 = this.mWirelessLighten;
        if (r0 == false) goto L9;
        int r5 = 0;
    L10:
        r3.setVisibility(r5);
        View r4 = this.mWirelessLightenTips;
        if (r0 == false) goto L13;
        int r1 = 0;
    L14:
        r4.setVisibility(r1);
        SettingItemSwitch r2 = this.mWirelessLighten;
        if (Settings.Global.getInt(getContentResolver(), "wireless_lighten_auto", 1) != 1) goto L17;
        boolean r6 = true;
    L18:
        r2.setChecked(r6);
        if (SettingsProviderUtils.getSideDialType(this.mContext) != 2) goto L21;
        this.mWirelessTntAuto.setEnabled(false);
        this.mWirelessTntAuto.setSummary(R.string.wireless_tnt_auto_summary);
        return;
    L21:
        this.mWirelessTntAuto.setEnabled(true);
        this.mWirelessTntAuto.getSummaryView().setVisibility(8);
        return;
    L17:
        r6 = false;
        goto L18
    L13:
        r1 = 8;
        goto L14
    L9:
        r5 = 8;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private void registerContentObserver() {
        ContentResolver r0 = getContentResolver();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.registerContentObserver(Settings.Global.getUriFor("side_dial_type"), true, this.mSideDialTypeObserver);
        r0.registerContentObserver(Settings.Global.getUriFor("wireless_tnt_auto"), true, this.mWirelessTntAutoObserver);
    }

    private void unRegisterContentObserver() {
        ContentResolver r0 = getContentResolver();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.unregisterContentObserver(this.mSideDialTypeObserver);
        r0.unregisterContentObserver(this.mWirelessTntAutoObserver);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_WirelessTntAutoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WirelessTntAutoFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_WirelessTntAutoFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_WirelessTntAutoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WirelessTntAutoFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_WirelessTntAutoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_WirelessTntAutoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WirelessTntAutoFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_WirelessTntAutoFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
