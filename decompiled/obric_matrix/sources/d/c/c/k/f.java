package d.c.c.k;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Uri f15446a = null;

    static {
        f15446a = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");
    }

    public static String a(ContentResolver r8, Uri r9) {
        Cursor r1 = null;
        String r2 = null;
        r2 = null;
        r2 = null;
        if (h(r9) == false) goto L22;
        Cursor r10 = r8.query(r9, null, null, null, null);     // Catch: Throwable -> L17
        if (r10 != null) goto L27;
    L15:
        if (r10 == null) goto L29;
        r10.close();
        return r2;
    L29:
        return r2;
    L27:
    L13:
        th = th;
        r1 = r10;
    L18:
        if (r1 == null) goto L20;
        r1.close();
    L20:
        throw th;
    L8:
        if (r10.moveToFirst() == false) goto L15;
        int r11 = r10.getColumnIndex("_data");     // Catch: Throwable -> L13
        if (r11 == (-1)) goto L15;
        r2 = r10.getString(r11);     // Catch: Throwable -> L13
    L17:
        th = th;
        goto L18
    L22:
        if (i(r9) == true) goto L24;
        return null;
    L24:
        return r9.getPath();
    }

    public static String b(Uri r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getScheme();
    }

    public static Uri c(int r2) {
        return new Uri.Builder().scheme("res").path(String.valueOf(r2)).build();
    }

    public static boolean d(Uri r1) {
        return "data".equals(b(r1));
    }

    public static boolean e(Uri r1) {
        return "asset".equals(b(r1));
    }

    public static boolean f(Uri r1) {
        String r2 = r1.toString();
        if (r2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString()) == true) goto L8;
        return false;
    }

    public static boolean g(Uri r2) {
        if (h(r2) == true) goto L5;
    L9:
        return false;
    L5:
        if ("com.android.contacts".equals(r2.getAuthority()) == false) goto L9;
        if (r2.getPath().startsWith(f15446a.getPath()) == true) goto L9;
        return true;
    }

    public static boolean h(Uri r1) {
        return "content".equals(b(r1));
    }

    public static boolean i(Uri r1) {
        return "file".equals(b(r1));
    }

    public static boolean j(Uri r1) {
        return "res".equals(b(r1));
    }

    public static boolean k(Uri r1) {
        String r2 = b(r1);
        if (LocationInfoConst.HTTPS.equals(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if ("http".equals(r2) == true) goto L8;
        return false;
    }

    public static boolean l(Uri r1) {
        return "android.resource".equals(b(r1));
    }

    public static URL m(Uri r1) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return new URL(r1.toString());
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
