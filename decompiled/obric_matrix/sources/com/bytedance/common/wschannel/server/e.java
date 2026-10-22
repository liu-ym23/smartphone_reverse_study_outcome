package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.utility.Logger;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f3752f = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f3753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MappedByteBuffer f3754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PriorityQueue<Integer> f3755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, C0108e> f3756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f3757e;

    class a extends com.bytedance.common.wschannel.u.e {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ e f3758i;

        a(e r1, long r2, long r4) {
            this.f3758i = r1;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.a(this.f3758i).get() == false) goto L5;
            return;
        L5:
            e.b(this.f3758i);
            e.c(this.f3758i, null, 2, -1);
        }
    }

    class b extends com.bytedance.common.wschannel.u.e {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f3759i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e f3760j;

        b(e r1, String r2) {
            this.f3760j = r1;
            this.f3759i = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c(this.f3760j, this.f3759i, 0, -1);
        }
    }

    class c extends com.bytedance.common.wschannel.u.e {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f3761i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f3762j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ e f3763k;

        c(e r1, String r2, long r3) {
            this.f3763k = r1;
            this.f3761i = r2;
            this.f3762j = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r0 = e.d(this.f3763k, this.f3761i, this.f3762j);
            if (r0 < 0) goto L10;
            C0108e r1 = (C0108e) e.e(this.f3763k).get(this.f3761i);
            if (r1 == null) goto L8;
            r1.c(r0);
        L8:
            if (Logger.debug() == false) goto L12;
            Logger.d(e.f(), "mapToFile success, message id:" + this.f3761i + " offset:" + r0);
            return;
        L12:
            return;
        L10:
            e.c(this.f3763k, this.f3761i, 1, -1);
        }
    }

    class d extends com.bytedance.common.wschannel.u.e {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f3764i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e f3765j;

        d(e r1, List r2) {
            this.f3765j = r1;
            this.f3764i = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r0 = this.f3764i.iterator();
            boolean r1 = false;
        L4:
            if (r0.hasNext() == false) goto L10;
            String r2 = (String) r0.next();
            if (e.e(this.f3765j).containsKey(r2) == false) goto L4;
            int r3 = ((C0108e) e.e(this.f3765j).get(r2)).a();
            e.e(this.f3765j).remove(r2);
            e.g(this.f3765j, r3);
            if (r1 == true) goto L4;
            r1 = true;
            goto L4
        L10:
            if (r1 == false) goto L20;
            e.h(this.f3765j);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.e$e, reason: collision with other inner class name */
    static class C0108e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f3766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3767b;

        public C0108e(long r1, int r3) {
            this.f3766a = r1;
            this.f3767b = r3;
        }

        public int a() {
            return this.f3767b;
        }

        public long b() {
            return this.f3766a;
        }

        public void c(int r1) {
            this.f3767b = r1;
        }
    }

    static {
    }

    public e(Context r13) {
        this.f3753a = new byte[40];
        this.f3755c = new PriorityQueue();
        this.f3756d = new ConcurrentHashMap();
        this.f3757e = new AtomicBoolean(false);
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L23
        FileChannel r14 = new RandomAccessFile(com.bytedance.common.wschannel.u.a.a(r13), "rw").getChannel();     // Catch: Throwable -> L23
        FileLock r3 = r14.tryLock();     // Catch: Throwable -> L21
        this.f3754b = r14.map(FileChannel.MapMode.READ_WRITE, 0, 262144);     // Catch: Throwable -> L19
        if (Logger.debug() == false) goto L9;
        Logger.d(f3752f, "magic number: " + l() + " file version: " + k() + " total count: " + n() + " total bytes: " + m());     // Catch: Throwable -> L19
    L9:
        if (l() == 2114) goto L11;
    L16:
        y();     // Catch: Throwable -> L19
    L17:
        com.bytedance.common.wschannel.u.d.d().e(new a(this, 3600000, 3600000));     // Catch: Throwable -> L19
        x(null, 4, System.currentTimeMillis() - r1);     // Catch: Throwable -> L19
        return;
    L11:
        if (m() <= 0) goto L16;
        if (n() <= 0) goto L16;
        p();     // Catch: Throwable -> L19
    L19:
        Throwable th = th;
    L25:
        Logger.e(f3752f, "create MappedByteBuffer failed: ", th);
        this.f3757e.set(true);
        w(5, th);
        if (r3 != null) goto L32;
    L28:
        if (r14 == null) goto L40;
        r14.close();     // Catch: IOException -> L31
        return;
    L42:
        return;
    L40:
        return;
    L32:
        r3.release();     // Catch: IOException -> L31
    L21:
        th = move-exception;
        r3 = null;
        th = th;
    L23:
        th = move-exception;
        r3 = null;
        th = th;
        r14 = null;
        goto L25
    }

    private void A(int r2) {
        this.f3754b.putInt(4, r2);
    }

    static /* synthetic */ AtomicBoolean a(e r0) {
        return r0.f3757e;
    }

    static /* synthetic */ void b(e r0) {
        r0.u();
    }

    static /* synthetic */ void c(e r0, String r1, int r2, long r3) {
        r0.x(r1, r2, r3);
    }

    static /* synthetic */ int d(e r0, String r1, long r2) {
        return r0.r(r1, r2);
    }

    static /* synthetic */ ConcurrentHashMap e(e r0) {
        return r0.f3756d;
    }

    static /* synthetic */ String f() {
        return f3752f;
    }

    static /* synthetic */ void g(e r0, int r1) {
        r0.v(r1);
    }

    static /* synthetic */ void h(e r0) {
        r0.j();
    }

    private void j() {
        this.f3754b.force();
    }

    private long k() {
        return this.f3754b.getShort(2);
    }

    private short l() {
        return this.f3754b.getShort(0);
    }

    private int m() {
        return this.f3754b.getInt(8);
    }

    private int n() {
        return this.f3754b.getInt(4);
    }

    private void p() {
        this.f3754b.position(12);
        long r0 = System.currentTimeMillis();
        int r2 = m() / 40;
        int r3 = 0;
        boolean r4 = false;
    L3:
        if (r3 >= r2) goto L19;
        byte[] r5 = new byte[32];
        this.f3754b.get(r5);
        long r6 = this.f3754b.getLong();
        if (q(r5) == false) goto L11;
        if (Logger.debug() == false) goto L9;
        Logger.d(f3752f, "Data is empty, bypass remove offset:" + r3);
    L9:
        this.f3755c.add(Integer.valueOf(r3));
    L18:
        r3 = r3 + 1;
        goto L3
    L11:
        if (r6 >= r0) goto L15;
        v(r3);
        if (r4 == true) goto L18;
        r4 = true;
        goto L18
    L15:
        String r8 = new String(r5, StandardCharsets.UTF_8);
        C0108e r9 = new C0108e(r6, r3);
        this.f3756d.put(r8, r9);
        if (Logger.debug() == false) goto L18;
        Logger.d(f3752f, "initPersistentBuffer item: " + new String(r5) + "&" + r9.b() + "_" + r9.a());
        goto L18
    L19:
        if (r4 == false) goto L22;
        j();
    L22:
        if (Logger.debug() == false) goto L31;
        Logger.d(f3752f, "map size:" + this.f3756d.size() + " total count:" + n() + " data size:" + r2 + " total bytes:" + m());
        return;
    }

    private boolean q(byte[] r4) {
        if (r4 != null) goto L5;
    L14:
        return true;
    L5:
        if (r4.length == 0) goto L14;
        int r1 = 0;
    L9:
        if (r1 >= r4.length) goto L14;
        if (r4[r1] != 0) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return false;
    }

    private int r(String r9, long r10) {
        byte[] r0 = r9.getBytes();
        if (r0 != null) goto L5;
    L27:
        return -1;
    L5:
        if (r0.length != 32) goto L27;
        int r2 = s(r0, r10);
        if (r2 < 0) goto L11;
        return r2;
    L11:
        if (this.f3754b.remaining() >= 40) goto L13;
    L22:
        String r3 = f3752f;
        Logger.i(r3, "remaining:" + this.f3754b.remaining() + " total count:" + n() + " threshold:6553 total bytes:" + m() + " threshold:262104");
        x(r9, 3, -1);
        t();
        int r8 = s(r0, r10);
        if (r8 >= 0) goto L26;
        Logger.e(r3, "Push data failed, removeDataForAvailableStorage is not working.");
        return -1;
    L26:
        return r8;
    L13:
        if (n() >= 6553) goto L22;
        if (m() >= 262104) goto L22;
        this.f3754b.position(m() + 12);
        this.f3754b.put(r0);
        this.f3754b.putLong(r10);
        int r11 = n();
        A(r11 + 1);
        z(m() + 40);
        if (Logger.debug() == false) goto L20;
        Logger.d(f3752f, String.format("push success in file: offset=%s, totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(r11), Integer.valueOf(n()), Integer.valueOf(m()), r9}));
    L20:
        j();
        return r11;
    }

    private int s(byte[] r4, long r5) {
        if (this.f3755c.isEmpty() == false) goto L6;
        return -1;
    L6:
        int r0 = this.f3755c.poll().intValue();
        this.f3754b.position((r0 * 40) + 12);
        this.f3754b.put(r4);
        this.f3754b.putLong(r5);
        A(n() + 1);
        if (Logger.debug() == false) goto L9;
        Logger.d(f3752f, String.format("push success in queue: offset=%s, totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(r0), Integer.valueOf(n()), Integer.valueOf(m()), new String(r4)}));
    L9:
        return r0;
    }

    private void t() {
        Logger.i(f3752f, "available:1092 queue:" + this.f3755c.size());
        Iterator<Map.Entry<String, C0108e>> r0 = this.f3756d.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        C0108e r1 = r0.next().getValue();
        if (r1.a() >= 1092) goto L4;
        v(r1.a());
        r0.remove();
        goto L4
    }

    private void u() {
        if (Logger.debug() == false) goto L5;
        Logger.d(f3752f, "removeExpiredCachedData");
    L5:
        Iterator<Map.Entry<String, C0108e>> r0 = this.f3756d.entrySet().iterator();
        long r1 = System.currentTimeMillis();
        boolean r3 = false;
    L7:
        if (r0.hasNext() == false) goto L13;
        C0108e r4 = r0.next().getValue();
        if (r4.b() >= r1) goto L7;
        v(r4.a());
        r0.remove();
        if (r3 == true) goto L7;
        r3 = true;
        goto L7
    L13:
        if (r3 == false) goto L23;
        j();
        return;
    }

    private void v(int r4) {
        if (r4 >= 0) goto L4;
        return;
    L4:
        this.f3754b.position((r4 * 40) + 12);
        this.f3754b.put(this.f3753a);
        A(n() - 1);
        this.f3755c.add(Integer.valueOf(r4));
        if (Logger.debug() == false) goto L8;
        Logger.d(f3752f, String.format("remove success: offset=%s, totalCount=%s, totalBytes=%s", new Object[]{Integer.valueOf(r4), Integer.valueOf(n()), Integer.valueOf(m())}));
        return;
    }

    private void w(int r2, Throwable r3) {
        JSONObject r1 = new JSONObject();
        r1.put("action", r2);     // Catch: JSONException -> L10
        String r4 = com.bytedance.common.wschannel.u.c.p(r3);     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r4) == false) goto L6;
    L8:
        r1.put("exception", r4);     // Catch: JSONException -> L10
    L12:
        com.bytedance.common.wschannel.server.d.l(r1);
        return;
    L6:
        if (r4.length() <= 2048) goto L8;
        r4 = r4.substring(0, 2048);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private void x(String r7, int r8, long r9) {
        int r0 = this.f3756d.size();
        int r1 = this.f3755c.size();
        int r2 = n();
        int r6 = m();
        JSONObject r3 = new JSONObject();
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        com.bytedance.common.wschannel.server.d.l(r3);
        return;
    L4:
        if (TextUtils.isEmpty(r7) == true) goto L7;
        r3.put("messageId", r7);     // Catch: JSONException -> L11
    L7:
        if (r9 < 0) goto L9;
        r3.put(TypedValues.TransitionType.S_DURATION, r9);     // Catch: JSONException -> L11
    L9:
        r3.put("action", r8);     // Catch: JSONException -> L11
        r3.put("mapSize", r0);     // Catch: JSONException -> L11
        r3.put("queueSize", r1);     // Catch: JSONException -> L11
        r3.put("totalCount", r2);     // Catch: JSONException -> L11
        r3.put("totalBytes", r6);     // Catch: JSONException -> L11
        goto L13
    }

    private void y() {
        Logger.i(f3752f, "reset");
        this.f3754b.clear();
        this.f3754b.putShort(2114);
        this.f3754b.putShort(1);
        this.f3754b.putInt(0);
        this.f3754b.putInt(0);
    }

    private void z(int r2) {
        this.f3754b.putInt(8, r2);
    }

    public boolean B(String r5, long r6) {
        if (this.f3757e.get() == false) goto L6;
        return false;
    L6:
        if (this.f3756d.containsKey(r5) == false) goto L9;
        Logger.i(f3752f, "Drop existed messageId:" + r5);
        com.bytedance.common.wschannel.u.d.d().e(new b(this, r5));
        return true;
    L9:
        long r2 = System.currentTimeMillis() + r6;
        this.f3756d.put(r5, new C0108e(r2, -1));
        com.bytedance.common.wschannel.u.d.d().e(new c(this, r5, r2));
        return false;
    }

    public void i(String[] r7) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f3752f, "ack message id: " + Arrays.toString(r7));
    L6:
        if (this.f3757e.get() == true) goto L36;
        if (r7 != null) goto L9;
        return;
    L9:
        if (r7.length == 0) goto L38;
        ArrayList r0 = new ArrayList();
        int r1 = r7.length;
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L25;
        String r3 = r7[r2];
        if (TextUtils.isEmpty(r3) == true) goto L23;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L17:
        if (r3.getBytes("UTF-8").length != 32) goto L23;
        r0.add(r3);     // Catch: UnsupportedEncodingException -> L21
    L23:
        r2 = r2 + 1;
        goto L12
    L25:
        if (r0.isEmpty() == false) goto L27;
        return;
    L27:
        com.bytedance.common.wschannel.u.d.d().e(new d(this, r0));
        return;
    L38:
        return;
    }

    public void o() {
        com.bytedance.common.wschannel.server.d.m();
    }
}
