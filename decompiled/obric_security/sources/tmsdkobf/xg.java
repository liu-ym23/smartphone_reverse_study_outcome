package tmsdkobf;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.InputStream;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes5.dex */
public abstract class xg {
    public static String a(Context r5, String r6) {
        InputStream r1 = null;
        PackageManager r7 = r5.getApplicationContext().getPackageManager();     // Catch: Throwable -> L32
        if (r7 == null) goto L9;
        PackageInfo r8 = r7.getPackageArchiveInfo(r6, 0);     // Catch: Throwable -> L32
        if (r8 == null) goto L9;
        String r9 = r8.packageName;     // Catch: Throwable -> L32
    L10:
        if (r9 == null) goto L40;
        return r9;
    L40:
        ZipFile r4 = new ZipFile(r6);     // Catch: Throwable -> L23
        InputStream r10 = r4.getInputStream(r4.getEntry("AndroidManifest.xml"));     // Catch: Throwable -> L31
        r9 = new oj().a(r10).getChildNodes().item(0).getAttributes().getNamedItem("package").getNodeValue();     // Catch: Throwable -> L22
        j.a(r10);
        if (qk.b() < 19) goto L20;
        j.a(r4);     // Catch: Throwable -> L30
    L39:
        goto L29
    L20:
        r4.close();     // Catch: Throwable -> L30
    L22:
        r1 = r10;
    L24:
        j.a(r1);
        if (qk.b() < 19) goto L28;
        j.a(r4);     // Catch: Throwable -> L30
        goto L39
    L28:
        r4.close();     // Catch: Throwable -> L30
    L23:
        r4 = null;
    L29:
        return r9;
    L9:
        r9 = null;
        goto L10
    }
}
