package w1;

import ai.j0;
import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements u1.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property$NodeInfo f22699b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22700a;

    static {
        f22699b = new Property$NodeInfo("DAV:", "sync-token");
    }

    public o(String r5) {
        this.f22700a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f22700a, ((o) r5).f22700a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f22700a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.hashCode();
    }

    public final String toString() {
        return j0.p(new StringBuilder("SyncToken(token="), this.f22700a, ')');
    }
}
