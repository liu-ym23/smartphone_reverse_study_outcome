package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class StringsKt___StringsKt$windowed$1 extends Lambda implements Function1<CharSequence, String> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        CharSequence r2 = (CharSequence) r1;
        Intrinsics.f(r2, "it");
        return r2.toString();
    }
}
