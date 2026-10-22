package ms.bd.c;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f22393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f22394b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f22395c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f22396d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f22397e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f22398f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f22399g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f22400h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f22401i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final FileFilter f22402j = null;

    static class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File r7) {
            return Pattern.matches((String) m.a(16777217, 0, 0, "80e12b", new byte[]{42, 34, 3, 126, 93, 56, 98, 44}), r7.getName());
        }
    }

    static {
        f22393a = (String) m.a(16777217, 0, 0, "f132dc", new byte[]{71, 33, 79, 69, 94, 103, 118, 31, 112});
        f22394b = (String) m.a(16777217, 0, 0, "4d4d38", new byte[]{13, 103, 85, 20, 27, 46, 37, 64});
        f22395c = (String) m.a(16777217, 0, 0, "7247e1", new byte[]{0, 53, 70, 87, 79, 52, 49, 0});
        f22396d = (String) m.a(16777217, 0, 0, "8e9acc", new byte[]{57, 100});
        f22397e = (String) m.a(16777217, 0, 0, "c8745a", new byte[]{122, 45});
        f22398f = (String) m.a(16777217, 0, 0, "a0bdaa", new byte[]{118, 38});
        f22399g = (String) m.a(16777217, 0, 0, "867258", new byte[]{36, 53, 92});
        f22400h = (String) m.a(16777217, 0, 0, "7d7a0f", new byte[]{43, 111, 74});
        f22401i = (String) m.a(16777217, 0, 0, "65b432", new byte[]{36, 56, 3, 69});
        f22402j = new a();
    }

    private static int a() {
    L6:
        return -1;
    L4:
        return new File((String) m.a(16777217, 0, 0, "727d82", new byte[]{105, 35, 93, 3, 72, 33, 49, 5, 111, 55, 35, 35, 11, 3, 30, 54, 32, 22, 107, 123, 37, 32, 81, 95})).listFiles(f22402j).length;
    }

    private static String b(String r10) {
        String r2 = null;
        File r3 = new File(r10);     // Catch: Throwable -> L14
        if (r3.exists() == false) goto L7;
        FileReader r11 = new FileReader(r3);     // Catch: Throwable -> L14
        BufferedReader r4 = new BufferedReader(r11);     // Catch: Throwable -> L13
        r2 = r4.readLine();     // Catch: Throwable -> L25
        r4.close();     // Catch: Throwable -> L23
    L29:
        r11.close();     // Catch: Throwable -> L24
    L19:
        if (r2 != null) goto L22;
        return (String) m.a(16777217, 0, 0, "66ff35", new byte[]{119});
    L22:
        return r2.trim();
    L15:
        if (r4 != null) goto L36;
    L17:
        if (r11 == null) goto L19;
    L36:
        r4.close();     // Catch: Throwable -> L26
    L13:
        r4 = null;
        goto L15
    L7:
        return (String) m.a(16777217, 0, 0, "b1868d", new byte[]{35});
    L14:
        r11 = null;
        r4 = null;
        goto L15
    }

    private static String c(HashMap<String, String> r0, String r1) {
        String r2 = r0.get(r1);     // Catch: Throwable -> L4
    L5:
        if (r2 != null) goto L8;
        return "";
    L8:
        return r2.trim();
    L4:
        r2 = null;
        goto L5
    }

    private static HashMap<String, String> d() {
        HashMap<String, String> r0 = new HashMap();
        BufferedReader r1 = null;
    L21:
        FileReader r2 = null;
    L22:
        if (r1 != null) goto L33;
    L24:
        if (r2 != null) goto L37;
    L26:
        return r0;
    L37:
        r2.close();     // Catch: Throwable -> L28
        goto L26
    L33:
        r1.close();     // Catch: Throwable -> L30
        goto L24
    L5:
        r2 = new FileReader((String) m.a(16777217, 0, 0, "d0cc9c", new byte[]{58, 34, 2, 24, 5, 59, 100, 1, 39, 58, 123, 52, 31}));     // Catch: Throwable -> L21
        BufferedReader r3 = new BufferedReader(r2);     // Catch: Throwable -> L29
    L39:
        String r4 = r3.readLine();     // Catch: Throwable -> L20
        if (r4 != null) goto L12;
        r3.close();     // Catch: Throwable -> L27
        goto L37
    L12:
        String[] r5 = r4.split((String) m.a(16777217, 0, 0, "138ab9", new byte[]{122}), 2);     // Catch: Throwable -> L20
        if (r5.length < 2) goto L39;
        String r6 = r5[0].trim();     // Catch: Throwable -> L20
        String r7 = r5[1].trim();     // Catch: Throwable -> L20
        if (r0.get(r6) != null) goto L39;
        r0.put(r6, r7);     // Catch: Throwable -> L20
    L20:
        r1 = r3;
        goto L22
    }

    public static String e() {
        JSONObject r0 = new JSONObject();
        HashMap<String, String> r2 = d();     // Catch: Throwable -> L13
        r0.put(f22401i, a());     // Catch: Throwable -> L13
        r0.put(f22396d, c(r2, f22393a));     // Catch: Throwable -> L13
        r0.put(f22397e, c(r2, f22394b));     // Catch: Throwable -> L13
        r0.put(f22399g, b((String) m.a(16777217, 0, 0, "7dcd05", new byte[]{105, 117, 9, 3, 64, 38, 49, 83, 59, 55, 35, 117, 95, 3, 22, 49, 32, 64, 63, 123, 37, 118, 5, 95, 12, 50, 33, 21, 125, 55, 54, 115, 22, 2, 10, 51, 123, 70, 34, 33, 47, 104, 22, 31, 48, 47, 53, 93, 13, 50, 52, 99, 1})));     // Catch: Throwable -> L13
        r0.put(f22400h, b((String) m.a(16777217, 0, 0, "38a472", new byte[]{109, 41, 11, 83, 71, 33, 53, 15, 57, 103, 39, 41, 93, 83, 17, 54, 36, 28, 61, 43, 33, 42, 7, 15, 11, 53, 37, 73, 127, 103, 50, 47, 20, 82, 13, 52, 127, 26, 32, 113, 43, 52, 20, 79, 55, 40, 57, 23, 15, 98, 48, 63, 3})));     // Catch: Throwable -> L13
        r0.put(f22398f, c(r2, f22395c));     // Catch: Throwable -> L13
    L8:
        String r1 = r0.toString();
        if (TextUtils.isEmpty(r1) == false) goto L12;
        return (String) m.a(16777217, 0, 0, "2e8cc9", new byte[]{56, 122});
    L12:
        return r1.trim();
    }
}
