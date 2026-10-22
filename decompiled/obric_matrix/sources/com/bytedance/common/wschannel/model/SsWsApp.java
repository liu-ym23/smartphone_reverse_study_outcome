package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.u.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public class SsWsApp implements IWsApp, Parcelable {
    public static final Parcelable.Creator<SsWsApp> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f3588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f3589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f3591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f3593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f3594l;
    private int m;
    private int n;
    boolean o;
    List<Integer> p;
    String q;
    int r;
    boolean s;
    private int t;
    private String u;

    static class a implements Parcelable.Creator<SsWsApp> {
        a() {
        }

        public SsWsApp a(Parcel r1) {
            return new SsWsApp(r1);
        }

        public SsWsApp[] b(int r1) {
            return new SsWsApp[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SsWsApp createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SsWsApp[] newArray(int r1) {
            return b(r1);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f3595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f3596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f3597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f3598d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f3599e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f3600f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f3601g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f3602h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f3603i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<String> f3604j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Map<String, String> f3605k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f3606l;
        List<Integer> m;
        String n;
        int o;
        boolean p;

        public b() {
            this.m = new ArrayList();
        }

        static /* synthetic */ Map a(b r0) {
            return r0.f3605k;
        }

        public SsWsApp b() {
            return new SsWsApp(this.f3603i, this.f3595a, this.f3596b, this.f3597c, this.f3604j, this.f3598d, this.f3599e, this.f3600f, this.f3601g, this.f3602h, this.f3606l, this.m, this.n, this.o, this.p, this, null);
        }

        public SsWsApp c(JSONObject r1) {
            SsWsApp r0 = new SsWsApp();
            r0.b(r1);
            return r0;
        }

        public b d(boolean r1) {
            this.p = r1;
            return this;
        }

        public b e(boolean r1) {
            this.f3606l = r1;
            return this;
        }

        public b f(int r1) {
            this.f3595a = r1;
            return this;
        }

        public b g(String r1) {
            this.f3601g = r1;
            return this;
        }

        public b h(int r1) {
            this.f3598d = r1;
            return this;
        }

        public b i(int r1) {
            this.f3603i = r1;
            return this;
        }

        public b j(List<String> r1) {
            this.f3604j = r1;
            return this;
        }

        public b k(String r1) {
            this.f3596b = r1;
            return this;
        }

        public b l(String r1) {
            this.f3602h = r1;
            return this;
        }

        public b m(int r1) {
            this.f3600f = r1;
            return this;
        }

        public b n(Map<String, String> r1) {
            this.f3605k = r1;
            return this;
        }

        public b o(String r1) {
            this.f3597c = r1;
            return this;
        }

        public b p(int r1) {
            this.f3599e = r1;
            return this;
        }

        public b q(String r1) {
            this.n = r1;
            return this;
        }

        public b r(List<Integer> r1) {
            this.m = r1;
            return this;
        }

        public b s(int r1) {
            this.o = r1;
            return this;
        }
    }

    static {
        CREATOR = new a();
    }

    protected SsWsApp() {
        this.f3588f = new HashMap();
        this.f3589g = new ArrayList();
        this.p = new ArrayList();
    }

    private SsWsApp(int r4, int r5, String r6, String r7, List<String> r8, int r9, int r10, int r11, String r12, String r13, boolean r14, List<Integer> r15, String r16, int r17, boolean r18, b r19) {
        this.f3588f = new HashMap();
        this.f3589g = new ArrayList();
        this.p = new ArrayList();
        this.f3592j = r5;
        this.f3590h = r4;
        this.f3593k = r6;
        this.f3594l = r7;
        if (r8 == null) goto L5;
        this.f3589g.addAll(r8);
    L5:
        this.m = r9;
        this.n = r10;
        this.t = r11;
        this.u = r12;
        this.f3591i = r13;
        if (b.a(r19) == null) goto L8;
        this.f3588f.putAll(b.a(r19));
    L8:
        this.o = r14;
        this.p = r15;
        this.q = r16;
        this.r = r17;
        this.s = r18;
    }

    /* synthetic */ SsWsApp(int r1, int r2, String r3, String r4, List r5, int r6, int r7, int r8, String r9, String r10, boolean r11, List r12, String r13, int r14, boolean r15, b r16, a r17) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    }

    protected SsWsApp(Parcel r7) {
        this.f3588f = new HashMap();
        this.f3589g = new ArrayList();
        this.p = new ArrayList();
        int r0 = r7.readInt();
        this.f3588f = new HashMap(r0);
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.f3588f.put(r7.readString(), r7.readString());
        r2 = r2 + 1;
        goto L3
    L5:
        this.f3589g = r7.createStringArrayList();
        this.f3590h = r7.readInt();
        this.f3591i = r7.readString();
        this.f3592j = r7.readInt();
        this.f3593k = r7.readString();
        this.f3594l = r7.readString();
        this.m = r7.readInt();
        this.n = r7.readInt();
        this.t = r7.readInt();
        this.u = r7.readString();
        if (r7.readByte() == 0) goto L8;
        boolean r3 = true;
    L9:
        this.o = r3;
        int r4 = r7.readInt();
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L12;
        this.p.add(Integer.valueOf(r7.readInt()));
        r5 = r5 + 1;
        goto L10
    L12:
        this.q = r7.readString();
        this.r = r7.readInt();
        if (r7.readByte() == 0) goto L15;
        r1 = true;
    L15:
        this.s = r1;
        return;
    L8:
        r3 = false;
        goto L9
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    @Nullable
    public String I() {
        return this.q;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public boolean J() {
        return this.s;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int a() {
        return this.m;
    }

    public void b(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        this.f3590h = r7.optInt(WsConstants.KEY_CHANNEL_ID);
        this.f3592j = r7.optInt(IBdInstall.PARAM_APP_ID);
        this.f3593k = r7.optString(WsConstants.KEY_DEVICE_ID);
        this.f3594l = r7.optString("install_id");
        this.m = r7.optInt(WsConstants.KEY_APP_VERSION);
        this.n = r7.optInt(WsConstants.KEY_PLATFORM);
        this.t = r7.optInt(WsConstants.KEY_FPID);
        this.u = r7.optString("app_kay");
        this.f3591i = r7.optString(WsConstants.KEY_EXTRA);
        JSONArray r0 = r7.optJSONArray("urls");
        this.f3589g.clear();
        int r1 = 0;
        if (r0 == null) goto L9;
        int r2 = r0.length();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        this.f3589g.add(r0.optString(r3));
        r3 = r3 + 1;
    L9:
        this.o = r7.optBoolean(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE);
        JSONArray r4 = r7.optJSONArray(WsConstants.KEY_SERVICE_ID_LIST);
        this.p.clear();
        if (r4 == null) goto L14;
        int r5 = r4.length();
    L12:
        if (r1 >= r5) goto L14;
        this.p.add(Integer.valueOf(r4.optInt(r1)));
        r1 = r1 + 1;
    L14:
        this.q = r7.optString(WsConstants.KEY_PRIVATE_PROTOCOL_URL);
        this.r = r7.optInt(WsConstants.KEY_TRANSPORT_MODE);
        this.s = r7.optBoolean(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET);
        this.f3588f.clear();
        this.f3588f.putAll(c.m(r7.optJSONObject("headers")));
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int b0() {
        return this.t;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int c() {
        return this.f3590h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L68:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L68;
        SsWsApp r6 = (SsWsApp) r5;
        if (this.f3590h == r6.f3590h) goto L14;
        return false;
    L14:
        if (this.f3592j == r6.f3592j) goto L17;
        return false;
    L17:
        if (this.m == r6.m) goto L20;
        return false;
    L20:
        if (this.n == r6.n) goto L23;
        return false;
    L23:
        if (this.t == r6.t) goto L26;
        return false;
    L26:
        if (this.f3588f.equals(r6.f3588f) == true) goto L28;
        return false;
    L28:
        List<String> r2 = this.f3589g;
        if (r2 == null) goto L34;
        if (r2.equals(r6.f3589g) == false) goto L35;
    L36:
        String r3 = this.f3591i;
        if (r3 == null) goto L42;
        if (r3.equals(r6.f3591i) == false) goto L43;
    L44:
        String r4 = this.f3593k;
        if (r4 == null) goto L50;
        if (r4.equals(r6.f3593k) == false) goto L51;
    L52:
        String r7 = this.f3594l;
        if (r7 == null) goto L58;
        if (r7.equals(r6.f3594l) == false) goto L59;
    L60:
        String r8 = this.u;
        if (r8 == null) goto L64;
        return r8.equals(r6.u);
    L64:
        if (r6.u != null) goto L67;
        return true;
    L67:
        return false;
    L59:
        return false;
    L58:
        if (r6.f3594l == null) goto L60;
    L51:
        return false;
    L50:
        if (r6.f3593k == null) goto L52;
    L43:
        return false;
    L42:
        if (r6.f3591i == null) goto L44;
    L35:
        return false;
    L34:
        if (r6.f3589g == null) goto L36;
        goto L35
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public List<String> f0() {
        return this.f3589g;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getAppId() {
        return this.f3592j;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getDeviceId() {
        return this.f3593k;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getExtra() {
        return this.f3591i;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getInstallId() {
        return this.f3594l;
    }

    public int hashCode() {
        int r0 = this.f3588f.hashCode() * 31;
        List<String> r1 = this.f3589g;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((r0 + r3) * 31) + this.f3590h) * 31;
        String r5 = this.f3591i;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((r4 + r6) * 31) + this.f3592j) * 31;
        String r8 = this.f3593k;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f3594l;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (((((((r10 + r12) * 31) + this.m) * 31) + this.n) * 31) + this.t) * 31;
        String r14 = this.u;
        if (r14 == null) goto L22;
        r2 = r14.hashCode();
    L22:
        return r13 + r2;
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int k() {
        return this.r;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public JSONObject m() {
        JSONObject r0 = new JSONObject();
        r0.put(WsConstants.KEY_CHANNEL_ID, this.f3590h);
        r0.put(IBdInstall.PARAM_APP_ID, this.f3592j);
        r0.put(WsConstants.KEY_DEVICE_ID, this.f3593k);
        r0.put("install_id", this.f3594l);
        JSONArray r1 = new JSONArray();
        List<String> r2 = this.f3589g;
        if (r2 == null) goto L8;
        Iterator<String> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r1.put(r3.next());
    L8:
        r0.put("headers", c.n(this.f3588f));
        r0.put("urls", r1);
        r0.put(WsConstants.KEY_APP_VERSION, this.m);
        r0.put(WsConstants.KEY_PLATFORM, this.n);
        r0.put(WsConstants.KEY_FPID, this.t);
        r0.put("app_kay", this.u);
        r0.put(WsConstants.KEY_EXTRA, this.f3591i);
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, this.o);
        JSONArray r4 = new JSONArray();
        List<Integer> r5 = this.p;
        if (r5 == null) goto L14;
        Iterator<Integer> r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        r4.put(r6.next());
    L14:
        r0.put(WsConstants.KEY_SERVICE_ID_LIST, r4);
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_URL, this.q);
        r0.put(WsConstants.KEY_TRANSPORT_MODE, this.r);
        r0.put(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET, this.s);
        return r0;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public boolean n() {
        return this.o;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int o() {
        return this.n;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String r() {
        return this.u;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public Map<String, String> t() {
        return this.f3588f;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public List<Integer> u() {
        return this.p;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.f3588f.size());
        Iterator<Map.Entry<String, String>> r5 = this.f3588f.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<String, String> r0 = r5.next();
        r3.writeString(r0.getKey());
        r3.writeString(r0.getValue());
        goto L4
    L6:
        r3.writeStringList(this.f3589g);
        r3.writeInt(this.f3590h);
        r3.writeString(this.f3591i);
        r3.writeInt(this.f3592j);
        r3.writeString(this.f3593k);
        r3.writeString(this.f3594l);
        r3.writeInt(this.m);
        r3.writeInt(this.n);
        r3.writeInt(this.t);
        r3.writeString(this.u);
        r3.writeByte(this.o ? 1 : 0);
        r3.writeInt(this.p.size());
        Iterator<Integer> r6 = this.p.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r3.writeInt(r6.next().intValue());
        goto L8
    L10:
        r3.writeString(this.q);
        r3.writeInt(this.r);
        r3.writeByte(this.s ? 1 : 0);
    }
}
