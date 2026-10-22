package z4;

import ai.p;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.os.MessageQueue;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.google.common.reflect.w;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.g;
import com.lynx.tasm.resourceprovider.LynxResourceResponse$ResponseState;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.SoftReference;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import wc.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements d, go.a {
    public static volatile a f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f23389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f23390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f23391c;
    public Object d;
    public Object e;

    public a() {
        this.f23389a = new ConcurrentHashMap();
        this.f23390b = new ConcurrentHashMap();
        this.f23391c = new AtomicBoolean(false);
        this.d = new LinkedHashMap();
        this.e = "";
    }

    @Override // z4.d
    public p a() {
        if (((p) this.f23389a) != null) goto L6;
        this.f23389a = new p(1);
    L6:
        return (p) this.f23389a;
    }

    public void b(int r10) {
        Object r5 = this.f23389a;
        monitor-enter(r5);
        al.b r11 = (al.b) ((HashMap) this.f23391c).get("webx_bullet");     // Catch: Throwable -> L8
        if (r11 != null) goto L10;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L10:
        int r12 = r11.f315a.size();     // Catch: Throwable -> L8
        r11.f317c = r10;     // Catch: Throwable -> L8
        int r13 = 0;
        if (r12 >= r10) goto L16;
    L13:
        if (r13 >= (r10 - r12)) goto L27;
        d(r11);     // Catch: Throwable -> L8
        r13 = r13 + 1;     // Catch: Throwable -> L8
    L27:
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L16:
        if (r13 >= (r12 - r10)) goto L27;
        WebView r14 = (WebView) ((SoftReference) r11.f315a.remove((r12 - 1) - r13)).get();     // Catch: Throwable -> L8
        Context r15 = (Context) this.f23390b;     // Catch: Throwable -> L8
        if (r14 == null) goto L26;
        r14.stopLoading();     // Catch: Throwable -> L8
        if (r15 == null) goto L25;
        Context r16 = r14.getContext();     // Catch: Throwable -> L8
        if ((r16 instanceof MutableContextWrapper) == false) goto L25;
        ((MutableContextWrapper) r16).setBaseContext(r15);     // Catch: Throwable -> L8
    L25:
        r14.loadUrl("about:blank");     // Catch: Throwable -> L8
        r14.destroy();     // Catch: Throwable -> L8
    L26:
        r13 = r13 + 1;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // z4.d
    public CheckFilter c() {
        if (((CheckFilter) this.e) != null) goto L6;
        this.e = new CheckFilter();
    L6:
        return (CheckFilter) this.e;
    }

    @Override // z4.d
    public f9.a d() {
        if (((f9.a) this.f23390b) != null) goto L6;
        this.f23390b = new f9.a(1);
    L6:
        return (f9.a) this.f23390b;
    }

    public void e(String r5, String r10, double r11) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "stepName");
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, r5, r10 + "  recordCpu cpurate: " + r11, "CpuMemoryPerfMetric");
        ((ConcurrentHashMap) this.f23389a).put(r10, Double.valueOf(r11));
    }

    @Override // go.a
    public void f(w r5) {
        if (((LynxResourceResponse$ResponseState) r5.f9377c) != LynxResourceResponse$ResponseState.f10948b) goto L7;
        Object r10 = r5.f9376b;
        if (r10 == null) goto L7;
        ((AtomicReference) this.f23389a).set(r10);
    L8:
        ((CountDownLatch) this.d).countDown();
        return;
    L7:
        StringBuilder r11 = new StringBuilder("Load font with genericResourceFetcher failed:");
        String r12 = u8.a.g((Throwable) r5.d, r11);
        ((g) this.e).getClass();
        g.c(30202, r12, (String) this.f23390b, null, (LynxContext) this.f23391c);
        goto L8
    }

    public void g() {
        FileLock r5 = (FileLock) this.f23390b;
        if (r5 != null) goto L8;
    L5:
        com.bytedance.librarian.b r10 = (com.bytedance.librarian.b) this.e;
        f r11 = r10.f6778b;
        f.g("released lock " + ((File) this.d).getPath());
        r10.c((FileChannel) this.f23391c);
        r10.c((RandomAccessFile) this.f23389a);
        return;
    L8:
        r5.release();     // Catch: IOException -> L7
        goto L5
    }

    @Override // z4.d
    public a5.c getInitConfig() {
        return null;
    }

    public void h() {
        com.bytedance.librarian.b r5 = (com.bytedance.librarian.b) this.e;
        File r10 = (File) this.d;
        RandomAccessFile r11 = new RandomAccessFile(r10, "rw");
        this.f23389a = r11;
        this.f23391c = r11.getChannel();     // Catch: IOException -> L7
        f r12 = r5.f6778b;     // Catch: IOException -> L9
        f.g("blocking on lock " + r10.getPath());     // Catch: IOException -> L9
        this.f23390b = ((FileChannel) this.f23391c).lock();     // Catch: IOException -> L9
        f.g("acquired on lock " + r10.getPath());     // Catch: IOException -> L7
        return;
    L9:
        e = move-exception;
        r5.c((FileChannel) this.f23391c);     // Catch: IOException -> L7
        throw e;     // Catch: IOException -> L7
    L7:
        e = move-exception;
        r5.c((RandomAccessFile) this.f23389a);
        throw e;
    }

    @Override // z4.d
    public HashMap e() {
        if (((HashMap) this.f23391c) != null) goto L6;
        this.f23391c = new HashMap();
    L6:
        return (HashMap) this.f23391c;
    }

    public void c(long r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "stepName");
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.b(8, r10, r11 + "  recordMemroy memory: " + r5, "CpuMemoryPerfMetric");
        ((ConcurrentHashMap) this.f23390b).put(r11, Long.valueOf(r5));
    }

    public void d(al.b r5) {
        if (((MessageQueue) this.d) == null) goto L12;
        Object r10 = this.e;
        monitor-enter(r10);
        monitor-exit(r10);     // Catch: Throwable -> L9
        ((MessageQueue) this.d).addIdleHandler(new zk.a(this, r5));
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        this.d = Looper.getMainLooper().getQueue();
        d(r5);
    }

    @Override // z4.d
    public HashSet f() {
        if (((HashSet) this.d) != null) goto L6;
        this.d = new HashSet();
    L6:
        return (HashSet) this.d;
    }

    @Override // z4.d
    public ArrayList b() {
        return new ArrayList();
    }
}
