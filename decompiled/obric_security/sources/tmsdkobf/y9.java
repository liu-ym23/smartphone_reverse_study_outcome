package tmsdkobf;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.platform.godzilla.common.Constant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
public abstract class y9 {
    public static String a(String r3) {
        StringBuffer r0 = new StringBuffer();
        Matcher r4 = Pattern.compile("\\\\u([\\S]{4})([^\\\\]*)").matcher(r3);
    L4:
        if (r4.find() == false) goto L7;
        r0.append((char) Integer.parseInt(r4.group(1), 16));
        r0.append(r4.group(2));
        goto L4
    L7:
        return r0.toString();
    }

    public static List b(String r13) {
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(r13) == false) goto L5;
        return r0;
    L5:
        int r2 = r13.lastIndexOf(47);
        Pattern r5 = null;
        if (r2 != (-1)) goto L8;
    L29:
        String r6 = r13;
        String r3 = null;
    L31:
        if (TextUtils.isEmpty(r3) == false) goto L63;
    L33:
        r13 = r6;
    L34:
        Iterator r4 = ac.c().iterator();
    L36:
        if (r4.hasNext() == false) goto L61;
        File r7 = new File(((String) r4.next()) + LibrarianImpl.Constants.SEPARATOR + r13);
        if (r7.exists() == false) goto L36;
        if (r7.isDirectory() == false) goto L36;
        File[] r8 = r7.listFiles();
        if (r8 == null) goto L36;
        int r9 = r8.length;
        int r10 = 0;
    L45:
        if (r10 >= r9) goto L36;
        File r11 = r8[r10];
        if (r11.isDirectory() == false) goto L60;
        if (r5 != null) goto L65;
        r0.add(r11.getAbsolutePath());     // Catch: Exception -> L58
        goto L60
    L65:
        String r12 = r11.getAbsolutePath();     // Catch: Exception -> L58
        int r14 = r12.lastIndexOf(47);     // Catch: Exception -> L58
        if (r14 == (-1)) goto L60;
        if (r14 >= (r12.length() - 1)) goto L60;
        if (r5.matcher(r12.substring(r14 + 1)).matches() == false) goto L60;
        a(r11, r0);     // Catch: Exception -> L58
    L58:
        e = move-exception;
        q8.b("OfflineVideoUtil", "getAllMatchPath error :" + e.getMessage() + " path :" + r11.getAbsolutePath());
    L60:
        r10 = r10 + 1;
        goto L45
    L61:
        return r0;
    L63:
        r5 = Pattern.compile(r3);     // Catch: Exception -> L62
    L8:
        if (r2 >= (r13.length() - 1)) goto L29;
        r6 = r13.substring(0, r2);
        r3 = r13.substring(r2 + 1);
        if (r3.contains("*") == true) goto L31;
        if (r3.contains("+") == true) goto L31;
        if (r3.contains("?") == true) goto L31;
        if (r3.contains("[") == true) goto L31;
        if (r3.contains("]") == true) goto L31;
        if (r3.contains("(") == true) goto L31;
        if (r3.contains(")") == true) goto L31;
        if (r3.contains("|") == true) goto L31;
        if (r3.contains("^") == true) goto L31;
        if (r3.contains("$") == true) goto L31;
        goto L29
    }

    public static String c(String r6) {
        byte[] r7 = x8.a(r6);
        StringBuilder r0 = new StringBuilder(r7.length * 2);
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        String r3 = Integer.toHexString(r7[r2] & UByte.MAX_VALUE);
        if (r3.length() != 1) goto L7;
        r3 = "0" + r3;
    L7:
        r0.append(r3);
        r2 = r2 + 1;
        goto L3
    L9:
        return r0.toString();
    }

    public static long d(String r9) {
        long r1 = 0;
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return 0;
    L5:
        Stack r0 = new Stack();
        Stack r3 = new Stack();
        r0.push(r9);
    L7:
        if (r0.isEmpty() == true) goto L21;
        File r10 = new File((String) r0.pop());
        if (r10.isDirectory() == true) goto L10;
        r1 = r1 + r10.length();
        goto L7
    L10:
        r3.push(r10.getAbsolutePath());
        String[] r4 = r10.list();
        if (r4 == null) goto L7;
        int r5 = r4.length;
        int r6 = 0;
    L13:
        if (r6 >= r5) goto L7;
        File r8 = new File(r10, r4[r6]);
        if (r8.isDirectory() == false) goto L17;
        r0.push(r8.getAbsolutePath());
    L18:
        r6 = r6 + 1;
        goto L13
    L17:
        r1 = r1 + r8.length();
    L21:
        if (r3.isEmpty() == true) goto L23;
        r1 = r1 + new File((String) r3.pop()).length();
        goto L21
    L23:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static List e(String r5) {
        ArrayList r0 = new ArrayList();
        FileInputStream r1 = null;
        BufferedReader r2 = null;
        r2 = null;
        FileInputStream r3 = new FileInputStream(r5);     // Catch: Throwable -> L30 Exception -> L32
    L96:
        ?? r6 = new InputStreamReader(r3, Constant.CHARSET_UTF_8);     // Catch: Throwable -> L26 Exception -> L28
        BufferedReader r4 = new BufferedReader(r6);     // Catch: Throwable -> L22 Exception -> L24
    L94:
        String r7 = r4.readLine();     // Catch: Throwable -> L18 Exception -> L20
        if (r7 == null) goto L84;
        r0.add(r7);     // Catch: Throwable -> L18 Exception -> L20
    L84:
        r4.close();     // Catch: IOException -> L12
    L76:
        r6.close();     // Catch: IOException -> L16
    L80:
        r3.close();     // Catch: IOException -> L49
    L51:
        return r0;
    L49:
        e = move-exception;
        e.printStackTrace();
    L16:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
    L20:
        Exception e = e;
    L82:
        e.printStackTrace();     // Catch: Throwable -> L52
        if (r4 != null) goto L74;
    L41:
        if (r6 != 0) goto L88;
    L46:
        if (r3 == null) goto L51;
    L88:
        r6.close();     // Catch: IOException -> L44
    L44:
        e = move-exception;
        e.printStackTrace();
        goto L46
    L74:
        r4.close();     // Catch: IOException -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
    L52:
        Throwable th = th;
        r1 = r3;
        r6 = r6;
    L54:
        r3 = r1;
    L55:
        r2 = r4;
    L56:
        if (r2 != null) goto L72;
    L61:
        if (r6 != 0) goto L86;
    L66:
        if (r3 == null) goto L99;
        r3.close();     // Catch: IOException -> L69
        throw th;
    L69:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L99:
        throw th;
    L86:
        r6.close();     // Catch: IOException -> L64
    L64:
        e = move-exception;
        e.printStackTrace();
        goto L66
    L72:
        r2.close();     // Catch: IOException -> L59
    L59:
        e = move-exception;
        e.printStackTrace();
    L18:
        th = th;
    L24:
        e = move-exception;
        r4 = null;
        e = e;
    L22:
        th = th;
        goto L56
    L28:
        e = e;
        r4 = null;
    L34:
        e = e;
        r6 = r4;
    L26:
        th = move-exception;
        th = th;
        r6 = 0;
    L32:
        e = e;
        r3 = null;
        r4 = null;
    L30:
        th = move-exception;
        th = th;
        r6 = 0;
        r4 = null;
        goto L54
    }

    private static void a(File r4, List r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.exists() == true) goto L6;
        return;
    L6:
        if (r4.isDirectory() == false) goto L22;
        if (r5 == null) goto L24;
        File[] r6 = r4.listFiles();
        if (r6 == null) goto L23;
        int r0 = r6.length;
        int r1 = 0;
    L12:
        if (r1 >= r0) goto L25;
        File r2 = r6[r1];
        if (r2.isDirectory() == false) goto L16;
        r5.add(r2.getAbsolutePath());
    L16:
        r1 = r1 + 1;
        goto L12
    L25:
        return;
    L23:
        return;
    L24:
        return;
    }

    public static String b(String r1, Pattern r2) {
        Matcher r3 = r2.matcher(r1);
        if (r3.find() == true) goto L5;
        return null;
    L5:
        if (r3.groupCount() >= 1) goto L7;
        return null;
    L7:
        return r3.group(1);
    }

    public static int a(String r1, Pattern r2) {
        Matcher r3 = r2.matcher(r1);
        if (r3.find() == true) goto L5;
    L9:
        return 0;
    L5:
        if (r3.groupCount() < 1) goto L9;
        return Integer.parseInt(r3.group(1));
    }
}
