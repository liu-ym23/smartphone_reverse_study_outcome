package com.bytedance.applog.p;

import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    public c(HashSet<String> r1, HashMap<String, HashSet<String>> r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.applog.p.a
    protected boolean d(String r1) {
        return this.f2301a.contains(r1);
    }

    @Override // com.bytedance.applog.p.a
    protected boolean e(HashSet<String> r1, String r2) {
        return r1.contains(r2);
    }
}
