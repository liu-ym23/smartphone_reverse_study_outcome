package tmsdkobf;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class md {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f351a = null;

    static {
        f351a = new String[]{"MI 2"};
    }

    public static File a(Context r4, String r5) {
        if (r4 != null) goto L27;
        return null;
    L27:
        File r2 = r4.getExternalFilesDir("tmsecure");     // Catch: Throwable -> L13
        if (r2.exists() == true) goto L10;
        r2.mkdirs();     // Catch: Throwable -> L13
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L29;
        return r4.getExternalFilesDir("tmsecure/" + r5);
    L29:
        return r2;
    L13:
        File r6 = r4.getExternalFilesDir(r5);
        if (r6 != null) goto L30;
        File r0 = new File("/sdcard/" + r4.getPackageName() + "/files");     // Catch: Throwable -> L22
        if (r0.exists() == true) goto L19;
        r0.mkdirs();     // Catch: Throwable -> L20
    L19:
        return r0;
    L21:
        return r0;
    L31:
        return r6;
    L30:
        return r6;
    }

    public static ArrayList a() {
        ArrayList r0 = new ArrayList();
        if (a5.a() != 0) goto L7;
        String r1 = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (r1 == null) goto L7;
        r0.add(r1);
    L7:
        BufferedReader r2 = null;
        BufferedReader r3 = new BufferedReader(new FileReader("/proc/mounts"));     // Catch: Throwable -> L50 Exception -> L52
    L80:
        String r4 = r3.readLine();     // Catch: Throwable -> L46 Exception -> L48
        if (r4 == null) goto L40;
        if (r4.contains("vfat") == true) goto L19;
        if (r4.contains("exfat") == true) goto L19;
        if (r4.contains("/mnt") == true) goto L19;
        if (r4.contains("fuse") == false) goto L80;
    L19:
        String[] r5 = r4.split("\\s+");     // Catch: Throwable -> L46 Exception -> L48
        if (r5[1].equals(Environment.getExternalStorageDirectory().getPath()) == true) goto L22;
        if (r4.contains("/dev/block/vold") == false) goto L80;
        if (r4.contains("/mnt/secure") == true) goto L80;
        if (r4.contains("/mnt/asec") == true) goto L80;
        if (r4.contains("/mnt/obb") == true) goto L80;
        if (r4.contains("/dev/mapper") == true) goto L80;
        if (r4.contains("tmpfs") == true) goto L80;
        if (a(r0, r5[1]) == true) goto L80;
        String r6 = r5[1];     // Catch: Throwable -> L46 Exception -> L48
    L39:
        r0.add(r6);     // Catch: Throwable -> L46 Exception -> L48
        goto L80
    L22:
        if (a(r0, r5[1]) == true) goto L80;
        r6 = r5[1];     // Catch: Throwable -> L46 Exception -> L48
        goto L39
    L40:
        a(r0);     // Catch: Throwable -> L46 Exception -> L48
        r3.close();     // Catch: IOException -> L43
    L45:
        return r0;
    L43:
        e = move-exception;
        e.printStackTrace();
        goto L45
    L48:
        Exception e = e;
    L70:
        e.printStackTrace();     // Catch: Throwable -> L61
        if (r3 != null) goto L76;
    L60:
        return r0;
    L76:
        r3.close();     // Catch: IOException -> L58
    L58:
        e = move-exception;
        e.printStackTrace();
    L61:
        th = th;
        r2 = r3;
    L63:
        r3 = r2;
    L64:
        if (r3 != null) goto L72;
    L69:
        throw th;
    L72:
        r3.close();     // Catch: IOException -> L67
    L67:
        e = move-exception;
        e.printStackTrace();
    L46:
        th = th;
    L52:
        e = move-exception;
        r3 = null;
        e = e;
    L50:
        th = th;
        goto L63
    }

    private static boolean a(ArrayList r3, String r4) {
        Iterator r5 = r3.iterator();
    L3:
        boolean r1 = false;
        if (r5.hasNext() == false) goto L17;
        String r0 = (String) r5.next();
        if (r4.equals(r0) == true) goto L7;
        String r2 = new File(r0).getCanonicalPath();     // Catch: IOException -> L14
        String r6 = new File(r4).getCanonicalPath();     // Catch: IOException -> L14
        if (r2 == null) goto L16;
        if (r6 == null) goto L16;
        r1 = r2.equals(r6);     // Catch: IOException -> L14
    L16:
        if (r1 == false) goto L3;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L7:
        return true;
    L17:
        return r1;
    }

    private static void a(ArrayList r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.size() <= 0) goto L16;
        int r1 = 0;
    L8:
        if (r1 >= r4.size()) goto L17;
    L10:
        if (((String) r4.get(r1)).endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L12;
        r4.set(r1, ((String) r4.get(r1)).substring(0, ((String) r4.get(r1)).length() - 1));
        goto L10
    L12:
        r1 = r1 + 1;
        goto L8
    L17:
        return;
    }
}
