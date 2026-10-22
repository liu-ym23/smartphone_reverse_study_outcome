package tmsdkobf;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class z8 {
    public static i3 a(i3 r7, byte[] r8) {
        if (r8 != null) goto L5;
    L51:
        Log.w("TuringDebug", "u1");
        return r7;
    L5:
        if (r8.length == 0) goto L51;
        byte[] r9 = zj.a(r8, zj.a());
        if (r9 != null) goto L10;
    L49:
        Log.w("TuringDebug", "u2");
        return r7;
    L10:
        if (r9.length == 0) goto L49;
        byte[] r10 = kl.b(r9);
        if (r10 != null) goto L15;
    L47:
        Log.w("TuringDebug", "u3");
        return r7;
    L15:
        if (r10.length == 0) goto L47;
        q r2 = new q();
        new HashMap();
        HashMap r3 = new HashMap();
        r2.f425a = 3;
        r2.d = 3;
        if (r10.length < 4) goto L46;
        y1 r4 = new y1(r10, 4);     // Catch: Exception -> L42
        r4.b = "UTF-8";     // Catch: Exception -> L42
        r2.a(r4);     // Catch: Exception -> L42
        r4.f629a = ByteBuffer.wrap(r2.g);     // Catch: Exception -> L42
        if (y8.f636a != null) goto L22;
        HashMap r11 = new HashMap();     // Catch: Exception -> L42
        y8.f636a = r11;     // Catch: Exception -> L42
        r11.put("", new byte[0]);     // Catch: Exception -> L42
    L22:
        HashMap r12 = r4.a(y8.f636a, 0, false);     // Catch: Exception -> L42
    L39:
        th = move-exception;
        Log.w("TuringDebug", th);
        return r7;
    L24:
        if (r12.containsKey("resp") == true) goto L26;
        Object r13 = null;
    L58:
        return (i3) r13;
    L26:
        if (r3.containsKey("resp") == false) goto L28;
        r13 = r3.get("resp");     // Catch: Throwable -> L39
        goto L58
    L28:
        byte[] r14 = (byte[]) r12.get("resp");     // Catch: Throwable -> L39
        y1 r5 = new y1();     // Catch: Exception -> L33 Throwable -> L39
        r5.f629a = ByteBuffer.wrap(r14);     // Catch: Exception -> L33 Throwable -> L39
        r5.b = "UTF-8";     // Catch: Exception -> L33 Throwable -> L39
        r13 = r5.a(r7, 0, true);     // Catch: Exception -> L33 Throwable -> L39
        if (r13 == null) goto L58;
        r3.put("resp", r13);     // Catch: Exception -> L33 Throwable -> L39
    L33:
        e = move-exception;
        throw new Exception(e);     // Catch: Throwable -> L39
    L42:
        e = move-exception;
        throw new RuntimeException(e);
    L46:
        throw new IllegalArgumentException("decode package must include size head");
    }
}
