package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class el {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f187a;
    private String b;
    private z6 c;
    private int d;
    private al e;
    private hk f;

    public el(String r2, z6 r3, int r4) {
        Context r0 = rd.e();
        this.f187a = r0;
        if (r2 != null) goto L6;
        r2 = r0.getPackageName();
    L6:
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = new sk(this.f187a, "sk_" + this.b + f());
        this.f = new hk();
    }

    private String f() {
        int r0 = this.d;
        if (r0 != 1) goto L6;
        return "_test";
    L6:
        if (r0 != 0) goto L10;
        return "";
    L10:
        return "_svr" + this.d;
    }

    public void a(nd r4) {
        String r0 = "key_yekterces" + r4.f372a;
        if (TextUtils.isEmpty(r4.b) == false) goto L6;
        this.e.a(r0);
        return;
    L6:
        String r5 = this.f.d(this.f187a, "" + r4.b + "|" + r4.c);
        if (r5 != null) goto L9;
        return;
    L9:
        this.e.a(r0, r5);
    }

    public String b() {
        String r0 = this.e.b("key_gd", "");
        return this.f.c(this.f187a, r0);
    }

    public nd c(int r4) {
        String r3 = this.f.b(this.f187a, this.e.b("key_yekterces" + r4, ""));
        if (TextUtils.isEmpty(r3) == true) goto L9;
        int r0 = r3.indexOf("|");
        if (r0 <= 0) goto L9;
        if (r0 >= (r3.length() - 1)) goto L9;
        nd r1 = new nd();
        r1.f372a = r4;
        r1.b = r3.substring(0, r0);
        r1.c = r3.substring(r0 + 1);
        return r1;
    L9:
        return null;
    }

    public void d(String r3) {
        String r4 = this.f.e(this.f187a, r3);
        if (r4 != null) goto L5;
        return;
    L5:
        this.e.a("key_vd", r4);
    }

    public j1 e() {
        String r0 = this.e.b("key_v_i", "");
        byte[] r3 = this.f.a(this.f187a, r0);
        if (r3 != null) goto L5;
    L7:
        return null;
    L5:
        if (r3.length <= 0) goto L7;
        return (j1) z7.a(r3, new j1(), false);
    }

    public pc g() {
        String r0 = this.e.b("key_s_c", "");
        byte[] r3 = this.f.a(this.f187a, r0);
        if (r3 != null) goto L5;
    L7:
        return null;
    L5:
        if (r3.length <= 0) goto L7;
        return (pc) z7.a(r3, new pc(), false);
    }

    public String h() {
        String r0 = this.e.b("key_vd", "");
        return this.f.c(this.f187a, r0);
    }

    public boolean b(String r3) {
        return this.e.b("key_d_m_d" + r3, false);
    }

    public int b(int r2) {
        return this.e.b("key_i_r_f_l", r2);
    }

    public void e(int r2) {
        this.e.a("key_lst", r2);
    }

    public d1 d() {
        String r0 = this.e.b("key_g_i", "");
        byte[] r3 = this.f.a(this.f187a, r0);
        if (r3 != null) goto L5;
    L7:
        d1 r4 = null;
    L8:
        if (r4 == null) goto L10;
        String r1 = "done";
    L11:
        cj.b("GUI", "GUI ".concat(r1));
        return r4;
    L10:
        r1 = "null";
        goto L11
    L5:
        if (r3.length <= 0) goto L7;
        r4 = (d1) z7.a(r3, new d1(), false);
        goto L8
    }

    public void c(String r3) {
        String r4 = this.f.e(this.f187a, r3);
        if (r4 != null) goto L5;
        return;
    L5:
        this.e.a("key_gd", r4);
    }

    public void d(int r2) {
        this.e.a("key_i_r_f_l", r2);
    }

    public long c() {
        String r0 = this.e.b("key_gd_ck_tm", "");
        return Long.parseLong(this.f.b(this.f187a, r0));
    L5:
        return 0;
    }

    public void a(int r3) {
        this.e.a("key_yekterces" + r3);
    }

    public void a(long r2) {
        String r3 = Long.toString(r2);
        String r4 = this.f.d(this.f187a, r3);
        if (r4 != null) goto L5;
        return;
    L5:
        this.e.a("key_gd_ck_tm", r4);
    }

    public void a(d1 r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        byte[] r4 = z7.a(r3);
        if (r4 == null) goto L10;
        String r5 = this.f.a(this.f187a, r4);
        if (r5 == null) goto L11;
        this.e.a("key_g_i", r5);
        return;
    L11:
        return;
    }

    public void a(j1 r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        byte[] r4 = z7.a(r3);
        if (r4 == null) goto L10;
        String r5 = this.f.a(this.f187a, r4);
        if (r5 == null) goto L11;
        this.e.a("key_v_i", r5);
        return;
    L11:
        return;
    }

    public u5 a(String r1) {
        return (u5) a().get(r1);
    }

    public void a(String r9, long r10, List r12) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (r10 <= 0) goto L9;
        if (r12 == null) goto L9;
        boolean r0 = false;
    L10:
        LinkedHashMap r2 = a();
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r4 = r2.entrySet().iterator();
    L12:
        if (r4.hasNext() == false) goto L21;
        Map.Entry r5 = (Map.Entry) r4.next();
        String r6 = (String) r5.getKey();
        u5 r7 = (u5) r5.getValue();
        if (r6 == null) goto L12;
        if (r7 == null) goto L12;
        if (r7.a() == false) goto L12;
        r3.put(r6, r7);
        goto L12
    L21:
        if (r0 == false) goto L23;
        r3.remove(r9);
    L27:
        if (r3.size() <= 10) goto L29;
        r3.remove((String) new ArrayList(r3.keySet()).get(0));
    L29:
        StringBuilder r11 = new StringBuilder();
        Iterator r13 = r3.entrySet().iterator();
        int r14 = 0;
    L31:
        if (r13.hasNext() == false) goto L50;
        Map.Entry r15 = (Map.Entry) r13.next();
        String r1 = (String) r15.getKey();
        u5 r16 = (u5) r15.getValue();
        if (r1 == null) goto L31;
        if (r16 == null) goto L31;
        long r8 = r16.f548a;
        if (r8 <= System.currentTimeMillis()) goto L31;
        StringBuilder r17 = new StringBuilder();
        Iterator r18 = r16.b.iterator();
        int r19 = 0;
    L41:
        if (r18.hasNext() == false) goto L46;
        String r20 = (String) r18.next();
        if (r19 <= 0) goto L45;
        r17.append("#");
    L45:
        r17.append(r20);
        r19 = r19 + 1;
        goto L41
    L46:
        StringBuilder r110 = new StringBuilder();
        r110.append(r1).append(",").append(r8).append(",").append(r17.toString());
        if (r14 <= 0) goto L49;
        r11.append("|");
    L49:
        r11.append(r110.toString());
        r14 = r14 + 1;
        goto L31
    L50:
        String r21 = this.f.d(this.f187a, r11.toString());
        if (r21 != null) goto L53;
        return;
    L53:
        this.e.a("key_hips", r21);
        return;
    L23:
        u5 r22 = new u5(r10, r12, false);
        if (r22.a() == false) goto L27;
        r3.put(r9, r22);
    L9:
        r0 = true;
        goto L10
    }

    private LinkedHashMap a() {
        LinkedHashMap r0 = new LinkedHashMap();
        String r9 = this.f.b(this.f187a, this.e.b("key_hips", ""));
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return r0;
    L5:
        String[] r10 = r9.split("\\|");
        if (r10 != null) goto L8;
    L24:
        return r0;
    L8:
        if (r10.length == 0) goto L24;
        int r1 = r10.length;
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L24;
        String r4 = r10[r3];
        if (TextUtils.isEmpty(r4) == true) goto L23;
        String[] r5 = r4.split(",");
        if (r5 == null) goto L23;
        if (r5.length <= 0) goto L23;
        String r6 = r5[0];     // Catch: Exception -> L25
        long r7 = Long.parseLong(r5[1]);     // Catch: Exception -> L25
        String[] r8 = r5[2].split("#");     // Catch: Exception -> L25
        if (r8 == null) goto L23;
        r0.put(r6, new u5(r7, u5.a(Arrays.asList(r8), false), false));     // Catch: Exception -> L25
    L23:
        r3 = r3 + 1;
        goto L11
    }

    public void a(pc r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        byte[] r4 = z7.a(r3);
        if (r4 == null) goto L10;
        String r5 = this.f.a(this.f187a, r4);
        if (r5 == null) goto L11;
        this.e.a("key_s_c", r5);
        return;
    L11:
        return;
    }

    public void a(String r3, boolean r4) {
        this.e.a("key_d_m_d" + r3, r4);
    }

    public void a(c7 r1) {
        this.f.a(r1);
    }
}
