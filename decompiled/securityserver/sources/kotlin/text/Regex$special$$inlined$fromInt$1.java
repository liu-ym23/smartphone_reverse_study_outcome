package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Regex$special$$inlined$fromInt$1 extends Lambda implements Function1<RegexOption, Boolean> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        FlagEnum r2 = (FlagEnum) ((Enum) r1);
        r2.getClass();
        if (r2.getValue() != 0) goto L5;
        boolean r0 = true;
    L7:
        return Boolean.valueOf(r0);
    L5:
        r0 = false;
        goto L7
    }
}
