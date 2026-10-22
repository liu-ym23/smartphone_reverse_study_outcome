package w1;

import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements u1.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property$NodeInfo f22697b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22698a;

    static {
        f22697b = new Property$NodeInfo("urn:ietf:params:xml:ns:caldav", "schedule-tag");
    }

    public n(String r5) {
        if (r5 == null) goto L5;
        String r10 = x1.a.a(r5);
    L6:
        this.f22698a = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }

    public final String toString() {
        String r5 = this.f22698a;
        if (r5 != null) goto L6;
        return "(null)";
    L6:
        return r5;
    }
}
