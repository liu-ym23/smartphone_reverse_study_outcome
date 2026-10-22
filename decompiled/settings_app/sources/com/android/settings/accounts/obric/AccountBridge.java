package com.android.settings.accounts.obric;

import com.obric.matrix.platform.sdk.ones.account.IAccountService;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountBridge;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AccountBridge implements IAccountBridge {
    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountBridge
    public void onBind(IAccountService r1) {
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountBridge
    public void onDisconnect() {
    }

    public AccountBridge() {
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountBridge
    public ArrayList<String> addTokenHost() {
        return new ArrayList();
    }
}
