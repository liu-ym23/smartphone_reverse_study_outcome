package com.bytedance.apm.battery.dao.c;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import com.bytedance.common.wschannel.WsConstants;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.apm.battery.dao.a<com.bytedance.apm.u.a> implements com.bytedance.apm.battery.dao.a.b<com.bytedance.apm.u.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile a f1308e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f1309f = "_id <= ? ";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f1310g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f1311h = "main_process = 1 AND delete_flag = 0";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f1312i = "main_process = 0 AND delete_flag = 0 AND timestamp <= ? ";

    static {
        f1310g = new String[]{"_id", "front", WsConstants.KEY_CONNECTION_TYPE, "timestamp", "accumulation", "version_id", "source", "status", "scene", "process", "main_process", WsConstants.KEY_SESSION_ID};
    }

    private a() {
    }

    public static a k() {
        if (f1308e != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1308e != null) goto L9;
        f1308e = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f1308e;
    }

    @Override // com.bytedance.apm.battery.dao.a.b
    @NonNull
    public /* bridge */ /* synthetic */ com.bytedance.apm.u.a a(com.bytedance.apm.battery.dao.a.c r1) {
        return j(r1);
    }

    @Override // com.bytedance.apm.battery.dao.a
    public String[] b() {
        return f1310g;
    }

    @Override // com.bytedance.apm.battery.dao.a
    public String d() {
        return "t_battery";
    }

    @NonNull
    public com.bytedance.apm.u.a j(com.bytedance.apm.battery.dao.a.c r22) {
        long r1 = r22.c("_id");
        long r3 = r22.c("front");
        String r10 = r22.d(WsConstants.KEY_CONNECTION_TYPE);
        long r8 = r22.c("timestamp");
        long r12 = r22.c("accumulation");
        long r14 = r22.c("version_id");
        String r5 = r22.d("source");
        long r6 = r22.c("status");
        String r16 = r22.d("scene");
        int r11 = r22.b("main_process");
        String r13 = r22.d("process");
        if (r3 == 0) goto L5;
        boolean r4 = true;
    L7:
        if (r6 == 0) goto L9;
        boolean r17 = true;
    L10:
        com.bytedance.apm.u.a r0 = new com.bytedance.apm.u.a(r4, r8, r10, r17, r12, r16, r5);
        r0.q(r13);
        r0.o(r1);
        r0.u(r14);
        if (r11 != 1) goto L13;
        boolean r7 = true;
    L14:
        r0.p(r7);
        r0.s(r22.d(WsConstants.KEY_SESSION_ID));
        return r0;
    L13:
        r7 = false;
        goto L14
    L9:
        r17 = false;
        goto L10
    L5:
        r4 = false;
        goto L7
    }

    public synchronized List<com.bytedance.apm.u.a> l(boolean r3, long r4) {
        monitor-enter(this);
        if (r3 == false) goto L5;
        List<com.bytedance.apm.u.a> r5 = g(f1311h, null, "_id", this);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r5;
    L5:
        r5 = g(f1312i, new String[]{String.valueOf(r4)}, "_id", this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized long m(com.bytedance.apm.u.a r10) {
        monitor-enter(this);
        if (r10 != null) goto L27;
        monitor-exit(this);
        return -1;
    L27:
        ContentValues r2 = new ContentValues();     // Catch: Throwable -> L22 Exception -> L25
        int r5 = 1;
        if (r10.k() == false) goto L10;
        int r4 = 1;
    L11:
        r2.put("front", Integer.valueOf(r4));     // Catch: Throwable -> L22 Exception -> L25
        r2.put("source", r10.e());     // Catch: Throwable -> L22 Exception -> L25
        r2.put(WsConstants.KEY_CONNECTION_TYPE, r10.h());     // Catch: Throwable -> L22 Exception -> L25
        r2.put("timestamp", Long.valueOf(r10.g()));     // Catch: Throwable -> L22 Exception -> L25
        r2.put("accumulation", Long.valueOf(r10.a()));     // Catch: Throwable -> L22 Exception -> L25
        r2.put("version_id", Long.valueOf(r10.i()));     // Catch: Throwable -> L22 Exception -> L25
        if (r10.n() == false) goto L14;
        int r6 = 1;
    L15:
        r2.put("status", Integer.valueOf(r6));     // Catch: Throwable -> L22 Exception -> L25
        r2.put("scene", r10.d());     // Catch: Throwable -> L22 Exception -> L25
        if (r10.l() == true) goto L19;
        r5 = 0;
    L19:
        r2.put("main_process", Integer.valueOf(r5));     // Catch: Throwable -> L22 Exception -> L25
        r2.put("process", r10.c());     // Catch: Throwable -> L22 Exception -> L25
        r2.put(WsConstants.KEY_SESSION_ID, r10.f());     // Catch: Throwable -> L22 Exception -> L25
        long r0 = f(r2);     // Catch: Throwable -> L22 Exception -> L25
        monitor-exit(this);
        return r0;
        goto L26
    L14:
        r6 = 0;
        goto L15
    L10:
        r4 = 0;
    L22:
        th = move-exception;
        throw th;
    L26:
        return -1;
    }

    public synchronized void n(long r5) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put("delete_flag", 1);     // Catch: Throwable -> L6
        i(r0, f1309f, new String[]{String.valueOf(r5)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
