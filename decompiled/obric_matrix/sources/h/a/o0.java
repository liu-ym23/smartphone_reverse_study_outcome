package h.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n2\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0087\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\\\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\n2'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0012¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u0002H\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0087\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "invoke", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum o0 extends Enum<o0> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o0 f17545f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final o0 f17546g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final o0 f17547h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final o0 f17548i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ o0[] f17549j = null;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17550a = null;

        static {
            int[] r0 = new int[o0.values().length];
            r0[o0.f17545f.ordinal()] = 1;
            r0[o0.f17547h.ordinal()] = 2;
            r0[o0.f17548i.ordinal()] = 3;
            r0[o0.f17546g.ordinal()] = 4;
            f17550a = r0;
        }
    }

    static {
        f17545f = new o0("DEFAULT", 0);
        f17546g = new o0("LAZY", 1);
        f17547h = new o0("ATOMIC", 2);
        f17548i = new o0("UNDISPATCHED", 3);
        f17549j = a();
    }

    private o0(String r1, int r2) {
        super(r1, r2);
    }

    private static final /* synthetic */ o0[] a() {
        return new o0[]{f17545f, f17546g, f17547h, f17548i};
    }

    public static o0 valueOf(String r1) {
        return (o0) Enum.valueOf(o0.class, r1);
    }

    public static o0[] values() {
        return (o0[]) f17549j.clone();
    }

    public final <R, T> void b(kotlin.n0.c.p<? super R, ? super kotlin.k0.d<? super T>, ? extends Object> r7, R r8, kotlin.k0.d<? super T> r9) {
        int r6 = a.f17550a[ordinal()];
        if (r6 != 1) goto L5;
        h.a.g3.a.d(r7, r8, r9, null, 4, null);
        return;
    L5:
        if (r6 != 2) goto L7;
        kotlin.k0.f.a(r7, r8, r9);
        return;
    L7:
        if (r6 != 3) goto L9;
        h.a.g3.b.a(r7, r8, r9);
        return;
    L9:
        if (r6 != 4) goto L12;
        return;
    L12:
        throw new kotlin.m();
    }

    public final boolean c() {
        if (this != f17546g) goto L5;
        return true;
    L5:
        return false;
    }
}
