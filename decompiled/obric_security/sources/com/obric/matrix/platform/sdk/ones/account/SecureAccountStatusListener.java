package com.obric.matrix.platform.sdk.ones.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SecureAccountStatusListener implements IAccountStatusListener {
    private static final String TAG = "AccountSDK_SecureAccountStatusListener";
    private final BroadcastReceiver mAccountStateChangedReceiver;
    private final Context mContext;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.account.SecureAccountStatusListener$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ SecureAccountStatusListener this$0;

        AnonymousClass1(SecureAccountStatusListener r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r2, final Intent r3) {
            this.this$0.asyncInvoke(new SecureAccountStatusListener$1$$ExternalSyntheticLambda0(this, r3));
        }

        /* JADX INFO: renamed from: lambda$onReceive$0$com-obric-matrix-platform-sdk-ones-account-SecureAccountStatusListener$1, reason: not valid java name */
        /* synthetic */ void m156xdd3ddfb(Intent r3) {
            Log.i(SecureAccountStatusListener.TAG, "onReceive action = " + r3.getAction());
            if (r3.getAction() != null) goto L6;
            return;
        L6:
            if (r3.getAction().equals(AccountConst.ACTION_SECURE_LOGIN) == false) goto L9;
            this.this$0.onLogin();
            return;
        L9:
            if (r3.getAction().equals(AccountConst.ACTION_SECURE_LOGOUT) == false) goto L12;
            this.this$0.onLogout(r3.getIntExtra(AccountConst.EXTRA_LOGOUT_SCENE, 0));
            return;
        L12:
            if (r3.getAction().equals(AccountConst.ACTION_SECURE_ACCOUNT_INFO_UPDATE) == false) goto L17;
            this.this$0.onAccountInfoUpdate();
            return;
        }
    }

    protected void asyncInvoke(Runnable r1) {
    }

    public SecureAccountStatusListener() {
        this.mAccountStateChangedReceiver = new AnonymousClass1(this);
        this.mContext = AppGlobals.INSTANCE.getApplicationContext();
    }

    public void startListen() {
        Log.i(TAG, "startListen");
        IntentFilter r4 = new IntentFilter();
        r4.addAction(AccountConst.ACTION_SECURE_LOGIN);
        r4.addAction(AccountConst.ACTION_SECURE_LOGOUT);
        r4.addAction(AccountConst.ACTION_SECURE_ACCOUNT_INFO_UPDATE);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        this.mContext.registerReceiver(this.mAccountStateChangedReceiver, r4, AccountConst.PERMISSION_ACCOUNT_STATUS, null, 2);
        return;
    L5:
        this.mContext.registerReceiver(this.mAccountStateChangedReceiver, r4, AccountConst.PERMISSION_ACCOUNT_STATUS, null);
    }

    public void stopListen() {
        this.mContext.unregisterReceiver(this.mAccountStateChangedReceiver);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onLogin() {
        OLog.d(TAG, "onAccountLogin");
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onLogout(int r2) {
        OLog.d(TAG, "onAccountLogout logoutScene = " + r2);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onAccountInfoUpdate() {
        OLog.d(TAG, "onAccountInfoUpdate");
    }
}
