package obric.util;

import com.obric.olog.OLog;
import java.util.Comparator;

/* JADX INFO: loaded from: classes5.dex */
public class SectionComparator2 implements Comparator<String> {
    private static final String ORDER = "abcdefghijklmnopqrstuvwxyz#";
    private static final String TAG = "SectionComparator2";

    public SectionComparator2() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(String r1, String r2) {
        return compare2(r1, r2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(String r5, String r6) {
        if (r5 != null) goto L7;
        if (r6 != null) goto L7;
        return 0;
    L7:
        if (r5 != null) goto L10;
        return -1;
    L10:
        if (r6 != null) goto L32;
        return 1;
    L32:
    L29:
        th = move-exception;
        OLog.e(TAG, "compare error=" + th);
        return 0;
    L13:
        if (r5.isEmpty() == false) goto L15;
        char r7 = '#';
    L17:
        if (r6.isEmpty() == false) goto L19;
        char r8 = '#';
    L20:
        if (r7 != '#') goto L23;
        if (r8 != '#') goto L23;
        return 0;
    L23:
        if (r7 != '#') goto L25;
        return 1;
    L25:
        if (r8 != '#') goto L27;
        return -1;
    L27:
        return Character.compare(r7, r8);
    L19:
        r8 = Character.toLowerCase(r6.charAt(0));     // Catch: Throwable -> L29
        goto L20
    L15:
        r7 = Character.toLowerCase(r5.charAt(0));     // Catch: Throwable -> L29
        goto L17
    }
}
