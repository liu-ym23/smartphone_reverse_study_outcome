package com.bytedance.memory.c;

import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.d;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.Npth;
import com.bytedance.memory.b.e;
import com.bytedance.memory.b.h;
import com.bytedance.memory.heap.HeapDump;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final File f5010b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile c f5011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f5012d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5013a;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f5014f;

        a(c r1) {
            this.f5014f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f5014f);
        }
    }

    static {
    }

    private c() {
        this.f5013a = System.currentTimeMillis();
        com.bytedance.memory.a.a.l().j();
    }

    static /* synthetic */ void a(c r0) {
        r0.e();
    }

    private File c(File r5) {
        String r4 = d.k().optString(WsConstants.KEY_DEVICE_ID);
        String r0 = d.k().optString("update_version_code");
        com.bytedance.memory.heap.a.o().E(r0);
        File r1 = new File(r5.getParent(), r4 + "_" + r0 + "_shrink.zip");
        h.c(r5, r1);
        if (r5.exists() == false) goto L5;
        r5.delete();
    L5:
        com.bytedance.memory.heap.a.o().D(true);
        com.bytedance.memory.heap.a.o().C(r1.getAbsolutePath());
        com.bytedance.memory.heap.a.o().B(4);
        return r1;
    }

    @WorkerThread
    private void d() {
        long r0 = System.nanoTime();
        File r2 = f5012d.j();
        File r3 = f5010b;
        if (r2 != r3) goto L5;
        return;
    L5:
        File r4 = r2.getParentFile();
        if (r4.exists() == true) goto L8;
        r4.mkdirs();
    L8:
        long r5 = System.currentTimeMillis();
        com.bytedance.memory.d.a.e("dump_begin");
        com.bytedance.memory.f.a.InterfaceC0157a r6 = com.bytedance.memory.a.a.l().k().b();
        if (r6 != null) goto L11;
    L15:
        File r7 = j(r2);
        com.bytedance.memory.heap.a.o().D(false);
    L16:
        com.bytedance.memory.d.a.e("dump_end");
        com.bytedance.memory.d.a.f("dump_time", System.currentTimeMillis() - r5);
        if (r7 != r3) goto L19;
        return;
    L19:
        k(r7, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r0));
        com.bytedance.memory.heap.a.o().I(System.currentTimeMillis());
        return;
    L11:
        if (com.bytedance.memory.d.a.a("close_native_dump_and_shrink") == true) goto L15;
        File r9 = new File(b.d().h(), ".mini.hprof");
        if (r6.a(r9) == false) goto L15;
        r7 = c(r9);
        goto L16
    }

    private void e() {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (b() == false) goto L11;
        d();     // Catch: Exception -> L6
        com.bytedance.memory.i.a.i().h();     // Catch: Exception -> L6
        return;
    }

    private long g() {
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L5;
        return 0;
    L5:
        return h(Environment.getExternalStorageDirectory());
    }

    public static long h(File r5) {
        StatFs r0 = new StatFs(r5.getPath());     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return r0.getAvailableBytes();
    L8:
        return ((long) r0.getBlockCount()) * r0.getBlockSize();
    L9:
        return 0;
    }

    public static c i() {
        if (f5011c != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5011c != null) goto L9;
        f5011c = new c();     // Catch: Throwable -> L11
        f5012d = b.d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f5011c;
    }

    @Nullable
    private File j(File r4) {
    L9:
        e = move-exception;
        com.bytedance.memory.b.c.b(e, "Could not realDump heap", new Object[0]);
        return f5010b;
    L4:
        if (com.bytedance.memory.a.a.l().k().e() != 2) goto L6;
        com.bytedance.memory.b.c.c("Native dump", new Object[0]);     // Catch: Exception -> L9
        Npth.dumpHprof(r4.getAbsolutePath());     // Catch: Exception -> L9
        Thread.sleep(30000);     // Catch: Exception -> L9
        com.bytedance.memory.b.c.c("Native dump exist ? " + new File(r4.getAbsolutePath()).exists(), new Object[0]);     // Catch: Exception -> L9
    L7:
        com.bytedance.memory.heap.a.o().E(d.k().optString("update_version_code"));     // Catch: Exception -> L9
        return r4;
    L6:
        Debug.dumpHprofData(r4.getAbsolutePath());     // Catch: Exception -> L9
        goto L7
    }

    @NonNull
    private HeapDump k(@NonNull File r4, long r5) {
        HeapDump.b r0 = HeapDump.newBuilder();
        r0.g(r4);
        r0.e(0);
        r0.c(this.f5013a);
        r0.h(r4.length());
        r0.d(e.f4999a);
        r0.f(r5);
        HeapDump r3 = r0.a();
        com.bytedance.memory.b.c.c(r3.toString(), new Object[0]);
        com.bytedance.memory.heap.a.o().y(r3);
        return r3;
    }

    public boolean b() {
        long r0 = g();     // Catch: Exception -> L11
        long r2 = com.bytedance.apm.util.b.i();     // Catch: Exception -> L11
        if (r0 > 0) goto L6;
        return false;
    L6:
        if (r2 > 0) goto L8;
        return false;
    L8:
        if (r0 <= (r2 * 1.5f)) goto L19;
        return true;
    L19:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void f(long r1) {
        this.f5013a = r1;
        com.bytedance.memory.heap.a.o().r();
        if (com.bytedance.memory.a.a.l().k().e() != 2) goto L5;
        com.bytedance.memory.b.b.f4995a.a(new a(this), "HeapDumper-dumpHeap");
        return;
    L5:
        e();
    }
}
