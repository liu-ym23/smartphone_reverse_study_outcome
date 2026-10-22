package androidx.core.database;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class DatabaseUtilsCompat {
    private DatabaseUtilsCompat() {
    }

    @Deprecated
    public static String[] appendSelectionArgs(String[] r3, String[] r4) {
        if (r3 != null) goto L4;
    L8:
        return r4;
    L4:
        if (r3.length == 0) goto L8;
        String[] r0 = new String[r3.length + r4.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        System.arraycopy(r4, 0, r0, r3.length, r4.length);
        return r0;
    }

    @Deprecated
    public static String concatenateWhere(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return r3;
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L9;
        return r2;
    L9:
        return "(" + r2 + ") AND (" + r3 + ")";
    }
}
