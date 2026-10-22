package ms.bd.c;

import android.os.Build;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f22573e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f22574f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f22575g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f22576h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f22577i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f22580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Throwable f22581d;

    static {
        f22573e = (String) m.a(16777217, 0, 0, "f312c8", new byte[]{99});
        f22574f = (String) m.a(16777217, 0, 0, "870e82", new byte[]{59});
        f22575g = (String) m.a(16777217, 0, 0, "d22584", new byte[]{102});
        f22576h = (String) m.a(16777217, 0, 0, "94ca52", new byte[]{46});
        f22577i = (String) m.a(16777217, 0, 0, "ca2ece", new byte[]{113});
    }

    public z2(int r2, String r3, String r4) {
        this(r2, r3, r4, null);
    }

    private z2(int r1, String r2, String r3, Throwable r4) {
        this.f22578a = r1;
        this.f22579b = r2;
        this.f22580c = r3;
        this.f22581d = r4;
    }

    public static z2 a(int r3) {
        return new z2(r3, "", "", null);
    }

    public static z2 b(int r2, Throwable r3) {
        return new z2(r2, "", "", r3);
    }

    public String[] c() {
        String[] r1 = new String[2];
        int r3 = 0;
        r1[0] = String.valueOf(this.f22578a);
        JSONObject r2 = new JSONObject();
        r2.put(f22573e, System.currentTimeMillis());     // Catch: Throwable -> L20
        r2.put(f22574f, this.f22578a);     // Catch: Throwable -> L20
        if (this.f22581d == null) goto L12;
        String r4 = f22575g;     // Catch: Throwable -> L20
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L20
        r5.append(this.f22581d.getMessage());     // Catch: Throwable -> L20
        StackTraceElement[] r11 = this.f22581d.getStackTrace();     // Catch: Throwable -> L20
        int r6 = r11.length;     // Catch: Throwable -> L20
        int r7 = 0;
    L6:
        if (r3 >= r6) goto L11;
        StackTraceElement r8 = r11[r3];     // Catch: Throwable -> L20
        int r9 = r7 + 1;     // Catch: Throwable -> L20
        if (r7 >= 3) goto L11;
        r5.append("\n");     // Catch: Throwable -> L20
        r5.append(r8.toString());     // Catch: Throwable -> L20
        r3 = r3 + 1;     // Catch: Throwable -> L20
        r7 = r9;
    L11:
        r2.put(r4, r5.toString());     // Catch: Throwable -> L20
    L14:
        if (Build.VERSION.SDK_INT < 19) goto L17;
        String r12 = Base64.encodeToString(r2.toString().getBytes(StandardCharsets.UTF_8), 2);     // Catch: Throwable -> L20
    L18:
        r1[1] = r12;
        return r1;
    L12:
        r2.put(f22576h, this.f22579b);     // Catch: Throwable -> L20
        r2.put(f22577i, this.f22580c);     // Catch: Throwable -> L20
    L17:
        r12 = "";
        goto L18
    }
}
