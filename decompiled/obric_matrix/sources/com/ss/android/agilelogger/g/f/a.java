package com.ss.android.agilelogger.g.f;

import com.ss.android.agilelogger.g.b;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {
    public a() {
    }

    @Override // com.ss.android.agilelogger.g.b
    public /* bridge */ /* synthetic */ String a(Object r1) {
        return b((Thread) r1);
    }

    public String b(Thread r2) {
        StringBuffer r1 = new StringBuffer();
        r1.append("Thread: ");
        r1.append(r2.getName());
        return r1.toString();
    }
}
