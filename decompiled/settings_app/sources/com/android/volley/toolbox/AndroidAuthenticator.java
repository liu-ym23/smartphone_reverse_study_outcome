package com.android.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.volley.AuthFailureError;

/* JADX INFO: loaded from: classes.dex */
public class AndroidAuthenticator implements Authenticator {
    private final Account mAccount;
    private final AccountManager mAccountManager;
    private final String mAuthTokenType;
    private final boolean mNotifyAuthFailure;

    public AndroidAuthenticator(Context r2, Account r3, String r4) {
        this(r2, r3, r4, false);
    }

    public AndroidAuthenticator(Context r1, Account r2, String r3, boolean r4) {
        this(AccountManager.get(r1), r2, r3, r4);
    }

    AndroidAuthenticator(AccountManager r1, Account r2, String r3, boolean r4) {
        this.mAccountManager = r1;
        this.mAccount = r2;
        this.mAuthTokenType = r3;
        this.mNotifyAuthFailure = r4;
    }

    public Account getAccount() {
        return this.mAccount;
    }

    public String getAuthTokenType() {
        return this.mAuthTokenType;
    }

    @Override // com.android.volley.toolbox.Authenticator
    public String getAuthToken() throws AuthFailureError {
        AccountManagerFuture<Bundle> r0 = this.mAccountManager.getAuthToken(this.mAccount, this.mAuthTokenType, this.mNotifyAuthFailure, null, null);
        Bundle r1 = r0.getResult();     // Catch: Exception -> L18
        if (r0.isDone() == true) goto L7;
    L13:
        String r2 = null;
    L14:
        if (r2 == null) goto L17;
        return r2;
    L17:
        throw new AuthFailureError("Got null auth token for type: " + this.mAuthTokenType);
    L7:
        if (r0.isCancelled() == true) goto L13;
        if (r1.containsKey("intent") == true) goto L12;
        r2 = r1.getString("authtoken");
        goto L14
    L12:
        throw new AuthFailureError((Intent) r1.getParcelable("intent"));
    L18:
        e = move-exception;
        throw new AuthFailureError("Error while retrieving auth token", e);
    }

    @Override // com.android.volley.toolbox.Authenticator
    public void invalidateAuthToken(String r2) {
        this.mAccountManager.invalidateAuthToken(this.mAccount.type, r2);
    }
}
