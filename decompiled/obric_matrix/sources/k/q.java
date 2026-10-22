package k;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: loaded from: classes2.dex */
public final class q {
    public static final f a(x r1) {
        kotlin.n0.d.o.g(r1, "$this$buffer");
        return new s(r1);
    }

    public static final g b(z r1) {
        kotlin.n0.d.o.g(r1, "$this$buffer");
        return new t(r1);
    }

    public static final boolean c(AssertionError r4) {
        kotlin.n0.d.o.g(r4, "$this$isAndroidGetsocknameError");
        if (r4.getCause() == null) goto L11;
        String r5 = r4.getMessage();
        if (r5 == null) goto L7;
        boolean r6 = kotlin.u0.k.F(r5, "getsockname failed", false, 2, null);
    L8:
        if (r6 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r6 = false;
        goto L8
    L11:
        return false;
    }

    public static final x d(File r3) {
        return h(r3, false, 1, null);
    }

    public static final x e(File r1, boolean r2) {
        kotlin.n0.d.o.g(r1, "$this$sink");
        return f(new FileOutputStream(r1, r2));
    }

    public static final x f(OutputStream r2) {
        kotlin.n0.d.o.g(r2, "$this$sink");
        return new r(r2, new a0());
    }

    public static final x g(Socket r3) {
        kotlin.n0.d.o.g(r3, "$this$sink");
        y r0 = new y(r3);
        OutputStream r4 = r3.getOutputStream();
        kotlin.n0.d.o.b(r4, "getOutputStream()");
        return r0.v(new r(r4, r0));
    }

    public static /* synthetic */ x h(File r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return e(r0, r1);
    }

    public static final z i(File r1) {
        kotlin.n0.d.o.g(r1, "$this$source");
        return j(new FileInputStream(r1));
    }

    public static final z j(InputStream r2) {
        kotlin.n0.d.o.g(r2, "$this$source");
        return new p(r2, new a0());
    }

    public static final z k(Socket r3) {
        kotlin.n0.d.o.g(r3, "$this$source");
        y r0 = new y(r3);
        InputStream r4 = r3.getInputStream();
        kotlin.n0.d.o.b(r4, "getInputStream()");
        return r0.w(new p(r4, r0));
    }
}
