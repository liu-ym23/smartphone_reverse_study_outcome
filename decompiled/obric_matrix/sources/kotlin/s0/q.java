package kotlin.s0;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/KVisibility;", "", "(Ljava/lang/String;I)V", "PUBLIC", "PROTECTED", "INTERNAL", "PRIVATE", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum q extends Enum<q> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q f18483f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q f18484g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q f18485h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final q f18486i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ q[] f18487j = null;

    static {
        f18483f = new q("PUBLIC", 0);
        f18484g = new q("PROTECTED", 1);
        f18485h = new q("INTERNAL", 2);
        f18486i = new q("PRIVATE", 3);
        f18487j = a();
    }

    private q(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ q[] a() {
        return new q[]{f18483f, f18484g, f18485h, f18486i};
    }

    public static q valueOf(String r1) {
        return (q) Enum.valueOf(q.class, r1);
    }

    public static q[] values() {
        return (q[]) f18487j.clone();
    }
}
