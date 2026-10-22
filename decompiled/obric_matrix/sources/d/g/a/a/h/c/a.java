package d.g.a.a.h.c;

import d.g.a.a.h.b;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {
    public a() {
    }

    private static String b(String r6) {
        StringBuilder r0 = new StringBuilder(r6.length() + 10);
        String[] r7 = r6.split("\n");
        int r2 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        if (r3 == 0) goto L6;
        r0.append("\n");
    L6:
        String r4 = r7[r3];
        r0.append(9553);
        r0.append(r4);
        r3 = r3 + 1;
        goto L3
    L8:
        return r0.toString();
    }

    @Override // d.g.a.a.h.b
    public /* bridge */ /* synthetic */ String a(Object r1) {
        return c((String[]) r1);
    }

    public String c(String[] r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        if (r8.length == 0) goto L31;
        String[] r0 = new String[r8.length];
        int r1 = r8.length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r3 >= r1) goto L13;
        String r5 = r8[r3];
        if (r5 == null) goto L12;
        r0[r4] = r5;
        r4 = r4 + 1;
    L12:
        r3 = r3 + 1;
        goto L8
    L13:
        if (r4 != 0) goto L15;
        return "";
    L15:
        StringBuilder r7 = new StringBuilder();
        r7.append("╔═══════════════════════════════════════════════════════════════════════════════════════════════════");
        r7.append("\n");
    L16:
        if (r2 >= r4) goto L23;
        r7.append(b(r0[r2]));
        int r6 = r4 - 1;
        r7.append("\n");
        if (r2 == r6) goto L20;
        r7.append("╟───────────────────────────────────────────────────────────────────────────────────────────────────");
        r7.append("\n");
    L21:
        r2 = r2 + 1;
        goto L16
    L20:
        r7.append("╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
        goto L21
    L23:
        return r7.toString();
    L31:
        return "";
    }
}
