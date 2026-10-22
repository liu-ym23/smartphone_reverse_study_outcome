package kotlin.u0;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matcher f21443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f21444b;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0096\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends kotlin.i0.c<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f21445f;

        a(h r1) {
            this.f21445f = r1;
        }

        public /* bridge */ boolean a(String r1) {
            return super.contains(r1);
        }

        public String b(int r1) {
            String r0 = h.c(this.f21445f).group(r1);
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        public /* bridge */ int c(String r1) {
            return super.indexOf(r1);
        }

        @Override // kotlin.i0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return false;
        L7:
            return a((String) r2);
        }

        public /* bridge */ int g(String r1) {
            return super.lastIndexOf(r1);
        }

        @Override // kotlin.i0.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return b(r1);
        }

        @Override // kotlin.i0.c, kotlin.i0.a
        public int getSize() {
            return h.c(this.f21445f).groupCount() + 1;
        }

        @Override // kotlin.i0.c, java.util.List
        public final /* bridge */ int indexOf(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return -1;
        L7:
            return c((String) r2);
        }

        @Override // kotlin.i0.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return -1;
        L7:
            return g((String) r2);
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0096\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends kotlin.i0.a<f> implements Object, kotlin.n0.d.l0.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f21446f;

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/text/MatchGroup;", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<Integer, f> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f21447f;

            a(b r1) {
                this.f21447f = r1;
                super(1);
            }

            public final f a(int r1) {
                return this.f21447f.b(r1);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ f invoke(Integer r1) {
                return a(r1.intValue());
            }
        }

        b(h r1) {
            this.f21446f = r1;
        }

        public /* bridge */ boolean a(f r1) {
            return super.contains(r1);
        }

        public f b(int r3) {
            kotlin.r0.d r0 = j.c(h.c(this.f21446f), r3);
            if (r0.o().intValue() < 0) goto L5;
            String r2 = h.c(this.f21446f).group(r3);
            kotlin.n0.d.o.e(r2, "matchResult.group(index)");
            return new f(r2, r0);
        L5:
            return null;
        }

        @Override // kotlin.i0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object r2) {
            if (r2 != null) goto L4;
            boolean r0 = true;
        L5:
            if (r0 == true) goto L9;
            return false;
        L9:
            return a((f) r2);
        L4:
            r0 = r2 instanceof f;
            goto L5
        }

        @Override // kotlin.i0.a
        public int getSize() {
            return h.c(this.f21446f).groupCount() + 1;
        }

        @Override // kotlin.i0.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // kotlin.i0.a, java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return kotlin.t0.k.t(kotlin.i0.r.I(kotlin.i0.r.h(this)), new a(this)).iterator();
        }
    }

    public h(Matcher r2, CharSequence r3) {
        kotlin.n0.d.o.f(r2, "matcher");
        kotlin.n0.d.o.f(r3, "input");
        this.f21443a = r2;
        new b(this);
    }

    public static final /* synthetic */ MatchResult c(h r0) {
        return r0.d();
    }

    private final MatchResult d() {
        return this.f21443a;
    }

    @Override // kotlin.u0.g
    public g.b a() {
        return g.a.a(this);
    }

    @Override // kotlin.u0.g
    public List<String> b() {
        if (this.f21444b != null) goto L5;
        this.f21444b = new a(this);
    L5:
        List<String> r1 = this.f21444b;
        kotlin.n0.d.o.c(r1);
        return r1;
    }

    @Override // kotlin.u0.g
    public String getValue() {
        String r1 = d().group();
        kotlin.n0.d.o.e(r1, "matchResult.group()");
        return r1;
    }
}
