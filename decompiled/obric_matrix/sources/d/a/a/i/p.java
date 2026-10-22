package d.a.a.i;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class p extends g {
    public p(m r1, Class<?> r2) {
        super(r1, r2, r2);
    }

    @Override // d.a.a.i.g, d.a.a.i.q.f
    public <T> T a(b r17, Type r18, Object r19) {
        e r3 = r17.f12388j;
        int r4 = r3.f12404a;
        Throwable r6 = null;
        if (r4 != 8) goto L7;
        r3.s();
        return null;
    L7:
        if (r17.o != 2) goto L10;
        r17.o = 0;
    L11:
        if (r18 != null) goto L13;
    L17:
        Class<?> r1 = null;
    L18:
        HashMap r5 = new HashMap();
        Throwable r7 = null;
        String r11 = null;
        StackTraceElement[] r12 = null;
    L19:
        String r13 = r3.R(r17.f12384f);
        if (r13 != null) goto L26;
        int r9 = r3.f12404a;
        if (r9 == 13) goto L23;
        if (r9 != 16) goto L26;
    L23:
        r3.t(16);
        if (r1 != null) goto L95;
        Object r0 = (T) new Exception(r11, r7);
    L86:
        if (r12 == null) goto L88;
        ((Throwable) r0).setStackTrace(r12);
    L88:
        return (T) r0;
    L95:
        Constructor<?>[] r2 = r1.getConstructors();     // Catch: Exception -> L89
        int r8 = r2.length;     // Catch: Exception -> L89
        Constructor<?> r10 = null;
        Constructor<?> r14 = null;
        Constructor<?> r15 = null;
        int r16 = 0;
    L58:
        if (r16 >= r8) goto L75;
        Constructor<?> r110 = r2[r16];     // Catch: Exception -> L89
        if (r110.getParameterTypes().length != 0) goto L63;
        r15 = r110;
    L74:
        r16 = r16 + 1;     // Catch: Exception -> L89
        goto L58
    L63:
        if (r110.getParameterTypes().length != 1) goto L68;
        if (r110.getParameterTypes()[0] != String.class) goto L68;
        r14 = r110;
    L68:
        if (r110.getParameterTypes().length != 2) goto L74;
        if (r110.getParameterTypes()[0] != String.class) goto L74;
        if (r110.getParameterTypes()[1] != Throwable.class) goto L74;
        r10 = r110;
        goto L74
    L75:
        if (r10 == null) goto L78;
        Object r20 = r10.newInstance(new Object[]{r11, r7});     // Catch: Exception -> L89
    L77:
        r6 = (Throwable) r20;     // Catch: Exception -> L89
    L82:
        if (r6 != null) goto L85;
        r0 = (T) new Exception(r11, r7);
        goto L86
    L85:
        r0 = (T) r6;
        goto L86
    L78:
        if (r14 == null) goto L80;
        r20 = r14.newInstance(new Object[]{r11});     // Catch: Exception -> L89
        goto L77
    L80:
        if (r15 == null) goto L82;
        r20 = r15.newInstance(new Object[0]);     // Catch: Exception -> L89
    L89:
        e = move-exception;
        throw new d.a.a.d("create instance error", e);
    L26:
        r3.u(':');
        if ("@type".equals(r13) == false) goto L35;
        if (r3.f12404a != 4) goto L33;
        r1 = d.a.a.k.d.C(r3.X(), r17.f12385g.f12447c);
        r3.t(16);
    L52:
        if (r3.f12404a != 13) goto L19;
    L33:
        throw new d.a.a.d("syntax error");
    L35:
        if ("message".equals(r13) == false) goto L45;
        int r21 = r3.f12404a;
        if (r21 != 8) goto L39;
        r11 = null;
    L41:
        r3.s();
        goto L52
    L39:
        if (r21 != 4) goto L43;
        r11 = r3.X();
        goto L41
    L43:
        throw new d.a.a.d("syntax error");
    L45:
        if ("cause".equals(r13) == false) goto L48;
        r7 = (Throwable) a(r17, null, "cause");
        goto L52
    L48:
        if ("stackTrace".equals(r13) == false) goto L50;
        r12 = (StackTraceElement[]) r17.V(StackTraceElement[].class);
        goto L52
    L50:
        r5.put(r13, r17.F());
        goto L52
    L13:
        if ((r18 instanceof Class) == false) goto L17;
        r1 = (Class) r18;
        if (Throwable.class.isAssignableFrom(r1) == false) goto L17;
    L10:
        if (r4 == 12) goto L11;
        throw new d.a.a.d("syntax error");
    }
}
