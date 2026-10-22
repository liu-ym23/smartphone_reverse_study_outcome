package com.bytedance.memory.heap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.core.e;
import com.bytedance.apm.d;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.memory.b.c;
import com.bytedance.memory.b.h;
import com.bytedance.memory.g.j;
import com.bytedance.services.apm.api.EnsureManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile a f5062f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f5064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile HeapDump f5065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile SharedPreferences f5066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5067e;

    /* JADX INFO: renamed from: com.bytedance.memory.heap.a$a, reason: collision with other inner class name */
    class RunnableC0159a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f5068f;

        RunnableC0159a(a r1) {
            this.f5068f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.memory.c.b.d().k() == false) goto L20;
            String r2 = a.o().s();
            if (com.bytedance.memory.c.b.d().f().length() > 31457280) goto L7;
        L18:
            c.c("HeapSaver shrink return deleteCache", new Object[0]);
            a.o().i();
            return;
        L7:
            if (TextUtils.isEmpty(r2) == true) goto L18;
            a.a(this.f5068f, true);
            Process.setThreadPriority(10);
            String r3 = d.k().optString(WsConstants.KEY_DEVICE_ID);
            if (a.o().k() == null) goto L12;
            long r0 = a.o().k().currentTime;
        L13:
            long r4 = r0;
            File r6 = com.bytedance.memory.c.b.d().f();
            String r7 = r6.getName().substring(0, r6.getName().lastIndexOf("."));
            boolean r1 = com.bytedance.memory.d.a.c("memory_upload_origin");
            a r5 = this.f5068f;
            if (r1 == false) goto L16;
            a.b(r5, r2, r3, r4, r6, r7);
        L17:
            com.bytedance.memory.c.b.d().b();
            a.a(this.f5068f, false);
            Process.setThreadPriority(0);
            com.bytedance.memory.h.a.d();
            return;
        L16:
            a.c(r5, r2, r3, r4, r6);
            goto L17
        L12:
            r0 = System.currentTimeMillis();
            goto L13
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f5069f;

        b(a r1) {
            this.f5069f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.d(this.f5069f, null);
            com.bytedance.memory.b.d.a(com.bytedance.memory.c.b.d().i());
            a.e(this.f5069f);
            a.o().C("");
            a.o().E("");
            a.o().B(0);
        }
    }

    private a(@NonNull Context r2) {
        this.f5066d = null;
        this.f5063a = r2.getApplicationContext();
    }

    private void A(String r2) {
        r().edit().putString("filePath", r2).commit();
    }

    private void G(@NonNull HeapDump r3, JSONObject r4) {
        r4.put("heapDumpFilePath", r3.heapDumpFile.getPath());
        r4.put("shrinkFilePath", r3.shrinkFilePath);
        r4.put("heapDumpFileSize", r3.heapDumpFile.length());
        r4.put("referenceName", r3.referenceName);
        r4.put("isDebug", r3.isDebug);
        r4.put("gcDurationMs", r3.gcDurationMs);
        r4.put("watchDurationMs", r3.watchDurationMs);
        r4.put("dumpDurationMs", r3.heapDumpDurationMs);
        r4.put("currentTime", r3.currentTime);
    }

    @NonNull
    private HeapDump H(JSONObject r3, File r4) {
        HeapDump.b r2 = HeapDump.newBuilder();
        r2.g(r4);
        r2.c(r3.optLong("currentTime"));
        r2.h(r3.optLong("heapDumpFileSize"));
        r2.k(r3.optString("referenceName"));
        r2.i(r3.optBoolean("isDebug"));
        r2.e(r3.optLong("gcDurationMs"));
        r2.m(r3.optLong("watchDurationMs"));
        r2.f(r3.optLong("dumpDurationMs"));
        r2.l(r3.optString("shrinkFilePath"));
        return r2.a();
    }

    static /* synthetic */ boolean a(a r0, boolean r1) {
        r0.f5064b = r1;
        return r1;
    }

    static /* synthetic */ void b(a r0, String r1, String r2, long r3, File r5, String r6) {
        r0.g(r1, r2, r3, r5, r6);
    }

    static /* synthetic */ void c(a r0, String r1, String r2, long r3, File r5) {
        r0.h(r1, r2, r3, r5);
    }

    static /* synthetic */ HeapDump d(a r0, HeapDump r1) {
        r0.f5065c = r1;
        return r1;
    }

    static /* synthetic */ void e(a r0) {
        r0.j();
    }

    private void g(String r5, String r6, long r7, File r9, String r10) {
        File r4 = new File(com.bytedance.memory.c.b.d().i(), "dump.hprof");
        if (r9.getPath().contains("jpg") == false) goto L5;
        r9.renameTo(r4);
    L5:
        File r11 = new File(com.bytedance.memory.c.b.d().c(), r10.replace("dump", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(r7))) + "_" + r6 + "_" + r5 + "_origin.zip");
        com.bytedance.memory.d.a.d("origin_compress_begin");
        long r8 = System.currentTimeMillis();
        h.c(r4, r11);
        c.c("compress origin file succeed", new Object[0]);
        com.bytedance.memory.d.a.f("origin_compress_time", System.currentTimeMillis() - r8);
        com.bytedance.memory.d.a.d("origin_compress_end");
        com.bytedance.memory.d.a.f("origin_compress_size", r11.length() / 1024);
        if (r4.exists() == false) goto L8;
        r4.delete();
    L8:
        o().B(1);
        o().D(true);
        o().C(r11.getAbsolutePath());
    }

    private void h(String r8, String r9, long r10, File r12) {
        c.c("shrink begin with path %s, length %s ", new Object[]{r12.getPath(), Long.valueOf(r12.length())});
        File r7 = x(r12);
        if (r7 != null) goto L5;
    L14:
        c.c("shrink failed deleteCache", new Object[0]);
        o().i();
        return;
    L5:
        if (r7.length() < 31457280) goto L7;
    L9:
        c.c("shrink succeed", new Object[0]);
        com.bytedance.memory.d.a.d("shrink_compress_begin");
        long r0 = System.currentTimeMillis();
        File r11 = h.b(r7, true);
        com.bytedance.memory.d.a.f("shrink_compress_time", System.currentTimeMillis() - r0);
        com.bytedance.memory.d.a.d("shrink_compress_end");
        com.bytedance.memory.d.a.f("shrink_compress_size", r11.length() / 1024);
        File r13 = new File(r11.getParent(), new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(r10)) + "_" + r9 + "_" + r8 + "_shrink.zip");
        if (r11.exists() == false) goto L12;
        r11.renameTo(r13);
    L12:
        o().D(true);
        o().C(r13.getAbsolutePath());
        return;
    L7:
        if (o().n() != 2) goto L9;
        goto L9
    }

    private void j() {
        A("");
    }

    private String m() {
        return r().getString("filePath", "");
    }

    public static a o() {
        if (f5062f != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5062f != null) goto L9;
        f5062f = new a(com.bytedance.memory.a.a.l().j());     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f5062f;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x006c: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x006c */
    @Nullable
    private HeapDump w(@NonNull String r6) {
        File r0 = new File(r6);
        FileInputStream r1 = null;
        if (r0.exists() == true) goto L6;
        j();
        return null;
    L6:
        StringBuilder r7 = new StringBuilder();
        FileInputStream r2 = new FileInputStream(r0);     // Catch: Throwable -> L16 Exception -> L18
    L42:
        int r3 = r2.read();     // Catch: Exception -> L14 Throwable -> L27
        if (r3 == (-1)) goto L11;
        r7.append((char) r3);     // Catch: Exception -> L14 Throwable -> L27
        goto L42
    L11:
        JSONObject r4 = new JSONObject(r7.toString());     // Catch: Exception -> L14 Throwable -> L27
        HeapDump r8 = H(r4, new File(r4.optString("heapDumpFilePath")));     // Catch: Exception -> L14 Throwable -> L27
        this.f5065c = r8;     // Catch: Exception -> L14 Throwable -> L27
        r2.close();     // Catch: IOException -> L32
    L13:
        return r8;
    L14:
        e = e;
    L21:
        if (r0.delete() == false) goto L23;
        c.b(e, "Could not read result file %s, deleted it.", new Object[]{r0});     // Catch: Throwable -> L27
    L24:
        if (r2 != null) goto L35;
    L26:
        return null;
    L35:
        r2.close();     // Catch: IOException -> L33
        goto L26
    L23:
        c.b(e, "Could not read result file %s, could not delete it either.", new Object[]{r0});     // Catch: Throwable -> L27
        goto L24
    L27:
        th = th;
        r1 = r2;
    L29:
        if (r1 != null) goto L39;
    L31:
        throw th;
    L39:
        r1.close();     // Catch: IOException -> L34
    L18:
        e = e;
        r2 = null;
    L16:
        th = th;
        goto L29
    }

    @Nullable
    @SuppressLint({"SimpleDateFormat"})
    @WorkerThread
    private File x(@NonNull File r4) {
    L7:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "realShrink failed");
        th.printStackTrace();
        return null;
    L4:
        if (r4.exists() == false) goto L12;
        return j.a(r4, new File(com.bytedance.memory.c.b.d().h(), "dump.hprof"));
    L12:
        return null;
    }

    private void z(HeapDump r1) {
        this.f5065c = r1;
    }

    @SuppressLint({"ApplySharedPref"})
    public void B(int r2) {
        r().edit().putInt("hprof_type", r2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void C(String r2) {
        r().edit().putString("latestFilePath", r2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void D(boolean r2) {
        r().edit().putBoolean("hasShrink", r2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public void E(String r2) {
        r().edit().putString("updateVersionCode", r2).commit();
    }

    @SuppressLint({"SimpleDateFormat"})
    @WorkerThread
    public void F() {
        if (this.f5064b == false) goto L6;
        return;
    L6:
        if (o().t() == false) goto L9;
        c.c("HeapSaver shrink hasShrinked", new Object[0]);
        com.bytedance.memory.h.a.d();
        return;
    L9:
        com.bytedance.memory.b.b.f4995a.a(new RunnableC0159a(this), "HeapSaver-shrink");
    }

    public void I(long r2) {
        this.f5067e = true;
        r().edit().putLong("lastDumpTime", r2).commit();
    }

    @WorkerThread
    public void f() {
        if (this.f5065c == null) goto L5;
        return;
    L5:
        String r0 = m();
        if (TextUtils.isEmpty(r0) == true) goto L9;
        HeapDump r1 = w(r0);
        c.c("cache heapdump %s", new Object[]{r1});
        z(r1);
        return;
    }

    public void i() {
        com.bytedance.memory.b.b.f4995a.a(new b(this), "HeapSaver-deleteCache");
    }

    @Nullable
    public HeapDump k() {
        return this.f5065c;
    }

    public long l() {
        if (o().k() == null) goto L6;
        return o().k().currentTime;
    L6:
        return System.currentTimeMillis();
    }

    public int n() {
        return r().getInt("hprof_type", 1);
    }

    public long p() {
        return r().getLong("lastDumpTime", 0);
    }

    public String q() {
        return r().getString("latestFilePath", "");
    }

    @NonNull
    public SharedPreferences r() {
        if (this.f5066d != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f5066d != null) goto L8;
        this.f5066d = e.h(this.f5063a, "MemoryWidgetSp" + d.i());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f5066d;
    }

    public String s() {
        return r().getString("updateVersionCode", "");
    }

    public boolean t() {
        return r().getBoolean("hasShrink", false);
    }

    public boolean u() {
        return this.f5067e;
    }

    public boolean v() {
        long r0 = r().getLong("lastDumpTime", 0);
        if ((System.currentTimeMillis() - r0) >= LocationInfoConst.defaultsOverseasCacheValidity) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public File y(@NonNull HeapDump r5) {
        z(r5);
        File r0 = com.bytedance.memory.c.b.d().g();
        if (r0.exists() == false) goto L5;
        r0.delete();
    L5:
        c.c("analyzedHeapFile.getHeapDumpFilePath() %s", new Object[]{r0.getPath()});
        A(r0.getPath());
        JSONObject r1 = new JSONObject();
        FileOutputStream r2 = null;
        G(r5, r1);     // Catch: Throwable -> L12 Exception -> L14
        FileOutputStream r4 = new FileOutputStream(r0);     // Catch: Throwable -> L12 Exception -> L14
        r4.write(r1.toString().getBytes());     // Catch: Exception -> L10 Throwable -> L20
        r4.close();     // Catch: IOException -> L25
    L9:
        return r0;
    L10:
        e = e;
    L16:
        c.b(e, "Could not save leak analysis result to disk.", new Object[0]);     // Catch: Throwable -> L20
        if (r4 != null) goto L28;
    L19:
        return null;
    L28:
        r4.close();     // Catch: IOException -> L26
    L20:
        th = th;
        r2 = r4;
    L22:
        if (r2 != null) goto L32;
    L24:
        throw th;
    L32:
        r2.close();     // Catch: IOException -> L27
        goto L24
    L14:
        e = e;
        r4 = null;
    L12:
        th = th;
        goto L22
    }
}
