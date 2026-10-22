package com.bytedance.securityserver.trustcircle.account;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.helper.widget.a;
import com.obric.matrix.platform.sdk.ones.account.AccountException;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class AccountStatusListener implements IAccountStatusListener {
    public static volatile AccountStatusListener c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f71a;
    public final Context b;

    public AccountStatusListener(Context r2) {
        this.f71a = Executors.newSingleThreadExecutor();
        this.b = r2;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public final void onAccountInfoUpdate() {
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public final void onLogin() {
        Log.i("SecurityServer-AccountStatusListener", "Account login");
        a r0 = new a(4, this);
        this.f71a.execute(r0);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public final void onLogout(int r4) {
        Context r3 = this.b;
        Log.i("SecurityServer-AccountStatusListener", "Account logout");
        Log.i("SecurityServer-AccountStatusListener", "Account logoutScene: " + OAccount.INSTANCE.logoutScene());     // Catch: AccountException -> L7
        AccountUtils.a(r3, 0);     // Catch: AccountException -> L7
        AccountUtils.a(r3, 1);     // Catch: AccountException -> L7
        if (AccountUtils.i(r3, 1) == 0) goto L12;
        Log.e("SecurityServer-AccountStatusListener", "exit trust circle & revoke account cert chain failed");     // Catch: AccountException -> L7
        AccountUtils.h(r3, 1);     // Catch: AccountException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        Log.e("SecurityServer-AccountStatusListener", "get logoutScene failed, exception: " + e.getMessage());
    }
}
