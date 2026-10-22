package u0;

import ai.j0;
import android.app.Application;
import k5.d;
import kn.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f22194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22196c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f22197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f22198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f22199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f22200k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f22201l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f22202m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f22203n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f22204o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f22205p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f22206q;

    public a(Application r14, String r15, String r16, int r17, String r18, String r19, String r20, String r21, String r22, boolean r23, boolean r24, boolean r25, String r26, boolean r27, String r28, boolean r29, String r30) {
        Intrinsics.checkNotNullParameter(r14, "application");
        Intrinsics.checkNotNullParameter(r16, "appName");
        Intrinsics.checkNotNullParameter(r18, "appVersion");
        Intrinsics.checkNotNullParameter(r19, "appVersionCode");
        Intrinsics.checkNotNullParameter(r20, "appPackageName");
        Intrinsics.checkNotNullParameter(r21, "appChannel");
        Intrinsics.checkNotNullParameter(r22, "updateVersionCode");
        Intrinsics.checkNotNullParameter(r26, "bid");
        Intrinsics.checkNotNullParameter(r28, "boeEnv");
        Intrinsics.checkNotNullParameter(r30, "ppeEnv");
        Intrinsics.checkNotNullParameter("zh", "language");
        this.f22194a = r14;
        this.f22195b = r15;
        this.f22196c = r16;
        this.d = r17;
        this.e = r18;
        this.f = r19;
        this.g = r20;
        this.f22197h = r21;
        this.f22198i = r22;
        this.f22199j = r23;
        this.f22200k = r24;
        this.f22201l = r25;
        this.f22202m = r26;
        this.f22203n = r27;
        this.f22204o = r28;
        this.f22205p = r29;
        this.f22206q = r30;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        Application r11 = r10.f22194a;
        if (Intrinsics.areEqual(this.f22194a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22195b, r10.f22195b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f22196c, r10.f22196c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f22197h, r10.f22197h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f22198i, r10.f22198i) == true) goto L36;
        return false;
    L36:
        if (this.f22199j == r10.f22199j) goto L39;
        return false;
    L39:
        if (this.f22200k == r10.f22200k) goto L42;
        return false;
    L42:
        if (this.f22201l == r10.f22201l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f22202m, r10.f22202m) == true) goto L48;
        return false;
    L48:
        if (this.f22203n == r10.f22203n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f22204o, r10.f22204o) == true) goto L54;
        return false;
    L54:
        if (this.f22205p == r10.f22205p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f22206q, r10.f22206q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual("zh", "zh") == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(null, null) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(null, null) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f22194a.hashCode() * 31;
        String r10 = this.f22195b;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return Boolean.hashCode(false) + e.a(d.a(100, (((this.f22206q.hashCode() + e.a(kk.a.b(this.f22204o, e.a(kk.a.b(this.f22202m, e.a(e.a(e.a(kk.a.b(this.f22198i, kk.a.b(this.f22197h, kk.a.b(this.g, kk.a.b(this.f, kk.a.b(this.e, d.a(this.d, kk.a.b(this.f22196c, (r5 + r11) * 31, 31)), 31), 31), 31), 31), 31), 31, this.f22199j), 31, this.f22200k), 31, this.f22201l), 31), 31, this.f22203n), 31), 31, this.f22205p)) * 31) + 3886) * 961), 961, false);
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("AISDKConfig(application=");
        r5.append(this.f22194a);
        r5.append(", deviceId=");
        r5.append(this.f22195b);
        r5.append(", appName=");
        r5.append(this.f22196c);
        r5.append(", appId=");
        r5.append(this.d);
        r5.append(", appVersion=");
        r5.append(this.e);
        r5.append(", appVersionCode=");
        r5.append(this.f);
        r5.append(", appPackageName=");
        r5.append(this.g);
        r5.append(", appChannel=");
        r5.append(this.f22197h);
        r5.append(", updateVersionCode=");
        r5.append(this.f22198i);
        r5.append(", isOversea=");
        r5.append(this.f22199j);
        r5.append(", isDebug=");
        r5.append(this.f22200k);
        r5.append(", isTestChannel=");
        r5.append(this.f22201l);
        r5.append(", bid=");
        r5.append(this.f22202m);
        r5.append(", boeEnable=");
        r5.append(this.f22203n);
        r5.append(", boeEnv=");
        r5.append(this.f22204o);
        r5.append(", ppeEnable=");
        r5.append(this.f22205p);
        r5.append(", ppeEnv=");
        return j0.q(r5, this.f22206q, ", language=zh, fontSizeInPx=null, textZoom=100, disablePerformance=false, unsupportedRenderType=null, enableLynxV8=false)");
    }
}
