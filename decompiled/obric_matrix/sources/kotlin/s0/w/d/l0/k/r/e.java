package kotlin.s0.w.d.l0.k.r;

import java.util.Arrays;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends o<Character> {
    public e(char r1) {
        super(Character.valueOf(r1));
    }

    private final String c(char r2) {
        if (r2 != '\b') goto L6;
        return "\\b";
    L6:
        if (r2 != '\t') goto L9;
        return "\\t";
    L9:
        if (r2 != '\n') goto L12;
        return "\\n";
    L12:
        if (r2 != '\f') goto L15;
        return "\\f";
    L15:
        if (r2 != '\r') goto L18;
        return "\\r";
    L18:
        if (e(r2) == true) goto L27;
        return "?";
    L27:
        return String.valueOf(r2);
    }

    private final boolean e(char r1) {
        byte r0 = (byte) Character.getType(r1);
        if (r0 != 0) goto L5;
    L17:
        return false;
    L5:
        if (r0 == 13) goto L17;
        if (r0 == 14) goto L17;
        if (r0 == 15) goto L17;
        if (r0 == 16) goto L17;
        if (r0 == 18) goto L17;
        if (r0 == 19) goto L17;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.k.r.g
    public /* bridge */ /* synthetic */ e0 a(h0 r1) {
        return d(r1);
    }

    public m0 d(h0 r1) {
        kotlin.n0.d.o.f(r1, "module");
        m0 r0 = r1.o().u();
        kotlin.n0.d.o.e(r0, "module.builtIns.charType");
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.k.r.g
    public String toString() {
        String r4 = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(b().charValue()), c(b().charValue())}, 2));
        kotlin.n0.d.o.e(r4, "format(this, *args)");
        return r4;
    }
}
