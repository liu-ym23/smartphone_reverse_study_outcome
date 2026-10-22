package l.b.g.b.a;

import java.util.HashMap;
import java.util.Map;
import l.b.a.o;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f22022e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f22023f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f22024g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f22025h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k f22026i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Map<Object, k> f22027j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final o f22031d;

    static class a extends HashMap<Object, k> {
        a() {
            k r0 = k.f22022e;
            put(Integer.valueOf(k.a(r0)), r0);
            k r1 = k.f22023f;
            put(Integer.valueOf(k.a(r1)), r1);
            k r2 = k.f22024g;
            put(Integer.valueOf(k.a(r2)), r2);
            k r3 = k.f22025h;
            put(Integer.valueOf(k.a(r3)), r3);
            k r4 = k.f22026i;
            put(Integer.valueOf(k.a(r4)), r4);
        }
    }

    static {
        o r1 = l.b.a.o2.a.f21649c;
        f22022e = new k(5, 32, 5, r1);
        f22023f = new k(6, 32, 10, r1);
        f22024g = new k(7, 32, 15, r1);
        f22025h = new k(8, 32, 20, r1);
        f22026i = new k(9, 32, 25, r1);
        f22027j = new a();
    }

    protected k(int r1, int r2, int r3, o r4) {
        this.f22028a = r1;
        this.f22029b = r2;
        this.f22030c = r3;
        this.f22031d = r4;
    }

    static /* synthetic */ int a(k r0) {
        return r0.f22028a;
    }

    static k e(int r1) {
        return f22027j.get(Integer.valueOf(r1));
    }

    public o b() {
        return this.f22031d;
    }

    public int c() {
        return this.f22030c;
    }

    public int d() {
        return this.f22029b;
    }

    public int f() {
        return this.f22028a;
    }
}
