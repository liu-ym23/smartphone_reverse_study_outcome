package tmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ph extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m8 f421a;
    public final List b;

    public ph(Looper r1, m8 r2) {
        super(r1);
        this.b = new ArrayList();
        this.f421a = r2;
    }

    public final void a() {
        Iterator r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        v8 r1 = (v8) r0.next();
        r1.getClass();
        Object r2 = v8.i;
        monitor-enter(r2);
        int r3 = v8.j;     // Catch: Throwable -> L12
        if (r3 >= 200) goto L10;
        v8.j = r3 + 1;     // Catch: Throwable -> L12
        r1.f571a = v8.k;     // Catch: Throwable -> L12
        v8.k = r1;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        this.b.clear();
    }

    @Override // android.os.Handler
    public void handleMessage(Message r13) {
        int r0 = r13.what;
        h2 r1 = null;
        if (r0 != 1) goto L5;
        Object r14 = r13.obj;
        if ((r14 instanceof String) == true) goto L72;
        return;
    L72:
        ((w.a) this.f421a).a(new ki((String) r14, 3, null));
        return;
    L5:
        if (r0 != 2) goto L85;
        Object r15 = r13.obj;
        if ((r15 instanceof v8) == true) goto L10;
        return;
    L10:
        v8 r16 = (v8) r15;
        String r2 = r16.b;
        if (TextUtils.isEmpty(r2) == false) goto L14;
        return;
    L14:
        if (this.b.isEmpty() == false) goto L16;
    L18:
        int r5 = r16.c;
        if (r5 == 0) goto L68;
        if (r5 == 1) goto L27;
        if (r5 == 2) goto L25;
        if (r5 != 3) goto L87;
        a();
        return;
    L87:
        return;
    L25:
        this.b.isEmpty();
        this.b.add(r16);
        return;
    L27:
        if (this.b.isEmpty() == true) goto L88;
        this.b.add(r16);
        List r6 = this.b;
        ArrayList r7 = new ArrayList();
        if (r6.size() > 8) goto L32;
        r7.addAll(r6);
    L38:
        if (r7.isEmpty() == true) goto L55;
        v8 r3 = (v8) r7.get(0);
        h2 r8 = new h2();
        long r9 = System.currentTimeMillis();
        long r10 = r3.h;
        r8.b = (int) (r9 - r10);
        r8.f236a = r10;
        ArrayList r4 = new ArrayList();
        Iterator r11 = r7.iterator();
    L42:
        if (r11.hasNext() == false) goto L54;
        v8 r12 = (v8) r11.next();
        f3 r17 = new f3();
        int r18 = r12.c;
        if (r18 == 0) goto L52;
        if (r18 == 1) goto L51;
        if (r18 == 2) goto L50;
        if (r18 == 3) goto L49;
        r17.f195a = 0;
    L53:
        r17.d = r12.f;
        r17.e = r12.g;
        r4.add(r17);
        goto L42
    L49:
        r17.f195a = 4;
        goto L53
    L50:
        r17.f195a = 2;
        goto L53
    L51:
        r17.f195a = 3;
        goto L53
    L52:
        r17.f195a = 1;
        goto L53
    L54:
        r8.c = r4;
        r1 = r8;
    L55:
        if (r1 != null) goto L58;
        return;
    L58:
        if (r16.d > 0) goto L61;
        r1.d |= 1;
    L61:
        if (r16.e != 0) goto L64;
        r1.d |= 2;
    L64:
        if (r1.d == 0) goto L66;
        ((w.a) this.f421a).a(new ki(r2, 2, r1));
    L67:
        a();
        return;
    L66:
        ((w.a) this.f421a).a(new ki(r2, 1, r1));
        goto L67
    L32:
        v8 r19 = (v8) r6.get(0);
        v8 r20 = (v8) r6.get(r6.size() - 1);
        r6.remove(r19);
        r6.remove(r20);
        int r110 = (int) Math.ceil(r6.size() / 6);
        r7.add(r19);
        int r21 = 1;
    L34:
        if (r21 >= r6.size()) goto L36;
        r7.add(r6.get(r21));
        r21 = r21 + r110;
        goto L34
    L36:
        r7.add(r20);
        goto L38
    L88:
        return;
    L68:
        a();
        this.b.add(r16);
        return;
    L16:
        if (((v8) this.b.get(0)).b.equals(r16.b) == true) goto L18;
        a();
        goto L18
    }
}
