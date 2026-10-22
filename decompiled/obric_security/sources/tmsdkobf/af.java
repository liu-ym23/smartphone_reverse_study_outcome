package tmsdkobf;

import android.text.TextUtils;
import com.obric.oui.utils.AnimTokens;
import java.util.HashMap;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class af {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f99a;
        public int b;
        public int c;
        public String d;
        public int e;

        public a(int r1, int r2, String r3, int r4, String r5, int r6) {
            this.f99a = r1;
            this.b = r2;
            this.d = r3;
            this.c = r4;
            this.e = r6;
        }

        public String toString() {
            return "" + String.format("% 6d", new Object[]{Integer.valueOf(this.f99a)}) + "    " + String.format("% 6d", new Object[]{Integer.valueOf(this.b)}) + "    " + String.format("% 6d", new Object[]{Integer.valueOf(this.c)}) + "    " + this.d;
        }
    }

    public static a b(int r12) {
        String r2 = a(r12);     // Catch: Throwable -> L20
        if (r12 == (-1)) goto L7;
        String r5 = new String(xj.a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/%d/status", new Object[]{Integer.valueOf(r12)})));     // Catch: Throwable -> L30
    L8:
        HashMap r6 = new HashMap();     // Catch: Throwable -> L30
        String[] r7 = r5.split(IOUtils.LINE_SEPARATOR_UNIX);     // Catch: Throwable -> L30
        int r8 = r7.length;     // Catch: Throwable -> L30
        int r9 = 0;
    L9:
        if (r9 >= r8) goto L15;
        String[] r10 = r7[r9].split(":");     // Catch: Throwable -> L30
        if (r10.length < 2) goto L14;
        r6.put(r10[0].trim(), r10[1].trim());     // Catch: Throwable -> L30
    L14:
        r9 = r9 + 1;     // Catch: Throwable -> L30
        goto L9
    L15:
        int r3 = Integer.parseInt((String) r6.get("PPid"));     // Catch: Throwable -> L30
        int r4 = Integer.parseInt(((String) r6.get("Uid")).split("\\s+")[0]);     // Catch: Throwable -> L19
        String r11 = r2;
        int r13 = r3;
        int r14 = r4;
        int r15 = Integer.parseInt((String) r6.get("TracerPid"));     // Catch: Throwable -> L29
    L23:
        if (r11 == null) goto L42;
        if (r13 == (-1)) goto L43;
        if (r14 != (-1)) goto L28;
        return null;
    L28:
        return new a(r12, r13, r11, r14, null, r15);
    L43:
        return null;
    L42:
        return null;
    L22:
        r15 = -1;
        r11 = r2;
        r13 = r3;
        r14 = r4;
    L19:
        r4 = -1;
        goto L22
    L7:
        r5 = new String(xj.a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/self/status", new Object[0])));     // Catch: Throwable -> L30
    L21:
        r3 = -1;
        r4 = -1;
    L20:
        r2 = null;
        goto L21
    }

    public static String a(int r7) {
        Locale r1 = Locale.SIMPLIFIED_CHINESE;     // Catch: Throwable -> L16
        byte[] r2 = xj.a(String.format(r1, "/proc/%d/cmdline", new Object[]{Integer.valueOf(r7)}), 100);     // Catch: Throwable -> L16
        if (r2 == null) goto L6;
        String r5 = new String(r2, 0, a(r2, 0, 0));     // Catch: Throwable -> L16
    L8:
        if (TextUtils.isEmpty(r5) == false) goto L21;
        byte[] r8 = xj.a(String.format(r1, "/proc/%d/status", new Object[]{Integer.valueOf(r7)}), AnimTokens.OUI_ANIMATION_DURATION_SHORT_3);     // Catch: Throwable -> L16
        if (r8 == null) goto L22;
        int r3 = a(r8, 7, '\n');     // Catch: Throwable -> L16
        if (r3 != 0) goto L14;
        return "";
    L14:
        return new String(r8, 6, r3 - 6);
    L22:
        return r5;
    L21:
        return r5;
    L6:
        r5 = "";
    L16:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static int a(byte[] r2, int r3, char r4) {
        int r5 = r3 - 1;
    L3:
        int r0 = r5 + 1;
        if (r5 >= r2.length) goto L12;
        if (r0 == r2.length) goto L11;
        if (r2[r0] == r4) goto L11;
        r5 = r0;
    L11:
        return r0;
    L12:
        return 0;
    }
}
