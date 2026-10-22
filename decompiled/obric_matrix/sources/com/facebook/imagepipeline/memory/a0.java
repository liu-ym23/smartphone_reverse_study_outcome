package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes2.dex */
public class a0 implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a0 f6671a;

    static {
    }

    private a0() {
    }

    public static synchronized a0 h() {
        monitor-enter(a0.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f6671a != null) goto L7;
        f6671a = new a0();     // Catch: Throwable -> L10
    L7:
        a0 r1 = f6671a;     // Catch: Throwable -> L10
        monitor-exit(a0.class);
        return r1;
    }

    @Override // com.facebook.imagepipeline.memory.g0
    public void a(int r1) {
    }

    @Override // com.facebook.imagepipeline.memory.g0
    public void b(int r1) {
    }

    @Override // com.facebook.imagepipeline.memory.g0
    public void c(a r1) {
    }

    @Override // com.facebook.imagepipeline.memory.g0
    public void d() {
    }

    @Override // com.facebook.imagepipeline.memory.g0
    public void e(int r1) {
    }

    @Override // com.facebook.imagepipeline.memory.g0
    public void f() {
    }

    @Override // com.facebook.imagepipeline.memory.g0
    public void g(int r1) {
    }
}
