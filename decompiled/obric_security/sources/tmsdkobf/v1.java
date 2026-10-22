package tmsdkobf;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f563a = null;
    public static final String[] b = null;
    public static final Set c = null;

    static {
        HashSet r0 = new HashSet();
        f563a = r0;
        b = new String[0];
        r0.add(xk.a(xk.M));
        r0.add(xk.a(xk.N));
        r0.add(xk.a(xk.O));
        r0.add(xk.a(xk.P));
        r0.add(xk.a(xk.Q));
        r0.add(xk.a(xk.R));
        r0.add(xk.a(xk.S));
        r0.add(xk.a(xk.T));
        r0.add(xk.a(xk.U));
        r0.add(xk.a(xk.V));
        r0.add(xk.a(xk.W));
        r0.add(xk.a(xk.X));
        HashSet r1 = new HashSet();
        c = r1;
        r1.add(xk.a(xk.L));
    }

    public static List a() {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        String[] r2 = new File("/proc").list();
        if (r2 == null) goto L19;
        int r4 = r2.length;
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L19;
        String r6 = r2[r5];
        if (TextUtils.isEmpty(r6) == true) goto L18;
        char r7 = r6.charAt(0);     // Catch: Exception -> L111
        if (r7 > '9') goto L18;
        if (r7 < '0') goto L18;
        af.a r8 = af.b(Integer.parseInt(r6));     // Catch: Exception -> L111
        if (r8 == null) goto L18;
        r1.add(r8);     // Catch: Exception -> L111
    L18:
        r5 = r5 + 1;
    L19:
        ArrayList r3 = new ArrayList();
        int r9 = Process.myPid();
        Iterator r10 = r1.iterator();
        int r11 = 0;
    L21:
        if (r10.hasNext() == false) goto L25;
        af.a r12 = (af.a) r10.next();
        if (r9 != r12.f99a) goto L21;
        r11 = r12.e;
        goto L21
    L25:
        if (r11 == 0) goto L38;
        if (r9 == r11) goto L38;
        Iterator r13 = r1.iterator();
        String r14 = "";
    L30:
        if (r13.hasNext() == false) goto L35;
        af.a r15 = (af.a) r13.next();
        if (r11 != r15.f99a) goto L30;
        r14 = r15.d;
        goto L30
    L35:
        if (TextUtils.isEmpty(r14) == true) goto L38;
        nk r16 = new nk();
        r16.f376a = q3.f431a + q3.e;
        r16.b = r14;
        r3.add(r16);
    L38:
        r0.addAll(r3);
        StringBuilder r17 = new StringBuilder();
        ArrayList r18 = new ArrayList();
        Iterator r19 = r1.iterator();
    L40:
        if (r19.hasNext() == false) goto L47;
        af.a r20 = (af.a) r19.next();
        Iterator r21 = ((HashSet) f563a).iterator();
    L43:
        if (r21.hasNext() == false) goto L40;
        if (r20.d.contains((String) r21.next()) == false) goto L43;
        r17.append(r20.d);
        r17.append("_");
        goto L43
    L47:
        String r22 = r17.toString();
        if (TextUtils.isEmpty(r22) == true) goto L50;
        nk r23 = new nk();
        r23.f376a = q3.f431a + q3.c;
        r23.b = r22.substring(0, r22.length() - 1);
        r18.add(r23);
    L50:
        r0.addAll(r18);
        ArrayList r24 = new ArrayList();
        StringBuilder r25 = new StringBuilder();
        HashSet r26 = new HashSet();
        Iterator r27 = r1.iterator();
        int r28 = 0;
    L52:
        if (r27.hasNext() == false) goto L103;
        af.a r29 = (af.a) r27.next();
        if (r29.c != 0) goto L52;
        if (r29.d.startsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L52;
        if (r29.d.startsWith("/system") == true) goto L52;
        if (r29.d.startsWith("/dev") == true) goto L52;
        if (r29.d.startsWith("/sbin") == true) goto L52;
        if (r29.d.startsWith("/init") == true) goto L52;
        if (r29.d.startsWith("/vendor") == true) goto L52;
        if (r29.d.startsWith("/bin") == true) goto L52;
        if (r29.d.startsWith("/usr") == true) goto L52;
        if (r29.d.contains("kinguser") == true) goto L52;
        if (r29.d.endsWith("so") == true) goto L52;
        Iterator r30 = ((HashSet) f563a).iterator();
    L88:
        if (r30.hasNext() == false) goto L92;
        if (r29.d.contains((String) r30.next()) == false) goto L88;
    L92:
        Iterator r31 = ((HashSet) c).iterator();
    L94:
        if (r31.hasNext() == false) goto L98;
        if (r29.d.contains((String) r31.next()) == false) goto L94;
    L98:
        r26.add(r29.d);
        int r32 = r28 + 1;
        if (r28 >= 8) goto L103;
        r28 = r32;
    L103:
        if (r26.size() <= 0) goto L109;
        Iterator r33 = r26.iterator();
    L106:
        if (r33.hasNext() == false) goto L108;
        r25.append((String) r33.next());
        r25.append("%3B");
        goto L106
    L108:
        String r34 = r25.toString();
        nk r35 = new nk();
        r35.f376a = q3.f431a + q3.d;
        r35.b = r34.substring(0, r34.length() - 1);
        r24.add(r35);
    L109:
        r0.addAll(r24);
        return r0;
    }

    public static String b() {
        StringBuffer r0 = new StringBuffer();
        String r1 = a(xk.a(xk.o0), xk.a(xk.C0), "v4");
        if (TextUtils.isEmpty(r1) == true) goto L5;
        r0.append(r1);
    L5:
        String r2 = a(xk.a(xk.p0), "(.{32}:.{3,4})\\s(.{32}:.{3,4})\\s(.{2})\\s.{8}:.{8}\\s.{2}:.{8}\\s.{8}\\s+(.{4,5})", "v6");
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (TextUtils.isEmpty(r1) == true) goto L10;
        r0.append("_");
    L10:
        r0.append(r2);
    L12:
        return r0.toString();
    }

    public static String a(String r8, String r9, String r10) {
        StringBuffer r0 = new StringBuffer();
        String r1 = new String(xj.a(r8));     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r1) == false) goto L7;
        String[] r11 = b;
    L13:
        if (r11 != null) goto L16;
        r0.append(r10 + ";-1");
        return r0.toString();
    L16:
        r0.append(r10 + ";0");
        new HashMap();
        HashMap r12 = new HashMap();
        Pattern r13 = Pattern.compile(r9);
        int r2 = r11.length;
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L32;
        Matcher r4 = r13.matcher(r11[r3]);
        if (r4.find() == false) goto L30;
        String r5 = r4.group(4).trim();
        if ("0A".equals(r4.group(3)) == false) goto L30;
        String[] r6 = r4.group(1).split(":");
        if (r6 == null) goto L30;
        if (r6.length < 2) goto L30;
        r12.put(r6[1], r5);
    L30:
        r3 = r3 + 1;
        goto L18
    L32:
        if (r12.isEmpty() == true) goto L40;
        r0.append(";");
        Iterator r14 = r12.keySet().iterator();
    L35:
        if (r14.hasNext() == false) goto L40;
        String r15 = (String) r14.next();
        r0.append((String) r12.get(r15));
        r0.append(":");
        r0.append(r15);
        if (r14.hasNext() == false) goto L35;
        r0.append(",");
    L40:
        return r0.toString();
    L7:
        r11 = r1.split(IOUtils.LINE_SEPARATOR_UNIX);
        if (r11 != null) goto L10;
    L11:
        r11 = b;
        goto L13
    L10:
        if (r11.length != 0) goto L13;
    L12:
        r11 = null;
        goto L13
    }
}
