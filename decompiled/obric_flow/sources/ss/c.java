package ss;

import com.obric.oui.window.bean.WindowSizeClass;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowSizeClass f22010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f22011b;

    public c(WindowSizeClass r5, a r10) {
        Intrinsics.checkNotNullParameter(r5, "windowSizeClass");
        Intrinsics.checkNotNullParameter(r10, "pageSize");
        this.f22010a = r5;
        this.f22011b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        WindowSizeClass r11 = r10.f22010a;
        if (this.f22010a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22011b, r10.f22011b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f22010a.hashCode() * 31;
        return this.f22011b.hashCode() + r5;
    }

    public final String toString() {
        return "WindowSizeWithPageSize(windowSizeClass=" + this.f22010a + ", pageSize=" + this.f22011b + ')';
    }
}
