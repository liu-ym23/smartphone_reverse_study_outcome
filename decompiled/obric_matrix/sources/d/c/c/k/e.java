package d.c.c.k;

import com.facebook.infer.annotation.Functional;

/* JADX INFO: loaded from: classes.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f15442f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f15443g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f15444h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ e[] f15445i = null;

    static {
        e r0 = new e("YES", 0);
        f15442f = r0;
        e r1 = new e("NO", 1);
        f15443g = r1;
        e r3 = new e("UNSET", 2);
        f15444h = r3;
        f15445i = new e[]{r0, r1, r3};
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    @Functional
    public static e a(boolean r0) {
        if (r0 == false) goto L5;
        return f15442f;
    L5:
        return f15443g;
    }

    public static e valueOf(String r1) {
        return (e) Enum.valueOf(e.class, r1);
    }

    public static e[] values() {
        return (e[]) f15445i.clone();
    }
}
