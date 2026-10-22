package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: Indent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\f\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002H\u0007¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 8, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public StringsKt__IndentKt() {
    }

    public static /* synthetic */ String trimMargin$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "|";
    L6:
        return StringsKt.trimMargin(r0, r1);
    }

    public static final String trimMargin(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "marginPrefix");
        return StringsKt.replaceIndentByMargin(r1, "", r2);
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = "|";
    L9:
        return StringsKt.replaceIndentByMargin(r0, r1, r2);
    }

    public static final String replaceIndentByMargin(String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r21, "<this>");
        Intrinsics.checkNotNullParameter(r22, "newIndent");
        Intrinsics.checkNotNullParameter(r23, "marginPrefix");
        if ((!StringsKt.isBlank(r23)) == false) goto L40;
        List<String> r1 = StringsKt.lines(r21);
        int r7 = r21.length() + (r22.length() * r1.size());
        Function1<String, String> r8 = getIndentFunction$StringsKt__IndentKt(r22);
        int r9 = CollectionsKt.getLastIndex(r1);
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r1.iterator();
        int r0 = 0;
    L6:
        if (r11.hasNext() == false) goto L37;
        Object r2 = r11.next();
        int r13 = r0 + 1;
        if (r0 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        String r14 = (String) r2;
        String r15 = null;
        if (r0 == 0) goto L14;
        if (r0 == r9) goto L14;
    L16:
        String r3 = r14;
        int r4 = r3.length();
        int r5 = 0;
    L18:
        if (r5 >= r4) goto L23;
        if ((!CharsKt.isWhitespace(r3.charAt(r5))) == true) goto L21;
        r5 = r5 + 1;
        goto L18
    L21:
        int r6 = r5;
    L24:
        if (r6 == (-1)) goto L29;
        int r17 = r6;
        if (StringsKt.startsWith$default(r14, r23, r6, false, 4, null) == false) goto L29;
        int r12 = r17 + r23.length();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type java.lang.String");
        r15 = r14.substring(r12);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).substring(startIndex)");
    L29:
        if (r15 == null) goto L34;
        String r16 = r8.invoke(r15);
        if (r16 == null) goto L34;
        r14 = r16;
    L34:
        if (r14 == null) goto L36;
        r10.add(r14);
    L36:
        r0 = r13;
        goto L6
    L23:
        r6 = -1;
    L14:
        if (StringsKt.isBlank(r14) == false) goto L16;
        r14 = null;
        goto L34
    L37:
        String r18 = ((StringBuilder) CollectionsKt.joinTo$default(r10, new StringBuilder(r7), IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(r18, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return r18;
    L40:
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static final String trimIndent(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.replaceIndent(r1, "");
    }

    public static /* synthetic */ String replaceIndent$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "";
    L6:
        return StringsKt.replaceIndent(r0, r1);
    }

    public static final String replaceIndent(String r17, String r18) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r18, "newIndent");
        List<String> r1 = StringsKt.lines(r17);
        List<String> r3 = r1;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r6 = r5.next();
        if ((!StringsKt.isBlank((String) r6)) == false) goto L4;
        r4.add(r6);
        goto L4
    L8:
        ArrayList r7 = r4;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        r8.add(Integer.valueOf(indentWidth$StringsKt__IndentKt((String) r9.next())));
        goto L10
    L12:
        Integer r10 = (Integer) CollectionsKt.minOrNull(r8);
        int r11 = 0;
        if (r10 == null) goto L15;
        int r12 = r10.intValue();
    L16:
        int r0 = r17.length() + (r18.length() * r1.size());
        Function1<String, String> r2 = getIndentFunction$StringsKt__IndentKt(r18);
        int r13 = CollectionsKt.getLastIndex(r1);
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r3.iterator();
    L18:
        if (r15.hasNext() == false) goto L37;
        Object r16 = r15.next();
        int r19 = r11 + 1;
        if (r11 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        String r20 = (String) r16;
        if (r11 == 0) goto L26;
        if (r11 == r13) goto L26;
    L28:
        String r21 = StringsKt.drop(r20, r12);
        if (r21 == null) goto L34;
        String r22 = r2.invoke(r21);
        if (r22 == null) goto L34;
        r20 = r22;
    L34:
        if (r20 == null) goto L36;
        r14.add(r20);
    L36:
        r11 = r19;
    L26:
        if (StringsKt.isBlank(r20) == false) goto L28;
        r20 = null;
        goto L34
    L37:
        String r23 = ((StringBuilder) CollectionsKt.joinTo$default(r14, new StringBuilder(r0), IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(r23, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return r23;
    L15:
        r12 = 0;
        goto L16
    }

    public static /* synthetic */ String prependIndent$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "    ";
    L6:
        return StringsKt.prependIndent(r0, r1);
    }

    public static final String prependIndent(String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "indent");
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence(r10), new AnonymousClass1(r11)), IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, null, 62, null);
    }

    private static final int indentWidth$StringsKt__IndentKt(String r5) {
        String r0 = r5;
        int r1 = r0.length();
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        if ((!CharsKt.isWhitespace(r0.charAt(r2))) == true) goto L10;
        r2 = r2 + 1;
    L10:
        if (r2 == (-1)) goto L12;
        return r2;
    L12:
        return r5.length();
    L9:
        r2 = -1;
        goto L10
    }

    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(final String r1) {
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return StringsKt__IndentKt$getIndentFunction$1.INSTANCE;
    L9:
        return new StringsKt__IndentKt$getIndentFunction$2(r1);
    L5:
        r0 = false;
        goto L6
    }

    private static final String reindent$StringsKt__IndentKt(List<String> r12, int r13, Function1<? super String, String> r14, Function1<? super String, String> r15) {
        int r0 = CollectionsKt.getLastIndex(r12);
        ArrayList r1 = new ArrayList();
        Iterator<T> r16 = r12.iterator();
        int r2 = 0;
    L4:
        if (r16.hasNext() == false) goto L23;
        Object r3 = r16.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r5 = (String) r3;
        if (r2 == 0) goto L12;
        if (r2 == r0) goto L12;
    L14:
        String r6 = r15.invoke(r5);
        if (r6 == null) goto L20;
        String r7 = r14.invoke(r6);
        if (r7 == null) goto L20;
        r5 = r7;
    L20:
        if (r5 == null) goto L22;
        r1.add(r5);
    L22:
        r2 = r4;
    L12:
        if (StringsKt.isBlank(r5) == false) goto L14;
        r5 = null;
        goto L20
    L23:
        String r17 = ((StringBuilder) CollectionsKt.joinTo$default(r1, new StringBuilder(r13), IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(r17, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return r17;
    }
}
