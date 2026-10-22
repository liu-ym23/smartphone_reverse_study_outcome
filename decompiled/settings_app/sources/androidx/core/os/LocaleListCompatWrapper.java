package androidx.core.os;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class LocaleListCompatWrapper implements LocaleListInterface {
    private static final Locale EN_LATN = null;
    private static final Locale LOCALE_AR_XB = null;
    private static final Locale LOCALE_EN_XA = null;
    private static final Locale[] sEmptyList = null;
    private final Locale[] mList;
    private final String mStringRepresentation;

    static class Api21Impl {
        private Api21Impl() {
        }

        static String getScript(Locale r0) {
            return r0.getScript();
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return null;
    }

    static {
        sEmptyList = new Locale[0];
        LOCALE_EN_XA = new Locale("en", "XA");
        LOCALE_AR_XB = new Locale("ar", "XB");
        EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int r2) {
        if (r2 < 0) goto L6;
        Locale[] r1 = this.mList;
        if (r2 >= r1.length) goto L6;
        return r1[r2];
    L6:
        return null;
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        if (this.mList.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.mList.length;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale r4) {
        int r0 = 0;
    L3:
        Locale[] r1 = this.mList;
        if (r0 >= r1.length) goto L9;
        if (r1[r0].equals(r4) == true) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return r0;
    L9:
        return -1;
    }

    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if ((r6 instanceof LocaleListCompatWrapper) == true) goto L8;
        return false;
    L8:
        Locale[] r7 = ((LocaleListCompatWrapper) r6).mList;
        if (this.mList.length == r7.length) goto L11;
        return false;
    L11:
        int r1 = 0;
    L12:
        Locale[] r3 = this.mList;
        if (r1 >= r3.length) goto L18;
        if (r3[r1].equals(r7[r1]) == false) goto L16;
        r1 = r1 + 1;
        goto L12
    L16:
        return false;
    L18:
        return true;
    }

    public int hashCode() {
        Locale[] r4 = this.mList;
        int r0 = r4.length;
        int r1 = 1;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = (r1 * 31) + r4[r2].hashCode();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[");
        int r1 = 0;
    L3:
        Locale[] r2 = this.mList;
        if (r1 >= r2.length) goto L9;
        r0.append(r2[r1]);
        if (r1 >= (this.mList.length - 1)) goto L8;
        r0.append(',');
    L8:
        r1 = r1 + 1;
        goto L3
    L9:
        r0.append("]");
        return r0.toString();
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.mStringRepresentation;
    }

    LocaleListCompatWrapper(Locale... r8) {
        if (r8.length != 0) goto L5;
        this.mList = sEmptyList;
        this.mStringRepresentation = "";
        return;
    L5:
        ArrayList r0 = new ArrayList();
        HashSet r1 = new HashSet();
        StringBuilder r2 = new StringBuilder();
        int r4 = 0;
    L7:
        if (r4 >= r8.length) goto L19;
        Locale r5 = r8[r4];
        if (r5 == null) goto L18;
        if (r1.contains(r5) == true) goto L16;
        Locale r6 = (Locale) r5.clone();
        r0.add(r6);
        toLanguageTag(r2, r6);
        if (r4 >= (r8.length - 1)) goto L15;
        r2.append(',');
    L15:
        r1.add(r6);
    L16:
        r4 = r4 + 1;
        goto L7
    L18:
        throw new NullPointerException("list[" + r4 + "] is null");
    L19:
        this.mList = (Locale[]) r0.toArray(new Locale[0]);
        this.mStringRepresentation = r2.toString();
    }

    static void toLanguageTag(StringBuilder r1, Locale r2) {
        r1.append(r2.getLanguage());
        String r0 = r2.getCountry();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L9;
        r1.append('-');
        r1.append(r2.getCountry());
        return;
    }

    private static String getLikelyScript(Locale r1) {
        String r2 = Api21Impl.getScript(r1);
        if (r2.isEmpty() == true) goto L5;
        return r2;
    L5:
        return "";
    }

    private static boolean isPseudoLocale(Locale r1) {
        if (LOCALE_EN_XA.equals(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (LOCALE_AR_XB.equals(r1) == true) goto L8;
        return false;
    }

    private static int matchScore(Locale r4, Locale r5) {
        if (r4.equals(r5) == false) goto L6;
        return 1;
    L6:
        if (r4.getLanguage().equals(r5.getLanguage()) == true) goto L9;
        return 0;
    L9:
        if (isPseudoLocale(r4) == false) goto L11;
    L24:
        return 0;
    L11:
        if (isPseudoLocale(r5) == true) goto L24;
        String r0 = getLikelyScript(r4);
        if (r0.isEmpty() == false) goto L23;
        String r6 = r4.getCountry();
        if (r6.isEmpty() == false) goto L18;
        return 1;
    L18:
        if (r6.equals(r5.getCountry()) == false) goto L21;
        return 1;
    L21:
        return 0;
    L23:
        return r0.equals(getLikelyScript(r5)) ? 1 : 0;
    }

    private int findFirstMatchIndex(Locale r4) {
        int r0 = 0;
    L3:
        Locale[] r1 = this.mList;
        if (r0 >= r1.length) goto L9;
        if (matchScore(r4, r1[r0]) > 0) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return r0;
    L9:
        return Integer.MAX_VALUE;
    }

    private int computeFirstMatchIndex(Collection<String> r5, boolean r6) {
        Locale[] r0 = this.mList;
        if (r0.length != 1) goto L6;
        return 0;
    L6:
        if (r0.length != 0) goto L10;
        return -1;
    L10:
        if (r6 == false) goto L16;
        int r7 = findFirstMatchIndex(EN_LATN);
        if (r7 != 0) goto L14;
        return 0;
    L14:
        if (r7 >= Integer.MAX_VALUE) goto L16;
    L17:
        Iterator<String> r8 = r5.iterator();
    L19:
        if (r8.hasNext() == false) goto L25;
        int r1 = findFirstMatchIndex(LocaleListCompat.forLanguageTagCompat(r8.next()));
        if (r1 == 0) goto L22;
        if (r1 >= r7) goto L19;
        r7 = r1;
        goto L19
    L22:
        return 0;
    L25:
        if (r7 != Integer.MAX_VALUE) goto L27;
        return 0;
    L27:
        return r7;
    L16:
        r7 = Integer.MAX_VALUE;
        goto L17
    }

    private Locale computeFirstMatch(Collection<String> r1, boolean r2) {
        int r3 = computeFirstMatchIndex(r1, r2);
        if (r3 != (-1)) goto L6;
        return null;
    L6:
        return this.mList[r3];
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(String[] r2) {
        return computeFirstMatch(Arrays.asList(r2), false);
    }
}
