package com.android.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.vpn2.VpnConfigFragment;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class VpnAdvancedOptionsActivity extends BaseActivity {
    private OInputLayout mDnsServers;
    private OInputLayout mRoutes;
    private OInputLayout mSearchDomains;

    public void com_android_settings_VpnAdvancedOptionsActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_VpnAdvancedOptionsActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_VpnAdvancedOptionsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_VpnAdvancedOptionsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public VpnAdvancedOptionsActivity() {
    }

    public void com_android_settings_VpnAdvancedOptionsActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.vpn_config_advanced_options_layout);
        setupBackBtnOnTitle(false);
        setTitleName(R.string.vpn_advanced_options);
        int r0 = getResources().getDimensionPixelSize(R.dimen.dimen_20);
        OCardListItem r1 = (OCardListItem) findViewById(R.id.search_domains);
        OInputLayout r2 = (OInputLayout) r1.getCustomStartView();
        this.mSearchDomains = r2;
        r2.setHint(getString(R.string.vpn_not_used));
        this.mSearchDomains.setLabel(getString(R.string.vpn_search_domains));
        this.mSearchDomains.showLabel(true);
        this.mSearchDomains.setMaxLines(1);
        this.mSearchDomains.showClear(true);
        this.mSearchDomains.setLimitCount(32);
        this.mSearchDomains.setInputType(1);
        r1.customDivider(r0, r0);
        r1.showDivider(true);
        OCardListItem r3 = (OCardListItem) findViewById(R.id.dns_servers);
        r3.customDivider(r0, r0);
        r3.showDivider(true);
        OInputLayout r4 = (OInputLayout) r3.getCustomStartView();
        this.mDnsServers = r4;
        r4.setHint(getString(R.string.vpn_not_used));
        this.mDnsServers.setLabel(getString(R.string.vpn_dns_servers));
        this.mDnsServers.showLabel(true);
        this.mDnsServers.setMaxLines(1);
        this.mDnsServers.showClear(true);
        this.mDnsServers.setLimitCount(32);
        this.mDnsServers.setType(3);
        OCardListItem r5 = (OCardListItem) findViewById(R.id.routes);
        r5.customDivider(r0, r0);
        r5.showDivider(false);
        OInputLayout r8 = (OInputLayout) r5.getCustomStartView();
        this.mRoutes = r8;
        r8.setHint(getString(R.string.vpn_not_used));
        this.mRoutes.setLabel(getString(R.string.vpn_routes));
        this.mRoutes.showLabel(true);
        this.mRoutes.setMaxLines(1);
        this.mRoutes.showClear(true);
        this.mRoutes.setLimitCount(32);
        this.mRoutes.setType(3);
        String r9 = getIntent().getStringExtra(VpnConfigFragment.EXTRA_SEARCH_DOMAINS);
        this.mSearchDomains.setText(r9);
        this.mSearchDomains.getVInput().setSelection(r9.length());
        String r10 = getIntent().getStringExtra(VpnConfigFragment.EXTRA_DNS_SERVERS);
        this.mDnsServers.setText(r10);
        this.mDnsServers.getVInput().setSelection(r10.length());
        String r11 = getIntent().getStringExtra(VpnConfigFragment.EXTRA_ROUTES);
        this.mRoutes.setText(r11);
        this.mRoutes.getVInput().setSelection(r11.length());
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) findViewById(R.id.page_container));
    }

    public void com_android_settings_VpnAdvancedOptionsActivity__finish$___twin___() {
        Intent r0 = new Intent();
        r0.putExtra(VpnConfigFragment.EXTRA_SEARCH_DOMAINS, this.mSearchDomains.getVInput().getText().toString().trim());
        r0.putExtra(VpnConfigFragment.EXTRA_DNS_SERVERS, this.mDnsServers.getVInput().getText().toString().trim());
        r0.putExtra(VpnConfigFragment.EXTRA_ROUTES, this.mRoutes.getVInput().getText().toString().trim());
        setResult(-1, r0);
        super.finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_VpnAdvancedOptionsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(VpnAdvancedOptionsActivity r1) {
        com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(VpnAdvancedOptionsActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        VpnAdvancedOptionsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_VpnAdvancedOptionsActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(VpnAdvancedOptionsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(VpnAdvancedOptionsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        VpnAdvancedOptionsActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(VpnAdvancedOptionsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_VpnAdvancedOptionsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(VpnAdvancedOptionsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_VpnAdvancedOptionsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_PrivacyHook_onResume(VpnAdvancedOptionsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        VpnAdvancedOptionsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_VpnAdvancedOptionsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(VpnAdvancedOptionsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_PrivacyHook_onPause(VpnAdvancedOptionsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        VpnAdvancedOptionsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_VpnAdvancedOptionsActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(VpnAdvancedOptionsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        VpnAdvancedOptionsActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_PrivacyHook_onStop(VpnAdvancedOptionsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        VpnAdvancedOptionsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_VpnAdvancedOptionsActivity__onStop$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_VpnAdvancedOptionsActivity_com_obric_hook_lancet_PrivacyHook_finish(VpnAdvancedOptionsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        VpnAdvancedOptionsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_VpnAdvancedOptionsActivity__finish$___twin___();
    }
}
