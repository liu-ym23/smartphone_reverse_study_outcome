package com.android.settings.security;

import android.R;
import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.security.IKeyChainService;
import android.security.KeyChain;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.ToastUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.vpn2.VpnUtils;
import com.android.vcard.VCardConfig;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class CredentialStorage extends BaseActivity {
    public static final String ACTION_INSTALL = "com.android.credentials.INSTALL";
    public static final String ACTION_RESET = "com.android.credentials.RESET";
    private static final int CONFIRM_CLEAR_SYSTEM_CREDENTIAL_REQUEST = 1;
    public static final int MIN_PASSWORD_QUALITY = 65536;
    private static final String TAG = "CredentialStorage";
    private Bundle mInstallBundle;
    private LockPatternUtils mUtils;

    /* JADX INFO: renamed from: com.android.settings.security.CredentialStorage$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class InstallKeyInKeyChain extends AsyncTask<Void, Void, Boolean> {
        final String mAlias;
        private final byte[] mCaListData;
        private final byte[] mCertData;
        private final byte[] mKeyData;
        private final int mUid;
        final /* synthetic */ CredentialStorage this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Boolean doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Boolean r1) {
            onPostExecute2(r1);
        }

        InstallKeyInKeyChain(CredentialStorage r1, String r2, byte[] r3, byte[] r4, byte[] r5, int r6) {
            this.this$0 = r1;
            this.mAlias = r2;
            this.mKeyData = r3;
            this.mCertData = r4;
            this.mCaListData = r5;
            this.mUid = r6;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Boolean doInBackground2(Void... r11) {
            KeyChain.KeyChainConnection r2 = KeyChain.bind(this.this$0);     // Catch: InterruptedException -> L26 RemoteException -> L29
            IKeyChainService r9 = r2.getService();     // Catch: Throwable -> L19
            if (r9.installKeyPair(this.mKeyData, this.mCertData, this.mCaListData, this.mAlias, this.mUid) == true) goto L10;
            OLog.w(CredentialStorage.TAG, String.format("Failed installing key %s", new Object[]{this.mAlias}));     // Catch: Throwable -> L19
            if (r2 == null) goto L9;
            r2.close();     // Catch: InterruptedException -> L26 RemoteException -> L29
        L9:
            return false;
        L10:
            int r3 = this.mUid;     // Catch: Throwable -> L19
            if (r3 != 1000) goto L13;
        L14:
            r9.setUserSelectable(this.mAlias, true);     // Catch: Throwable -> L19
        L16:
            if (r2 == null) goto L18;
            r2.close();     // Catch: InterruptedException -> L26 RemoteException -> L29
        L18:
            return true;
        L13:
            if (r3 != (-1)) goto L16;
        L19:
            th = move-exception;
            if (r2 != null) goto L33;
        L25:
            throw th;     // Catch: InterruptedException -> L26 RemoteException -> L29
        L33:
            r2.close();     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            th.addSuppressed(th);     // Catch: InterruptedException -> L26 RemoteException -> L29
        L29:
            e = move-exception;
            OLog.w(CredentialStorage.TAG, String.format("Failed to install key %s to uid %d", new Object[]{this.mAlias, Integer.valueOf(this.mUid)}), e);
            return false;
        L26:
            e = move-exception;
            OLog.w(CredentialStorage.TAG, String.format("Interrupted while installing key %s", new Object[]{this.mAlias}), e);
            Thread.currentThread().interrupt();
            return false;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Boolean r3) {
            CredentialStorage.access$500(this.this$0, this.mAlias, this.mUid, r3.booleanValue());
        }
    }

    private class ResetDialog implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
        private boolean mResetConfirmed;
        final /* synthetic */ CredentialStorage this$0;

        /* synthetic */ ResetDialog(CredentialStorage r1, AnonymousClass1 r2) {
            this(r1);
        }

        private ResetDialog(CredentialStorage r2) {
            this.this$0 = r2;
            OAlertDialog r3 = new OAlertDialogBuilder(r2).horizontalButton(true).title(R.string.dialog_alert_title).message(com.android.settings.R.string.credentials_reset_hint).positiveButton(R.string.ok, this).negativeButton(R.string.cancel, this).build();
            r3.setOnDismissListener(this);
            r3.show();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            if (r2 != (-1)) goto L5;
            boolean r3 = true;
        L6:
            this.mResetConfirmed = r3;
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface r3) {
            if (this.mResetConfirmed == true) goto L6;
            this.this$0.finish();
            return;
        L6:
            this.mResetConfirmed = false;
            if (CredentialStorage.access$100(this.this$0).isSecure(UserHandle.myUserId()) == true) goto L10;
            new ResetKeyStoreAndKeyChain(this.this$0, null).execute(new Void[0]);
            return;
        L10:
            if (CredentialStorage.access$300(this.this$0, 1) == true) goto L14;
            OLog.w(CredentialStorage.TAG, "Failed to launch credential confirmation for a secure user.");
            this.this$0.finish();
            return;
        }
    }

    private class ResetKeyStoreAndKeyChain extends AsyncTask<Void, Void, Boolean> {
        final /* synthetic */ CredentialStorage this$0;

        private ResetKeyStoreAndKeyChain(CredentialStorage r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ResetKeyStoreAndKeyChain(CredentialStorage r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Boolean doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Boolean r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Boolean doInBackground2(Void... r5) {
            CredentialStorage.access$100(this.this$0).resetKeyStore(UserHandle.myUserId());
            KeyChain.KeyChainConnection r4 = KeyChain.bind(this.this$0);     // Catch: Throwable -> L15 InterruptedException -> L18
            Boolean r0 = Boolean.valueOf(r4.getService().reset());     // Catch: Throwable -> L7 RemoteException -> L9
            r4.close();     // Catch: Throwable -> L15 InterruptedException -> L18
            return r0;
        L7:
            th = move-exception;
            r4.close();     // Catch: Throwable -> L15 InterruptedException -> L18
            throw th;     // Catch: Throwable -> L15 InterruptedException -> L18
        L9:
            e = move-exception;
            OLog.e(CredentialStorage.TAG, "keyChainConnection reset error: " + e);     // Catch: Throwable -> L7
            r4.close();     // Catch: Throwable -> L15 InterruptedException -> L18
            return false;
        L18:
            e = move-exception;
            OLog.e(CredentialStorage.TAG, "ResetKeyStoreAndKeyChain InterruptedException: " + e);
            Thread.currentThread().interrupt();
            return false;
        L15:
            th = move-exception;
            OLog.e(CredentialStorage.TAG, "ResetKeyStoreAndKeyChain Throwable: " + th);
            return false;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Boolean r2) {
            if (r2.booleanValue() == false) goto L5;
            ToastUtils.show(this.this$0, com.android.settings.R.string.credentials_erased);
            CredentialStorage.access$400(this.this$0);
        L6:
            this.this$0.finish();
            return;
        L5:
            ToastUtils.show(this.this$0, com.android.settings.R.string.credentials_not_erased);
            goto L6
        }
    }

    public void com_android_settings_security_CredentialStorage__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_security_CredentialStorage__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_security_CredentialStorage__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_security_CredentialStorage_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_security_CredentialStorage_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_security_CredentialStorage_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_security_CredentialStorage_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_security_CredentialStorage_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public CredentialStorage() {
    }

    static /* synthetic */ LockPatternUtils access$100(CredentialStorage r0) {
        return r0.mUtils;
    }

    static /* synthetic */ boolean access$300(CredentialStorage r0, int r1) {
        return r0.confirmKeyGuard(r1);
    }

    static /* synthetic */ void access$400(CredentialStorage r0) {
        r0.clearLegacyVpnIfEstablished();
    }

    static /* synthetic */ void access$500(CredentialStorage r0, String r1, int r2, boolean r3) {
        r0.onKeyInstalled(r1, r2, r3);
    }

    public void com_android_settings_security_CredentialStorage__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mUtils = new LockPatternUtils(this);
        OLog.d(TAG, "onCreate");
        Window r1 = getWindow();
        if (r1 == null) goto L6;
        WindowManager.LayoutParams r3 = r1.getAttributes();
        r3.alpha = 0.0f;
        r1.setAttributes(r3);
        return;
    }

    public void com_android_settings_security_CredentialStorage__onResume$___twin___() {
        super.onResume();
        Intent r0 = getIntent();
        String r1 = r0.getAction();
        if (((UserManager) getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_config_credentials") == false) goto L5;
        finish();
        return;
    L5:
        if (ACTION_RESET.equals(r1) == false) goto L10;
        if (checkCallerIsSelf() == false) goto L10;
        new ResetDialog(this, null);
        return;
    L10:
        if (ACTION_INSTALL.equals(r1) == true) goto L12;
    L14:
        handleInstall();
        return;
    L12:
        if (checkCallerIsCertInstallerOrSelfInProfile() == false) goto L14;
        this.mInstallBundle = r0.getExtras();
        goto L14
    }

    private void handleInstall() {
        if (isFinishing() == false) goto L6;
        return;
    L6:
        if (installIfAvailable() == false) goto L9;
        finish();
        return;
    }

    private boolean installIfAvailable() {
        Bundle r0 = this.mInstallBundle;
        if (r0 != null) goto L5;
    L23:
        return true;
    L5:
        if (r0.isEmpty() == true) goto L23;
        Bundle r1 = this.mInstallBundle;
        this.mInstallBundle = null;
        int r11 = r1.getInt("install_as_uid", -1);
        if (r11 != (-1)) goto L10;
    L17:
        String r7 = r1.getString("user_key_pair_name", null);
        if (TextUtils.isEmpty(r7) == false) goto L21;
        OLog.e(TAG, "Cannot install key without an alias");
        return true;
    L21:
        new InstallKeyInKeyChain(this, r7, r1.getByteArray("user_private_key_data"), r1.getByteArray("user_certificate_data"), r1.getByteArray("ca_certificates_data"), r11).execute(new Void[0]);
        return false;
    L10:
        if (UserHandle.isSameUser(r11, Process.myUid()) == true) goto L17;
        int r2 = UserHandle.getUserId(r11);
        if (r11 == 1010) goto L15;
        OLog.e(TAG, "Failed to install credentials as uid " + r11 + ": cross-user installs may only target wifi uids");
        return true;
    L15:
        startActivityAsUser(new Intent(ACTION_INSTALL).setPackage(getPackageName()).setFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING).putExtras(r1), new UserHandle(r2));
        return true;
    }

    private void clearLegacyVpnIfEstablished() {
        if (VpnUtils.disconnectLegacyVpn(getApplicationContext()) == false) goto L6;
        ToastUtils.show(this, com.android.settings.R.string.vpn_disconnected);
        return;
    }

    private void onKeyInstalled(String r5, int r6, boolean r7) {
        if (r7 == true) goto L6;
        OLog.w(TAG, String.format("Error installing alias %s for uid %d", new Object[]{r5, Integer.valueOf(r6)}));
        finish();
        return;
    L6:
        OLog.i(TAG, String.format("Successfully installed alias %s to uid %d.", new Object[]{r5, Integer.valueOf(r6)}));
        sendBroadcast(new Intent("android.security.action.KEYCHAIN_CHANGED"));
        setResult(-1);
        finish();
    }

    private boolean checkCallerIsSelf() {
        if (Process.myUid() != ActivityManager.getService().getLaunchedFromUid(getActivityToken())) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    private String getCallingPackageName() {
        return ActivityManager.getService().getLaunchedFromPackage(getActivityToken());
    L4:
        return null;
    }

    private boolean checkCallerIsCertInstallerOrSelfInProfile() {
        String r0 = getCallingPackageName();
        if (TextUtils.equals("com.android.certinstaller", r0) == true) goto L5;
        int r1 = ActivityManager.getService().getLaunchedFromUid(getActivityToken());     // Catch: RemoteException -> L24
        if (r1 != (-1)) goto L14;
        OLog.e(TAG, "com.android.credentials.INSTALL must be started with startActivityForResult");     // Catch: RemoteException -> L24
        return false;
    L14:
        if (UserHandle.isSameApp(r1, Process.myUid()) == true) goto L16;
        return false;
    L16:
        int r2 = UserHandle.getUserId(r1);     // Catch: RemoteException -> L24
        UserInfo r4 = ((UserManager) getSystemService(PickApplicationActivity.EXTRA_USER)).getProfileParent(r2);
        if (r4 == null) goto L23;
        if (r4.id != UserHandle.myUserId()) goto L23;
        return true;
    L23:
        return false;
    L24:
        return false;
    L5:
        if (getPackageManager().checkSignatures(r0, getPackageName()) != 0) goto L8;
        return true;
    L8:
        return false;
    }

    private boolean confirmKeyGuard(int r4) {
        Resources r0 = getResources();
        return new ChooseLockSettingsHelper(this).launchConfirmationActivity(r4, r0.getText(com.android.settings.R.string.credentials_title), true, 2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == 1) goto L5;
        return;
    L5:
        if (r2 != (-1)) goto L8;
        new ResetKeyStoreAndKeyChain(this, null).execute(new Void[0]);
        return;
    L8:
        finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_security_CredentialStorage_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CredentialStorage r1) {
        com_android_settings_security_CredentialStorage_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_security_CredentialStorage_com_obric_hook_lancet_PrivacyHook_onCreate(CredentialStorage r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        CredentialStorage r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_security_CredentialStorage__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_security_CredentialStorage_com_obric_hook_lancet_BatchedActivityLancet_onResume(CredentialStorage r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_security_CredentialStorage_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_security_CredentialStorage_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(CredentialStorage r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_security_CredentialStorage_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        CredentialStorage r5 = r4;
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
    public static void com_android_settings_security_CredentialStorage_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(CredentialStorage r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_security_CredentialStorage__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_security_CredentialStorage_com_obric_hook_lancet_BatchedActivityLancet_onStop(CredentialStorage r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_security_CredentialStorage_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_security_CredentialStorage_com_obric_hook_lancet_PrivacyHook_onResume(CredentialStorage r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        CredentialStorage r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_security_CredentialStorage__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_security_CredentialStorage_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(CredentialStorage r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_security_CredentialStorage_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_security_CredentialStorage_com_obric_hook_lancet_PrivacyHook_onPause(CredentialStorage r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        CredentialStorage r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_security_CredentialStorage__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_security_CredentialStorage_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(CredentialStorage r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_security_CredentialStorage_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        CredentialStorage r5 = r3;
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
    public static void com_android_settings_security_CredentialStorage_com_obric_hook_lancet_PrivacyHook_onStop(CredentialStorage r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        CredentialStorage r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_security_CredentialStorage__onStop$___twin___();
    }
}
