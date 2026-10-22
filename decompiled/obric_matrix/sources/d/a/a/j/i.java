package d.a.a.j;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
class i implements t {
    i() {
    }

    @Override // d.a.a.j.t
    public void b(m r1, Object r2, Object r3, Type r4) {
        z r0 = r1.f12492b;
        Enum r5 = (Enum) r2;
        if ((r0.f12526h & a0.f12468j.f12471f) == 0) goto L11;
        String r6 = r5.toString();
        if ((r0.f12526h & a0.f12466h.f12471f) == 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == false) goto L10;
        r0.X(r6);
        return;
    L10:
        r0.V(r6, 0, false);
        return;
    L7:
        r7 = false;
        goto L8
    L11:
        r0.L(r5.ordinal());
    }
}
