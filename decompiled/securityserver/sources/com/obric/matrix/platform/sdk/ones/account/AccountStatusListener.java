package com.obric.matrix.platform.sdk.ones.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AccountStatusListener implements IAccountStatusListener {
    private static final String TAG = "AccountSDK_AccountStatusListener";
    private final BroadcastReceiver mAccountStateChangedReceiver;
    private final Context mContext;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.account.AccountStatusListener$1, reason: invalid class name */
    public class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ AccountStatusListener this$0;

        public AnonymousClass1(AccountStatusListener r1) {
            this.this$0 = r1;
        }

        public static /* synthetic */ void a(AnonymousClass1 r0, Intent r1) {
            r0.lambda$onReceive$0(r1);
        }

        private /* synthetic */ void lambda$onReceive$0(Intent r3) {
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

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r2, final Intent r3) {
            this.this$0.asyncInvoke(new a(this, r3));
        }
    }

    public AccountStatusListener() {
        this.mAccountStateChangedReceiver = new AnonymousClass1(this);
        this.mContext = AppGlobals.INSTANCE.getApplicationContext();
    }

    public void asyncInvoke(Runnable r1) {
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onAccountInfoUpdate() {
        OLog.d(TAG, "onAccountInfoUpdate");
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onLogin() {
        OLog.d(TAG, "onAccountLogin");
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onLogout(int r2) {
        OLog.d(TAG, "onAccountLogout logoutScene = " + r2);
    }

    public void startListen() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction(AccountConst.ACTION_LOGIN);
        r0.addAction(AccountConst.ACTION_LOGOUT);
        r0.addAction(AccountConst.ACTION_ACCOUNT_INFO_UPDATE);
        this.mContext.registerReceiver(this.mAccountStateChangedReceiver, r0);
    }

    public void stopListen() {
        this.mContext.unregisterReceiver(this.mAccountStateChangedReceiver);
    }
}
