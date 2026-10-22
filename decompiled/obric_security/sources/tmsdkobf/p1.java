package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public abstract class p1 {
    public static String a(String r5) {
        String[] r6 = r5.split(" ", 3);
        if (r6.length > 2) goto L6;
        return null;
    L6:
        if ("rwxp".equals(r6[1]) == true) goto L8;
        return null;
    L8:
        int r3 = r6[2].indexOf(47);
        if (r3 != (-1)) goto L11;
        return null;
    L11:
        String r2 = r6[2].substring(r3).trim();
        if (r2.startsWith("/data/") == false) goto L15;
        return null;
    L15:
        return r6[1] + ";" + r2;
    }
}
