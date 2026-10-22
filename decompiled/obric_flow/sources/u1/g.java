package u1;

import androidx.core.app.NotificationCompat;
import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property$NodeInfo f22236c = null;
    public static final StatusLine d = null;
    public static final StatusLine e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f22237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StatusLine f22238b;

    static {
        f22236c = new Property$NodeInfo("DAV:", "propstat");
        Protocol r5 = Protocol.HTTP_1_1;
        d = new StatusLine(r5, 200, "Assuming OK");
        e = new StatusLine(r5, 500, "Invalid status line");
    }

    public g(LinkedList r5, StatusLine r10) {
        Intrinsics.checkNotNullParameter(r5, "properties");
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_STATUS);
        this.f22237a = r5;
        this.f22238b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r5;
        LinkedList r11 = r10.f22237a;
        if (Intrinsics.areEqual(this.f22237a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22238b, r10.f22238b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f22237a.hashCode() * 31;
        return (this.f22238b.hashCode() + r5) * 31;
    }

    public final String toString() {
        return "PropStat(properties=" + this.f22237a + ", status=" + this.f22238b + ", error=null)";
    }
}
