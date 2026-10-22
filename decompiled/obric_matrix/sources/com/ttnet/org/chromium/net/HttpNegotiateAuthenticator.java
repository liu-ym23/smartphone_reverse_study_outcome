package com.ttnet.org.chromium.net;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net::android")
public class HttpNegotiateAuthenticator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "net_auth";
    private final String mAccountType;
    private Bundle mSpnegoContext;

    @VisibleForTesting
    class GetAccountsCallback implements AccountManagerCallback<Account[]> {
        private final RequestData mRequestData;
        final /* synthetic */ HttpNegotiateAuthenticator this$0;

        public GetAccountsCallback(HttpNegotiateAuthenticator r1, RequestData r2) {
            this.this$0 = r1;
            this.mRequestData = r2;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Account[]> r10) {
            Account[] r11 = r10.getResult();     // Catch: Throwable -> L12
            if (r11.length != 0) goto L9;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ", new Object[0]);
            HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, this.this$0, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
            return;
        L9:
            if (r11.length <= 1) goto L17;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: Found %d accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.", new Object[]{Integer.valueOf(r11.length)});
            HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, this.this$0, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
            return;
        L17:
            return;
        L12:
            e = move-exception;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to retrieve accounts.", new Object[]{e});
            HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, this.this$0, -9, null);
        }
    }

    @VisibleForTesting
    class GetTokenCallback implements AccountManagerCallback<Bundle> {
        private final RequestData mRequestData;
        final /* synthetic */ HttpNegotiateAuthenticator this$0;

        public GetTokenCallback(HttpNegotiateAuthenticator r1, RequestData r2) {
            this.this$0 = r1;
            this.mRequestData = r2;
        }

        @Proxy("registerReceiver")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
        public static Intent INVOKEVIRTUAL_com_ttnet_org_chromium_net_HttpNegotiateAuthenticator$GetTokenCallback_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3) {
            return r1.registerReceiver(r2, r3);
        L4:
            e = move-exception;
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
            throw e;
        L8:
            return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
        }

        static /* synthetic */ RequestData access$000(GetTokenCallback r0) {
            return r0.mRequestData;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> r9) {
            Bundle r10 = r9.getResult();     // Catch: Throwable -> L8
            if (r10.containsKey("intent") == false) goto L6;
            final Context r11 = ContextUtils.getApplicationContext();
            INVOKEVIRTUAL_com_ttnet_org_chromium_net_HttpNegotiateAuthenticator$GetTokenCallback_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r11, new AnonymousClass1(this, r11), new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"));
            return;
        L6:
            HttpNegotiateAuthenticator.access$100(this.this$0, r10, this.mRequestData);
            return;
        L8:
            e = move-exception;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to obtain a token.", new Object[]{e});
            HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, this.this$0, -9, null);
        }
    }

    interface Natives {
        void setResult(long r1, HttpNegotiateAuthenticator r3, int r4, String r5);
    }

    static class RequestData {
        public Account account;
        public AccountManager accountManager;
        public String authTokenType;
        public long nativeResultObject;
        public Bundle options;

        RequestData() {
        }
    }

    static {
    }

    protected HttpNegotiateAuthenticator(String r1) {
        this.mAccountType = r1;
    }

    static /* synthetic */ void access$100(HttpNegotiateAuthenticator r0, Bundle r1, RequestData r2) {
        r0.processResult(r1, r2);
    }

    @CalledByNative
    @VisibleForTesting
    static HttpNegotiateAuthenticator create(String r1) {
        return new HttpNegotiateAuthenticator(r1);
    }

    private void processResult(Bundle r9, RequestData r10) {
        this.mSpnegoContext = r9.getBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT);
        int r1 = -9;
        switch(r9.getInt(HttpNegotiateConstants.KEY_SPNEGO_RESULT, 1)) {
            case 0: goto L13;
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L14;
        };
    L5:
        r1 = NetError.ERR_MALFORMED_IDENTITY;
        goto L14
    L6:
        r1 = NetError.ERR_UNDOCUMENTED_SECURITY_LIBRARY_STATUS;
        goto L14
    L7:
        r1 = NetError.ERR_MISSING_AUTH_CREDENTIALS;
        goto L14
    L8:
        r1 = NetError.ERR_UNSUPPORTED_AUTH_SCHEME;
        goto L14
    L9:
        r1 = NetError.ERR_INVALID_AUTH_CREDENTIALS;
        goto L14
    L10:
        r1 = NetError.ERR_INVALID_RESPONSE;
        goto L14
    L11:
        r1 = NetError.ERR_UNEXPECTED_SECURITY_LIBRARY_STATUS;
        goto L14
    L12:
        r1 = -3;
        goto L14
    L13:
        r1 = 0;
    L14:
        Natives r2 = HttpNegotiateAuthenticatorJni.get();
        long r3 = r10.nativeResultObject;
        r2.setResult(r3, this, r1, r9.getString("authtoken"));
    }

    private void requestTokenWithActivity(Context r1, Activity r2, RequestData r3, String[] r4) {
    }

    private void requestTokenWithoutActivity(Context r1, RequestData r2, String[] r3) {
    }

    @CalledByNative
    @VisibleForTesting
    void getNextAuthToken(long r5, String r7, String r8, boolean r9) {
        Context r0 = ContextUtils.getApplicationContext();
        RequestData r1 = new RequestData();
        r1.authTokenType = HttpNegotiateConstants.SPNEGO_TOKEN_TYPE_BASE + r7;
        r1.accountManager = AccountManager.get(r0);
        r1.nativeResultObject = r5;
        String[] r6 = {HttpNegotiateConstants.SPNEGO_FEATURE};
        Bundle r10 = new Bundle();
        r1.options = r10;
        if (r8 == null) goto L5;
        r10.putString(HttpNegotiateConstants.KEY_INCOMING_AUTH_TOKEN, r8);
    L5:
        Bundle r11 = this.mSpnegoContext;
        if (r11 == null) goto L8;
        r1.options.putBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT, r11);
    L8:
        r1.options.putBoolean(HttpNegotiateConstants.KEY_CAN_DELEGATE, r9);
        Activity r12 = ApplicationStatus.getLastTrackedFocusedActivity();
        if (r12 != null) goto L11;
        requestTokenWithoutActivity(r0, r1, r6);
        return;
    L11:
        requestTokenWithActivity(r0, r12, r1, r6);
    }

    @VisibleForTesting
    boolean lacksPermission(Context r2, String r3, boolean r4) {
        if (r4 == false) goto L8;
        if (Build.VERSION.SDK_INT < 23) goto L8;
        return false;
    L8:
        if (r2.checkPermission(r3, Process.myPid(), Process.myUid()) == 0) goto L11;
        return true;
    L11:
        return false;
    }
}
