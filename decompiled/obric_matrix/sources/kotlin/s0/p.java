package kotlin.s0;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/KVariance;", "", "(Ljava/lang/String;I)V", "INVARIANT", "IN", "OUT", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum p extends Enum<p> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p f18479f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final p f18480g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final p f18481h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ p[] f18482i = null;

    static {
        f18479f = new p("INVARIANT", 0);
        f18480g = new p("IN", 1);
        f18481h = new p("OUT", 2);
        f18482i = a();
    }

    private p(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ p[] a() {
        return new p[]{f18479f, f18480g, f18481h};
    }

    public static p valueOf(String r1) {
        return (p) Enum.valueOf(p.class, r1);
    }

    public static p[] values() {
        return (p[]) f18482i.clone();
    }
}
