package tmsdkobf;

import android.os.Build;
import android.os.Environment;
import com.bytedance.librarian.LibrarianImpl;
import tmsdk.common.tcc.QFile;

/* JADX INFO: loaded from: classes5.dex */
public abstract class dc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f151a = null;
    private static final String b = null;
    public static final String c = null;
    private static final int d = 0;

    static {
        if (a() == false) goto L5;
        String r0 = "content://com.android.externalstorage.documents/tree/primary%3A/document/primary%3Aandroid%2Fdata";
    L6:
        f151a = r0;
        String r1 = Environment.getExternalStorageDirectory().getAbsolutePath();
        b = r1;
        String r2 = r1 + "/android/data/";
        c = r2;
        d = r2.length();
        return;
    L5:
        r0 = "content://com.android.externalstorage.documents/tree/primary%3Aandroid%2Fdata/document/primary%3Aandroid%2Fdata";
        goto L6
    }

    public static QFile a(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new QFile(r2.replace("primary:", b + LibrarianImpl.Constants.SEPARATOR));
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT != 30) goto L5;
        return true;
    L5:
        return false;
    }
}
