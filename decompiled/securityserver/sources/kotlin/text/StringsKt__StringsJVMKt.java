package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public static final boolean a(String r6, int r7, boolean r8, String r9, int r10, int r11) {
        Intrinsics.f(r6, "<this>");
        Intrinsics.f(r9, "other");
        if (r8 == true) goto L6;
        return r6.regionMatches(r7, r9, r10, r11);
    L6:
        return r6.regionMatches(r8, r7, r9, r10, r11);
    }
}
