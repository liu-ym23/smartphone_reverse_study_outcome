package ms.bd.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c4 extends a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f22327a;

    class a implements d.b.h.a.a.h.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c4 f22328a;

        a(c4 r1) {
            this.f22328a = r1;
        }

        @Override // d.b.h.a.a.h.g.b
        public Map<String, String> onCallToAddSecurityFactor(String r19, Map<String, List<String>> r20) {
            HashMap r6 = new HashMap();
            if (r19 == null) goto L39;
            if (r20 == null) goto L39;
            String r1 = r19.toLowerCase();
            if (r1.contains((String) m.a(16777217, 0, 0, "a91fa6", new byte[]{120, 47, 86, 2})) == false) goto L9;
        L15:
            q4.b().d();
            ArrayList r3 = new ArrayList();
            Iterator<Map.Entry<String, List<String>>> r7 = r20.entrySet().iterator();
        L16:
            String[] r9 = null;
            String r10 = null;
            r10 = null;
            int r11 = 0;
            if (r7.hasNext() == false) goto L27;
            Map.Entry<String, List<String>> r8 = r7.next();
            String r12 = r8.getKey();
            if (r8.getValue() != null) goto L21;
        L23:
            if (r12 == null) goto L16;
            if (r10 == null) goto L16;
            r3.add(r12);
            r3.add(r10);
            goto L16
        L21:
            if (r8.getValue().size() <= 0) goto L23;
            r10 = r8.getValue().get(0);
            goto L23
        L27:
            if (r1.startsWith((String) m.a(16777217, 0, 0, "a943b9", new byte[]{120, 47, 83, 87})) == false) goto L30;
            String[] r5 = (String[]) r3.toArray(new String[0]);
            long r13 = c4.d(this.f22328a);
            int r0 = b.f22318b;
            Object r2 = m.a(50331649, 0, r13, r19, r5);
        L32:
            r9 = (String[]) r2;
        L33:
            if (r9 == null) goto L39;
            HashMap r4 = new HashMap();
        L36:
            if (r11 >= r9.length) goto L38;
            r4.put(r9[r11], r9[r11 + 1]);
            r11 = r11 + 2;
            goto L36
        L38:
            return r4;
        L30:
            if (r1.startsWith((String) m.a(16777217, 0, 0, "bf6bef", new byte[]{100, 119})) == false) goto L33;
            r3.add((String) m.a(16777217, 0, 0, "13f7c6", new byte[]{21, 3, 57}));
            r3.add(r19);
            String[] r16 = (String[]) r3.toArray(new String[0]);
            long r14 = c4.d(this.f22328a);
            int r15 = b.f22318b;
            r2 = m.a(100663297, 0, r14, null, r16);
            goto L32
        L9:
            if (r1.contains((String) m.a(16777217, 0, 0, "efd51c", new byte[]{124, 112, 3, 81, 29})) == true) goto L15;
            if (r1.contains((String) m.a(16777217, 0, 0, "3a3540", new byte[]{53, 112})) == true) goto L15;
            throw new RuntimeException((String) m.a(16777217, 0, 0, "3b85b7", new byte[]{43, 116, 11, 76, 72, 51, 36, 3, 107, 96, 98, 104, 95, 85, 77, 111, 56, 87, 125, 117, 49, 47, 92, 82, 78}));
        L39:
            return r6;
        }
    }

    public c4() {
    }

    static /* synthetic */ long d(c4 r2) {
        return r2.f22327a;
    }

    @Override // ms.bd.c.a4
    protected Object c(long r1) {
        this.f22327a = r1;
        a r2 = new a(this);
        monitor-enter(this);
        d.b.h.a.a.h.g.G(r2);     // Catch: Throwable -> L8
        monitor-exit(this);
        return Boolean.TRUE;
    L8:
        th = move-exception;
        throw th;
    }

    protected void finalize() {
        long r2 = this.f22327a;
        int r0 = b.f22318b;
        m.a(50331650, 0, r2, null, null);
        m.a(100663298, 0, this.f22327a, null, null);
        this.f22327a = -1;
        super.finalize();
    }
}
