package com.bytedance.common.wschannel.u;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3807a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f3808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static File f3809c;

    static {
    }

    public a() {
    }

    public static synchronized File a(Context r5) {
        monitor-enter(a.class);
        File r1 = f3808b;     // Catch: Throwable -> L20
        if (r1 == null) goto L25;
        monitor-exit(a.class);
        return r1;
    L25:
        File r2 = new File(b(r5), c.c(r5).replace(".", "_").replace(":", "-") + "_frontier.bin");     // Catch: Exception -> L15 Throwable -> L20
        if (r2.exists() == true) goto L11;
        r2.createNewFile();     // Catch: Exception -> L15 Throwable -> L20
    L11:
        f3808b = r2;     // Catch: Exception -> L15 Throwable -> L20
        if (Logger.debug() == false) goto L17;
        Logger.d(f3807a, "prepare PersistentFile success. fileName=" + f3808b);     // Catch: Exception -> L15 Throwable -> L20
    L17:
        File r6 = f3808b;     // Catch: Throwable -> L20
        monitor-exit(a.class);
        return r6;
    L15:
        e = move-exception;
        Logger.e(f3807a, "prepare PersistentFile fail.", e);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private static File b(Context r2) {
        File r0 = f3809c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        File r1 = new File(r2.getFilesDir(), "wschannel");
        f3809c = r1;
        if (r1.exists() == true) goto L9;
        f3809c.mkdirs();
    L9:
        return f3809c;
    }
}
