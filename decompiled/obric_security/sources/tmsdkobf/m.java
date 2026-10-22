package tmsdkobf;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes5.dex */
public class m extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseArray f343a;

    public m() {
        this.f343a = new SparseArray();
    }

    public Object a(int r1) {
        return this.f343a.get(r1);
    }

    public String b() {
        return a(this.f343a.get(3));
    }

    public String c() {
        return a(this.f343a.get(26));
    }

    public String d() {
        return a(this.f343a.get(25));
    }

    public String e() {
        return a(this.f343a.get(11));
    }

    public String f() {
        return a(this.f343a.get(21));
    }

    public String g() {
        return a(this.f343a.get(24));
    }

    public Drawable h() {
        Object r1 = this.f343a.get(6);
        if (r1 != null) goto L7;
        return null;
    L7:
        return (Drawable) r1;
    }

    public long i() {
        Object r2 = this.f343a.get(18);
        if (r2 != null) goto L7;
        return 0;
    L7:
        return ((Long) r2).longValue();
    }

    public long j() {
        Object r2 = this.f343a.get(10);
        if (r2 != null) goto L7;
        return 0;
    L7:
        return ((Long) r2).longValue();
    }

    public String k() {
        return a(this.f343a.get(1));
    }

    public String l() {
        return a(this.f343a.get(22));
    }

    public long m() {
        Object r2 = this.f343a.get(9);
        if (r2 != null) goto L7;
        return 0;
    L7:
        return ((Long) r2).longValue();
    }

    public int n() {
        Object r1 = this.f343a.get(2);
        if (r1 != null) goto L7;
        return 0;
    L7:
        return ((Integer) r1).intValue();
    }

    public long o() {
        Object r2 = this.f343a.get(19);
        if (r2 != null) goto L7;
        return 0;
    L7:
        return ((Long) r2).longValue();
    }

    public String p() {
        return a(this.f343a.get(7));
    }

    public int q() {
        Object r1 = this.f343a.get(8);
        if (r1 != null) goto L7;
        return 0;
    L7:
        return ((Integer) r1).intValue();
    }

    public boolean r() {
        Object r1 = this.f343a.get(16);
        if (r1 != null) goto L7;
        return false;
    L7:
        return ((Boolean) r1).booleanValue();
    }

    public boolean s() {
        Object r1 = this.f343a.get(17);
        if (r1 != null) goto L7;
        return false;
    L7:
        return ((Boolean) r1).booleanValue();
    }

    public boolean t() {
        Object r1 = this.f343a.get(4);
        if (r1 != null) goto L7;
        return false;
    L7:
        return ((Boolean) r1).booleanValue();
    }

    public String a() {
        return a(this.f343a.get(15));
    }

    public void b(String r2) {
        this.f343a.put(3, r2);
    }

    public void c(String r2) {
        this.f343a.put(26, r2);
    }

    public void d(String r2) {
        this.f343a.put(25, r2);
    }

    public void e(String r2) {
        this.f343a.put(11, r2);
    }

    public void f(String r2) {
        this.f343a.put(21, r2);
    }

    public void g(String r2) {
        this.f343a.put(24, r2);
    }

    public void h(String r2) {
        this.f343a.put(1, r2);
    }

    public void i(String r2) {
        this.f343a.put(22, r2);
    }

    public void j(String r2) {
        this.f343a.put(7, r2);
    }

    private String a(Object r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if ((r1 instanceof String) == false) goto L10;
        return (String) r1;
    L10:
        return r1.toString();
    }

    public void b(long r1) {
        this.f343a.put(10, Long.valueOf(r1));
    }

    public void c(long r1) {
        this.f343a.put(9, Long.valueOf(r1));
    }

    public void d(long r1) {
        this.f343a.put(19, Long.valueOf(r1));
    }

    public void a(int r1, Object r2) {
        this.f343a.put(r1, r2);
    }

    public void b(boolean r2) {
        this.f343a.put(4, Boolean.valueOf(r2));
    }

    public void c(int r2) {
        this.f343a.put(8, Integer.valueOf(r2));
    }

    public void a(boolean r2) {
        this.f343a.put(16, Boolean.valueOf(r2));
    }

    public void b(int r2) {
        this.f343a.put(2, Integer.valueOf(r2));
    }

    public void a(String r2) {
        this.f343a.put(15, r2);
    }

    public void a(tmsdk.common.module.qscanner.impl.b.e r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4.f53a) == true) goto L15;
        d(r4.f53a);
        d2 r0 = tmsdk.common.module.qscanner.impl.a.f45a.a(r4.f53a);
        if (r0 == null) goto L15;
        String r1 = r0.f142a;
        if (TextUtils.isEmpty(r1) == true) goto L11;
        e(r1);
    L11:
        String r2 = r0.b;
        if (TextUtils.isEmpty(r2) == true) goto L15;
        i(r2);
    L15:
        if (TextUtils.isEmpty(r4.b) == true) goto L18;
        c(r4.b);
        return;
    }

    public void a(Drawable r2) {
        this.f343a.put(6, r2);
    }

    public void a(long r1) {
        this.f343a.put(18, Long.valueOf(r1));
    }

    public void a(Boolean r2) {
        this.f343a.put(17, r2);
    }
}
