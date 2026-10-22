package androidx.core.content;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    public static boolean matches(@Nullable String r1, @NonNull String r2) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return mimeTypeAgainstFilter(r1.split(LibrarianImpl.Constants.SEPARATOR), r2.split(LibrarianImpl.Constants.SEPARATOR));
    }

    @NonNull
    public static String[] matchesMany(@Nullable String[] r6, @NonNull String r7) {
        int r0 = 0;
        if (r6 == null) goto L5;
        ArrayList r1 = new ArrayList();
        String[] r8 = r7.split(LibrarianImpl.Constants.SEPARATOR);
        int r3 = r6.length;
    L7:
        if (r0 >= r3) goto L13;
        String r4 = r6[r0];
        if (mimeTypeAgainstFilter(r4.split(LibrarianImpl.Constants.SEPARATOR), r8) == false) goto L11;
        r1.add(r4);
    L11:
        r0 = r0 + 1;
        goto L7
    L13:
        return (String[]) r1.toArray(new String[r1.size()]);
    L5:
        return new String[0];
    }

    private static boolean mimeTypeAgainstFilter(@NonNull String[] r5, @NonNull String[] r6) {
        if (r6.length != 2) goto L25;
        if (r6[0].isEmpty() == true) goto L23;
        if (r6[1].isEmpty() == true) goto L23;
        if (r5.length == 2) goto L12;
        return false;
    L12:
        if ("*".equals(r6[0]) == true) goto L17;
        if (r6[0].equals(r5[0]) == true) goto L17;
        return false;
    L17:
        if ("*".equals(r6[1]) == false) goto L19;
    L21:
        return true;
    L19:
        if (r6[1].equals(r5[1]) == true) goto L21;
        return false;
    L23:
        throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
    L25:
        throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
    }

    @Nullable
    public static String matches(@Nullable String r6, @NonNull String[] r7) {
        if (r6 != null) goto L5;
        return null;
    L5:
        String[] r8 = r6.split(LibrarianImpl.Constants.SEPARATOR);
        int r2 = r7.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        String r4 = r7[r3];
        if (mimeTypeAgainstFilter(r8, r4.split(LibrarianImpl.Constants.SEPARATOR)) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return r4;
    L11:
        return null;
    }

    @Nullable
    public static String matches(@Nullable String[] r6, @NonNull String r7) {
        if (r6 != null) goto L5;
        return null;
    L5:
        String[] r8 = r7.split(LibrarianImpl.Constants.SEPARATOR);
        int r2 = r6.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        String r4 = r6[r3];
        if (mimeTypeAgainstFilter(r4.split(LibrarianImpl.Constants.SEPARATOR), r8) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return r4;
    L11:
        return null;
    }
}
