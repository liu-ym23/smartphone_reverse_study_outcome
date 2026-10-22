package x4;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends t4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t4.a f22978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f22979c;

    public i() {
        super("performance");
        this.f22979c = new JSONObject();
    }

    @Override // sj.g
    public final void m(JSONObject r5) {
        t4.a r10 = this.f22978b;
        if (r10 == null) goto L5;
        JSONObject r11 = r10.s();
    L6:
        qo.a.m(r5, r11);
        qo.a.m(r5, this.f22979c);
        return;
    L5:
        r11 = null;
        goto L6
    }
}
