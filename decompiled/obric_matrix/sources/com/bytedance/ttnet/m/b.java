package com.bytedance.ttnet.m;

/* JADX INFO: loaded from: classes.dex */
public class b extends d.b.h.a.a.h.b<d> {
    public boolean d0;
    public int e0;

    class a implements d.b.h.a.a.h.b.InterfaceC0357b {
        a() {
        }

        @Override // d.b.h.a.a.h.b.InterfaceC0357b
        public d.b.h.a.a.h.b create() {
            return new b();
        }
    }

    public b() {
        this.d0 = false;
        this.e0 = -1;
    }

    public static void d() {
        d.b.h.a.a.h.b.c(new a());
    }
}
