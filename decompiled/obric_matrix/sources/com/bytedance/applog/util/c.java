package com.bytedance.applog.util;

import com.bytedance.bdinstall.d0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c implements d0 {
    public c() {
    }

    @Override // com.bytedance.bdinstall.d0
    public String a(String r1, byte[] r2, Map<String, String> r3) {
        return com.bytedance.applog.v.a.h(1, r1, (HashMap) r3, r2);
    }

    @Override // com.bytedance.bdinstall.d0
    public byte[] b(String r1, byte[] r2, Map<String, String> r3) {
        return com.bytedance.applog.v.a.j(1, r1, (HashMap) r3, r2);
    }

    @Override // com.bytedance.bdinstall.d0
    public String get(String r2, Map<String, String> r3) {
        return com.bytedance.applog.v.a.h(0, r2, (HashMap) r3, null);
    }
}
