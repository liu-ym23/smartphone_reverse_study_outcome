package com.obric.matrix.monitor;

import android.os.ParcelFileDescriptor;
import android.os.SharedMemory;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.os.oms.monitor.OmsMonitorProviderBase;
import com.obric.matrix.ostracker_api.b;
import com.obric.matrix.r.c.c;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class OmsMonitorBackendService extends OmsMonitorProviderBase {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Integer, a> f9220f;

    private final class a implements Closeable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f9221f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f9222g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final SharedMemory f9223h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final InputStream f9224i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private ByteBuffer f9225j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final Thread f9226k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private volatile boolean f9227l;
        private boolean m;
        private int n;
        final /* synthetic */ OmsMonitorBackendService o;

        a(OmsMonitorBackendService r2, int r3, String r4, SharedMemory r5, ParcelFileDescriptor r6) {
            this.o = r2;
            this.f9227l = true;
            this.f9221f = r3;
            this.f9222g = r4;
            this.f9223h = r5;
            this.f9224i = new ParcelFileDescriptor.AutoCloseInputStream(r6);
            ByteBuffer r7 = r5.mapReadWrite().order(ByteOrder.LITTLE_ENDIAN);
            this.f9225j = r7;
            this.n = r7.getInt(16);
            Thread r8 = new Thread(new com.obric.matrix.monitor.a(this), "oms-monitor-reader-" + r3);
            this.f9226k = r8;
            r8.setDaemon(true);
        }

        private void a(int r4, int r5, byte[] r6) {
            String r0 = new String(r6, StandardCharsets.UTF_8);
            JSONObject r7 = new JSONObject(r0);     // Catch: JSONException -> L10
            if (r4 != 1) goto L7;
            OmsMonitorBackendService.c(r5, r7.optString(LocationMonitorConst.TAG), r7.optString("message"), r7.optString("throwable"));     // Catch: JSONException -> L10
        L13:
            return;
        L7:
            if (r4 != 2) goto L13;
            OmsMonitorBackendService.d(r7.optString("eventName"), r7.optJSONObject("params"));     // Catch: JSONException -> L10
        L10:
            e = move-exception;
            c.t("OmsMonitorProvider", "bad payload channel=" + this.f9221f + ", payload=" + r0, e);
        }

        private synchronized void g() {
            monitor-enter(this);
            ByteBuffer r0 = this.f9225j;     // Catch: Throwable -> L52
            if (this.m == false) goto L6;
        L50:
            monitor-exit(this);
            return;
        L6:
            if (this.f9227l == false) goto L50;
            if (r0 == null) goto L50;
            if (r0.getInt(0) == 1330467661) goto L15;
            c.s("OmsMonitorProvider", "bad channel magic id=" + this.f9221f);     // Catch: Throwable -> L52
            OmsMonitorBackendService.b(this.o, this.f9221f, "bad_channel_magic");     // Catch: Throwable -> L52
            monitor-exit(this);
            return;
        L15:
            int r1 = r0.getInt(32);     // Catch: Throwable -> L52
            int r3 = r0.getInt(36);     // Catch: Throwable -> L52
            int r4 = r0.getInt(12);     // Catch: Throwable -> L52
        L16:
            int r5 = this.n;     // Catch: Throwable -> L52
            if (r5 >= r4) goto L47;
            int r6 = Math.floorMod(r5, r3) + r1;     // Catch: Throwable -> L52
            int r7 = r6 + 8;     // Catch: Throwable -> L52
            int r8 = r1 + r3;     // Catch: Throwable -> L52
            if (r7 > r8) goto L20;
            int r9 = r0.getInt(r6 + 0);     // Catch: Throwable -> L52
            int r10 = r0.getInt(r6 + 4);     // Catch: Throwable -> L52
            if (r9 != 1330467666) goto L24;
            if (r10 == 0) goto L28;
            if (r10 < 36) goto L43;
            if (r10 > r3) goto L43;
            if ((r6 + r10) > r8) goto L43;
            int r11 = r0.getInt(r7);     // Catch: Throwable -> L52
            int r12 = r0.getInt(r6 + 12);     // Catch: Throwable -> L52
            int r13 = r0.getInt(r6 + 32);     // Catch: Throwable -> L52
            if (r13 < 0) goto L40;
            if (r13 > (r10 - 36)) goto L40;
            byte[] r14 = new byte[r13];     // Catch: Throwable -> L52
            ByteBuffer r15 = r0.duplicate();     // Catch: Throwable -> L52
            r15.position(r6 + 36);     // Catch: Throwable -> L52
            r15.get(r14);     // Catch: Throwable -> L52
            a(r11, r12, r14);     // Catch: Throwable -> L52
            this.n += r10;     // Catch: Throwable -> L52
        L40:
            c.s("OmsMonitorProvider", "bad payload length channel=" + this.f9221f + ", length=" + r13 + ", size=" + r10);     // Catch: Throwable -> L52
            OmsMonitorBackendService.b(this.o, this.f9221f, "bad_payload_length");     // Catch: Throwable -> L52
            monitor-exit(this);
            return;
        L43:
            c.s("OmsMonitorProvider", "bad record size channel=" + this.f9221f + ", size=" + r10);     // Catch: Throwable -> L52
            OmsMonitorBackendService.b(this.o, this.f9221f, "bad_record_size");     // Catch: Throwable -> L52
            monitor-exit(this);
            return;
        L28:
            int r16 = this.n;     // Catch: Throwable -> L52
        L21:
            this.n = r16 + (r8 - r6);     // Catch: Throwable -> L52
            goto L16
        L24:
            c.s("OmsMonitorProvider", "bad record magic channel=" + this.f9221f + ", package=" + this.f9222g);     // Catch: Throwable -> L52
            OmsMonitorBackendService.b(this.o, this.f9221f, "bad_record_magic");     // Catch: Throwable -> L52
            monitor-exit(this);
            return;
        L20:
            r16 = this.n;     // Catch: Throwable -> L52
            goto L21
        L47:
            r0.putInt(16, r5);     // Catch: Throwable -> L52
            monitor-exit(this);
            return;
        L52:
            th = move-exception;
            throw th;
        }

        public static /* synthetic */ void l(a r0) {
            r0.s();
        }

        private void s() {
            byte[] r1 = new byte[64];
        L4:
            if (this.f9227l == false) goto L28;
        L13:
            e = move-exception;
            if (this.f9227l == false) goto L27;
            c.t("OmsMonitorProvider", "signal read failed channel=" + this.f9221f, e);
            OmsMonitorBackendService.b(this.o, this.f9221f, "io_error");
            return;
        L27:
            return;
        L11:
            th = move-exception;
            c.t("OmsMonitorProvider", "reader failure channel=" + this.f9221f, th);
            goto L4
        L6:
            if (this.f9224i.read(r1) >= 0) goto L9;
            OmsMonitorBackendService.b(this.o, this.f9221f, "eof");     // Catch: Throwable -> L11 IOException -> L13
        L8:
            return;
        L9:
            g();     // Catch: Throwable -> L11 IOException -> L13
            goto L4
        }

        void b() {
            g();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            c.t("OmsMonitorProvider", "drain failed channel=" + this.f9221f, th);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (this.m == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.m = true;     // Catch: Throwable -> L14
            this.f9227l = false;     // Catch: Throwable -> L14
            OmsMonitorBackendService.a(this.f9224i);     // Catch: Throwable -> L14
            ByteBuffer r0 = this.f9225j;     // Catch: Throwable -> L14
            this.f9225j = null;     // Catch: Throwable -> L14
            if (r0 != null) goto L20;
        L11:
            OmsMonitorBackendService.a(this.f9223h);     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L20:
            SharedMemory.unmap(r0);     // Catch: Throwable -> L17
            goto L11
        }

        void x() {
            this.f9226k.start();
        }
    }

    public OmsMonitorBackendService() {
        this.f9220f = new ConcurrentHashMap();
    }

    static /* synthetic */ void a(Closeable r0) {
        e(r0);
    }

    static /* synthetic */ void b(OmsMonitorBackendService r0, int r1, String r2) {
        r0.i(r1, r2);
    }

    static /* synthetic */ void c(int r0, String r1, String r2, String r3) {
        g(r0, r1, r2, r3);
    }

    static /* synthetic */ void d(String r0, JSONObject r1) {
        f(r0, r1);
    }

    private static void e(Closeable r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: IOException -> L6
        return;
    }

    private static void f(String r1, JSONObject r2) {
        if (h(r1) == false) goto L6;
        c.s("OmsMonitorProvider", "ignore empty eventName");
        return;
    L6:
        if (r2 != null) goto L8;
        r2 = new JSONObject();
    L8:
        b.g(r1, r2);
    }

    private static void g(int r2, String r3, String r4, String r5) {
        if (h(r3) == false) goto L5;
        String r6 = "OmsMonitorProvider";
    L7:
        if (h(r4) == false) goto L10;
        r4 = "";
    L10:
        if (h(r5) == true) goto L12;
        r4 = r4 + '\n' + r5;
    L12:
        switch(r2) {
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L14;
            default: goto L16;
        };
    L14:
        c.f(r6, r4);
        return;
    L15:
        c.s(r6, r4);
        return;
    L16:
        c.j(r6, r4);
        return;
    L17:
        c.b(r6, r4);
        return;
    L18:
        c.q(r6, r4);
        return;
    L5:
        r6 = "OmsMonitor_" + r3;
        goto L7
    }

    private static boolean h(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }

    private void i(int r2, String r3) {
        a r1 = this.f9220f.remove(Integer.valueOf(r2));
        if (r1 == null) goto L6;
        r1.close();
        c.j("OmsMonitorProvider", "removeChannel id=" + r2 + ", reason=" + r3);
        return;
    }

    protected void notifyChannel(int r1) {
        a r0 = this.f9220f.get(Integer.valueOf(r1));
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public void onDestroy() {
        Iterator<a> r0 = this.f9220f.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().close();
        goto L4
    L6:
        this.f9220f.clear();
        super.onDestroy();
    }

    protected void registerChannel(int r10, String r11, SharedMemory r12, ParcelFileDescriptor r13) {
        unregisterChannel(r10);
        a r8 = new a(this, r10, r11, r12, r13);     // Catch: Throwable -> L5
        this.f9220f.put(Integer.valueOf(r10), r8);     // Catch: Throwable -> L5
        r8.x();     // Catch: Throwable -> L5
        c.j("OmsMonitorProvider", "registerChannel id=" + r10 + ", package=" + r11);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        c.g("OmsMonitorProvider", "registerChannel failed id=" + r10 + ", package=" + r11, th);
        e(r12);
        e(r13);
    }

    protected void unregisterChannel(int r2) {
        i(r2, "unregister");
    }
}
