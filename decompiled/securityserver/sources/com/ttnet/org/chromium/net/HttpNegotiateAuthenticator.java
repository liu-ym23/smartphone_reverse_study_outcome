package com.ttnet.org.chromium.net;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net::android")
public class HttpNegotiateAuthenticator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "net_auth";
    private final String mAccountType;
    private Bundle mSpnegoContext;

    @VisibleForTesting
    public class GetAccountsCallback implements AccountManagerCallback<Account[]> {
        private final RequestData mRequestData;
        final /* synthetic */ HttpNegotiateAuthenticator this$0;

        public GetAccountsCallback(HttpNegotiateAuthenticator r1, RequestData r2) {
            this.this$0 = r1;
            this.mRequestData = r2;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Account[]> r9) {
            Account[] r10 = r9.getResult();     // Catch: Throwable -> L12
            if (r10.length != 0) goto L9;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ", new Object[0]);
            HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, this.this$0, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
            return;
        L9:
            if (r10.length <= 1) goto L17;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: Found %d accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.", new Object[]{Integer.valueOf(r10.length)});
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
    public class GetTokenCallback implements AccountManagerCallback<Bundle> {
        private final RequestData mRequestData;
        final /* synthetic */ HttpNegotiateAuthenticator this$0;

        public GetTokenCallback(HttpNegotiateAuthenticator r1, RequestData r2) {
            this.this$0 = r1;
            this.mRequestData = r2;
        }

        public static /* synthetic */ RequestData access$000(GetTokenCallback r0) {
            return r0.mRequestData;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> r9) {
            Bundle r10 = r9.getResult();     // Catch: Throwable -> L8
            if (r10.containsKey("intent") == false) goto L6;
            final Context r11 = ContextUtils.getApplicationContext();
            r11.registerReceiver(new AnonymousClass1(this, r11), new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"));
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

    public interface Natives {
        void setResult(long r1, HttpNegotiateAuthenticator r3, int r4, String r5);
    }

    public static class RequestData {
        public Account account;
        public AccountManager accountManager;
        public String authTokenType;
        public long nativeResultObject;
        public Bundle options;

        public RequestData() {
        }
    }

    public HttpNegotiateAuthenticator(String r1) {
        this.mAccountType = r1;
    }

    public static /* synthetic */ void access$100(HttpNegotiateAuthenticator r0, Bundle r1, RequestData r2) {
        r0.processResult(r1, r2);
    }

    @CalledByNative
    @VisibleForTesting
    public static HttpNegotiateAuthenticator create(String r1) {
        return new HttpNegotiateAuthenticator(r1);
    }

    private void processResult(Bundle r9, RequestData r10) {
        this.mSpnegoContext = r9.getBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT);
        int r1 = -9;
        switch(r9.getInt(HttpNegotiateConstants.KEY_SPNEGO_RESULT, 1)) {
            case 0: goto L13;
            case 1: goto L4;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        int r6 = r1;
        HttpNegotiateAuthenticatorJni.get().setResult(r10.nativeResultObject, this, r6, r9.getString("authtoken"));
        return;
    L5:
        r1 = NetError.ERR_MALFORMED_IDENTITY;
        goto L4
    L6:
        r1 = NetError.ERR_UNDOCUMENTED_SECURITY_LIBRARY_STATUS;
        goto L4
    L7:
        r1 = NetError.ERR_MISSING_AUTH_CREDENTIALS;
        goto L4
    L8:
        r1 = NetError.ERR_UNSUPPORTED_AUTH_SCHEME;
        goto L4
    L9:
        r1 = NetError.ERR_INVALID_AUTH_CREDENTIALS;
        goto L4
    L10:
        r1 = NetError.ERR_INVALID_RESPONSE;
        goto L4
    L11:
        r1 = NetError.ERR_UNEXPECTED_SECURITY_LIBRARY_STATUS;
        goto L4
    L12:
        r1 = -3;
        goto L4
    L13:
        r1 = 0;
        goto L4
    }

    private void requestTokenWithActivity(Context r1, Activity r2, RequestData r3, String[] r4) {
    }

    private void requestTokenWithoutActivity(Context r1, RequestData r2, String[] r3) {
    }

    @CalledByNative
    @VisibleForTesting
    public void getNextAuthToken(long r4, String r6, String r7, boolean r8) {
        Context r0 = ContextUtils.getApplicationContext();
        RequestData r1 = new RequestData();
        r1.authTokenType = a.a.A(HttpNegotiateConstants.SPNEGO_TOKEN_TYPE_BASE, r6);
        r1.accountManager = AccountManager.get(r0);
        r1.nativeResultObject = r4;
        String[] r5 = {HttpNegotiateConstants.SPNEGO_FEATURE};
        Bundle r9 = new Bundle();
        r1.options = r9;
        if (r7 == null) goto L5;
        r9.putString(HttpNegotiateConstants.KEY_INCOMING_AUTH_TOKEN, r7);
    L5:
        Bundle r10 = this.mSpnegoContext;
        if (r10 == null) goto L8;
        r1.options.putBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT, r10);
    L8:
        r1.options.putBoolean(HttpNegotiateConstants.KEY_CAN_DELEGATE, r8);
        Activity r11 = ApplicationStatus.getLastTrackedFocusedActivity();
        if (r11 != null) goto L11;
        requestTokenWithoutActivity(r0, r1, r5);
        return;
    L11:
        requestTokenWithActivity(r0, r11, r1, r5);
    }

    @VisibleForTesting
    public boolean lacksPermission(Context r2, String r3, boolean r4) {
        if (r4 == false) goto L6;
        return false;
    L6:
        if (r2.checkPermission(r3, Process.myPid(), Process.myUid()) == 0) goto L9;
        return true;
    L9:
        return false;
    }
}
