package com.loc;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ew extends AMapLocation {
    protected String O;
    private String P;
    private String Q;
    private int R;
    private String S;
    private int T;
    private String U;
    private JSONObject V;
    private String W;
    boolean X;
    String Y;
    private String Z;
    private String a0;

    public ew(String r3) {
        super(r3);
        this.O = "";
        this.P = null;
        this.Q = "";
        this.S = "";
        this.T = 0;
        this.U = "new";
        this.V = null;
        this.W = "";
        this.X = true;
        this.Y = String.valueOf(AMapLocationClientOption.e.f500f);
        this.Z = "";
        this.a0 = null;
    }

    private void r1(String r1) {
        this.W = r1;
    }

    private void u1(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return;
    L5:
        String[] r0 = r7.split("\\*");
        int r1 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        String r4 = r0[r3];
        if (TextUtils.isEmpty(r4) == false) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        String[] r2 = r4.split(",");
        setLongitude(a5.I(r2[0]));
        setLatitude(a5.I(r2[1]));
        setAccuracy(a5.R(r2[2]));
    L11:
        this.Z = r7;
    }

    @Override // com.amap.api.location.AMapLocation
    public final JSONObject U0(int r4) {
        JSONObject r1 = super.U0(r4);     // Catch: Throwable -> L17
        if (r4 != 1) goto L6;
        r1.put("retype", this.S);     // Catch: Throwable -> L17
        r1.put("cens", this.Z);     // Catch: Throwable -> L17
        r1.put("coord", this.R);     // Catch: Throwable -> L17
        r1.put("mcell", this.W);     // Catch: Throwable -> L17
        r1.put("desc", this.O);     // Catch: Throwable -> L17
        r1.put("address", L());     // Catch: Throwable -> L17
        if (this.V != null) goto L13;
    L15:
        r1.put(WsConstants.KEY_CONNECTION_TYPE, this.U);     // Catch: Throwable -> L17
        r1.put("isReversegeo", this.X);     // Catch: Throwable -> L17
        r1.put("geoLanguage", this.Y);     // Catch: Throwable -> L17
        return r1;
    L13:
        if (a5.t(r1, "offpct") == false) goto L15;
        r1.put("offpct", this.V.getString("offpct"));     // Catch: Throwable -> L17
        goto L15
    L6:
        if (r4 == 2) goto L15;
        if (r4 == 3) goto L15;
        return r1;
    L17:
        th = move-exception;
        s4.h(th, "AmapLoc", "toStr");
        return null;
    }

    @Override // com.amap.api.location.AMapLocation
    public final String V0() {
        return W0(1);
    }

    @Override // com.amap.api.location.AMapLocation
    public final String W0(int r3) {
        JSONObject r4 = U0(r3);     // Catch: Throwable -> L5
        r4.put("nb", this.a0);     // Catch: Throwable -> L5
    L7:
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4.toString();
    L5:
        th = move-exception;
        s4.h(th, "AMapLocation", "toStr part2");
        r4 = null;
        goto L7
    }

    public final String X0() {
        return this.P;
    }

    public final void Y0(int r1) {
        this.T = r1;
    }

    public final void Z0(String r1) {
        this.P = r1;
    }

    public final void a1(JSONObject r1) {
        this.V = r1;
    }

    public final void b1(boolean r1) {
        this.X = r1;
    }

    public final String c1() {
        return this.Q;
    }

    public final void d1(String r1) {
        this.Q = r1;
    }

    public final void e1(JSONObject r7) {
        s4.f(this, r7);     // Catch: Throwable -> L16
        k1(r7.optString(WsConstants.KEY_CONNECTION_TYPE, this.U));     // Catch: Throwable -> L16
        i1(r7.optString("retype", this.S));     // Catch: Throwable -> L16
        u1(r7.optString("cens", this.Z));     // Catch: Throwable -> L16
        o1(r7.optString("desc", this.O));     // Catch: Throwable -> L16
        g1(r7.optString("coord", String.valueOf(this.R)));     // Catch: Throwable -> L16
        r1(r7.optString("mcell", this.W));     // Catch: Throwable -> L16
        b1(r7.optBoolean("isReversegeo", this.X));     // Catch: Throwable -> L16
        m1(r7.optString("geoLanguage", this.Y));     // Catch: Throwable -> L16
        if (a5.t(r7, "poiid") == false) goto L7;
        w0(r7.optString("poiid"));     // Catch: Throwable -> L16
    L7:
        if (a5.t(r7, "pid") == false) goto L10;
        w0(r7.optString("pid"));     // Catch: Throwable -> L16
    L10:
        if (a5.t(r7, "floor") == false) goto L13;
        H0(r7.optString("floor"));     // Catch: Throwable -> L16
    L13:
        if (a5.t(r7, "flr") == false) goto L21;
        H0(r7.optString("flr"));     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L16:
        th = move-exception;
        s4.h(th, "AmapLoc", "AmapLoc");
    }

    public final int f1() {
        return this.R;
    }

    public final void g1(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L10:
        int r3 = -1;
    L11:
        this.R = r3;
        if (this.R != 0) goto L16;
        String r4 = "WGS84";
    L14:
        super.A0(r4);
        return;
    L16:
        r4 = "GCJ02";
        goto L14
    L5:
        if (r2.equals(BDLocationException.ERROR_TIMEOUT) == false) goto L8;
        r3 = 0;
        goto L11
    L8:
        if (r2.equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L10;
        r3 = 1;
        goto L11
    }

    public final String h1() {
        return this.S;
    }

    public final void i1(String r1) {
        this.S = r1;
    }

    public final String j1() {
        return this.U;
    }

    public final void k1(String r1) {
        this.U = r1;
    }

    public final JSONObject l1() {
        return this.V;
    }

    public final void m1(String r1) {
        this.Y = r1;
    }

    public final String n1() {
        return this.W;
    }

    public final void o1(String r1) {
        this.O = r1;
    }

    public final ew p1() {
        String r0 = n1();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return null;
    L5:
        String[] r1 = r0.split(",");
        if (r1.length == 3) goto L8;
        return null;
    L8:
        ew r2 = new ew("");
        r2.setProvider(getProvider());
        r2.setLongitude(a5.I(r1[0]));
        r2.setLatitude(a5.I(r1[1]));
        r2.setAccuracy(a5.N(r1[2]));
        r2.y0(P());
        r2.t0(K());
        r2.B0(R());
        r2.P0(a0());
        r2.x0(O());
        r2.setTime(getTime());
        r2.k1(j1());
        r2.g1(String.valueOf(f1()));
        if (a5.q(r2) == true) goto L11;
        return null;
    L11:
        return r2;
    }

    public final void q1(String r1) {
        this.a0 = r1;
    }

    public final boolean s1() {
        return this.X;
    }

    public final String t1() {
        return this.Y;
    }

    public final String v1() {
        return this.a0;
    }

    public final int w1() {
        return this.T;
    }
}
