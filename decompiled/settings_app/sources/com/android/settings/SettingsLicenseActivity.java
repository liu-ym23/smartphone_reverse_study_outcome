package com.android.settings;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.webkit.WebView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.platform.godzilla.common.Constant;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsLicenseActivity extends LifeHookActivity2 {
    private static final String DEFAULT_LICENSE_PATH = "/system/etc/NOTICE.html.gz";
    private static final boolean LOGV = false;
    private static final String PROPERTY_LICENSE_PATH = "ro.config.license_path";
    private static final String TAG = "SettingsLicenseActivity";
    private Handler mHandler;
    private ProgressDialog mSpinnerDlg;
    private AlertDialog mTextDlg;
    private WebView mWebView;

    private class LicenseFileLoader implements Runnable {
        private static final String INNER_TAG = "SettingsLicenseActivity.LicenseFileLoader";
        public static final int STATUS_EMPTY_FILE = 3;
        public static final int STATUS_NOT_FOUND = 1;
        public static final int STATUS_OK = 0;
        public static final int STATUS_READ_ERROR = 2;
        private String mFileName;
        private Handler mHandler;
        final /* synthetic */ SettingsLicenseActivity this$0;

        public LicenseFileLoader(SettingsLicenseActivity r1, String r2, Handler r3) {
            this.this$0 = r1;
            this.mFileName = r2;
            this.mHandler = r3;
        }

        /* JADX WARN: Not initialized variable reg: 4, insn: 0x00c0: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:42:0x00c0 */
        @Override // java.lang.Runnable
        public void run() {
            StringBuilder r1 = new StringBuilder(2048);
            InputStreamReader r3 = null;
            char[] r2 = new char[2048];     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L26
            if (this.mFileName.endsWith(".gz") == false) goto L6;
            InputStreamReader r4 = new InputStreamReader(new GZIPInputStream(new FileInputStream(this.mFileName)));     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L26
        L59:
            int r5 = r4.read(r2);     // Catch: IOException -> L14 FileNotFoundException -> L16 Throwable -> L41
            int r6 = 0;
            if (r5 < 0) goto L11;
            r1.append(r2, 0, r5);     // Catch: IOException -> L14 FileNotFoundException -> L16 Throwable -> L41
        L11:
            if (r4 != null) goto L52;
        L32:
            if (r6 == 0) goto L34;
        L36:
            Message r0 = this.mHandler.obtainMessage(r6, null);
            if (r6 != 0) goto L39;
            r0.obj = r1.toString();
        L39:
            this.mHandler.sendMessage(r0);
            return;
        L34:
            if (TextUtils.isEmpty(r1) == false) goto L36;
            OLog.e(INNER_TAG, "License HTML is empty (from " + this.mFileName + ")");
            r6 = 3;
            goto L36
        L52:
            r4.close();     // Catch: IOException -> L46
        L16:
            e = e;
        L28:
            OLog.e(INNER_TAG, "License HTML file not found at " + this.mFileName, e);     // Catch: Throwable -> L41
            if (r4 != null) goto L50;
        L31:
            r6 = 1;
            goto L32
        L50:
            r4.close();     // Catch: IOException -> L48
        L14:
            e = e;
        L22:
            OLog.e(INNER_TAG, "Error reading license HTML file at " + this.mFileName, e);     // Catch: Throwable -> L41
            if (r4 != null) goto L56;
        L25:
            r6 = 2;
            goto L32
        L56:
            r4.close();     // Catch: IOException -> L47
            goto L25
        L6:
            r4 = new FileReader(this.mFileName);     // Catch: Throwable -> L18 IOException -> L20 FileNotFoundException -> L26
        L41:
            th = th;
            r3 = r4;
        L43:
            if (r3 != null) goto L54;
        L45:
            throw th;
        L54:
            r3.close();     // Catch: IOException -> L49
        L26:
            e = e;
            r4 = null;
        L20:
            e = e;
            r4 = null;
        L18:
            th = th;
            goto L43
        }
    }

    public void com_android_settings_SettingsLicenseActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_SettingsLicenseActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_SettingsLicenseActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_SettingsLicenseActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    static /* synthetic */ void access$000(SettingsLicenseActivity r0, String r1) {
        r0.showPageOfText(r1);
    }

    static /* synthetic */ void access$100(SettingsLicenseActivity r0) {
        r0.showErrorAndFinish();
    }

    static /* synthetic */ ProgressDialog access$200(SettingsLicenseActivity r0) {
        return r0.mSpinnerDlg;
    }

    static /* synthetic */ AlertDialog access$300(SettingsLicenseActivity r0) {
        return r0.mTextDlg;
    }

    public SettingsLicenseActivity() {
        this.mHandler = null;
        this.mWebView = null;
        this.mSpinnerDlg = null;
        this.mTextDlg = null;
    }

    public void com_android_settings_SettingsLicenseActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        String r6 = SystemProperties.get(PROPERTY_LICENSE_PATH, DEFAULT_LICENSE_PATH);
        if (TextUtils.isEmpty(r6) == false) goto L6;
        OLog.e(TAG, "The system property for the license file is empty.");
        showErrorAndFinish();
        return;
    L6:
        setVisible(false);
        this.mWebView = new WebView(this);
        this.mHandler = new AnonymousClass1(this);
        ProgressDialog r1 = ProgressDialog.show(this, getText(R.string.settings_license_activity_title), getText(R.string.settings_license_activity_loading), true, false);
        r1.setProgressStyle(0);
        this.mSpinnerDlg = r1;
        new Thread(new LicenseFileLoader(this, r6, this.mHandler)).start();
    }

    public void com_android_settings_SettingsLicenseActivity__onDestroy$___twin___() {
        AlertDialog r0 = this.mTextDlg;
        if (r0 != null) goto L5;
    L7:
        ProgressDialog r1 = this.mSpinnerDlg;
        if (r1 != null) goto L10;
    L12:
        super.onDestroy();
        return;
    L10:
        if (r1.isShowing() == false) goto L12;
        this.mSpinnerDlg.dismiss();
        goto L12
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mTextDlg.dismiss();
        goto L7
    }

    private void showPageOfText(String r9) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(this, getResources().getInteger(R.integer.dialog_style_id));
        r0.setCancelable(true).setView(this.mWebView).setTitle(R.string.settings_license_activity_title);
        AlertDialog r1 = r0.create();
        this.mTextDlg = r1;
        r1.setOnDismissListener(new AnonymousClass2(this));
        this.mWebView.loadDataWithBaseURL(null, r9, "text/html", Constant.CHARSET_UTF_8, null);
        this.mWebView.setWebViewClient(new AnonymousClass3(this));
        this.mWebView = null;
    }

    private void showErrorAndFinish() {
        this.mSpinnerDlg.dismiss();
        this.mSpinnerDlg = null;
        ToastUtils.show(this, R.string.settings_license_activity_unavailable);
        finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_SettingsLicenseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SettingsLicenseActivity r1) {
        com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(SettingsLicenseActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SettingsLicenseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_SettingsLicenseActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(SettingsLicenseActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(SettingsLicenseActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        SettingsLicenseActivity r5 = r4;
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
    public static void com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(SettingsLicenseActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_SettingsLicenseActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(SettingsLicenseActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_SettingsLicenseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(SettingsLicenseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SettingsLicenseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_SettingsLicenseActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(SettingsLicenseActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(SettingsLicenseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SettingsLicenseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_SettingsLicenseActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(SettingsLicenseActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        SettingsLicenseActivity r5 = r3;
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
    public static void com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(SettingsLicenseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SettingsLicenseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_SettingsLicenseActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_SettingsLicenseActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(SettingsLicenseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SettingsLicenseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_SettingsLicenseActivity__onDestroy$___twin___();
    }
}
