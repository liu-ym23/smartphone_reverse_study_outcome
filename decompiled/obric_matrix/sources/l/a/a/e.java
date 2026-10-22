package l.a.a;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Comparator<d> {
    public e() {
    }

    public int a(d r1, d r2) {
        return r1.getStart() - r2.getStart();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(d r1, d r2) {
        return a(r1, r2);
    }
}
