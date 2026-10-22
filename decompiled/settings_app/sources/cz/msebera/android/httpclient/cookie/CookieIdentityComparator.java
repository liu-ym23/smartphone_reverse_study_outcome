package cz.msebera.android.httpclient.cookie;

import com.bytedance.librarian.LibrarianImpl;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes5.dex */
public class CookieIdentityComparator implements Serializable, Comparator<Cookie> {
    private static final long serialVersionUID = 4466565437490631532L;

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Cookie r1, Cookie r2) {
        return compare2(r1, r2);
    }

    public CookieIdentityComparator() {
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Cookie r6, Cookie r7) {
        int r5 = r6.getName().compareTo(r7.getName());
        if (r5 != 0) goto L18;
        String r8 = r6.getDomain();
        String r1 = "";
        if (r8 != null) goto L8;
        r8 = "";
    L10:
        String r4 = r7.getDomain();
        if (r4 != null) goto L14;
    L17:
        r5 = r8.compareToIgnoreCase(r1);
        goto L18
    L14:
        if (r4.indexOf(46) != (-1)) goto L16;
        r1 = r4 + ".local";
        goto L17
    L16:
        r1 = r4;
        goto L17
    L8:
        if (r8.indexOf(46) != (-1)) goto L10;
        r8 = r8 + ".local";
    L18:
        if (r5 != 0) goto L28;
        String r9 = r6.getPath();
        String r10 = LibrarianImpl.Constants.SEPARATOR;
        if (r9 != null) goto L22;
        r9 = LibrarianImpl.Constants.SEPARATOR;
    L22:
        String r11 = r7.getPath();
        if (r11 == null) goto L27;
        r10 = r11;
    L27:
        return r9.compareTo(r10);
    L28:
        return r5;
    }
}
