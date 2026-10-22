package com.android.settings.settingitemsprovider;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.util.FeedbackLauncher;

/* JADX INFO: loaded from: classes2.dex */
public class SettingItemsLauncher extends LifeHookActivity2 {
    private static final String TAG = "SearchSettings";
    private ComponentName mComponent;
    private Context mContext;
    private AlertDialog mDialog;
    private String mExtra;
    private String mIntent;

    public void com_android_settings_settingitemsprovider_SettingItemsLauncher__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_settingitemsprovider_SettingItemsLauncher__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_settingitemsprovider_SettingItemsLauncher__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_settingitemsprovider_SettingItemsLauncher__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public SettingItemsLauncher() {
    }

    static /* synthetic */ Context access$000(SettingItemsLauncher r0) {
        return r0.mContext;
    }

    public void com_android_settings_settingitemsprovider_SettingItemsLauncher__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        this.mContext = this;
        Utils.setTranslucentStatusAndNavigation(this, getWindow());
        Intent r4 = getIntent();
        if (r4 != null) goto L7;
        finish();
        return;
    L7:
        if ("android.intent.action.MAIN".equals(r4.getAction()) == false) goto L10;
        launchApplication(r4.getData());
        return;
    }

    private void launchApplication(Uri r12) {
        uriToComponentName(r12);
        OLog.i(TAG, "Launching " + this.mComponent);
        String r0 = this.mIntent;
        if (r0 != null) goto L68;
    L8:
        Intent r1 = null;
    L10:
        if (r1 == null) goto L12;
    L30:
        if (r1 != null) goto L33;
        OLog.w(TAG, "null launchIntent, fromIntent: " + this.mIntent);
        finish();
        return;
    L33:
        r1.putExtra("from_search", true);
        processCustomData(r1);
        if (isFeedbackIntent(r1) == false) goto L41;
        r1.putExtra("start_from_setting", true);
        if (startFeedback(r1) == true) goto L38;
        OLog.d(TAG, "launchApplication, open feedback failed");
    L38:
        finish();
        return;
    L41:
        if (r1.getComponent() == null) goto L50;
        if (isIntentAvailable(r1) == true) goto L50;
        String r13 = r1.getComponent().getPackageName();
        if (com.android.settings.Constants.PKG_HAND_IN_HAND.equals(r13) == false) goto L47;
        showInstallDialog(r1.getComponent().getPackageName(), getString(R.string.hand_in_hand_dialog_title));
    L47:
        OLog.d(TAG, " No package installed : " + r13);
        finish();
        return;
    L50:
        if (r1.getComponent() != null) goto L52;
    L67:
        ActivityOptions.makeBasic();     // Catch: Throwable -> L59 ActivityNotFoundException -> L61
        if (Utils.isDesktop(this) == false) goto L57;
        startActivity(r1, GlobalProxyLancet.com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(getIntent(), "bytedanceos.intent.extra.SHOW_WINDOW_WITH_OPTIONS"));     // Catch: Throwable -> L59 ActivityNotFoundException -> L61
    L58:
        finish();
        return;
    L57:
        startActivity(r1);     // Catch: Throwable -> L59 ActivityNotFoundException -> L61
    L61:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L59
        OLog.w(TAG, "Activity not found: " + this.mComponent);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        finish();
        throw th;
    L52:
        if (r1.getComponent().getPackageName().equals("com.google.android.apps.safetyhub") == false) goto L67;
        r1.setAction(null);
        goto L67
    L12:
        if (this.mComponent == null) goto L30;
        r1 = new Intent("android.intent.action.MAIN");
        r1.setFlags(268468224);
        r1.setData(r12);
        r1.setComponent(this.mComponent);
        if (this.mExtra == null) goto L30;
        OLog.i(TAG, "extra : " + this.mExtra);
        String[] r14 = this.mExtra.split("\\|");
        int r5 = r14.length;
        int r6 = 0;
    L16:
        if (r6 >= r5) goto L30;
        String[] r7 = r14[r6].split("=");
        String r8 = r7[0];
        String r9 = r7[1];
        if (r9.startsWith("[") == false) goto L26;
        if (r9.endsWith("]") == false) goto L26;
        String[] r10 = r9.substring(1, r9.length() - 1).split(",");
        r1.putExtra(r8, r10);
        int r11 = 0;
    L23:
        if (r11 >= r10.length) goto L29;
        OLog.d(TAG, "value = " + r10[r11]);
        r11 = r11 + 1;
    L29:
        r6 = r6 + 1;
    L26:
        if (TextUtils.isDigitsOnly(r9) == false) goto L28;
        r1.putExtra(r8, Integer.valueOf(r9).intValue());
        goto L29
    L28:
        r1.putExtra(r8, r9);
        goto L29
    L68:
        r1 = Intent.parseUri(r0, 0);     // Catch: URISyntaxException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private boolean isFeedbackIntent(Intent r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.getComponent() == null) goto L8;
        if (com.android.settings.Constants.PKG_BUG2GO.equals(r1.getComponent().getPackageName()) == false) goto L8;
        return true;
    }

    private boolean startFeedback(final Intent r3) {
        return FeedbackLauncher.startFeedback(this, r3.getExtras(), new SettingItemsLauncher$$ExternalSyntheticLambda0(r3));
    }

    static /* synthetic */ void lambda$startFeedback$0(Intent r1, Intent r2) {
        r2.setAction(r1.getAction());
        r2.setData(r1.getData());
        Set<String> r3 = r1.getCategories();
        if (r3 == null) goto L8;
        Iterator<String> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        r2.addCategory(r4.next());
        goto L6
    L10:
        return;
    }

    public void uriToComponentName(Uri r6) {
        OLog.d(TAG, "URI is " + r6);
        if (r6 != null) goto L6;
        return;
    L6:
        if ("content".equals(r6.getScheme()) == true) goto L9;
        return;
    L9:
        if (SearchSuggestionProvider.AUTHORITY.equals(r6.getAuthority()) == true) goto L12;
        return;
    L12:
        if (r6.toString().contains("intent=") == true) goto L27;
    L17:
        List<String> r7 = r6.getPathSegments();
        if ("settingitems".equals(r7.get(0)) == true) goto L21;
        return;
    L21:
        if (r7.size() <= 2) goto L24;
        this.mComponent = new ComponentName(r7.get(1), r7.get(2));
    L24:
        if (r7.size() <= 3) goto L29;
        this.mExtra = r7.get(3);
        return;
    L29:
        return;
    L27:
        this.mIntent = r6.toString().substring(r6.toString().indexOf("intent=") + 7);     // Catch: IndexOutOfBoundsException -> L15
        OLog.d(TAG, "mIntent " + this.mIntent);     // Catch: IndexOutOfBoundsException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    protected boolean isIntentAvailable(Intent r1) {
        return Utils.isPackageInstalled(this.mContext, r1.getComponent().getPackageName());
    }

    private void showInstallDialog(final String r4, String r5) {
        AlertDialog r0 = this.mDialog;
        if (r0 == null) goto L7;
        if (r0.isShowing() == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r5) == true) goto L15;
        this.mDialog = new AlertDialog.Builder(this.mContext).setTitle(R.string.dlg_title_notice).setMessage(getString(R.string.install_package_message, new Object[]{r5})).setNegativeButton(android.R.string.cancel, new AnonymousClass3(this)).setPositiveButton(R.string.install_text, new AnonymousClass2(this, r4)).setOnCancelListener(new AnonymousClass1(this)).show();
        return;
    }

    private void processCustomData(Intent r7) {
        String r6 = r7.getDataString();
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.contains(com.android.settings.Constants.PKG_GLOBAL_ROAMING) == false) goto L9;
        r7.setData(null);
    L9:
        if (r6.contains(Utils.TOGGLEABLE_SERVICE_KEY) == false) goto L16;
        String[] r8 = r6.split("\\|");
        int r0 = r8.length;
        int r2 = 0;
    L11:
        if (r2 >= r0) goto L20;
        String[] r3 = r8[r2].split("=");
        if (r3.length <= 1) goto L15;
        r7.putExtra(r3[0], r3[1]);
    L15:
        r2 = r2 + 1;
        goto L11
    L20:
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_settingitemsprovider_SettingItemsLauncher_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SettingItemsLauncher r1) {
        com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(SettingItemsLauncher r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SettingItemsLauncher r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_settingitemsprovider_SettingItemsLauncher__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_BatchedActivityLancet_onResume(SettingItemsLauncher r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(SettingItemsLauncher r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        SettingItemsLauncher r5 = r4;
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
    public static void com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(SettingItemsLauncher r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_settingitemsprovider_SettingItemsLauncher__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_BatchedActivityLancet_onStop(SettingItemsLauncher r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_settingitemsprovider_SettingItemsLauncher_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_PrivacyHookActivity2_onResume(SettingItemsLauncher r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SettingItemsLauncher r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_settingitemsprovider_SettingItemsLauncher__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(SettingItemsLauncher r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_PrivacyHookActivity2_onPause(SettingItemsLauncher r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SettingItemsLauncher r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_settingitemsprovider_SettingItemsLauncher__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(SettingItemsLauncher r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        SettingItemsLauncher r5 = r3;
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
    public static void com_android_settings_settingitemsprovider_SettingItemsLauncher_com_obric_hook_lancet_PrivacyHookActivity2_onStop(SettingItemsLauncher r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SettingItemsLauncher r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_settingitemsprovider_SettingItemsLauncher__onStop$___twin___();
    }
}
