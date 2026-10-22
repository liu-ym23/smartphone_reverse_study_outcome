package kotlin.u0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\f\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002H\u0007¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
class m extends l {

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "line", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<String, String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f21449f = null;

        static {
            f21449f = new a();
        }

        a() {
            super(1);
        }

        public final String a(String r1) {
            kotlin.n0.d.o.f(r1, "line");
            return r1;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ String invoke(String r1) {
            String r2 = r1;
            a(r2);
            return r2;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "line", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<String, String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f21450f;

        b(String r1) {
            this.f21450f = r1;
            super(1);
        }

        public final String a(String r2) {
            kotlin.n0.d.o.f(r2, "line");
            return this.f21450f + r2;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ String invoke(String r1) {
            return a(r1);
        }
    }

    private static final kotlin.n0.c.l<String, String> b(String r1) {
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return a.f21449f;
    L9:
        return new b(r1);
    L5:
        r0 = false;
        goto L6
    }

    private static final int c(String r4) {
        int r0 = r4.length();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        if ((!kotlin.u0.a.c(r4.charAt(r1))) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 == (-1)) goto L12;
        return r1;
    L12:
        return r4.length();
    L9:
        r1 = -1;
        goto L10
    }

    public static final String d(String r14, String r15) {
        kotlin.n0.d.o.f(r14, "<this>");
        kotlin.n0.d.o.f(r15, "newIndent");
        List<String> r0 = u.Y(r14);
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((!k.q((String) r3)) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        ArrayList r4 = new ArrayList(kotlin.i0.r.q(r1, 10));
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r4.add(Integer.valueOf(c((String) r5.next())));
        goto L10
    L12:
        Integer r6 = (Integer) kotlin.i0.r.g0(r4);
        int r7 = 0;
        if (r6 == null) goto L15;
        int r8 = r6.intValue();
    L16:
        int r16 = r14.length() + (r15.length() * r0.size());
        kotlin.n0.c.l<String, String> r17 = b(r15);
        int r9 = kotlin.i0.r.i(r0);
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r0.iterator();
    L18:
        if (r11.hasNext() == false) goto L37;
        Object r12 = r11.next();
        int r13 = r7 + 1;
        String r18 = null;
        if (r7 < 0) goto L35;
        String r19 = (String) r12;
        if (r7 == 0) goto L25;
        if (r7 == r9) goto L25;
    L27:
        String r20 = w.I0(r19, r8);
        if (r20 == null) goto L31;
        r18 = r17.invoke(r20);
        if (r18 == null) goto L31;
    L32:
        if (r18 == null) goto L34;
        r10.add(r18);
    L34:
        r7 = r13;
    L31:
        r18 = r19;
    L25:
        if (k.q(r19) == false) goto L27;
    L35:
        kotlin.i0.r.p();
        throw null;
    L37:
        StringBuilder r110 = new StringBuilder(r16);
        kotlin.i0.r.X(r10, r110, "\n", null, null, 0, null, null, 124, null);
        String r111 = r110.toString();
        kotlin.n0.d.o.e(r111, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return r111;
    L15:
        r8 = 0;
        goto L16
    }

    public static String e(String r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return d(r1, "");
    }
}
