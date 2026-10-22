package u0;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kn.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f22211c;
    public final LinkedHashSet d;

    public c() {
        LinkedHashMap r5 = new LinkedHashMap();
        LinkedHashSet r10 = new LinkedHashSet();
        Intrinsics.checkNotNullParameter(r5, "authorityList");
        Intrinsics.checkNotNullParameter(r10, "clientPackageList");
        this.f22209a = true;
        this.f22210b = "com.obric.appletapp";
        this.f22211c = r5;
        this.d = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        boolean r11 = r10.f22209a;
        if (this.f22209a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22210b, r10.f22210b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f22211c, r10.f22211c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(null, null) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(null, null) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        int r10 = e.a(Boolean.hashCode(this.f22209a) * 31, 31, false);
        String r11 = this.f22210b;
        if (r11 == null) goto L6;
        r5 = r11.hashCode();
    L6:
        int r12 = this.f22211c.hashCode();
        int r13 = this.d.hashCode();
        return (r13 + ((r12 + ((r10 + r5) * 31)) * 961)) * 961;
    }

    public final String toString() {
        return "AISDKMultiProcessConfig(isClient=" + this.f22209a + ", isChildProcess=false, hostPackageName=" + this.f22210b + ", authorityList=" + this.f22211c + ", customAuthorityHandler=null, clientPackageList=" + this.d + ", onResourceFallback=null, loadAIPackageFallback=null)";
    }
}
