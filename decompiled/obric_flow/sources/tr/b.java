package tr;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f22163c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22165b;

    static {
        Intrinsics.checkNotNullParameter("#", "letter");
        f22163c = new b(0, "#");
    }

    public b(int r5, String r10) {
        this.f22164a = r5;
        this.f22165b = r10;
        if (r5 == 2) goto L6;
        return;
    L6:
        throw new IllegalStateException("symbol must have 3 bitmaps!");
    }
}
