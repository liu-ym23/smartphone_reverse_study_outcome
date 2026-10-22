package l.b.g.b.a;

import java.util.HashMap;
import java.util.Map;
import l.b.a.o;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f21993f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f21994g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f21995h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f21996i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Object, e> f21997j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final o f22002e;

    static class a extends HashMap<Object, e> {
        a() {
            e r0 = e.f21993f;
            put(Integer.valueOf(e.a(r0)), r0);
            e r1 = e.f21994g;
            put(Integer.valueOf(e.a(r1)), r1);
            e r2 = e.f21995h;
            put(Integer.valueOf(e.a(r2)), r2);
            e r3 = e.f21996i;
            put(Integer.valueOf(e.a(r3)), r3);
        }
    }

    static {
        o r9 = l.b.a.o2.a.f21649c;
        f21993f = new e(1, 32, 1, 265, 7, 8516, r9);
        f21994g = new e(2, 32, 2, 133, 6, 4292, r9);
        f21995h = new e(3, 32, 4, 67, 4, 2180, r9);
        f21996i = new e(4, 32, 8, 34, 0, 1124, r9);
        f21997j = new a();
    }

    protected e(int r1, int r2, int r3, int r4, int r5, int r6, o r7) {
        this.f21998a = r1;
        this.f21999b = r2;
        this.f22000c = r3;
        this.f22001d = r4;
        this.f22002e = r7;
    }

    static /* synthetic */ int a(e r0) {
        return r0.f21998a;
    }

    public static e e(int r1) {
        return f21997j.get(Integer.valueOf(r1));
    }

    public o b() {
        return this.f22002e;
    }

    public int c() {
        return this.f21999b;
    }

    public int d() {
        return this.f22001d;
    }

    public int f() {
        return this.f21998a;
    }

    public int g() {
        return this.f22000c;
    }
}
