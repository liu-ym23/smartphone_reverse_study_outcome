package d.e.b.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Externalizable {
    private i A;
    private boolean B;
    private i C;
    private boolean D;
    private i E;
    private boolean F;
    private i G;
    private boolean H;
    private i I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f16599J;
    private i K;
    private boolean L;
    private i M;
    private String N;
    private int O;
    private String P;
    private boolean Q;
    private String R;
    private boolean S;
    private String T;
    private boolean U;
    private String V;
    private boolean W;
    private String X;
    private boolean Y;
    private String Z;
    private boolean a0;
    private List<f> b0;
    private List<f> c0;
    private boolean d0;
    private boolean e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16600f;
    private String f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private i f16601g;
    private boolean g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f16602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private i f16603i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16604j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private i f16605k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f16606l;
    private i m;
    private boolean n;
    private i o;
    private boolean p;
    private i q;
    private boolean r;
    private i s;
    private boolean t;
    private i u;
    private boolean v;
    private i w;
    private boolean x;
    private i y;
    private boolean z;

    public g() {
        this.f16601g = null;
        this.f16603i = null;
        this.f16605k = null;
        this.m = null;
        this.o = null;
        this.q = null;
        this.s = null;
        this.u = null;
        this.w = null;
        this.y = null;
        this.A = null;
        this.C = null;
        this.E = null;
        this.G = null;
        this.I = null;
        this.K = null;
        this.M = null;
        this.N = "";
        this.O = 0;
        this.P = "";
        this.R = "";
        this.T = "";
        this.V = "";
        this.X = "";
        this.Z = "";
        this.a0 = false;
        this.b0 = new ArrayList();
        this.c0 = new ArrayList();
        this.d0 = false;
        this.f0 = "";
        this.g0 = false;
    }

    public g A(String r1) {
        this.P = r1;
        return this;
    }

    public g B(String r2) {
        this.e0 = true;
        this.f0 = r2;
        return this;
    }

    public g C(boolean r1) {
        this.d0 = r1;
        return this;
    }

    public g D(i r2) {
        Objects.requireNonNull(r2);
        this.f16604j = true;
        this.f16605k = r2;
        return this;
    }

    public g E(boolean r1) {
        this.g0 = r1;
        return this;
    }

    public g F(String r2) {
        this.S = true;
        this.T = r2;
        return this;
    }

    public g G(String r2) {
        this.W = true;
        this.X = r2;
        return this;
    }

    public g H(String r2) {
        this.Y = true;
        this.Z = r2;
        return this;
    }

    public g I(i r2) {
        Objects.requireNonNull(r2);
        this.L = true;
        this.M = r2;
        return this;
    }

    public g J(i r2) {
        Objects.requireNonNull(r2);
        this.v = true;
        this.w = r2;
        return this;
    }

    public g K(i r2) {
        Objects.requireNonNull(r2);
        this.r = true;
        this.s = r2;
        return this;
    }

    public g L(String r2) {
        this.U = true;
        this.V = r2;
        return this;
    }

    public g M(String r2) {
        this.Q = true;
        this.R = r2;
        return this;
    }

    public g N(i r2) {
        Objects.requireNonNull(r2);
        this.n = true;
        this.o = r2;
        return this;
    }

    public g O(boolean r1) {
        this.a0 = r1;
        return this;
    }

    public g P(i r2) {
        Objects.requireNonNull(r2);
        this.p = true;
        this.q = r2;
        return this;
    }

    public g Q(i r2) {
        Objects.requireNonNull(r2);
        this.D = true;
        this.E = r2;
        return this;
    }

    public g R(i r2) {
        Objects.requireNonNull(r2);
        this.f16599J = true;
        this.K = r2;
        return this;
    }

    public g S(i r2) {
        Objects.requireNonNull(r2);
        this.F = true;
        this.G = r2;
        return this;
    }

    public g T(i r2) {
        Objects.requireNonNull(r2);
        this.f16606l = true;
        this.m = r2;
        return this;
    }

    public g U(i r2) {
        Objects.requireNonNull(r2);
        this.x = true;
        this.y = r2;
        return this;
    }

    public g V(i r2) {
        Objects.requireNonNull(r2);
        this.B = true;
        this.C = r2;
        return this;
    }

    public g W(i r2) {
        Objects.requireNonNull(r2);
        this.t = true;
        this.u = r2;
        return this;
    }

    public int a() {
        return this.O;
    }

    public i b() {
        return this.f16603i;
    }

    public i c() {
        return this.f16601g;
    }

    public String d() {
        return this.N;
    }

    public String e() {
        return this.P;
    }

    public int f() {
        return this.c0.size();
    }

    public i g() {
        return this.f16605k;
    }

    public String h() {
        return this.X;
    }

    public String i() {
        return this.Z;
    }

    public int j() {
        return this.b0.size();
    }

    public i k() {
        return this.w;
    }

    public i l() {
        return this.s;
    }

    public i m() {
        return this.o;
    }

    public i n() {
        return this.q;
    }

    public i o() {
        return this.m;
    }

    public i p() {
        return this.y;
    }

    public i q() {
        return this.C;
    }

    public i r() {
        return this.u;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r6) {
        if (r6.readBoolean() == false) goto L6;
        i r0 = new i();
        r0.readExternal(r6);
        y(r0);
    L6:
        if (r6.readBoolean() == false) goto L9;
        i r1 = new i();
        r1.readExternal(r6);
        x(r1);
    L9:
        if (r6.readBoolean() == false) goto L12;
        i r2 = new i();
        r2.readExternal(r6);
        D(r2);
    L12:
        if (r6.readBoolean() == false) goto L15;
        i r3 = new i();
        r3.readExternal(r6);
        T(r3);
    L15:
        if (r6.readBoolean() == false) goto L18;
        i r4 = new i();
        r4.readExternal(r6);
        N(r4);
    L18:
        if (r6.readBoolean() == false) goto L21;
        i r5 = new i();
        r5.readExternal(r6);
        P(r5);
    L21:
        if (r6.readBoolean() == false) goto L24;
        i r7 = new i();
        r7.readExternal(r6);
        K(r7);
    L24:
        if (r6.readBoolean() == false) goto L27;
        i r8 = new i();
        r8.readExternal(r6);
        W(r8);
    L27:
        if (r6.readBoolean() == false) goto L30;
        i r9 = new i();
        r9.readExternal(r6);
        J(r9);
    L30:
        if (r6.readBoolean() == false) goto L33;
        i r10 = new i();
        r10.readExternal(r6);
        U(r10);
    L33:
        if (r6.readBoolean() == false) goto L36;
        i r11 = new i();
        r11.readExternal(r6);
        w(r11);
    L36:
        if (r6.readBoolean() == false) goto L39;
        i r12 = new i();
        r12.readExternal(r6);
        V(r12);
    L39:
        if (r6.readBoolean() == false) goto L42;
        i r13 = new i();
        r13.readExternal(r6);
        Q(r13);
    L42:
        if (r6.readBoolean() == false) goto L45;
        i r14 = new i();
        r14.readExternal(r6);
        S(r14);
    L45:
        if (r6.readBoolean() == false) goto L48;
        i r15 = new i();
        r15.readExternal(r6);
        u(r15);
    L48:
        if (r6.readBoolean() == false) goto L51;
        i r16 = new i();
        r16.readExternal(r6);
        R(r16);
    L51:
        if (r6.readBoolean() == false) goto L53;
        i r17 = new i();
        r17.readExternal(r6);
        I(r17);
    L53:
        z(r6.readUTF());
        v(r6.readInt());
        A(r6.readUTF());
        if (r6.readBoolean() == false) goto L57;
        M(r6.readUTF());
    L57:
        if (r6.readBoolean() == false) goto L60;
        F(r6.readUTF());
    L60:
        if (r6.readBoolean() == false) goto L63;
        L(r6.readUTF());
    L63:
        if (r6.readBoolean() == false) goto L66;
        G(r6.readUTF());
    L66:
        if (r6.readBoolean() == false) goto L68;
        H(r6.readUTF());
    L68:
        O(r6.readBoolean());
        int r18 = r6.readInt();
        int r19 = 0;
        int r20 = 0;
    L69:
        if (r20 >= r18) goto L71;
        f r21 = new f();
        r21.readExternal(r6);
        this.b0.add(r21);
        r20 = r20 + 1;
        goto L69
    L71:
        int r22 = r6.readInt();
    L72:
        if (r19 >= r22) goto L74;
        f r23 = new f();
        r23.readExternal(r6);
        this.c0.add(r23);
        r19 = r19 + 1;
        goto L72
    L74:
        C(r6.readBoolean());
        if (r6.readBoolean() == false) goto L77;
        B(r6.readUTF());
    L77:
        E(r6.readBoolean());
    }

    @Deprecated
    public int s() {
        return f();
    }

    @Deprecated
    public int t() {
        return j();
    }

    public g u(i r2) {
        Objects.requireNonNull(r2);
        this.H = true;
        this.I = r2;
        return this;
    }

    public g v(int r1) {
        this.O = r1;
        return this;
    }

    public g w(i r2) {
        Objects.requireNonNull(r2);
        this.z = true;
        this.A = r2;
        return this;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r5) {
        r5.writeBoolean(this.f16600f);
        if (this.f16600f == false) goto L5;
        this.f16601g.writeExternal(r5);
    L5:
        r5.writeBoolean(this.f16602h);
        if (this.f16602h == false) goto L8;
        this.f16603i.writeExternal(r5);
    L8:
        r5.writeBoolean(this.f16604j);
        if (this.f16604j == false) goto L11;
        this.f16605k.writeExternal(r5);
    L11:
        r5.writeBoolean(this.f16606l);
        if (this.f16606l == false) goto L14;
        this.m.writeExternal(r5);
    L14:
        r5.writeBoolean(this.n);
        if (this.n == false) goto L17;
        this.o.writeExternal(r5);
    L17:
        r5.writeBoolean(this.p);
        if (this.p == false) goto L20;
        this.q.writeExternal(r5);
    L20:
        r5.writeBoolean(this.r);
        if (this.r == false) goto L23;
        this.s.writeExternal(r5);
    L23:
        r5.writeBoolean(this.t);
        if (this.t == false) goto L26;
        this.u.writeExternal(r5);
    L26:
        r5.writeBoolean(this.v);
        if (this.v == false) goto L29;
        this.w.writeExternal(r5);
    L29:
        r5.writeBoolean(this.x);
        if (this.x == false) goto L32;
        this.y.writeExternal(r5);
    L32:
        r5.writeBoolean(this.z);
        if (this.z == false) goto L35;
        this.A.writeExternal(r5);
    L35:
        r5.writeBoolean(this.B);
        if (this.B == false) goto L38;
        this.C.writeExternal(r5);
    L38:
        r5.writeBoolean(this.D);
        if (this.D == false) goto L41;
        this.E.writeExternal(r5);
    L41:
        r5.writeBoolean(this.F);
        if (this.F == false) goto L44;
        this.G.writeExternal(r5);
    L44:
        r5.writeBoolean(this.H);
        if (this.H == false) goto L47;
        this.I.writeExternal(r5);
    L47:
        r5.writeBoolean(this.f16599J);
        if (this.f16599J == false) goto L50;
        this.K.writeExternal(r5);
    L50:
        r5.writeBoolean(this.L);
        if (this.L == false) goto L53;
        this.M.writeExternal(r5);
    L53:
        r5.writeUTF(this.N);
        r5.writeInt(this.O);
        r5.writeUTF(this.P);
        r5.writeBoolean(this.Q);
        if (this.Q == false) goto L56;
        r5.writeUTF(this.R);
    L56:
        r5.writeBoolean(this.S);
        if (this.S == false) goto L59;
        r5.writeUTF(this.T);
    L59:
        r5.writeBoolean(this.U);
        if (this.U == false) goto L62;
        r5.writeUTF(this.V);
    L62:
        r5.writeBoolean(this.W);
        if (this.W == false) goto L65;
        r5.writeUTF(this.X);
    L65:
        r5.writeBoolean(this.Y);
        if (this.Y == false) goto L68;
        r5.writeUTF(this.Z);
    L68:
        r5.writeBoolean(this.a0);
        int r0 = t();
        r5.writeInt(r0);
        int r1 = 0;
        int r2 = 0;
    L69:
        if (r2 >= r0) goto L71;
        this.b0.get(r2).writeExternal(r5);
        r2 = r2 + 1;
        goto L69
    L71:
        int r3 = s();
        r5.writeInt(r3);
    L72:
        if (r1 >= r3) goto L74;
        this.c0.get(r1).writeExternal(r5);
        r1 = r1 + 1;
        goto L72
    L74:
        r5.writeBoolean(this.d0);
        r5.writeBoolean(this.e0);
        if (this.e0 == false) goto L77;
        r5.writeUTF(this.f0);
    L77:
        r5.writeBoolean(this.g0);
    }

    public g x(i r2) {
        Objects.requireNonNull(r2);
        this.f16602h = true;
        this.f16603i = r2;
        return this;
    }

    public g y(i r2) {
        Objects.requireNonNull(r2);
        this.f16600f = true;
        this.f16601g = r2;
        return this;
    }

    public g z(String r1) {
        this.N = r1;
        return this;
    }
}
