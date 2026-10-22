package x4;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends sj.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f22955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k8.a f22957c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f22960j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f22961k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f22962l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f22963m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f22964n;

    public d(h r5) {
        Intrinsics.checkNotNullParameter(r5, "commonData");
        this.f22955a = r5;
        this.f22957c = new k8.a(99999999, "", 0);
        this.f22961k = "";
        this.f22962l = "";
        this.f22963m = "";
        this.f22964n = "";
        r5.s("stage", 0);
    }

    @Override // sj.g
    public final void m(JSONObject r5) {
        qo.a.e(this.f22956b, "stage", r5);
        qo.a.e(this.d, "js_exception_count", r5);
        qo.a.e(this.e, "native_error_count", r5);
        qo.a.e(this.f, "static_count", r5);
        qo.a.e(this.g, "fetch_error_count", r5);
        qo.a.e(this.f22958h, "jsb_error_count", r5);
        qo.a.e(this.f22959i, "res_loader_error_count", r5);
        qo.a.e(this.f22960j, "res_loader_error_template_count", r5);
        qo.a.t("render_status", this.f22961k, r5);
        qo.a.t("dom_state", this.f22962l, r5);
        qo.a.t("rendering_phase", this.f22963m, r5);
        qo.a.t("js_hang", this.f22964n, r5);
    }

    public final void s(int r5) {
        this.f22956b = r5;
        Integer r10 = Integer.valueOf(r5);
        this.f22955a.s("stage", r10);
    }

    public final void t(com.bytedance.android.monitorV2.event.a r5, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r11, "message");
        String r12 = r5.f3557a;
        switch(r12.hashCode()) {
            case -892481938: goto L40;
            case 281935726: goto L35;
            case 299602137: goto L30;
            case 1521451035: goto L25;
            case 1727072305: goto L16;
            case 1830775838: goto L11;
            case 1910899023: goto L6;
            default: goto L44;
        };
    L44:
        return;
    L6:
        if (r12.equals("jsbError") == false) goto L45;
        this.f22957c = new k8.a(37000000, r11, r10);
        return;
    L45:
        return;
    L11:
        if (r12.equals("res_loader_error_template") == false) goto L46;
        this.f22957c = new k8.a(63000000, r11, r10);
        return;
    L46:
        return;
    L16:
        if (r12.equals("nativeError") == true) goto L19;
        return;
    L19:
        if (Intrinsics.areEqual(r5.f.f22975c, "web") == false) goto L21;
        k8.a r13 = new k8.a(47000000, r11, r10);
    L22:
        this.f22957c = r13;
        return;
    L21:
        r13 = new k8.a(50000000, r11, r10);
        goto L22
    L25:
        if (r12.equals("res_loader_error") == false) goto L48;
        this.f22957c = new k8.a(63000000, r11, r10);
        return;
    L48:
        return;
    L30:
        if (r12.equals("js_exception") == false) goto L49;
        this.f22957c = new k8.a(70000000, r11, r10);
        return;
    L49:
        return;
    L35:
        if (r12.equals("fetchError") == false) goto L50;
        this.f22957c = new k8.a(65000000, r11, r10);
        return;
    L50:
        return;
    L40:
        if (r12.equals("static") == true) goto L42;
        return;
    L42:
        this.f22957c = new k8.a(67000000, r11, r10);
    }

    public final void u(com.bytedance.android.monitorV2.event.d r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L42;
        String r10 = r5.f3557a;
        switch(r10.hashCode()) {
            case -892481938: goto L38;
            case 281935726: goto L33;
            case 299602137: goto L28;
            case 1521451035: goto L23;
            case 1727072305: goto L18;
            case 1830775838: goto L13;
            case 1910899023: goto L8;
            default: goto L43;
        };
    L43:
        return;
    L8:
        if (r10.equals("jsbError") == false) goto L44;
        this.f22958h++;
        return;
    L44:
        return;
    L13:
        if (r10.equals("res_loader_error_template") == false) goto L45;
        this.f22960j++;
        return;
    L45:
        return;
    L18:
        if (r10.equals("nativeError") == false) goto L46;
        this.e++;
        return;
    L46:
        return;
    L23:
        if (r10.equals("res_loader_error") == false) goto L47;
        this.f22959i++;
        return;
    L47:
        return;
    L28:
        if (r10.equals("js_exception") == false) goto L48;
        this.d++;
        return;
    L48:
        return;
    L33:
        if (r10.equals("fetchError") == false) goto L49;
        this.g++;
        return;
    L49:
        return;
    L38:
        if (r10.equals("static") == false) goto L50;
        this.f++;
        return;
    L50:
        return;
    }
}
