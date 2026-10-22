package com.bytedance.securityserver.adapter.api;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public interface ISecretDataManager {
    ISecretData a();

    ISecretQueryResult b(Context r1, Bundle r2);

    ISecretAddResult c(Context r1, ISecretData r2, Bundle r3);

    int d(Context r1, ISecretData r2, Bundle r3);
}
