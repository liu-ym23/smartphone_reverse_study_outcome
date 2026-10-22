package tmsdkobf;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b0$$ExternalSyntheticBackport0 {
    public static /* synthetic */ boolean m(String r5) {
        int r0 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        int r3 = r5.codePointAt(r2);
        if (Character.isWhitespace(r3) == false) goto L6;
        r2 = r2 + Character.charCount(r3);
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static /* synthetic */ boolean m(AtomicReference r1, Object r2, Object r3) {
    L3:
        if (r1.compareAndSet(r2, r3) == true) goto L4;
        if (r1.get() == r2) goto L3;
        return false;
    L4:
        return true;
    }

    public static /* synthetic */ boolean m(AtomicReferenceArray r1, int r2, Object r3, Object r4) {
    L3:
        if (r1.compareAndSet(r2, r3, r4) == true) goto L4;
        if (r1.get(r2) == r3) goto L3;
        return false;
    L4:
        return true;
    }

    public static /* synthetic */ boolean m(AtomicReferenceFieldUpdater r1, Object r2, Object r3, Object r4) {
    L3:
        if (r1.compareAndSet(r2, r3, r4) == true) goto L4;
        if (r1.get(r2) == r3) goto L3;
        return false;
    L4:
        return true;
    }
}
