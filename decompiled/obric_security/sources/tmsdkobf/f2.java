package tmsdkobf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class f2 implements e6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f194a;
    final boolean b;
    final ad c;
    public Set d;
    public Map e;
    List f;
    kd g;
    List h;
    List i;

    public f2(ad r2) {
        this.f = new ArrayList();
        this.c = r2;
        this.f194a = r2.j();
        this.b = r2.i();
    }

    @Override // tmsdkobf.e6
    public kd a(String r3) {
        Iterator r2 = this.f.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        kd r0 = (kd) r2.next();
        if (r3.equals(r0.f306a) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    @Override // tmsdkobf.e6
    public void b(String r2) {
        if (this.d != null) goto L5;
        this.d = new HashSet();
    L5:
        this.d.add(r2);
    }

    @Override // tmsdkobf.e6
    public List c() {
        if (this.b == false) goto L13;
        ArrayList r0 = new ArrayList();
        Iterator r3 = this.i.iterator();
    L6:
        if (r3.hasNext() == false) goto L11;
        kd r1 = (kd) r3.next();
        if (r1.k == true) goto L6;
        r0.add(r1);
        goto L6
    L11:
        return r0;
    L13:
        return this.i;
    }

    @Override // tmsdkobf.e6
    public he d(String r3) {
        he r0 = (he) this.e.get(r3);
        if (r0.b != null) goto L5;
        r0.b = bc.a().a(r3, this.f194a);
    L5:
        return r0;
    }

    @Override // tmsdkobf.e6
    public String[] e() {
        Set r1 = this.d;
        if (r1 != null) goto L5;
        return null;
    L5:
        return (String[]) r1.toArray(new String[0]);
    }

    @Override // tmsdkobf.e6
    public boolean f() {
        ce.a();
        if (this.e == null) goto L5;
        return true;
    L5:
        if (new cc().a(this.f194a, this) == true) goto L8;
        return false;
    L8:
        this.e = bc.a().c();
        return true;
    }

    @Override // tmsdkobf.e6
    public kd g() {
        return this.g;
    }

    private String a(he r6, boolean r7) {
        if (r6 != null) goto L5;
        return null;
    L5:
        StringBuilder r0 = new StringBuilder();
        if (r7 == false) goto L8;
        String r1 = "1;";
    L9:
        r0.append(r1);
        List r8 = r6.c;
        if (r8 == null) goto L33;
        Iterator r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L33;
        ce r2 = (ce) r9.next();
        boolean r3 = true;
        if (this.b == false) goto L23;
        int r4 = r2.c;
        if (r7 == true) goto L19;
        if (r4 == 1) goto L31;
    L30:
        r3 = false;
    L31:
        ce.a(r0, r2, r7, r3);
        goto L13
    L19:
        if (r4 == 3) goto L30;
    L23:
        if (r7 == true) goto L31;
        int r5 = r2.c;
        if (r5 == 1) goto L31;
        if (r5 != 2) goto L30;
    L33:
        return r0.toString();
    L8:
        r1 = "0;";
        goto L9
    }

    @Override // tmsdkobf.e6
    public List b() {
        if (this.b == false) goto L13;
        ArrayList r0 = new ArrayList();
        Iterator r3 = this.f.iterator();
    L6:
        if (r3.hasNext() == false) goto L11;
        kd r1 = (kd) r3.next();
        if (r1.k == true) goto L6;
        r0.add(r1);
        goto L6
    L11:
        return r0;
    L13:
        return this.f;
    }

    @Override // tmsdkobf.e6
    public Map c(String r6) {
        Map r0 = bc.a().d(r6);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.size() < 1) goto L26;
        Iterator r1 = r0.entrySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L15;
        Map.Entry r2 = (Map.Entry) r1.next();
        he r3 = (he) r2.getValue();
        if (r3 == null) goto L9;
        if (r3.b.containsKey(r6) == false) goto L9;
        r0.put((String) r2.getKey(), r3);
        goto L9
    L15:
        this.e = r0;
        return r0;
    L26:
        return null;
    }

    @Override // tmsdkobf.e6
    public String[] d() {
        Map r1 = this.e;
        if (r1 == null) goto L6;
        Set r2 = r1.keySet();
        return (String[]) r2.toArray(new String[0]);
    L6:
        return null;
    }

    @Override // tmsdkobf.e6
    public String a(he r3, Map r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Iterator r0 = r3.b.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        if (r4.containsKey((String) r0.next()) == false) goto L7;
        boolean r5 = false;
    L13:
        if (r3.c != null) goto L16;
        r3.c = bc.a().c(r3.f246a);
    L16:
        return a(r3, r5);
    L11:
        r5 = true;
        goto L13
    }

    @Override // tmsdkobf.e6
    public void b(List r1) {
        this.i = r1;
    }

    @Override // tmsdkobf.e6
    public void c(List r1) {
        this.f = r1;
    }

    @Override // tmsdkobf.e6
    public List a() {
        return this.h;
    }

    @Override // tmsdkobf.e6
    public void a(kd r1) {
        this.g = r1;
    }

    @Override // tmsdkobf.e6
    public void a(List r1) {
        this.h = r1;
    }
}
