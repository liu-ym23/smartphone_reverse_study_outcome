package tmsdkobf;

import android.content.Context;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public abstract class q1 {
    public static String a(Context r6) {
        HashSet r1 = new HashSet();
        String r2 = r6.getPackageName();     // Catch: Throwable -> L10
        Pattern r0 = Pattern.compile("^/data/user/\\d+/" + r2);     // Catch: Throwable -> L10
        String r7 = r6.getApplicationInfo().nativeLibraryDir;     // Catch: Throwable -> L10
        BufferedReader r3 = new BufferedReader(new FileReader(xk.a(xk.n)));     // Catch: Throwable -> L10
    L37:
        String r4 = r3.readLine();     // Catch: Throwable -> L34
        if (r4 == null) goto L11;
        String r5 = a(r4, r2, r0, r7);     // Catch: Throwable -> L34
        if (r5 == null) goto L37;
        r1.add(r5);     // Catch: Throwable -> L34
    L11:
        j.a(r3);
        Pattern[] r8 = xf.a();
        Iterator r9 = r1.iterator();
    L12:
        int r10 = 0;
        if (r9.hasNext() == false) goto L21;
        String r11 = (String) r9.next();
        int r12 = r8.length;
    L15:
        if (r10 >= r12) goto L12;
        if (r8[r10].matcher(r11).find() == true) goto L18;
        r10 = r10 + 1;
        goto L15
    L18:
        r9.remove();
        goto L12
    L21:
        if (r1.size() <= 0) goto L32;
        StringBuilder r13 = new StringBuilder();
        Iterator r14 = r1.iterator();
    L24:
        if (r14.hasNext() == false) goto L55;
        r10 = r10 + 1;
        r13.append((String) r14.next());
        if (r10 >= 8) goto L55;
        if (r14.hasNext() == false) goto L24;
        r13.append("_");
    L55:
        return r13.toString();
    L32:
        return "";
    L10:
        r3 = null;
        goto L11
    }

    public static String a() {
        File r0 = new File("/system/lib");     // Catch: Throwable -> L13
        if (r0.canRead() == false) goto L11;
        File[] r1 = r0.listFiles();     // Catch: Throwable -> L13
        int r2 = r1.length;     // Catch: Throwable -> L13
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        File r4 = r1[r3];     // Catch: Throwable -> L13
        if (r4.getName().contains("rockchip") == true) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        return r4.getAbsolutePath();
    L11:
        return "";
    }

    public static String a(String r4, String r5, Pattern r6, String r7) {
        boolean r0 = r4.endsWith(LibrarianImpl.Constants.SO_SUFFIX);
        if (r0 == false) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r0 == true) goto L12;
        if (r1 == true) goto L12;
        return null;
    L12:
        int r2 = r4.indexOf(47);
        if (r2 != (-1)) goto L15;
        return null;
    L15:
        String r8 = r4.substring(r2).trim();
        if (r8.startsWith("/data/") == true) goto L18;
        return null;
    L18:
        if (r0 == false) goto L23;
        if (r7 == null) goto L23;
        if (r8.startsWith(r7) == false) goto L23;
        return null;
    L23:
        String r9 = "/data/data/" + r5 + LibrarianImpl.Constants.SEPARATOR;
        if (r8.startsWith(r9) == false) goto L27;
        return null;
    L27:
        if (r8.startsWith("/data/app/" + r5) == false) goto L30;
        return null;
    L30:
        if (r6.matcher(r8).find() == false) goto L32;
        return null;
    L32:
        if (r0 == false) goto L41;
        File r10 = new File(r9 + LibrarianImpl.Constants.LIB_PREFIX);
        HashMap r11 = xj.f624a;
        String r12 = r10.getCanonicalPath();     // Catch: IOException -> L36
    L37:
        if (r12 != null) goto L39;
    L40:
        return null;
    L39:
        if (r8.startsWith(r12) == false) goto L41;
    L36:
        r12 = null;
    L41:
        return r8;
    L5:
        if (r4.endsWith(".jar") == false) goto L7;
        r1 = true;
        goto L9
    }
}
