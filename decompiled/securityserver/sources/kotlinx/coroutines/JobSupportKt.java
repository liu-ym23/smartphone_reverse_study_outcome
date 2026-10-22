package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class JobSupportKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Symbol f377a = null;
    public static final Symbol b = null;
    public static final Symbol c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Symbol f378d = null;
    public static final Symbol e = null;
    public static final Empty f = null;
    public static final Empty g = null;

    static {
        f377a = new Symbol("COMPLETING_ALREADY");
        b = new Symbol("COMPLETING_WAITING_CHILDREN");
        c = new Symbol("COMPLETING_RETRY");
        f378d = new Symbol("TOO_LATE_TO_CANCEL");
        e = new Symbol("SEALED");
        f = new Empty(false);
        g = new Empty(true);
    }

    public static final Object a(Object r1) {
        if ((r1 instanceof IncompleteStateBox) == true) goto L5;
        Object r0 = null;
    L6:
        IncompleteStateBox r2 = (IncompleteStateBox) r0;
        if (r2 == null) goto L12;
        Incomplete r3 = r2.f374a;
        if (r3 != null) goto L11;
        return r1;
    L11:
        return r3;
    L12:
        return r1;
    L5:
        r0 = r1;
        goto L6
    }
}
