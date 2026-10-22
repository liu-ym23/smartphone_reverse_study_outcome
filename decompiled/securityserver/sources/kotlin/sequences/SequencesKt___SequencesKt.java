package kotlin.sequences;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {
    public static final Collection a(Sequence r1, AbstractCollection r2) {
        Intrinsics.f(r1, "<this>");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(r3.next());
        goto L4
    L6:
        return r2;
    }

    public static final List b(Sequence r1) {
        Intrinsics.f(r1, "<this>");
        ArrayList r0 = new ArrayList();
        a(r1, r0);
        return r0;
    }
}
