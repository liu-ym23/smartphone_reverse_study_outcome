package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public interface r0 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f463a;
        public final byte[] b;

        public a(int r3, byte[] r4) {
            if (r3 != 0) goto L5;
        L8:
            this.f463a = r3;
            this.b = r4;
            return;
        L5:
            if (r3 > (-1000)) goto L7;
            if (r3 >= (-9999)) goto L8;
        L7:
            r3 = -9999;
            goto L8
        }
    }
}
