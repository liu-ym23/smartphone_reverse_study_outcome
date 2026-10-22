package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Appendable.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007\u001a9\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\n\u001a\u0002H\u00012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0000¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0087\b\u001a\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a\u001f\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0006H\u0087\b\u001a7\u0010\u0010\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"append", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendElement", "", "element", "transform", "Lkotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "appendLine", "", "appendRange", "startIndex", "", "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__AppendableKt {
    public StringsKt__AppendableKt() {
    }

    public static final <T extends Appendable> T appendRange(T r1, CharSequence r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "value");
        T r5 = (T) r1.append(r2, r3, r4);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return r5;
    }

    public static final <T extends Appendable> T append(T r3, CharSequence... r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "value");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3.append(r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    private static final Appendable appendLine(Appendable r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Appendable r2 = r1.append('\n');
        Intrinsics.checkNotNullExpressionValue(r2, "append(...)");
        return r2;
    }

    private static final Appendable appendLine(Appendable r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Appendable r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        Appendable r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final Appendable appendLine(Appendable r1, char r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Appendable r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        Appendable r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void appendElement(Appendable r1, T r2, Function1<? super T, ? extends CharSequence> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r3 == null) goto L5;
        r1.append(r3.invoke(r2));
        return;
    L5:
        if (r2 != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L11;
        r1.append((CharSequence) r2);
        return;
    L11:
        if ((r2 instanceof Character) == false) goto L13;
        r1.append(((Character) r2).charValue());
        return;
    L13:
        r1.append(String.valueOf(r2));
        return;
    L7:
        r4 = r2 instanceof CharSequence;
        goto L8
    }
}
