package h.a.d3;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 %*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003$%&B\u0016\b\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0019\u0010\u0005J\r\u0010\u001a\u001a\u00028\u0000¢\u0006\u0004\b\u001b\u0010\u0005J\u0010\u0010\u001c\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult;", "T", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getHolder$annotations", "()V", "isClosed", "", "isClosed-impl", "(Ljava/lang/Object;)Z", "isFailure", "isFailure-impl", "isSuccess", "isSuccess-impl", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "getOrThrow", "getOrThrow-impl", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Closed", "Companion", "Failed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f17229b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f17230c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f17231a;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Closed;", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "cause", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f17232a;

        public a(Throwable r1) {
            this.f17232a = r1;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof a) == true) goto L5;
        L7:
            return false;
        L5:
            if (kotlin.n0.d.o.a(this.f17232a, ((a) r2).f17232a) == false) goto L7;
            return true;
        }

        public int hashCode() {
            Throwable r0 = this.f17232a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        @Override // h.a.d3.j.c
        public String toString() {
            return "Closed(" + this.f17232a + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0001\u0010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0001\u0010\u0007H\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\r\u0010\u000eJ,\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0001\u0010\u00072\u0006\u0010\u0010\u001a\u0002H\u0007H\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Companion;", "", "()V", "failed", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "closed", "Lkotlinx/coroutines/channels/ChannelResult;", "E", "cause", "", "closed-JP2dKIU", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "failure", "failure-PtdJZtk", "()Ljava/lang/Object;", "success", "value", "success-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.n0.d.g r1) {
            this();
        }

        public final <E> Object a(Throwable r1) {
            a r0 = new a(r1);
            j.c(r0);
            return r0;
        }

        public final <E> Object b() {
            c r0 = j.a();
            j.c(r0);
            return r0;
        }

        public final <E> Object c(E r1) {
            j.c(r1);
            return r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Failed;", "", "()V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class c {
        public c() {
        }

        public String toString() {
            return "Failed";
        }
    }

    static {
        f17229b = new b(null);
        f17230c = new c();
    }

    private /* synthetic */ j(Object r1) {
        this.f17231a = r1;
    }

    public static final /* synthetic */ c a() {
        return f17230c;
    }

    public static final /* synthetic */ j b(Object r1) {
        return new j(r1);
    }

    public static <T> Object c(Object r0) {
        return r0;
    }

    public static boolean d(Object r2, Object r3) {
        if ((r3 instanceof j) == true) goto L6;
        return false;
    L6:
        if (kotlin.n0.d.o.a(r2, ((j) r3).k()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public static final Throwable e(Object r2) {
        if ((r2 instanceof a) == false) goto L5;
        a r3 = (a) r2;
    L6:
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.f17232a;
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T f(Object r2) {
        if ((r2 instanceof c) == true) goto L6;
        return r2;
    L6:
        if ((r2 instanceof a) == false) goto L11;
        Throwable r0 = ((a) r2).f17232a;
        if (r0 == null) goto L11;
        throw r0;
    L11:
        throw new IllegalStateException(kotlin.n0.d.o.m("Trying to call 'getOrThrow' on a failed channel result: ", r2).toString());
    }

    public static int g(Object r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.hashCode();
    }

    public static final boolean h(Object r0) {
        return r0 instanceof a;
    }

    public static final boolean i(Object r0) {
        return !(r0 instanceof c);
    }

    public static String j(Object r2) {
        if ((r2 instanceof a) == false) goto L6;
        return ((a) r2).toString();
    L6:
        return "Value(" + r2 + ')';
    }

    public boolean equals(Object r1) {
        return d(this.f17231a, r1);
    }

    public int hashCode() {
        return g(this.f17231a);
    }

    public final /* synthetic */ Object k() {
        return this.f17231a;
    }

    public String toString() {
        return j(this.f17231a);
    }
}
