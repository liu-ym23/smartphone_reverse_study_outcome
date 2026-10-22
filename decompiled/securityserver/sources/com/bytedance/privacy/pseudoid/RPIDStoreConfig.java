package com.bytedance.privacy.pseudoid;

import a.a;
import com.bytedance.privacy.network.NetworkConfig;

/* JADX INFO: loaded from: classes.dex */
public class RPIDStoreConfig {
    public static String a(String r1, String r2, String r3) {
        String r4 = r1 + "_" + r2 + r3;
        if (NetworkConfig.a().b() == true) goto L5;
        return r4;
    L5:
        return a.j(r4, "_boe");
    }
}
