package com.android.settings.specialaccess.datausage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.datausage.DataSaverBackend;
import com.android.settings.specialaccess.SpecialAccessBaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.drawer.EntriesProvider;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.lisitem.OListItemSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: DataSaverSummaryActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0014J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/settings/specialaccess/datausage/DataSaverSummaryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "dataSaverBackend", "Lcom/android/settings/datausage/DataSaverBackend;", "dataSaverBackendListener", "com/android/settings/specialaccess/datausage/DataSaverSummaryActivity$dataSaverBackendListener$1", "Lcom/android/settings/specialaccess/datausage/DataSaverSummaryActivity$dataSaverBackendListener$1;", "oDataSaver", "Lcom/obric/oui/lisitem/OListItemGeneral;", "oSwitch", "Lcom/obric/oui/lisitem/OListItemSwitch;", "switching", "", "isLightStatusBar", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onSwitchChanged", EntriesProvider.METHOD_IS_CHECKED, "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DataSaverSummaryActivity extends AppCompatActivity {
    private final String TAG;
    private DataSaverBackend dataSaverBackend;
    private final DataSaverSummaryActivity$dataSaverBackendListener$1 dataSaverBackendListener;
    private OListItemGeneral oDataSaver;
    private OListItemSwitch oSwitch;
    private boolean switching;

    /* JADX INFO: renamed from: $r8$lambda$02O1CEMDPYXD-seqbEaLe4Hz5ss, reason: not valid java name */
    public static /* synthetic */ void m610$r8$lambda$02O1CEMDPYXDseqbEaLe4Hz5ss(DataSaverSummaryActivity r0, View r1) {
        onCreate$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$l2yIW5WmEvjvslDI2t9qHQiFrIQ(DataSaverSummaryActivity r0, CompoundButton r1, boolean r2) {
        onCreate$lambda$1$lambda$0(r0, r1, r2);
    }

    public void com_android_settings_specialaccess_datausage_DataSaverSummaryActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_specialaccess_datausage_DataSaverSummaryActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.android.settings.specialaccess.datausage.DataSaverSummaryActivity$dataSaverBackendListener$1] */
    public DataSaverSummaryActivity() {
        this.TAG = "DataSaverSummaryActivity";
        this.dataSaverBackendListener = new DataSaverSummaryActivity$dataSaverBackendListener$1(this);
    }

    public static final /* synthetic */ OListItemSwitch access$getOSwitch$p(DataSaverSummaryActivity r0) {
        return r0.oSwitch;
    }

    public static final /* synthetic */ void access$setSwitching$p(DataSaverSummaryActivity r0, boolean r1) {
        r0.switching = r1;
    }

    public void com_android_settings_specialaccess_datausage_DataSaverSummaryActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.activity_data_saver_summary);
        getWindow().getDecorView().setSystemUiVisibility(1792);
        getWindow().addFlags(Integer.MIN_VALUE);
        DataSaverSummaryActivity r0 = this;
        getWindow().setStatusBarColor(ContextCompat.getColor(r0, R.color.some_activities_bg_color));
        getWindow().setNavigationBarColor(0);
        UIUtils.setUpFakeStatusBarOnApplyWindowInsets(findViewById(R.id.fake_status_bar));
        SpecialAccessBaseActivity.setLightStatusBarIcon(getWindow(), isLightStatusBar());
        this.dataSaverBackend = new DataSaverBackend(r0);
        OListItemSwitch r4 = (OListItemSwitch) findViewById(R.id.data_saver_switch);
        this.oSwitch = r4;
        if (r4 == null) goto L8;
        DataSaverBackend r1 = this.dataSaverBackend;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("dataSaverBackend");
        r1 = null;
    L7:
        r4.setChecked(r1.isDataSaverEnabled());
        r4.setOnCheckedChangeListener(new DataSaverSummaryActivity$$ExternalSyntheticLambda0(this));
    L8:
        OListItemGeneral r5 = (OListItemGeneral) findViewById(R.id.data_saver);
        this.oDataSaver = r5;
        if (r5 == null) goto L12;
        r5.setOnClickListener(new DataSaverSummaryActivity$$ExternalSyntheticLambda1(this));
        return;
    }

    private static final void onCreate$lambda$1$lambda$0(DataSaverSummaryActivity r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "<anonymous parameter 0>");
        r1.onSwitchChanged(r3);
    }

    private static final void onCreate$lambda$2(DataSaverSummaryActivity r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Utils.startActivity(r2, new Intent(r2, DataSaverActivity.class));
    }

    protected final boolean isLightStatusBar() {
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L5;
        return true;
    L5:
        return false;
    }

    public void com_android_settings_specialaccess_datausage_DataSaverSummaryActivity__onResume$___twin___() {
        super.onResume();
        DataSaverBackend r0 = this.dataSaverBackend;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataSaverBackend");
        r0 = null;
    L5:
        r0.addListener(this.dataSaverBackendListener);
    }

    public void com_android_settings_specialaccess_datausage_DataSaverSummaryActivity__onPause$___twin___() {
        super.onPause();
        DataSaverBackend r0 = this.dataSaverBackend;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataSaverBackend");
        r0 = null;
    L5:
        r0.remListener(this.dataSaverBackendListener);
    }

    private final void onSwitchChanged(boolean r2) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.switching == true) goto L9;
        this.switching = true;     // Catch: Throwable -> L12
        DataSaverBackend r0 = this.dataSaverBackend;     // Catch: Throwable -> L12
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataSaverBackend");     // Catch: Throwable -> L12
        r0 = null;
    L8:
        r0.setDataSaverEnabled(r2);     // Catch: Throwable -> L12
    L9:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DataSaverSummaryActivity r1) {
        r1.com_android_settings_specialaccess_datausage_DataSaverSummaryActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(DataSaverSummaryActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(DataSaverSummaryActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_datausage_DataSaverSummaryActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        DataSaverSummaryActivity r5 = r4;
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
    public static void com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(DataSaverSummaryActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_specialaccess_datausage_DataSaverSummaryActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(DataSaverSummaryActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(DataSaverSummaryActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_datausage_DataSaverSummaryActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_specialaccess_datausage_DataSaverSummaryActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(DataSaverSummaryActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_specialaccess_datausage_DataSaverSummaryActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        DataSaverSummaryActivity r5 = r3;
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
}
