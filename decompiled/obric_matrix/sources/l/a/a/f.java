package l.a.a;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Comparator<d> {
    public f() {
    }

    public int a(d r2, d r3) {
        int r1 = r3.size() - r2.size();
        if (r1 == 0) goto L5;
        return r1;
    L5:
        return r2.getStart() - r3.getStart();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(d r1, d r2) {
        return a(r1, r2);
    }
}
