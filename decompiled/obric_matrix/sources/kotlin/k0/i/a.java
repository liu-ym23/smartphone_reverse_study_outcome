package kotlin.k0.i;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0081\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/coroutines/intrinsics/CoroutineSingletons;", "", "(Ljava/lang/String;I)V", "COROUTINE_SUSPENDED", "UNDECIDED", "RESUMED", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f18400f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f18401g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f18402h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ a[] f18403i = null;

    static {
        f18400f = new a("COROUTINE_SUSPENDED", 0);
        f18401g = new a("UNDECIDED", 1);
        f18402h = new a("RESUMED", 2);
        f18403i = a();
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ a[] a() {
        return new a[]{f18400f, f18401g, f18402h};
    }

    public static a valueOf(String r1) {
        return (a) Enum.valueOf(a.class, r1);
    }

    public static a[] values() {
        return (a[]) f18403i.clone();
    }
}
