package com.android.internal.inputmethod;

import android.icu.util.ULocale;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class LocaleUtils {

    public interface LocaleExtractor<T> {
        Locale get(T r1);
    }

    private static final class ScoreEntry implements Comparable<ScoreEntry> {
        public int mIndex;
        public final byte[] mScore;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ScoreEntry r1) {
            return compareTo2(r1);
        }

        ScoreEntry(byte[] r2, int r3) {
            this.mIndex = -1;
            this.mScore = new byte[r2.length];
            set(r2, r3);
        }

        private void set(byte[] r4, int r5) {
            int r0 = 0;
        L3:
            byte[] r1 = this.mScore;
            if (r0 >= r1.length) goto L6;
            r1[r0] = r4[r0];
            r0 = r0 + 1;
            goto L3
        L6:
            this.mIndex = r5;
        }

        public void updateIfBetter(byte[] r3, int r4) {
            if (compare(this.mScore, r3) != (-1)) goto L6;
            set(r3, r4);
            return;
        }

        private static int compare(byte[] r4, byte[] r5) {
            int r1 = 0;
        L4:
            if (r1 >= r4.length) goto L13;
            byte r2 = r4[r1];
            byte r3 = r5[r1];
            if (r2 > r3) goto L7;
            if (r2 < r3) goto L10;
            r1 = r1 + 1;
            goto L4
        L10:
            return -1;
        L7:
            return 1;
        L13:
            return 0;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ScoreEntry r1) {
            return compare(this.mScore, r1.mScore) * (-1);
        }
    }

    LocaleUtils() {
    }

    private static byte calculateMatchingSubScore(ULocale r3, ULocale r4) {
        if (r3.equals(r4) == false) goto L5;
        return 3;
    L5:
        String r0 = r3.getScript();
        if (r0.isEmpty() == false) goto L8;
        return 1;
    L8:
        if (r0.equals(r4.getScript()) == false) goto L21;
        String r5 = r3.getCountry();
        if (r5.isEmpty() == false) goto L13;
        return 2;
    L13:
        if (r5.equals(r4.getCountry()) == false) goto L20;
        return 3;
    L20:
        return 2;
    L21:
        return 1;
    }

    public static <T> void filterByLanguage(List<T> r16, LocaleExtractor<T> r17, LocaleList r18, ArrayList<T> r19) {
        if (r18.isEmpty() == false) goto L5;
        return;
    L5:
        int r1 = r18.size();
        ArrayMap r2 = new ArrayMap();
        byte[] r3 = new byte[r1];
        ULocale[] r4 = new ULocale[r1];
        int r5 = r16.size();
        int r6 = 0;
        int r7 = 0;
    L6:
        if (r7 >= r5) goto L31;
        Locale r8 = r17.get(r16.get(r7));
        if (r8 == null) goto L30;
        boolean r10 = true;
        int r11 = 0;
    L11:
        if (r11 >= r1) goto L24;
        Locale r13 = r18.get(r11);
        if (TextUtils.equals(r8.getLanguage(), r13.getLanguage()) == true) goto L16;
        r3[r11] = 0;
    L22:
        r11 = r11 + 1;
        goto L11
    L16:
        if (r4[r11] != null) goto L18;
        r4[r11] = ULocale.addLikelySubtags(ULocale.forLocale(r13));
    L18:
        byte r14 = calculateMatchingSubScore(r4[r11], ULocale.addLikelySubtags(ULocale.forLocale(r8)));
        r3[r11] = r14;
        if (r10 == false) goto L22;
        if (r14 == 0) goto L22;
        r10 = false;
        goto L22
    L24:
        if (r10 == true) goto L30;
        String r9 = r8.getLanguage();
        ScoreEntry r12 = (ScoreEntry) r2.get(r9);
        if (r12 != null) goto L29;
        r2.put(r9, new ScoreEntry(r3, r7));
        goto L30
    L29:
        r12.updateIfBetter(r3, r7);
    L30:
        r7 = r7 + 1;
        goto L6
    L31:
        int r15 = r2.size();
        ScoreEntry[] r20 = new ScoreEntry[r15];
        int r21 = 0;
    L32:
        if (r21 >= r15) goto L34;
        r20[r21] = (ScoreEntry) r2.valueAt(r21);
        r21 = r21 + 1;
        goto L32
    L34:
        Arrays.sort(r20);
    L35:
        if (r6 >= r15) goto L37;
        r19.add(r16.get(r20[r6].mIndex));
        r6 = r6 + 1;
        goto L35
    }
}
