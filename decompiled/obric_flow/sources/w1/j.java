package w1;

import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements u1.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property$NodeInfo f22690b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22691a;

    static {
        f22690b = new Property$NodeInfo("DAV:", "getetag");
    }

    public j(String r5) {
        if (r5 != null) goto L5;
        String r10 = null;
    L11:
        this.f22691a = r10;
        return;
    L5:
        if (StringsKt.P(r5, "W/") == true) goto L7;
    L9:
        r10 = x1.a.a(r5);
        goto L11
    L7:
        if (r5.length() < 3) goto L9;
        r5 = r5.substring(2);
        goto L9
    }

    public final String toString() {
        String r5 = this.f22691a;
        if (r5 != null) goto L6;
        return "(null)";
    L6:
        return r5;
    }
}
