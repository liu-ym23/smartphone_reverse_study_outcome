package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: _OneToManyTitlecaseMappings.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"titlecaseImpl", "", "", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class _OneToManyTitlecaseMappingsKt {
    public static final String titlecaseImpl(char r4) {
        String r0 = String.valueOf(r4);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.lang.String");
        String r1 = r0.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (r1.length() <= 1) goto L10;
        if (r4 == 329) goto L11;
        char r5 = r1.charAt(0);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type java.lang.String");
        String r2 = r1.substring(1);
        Intrinsics.checkNotNullExpressionValue(r2, "this as java.lang.String).substring(startIndex)");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.String");
        String r3 = r2.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return r5 + r3;
    L11:
        return r1;
    L10:
        return String.valueOf(Character.toTitleCase(r4));
    }
}
