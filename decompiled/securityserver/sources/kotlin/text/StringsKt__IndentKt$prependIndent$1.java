package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class StringsKt__IndentKt$prependIndent$1 extends Lambda implements Function1<String, String> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        String r2 = (String) r1;
        Intrinsics.f(r2, "it");
        if (StringsKt.t(r2) == true) goto L7;
        return "null".concat(r2);
    L7:
        throw null;
    }
}
