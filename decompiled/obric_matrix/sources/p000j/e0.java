package p000j;

import java.nio.charset.Charset;
import java.util.Objects;
import k.f;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e0 {

    static class a extends e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f17723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f17724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ byte[] f17725c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17726d;

        a(y r1, int r2, byte[] r3, int r4) {
            this.f17723a = r1;
            this.f17724b = r2;
            this.f17725c = r3;
            this.f17726d = r4;
        }

        @Override // p000j.e0
        public long a() {
            return this.f17724b;
        }

        @Override // p000j.e0
        public y b() {
            return this.f17723a;
        }

        @Override // p000j.e0
        public void f(f r3) {
            r3.I(this.f17725c, this.f17726d, this.f17724b);
        }
    }

    public e0() {
    }

    public static e0 c(y r2, String r3) {
        Charset r0 = c.f17800i;
        if (r2 == null) goto L9;
        Charset r1 = r2.a();
        if (r1 != null) goto L7;
        r2 = y.d(r2 + "; charset=utf-8");
        goto L9
    L7:
        r0 = r1;
    L9:
        return d(r2, r3.getBytes(r0));
    }

    public static e0 d(y r2, byte[] r3) {
        return e(r2, r3, 0, r3.length);
    }

    public static e0 e(y r7, byte[] r8, int r9, int r10) {
        Objects.requireNonNull(r8, "content == null");
        c.f(r8.length, r9, r10);
        return new a(r7, r10, r8, r9);
    }

    public long a() {
        return -1;
    }

    public abstract y b();

    public abstract void f(f r1);
}
