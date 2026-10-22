package h.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u0016H\u0000\u001a\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u0016H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0010\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003\"\u0016\u0010\u0012\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0003\"\u000e\u0010\u0014\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "getCOMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "getCOMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "getCOMPLETING_WAITING_CHILDREN$annotations", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "getEMPTY_ACTIVE$annotations", "EMPTY_NEW", "getEMPTY_NEW$annotations", "FALSE", "", "RETRY", "SEALED", "getSEALED$annotations", "TOO_LATE_TO_CANCEL", "getTOO_LATE_TO_CANCEL$annotations", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h.a.f3.f0 f17439a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h.a.f3.f0 f17440b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final h.a.f3.f0 f17441c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final h.a.f3.f0 f17442d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final h.a.f3.f0 f17443e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final g1 f17444f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final g1 f17445g = null;

    static {
        f17439a = new h.a.f3.f0("COMPLETING_ALREADY");
        f17440b = new h.a.f3.f0("COMPLETING_WAITING_CHILDREN");
        f17441c = new h.a.f3.f0("COMPLETING_RETRY");
        f17442d = new h.a.f3.f0("TOO_LATE_TO_CANCEL");
        f17443e = new h.a.f3.f0("SEALED");
        f17444f = new g1(false);
        f17445g = new g1(true);
    }

    public static final /* synthetic */ h.a.f3.f0 a() {
        return f17439a;
    }

    public static final /* synthetic */ h.a.f3.f0 b() {
        return f17441c;
    }

    public static final /* synthetic */ g1 c() {
        return f17445g;
    }

    public static final /* synthetic */ g1 d() {
        return f17444f;
    }

    public static final /* synthetic */ h.a.f3.f0 e() {
        return f17443e;
    }

    public static final /* synthetic */ h.a.f3.f0 f() {
        return f17442d;
    }

    public static final Object g(Object r1) {
        if ((r1 instanceof s1) == true) goto L5;
        return r1;
    L5:
        return new t1((s1) r1);
    }

    public static final Object h(Object r1) {
        if ((r1 instanceof t1) == false) goto L5;
        t1 r0 = (t1) r1;
    L6:
        if (r0 == null) goto L13;
        s1 r2 = r0.f17568a;
        if (r2 != null) goto L12;
        return r1;
    L12:
        return r2;
    L13:
        return r1;
    L5:
        r0 = null;
        goto L6
    }
}
