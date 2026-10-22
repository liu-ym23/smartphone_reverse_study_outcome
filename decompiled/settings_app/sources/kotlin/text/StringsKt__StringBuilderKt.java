package kotlin.text;

import com.bytedance.apm.constant.PerfConsts;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a6\u0010\u0000\u001a\u00020\u00012\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u001f\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0087\b\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000e\"\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000f\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0010\u001a-\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0015\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007H\u0087\b\u001a\u001f\u0010\u0015\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0087\b\u001a\u001d\u0010\u0015\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0016H\u0087\b\u001a\u001d\u0010\u0015\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0017H\u0087\b\u001a\u001d\u0010\u0015\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0012H\u0087\b\u001a\u001f\u0010\u0015\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0018H\u0087\b\u001a\u001f\u0010\u0015\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"buildString", "", PerfConsts.KEY_CURRENT_CAPACITY, "", "builderAction", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "append", "obj", "", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "str", "", "offset", "len", "appendLine", "", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    public StringsKt__StringBuilderKt() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    private static final StringBuilder append(StringBuilder r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return r3;
    }

    private static final String buildString(Function1<? super StringBuilder, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "builderAction");
        StringBuilder r0 = new StringBuilder();
        r1.invoke(r0);
        String r2 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return r2;
    }

    private static final String buildString(int r1, Function1<? super StringBuilder, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "builderAction");
        StringBuilder r0 = new StringBuilder(r1);
        r2.invoke(r0);
        String r3 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        return r3;
    }

    public static final StringBuilder append(StringBuilder r3, String... r4) {
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

    public static final StringBuilder append(StringBuilder r3, Object... r4) {
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

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use appendRange instead.", replaceWith = @ReplaceWith(expression = "this.appendRange(str, offset, offset + len)", imports = {}))
    private static final StringBuilder append(StringBuilder r0, char[] r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "str");
        throw new NotImplementedError(null, 1, null);
    }

    private static final StringBuilder appendLine(StringBuilder r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r2 = r1.append('\n');
        Intrinsics.checkNotNullExpressionValue(r2, "append(...)");
        return r2;
    }

    private static final StringBuilder appendLine(StringBuilder r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, char[] r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "value");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, char r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }
}
