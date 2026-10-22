package com.bytedance.memory.c;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f5001a;

    /* JADX INFO: renamed from: com.bytedance.memory.c.a$a, reason: collision with other inner class name */
    class RunnableC0155a implements Runnable {
        RunnableC0155a(a r1) {
        }

        @Override // java.lang.Runnable
        public void run() {
            long r0 = com.bytedance.memory.heap.a.o().p();     // Catch: Throwable -> L8
            if (r0 != 0) goto L5;
            return;
        L5:
            if ((System.currentTimeMillis() - r0) <= 259200000) goto L14;
            com.bytedance.memory.heap.a.o().i();     // Catch: Throwable -> L8
            return;
        L14:
            return;
        L8:
            th = move-exception;
            th.printStackTrace();
        }
    }

    private a() {
    }

    private boolean a(File r6) {
        com.bytedance.memory.b.c.c("lastModified %d now %d", new Object[]{Long.valueOf(r6.lastModified()), Long.valueOf(System.currentTimeMillis())});
        if ((System.currentTimeMillis() - r6.lastModified()) > 604800000) goto L5;
        return false;
    L5:
        return true;
    }

    public static a d() {
        if (f5001a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5001a != null) goto L9;
        f5001a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f5001a;
    }

    @WorkerThread
    public void b() {
        com.bytedance.memory.b.b.f4995a.a(new RunnableC0155a(this), "DumpFileController-checkWidgetFolder");
    }

    @WorkerThread
    public void c(@NonNull File r5) {
        if (r5.isFile() == false) goto L10;
        if (a(r5) == false) goto L7;
    L8:
        r5.delete();
        return;
    L7:
        if (r5.length() == 0) goto L8;
        return;
    L10:
        if (r5.isDirectory() == false) goto L21;
        File[] r6 = r5.listFiles();
        if (r6 != null) goto L14;
        return;
    L14:
        if (r6.length <= 0) goto L23;
        int r0 = r6.length;
        int r1 = 0;
    L16:
        if (r1 >= r0) goto L24;
        c(r6[r1]);
        r1 = r1 + 1;
        goto L16
    L24:
        return;
    L23:
        return;
    }
}
