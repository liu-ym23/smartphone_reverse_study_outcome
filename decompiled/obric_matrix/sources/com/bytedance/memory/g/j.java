package com.bytedance.memory.g;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.bytedance.services.apm.api.EnsureManager;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class j {
    @WorkerThread
    public static File a(@NonNull File r12, @NonNull File r13) {
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L19
        com.bytedance.memory.d.a.d("shrink_begin");     // Catch: Exception -> L19
        com.bytedance.memory.f.a.b r3 = com.bytedance.memory.a.a.l().k().f();     // Catch: Exception -> L19
        File r5 = new File(com.bytedance.memory.c.b.d().h(), ".mini.hprof");     // Catch: Exception -> L19
        if (r3 != null) goto L6;
    L12:
        new b().a(r12, r13);     // Catch: Exception -> L19
        com.bytedance.memory.b.h.d(r13, r5, true);     // Catch: Exception -> L19
        com.bytedance.memory.heap.a r14 = com.bytedance.memory.heap.a.o();     // Catch: Exception -> L19
    L11:
        r14.B(5);     // Catch: Exception -> L19
    L13:
        com.bytedance.memory.d.a.d("shrink_end");     // Catch: Exception -> L19
        com.bytedance.memory.d.a.f("shrink_time", System.currentTimeMillis() - r1);     // Catch: Exception -> L19
        com.bytedance.memory.d.a.f("origin_size", r12.length() / 1024);     // Catch: Exception -> L19
        com.bytedance.memory.d.a.f("shrink_size", r5.length() / 1024);     // Catch: Exception -> L19
        com.bytedance.memory.b.c.c("shrink hprof file %s, size: %dk to %s, size: %dk, use time:%d", new Object[]{r12.getPath(), Long.valueOf(r12.length() / 1024), r5.getPath(), Long.valueOf(r5.length() / 1024), Long.valueOf(System.currentTimeMillis() - r1)});     // Catch: Exception -> L19
        if (r5.exists() == false) goto L24;
        if (r5.length() > 0) goto L26;
        return null;
    L26:
        return r5;
    L24:
        return null;
    L6:
        if (com.bytedance.memory.d.a.a("close_native_shrink") == true) goto L12;
        if (r3.a(r12, r5) == false) goto L10;
        com.bytedance.memory.heap.a.o().B(3);     // Catch: Exception -> L19
        goto L13
    L10:
        new b().a(r12, r13);     // Catch: Exception -> L19
        com.bytedance.memory.b.h.d(r13, r5, true);     // Catch: Exception -> L19
        r14 = com.bytedance.memory.heap.a.o();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "shrink failed");
        e.printStackTrace();
        return null;
    }
}
