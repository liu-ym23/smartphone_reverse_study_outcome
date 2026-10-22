package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    public static final void b(Iterable r2, StringBuilder r3, CharSequence r4, CharSequence r5, CharSequence r6, int r7, CharSequence r8, Function1 r9) {
        Intrinsics.f(r2, "<this>");
        Intrinsics.f(r4, "separator");
        Intrinsics.f(r5, "prefix");
        Intrinsics.f(r6, "postfix");
        Intrinsics.f(r8, "truncated");
        r3.append(r5);
        Iterator r10 = r2.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L11;
        Object r0 = r10.next();
        r11 = r11 + 1;
        if (r11 <= 1) goto L8;
        r3.append(r4);
    L8:
        if (r7 < 0) goto L10;
        if (r11 > r7) goto L11;
    L10:
        StringsKt.l(r3, r0, r9);
    L11:
        if (r7 < 0) goto L14;
        if (r11 <= r7) goto L14;
        r3.append(r8);
    L14:
        r3.append(r6);
    }

    public static final void c(Iterable r1, java.util.AbstractCollection r2) {
        Intrinsics.f(r1, "<this>");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(r3.next());
        goto L4
    }
}
