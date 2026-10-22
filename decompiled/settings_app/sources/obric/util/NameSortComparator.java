package obric.util;

import android.os.Trace;
import com.obric.olog.OLog;
import java.text.RuleBasedCollator;
import java.util.Comparator;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class NameSortComparator implements Comparator<String> {
    private static final String SECTION_RULES = "&amp < a = A < b = B < c = C < d = D < e = E< f = F < g = G < h = H < i = I < j = J < k = K < l = L< m = M < n = N < o = O < p = P < q = Q < r = R < s = S< t = T < u = U < v = V < w = W < x = X < y = Y < z = Z< '#'";
    private static final String SECTION_RULES_JAPAN = "<&amp < あ < か < さ < た < な < は < ま < や < ら < わ< a = A < b = B < c = C < d = D < e = E< f = F < g = G < h = H < i = I < j = J < k = K < l = L< m = M < n = N < o = O < p = P < q = Q < r = R < s = S< t = T < u = U < v = V < w = W < x = X < y = Y < z = Z< '#'";
    private static final String SECTION_RULES_KOREA = "&amp < ㄱ < ㄴ < ㄷ < ㄹ < ㅁ < ㅂ < ㅅ < ㅇ < ㅈ < ㅊ < ㅋ < ㅌ < ㅍ < ㅎ< a = A < b = B < c = C < d = D < e = E< f = F < g = G < h = H < i = I < j = J < k = K < l = L< m = M < n = N < o = O < p = P < q = Q < r = R < s = S< t = T < u = U < v = V < w = W < x = X < y = Y < z = Z< '#'";
    private static final String SECTION_RULES_RUSSIAN = "<&amp< А = а < Б = б < В = в < Г = г < Д = д < Е = е = Ё = ё < Ж = ж < З = з < И = и < Й = й < К = к < Л = л < М = м < Н = н < О = о < П = п < Р = р < С = с < Т = т < У = у < Ф = ф < Х = х < Ц = ц < Ч = ч < Ш = ш < Щ = щ < Ъ = ъ < Ы = ы < Ь = ь < Э = э < Ю = ю < Я = я < a = A < b = B < c = C < d = D < e = E< f = F < g = G < h = H < i = I < j = J < k = K < l = L< m = M < n = N < o = O < p = P < q = Q < r = R < s = S< t = T < u = U < v = V < w = W < x = X < y = Y < z = Z< '#'";
    private static final String TAG = "NameSortComparator";
    protected static RuleBasedCollator mCollator;

    public NameSortComparator() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(String r1, String r2) {
        return compare2(r1, r2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(String r1, String r2) {
        return mCollator.compare(r1, r2);
    }

    static {
        Trace.beginSection("RuleBasedCollator");     // Catch: Throwable -> L5 Throwable -> L7
        OLog.i(TAG, "mCollator init1");     // Catch: Throwable -> L5 Throwable -> L7
        mCollator = new RuleBasedCollator(SECTION_RULES);     // Catch: Throwable -> L5 Throwable -> L7
        OLog.i(TAG, "mCollator init2");     // Catch: Throwable -> L5 Throwable -> L7
    L9:
        Trace.endSection();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        OLog.e(TAG, "new RuleBasedCollator error " + e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public static void updateCollator() {
        String r1 = Locale.getDefault().getLanguage();
        if (Locale.KOREA.getLanguage().equals(r1) == false) goto L6;
        String r2 = SECTION_RULES_KOREA;
    L12:
        RuleBasedCollator r3 = mCollator;
        if (r3 != null) goto L15;
    L22:
        OLog.d(TAG, "updateCollator");     // Catch: Throwable -> L19
        mCollator = new RuleBasedCollator(r2);     // Catch: Throwable -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        OLog.e(TAG, "updateCollator error " + e);
        return;
    L15:
        if (r2.equals(r3.getRules()) == false) goto L22;
        return;
    L6:
        if (Locale.JAPAN.getLanguage().equals(r1) == false) goto L9;
        r2 = SECTION_RULES_JAPAN;
        goto L12
    L9:
        if ("ru".equals(r1) == false) goto L11;
        r2 = SECTION_RULES_RUSSIAN;
        goto L12
    L11:
        r2 = SECTION_RULES;
        goto L12
    }
}
