package xc;

import ai.j0;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23014c;
    public final String d;

    public a(String r5, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, Constant.APPID);
        Intrinsics.checkNotNullParameter(r10, "appVersion");
        Intrinsics.checkNotNullParameter(r11, "installId");
        Intrinsics.checkNotNullParameter(r12, "did");
        Intrinsics.checkNotNullParameter("", LynxMonitorService.KEY_CHANNEL);
        this.f23012a = r5;
        this.f23013b = r10;
        this.f23014c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        String r11 = r10.f23012a;
        if (Intrinsics.areEqual(this.f23012a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23013b, r10.f23013b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f23014c, r10.f23014c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual("", "") == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f23012a.hashCode() * 31;
        int r10 = kk.a.b(this.f23013b, r5, 31);
        int r11 = kk.a.b(this.f23014c, r10, 31);
        return kk.a.b(this.d, r11, 31);
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("AppInfo(appId=");
        r5.append(this.f23012a);
        r5.append(", appVersion=");
        r5.append(this.f23013b);
        r5.append(", installId=");
        r5.append(this.f23014c);
        r5.append(", did=");
        return j0.q(r5, this.d, ", channel=)");
    }
}
