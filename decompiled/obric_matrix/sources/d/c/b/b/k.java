package d.c.b.b;

import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class k implements d.c.b.a.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f15358c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static k f15359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f15360e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.c.b.a.d f15361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f15362b;

    static {
        f15358c = new Object();
    }

    private k() {
    }

    @ReturnsOwnership
    public static k a() {
        Object r0 = f15358c;
        monitor-enter(r0);
        k r1 = f15359d;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        f15359d = r1.f15362b;     // Catch: Throwable -> L12
        r1.f15362b = null;     // Catch: Throwable -> L12
        f15360e--;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return new k();
    L12:
        th = move-exception;
        throw th;
    }

    private void c() {
    }

    public void b() {
        Object r0 = f15358c;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f15360e >= 5) goto L10;
        c();     // Catch: Throwable -> L12
        f15360e++;     // Catch: Throwable -> L12
        k r1 = f15359d;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        this.f15362b = r1;     // Catch: Throwable -> L12
    L9:
        f15359d = this;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public k d(d.c.b.a.d r1) {
        this.f15361a = r1;
        return this;
    }

    public k e(long r1) {
        return this;
    }

    public k f(long r1) {
        return this;
    }

    public k g(d.c.b.a.c.a r1) {
        return this;
    }

    public k h(IOException r1) {
        return this;
    }

    public k i(long r1) {
        return this;
    }

    public k j(String r1) {
        return this;
    }
}
