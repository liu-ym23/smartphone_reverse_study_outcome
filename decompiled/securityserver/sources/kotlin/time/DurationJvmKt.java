package kotlin.time;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DurationJvmKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f358a = 0;

    static {
        ThreadLocal[] r1 = new ThreadLocal[4];
        int r2 = 0;
    L3:
        if (r2 >= 4) goto L5;
        r1[r2] = new ThreadLocal();
        r2 = r2 + 1;
        goto L3
    }
}
