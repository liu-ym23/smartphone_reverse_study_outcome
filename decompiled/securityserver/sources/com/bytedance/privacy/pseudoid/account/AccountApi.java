package com.bytedance.privacy.pseudoid.account;

import com.bytedance.privacy.bridge.IAccountBridge;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AccountApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IAccountBridge f23a;

    public static String a() {
        IAccountBridge r0 = f23a;
        if (r0 == null) goto L5;
        String r1 = r0.e();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }
}
