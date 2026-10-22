package com.bytedance.applog.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.applog.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile f f2421b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<com.bytedance.applog.f> f2422a;

    private f() {
        this.f2422a = new CopyOnWriteArraySet();
    }

    public static f b() {
        if (f2421b != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2421b != null) goto L9;
        f2421b = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f2421b;
    }

    @Override // com.bytedance.applog.f
    public void a(@NonNull String r12, @NonNull String r13, String r14, long r15, long r17, String r19) {
        Iterator<com.bytedance.applog.f> r0 = this.f2422a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r12, r13, r14, r15, r17, r19);
        goto L4
    }

    @Override // com.bytedance.applog.f
    public void onEventV3(@NonNull String r2, @Nullable JSONObject r3) {
        Iterator<com.bytedance.applog.f> r1 = this.f2422a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onEventV3(r2, r3);
        goto L4
    }
}
