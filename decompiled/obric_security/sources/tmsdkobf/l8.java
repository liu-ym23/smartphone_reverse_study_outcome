package tmsdkobf;

import android.content.Context;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class l8 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    public static boolean a(Context r6, String r7) {
        String r1 = TMSDKContext.getStrFromEnvMap(TMSDKContext.PRE_LIB_PATH);
        ?? r2 = r1;
        if (r1 != null) goto L14;
        String r3 = r6.getCacheDir().toString();     // Catch: Exception -> L12
        if (r3.endsWith(LibrarianImpl.Constants.SEPARATOR) != true) goto L7;
        r3 = r3.substring(0, r3.length() - 2);     // Catch: Exception -> L12
    L7:
        int r4 = r3.lastIndexOf(47);     // Catch: Exception -> L12
        if (r4 == (-1)) goto L10;
        r6 = r3.substring(0, r4) + "/lib/";     // Catch: Exception -> L12
        ?? r8 = r6;
    L11:
        r2 = r8;
        goto L14
    L10:
        r8 = "";
    L12:
        r2 = "/data/data/" + r6.getPackageName() + "/lib/";
    L14:
        if (r2.length() != 0) goto L16;
        System.loadLibrary(r7);     // Catch: UnsatisfiedLinkError -> L43
    L42:
        return true;
    L43:
        e = move-exception;
        e.printStackTrace();
        return false;
    L16:
        if (new File(r2 + r7).exists() == true) goto L55;
    L19:
        boolean r9 = false;
    L20:
        if (r9 == false) goto L22;
    L27:
        String r0 = r7;
    L28:
        if (r9 == false) goto L30;
    L35:
        if (r9 == true) goto L42;
        System.loadLibrary(r7);     // Catch: UnsatisfiedLinkError -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
        return false;
    L30:
        if (r0.startsWith(LibrarianImpl.Constants.LIB_PREFIX) == true) goto L35;
        String r5 = LibrarianImpl.Constants.LIB_PREFIX + r0;
        if (new File(r2 + r5).exists() == false) goto L35;
        System.load(r2 + r5);     // Catch: UnsatisfiedLinkError -> L47
    L22:
        if (r7.endsWith(LibrarianImpl.Constants.SO_SUFFIX) == true) goto L27;
        r0 = r7 + LibrarianImpl.Constants.SO_SUFFIX;
        if (new File(r2 + r0).exists() == false) goto L28;
        System.load(r2 + r0);     // Catch: UnsatisfiedLinkError -> L46
        r9 = true;
        goto L28
    L55:
        System.load(r2 + r7);     // Catch: UnsatisfiedLinkError -> L48
        r9 = true;
        goto L20
    }
}
