package kotlin.k0;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c implements g, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f18393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final g.b f18394g;

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends q implements p<String, g.b, String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f18395f = null;

        static {
            f18395f = new a();
        }

        a() {
            super(2);
        }

        public final String a(String r1, g.b r2) {
            o.f(r1, "acc");
            o.f(r2, "element");
            if (r1.length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            return r2.toString();
        L9:
            return r1 + ", " + r2;
        L5:
            r0 = false;
            goto L6
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ String invoke(String r1, g.b r2) {
            return a(r1, r2);
        }
    }

    public c(g r2, g.b r3) {
        o.f(r2, "left");
        o.f(r3, "element");
        this.f18393f = r2;
        this.f18394g = r3;
    }

    private final boolean c(g.b r2) {
        return o.a(get(r2.getKey()), r2);
    }

    private final boolean d(c r2) {
    L3:
        if (c(r2.f18394g) == false) goto L4;
        g r3 = r2.f18393f;
        if ((r3 instanceof c) == false) goto L9;
        r2 = (c) r3;
        goto L3
    L9:
        o.d(r3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        return c((g.b) r3);
    L4:
        return false;
    }

    private final int e() {
        int r0 = 2;
    L3:
        g r2 = this.f18393f;
        if ((r2 instanceof c) == false) goto L6;
        c this = (c) r2;
    L7:
        if (this == null) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return r0;
    L6:
        this = null;
        goto L7
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
    L11:
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L10;
        c r4 = (c) r3;
        if (r4.e() != e()) goto L10;
        if (r4.d(this) == true) goto L11;
    L10:
        return false;
    }

    @Override // kotlin.k0.g
    public <R> R fold(R r2, p<? super R, ? super g.b, ? extends R> r3) {
        o.f(r3, "operation");
        return r3.invoke((Object) this.f18393f.fold(r2, r3), this.f18394g);
    }

    @Override // kotlin.k0.g
    public <E extends g.b> E get(g.c<E> r2) {
        o.f(r2, "key");
    L3:
        E r0 = (E) this.f18394g.get(r2);
        if (r0 != null) goto L5;
        g r1 = this.f18393f;
        if ((r1 instanceof c) == false) goto L10;
        c this = (c) r1;
        goto L3
    L10:
        return (E) r1.get(r2);
    L5:
        return r0;
    }

    public int hashCode() {
        return this.f18393f.hashCode() + this.f18394g.hashCode();
    }

    @Override // kotlin.k0.g
    public g minusKey(g.c<?> r2) {
        o.f(r2, "key");
        if (this.f18394g.get(r2) != null) goto L5;
        g r3 = this.f18393f.minusKey(r2);
        if (r3 != this.f18393f) goto L10;
        return this;
    L10:
        if (r3 != h.f18399f) goto L13;
        return this.f18394g;
    L13:
        return new c(r3, this.f18394g);
    L5:
        return this.f18393f;
    }

    @Override // kotlin.k0.g
    public g plus(g r1) {
        return g.a.a(this, r1);
    }

    public String toString() {
        return '[' + ((String) fold("", a.f18395f)) + ']';
    }
}
