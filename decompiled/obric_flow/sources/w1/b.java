package w1;

import ai.j0;
import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements u1.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property$NodeInfo f22677b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22678a;

    static {
        f22677b = new Property$NodeInfo("urn:ietf:params:xml:ns:caldav", "calendar-data");
    }

    public b(String r5) {
        this.f22678a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f22678a, ((b) r5).f22678a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f22678a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.hashCode();
    }

    public final String toString() {
        return j0.p(new StringBuilder("CalendarData(iCalendar="), this.f22678a, ')');
    }
}
