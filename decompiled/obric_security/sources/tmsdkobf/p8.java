package tmsdkobf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public class p8 implements e6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f411a;
    final boolean b;
    final ad c;
    public Set d;
    public Map e;
    List f;
    kd g;
    List h;
    List i;

    public p8(ad r2) {
        this.f = new ArrayList();
        this.c = r2;
        this.f411a = r2.j();
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
    public he d(String r1) {
        return (he) this.e.get(r1);
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
        if (this.e != null) goto L13;
        cc r0 = new cc();
        if (r0.a(this.f411a, this) == true) goto L8;
        return false;
    L8:
        if (r0.a(TMSDKContext.getApplicaionContext()) == true) goto L10;
        return false;
    L10:
        this.e = r0.f128a;
        return true;
    L13:
        return true;
    }

    @Override // tmsdkobf.e6
    public kd g() {
        return this.g;
    }

    private String a(he r5, boolean r6, boolean r7) {
        if (r5 != null) goto L5;
        return null;
    L5:
        StringBuilder r4 = new StringBuilder();
        if (r6 == false) goto L8;
        String r0 = "1;";
    L9:
        r4.append(r0);
        List r8 = r5.c;
        if (r8 == null) goto L33;
        Iterator r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L33;
        ce r1 = (ce) r9.next();
        boolean r2 = true;
        if (r7 == false) goto L23;
        int r3 = r1.c;
        if (r6 == true) goto L19;
        if (r3 == 1) goto L31;
    L30:
        r2 = false;
    L31:
        ce.a(r4, r1, r6, r2);
        goto L13
    L19:
        if (r3 == 3) goto L30;
    L23:
        if (r6 == true) goto L31;
        int r10 = r1.c;
        if (r10 == 1) goto L31;
        if (r10 != 2) goto L30;
    L33:
        return r4.toString();
    L8:
        r0 = "0;";
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
    public Map c(String r5) {
        f();
        Map r0 = this.e;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.size() == 0) goto L25;
        HashMap r1 = new HashMap();
        Iterator r4 = this.e.entrySet().iterator();
    L9:
        if (r4.hasNext() == false) goto L15;
        Map.Entry r2 = (Map.Entry) r4.next();
        he r3 = (he) r2.getValue();
        if (r3 == null) goto L9;
        if (r3.b.containsKey(r5) == false) goto L9;
        r1.put((String) r2.getKey(), r3);
        goto L9
    L15:
        return r1;
    L25:
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
        Iterator r0 = r3.b.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r4.containsKey((String) r0.next()) == false) goto L4;
        boolean r5 = false;
    L10:
        return a(r3, r5, this.b);
    L8:
        r5 = true;
        goto L10
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
