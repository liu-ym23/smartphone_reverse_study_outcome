package com.bytedance.memory.b;

import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC0154b f4995a = null;

    static class a implements InterfaceC0154b {
        a() {
        }

        @Override // com.bytedance.memory.b.b.InterfaceC0154b
        public void a(Runnable r1, String r2) {
            d.b.l.a.h.e r0 = d.b.l.a.h.c.d(r2, r1);
            d.b.l.a.h.c.a().c(r0);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.memory.b.b$b, reason: collision with other inner class name */
    public interface InterfaceC0154b {
        void a(Runnable r1, String r2);
    }

    static {
        Executors.newScheduledThreadPool(1, new f("CheckToDump"));
        f4995a = new a();
    }
}
