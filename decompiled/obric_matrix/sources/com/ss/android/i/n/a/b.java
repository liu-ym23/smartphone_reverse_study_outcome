package com.ss.android.i.n.a;

import android.content.Context;
import java.io.File;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11915a = null;

    static {
        f11915a = new b();
    }

    private b() {
    }

    public final File a(Context r2, String r3) {
        o.g(r2, "context");
        o.g(r3, "fileName");
        File r1 = new File(r2.getFilesDir(), "sec_share_data_file");     // Catch: Throwable -> L8
        if (r1.exists() == true) goto L6;
        r1.mkdirs();     // Catch: Throwable -> L8
    L6:
        return new File(r1, r3);
    L8:
        return null;
    }
}
