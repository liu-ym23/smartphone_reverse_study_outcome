package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public abstract class gk {
    public static void a(StringBuilder r4) {
        if (r4.length() <= 0) goto L5;
        r4.append(",");
    L5:
        r4.append("T:");
        long r2 = d8.f148a;
        r4.append(r2);
        r4.append(",");
        r4.append("LT:");
        r4.append(System.currentTimeMillis() - r2);
    }
}
