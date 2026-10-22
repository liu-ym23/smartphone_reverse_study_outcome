package com.bytedance.feedbackerlib.model.e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f4615b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f4616a;

    public b() {
        this.f4616a = new CopyOnWriteArrayList();
    }

    public static b d() {
        if (f4615b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4615b != null) goto L9;
        f4615b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f4615b;
    }

    public void a(String r1) {
        this.f4616a.add(r1);
    }

    public void b() {
        this.f4616a.clear();
    }

    public List<String> c() {
        return this.f4616a;
    }
}
