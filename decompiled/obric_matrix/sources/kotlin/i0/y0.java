package kotlin.i0;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/collections/State;", "", "(Ljava/lang/String;I)V", "Ready", "NotReady", "Done", "Failed", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final enum y0 extends Enum<y0> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y0 f18361f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final y0 f18362g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y0 f18363h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final y0 f18364i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ y0[] f18365j = null;

    static {
        f18361f = new y0("Ready", 0);
        f18362g = new y0("NotReady", 1);
        f18363h = new y0("Done", 2);
        f18364i = new y0("Failed", 3);
        f18365j = a();
    }

    private y0(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ y0[] a() {
        return new y0[]{f18361f, f18362g, f18363h, f18364i};
    }

    public static y0 valueOf(String r1) {
        return (y0) Enum.valueOf(y0.class, r1);
    }

    public static y0[] values() {
        return (y0[]) f18365j.clone();
    }
}
