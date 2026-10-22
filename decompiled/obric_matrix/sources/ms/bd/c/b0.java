package ms.bd.c;

/* JADX INFO: loaded from: classes2.dex */
final class b0 implements y.b {
    b0() {
    }

    public String a(String r1) {
        if (r1.startsWith("lib") == false) goto L8;
        if (r1.endsWith(".so") == false) goto L8;
        return r1;
    L8:
        return System.mapLibraryName(r1);
    }
}
