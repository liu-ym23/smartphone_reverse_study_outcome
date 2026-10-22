package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class StringsKt__IndentKt$getIndentFunction$1 extends Lambda implements Function1<String, String> {
    public static final StringsKt__IndentKt$getIndentFunction$1 b = null;

    static {
        b = new StringsKt__IndentKt$getIndentFunction$1(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        String r2 = (String) r1;
        Intrinsics.f(r2, "line");
        return r2;
    }
}
