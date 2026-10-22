package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class e extends d.b.p.a.g.a {
    public e() {
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "IvimageOptPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r1) {
    }

    @Override // d.b.p.a.g.a
    public void d() {
        d.b.p.a.d.h.c(b(), "start");
        if (Build.DISPLAY.contains("Flyme") == false) goto L5;
    L6:
        Class<?> r4 = null;
        r4 = Class.forName("ivimagesr.o000ooo");     // Catch: Throwable -> L10 ClassNotFoundException -> L12
        d.b.p.a.d.h.c("GODZILLA", "Class found = " + r4.getName());     // Catch: Throwable -> L10 ClassNotFoundException -> L12
        if (r4 == null) goto L20;
    L15:
        d.b.p.a.d.h.c("GODZILLA", "Register opt");
        IvimageOpt.start();
    L20:
        return;
    L10:
        th = move-exception;
        if (r4 == null) goto L19;
        d.b.p.a.d.h.c("GODZILLA", "Register opt");
        IvimageOpt.start();
    L19:
        throw th;
    L12:
        e = move-exception;
        d.b.p.a.d.h.c("GODZILLA", e.toString());     // Catch: Throwable -> L10
        if (r4 == null) goto L20;
    L5:
        if (Build.USER.equals("flyme") == true) goto L6;
    }
}
