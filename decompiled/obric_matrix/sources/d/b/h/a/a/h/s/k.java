package d.b.h.a.a.h.s;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, List<String>> f13765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13766b;

    public k(String r2) {
        this.f13765a = new LinkedHashMap();
        this.f13766b = r2;
    }

    public void a(String r2, int r3) {
        List<String> r0 = this.f13765a.get(r2);
        if (r0 != null) goto L5;
        r0 = new LinkedList();
    L5:
        r0.add(String.valueOf(r3));
        this.f13765a.put(r2, r0);
    }

    public void b(String r2, String r3) {
        List<String> r0 = this.f13765a.get(r2);
        if (r0 != null) goto L5;
        r0 = new LinkedList();
    L5:
        r0.add(String.valueOf(r3));
        this.f13765a.put(r2, r0);
    }

    public String c() {
        if (this.f13765a.isEmpty() == true) goto L5;
        String r0 = l.c(this.f13765a, "UTF-8");
        String r1 = this.f13766b;
        if (r1 != null) goto L9;
    L17:
        return r0;
    L9:
        if (r1.length() == 0) goto L17;
        if (this.f13766b.indexOf(63) < 0) goto L16;
        StringBuilder r2 = new StringBuilder();
        r2.append(this.f13766b);
        String r3 = "&";
    L14:
        r2.append(r3);
        r2.append(r0);
        return r2.toString();
    L16:
        r2 = new StringBuilder();
        r2.append(this.f13766b);
        r3 = "?";
        goto L14
    L5:
        return this.f13766b;
    }

    public String toString() {
        return c();
    }
}
