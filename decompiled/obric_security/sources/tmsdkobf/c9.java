package tmsdkobf;

import android.media.ExifInterface;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f126a = "MediaFileUtil";
    private static SimpleDateFormat b;
    public static final TimeZone c = null;
    public static final String d = null;
    private static final String[] e = null;
    private static final String[] f = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f127a = null;
        public static final String[] b = null;
        public static final String[] c = null;
        public static final String[] d = null;

        static {
            f127a = new String[]{"mp4", "avi", "3gpp", "mkv", "wmv", "3gpp2", "mp2ts", "3gp", "mov", "flv", "rmvb", "flv"};
            b = new String[]{"jpg", "jpeg", "png", "gif", "bmp"};
            c = new String[]{"mp3", "wma", "flac", "wav", "mid", "m4a", "aac"};
            d = new String[]{"jpg", "jpeg"};
        }
    }

    static {
        c = TimeZone.getDefault();
        d = Environment.getExternalStorageDirectory().getAbsolutePath();
        e = new String[]{"screenshot", "截屏"};
        f = new String[]{"xj", "androidgeek", "logo", "pt", "MYXJ", "C360"};
    }

    private static long a(ExifInterface r5) {
        String r6 = r5.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME);
        if (r6 != null) goto L5;
        return 0;
    L5:
        q8.b(f126a, "exif time:" + r6);
        ParsePosition r2 = new ParsePosition(0);
    L16:
        e = move-exception;
        q8.a(f126a, "exifDateTime", e);
        return 0;
    L15:
        return 0;
    L7:
        if (b != null) goto L9;
        SimpleDateFormat r3 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");     // Catch: Exception -> L15 IllegalArgumentException -> L16
        b = r3;     // Catch: Exception -> L15 IllegalArgumentException -> L16
        r3.setTimeZone(TimeZone.getTimeZone("UTC"));     // Catch: Exception -> L15 IllegalArgumentException -> L16
    L9:
        Date r7 = b.parse(r6, r2);     // Catch: Exception -> L15 IllegalArgumentException -> L16
        if (r7 != null) goto L12;
        return 0;
    L12:
        long r4 = r7.getTime();     // Catch: Exception -> L15 IllegalArgumentException -> L16
    L14:
        return r4 - ((long) c.getOffset(r4));
    }

    public static String b(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r1 = r3.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r1 >= 0) goto L8;
        return null;
    L8:
        if (r1 < (r3.length() - 1)) goto L10;
        return null;
    L10:
        return r3.substring(r1 + 1);
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

    public static boolean d(String r5) {
        if (r5 == null) goto L11;
        String[] r1 = f;
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        if (r5.startsWith(r1[r3]) == true) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public static boolean e(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return r1.startsWith(d);
    }

    public static boolean f(String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        String r6 = b(r5).toLowerCase();
        String[] r1 = a.d;
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        if (r1[r3].equals(r6) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static boolean g(String r5) {
        String r6 = b(r5).toLowerCase();
        String[] r0 = a.b;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r0[r3].equals(r6) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean h(String r5) {
        String r6 = r5.toLowerCase();
        String[] r0 = e;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r6.contains(r0[r3]) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static long a(String r2) {
        ExifInterface r0 = new ExifInterface(r2);     // Catch: Throwable -> L4
    L6:
        if (r0 != null) goto L8;
        return 0;
    L8:
        return a(r0);
    L4:
        th = move-exception;
        q8.a(f126a, "getImageTakenTime", th);
        r0 = null;
        goto L6
    }
}
