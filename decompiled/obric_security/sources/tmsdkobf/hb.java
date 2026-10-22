package tmsdkobf;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class hb implements Parcelable, Serializable {
    public static final Parcelable.Creator<hb> CREATOR = null;
    public int A;
    public String B;
    public ArrayList C;
    public int D;
    public int E;
    public String F;
    public String G;
    public boolean H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f243J;
    public boolean K;
    public boolean L;
    public int M;
    public long N;
    public long O;
    public String P;
    public String Q;
    public String R;
    public String S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f244a;
    public String b;
    public String c;
    public int d;
    public String e;
    public int f;
    public String g;
    public String h;
    public int i;
    public int j;
    public int k;
    public int l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public int r;
    public String s;
    public List t;
    public int u;
    public int v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    class a implements Parcelable.Creator {
        a() {
        }

        public hb a(Parcel r6) {
            hb r5 = new hb();
            r5.f244a = r6.readString();
            r5.b = r6.readString();
            r5.c = r6.readString();
            r5.d = r6.readInt();
            r5.e = r6.readString();
            r5.f = r6.readInt();
            r5.g = r6.readString();
            r5.h = r6.readString();
            r5.i = r6.readInt();
            r5.B = r6.readString();
            r5.C = r6.createTypedArrayList(eb.CREATOR);
            r5.m = r6.readString();
            r5.j = r6.readInt();
            r5.k = r6.readInt();
            r5.l = r6.readInt();
            r5.m = r6.readString();
            r5.n = r6.readString();
            r5.o = r6.readString();
            r5.q = r6.readString();
            r5.r = r6.readInt();
            r5.s = r6.readString();
            int r0 = r6.readInt();
            if (r0 <= 0) goto L5;
            ArrayList r1 = new ArrayList(r0);
            r5.t = r1;
            r6.readStringList(r1);
        L5:
            r5.u = r6.readInt();
            r5.v = r6.readInt();
            boolean r2 = false;
            if (r6.readByte() != 1) goto L8;
            boolean r3 = true;
        L9:
            r5.w = r3;
            if (r6.readByte() != 1) goto L12;
            boolean r4 = true;
        L13:
            r5.x = r4;
            if (r6.readByte() != 1) goto L16;
            boolean r7 = true;
        L17:
            r5.y = r7;
            if (r6.readByte() != 1) goto L20;
            boolean r8 = true;
        L21:
            r5.z = r8;
            r5.A = r6.readInt();
            r5.E = r6.readInt();
            r5.D = r6.readInt();
            r5.F = r6.readString();
            r5.G = r6.readString();
            if (r6.readByte() != 1) goto L24;
            boolean r9 = true;
        L25:
            r5.H = r9;
            r5.I = r6.readLong();
            if (r6.readByte() != 1) goto L28;
            boolean r10 = true;
        L29:
            r5.f243J = r10;
            if (r6.readByte() != 1) goto L32;
            boolean r11 = true;
        L33:
            r5.K = r11;
            if (r6.readByte() != 1) goto L36;
            r2 = true;
        L36:
            r5.L = r2;
            r5.M = r6.readInt();
            r5.N = r6.readLong();
            r5.O = r6.readLong();
            r5.P = r6.readString();
            r5.Q = r6.readString();
            r5.R = r6.readString();
            r5.S = r6.readString();
            return r5;
        L32:
            r11 = false;
            goto L33
        L28:
            r10 = false;
            goto L29
        L24:
            r9 = false;
            goto L25
        L20:
            r8 = false;
            goto L21
        L16:
            r7 = false;
            goto L17
        L12:
            r4 = false;
            goto L13
        L8:
            r3 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r1) {
            return a(r1);
        }

        public hb[] a(int r1) {
            return new hb[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public hb() {
        this.u = -1;
        this.v = -1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = 0;
        this.D = 0;
        this.E = 0;
        this.K = false;
        this.L = false;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = "";
        this.Q = "";
        this.R = "";
        this.S = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.f244a);
        r3.writeString(this.b);
        r3.writeString(this.c);
        r3.writeInt(this.d);
        r3.writeString(this.e);
        r3.writeInt(this.f);
        r3.writeString(this.g);
        r3.writeString(this.h);
        r3.writeInt(this.i);
        r3.writeString(this.B);
        r3.writeTypedList(this.C);
        r3.writeString(this.m);
        r3.writeInt(this.j);
        r3.writeInt(this.k);
        r3.writeInt(this.l);
        r3.writeString(this.m);
        r3.writeString(this.n);
        r3.writeString(this.o);
        r3.writeString(this.q);
        r3.writeInt(this.r);
        r3.writeString(this.s);
        List r5 = this.t;
        if (r5 != null) goto L5;
    L8:
        r3.writeInt(0);
    L9:
        r3.writeInt(this.u);
        r3.writeInt(this.v);
        r3.writeByte(this.w ? 1 : 0);
        r3.writeByte(this.x ? 1 : 0);
        r3.writeByte(this.y ? 1 : 0);
        r3.writeByte(this.z ? 1 : 0);
        r3.writeInt(this.A);
        r3.writeInt(this.E);
        r3.writeInt(this.D);
        r3.writeString(this.F);
        r3.writeString(this.G);
        r3.writeByte(this.H ? 1 : 0);
        r3.writeLong(this.I);
        r3.writeByte(this.f243J ? 1 : 0);
        r3.writeByte(this.K ? 1 : 0);
        r3.writeByte(this.L ? 1 : 0);
        r3.writeInt(this.M);
        r3.writeLong(this.N);
        r3.writeLong(this.O);
        r3.writeString(this.P);
        r3.writeString(this.Q);
        r3.writeString(this.R);
        r3.writeString(this.S);
        return;
    L5:
        if (r5.size() == 0) goto L8;
        r3.writeInt(this.t.size());
        r3.writeStringList(this.t);
        goto L9
    }
}
