package s1;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import m1.f;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f21812c;
    public final WeakReference d;

    public d(f r5, String r10, String r11, long r12) {
        Intrinsics.checkNotNullParameter(r5, "jsEventDelegate");
        this.f21810a = r10;
        this.f21811b = r11;
        this.f21812c = r12;
        this.d = new WeakReference(r5);
    }

    public final void a(a r5) {
        Intrinsics.checkNotNullParameter(r5, "aiBridgeEvent");
        String r10 = r5.d;
        if (r10 != null) goto L5;
    L10:
        f r11 = (f) this.d.get();
        if (r11 == null) goto L14;
        String r12 = r5.f21804a;
        Intrinsics.checkNotNullParameter(r12, "eventName");
        r11.f19965a.e(r12, r5.f21805b);
        return;
    L14:
        return;
    L5:
        if (r10.length() == 0) goto L10;
        if (Intrinsics.areEqual(r5.d, this.f21811b) == true) goto L10;
    }

    public final boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        String r10 = ((d) r5).f21810a;
        String r11 = this.f21810a;
        if (Intrinsics.areEqual(r11, r10) == false) goto L16;
        if (r11 == null) goto L16;
        if (r11.length() == 0) goto L16;
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r5 = this.f21810a;
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.hashCode();
    }
}
