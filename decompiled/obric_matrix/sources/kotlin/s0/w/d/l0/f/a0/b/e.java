package kotlin.s0.w.d.l0.f.a0.b;

import java.util.Arrays;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends kotlin.s0.w.d.l0.f.z.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f19882g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f19883f;

    static {
        f19882g = new e(new int[]{1, 7, 1});
        new e(new int[0]);
    }

    public e(int... r2) {
        o.f(r2, "numbers");
        this(r2, false);
    }

    public e(int[] r2, boolean r3) {
        o.f(r2, "versionArray");
        super(Arrays.copyOf(r2, r2.length));
        this.f19883f = r3;
    }

    public boolean h() {
        if (a() != 1) goto L7;
        if (b() != 0) goto L7;
        return false;
    L7:
        if (this.f19883f == false) goto L9;
        boolean r5 = f(f19882g);
    L15:
        if (r5 == true) goto L17;
        return false;
    L17:
        return true;
    L9:
        int r0 = a();
        e r3 = f19882g;
        if (r0 == r3.a()) goto L12;
    L14:
        r5 = false;
        goto L15
    L12:
        if (b() > (r3.b() + 1)) goto L14;
        r5 = true;
        goto L15
    }
}
