package com.android.settings;

import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.applications.RunningStateHelper;
import com.android.settings.base.BaseActivity;
import com.android.settings.permission.OpsManagerHelper;
import com.android.settings.permission.ReflectHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AppManageExternalStorageActivity extends BaseActivity {
    private static final String TAG = "ManageExternalStorageActivity";
    private ActivityManager mAM;
    private AppInfo mAppInfo;
    private AppOpsManager mAppOpsManager;
    private OListItemSwitch mCheckSwitch;
    private Dialog mDenyDialog;
    private AppAuthPermissionDialog mDialog;
    private boolean mGrantPermission;
    private boolean mIsDeny;
    private PackageManager mPM;
    private PackageInfo mPackageInfo;
    private String mPackageName;
    private final String mRequestedPermission;

    public class AppAuthPermissionDialog extends AlertDialog {
        private final DialogInterface.OnClickListener mAllowListener;
        private final DialogInterface.OnClickListener mDenyListener;
        private final DialogInterface.OnClickListener mDenyOnceListener;
        final /* synthetic */ AppManageExternalStorageActivity this$0;

        public AppAuthPermissionDialog(AppManageExternalStorageActivity r2, Context r3) {
            this.this$0 = r2;
            super(r3, 5);
            this.mDenyListener = new AnonymousClass1(this);
            this.mDenyOnceListener = new AnonymousClass2(this);
            this.mAllowListener = new AnonymousClass3(this);
            r2.mContext = r3;
            setCancelable(false);
            setupViews(r3, r3.getResources());
        }

        private void setupViews(Context r6, Resources r7) {
            LinearLayout r8 = (LinearLayout) LayoutInflater.from(r6).inflate(R.layout.bytedance_permission_dialog, null);
            TextView r0 = (TextView) r8.findViewById(R.id.name);
            TextView r1 = (TextView) r8.findViewById(R.id.detail);
            ImageView r2 = (ImageView) r8.findViewById(R.id.icon);
            AppManageExternalStorageActivity r3 = this.this$0;
            AppManageExternalStorageActivity.access$102(r3, AppManageExternalStorageActivity.access$200(r3));
            if (r0 == null) goto L5;
            r0.setText(AppManageExternalStorageActivity.access$100(this.this$0).label);
        L5:
            if (r2 == null) goto L7;
            r2.setImageDrawable(AppManageExternalStorageActivity.access$100(this.this$0).icon);
        L7:
            setTitle(r7.getString(R.string.dialog_title_alert));
            r1.setText(R.string.permission_dialog_external_storage);
            setButtonsForNormal(r7);
            setView(r8);
        }

        private void setButtonsForNormal(Resources r4) {
            setButton(-1, r4.getString(R.string.allow), this.mAllowListener);
            setButton(-3, r4.getString(R.string.deny_once), this.mDenyOnceListener);
            setButton(-2, r4.getString(R.string.deny), this.mDenyListener);
        }
    }

    class AppInfo {
        Drawable icon;
        String label;
        final /* synthetic */ AppManageExternalStorageActivity this$0;
        int uid;

        AppInfo(AppManageExternalStorageActivity r1) {
            this.this$0 = r1;
        }
    }

    public void com_android_settings_AppManageExternalStorageActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_AppManageExternalStorageActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_AppManageExternalStorageActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public AppManageExternalStorageActivity() {
        this.mRequestedPermission = "android.permission.MANAGE_EXTERNAL_STORAGE";
    }

    static /* synthetic */ boolean access$002(AppManageExternalStorageActivity r0, boolean r1) {
        r0.mIsDeny = r1;
        return r1;
    }

    static /* synthetic */ AppInfo access$100(AppManageExternalStorageActivity r0) {
        return r0.mAppInfo;
    }

    static /* synthetic */ AppInfo access$102(AppManageExternalStorageActivity r0, AppInfo r1) {
        r0.mAppInfo = r1;
        return r1;
    }

    static /* synthetic */ AppInfo access$200(AppManageExternalStorageActivity r0) {
        return r0.getAppInfo();
    }

    static /* synthetic */ boolean access$302(AppManageExternalStorageActivity r0, boolean r1) {
        r0.mGrantPermission = r1;
        return r1;
    }

    public void com_android_settings_AppManageExternalStorageActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.app_manage_external_storage_activity);
        this.mPackageName = getIntent().getData().getSchemeSpecificPart();
        this.mAppOpsManager = (AppOpsManager) getSystemService("appops");
        this.mPM = getPackageManager();
        this.mAM = (ActivityManager) getSystemService("activity");
        this.mPackageInfo = this.mPM.getPackageInfo(this.mPackageName, 0);     // Catch: PackageManager.NameNotFoundException -> L5
    L8:
        if (TextUtils.isEmpty(this.mPackageName) == false) goto L11;
        OLog.d(TAG, "empty package name ");
        finish();
        return;
    L11:
        this.mBackView = ((OFloatingTitleBar) findViewById(R.id.view_title)).addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(new AppManageExternalStorageActivity$$ExternalSyntheticLambda0(this));
        OListItemSwitch r5 = (OListItemSwitch) findViewById(R.id.item_switch);
        this.mCheckSwitch = r5;
        r5.setChecked(checkManageAppAllFilePermission());
        this.mCheckSwitch.setOnCheckedChangeListener(new AnonymousClass1(this));
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-AppManageExternalStorageActivity, reason: not valid java name */
    /* synthetic */ void m102x695984d9(View r1) {
        finish();
    }

    private void createDenyDialog() {
        this.mAppInfo = getAppInfo();
        this.mDenyDialog = new AlertDialog.Builder(this).setTitle(R.string.dlg_title_notice).setMessage(getString(R.string.used_external_storage_goto_setup, new Object[]{this.mAppInfo.label})).setNegativeButton(android.R.string.cancel, new AppManageExternalStorageActivity$$ExternalSyntheticLambda1(this)).setPositiveButton(R.string.goto_setup, new AppManageExternalStorageActivity$$ExternalSyntheticLambda2(this)).create();
    }

    /* JADX INFO: renamed from: lambda$createDenyDialog$1$com-android-settings-AppManageExternalStorageActivity, reason: not valid java name */
    /* synthetic */ void m100xed39f2ef(DialogInterface r1, int r2) {
        setResult(0);
        finish();
    }

    /* JADX INFO: renamed from: lambda$createDenyDialog$2$com-android-settings-AppManageExternalStorageActivity, reason: not valid java name */
    /* synthetic */ void m101x168e4830(DialogInterface r2, int r3) {
        Intent r4 = new Intent("com.bytedanceos.security.action.NATIVE_PACKAGE_DETAIL");
        r4.putExtra("detail", this.mPackageInfo);
        r4.putExtra(BaseActivity.EXTRA_FROM_SECURITY, this.mFromSecurityCenter);
        r4.putExtra("back_text", getString(R.string.application_info_label));
        Utils.startActivity(this, r4, 0);
    }

    public void com_android_settings_AppManageExternalStorageActivity__onResume$___twin___() {
        super.onResume();
        AppAuthPermissionDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
    L7:
        Dialog r1 = this.mDenyDialog;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isShowing() == true) goto L14;
        this.mDenyDialog.show();
        return;
    L14:
        return;
    L5:
        if (r0.isShowing() == true) goto L7;
        this.mDialog.show();
        goto L7
    }

    public void com_android_settings_AppManageExternalStorageActivity__finish$___twin___() {
        if (this.mIsDeny == false) goto L5;
        RunningStateHelper.getInstance().restartPackage(this.mPackageInfo);
    L5:
        super.finish();
    }

    private int getOriginatingUid() {
        int r2 = ActivityManagerNative.getDefault().getLaunchedFromUid(getActivityToken());     // Catch: RemoteException -> L7
        if (r2 <= (-1)) goto L12;
        return UserHandle.getUserId(r2);
    L12:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    private AppInfo getAppInfo() {
        AppInfo r0 = new AppInfo(this);
        PackageManager r1 = getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L11
        if (r1 != null) goto L6;
        return r0;
    L6:
        ApplicationInfo r2 = r1.getApplicationInfoAsUser(this.mPackageName, 0, getOriginatingUid());     // Catch: PackageManager.NameNotFoundException -> L11
        if (r2 != null) goto L9;
        return r0;
    L9:
        r0.label = (String) r1.getApplicationLabel(r2);     // Catch: PackageManager.NameNotFoundException -> L11
        r0.icon = r1.getApplicationIcon(r2);     // Catch: PackageManager.NameNotFoundException -> L11
        r0.uid = r2.uid;     // Catch: PackageManager.NameNotFoundException -> L11
    L14:
        if (r0.label != null) goto L16;
    L17:
        r0.label = getString(R.string.unknown_app) + this.mPackageName;
    L19:
        if (r0.icon != null) goto L21;
        r0.icon = Resources.getSystem().getDrawable(R.drawable.sym_app_on_sd_unavailable_icon);
    L21:
        return r0;
    L16:
        if (r0.label.length() != 0) goto L19;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public boolean isUserFix() {
        String r0 = AppOpsManager.permissionToOp("android.permission.MANAGE_EXTERNAL_STORAGE");
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        if (checkAppOp(this.mAppOpsManager, r0, this.mPackageInfo.applicationInfo.uid, this.mPackageName) != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public int checkAppOp(AppOpsManager r7, String r8, int r9, String r10) {
        int r6 = OpsManagerHelper.get_MODE_INVALID();
        if (r7 != null) goto L5;
        return r6;
    L5:
        Object r11 = ReflectHelper.invokeMethod(r7, "unsafeCheckOpRaw", new Class[]{String.class, Integer.TYPE, String.class}, new Object[]{r8, Integer.valueOf(r9), r10});
        if (r11 != null) goto L8;
        return r6;
    L8:
        return ((Integer) r11).intValue();
    }

    public void grantPermission(boolean r3) {
        AppOpsManager r0 = this.mAppOpsManager;
        int r2 = this.mPackageInfo.applicationInfo.uid;
        if (r3 == false) goto L5;
        int r4 = 0;
    L6:
        r0.setUidMode(92, r2, r4);
        return;
    L5:
        r4 = 2;
        goto L6
    }

    public boolean checkManageAppAllFilePermission() {
        int r3 = ((AppOpsManager) this.mContext.getSystemService(AppOpsManager.class)).noteOp("android:manage_external_storage", this.mPackageInfo.applicationInfo.uid, this.mPackageName);     // Catch: Exception -> L4
    L6:
        if (r3 != 0) goto L8;
        return true;
    L8:
        return false;
    L4:
        e = move-exception;
        e.printStackTrace();
        r3 = -1;
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_AppManageExternalStorageActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(AppManageExternalStorageActivity r1) {
        com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_PrivacyHook_onCreate(AppManageExternalStorageActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AppManageExternalStorageActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_AppManageExternalStorageActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(AppManageExternalStorageActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(AppManageExternalStorageActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        AppManageExternalStorageActivity r5 = r4;
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
    public static void com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(AppManageExternalStorageActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_AppManageExternalStorageActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(AppManageExternalStorageActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_AppManageExternalStorageActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_PrivacyHook_onResume(AppManageExternalStorageActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AppManageExternalStorageActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_AppManageExternalStorageActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(AppManageExternalStorageActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_PrivacyHook_onPause(AppManageExternalStorageActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AppManageExternalStorageActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_AppManageExternalStorageActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(AppManageExternalStorageActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        AppManageExternalStorageActivity r5 = r3;
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
    public static void com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_PrivacyHook_onStop(AppManageExternalStorageActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AppManageExternalStorageActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_AppManageExternalStorageActivity__onStop$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_AppManageExternalStorageActivity_com_obric_hook_lancet_PrivacyHook_finish(AppManageExternalStorageActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AppManageExternalStorageActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_AppManageExternalStorageActivity__finish$___twin___();
    }
}
