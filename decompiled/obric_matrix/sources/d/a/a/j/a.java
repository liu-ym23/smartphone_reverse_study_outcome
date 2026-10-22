package d.a.a.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<m> f12463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<Character> f12464b = null;

    static {
        f12463a = new ThreadLocal();
        f12464b = new ThreadLocal();
    }

    public a() {
    }

    final char d(m r2, Object r3, char r4) {
        ThreadLocal<m> r0 = f12463a;
        r0.set(r2);
        ThreadLocal<Character> r5 = f12464b;
        r5.set(Character.valueOf(r4));
        e(r3);
        r0.set(null);
        return r5.get().charValue();
    }

    public abstract void e(Object r1);
}
