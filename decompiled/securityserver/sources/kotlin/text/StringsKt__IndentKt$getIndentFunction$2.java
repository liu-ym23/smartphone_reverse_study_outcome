package kotlin.text;

import a.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class StringsKt__IndentKt$getIndentFunction$2 extends Lambda implements Function1<String, String> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r2) {
        String r3 = (String) r2;
        Intrinsics.f(r3, "line");
        return a.o(new StringBuilder(), null, r3);
    }
}
