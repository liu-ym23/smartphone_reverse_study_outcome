package tmsdkobf;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class d9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f149a;
    public long b;
    public String c;
    public boolean d;
    public boolean e;
    public boolean f;
    public long g;

    class a implements Comparator {
        a() {
        }

        public int a(d9 r3, d9 r4) {
            long r2 = r3.f149a;
            long r0 = r4.f149a;
            if (r2 != r0) goto L6;
            return 0;
        L6:
            if (r2 >= r0) goto L8;
            return -1;
        L8:
            return 1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
            return a((d9) r1, (d9) r2);
        }
    }

    public d9(long r2, long r4, String r6, long r7) {
        this.d = false;
        this.e = false;
        this.f = false;
        this.f149a = r2;
        this.b = r4;
        this.c = r6;
        this.e = c9.h(r6);
        this.d = !c9.e(this.c);
        this.f = c9.d(c9.c(this.c));
        this.g = r7;
    }

    public static void a(List r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.isEmpty() == true) goto L9;
        Collections.sort(r1, new a());
        return;
    }

    public d9(d9 r3) {
        this.c = "";
        this.d = false;
        this.e = false;
        this.f = false;
        this.f149a = r3.f149a;
        this.b = r3.b;
        this.c = r3.c;
        this.e = r3.e;
        this.d = r3.d;
        this.f = r3.f;
        this.g = r3.g;
    }
}
