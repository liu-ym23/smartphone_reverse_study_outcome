package tmsdkobf;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class il {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f278a;
    private LinkedHashMap b;

    public il(int r2) {
        this.f278a = -1;
        this.b = new LinkedHashMap();
        this.f278a = r2;
    }

    public Object a(Object r3, Object r4) {
        if (this.b.size() < this.f278a) goto L8;
        Set r0 = this.b.keySet();
        if (r0 == null) goto L8;
        Iterator r1 = r0.iterator();
        this.b.remove(r1.next());
    L8:
        return this.b.put(r3, r4);
    }

    public Object b(Object r1) {
        return this.b.get(r1);
    }

    public int b() {
        return this.b.size();
    }

    public void a(Object r1) {
        this.b.remove(r1);
    }

    public LinkedHashMap a() {
        return this.b;
    }
}
