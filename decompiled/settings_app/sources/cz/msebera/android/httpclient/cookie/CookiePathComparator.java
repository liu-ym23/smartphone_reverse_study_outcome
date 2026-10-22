package cz.msebera.android.httpclient.cookie;

import com.bytedance.librarian.LibrarianImpl;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public class CookiePathComparator implements Serializable, Comparator<Cookie> {
    public static final CookiePathComparator INSTANCE = null;
    private static final long serialVersionUID = 7523645369616405818L;

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Cookie r1, Cookie r2) {
        return compare2(r1, r2);
    }

    public CookiePathComparator() {
    }

    static {
        INSTANCE = new CookiePathComparator();
    }

    private String normalizePath(Cookie r1) {
        String r0 = r1.getPath();
        if (r0 != null) goto L6;
        r0 = LibrarianImpl.Constants.SEPARATOR;
    L6:
        if (r0.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L8;
        return r0;
    L8:
        return r0 + IOUtils.DIR_SEPARATOR_UNIX;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Cookie r2, Cookie r3) {
        String r4 = normalizePath(r2);
        String r1 = normalizePath(r3);
        if (r4.equals(r1) == false) goto L6;
        return 0;
    L6:
        if (r4.startsWith(r1) == false) goto L10;
        return -1;
    L10:
        if (r1.startsWith(r4) == false) goto L13;
        return 1;
    L13:
        return 0;
    }
}
