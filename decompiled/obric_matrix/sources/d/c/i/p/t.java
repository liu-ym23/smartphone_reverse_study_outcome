package d.c.i.p;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k<d.c.i.l.e> f16426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l0 f16427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f16428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.c.i.f.a f16430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, String> f16432g;

    public t(k<d.c.i.l.e> r2, l0 r3) {
        this.f16431f = true;
        this.f16426a = r2;
        this.f16427b = r3;
        this.f16428c = 0;
    }

    public List<Uri> a() {
        return this.f16427b.c().b();
    }

    public k<d.c.i.l.e> b() {
        return this.f16426a;
    }

    public l0 c() {
        return this.f16427b;
    }

    public Map<String, String> d() {
        return this.f16432g;
    }

    public String e() {
        return this.f16427b.getId();
    }

    public long f() {
        return this.f16428c;
    }

    public n0 g() {
        return this.f16427b.f();
    }

    public int h() {
        return this.f16429d;
    }

    public d.c.i.f.a i() {
        return this.f16430e;
    }

    public Uri j() {
        return this.f16427b.c().v();
    }

    public boolean k() {
        return this.f16431f;
    }

    public void l(Map<String, String> r1) {
        this.f16432g = r1;
    }

    public void m(long r1) {
        this.f16428c = r1;
    }

    public void n(String r1) {
    }
}
