package d.b.w.a.c;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Character f15235d = null;

    static {
        f15235d = ')';
    }

    public c() {
        this("proc/self/stat");
    }

    public c(String r1) {
        super(r1);
    }

    @Override // d.b.w.a.c.a
    protected b a(File r2) {
        return c(r2, null);
    }

    protected b c(File r6, d.b.w.a.b.e.d r7) {
        BufferedReader r5 = d.b.w.a.d.c.b(r6);
        if (r5 != null) goto L32;
        return null;
    L32:
        String r8 = r5.readLine();     // Catch: Exception -> L25 Throwable -> L29
        if (r8 != null) goto L9;
    L23:
        d.b.w.a.d.c.a(r5);
        return r7;
    L9:
        if (r8.isEmpty() == true) goto L23;
        String r9 = r8.trim();     // Catch: Exception -> L25 Throwable -> L29
        Character r0 = f15235d;     // Catch: Exception -> L25 Throwable -> L29
        String r1 = r9.substring(0, r9.indexOf(r0.charValue())).trim();     // Catch: Exception -> L25 Throwable -> L29
        String r10 = r9.substring(r9.indexOf(r0.charValue()) + 1, r9.length()).trim();     // Catch: Exception -> L25 Throwable -> L29
        String[] r2 = r1.split("\\(");     // Catch: Exception -> L25 Throwable -> L29
        String[] r11 = r10.split(" ");     // Catch: Exception -> L25 Throwable -> L29
        if (r2.length > 1) goto L14;
    L21:
        d.b.w.a.d.c.a(r5);
        return r7;
    L14:
        if (r11.length <= 14) goto L21;
        if (r7 != null) goto L18;
        r7 = new d.b.w.a.b.e.d();     // Catch: Exception -> L25 Throwable -> L29
    L18:
        r7.g(Integer.parseInt(r2[0].trim()));     // Catch: Exception -> L25 Throwable -> L29
        r7.h(r2[1].trim());     // Catch: Exception -> L25 Throwable -> L29
        r7.e((((Integer.parseInt(r11[11]) + Integer.parseInt(r11[12])) + Integer.parseInt(r11[13])) + Integer.parseInt(r11[14])) * 10);     // Catch: Exception -> L25 Throwable -> L29
        d.b.w.a.d.c.a(r5);
        return r7;
    L25:
        e = move-exception;
        d.b.w.a.d.b.c(Log.getStackTraceString(e));     // Catch: Throwable -> L29
        d.b.w.a.d.c.a(r5);
        return r7;
    L29:
        d.b.w.a.d.c.a(r5);
        return r7;
    }
}
