package com.bytedance.lighten.loader;

import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class p implements d.c.c.g.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<d.c.c.g.c> f4973a;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static p f4974a;

        static {
            f4974a = new p(null);
        }

        static /* synthetic */ p a() {
            return f4974a;
        }
    }

    private p() {
        this.f4973a = new CopyOnWriteArraySet();
    }

    /* synthetic */ p(a r1) {
        this();
    }

    public static p b() {
        return b.a();
    }

    @Override // d.c.c.g.d
    public void a(d.c.c.g.c r1) {
        if (r1 == null) goto L5;
        this.f4973a.add(r1);
        return;
    }

    public void c(d.c.c.g.b r3) {
        Log.d("Lighten:", "trimMemory: trimType=" + r3 + ", memoryTrimmableSet.size=" + this.f4973a.size());
        Iterator<d.c.c.g.c> r2 = this.f4973a.iterator();     // Catch: Exception -> L8
    L5:
        if (r2.hasNext() == false) goto L15;
        r2.next().a(r3);     // Catch: Exception -> L8
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
