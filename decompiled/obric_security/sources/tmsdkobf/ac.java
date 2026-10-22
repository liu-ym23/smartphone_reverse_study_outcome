package tmsdkobf;

import android.os.Environment;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List f93a = null;
    private static final List b = null;
    private static List c;

    static {
        f93a = new ArrayList();
        b = new ArrayList();
        c = new ArrayList();
    }

    public static void a(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        List r0 = f93a;
        if (r0.contains(r2) == true) goto L8;
        r0.add(r2);
        return;
    }

    public static void b(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        c.add(r1);
    }

    public static List c() {
        List r0 = z4.b(TMSDKContext.getApplicaionContext());
        if (r0.size() <= 0) goto L6;
    L4:
        r0.addAll(f93a);
        a(r0);
        return r0;
    L6:
        r0 = b(md.a());
        if (r0 != null) goto L9;
    L10:
        r0 = new ArrayList();
        r0.add(Environment.getExternalStorageDirectory().getAbsolutePath());
        goto L4
    L9:
        if (r0.size() > 0) goto L4;
        goto L4
    }

    public static List d() {
        return c;
    }

    public static List e() {
        List r0 = z4.b(TMSDKContext.getApplicaionContext());
        if (r0 != null) goto L5;
    L6:
        r0 = b(md.a());
        if (r0 != null) goto L9;
    L10:
        r0 = new ArrayList();
        r0.add(Environment.getExternalStorageDirectory().getAbsolutePath());
    L11:
        Iterator r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        q8.c("SdcardRoot", "getRealSdcardRoots :[" + ((String) r1.next()) + "]");
        goto L13
    L15:
        return r0;
    L9:
        if (r0.size() > 0) goto L11;
    L5:
        if (r0.size() > 0) goto L11;
        goto L6
    }

    public static void a() {
        f93a.clear();
    }

    public static List b() {
        List r0 = e();
        ArrayList r1 = new ArrayList();
        if (r0 == null) goto L10;
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        File[] r3 = new File((String) r2.next()).listFiles();
        if (r3 == null) goto L6;
        r1.addAll(Arrays.asList(r3));
    L10:
        return r1;
    }

    public static String c(String r2) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        int r0 = r2.lastIndexOf(LibrarianImpl.Constants.SEPARATOR);
        if (r0 >= 0) goto L7;
        return r2;
    L7:
        if (r0 < (r2.length() - 1)) goto L9;
        return r2;
    L9:
        return r2.substring(r0 + 1, r2.length());
    }

    public static String d(String r2) {
        String r3 = c(r2);
        if (r3 != null) goto L5;
        return r3;
    L5:
        int r0 = r3.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r0 > 0) goto L8;
        return r3;
    L8:
        if (r0 < (r3.length() - 1)) goto L10;
        return r3;
    L10:
        return r3.substring(0, r0);
    }

    public static String a(String r11, String r12) {
        String r0 = r11;
    L4:
        if (r0.startsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L6;
        r0 = r0.substring(1);
        goto L4
    L6:
        String r2 = r12;
    L8:
        if (r2.startsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L10;
        r2 = r2.substring(1);
        goto L8
    L10:
        String[] r1 = r0.split(LibrarianImpl.Constants.SEPARATOR);
        String[] r3 = r2.split(LibrarianImpl.Constants.SEPARATOR);
        if (r1.length >= r3.length) goto L13;
        boolean r4 = true;
        r3 = (String[]) r1.clone();
        r1 = r3;
    L14:
        int r5 = 0;
        int r6 = 0;
    L16:
        if (r5 >= r1.length) goto L34;
        if (r1[r5].equals(r3[0]) == false) goto L33;
        r6 = r6 + 1;
        int r7 = 1;
    L21:
        if (r7 >= r3.length) goto L29;
        int r8 = r5 + r7;
        if (r8 >= r1.length) goto L27;
        if (r1[r8].equals(r3[r7]) == false) goto L27;
        r6 = r6 + 1;
        r7 = r7 + 1;
    L27:
        r6 = 0;
    L29:
        if (r6 != r3.length) goto L33;
        if (r4 == false) goto L32;
        return r12;
    L32:
        return r11;
    L33:
        r5 = r5 + 1;
        goto L16
    L34:
        return null;
    L13:
        r4 = false;
        goto L14
    }

    private static List b(List r6) {
        int r0 = 0;
        boolean r1 = false;
    L4:
        if (r0 >= r6.size()) goto L20;
        int r2 = r0 + 1;
        int r3 = r2;
    L7:
        if (r3 >= r6.size()) goto L12;
        String r4 = a((String) r6.get(r0), (String) r6.get(r3));
        if (r4 != null) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        r6.remove(r4);
        r1 = true;
    L12:
        if (r1 == true) goto L15;
        r0 = r2;
        goto L4
    L15:
        return b(r6);
    L20:
        return r6;
    }

    public static void c(List r1) {
        List r0 = b;
        r0.clear();
        r0.addAll(r1);
    }

    private static void a(List r3) {
        Iterator r0 = b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = (String) r0.next();
        if (r3.contains(r1) == false) goto L4;
        r3.remove(r1);
        goto L4
    }

    public static String a(String r2, List r3) {
        if (r2 == null) goto L17;
        if (r3 != null) goto L5;
        return r2;
    L5:
        if (r3.isEmpty() == true) goto L19;
        Iterator r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L20;
        String r0 = (String) r4.next();
        if (r2.contains(r0) == false) goto L9;
        return r2.replaceFirst(r0, "");
    L20:
        return r2;
    L19:
        return r2;
    L17:
        return r2;
    }
}
