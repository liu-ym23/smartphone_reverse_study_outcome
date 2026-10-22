package com.android.settings.bluetooth;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.StatusDialogUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.time.Duration;
import java.util.Objects;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class RequestPermissionActivity extends LifeHookActivity2 implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
    private static final String EXTRA_CALLING_APP_NAME = "com.obric.intent.extra.CALLING_APP_NAME";
    private static final int MAX_DISCOVERABLE_TIMEOUT = 3600;
    static final int REQUEST_DISABLE = 3;
    static final int REQUEST_ENABLE = 1;
    static final int REQUEST_ENABLE_DISCOVERABLE = 2;
    private static final String TAG = "BtRequestPermission";
    private CharSequence mAppLabel;
    private BluetoothAdapter mBluetoothAdapter;
    private OAlertDialog mDialog;
    private StatusDialog mLoadingDialog;
    private BroadcastReceiver mReceiver;
    private int mRequest;
    private OAlertDialog mRequestDialog;
    private int mTimeout;

    private final class StateChangeReceiver extends BroadcastReceiver {
        private static final long TOGGLE_TIMEOUT_MILLIS = 10000;
        final /* synthetic */ RequestPermissionActivity this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_bluetooth_RequestPermissionActivity$StateChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        public StateChangeReceiver(RequestPermissionActivity r4) {
            this.this$0 = r4;
            r4.getWindow().getDecorView().postDelayed(new RequestPermissionActivity$StateChangeReceiver$$ExternalSyntheticLambda0(this), TOGGLE_TIMEOUT_MILLIS);
        }

        /* JADX INFO: renamed from: lambda$new$0$com-android-settings-bluetooth-RequestPermissionActivity$StateChangeReceiver, reason: not valid java name */
        /* synthetic */ void m373x7437a98f() {
            if (this.this$0.isFinishing() == false) goto L5;
            return;
        L5:
            if (this.this$0.isDestroyed() == true) goto L9;
            RequestPermissionActivity.access$200(this.this$0);
            return;
        }

        public void com_android_settings_bluetooth_RequestPermissionActivity$StateChangeReceiver__onReceive$___twin___(Context r2, Intent r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            int r4 = r3.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
            int r5 = RequestPermissionActivity.access$000(this.this$0);
            if (r5 == 1) goto L15;
            if (r5 == 2) goto L15;
            if (r5 == 3) goto L12;
            return;
        L12:
            if (r4 != 10) goto L18;
            RequestPermissionActivity.access$100(this.this$0);
            return;
        L18:
            return;
        L15:
            if (r4 != 12) goto L20;
            RequestPermissionActivity.access$100(this.this$0);
            return;
        }

        @Insert("onReceive")
        public static void com_android_settings_bluetooth_RequestPermissionActivity$StateChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(StateChangeReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            StateChangeReceiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settings_bluetooth_RequestPermissionActivity$StateChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_bluetooth_RequestPermissionActivity$StateChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_bluetooth_RequestPermissionActivity$StateChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_bluetooth_RequestPermissionActivity$StateChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
        }
    }

    public void com_android_settings_bluetooth_RequestPermissionActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_bluetooth_RequestPermissionActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_bluetooth_RequestPermissionActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_bluetooth_RequestPermissionActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public RequestPermissionActivity() {
        this.mTimeout = 120;
    }

    static /* synthetic */ int access$000(RequestPermissionActivity r0) {
        return r0.mRequest;
    }

    static /* synthetic */ void access$100(RequestPermissionActivity r0) {
        r0.proceedAndFinish();
    }

    static /* synthetic */ void access$200(RequestPermissionActivity r0) {
        r0.cancelAndFinish();
    }

    public void com_android_settings_bluetooth_RequestPermissionActivity__onCreate$___twin___(Bundle r8) {
        super.onCreate(r8);
        getWindow().addSystemFlags(524288);
        setResult(0);
        if (parseIntent() == false) goto L6;
        finish();
        return;
    L6:
        int r9 = this.mBluetoothAdapter.getState();
        int r0 = this.mRequest;
        if (r0 != 3) goto L14;
        switch(r9) {
            case 10: goto L13;
            case 11: goto L10;
            case 12: goto L10;
            case 13: goto L13;
            default: goto L9;
        };
    L9:
        OLog.e(TAG, "Unknown adapter state: " + r9);
        cancelAndFinish();
        return;
    L10:
        OAlertDialog r10 = RequestPermissionHelper.INSTANCE.requestDisable(this, this.mAppLabel, new RequestPermissionActivity$$ExternalSyntheticLambda0(this), new RequestPermissionActivity$$ExternalSyntheticLambda1(this));
        this.mRequestDialog = r10;
        if (r10 == null) goto L29;
        r10.show();
        return;
    L29:
        return;
    L13:
        proceedAndFinish();
        return;
    L14:
        switch(r9) {
            case 10: goto L20;
            case 11: goto L20;
            case 12: goto L17;
            case 13: goto L20;
            default: goto L15;
        };
    L15:
        OLog.e(TAG, "Unknown adapter state: " + r9);
        cancelAndFinish();
        return;
    L20:
        RequestPermissionHelper r1 = RequestPermissionHelper.INSTANCE;
        CharSequence r3 = this.mAppLabel;
        if (this.mRequest != 2) goto L23;
        int r11 = this.mTimeout;
    L24:
        OAlertDialog r12 = r1.requestEnable(this, r3, r11, new RequestPermissionActivity$$ExternalSyntheticLambda2(this), new RequestPermissionActivity$$ExternalSyntheticLambda3(this));
        this.mRequestDialog = r12;
        if (r12 == null) goto L35;
        r12.show();
        return;
    L35:
        return;
    L23:
        r11 = -1;
        goto L24
    L17:
        if (r0 != 1) goto L19;
        proceedAndFinish();
        return;
    L19:
        createDialog();
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-bluetooth-RequestPermissionActivity, reason: not valid java name */
    /* synthetic */ Unit m369x5615154e() {
        onDisableConfirmed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-android-settings-bluetooth-RequestPermissionActivity, reason: not valid java name */
    /* synthetic */ Unit m370xe3022c6d() {
        cancelAndFinish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-android-settings-bluetooth-RequestPermissionActivity, reason: not valid java name */
    /* synthetic */ Unit m371x6fef438c() {
        onEnableConfirmed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$onCreate$3$com-android-settings-bluetooth-RequestPermissionActivity, reason: not valid java name */
    /* synthetic */ Unit m372xfcdc5aab() {
        cancelAndFinish();
        return Unit.INSTANCE;
    }

    private void createDialog() {
        if (getResources().getBoolean(R.bool.auto_confirm_bluetooth_activation_dialog) == false) goto L6;
        onClick(null, -1);
        return;
    L6:
        OAlertDialogBuilder r0 = new OAlertDialogBuilder(this);
        if (this.mReceiver == null) goto L24;
        int r1 = this.mRequest;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L12;
        StatusDialog r2 = StatusDialogUtils.createStatusDialog(this, ResourceUtils.getString(R.string.bluetooth_turning_off));
        this.mLoadingDialog = r2;
        r2.show();
    L13:
        OAlertDialog r3 = this.mDialog;
        if (r3 != null) goto L16;
    L18:
        OAlertDialog r4 = this.mRequestDialog;
        if (r4 != null) goto L21;
        return;
    L21:
        if (r4.isShowing() == false) goto L39;
        this.mRequestDialog.dismiss();
        this.mRequestDialog = null;
        return;
    L39:
        return;
    L16:
        if (r3.isShowing() == false) goto L18;
        this.mDialog.dismiss();
        this.mDialog = null;
    L12:
        StatusDialog r5 = StatusDialogUtils.createStatusDialog(this, ResourceUtils.getString(R.string.bluetooth_turning_on));
        this.mLoadingDialog = r5;
        r5.show();
        goto L13
    L24:
        int r6 = this.mTimeout;
        if (r6 != 0) goto L31;
        CharSequence r7 = this.mAppLabel;
        if (r7 == null) goto L29;
        String r8 = getString(R.string.bluetooth_ask_lasting_discovery, new Object[]{r7});
    L30:
        r0.title(r8, true);
    L36:
        r0.positiveButton(getString(R.string.allow), this);
        r0.negativeButton(getString(R.string.prohibit), this);
        r0.autoDismiss(false);
        r0.horizontalButton(false);
        OAlertDialog r9 = r0.build();
        this.mDialog = r9;
        r9.setOnShowListener(new RequestPermissionActivity$$ExternalSyntheticLambda4(this));
        this.mDialog.show();
        return;
    L29:
        r8 = getString(R.string.bluetooth_ask_lasting_discovery_no_name);
        goto L30
    L31:
        CharSequence r10 = this.mAppLabel;
        if (r10 == null) goto L34;
        String r11 = getString(R.string.bluetooth_ask_discovery, new Object[]{r10, Integer.valueOf(r6)});
    L35:
        r0.title(r11, true);
        goto L36
    L34:
        r11 = getString(R.string.bluetooth_ask_discovery_no_name, new Object[]{Integer.valueOf(r6)});
        goto L35
    }

    /* JADX WARN: Type inference failed for: r8v6, types: [com.android.settings.bluetooth.RequestPermissionActivity$1] */
    /* JADX INFO: renamed from: lambda$createDialog$4$com-android-settings-bluetooth-RequestPermissionActivity, reason: not valid java name */
    /* synthetic */ void m368xc4d5a501(DialogInterface r8) {
        if ((this.mDialog.getNegativeButton() instanceof TextView) == false) goto L5;
        TextView r9 = (TextView) this.mDialog.getNegativeButton();
    L6:
        final TextView r6 = r9;
        final long r2 = 10000;
        final long r4 = 1000;
        new AnonymousClass1(this, r2, r4, r6).start();
        return;
    L5:
        r9 = null;
        goto L6
    }

    private void onEnableConfirmed() {
        this.mBluetoothAdapter.enable();
        if (this.mBluetoothAdapter.getState() != 12) goto L5;
        proceedAndFinish();
        return;
    L5:
        StateChangeReceiver r0 = new StateChangeReceiver(this);
        this.mReceiver = r0;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, r0, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        createDialog();
    }

    private void onDisableConfirmed() {
        this.mBluetoothAdapter.disable();
        if (this.mBluetoothAdapter.getState() != 10) goto L5;
        proceedAndFinish();
        return;
    L5:
        StateChangeReceiver r0 = new StateChangeReceiver(this);
        this.mReceiver = r0;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, r0, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        createDialog();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
        if (r2 != (-2)) goto L5;
        cancelAndFinish();
        return;
    L5:
        if (r2 != (-1)) goto L11;
        proceedAndFinish();
        return;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r1) {
        cancelAndFinish();
    }

    private void proceedAndFinish() {
        int r0 = this.mRequest;
        int r1 = 1;
        if (r0 != 1) goto L5;
    L17:
        r1 = -1;
    L18:
        setResult(r1);
        finish();
        return;
    L5:
        if (r0 == 3) goto L17;
        this.mBluetoothAdapter.setDiscoverableTimeout(Duration.ofSeconds(this.mTimeout));
        if (this.mBluetoothAdapter.setScanMode(23) != 0) goto L16;
        long r2 = System.currentTimeMillis() + (((long) this.mTimeout) * 1000);
        LocalBluetoothPreferences.persistDiscoverableEndTimestamp(this, r2);
        if (this.mTimeout <= 0) goto L12;
        com.android.settingslib.bluetooth.BluetoothDiscoverableTimeoutReceiver.setDiscoverableAlarm(this, r2);
    L12:
        int r3 = this.mTimeout;
        if (r3 < 1) goto L18;
        r1 = r3;
        goto L18
    L16:
        r1 = 0;
        goto L18
    }

    private void cancelAndFinish() {
        setResult(0);
        finish();
    }

    private boolean parseIntent() {
        Intent r0 = getIntent();
        if (r0 != null) goto L6;
        return true;
    L6:
        if (Objects.equals(r0.getAction(), "android.bluetooth.adapter.action.REQUEST_ENABLE") == false) goto L9;
        this.mRequest = 1;
    L18:
        String r1 = getLaunchedFromPackage();
        int r2 = getLaunchedFromUid();
        if (UserHandle.isSameApp(r2, 1000) == false) goto L24;
        if (getIntent().getStringExtra("android.intent.extra.PACKAGE_NAME") == null) goto L24;
        r1 = getIntent().getStringExtra("android.intent.extra.PACKAGE_NAME");
    L24:
        if (UserHandle.isSameApp(r2, 1000) == true) goto L29;
        if (getIntent().getStringExtra("android.intent.extra.PACKAGE_NAME") == null) goto L29;
        OLog.w(TAG, "Non-system Uid: " + r2 + " tried to override packageName \n");
    L29:
        if (TextUtils.isEmpty(r1) == true) goto L35;
        this.mAppLabel = getPackageManager().getApplicationInfo(r1, 0).loadSafeLabel(getPackageManager(), 1000.0f, 5);     // Catch: PackageManager.NameNotFoundException -> L32
    L32:
        OLog.e(TAG, "Couldn't find app with package name " + r1);
        setResult(0);
        return true;
    L35:
        if (getIntent().getStringExtra(EXTRA_CALLING_APP_NAME) == null) goto L37;
        this.mAppLabel = getIntent().getStringExtra(EXTRA_CALLING_APP_NAME);
    L37:
        BluetoothAdapter r3 = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothAdapter = r3;
        if (r3 != null) goto L41;
        OLog.e(TAG, "Error: there's a problem starting Bluetooth");
        setResult(0);
        return true;
    L41:
        return false;
    L9:
        if (Objects.equals(r0.getAction(), "android.bluetooth.adapter.action.REQUEST_DISABLE") == false) goto L12;
        this.mRequest = 3;
        goto L18
    L12:
        if (Objects.equals(r0.getAction(), "android.bluetooth.adapter.action.REQUEST_DISCOVERABLE") == false) goto L42;
        this.mRequest = 2;
        this.mTimeout = r0.getIntExtra("android.bluetooth.adapter.extra.DISCOVERABLE_DURATION", 120);
        OLog.d(TAG, "Setting Bluetooth Discoverable Timeout = " + this.mTimeout);
        int r4 = this.mTimeout;
        if (r4 >= 1) goto L16;
    L17:
        this.mTimeout = 120;
        goto L18
    L16:
        if (r4 <= 3600) goto L18;
    L42:
        OLog.e(TAG, "Error: this activity may be started only with intent android.bluetooth.adapter.action.REQUEST_ENABLE, android.bluetooth.adapter.action.REQUEST_DISABLE or android.bluetooth.adapter.action.REQUEST_DISCOVERABLE");
        setResult(0);
        return true;
    }

    public void com_android_settings_bluetooth_RequestPermissionActivity__onDestroy$___twin___() {
        super.onDestroy();
        BroadcastReceiver r0 = this.mReceiver;
        if (r0 == null) goto L5;
        unregisterReceiver(r0);
        this.mReceiver = null;
    L5:
        OAlertDialog r1 = this.mDialog;
        if (r1 != null) goto L8;
    L10:
        StatusDialog r2 = this.mLoadingDialog;
        if (r2 != null) goto L13;
    L15:
        OAlertDialog r3 = this.mRequestDialog;
        if (r3 != null) goto L18;
        return;
    L18:
        if (r3.isShowing() == false) goto L22;
        this.mRequestDialog.dismiss();
        this.mRequestDialog = null;
        return;
    L22:
        return;
    L13:
        if (r2.isShowing() == false) goto L15;
        this.mLoadingDialog.dismiss();
        this.mLoadingDialog = null;
        goto L15
    L8:
        if (r1.isShowing() == false) goto L10;
        this.mDialog.dismiss();
        this.mDialog = null;
        goto L10
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_bluetooth_RequestPermissionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(RequestPermissionActivity r1) {
        com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(RequestPermissionActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestPermissionActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_bluetooth_RequestPermissionActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(RequestPermissionActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(RequestPermissionActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        RequestPermissionActivity r5 = r4;
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
    public static void com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(RequestPermissionActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_bluetooth_RequestPermissionActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(RequestPermissionActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_bluetooth_RequestPermissionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(RequestPermissionActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestPermissionActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_bluetooth_RequestPermissionActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(RequestPermissionActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(RequestPermissionActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestPermissionActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_bluetooth_RequestPermissionActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(RequestPermissionActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        RequestPermissionActivity r5 = r3;
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
    public static void com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(RequestPermissionActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestPermissionActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_bluetooth_RequestPermissionActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_bluetooth_RequestPermissionActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(RequestPermissionActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestPermissionActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_bluetooth_RequestPermissionActivity__onDestroy$___twin___();
    }
}
