package com.bytedance.applog.o;

/* JADX INFO: loaded from: classes.dex */
public class f extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f2281h;

    public f(e r1, String r2) {
        super(r1);
        this.f2281h = r2;
    }

    @Override // com.bytedance.applog.o.c
    protected boolean c(int r1) {
        com.bytedance.applog.v.a.l(null, this.f2281h);
        return true;
    }

    @Override // com.bytedance.applog.o.c
    protected String e() {
        return "RangersEventVerify";
    }

    @Override // com.bytedance.applog.o.c
    protected long[] f() {
        return new long[]{1000};
    }

    @Override // com.bytedance.applog.o.c
    protected boolean h() {
        return true;
    }

    @Override // com.bytedance.applog.o.c
    protected long i() {
        return 1000;
    }
}
