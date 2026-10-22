package com.android.settings.accounts.obric;

import android.content.Context;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener;

/* JADX INFO: loaded from: classes2.dex */
class AccountStatusListener implements IAccountStatusListener {
    private Context mContext;

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onAccountInfoUpdate() {
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onLogin() {
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener
    public void onLogout(int r1) {
    }

    public AccountStatusListener(Context r1) {
        this.mContext = r1;
    }
}
