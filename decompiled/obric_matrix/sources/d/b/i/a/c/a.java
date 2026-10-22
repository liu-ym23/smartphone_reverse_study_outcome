package d.b.i.a.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f13908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected b f13909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected d f13910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f13912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f13913f;

    /* JADX INFO: renamed from: d.b.i.a.c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0369a implements b {
        public AbstractC0369a() {
        }

        @Override // d.b.i.a.c.a.b
        public long e() {
            return 604800000;
        }
    }

    public interface b {
        String a();

        String b();

        List<String> c();

        int d();

        long e();

        long f();
    }

    public interface c {
        boolean a();

        long b();

        boolean c();
    }

    public a(Context r1, b r2, c r3) {
        this.f13909b = r2;
        this.f13912e = r3;
        if (r2 == null) goto L14;
        if (r3 == null) goto L12;
        String r4 = r2.a();
        this.f13908a = r4;
        if (TextUtils.isEmpty(r4) == true) goto L10;
        d r5 = d.c(r1);
        this.f13910c = r5;
        r5.h(this.f13908a, this);
        return;
    L10:
        throw new IllegalArgumentException("type is empty.");
    L12:
        throw new IllegalArgumentException("responseConfig is null");
    L14:
        throw new IllegalArgumentException("config is null.");
    }

    public boolean a(String r1) {
        return b(d.b.i.a.c.c.c(r1));
    }

    public boolean b(byte[] r2) {
        return this.f13910c.a(this.f13908a, r2);
    }

    b c() {
        return this.f13909b;
    }

    public long d() {
        return this.f13913f;
    }

    String e() {
        return this.f13911d;
    }

    c f() {
        return this.f13912e;
    }

    protected void g(byte[] r1, boolean r2) {
    }

    protected abstract boolean h(String r1, byte[] r2);

    public void i(long r1) {
        this.f13913f = r1;
    }

    public void j(String r1) {
        this.f13911d = r1;
    }
}
