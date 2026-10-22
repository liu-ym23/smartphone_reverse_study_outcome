package kotlin.u0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0096\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class e implements kotlin.t0.h<kotlin.r0.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f21430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.n0.c.p<CharSequence, Integer, kotlin.u<Integer, Integer>> f21433d;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Iterator<kotlin.r0.d>, kotlin.n0.d.l0.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f21434f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f21435g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f21436h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private kotlin.r0.d f21437i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f21438j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ e f21439k;

        a(e r3) {
            this.f21439k = r3;
            this.f21434f = -1;
            int r4 = kotlin.r0.e.i(e.e(r3), 0, e.c(r3).length());
            this.f21435g = r4;
            this.f21436h = r4;
        }

        private final void b() {
            int r1 = 0;
            if (this.f21436h >= 0) goto L5;
            this.f21434f = 0;
            this.f21437i = null;
            return;
        L5:
            int r2 = -1;
            if (e.d(this.f21439k) <= 0) goto L10;
            int r0 = this.f21438j + 1;
            this.f21438j = r0;
            if (r0 < e.d(this.f21439k)) goto L10;
        L11:
            kotlin.r0.d r3 = new kotlin.r0.d(this.f21435g, k.K(e.c(this.f21439k)));
        L12:
            this.f21437i = r3;
        L13:
            this.f21436h = r2;
            this.f21434f = 1;
            return;
        L10:
            if (this.f21436h > e.c(this.f21439k).length()) goto L11;
            kotlin.u r4 = (kotlin.u) e.b(this.f21439k).invoke(e.c(this.f21439k), Integer.valueOf(this.f21436h));
            if (r4 != null) goto L17;
            r3 = new kotlin.r0.d(this.f21435g, k.K(e.c(this.f21439k)));
            goto L12
        L17:
            int r5 = ((Number) r4.a()).intValue();
            int r6 = ((Number) r4.b()).intValue();
            this.f21437i = kotlin.r0.e.m(this.f21435g, r5);
            int r7 = r5 + r6;
            this.f21435g = r7;
            if (r6 != 0) goto L20;
            r1 = 1;
        L20:
            r2 = r7 + r1;
            goto L13
        }

        public kotlin.r0.d c() {
            if (this.f21434f != (-1)) goto L6;
            b();
        L6:
            if (this.f21434f == 0) goto L10;
            kotlin.r0.d r0 = this.f21437i;
            kotlin.n0.d.o.d(r0, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f21437i = null;
            this.f21434f = -1;
            return r0;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f21434f != (-1)) goto L6;
            b();
        L6:
            if (this.f21434f == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ kotlin.r0.d next() {
            return c();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(CharSequence r2, int r3, int r4, kotlin.n0.c.p<? super CharSequence, ? super Integer, kotlin.u<Integer, Integer>> r5) {
        kotlin.n0.d.o.f(r2, "input");
        kotlin.n0.d.o.f(r5, "getNextMatch");
        this.f21430a = r2;
        this.f21431b = r3;
        this.f21432c = r4;
        this.f21433d = r5;
    }

    public static final /* synthetic */ kotlin.n0.c.p b(e r0) {
        return r0.f21433d;
    }

    public static final /* synthetic */ CharSequence c(e r0) {
        return r0.f21430a;
    }

    public static final /* synthetic */ int d(e r0) {
        return r0.f21432c;
    }

    public static final /* synthetic */ int e(e r0) {
        return r0.f21431b;
    }

    @Override // kotlin.t0.h
    public Iterator<kotlin.r0.d> iterator() {
        return new a(this);
    }
}
