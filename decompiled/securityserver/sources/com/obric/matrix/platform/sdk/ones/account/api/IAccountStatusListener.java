package com.obric.matrix.platform.sdk.ones.account.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface IAccountStatusListener {
    void onAccountInfoUpdate();

    void onLogin();

    void onLogout(int r1);
}
