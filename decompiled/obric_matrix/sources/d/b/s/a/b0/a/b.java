package d.b.s.a.b0.a;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f14656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f14657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f14658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f14659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f14660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f14661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f14662k;

    public b(int r1) {
    }

    public boolean b() {
        int r1 = this.f14652a;
        if (r1 > 1100) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 1199) goto L7;
        return true;
    }

    public boolean c() {
        int r0 = this.f14652a;
        if (r0 == 1101) goto L9;
        if (r0 == 1102) goto L9;
        if (r0 == 1103) goto L9;
    L11:
        return false;
    L9:
        if (TextUtils.isEmpty(this.f14655d) == true) goto L11;
        return true;
    }
}
