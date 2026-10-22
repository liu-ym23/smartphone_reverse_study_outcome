package h.a.d3;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/channels/BufferOverflow;", "", "(Ljava/lang/String;I)V", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f17221f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f17222g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f17223h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ e[] f17224i = null;

    static {
        f17221f = new e("SUSPEND", 0);
        f17222g = new e("DROP_OLDEST", 1);
        f17223h = new e("DROP_LATEST", 2);
        f17224i = a();
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ e[] a() {
        return new e[]{f17221f, f17222g, f17223h};
    }

    public static e valueOf(String r1) {
        return (e) Enum.valueOf(e.class, r1);
    }

    public static e[] values() {
        return (e[]) f17224i.clone();
    }
}
