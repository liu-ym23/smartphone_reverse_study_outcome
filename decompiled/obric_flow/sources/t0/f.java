package t0;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f22058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f22059b;

    public f(Function0 r5, Function0 r10) {
        this.f22058a = r5;
        this.f22059b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r10 = (f) r5;
        Function0 r11 = r10.f22058a;
        if (Intrinsics.areEqual(this.f22058a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22059b, r10.f22059b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        Function0 r10 = this.f22058a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        Function0 r13 = this.f22059b;
        if (r13 == null) goto L11;
        r5 = r13.hashCode();
    L11:
        return (r12 + r5) * 961;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "OnAppBackGroundCallback(onAppBackground=" + this.f22058a + ", onAppForeground=" + this.f22059b + ", onAllActivityDestroyed=null, callbackWrap=null)";
    }
}
