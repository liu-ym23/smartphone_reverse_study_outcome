package kotlin.s0.w.d.l0.d.b;

import java.io.Serializable;
import kotlin.n0.d.g;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f19193h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final e f19194i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f19195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f19196g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public final e a() {
            return e.a();
        }
    }

    static {
        f19193h = new a(null);
        f19194i = new e(-1, -1);
    }

    public e(int r1, int r2) {
        this.f19195f = r1;
        this.f19196g = r2;
    }

    public static final /* synthetic */ e a() {
        return f19194i;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.f19195f == r6.f19195f) goto L12;
        return false;
    L12:
        if (this.f19196g == r6.f19196g) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f19195f * 31) + this.f19196g;
    }

    public String toString() {
        return "Position(line=" + this.f19195f + ", column=" + this.f19196g + ')';
    }
}
