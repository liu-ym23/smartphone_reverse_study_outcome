package d.g.a.a.i;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    private static class a extends StringWriter {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f16731f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f16732g;

        public a() {
            this.f16731f = 0;
            this.f16732g = false;
        }

        @Override // java.io.StringWriter, java.io.Writer
        public void write(String r4, int r5, int r6) {
            if (this.f16732g == false) goto L5;
            return;
        L5:
            int r0 = this.f16731f;
            if ((r0 + r6) <= 4000) goto L9;
            this.f16732g = true;
            return;
        L9:
            this.f16731f = r0 + r6;
            super.write(r4, r5, r6);
        }
    }

    public static String a(Throwable r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        Throwable r0 = r2;
    L6:
        if (r0 == null) goto L12;
        if ((r0 instanceof UnknownHostException) == true) goto L9;
        r0 = r0.getCause();
        goto L6
    L9:
        return "ALOG:UnknownHostException";
    L12:
        a r1 = new a();
        PrintWriter r3 = new PrintWriter(r1);
        r2.printStackTrace(r3);     // Catch: Throwable -> L16
    L14:
        r3.flush();
        return r1.toString();
    }
}
