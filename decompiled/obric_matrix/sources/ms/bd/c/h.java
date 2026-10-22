package ms.bd.c;

/* JADX INFO: loaded from: classes2.dex */
final class h extends b.a {
    h() {
    }

    @Override // ms.bd.c.b.a
    public Object b(int r7, long r8, String r10, Object r11) {
        boolean r6 = l.b(a.a().c(), r10, r11.toString());     // Catch: Throwable -> L4
    L5:
        if (r6 == true) goto L11;
        return null;
    L11:
        return (String) m.a(16777217, 0, 0, "62abf9", new byte[]{8, 27});
    L4:
        String r9 = (String) m.a(16777217, 0, 0, "1232b8", new byte[]{39, 49, 70});
        r6 = false;
        goto L5
    }
}
