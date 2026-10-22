package com.ss.android.i;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static com.ss.android.i.m.a a() {
        com.ss.android.i.m.a r0 = j.k().k();
        if (r0 == null) goto L10;
        if (r0.init(j.k().e()) == false) goto L8;
        return r0;
    L8:
        throw new RuntimeException("please implement IAccountSec interface correctly");
    L10:
        throw new RuntimeException("please provide IAccountSec implementation");
    }
}
