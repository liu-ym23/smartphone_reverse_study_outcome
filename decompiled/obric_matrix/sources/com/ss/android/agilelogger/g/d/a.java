package com.ss.android.agilelogger.g.d;

import com.ss.android.agilelogger.g.b;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b<String> {
    public a() {
        this("MM-dd HH:mm:ss");
    }

    public a(String r1) {
        new Date();
    }

    @Override // com.ss.android.agilelogger.g.b
    public /* bridge */ /* synthetic */ String a(String r1) {
        String r2 = r1;
        b(r2);
        return r2;
    }

    public String b(String r1) {
        return r1;
    }
}
