package tmsdkobf;

import android.content.Context;
import com.bytedance.keva.KevaImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public abstract class k3 {
    public static k3 D;
    public static final l1 E = null;
    public Set A;
    public boolean B;
    public boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r0 f300a;
    public o1 b;
    public l1 c;
    public i7 d;
    public int e;
    public String f;
    public boolean g;
    public String[] h;
    public int i;
    public String j;
    public String k;
    public String l;
    public int m;
    public String n;
    public Map o;
    public String p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public long v;
    public long w;
    public int x;
    public boolean y;
    public boolean z;

    public class a implements l1 {
        public a() {
        }

        @Override // tmsdkobf.l1
        public boolean a() {
            return false;
        }
    }

    static {
        E = new a();
    }

    public k3() {
        this.e = 0;
        this.f = "";
        this.g = true;
        this.h = null;
        this.i = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = 0;
        this.n = "";
        this.o = new HashMap();
        this.p = "";
        this.q = true;
        this.r = false;
        this.s = true;
        this.t = true;
        this.u = false;
        this.v = 5000;
        this.w = 60000;
        this.x = 3;
        this.y = false;
        this.z = false;
        this.B = false;
        this.C = false;
    }

    public final void a() {
        String[] r0 = this.h;
        if (r0 == null) goto L21;
        String[] r1 = null;
        if (r0.length != 0) goto L7;
        this.h = null;
        goto L21
    L7:
        ArrayList r2 = new ArrayList();
        String[] r3 = this.h;
        int r4 = r3.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L16;
        String r6 = r3[r5];
        if (r6 == null) goto L14;
        if (r6.isEmpty() == true) goto L14;
        r2.add(r6);
    L14:
        r5 = r5 + 1;
        goto L8
    L16:
        if (r2.isEmpty() == true) goto L19;
        r1 = (String[]) r2.toArray(new String[0]);
    L19:
        this.h = r1;
    L21:
        if (this.h != null) goto L24;
        this.h = new String[]{""};
    L24:
        if (this.f300a == null) goto L26;
        this.y = true;
        return;
    L26:
        if (this.i >= 1000) goto L28;
        this.i = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
    L28:
        String[] r7 = this.h;
        int r8 = this.i;
        yk r9 = new yk(r7);
        if (r7.length <= 1) goto L32;
        xh.f623a.submit(new yj(r9, r8));
    L32:
        this.f300a = r9;
    }

    public final Context b() {
        monitor-enter(mh.class);
        Context r0 = mh.f353a;     // Catch: Throwable -> L7
        monitor-exit(mh.class);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public l1 c() {
        l1 r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return E;
    }

    public final void a(Context r1) {
        mh.a(r1);
    }
}
