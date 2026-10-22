package com.bytedance.bdinstall.c1;

import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.bdinstall.v0;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f2696a;

    class a implements g<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f2697a;

        a(d r1) {
            this.f2697a = r1;
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ boolean a(String r1, String r2) {
            return h(r1, r2);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ boolean b(String r1) {
            return f(r1);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ String c(String r1, String r2, d r3) {
            return i(r1, r2, r3);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ void d(String r1) {
            j(r1);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ String e() {
            return g();
        }

        public boolean f(String r1) {
            return v0.k(r1);
        }

        public String g() {
            return this.f2697a.b("openudid");
        }

        public boolean h(String r1, String r2) {
            return v0.d(r1, r2);
        }

        public String i(String r1, String r2, d r3) {
            if (r3 != null) goto L5;
            return r1;
        L5:
            return r3.j(r1, r2);
        }

        public void j(String r2) {
            this.f2697a.a("openudid", r2);
        }
    }

    class b implements g<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f2698a;

        b(d r1) {
            this.f2698a = r1;
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ boolean a(String r1, String r2) {
            return h(r1, r2);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ boolean b(String r1) {
            return f(r1);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ String c(String r1, String r2, d r3) {
            return i(r1, r2, r3);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ void d(String r1) {
            j(r1);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ String e() {
            return g();
        }

        public boolean f(String r1) {
            return v0.k(r1);
        }

        public String g() {
            return this.f2698a.b("clientudid");
        }

        public boolean h(String r1, String r2) {
            return v0.d(r1, r2);
        }

        public String i(String r1, String r2, d r3) {
            if (r3 != null) goto L5;
            return r1;
        L5:
            return r3.i(r1, r2);
        }

        public void j(String r2) {
            this.f2698a.a("clientudid", r2);
        }
    }

    class c implements g<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f2699a;

        c(d r1) {
            this.f2699a = r1;
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ boolean a(String r1, String r2) {
            return h(r1, r2);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ boolean b(String r1) {
            return f(r1);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ String c(String r1, String r2, d r3) {
            return i(r1, r2, r3);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ void d(String r1) {
            j(r1);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ String e() {
            return g();
        }

        public boolean f(String r1) {
            if (TextUtils.isEmpty(r1) == false) goto L5;
        L7:
            return false;
        L5:
            if (TextUtils.equals(r1, EnvironmentCompat.MEDIA_UNKNOWN) == true) goto L7;
            return true;
        }

        public String g() {
            return this.f2699a.b("serial_number");
        }

        public boolean h(String r1, String r2) {
            return v0.d(r1, r2);
        }

        public String i(String r1, String r2, d r3) {
            if (r3 != null) goto L5;
            return r1;
        L5:
            return r3.k(r1, r2);
        }

        public void j(String r2) {
            this.f2699a.a("serial_number", r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdinstall.c1.d$d, reason: collision with other inner class name */
    class C0079d implements g<String[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f2700a;

        C0079d(d r1) {
            this.f2700a = r1;
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ boolean a(String[] r1, String[] r2) {
            return h(r1, r2);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ boolean b(String[] r1) {
            return f(r1);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ String[] c(String[] r1, String[] r2, d r3) {
            return i(r1, r2, r3);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ void d(String[] r1) {
            j(r1);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ String[] e() {
            return g();
        }

        public boolean f(String[] r1) {
            if (r1 != null) goto L4;
        L6:
            return false;
        L4:
            if (r1.length <= 0) goto L6;
            return true;
        }

        public String[] g() {
            return this.f2700a.e("sim_serial_number");
        }

        public boolean h(String[] r9, String[] r10) {
            if (r9 != r10) goto L6;
            return true;
        L6:
            if (r9 == null) goto L27;
            if (r10 == null) goto L27;
            if (r9.length == r10.length) goto L12;
            return false;
        L12:
            int r1 = r9.length;
            int r2 = 0;
        L13:
            if (r2 >= r1) goto L26;
            String r3 = r9[r2];
            int r4 = r10.length;
            int r5 = 0;
            boolean r6 = false;
        L15:
            if (r5 >= r4) goto L23;
            if (v0.d(r10[r5], r3) == true) goto L21;
            if (r6 == true) goto L21;
            r6 = false;
        L22:
            r5 = r5 + 1;
        L21:
            r6 = true;
            goto L22
        L23:
            if (r6 == false) goto L24;
            r2 = r2 + 1;
            goto L13
        L24:
            return false;
        L26:
            return true;
        L27:
            return false;
        }

        public String[] i(String[] r1, String[] r2, d r3) {
            if (r3 != null) goto L5;
            return r1;
        L5:
            return r3.h(r1, r2);
        }

        public void j(String[] r2) {
            this.f2700a.d("sim_serial_number", r2);
        }
    }

    class e implements g<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f2701a;

        e(d r1) {
            this.f2701a = r1;
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ boolean a(String r1, String r2) {
            return h(r1, r2);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ boolean b(String r1) {
            return f(r1);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ String c(String r1, String r2, d r3) {
            return i(r1, r2, r3);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ void d(String r1) {
            j(r1);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ String e() {
            return g();
        }

        public boolean f(String r1) {
            return v0.k(r1);
        }

        public String g() {
            return this.f2701a.b("udid");
        }

        public boolean h(String r1, String r2) {
            return v0.d(r1, r2);
        }

        public String i(String r1, String r2, d r3) {
            if (r3 != null) goto L5;
            return r1;
        L5:
            return r3.l(r1, r2);
        }

        public void j(String r2) {
            this.f2701a.a("udid", r2);
        }
    }

    class f implements g<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f2702a;

        f(d r1) {
            this.f2702a = r1;
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ boolean a(String r1, String r2) {
            return h(r1, r2);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ boolean b(String r1) {
            return f(r1);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ String c(String r1, String r2, d r3) {
            return i(r1, r2, r3);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ void d(String r1) {
            j(r1);
        }

        @Override // com.bytedance.bdinstall.c1.d.g
        public /* bridge */ /* synthetic */ String e() {
            return g();
        }

        public boolean f(String r1) {
            return !TextUtils.isEmpty(r1);
        }

        public String g() {
            return this.f2702a.b(WsConstants.KEY_DEVICE_ID);
        }

        public boolean h(String r1, String r2) {
            return v0.d(r1, r2);
        }

        public String i(String r1, String r2, d r3) {
            if (r3 != null) goto L5;
            return r1;
        L5:
            return r3.c(r1, r2);
        }

        public void j(String r2) {
            this.f2702a.a(WsConstants.KEY_DEVICE_ID, r2);
        }
    }

    interface g<L> {
        boolean a(L r1, L r2);

        boolean b(L r1);

        L c(L r1, L r2, d r3);

        void d(L r1);

        L e();
    }

    public d() {
    }

    private d f() {
        return this.f2696a;
    }

    private <T> T g(T r4, T r5, g<T> r6) {
        if (r6 == null) goto L26;
        d r3 = f();
        T r0 = r6.e();
        boolean r1 = r6.b(r4);
        boolean r2 = r6.b(r0);
        if (r1 == true) goto L7;
        if (r2 == false) goto L7;
        r4 = r0;
    L7:
        if (r3 == null) goto L12;
        T r7 = r6.c(r4, r5, r3);
        if (r6.a(r7, r0) == true) goto L11;
        r6.d(r7);
    L11:
        return r7;
    L12:
        boolean r8 = false;
        if (r1 == true) goto L16;
        if (r2 == true) goto L16;
        r8 = true;
    L17:
        if (r8 == true) goto L19;
    L20:
        if (r1 == true) goto L22;
    L24:
        return r5;
    L22:
        if (r6.a(r5, r0) == true) goto L24;
    L23:
        r6.d(r5);
        goto L24
    L19:
        if (r6.b(r5) == true) goto L23;
    L16:
        r5 = r4;
        goto L17
    L26:
        throw new IllegalArgumentException("agent == null");
    }

    @Override // com.bytedance.bdinstall.c1.i
    public abstract void a(String r1, String r2);

    @Override // com.bytedance.bdinstall.c1.i
    public abstract String b(String r1);

    @Override // com.bytedance.bdinstall.c1.i
    public String c(String r2, String r3) {
        return (String) g(r2, r3, new f(this));
    }

    protected abstract void d(String r1, String[] r2);

    protected abstract String[] e(String r1);

    public String[] h(String[] r2, String[] r3) {
        return (String[]) g(r2, r3, new C0079d(this));
    }

    public String i(String r2, String r3) {
        return (String) g(r2, r3, new b(this));
    }

    public String j(String r2, String r3) {
        return (String) g(r2, r3, new a(this));
    }

    public String k(String r2, String r3) {
        return (String) g(r2, r3, new c(this));
    }

    public String l(String r2, String r3) {
        return (String) g(r2, r3, new e(this));
    }

    void m(d r1) {
        this.f2696a = r1;
    }
}
