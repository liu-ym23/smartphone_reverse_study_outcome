package com.obric.matrix.platform.sdk.ones.account;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.GlobalProxyLancet;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AccountStatusListener implements IAccountStatusListener {
    private static final String TAG = "AccountSDK_AccountStatusListener";
    private final BroadcastReceiver mAccountStateChangedReceiver;
    private final Context mContext;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.account.AccountStatusListener$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ AccountStatusListener this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_obric_matrix_platform_sdk_ones_account_AccountStatusListener$1_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        AnonymousClass1(AccountStatusListener r1) {
            this.this$0 = r1;
        }

        public void com_obric_matrix_platform_sdk_ones_account_AccountStatusListener$1__onReceive$___twin___(Context r2, final Intent r3) {
            this.this$0.asyncInvoke(new AccountStatusListener$1$$ExternalSyntheticLambda0(this, r3));
        }

        /* JADX INFO: renamed from: lambda$onReceive$0$com-obric-matrix-platform-sdk-ones-account-AccountStatusListener$1, reason: not valid java name */
        /* synthetic */ void m1009xf22b3cf2(Intent r3) {
            if (r3.getAction().equals(AccountConst.ACTION_LOGIN) == false) goto L6;
            this.this$0.onLogin();
            return;
        L6:
            if (r3.getAction().equals(AccountConst.ACTION_LOGOUT) == false) goto L9;
            int r4 = r3.getIntExtra(AccountConst.EXTRA_LOGOUT_SCENE, 0);
            this.this$0.onLogout(r4);
            return;
        L9:
            if (r3.getAction().equals(AccountConst.ACTION_ACCOUNT_INFO_UPDATE) == false) goto L14;
            this.this$0.onAccountInfoUpdate();
            return;
        }

        @Insert("onReceive")
        public static void com_obric_matrix_platform_sdk_ones_account_AccountStatusListener$1_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(AnonymousClass1 r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            AnonymousClass1 r1 = r7;
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
            r7.com_obric_matrix_platform_sdk_ones_account_AccountStatusListener$1__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_obric_matrix_platform_sdk_ones_account_AccountStatusListener$1__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_obric_matrix_platform_sdk_ones_account_AccountStatusListener$1__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_obric_matrix_platform_sdk_ones_account_AccountStatusListener$1__onReceive$___twin___(r8, r9);
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

    protected void asyncInvoke(Runnable r1) {
    }

    public AccountStatusListener() {
        this.mAccountStateChangedReceiver = new AnonymousClass1(this);
        this.mContext = AppGlobals.INSTANCE.getApplicationContext();
    }

    public void startListen() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction(AccountConst.ACTION_LOGIN);
        r0.addAction(AccountConst.ACTION_LOGOUT);
        r0.addAction(AccountConst.ACTION_ACCOUNT_INFO_UPDATE);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mAccountStateChangedReceiver, r0);
    }

    public void stopListen() {
        this.mContext.unregisterReceiver(this.mAccountStateChangedReceiver);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onLogin() {
        com.obric.matrix.platform.sdk.ones.account.log.OLog.d(TAG, "onAccountLogin");
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onLogout(int r2) {
        com.obric.matrix.platform.sdk.ones.account.log.OLog.d(TAG, "onAccountLogout logoutScene = " + r2);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onAccountInfoUpdate() {
        com.obric.matrix.platform.sdk.ones.account.log.OLog.d(TAG, "onAccountInfoUpdate");
    }
}
