package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.r.d;
import com.bytedance.common.wschannel.u.c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelMsg implements Parcelable {
    public static final Parcelable.Creator<WsChannelMsg> CREATOR = null;
    public static WsChannelMsg x;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f3610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3612i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<MsgHeader> f3613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f3614k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f3615l;
    private byte[] m;
    private ComponentName n;
    private int o;
    private NewMsgTimeHolder p;
    public transient long q;
    private String r;
    private boolean s;
    private d.a t;
    private String u;
    private String v;
    private String w;

    public static class MsgHeader implements Parcelable {
        public static final Parcelable.Creator<MsgHeader> CREATOR = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f3616f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        String f3617g;

        static class a implements Parcelable.Creator<MsgHeader> {
            a() {
            }

            public MsgHeader a(Parcel r2) {
                MsgHeader r1 = new MsgHeader();
                r1.f3616f = r2.readString();
                r1.f3617g = r2.readString();
                return r1;
            }

            public MsgHeader[] b(int r1) {
                return new MsgHeader[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ MsgHeader createFromParcel(Parcel r1) {
                return a(r1);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ MsgHeader[] newArray(int r1) {
                return b(r1);
            }
        }

        static {
            CREATOR = new a();
        }

        public MsgHeader() {
        }

        public String b() {
            return this.f3616f;
        }

        public String d() {
            return this.f3617g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void e(String r1) {
            this.f3616f = r1;
        }

        public void f(String r1) {
            this.f3617g = r1;
        }

        @NonNull
        public String toString() {
            return "MsgHeader{key='" + this.f3616f + "', value='" + this.f3617g + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeString(this.f3616f);
            r1.writeString(this.f3617g);
        }
    }

    static class a implements Parcelable.Creator<WsChannelMsg> {
        a() {
        }

        public WsChannelMsg a(Parcel r1) {
            return new WsChannelMsg(r1);
        }

        public WsChannelMsg[] b(int r1) {
            return new WsChannelMsg[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WsChannelMsg createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WsChannelMsg[] newArray(int r1) {
            return b(r1);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, String> f3619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f3620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f3621d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f3622e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte[] f3623f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f3624g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f3625h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f3626i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private ComponentName f3627j;

        public b(int r2) {
            this.f3619b = new HashMap();
            this.f3624g = "";
            this.f3625h = "";
            this.f3618a = r2;
        }

        public static b c(int r1) {
            return new b(r1);
        }

        public b a(String r2, String r3) {
            this.f3619b.put(r2, r3);
            return this;
        }

        public WsChannelMsg b() {
            if (this.f3618a <= 0) goto L23;
            if (this.f3621d < 0) goto L21;
            if (this.f3622e <= 0) goto L19;
            if (this.f3623f == null) goto L17;
            ArrayList r9 = new ArrayList();
            Iterator<Map.Entry<String, String>> r0 = this.f3619b.entrySet().iterator();
        L12:
            if (r0.hasNext() == false) goto L15;
            Map.Entry<String, String> r1 = r0.next();
            MsgHeader r2 = new MsgHeader();
            r2.e(r1.getKey());
            r2.f(r1.getValue());
            r9.add(r2);
            goto L12
        L15:
            return new WsChannelMsg(this.f3618a, this.f3626i, this.f3620c, this.f3621d, this.f3622e, r9, this.f3625h, this.f3624g, this.f3623f, this.f3627j);
        L17:
            throw new IllegalArgumentException("illegal payload");
        L19:
            throw new IllegalArgumentException("illegal method");
        L21:
            throw new IllegalArgumentException("illegal service");
        L23:
            throw new IllegalArgumentException("illegal channelId");
        }

        public b d(long r1) {
            this.f3620c = r1;
            return this;
        }

        public b e(int r1) {
            this.f3622e = r1;
            return this;
        }

        public b f(byte[] r1) {
            this.f3623f = r1;
            return this;
        }

        public b g(String r1) {
            this.f3625h = r1;
            return this;
        }

        public b h(String r1) {
            this.f3624g = r1;
            return this;
        }

        public b i(long r1) {
            this.f3626i = r1;
            return this;
        }

        public b j(int r1) {
            this.f3621d = r1;
            return this;
        }
    }

    static {
        CREATOR = new a();
        x = new WsChannelMsg();
    }

    @Deprecated
    public WsChannelMsg() {
        this.t = d.a.f3675g;
    }

    public WsChannelMsg(int r2, long r3, long r5, int r7, int r8, List<MsgHeader> r9, String r10, String r11, byte[] r12, ComponentName r13) {
        this.t = d.a.f3675g;
        this.o = r2;
        this.f3609f = r3;
        this.f3610g = r5;
        this.f3611h = r7;
        this.f3612i = r8;
        this.f3613j = r9;
        this.f3614k = r10;
        this.f3615l = r11;
        this.m = r12;
        this.n = r13;
    }

    protected WsChannelMsg(Parcel r3) {
        this.t = d.a.f3675g;
        this.f3609f = r3.readLong();
        this.f3610g = r3.readLong();
        this.f3611h = r3.readInt();
        this.f3612i = r3.readInt();
        this.f3613j = r3.createTypedArrayList(MsgHeader.CREATOR);
        this.f3614k = r3.readString();
        this.f3615l = r3.readString();
        this.m = r3.createByteArray();
        this.n = (ComponentName) r3.readParcelable(ComponentName.class.getClassLoader());
        this.o = r3.readInt();
        this.r = r3.readString();
        if (r3.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.s = r0;
        this.t = d.a.b(r3.readInt());
        this.p = (NewMsgTimeHolder) r3.readParcelable(NewMsgTimeHolder.class.getClassLoader());
        this.u = r3.readString();
        this.w = r3.readString();
        this.v = r3.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    protected WsChannelMsg(WsChannelMsg r3) {
        this.t = d.a.f3675g;
        M(r3.q());
        A(r3.d());
        O(r3.s());
        C(r3.f());
        D(r3.g());
        G(r3.i());
        H(r3.j());
        K(r3.l());
        y(r3.c());
        L(r3.p());
        F(r3.h());
        z(r3.x());
        Q(r3.w());
        P(r3.v());
        B(r3.u);
        N(r3.w);
        E(r3.v);
    }

    public void A(long r1) {
        this.f3610g = r1;
    }

    public void B(String r1) {
        this.u = r1;
    }

    public void C(int r1) {
        this.f3612i = r1;
    }

    public void D(List<MsgHeader> r1) {
        this.f3613j = r1;
    }

    public void E(String r1) {
        this.v = r1;
    }

    public void F(NewMsgTimeHolder r1) {
        this.p = r1;
    }

    public void G(byte[] r1) {
        this.m = r1;
    }

    public void H(String r1) {
        this.f3614k = r1;
    }

    public void K(String r1) {
        this.f3615l = r1;
    }

    public void L(ComponentName r1) {
        this.n = r1;
    }

    public void M(long r1) {
        this.f3609f = r1;
    }

    public void N(String r1) {
        this.w = r1;
    }

    public void O(int r1) {
        this.f3611h = r1;
    }

    public void P(d.a r1) {
        this.t = r1;
    }

    public void Q(String r1) {
        this.r = r1;
    }

    @NonNull
    public Map<String, String> R() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("seqId", String.valueOf(this.f3609f));
        r0.put("logId", String.valueOf(this.f3610g));
        r0.put("service", String.valueOf(this.f3611h));
        r0.put("method", String.valueOf(this.f3612i));
        r0.put("payloadEncoding", this.f3614k);
        r0.put("payloadType", this.f3615l);
        r0.put(WsConstants.KEY_PAYLOAD_MD5, c.b(MessageDigest.getInstance("MD5").digest(this.m), ""));     // Catch: NoSuchAlgorithmException -> L5
    L7:
        r0.put("channelId", String.valueOf(this.o));
        Iterator<MsgHeader> r3 = this.f3613j.iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        MsgHeader r1 = r3.next();
        r0.put(r1.f3616f, r1.f3617g);
        goto L9
    L11:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void b(String r2, String r3) {
        MsgHeader r0 = new MsgHeader();
        r0.e(r2);
        r0.f(r3);
        this.f3613j.add(r0);
    }

    public int c() {
        return this.o;
    }

    public long d() {
        return this.f3610g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.u;
    }

    public int f() {
        return this.f3612i;
    }

    public List<MsgHeader> g() {
        return this.f3613j;
    }

    public NewMsgTimeHolder h() {
        return this.p;
    }

    public byte[] i() {
        if (this.m != null) goto L6;
        this.m = new byte[1];
    L6:
        return this.m;
    }

    public String j() {
        return this.f3614k;
    }

    public String l() {
        return this.f3615l;
    }

    public ComponentName p() {
        return this.n;
    }

    public long q() {
        return this.f3609f;
    }

    public int s() {
        return this.f3611h;
    }

    @NonNull
    public String toString() {
        return "WsChannelMsg{, channelId = " + this.o + ", logId=" + this.f3610g + ", service=" + this.f3611h + ", method=" + this.f3612i + ", msgHeaders=" + this.f3613j + ", payloadEncoding='" + this.f3614k + "', payloadType='" + this.f3615l + "', payload=" + Arrays.toString(this.m) + ", replayToComponentName=" + this.n + '}';
    }

    public d.a v() {
        return this.t;
    }

    @Nullable
    public String w() {
        return this.r;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.f3609f);
        r3.writeLong(this.f3610g);
        r3.writeInt(this.f3611h);
        r3.writeInt(this.f3612i);
        r3.writeTypedList(this.f3613j);
        r3.writeString(this.f3614k);
        r3.writeString(this.f3615l);
        r3.writeByteArray(this.m);
        r3.writeParcelable(this.n, r4);
        r3.writeInt(this.o);
        r3.writeString(this.r);
        r3.writeByte(this.s ? 1 : 0);
        r3.writeInt(this.t.a());
        r3.writeParcelable(this.p, r4);
        r3.writeString(this.u);
        r3.writeString(this.w);
        r3.writeString(this.v);
    }

    public boolean x() {
        return this.s;
    }

    public void y(int r1) {
        this.o = r1;
    }

    public void z(boolean r1) {
        this.s = r1;
    }
}
