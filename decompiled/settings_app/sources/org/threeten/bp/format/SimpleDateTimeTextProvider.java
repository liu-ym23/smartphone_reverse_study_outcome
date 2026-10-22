package org.threeten.bp.format;

import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalField;

/* JADX INFO: loaded from: classes6.dex */
final class SimpleDateTimeTextProvider extends DateTimeTextProvider {
    private static final Comparator<Map.Entry<String, Long>> COMPARATOR = null;
    private final ConcurrentMap<Map.Entry<TemporalField, Locale>, Object> cache;

    static final class LocaleStore {
        private final Map<TextStyle, List<Map.Entry<String, Long>>> parsable;
        private final Map<TextStyle, Map<Long, String>> valueTextMap;

        LocaleStore(Map<TextStyle, Map<Long, String>> r10) {
            this.valueTextMap = r10;
            HashMap r0 = new HashMap();
            ArrayList r1 = new ArrayList();
            Iterator<TextStyle> r2 = r10.keySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L10;
            TextStyle r3 = r2.next();
            HashMap r4 = new HashMap();
            Iterator<Map.Entry<Long, String>> r5 = r10.get(r3).entrySet().iterator();
        L7:
            if (r5.hasNext() == false) goto L9;
            Map.Entry<Long, String> r6 = r5.next();
            r4.put(r6.getValue(), SimpleDateTimeTextProvider.access$000(r6.getValue(), r6.getKey()));
            goto L7
        L9:
            ArrayList r7 = new ArrayList(r4.values());
            Collections.sort(r7, SimpleDateTimeTextProvider.access$100());
            r0.put(r3, r7);
            r1.addAll(r7);
            r0.put(null, r1);
            goto L4
        L10:
            Collections.sort(r1, SimpleDateTimeTextProvider.access$100());
            this.parsable = r0;
        }

        String getText(long r1, TextStyle r3) {
            Map<Long, String> r0 = this.valueTextMap.get(r3);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get(Long.valueOf(r1));
        }

        Iterator<Map.Entry<String, Long>> getTextIterator(TextStyle r1) {
            List<Map.Entry<String, Long>> r0 = this.parsable.get(r1);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.iterator();
        }
    }

    SimpleDateTimeTextProvider() {
        this.cache = new ConcurrentHashMap(16, 0.75f, 2);
    }

    static /* synthetic */ Map.Entry access$000(Object r0, Object r1) {
        return createEntry(r0, r1);
    }

    static /* synthetic */ Comparator access$100() {
        return COMPARATOR;
    }

    static {
        COMPARATOR = new AnonymousClass1();
    }

    @Override // org.threeten.bp.format.DateTimeTextProvider
    public String getText(TemporalField r1, long r2, TextStyle r4, Locale r5) {
        Object r0 = findStore(r1, r5);
        if ((r0 instanceof LocaleStore) == true) goto L5;
        return null;
    L5:
        return ((LocaleStore) r0).getText(r2, r4);
    }

    @Override // org.threeten.bp.format.DateTimeTextProvider
    public Iterator<Map.Entry<String, Long>> getTextIterator(TemporalField r1, TextStyle r2, Locale r3) {
        Object r0 = findStore(r1, r3);
        if ((r0 instanceof LocaleStore) == true) goto L5;
        return null;
    L5:
        return ((LocaleStore) r0).getTextIterator(r2);
    }

    private Object findStore(TemporalField r3, Locale r4) {
        Map.Entry<TemporalField, Locale> r0 = createEntry(r3, r4);
        Object r1 = this.cache.get(r0);
        if (r1 != null) goto L6;
        Object r5 = createStore(r3, r4);
        this.cache.putIfAbsent(r0, r5);
        return this.cache.get(r0);
    L6:
        return r1;
    }

    private Object createStore(TemporalField r21, Locale r22) {
        if (r21 != ChronoField.MONTH_OF_YEAR) goto L7;
        DateFormatSymbols r0 = DateFormatSymbols.getInstance(r22);
        HashMap r1 = new HashMap();
        String[] r16 = r0.getMonths();
        HashMap r8 = new HashMap();
        r8.put(1L, r16[0]);
        r8.put(2L, r16[1]);
        r8.put(3L, r16[2]);
        r8.put(4L, r16[3]);
        r8.put(5L, r16[4]);
        r8.put(6L, r16[5]);
        r8.put(7L, r16[6]);
        r8.put(8L, r16[7]);
        r8.put(9L, r16[8]);
        r8.put(10L, r16[9]);
        r8.put(11L, r16[10]);
        r8.put(12L, r16[11]);
        r1.put(TextStyle.FULL, r8);
        HashMap r2 = new HashMap();
        r2.put(1L, r16[0].substring(0, 1));
        r2.put(2L, r16[1].substring(0, 1));
        r2.put(3L, r16[2].substring(0, 1));
        r2.put(4L, r16[3].substring(0, 1));
        r2.put(5L, r16[4].substring(0, 1));
        r2.put(6L, r16[5].substring(0, 1));
        r2.put(7L, r16[6].substring(0, 1));
        r2.put(8L, r16[7].substring(0, 1));
        r2.put(9L, r16[8].substring(0, 1));
        r2.put(10L, r16[9].substring(0, 1));
        r2.put(11L, r16[10].substring(0, 1));
        r2.put(12L, r16[11].substring(0, 1));
        r1.put(TextStyle.NARROW, r2);
        String[] r3 = r0.getShortMonths();
        HashMap r7 = new HashMap();
        r7.put(1L, r3[0]);
        r7.put(2L, r3[1]);
        r7.put(3L, r3[2]);
        r7.put(4L, r3[3]);
        r7.put(5L, r3[4]);
        r7.put(6L, r3[5]);
        r7.put(7L, r3[6]);
        r7.put(8L, r3[7]);
        r7.put(9L, r3[8]);
        r7.put(10L, r3[9]);
        r7.put(11L, r3[10]);
        r7.put(12L, r3[11]);
        r1.put(TextStyle.SHORT, r7);
        return createLocaleStore(r1);
    L7:
        if (r21 != ChronoField.DAY_OF_WEEK) goto L11;
        DateFormatSymbols r4 = DateFormatSymbols.getInstance(r22);
        HashMap r5 = new HashMap();
        String[] r9 = r4.getWeekdays();
        HashMap r10 = new HashMap();
        r10.put(1L, r9[2]);
        r10.put(2L, r9[3]);
        r10.put(3L, r9[4]);
        r10.put(4L, r9[5]);
        r10.put(5L, r9[6]);
        r10.put(6L, r9[7]);
        r10.put(7L, r9[1]);
        r5.put(TextStyle.FULL, r10);
        HashMap r11 = new HashMap();
        r11.put(1L, r9[2].substring(0, 1));
        r11.put(2L, r9[3].substring(0, 1));
        r11.put(3L, r9[4].substring(0, 1));
        r11.put(4L, r9[5].substring(0, 1));
        r11.put(5L, r9[6].substring(0, 1));
        r11.put(6L, r9[7].substring(0, 1));
        r11.put(7L, r9[1].substring(0, 1));
        r5.put(TextStyle.NARROW, r11);
        String[] r6 = r4.getShortWeekdays();
        HashMap r12 = new HashMap();
        r12.put(1L, r6[2]);
        r12.put(2L, r6[3]);
        r12.put(3L, r6[4]);
        r12.put(4L, r6[5]);
        r12.put(5L, r6[6]);
        r12.put(6L, r6[7]);
        r12.put(7L, r6[1]);
        r5.put(TextStyle.SHORT, r12);
        return createLocaleStore(r5);
    L11:
        if (r21 != ChronoField.AMPM_OF_DAY) goto L15;
        DateFormatSymbols r13 = DateFormatSymbols.getInstance(r22);
        HashMap r14 = new HashMap();
        String[] r15 = r13.getAmPmStrings();
        HashMap r17 = new HashMap();
        r17.put(0L, r15[0]);
        r17.put(1L, r15[1]);
        r14.put(TextStyle.FULL, r17);
        r14.put(TextStyle.SHORT, r17);
        return createLocaleStore(r14);
    L15:
        if (r21 != ChronoField.ERA) goto L23;
        DateFormatSymbols r18 = DateFormatSymbols.getInstance(r22);
        HashMap r19 = new HashMap();
        String[] r20 = r18.getEras();
        HashMap r23 = new HashMap();
        r23.put(0L, r20[0]);
        r23.put(1L, r20[1]);
        r19.put(TextStyle.SHORT, r23);
        if (r22.getLanguage().equals(Locale.ENGLISH.getLanguage()) == false) goto L19;
        HashMap r24 = new HashMap();
        r24.put(0L, "Before Christ");
        r24.put(1L, "Anno Domini");
        r19.put(TextStyle.FULL, r24);
    L20:
        HashMap r25 = new HashMap();
        r25.put(0L, r20[0].substring(0, 1));
        r25.put(1L, r20[1].substring(0, 1));
        r19.put(TextStyle.NARROW, r25);
        return createLocaleStore(r19);
    L19:
        r19.put(TextStyle.FULL, r23);
        goto L20
    L23:
        if (r21 != IsoFields.QUARTER_OF_YEAR) goto L26;
        HashMap r26 = new HashMap();
        HashMap r27 = new HashMap();
        r27.put(1L, "Q1");
        r27.put(2L, "Q2");
        r27.put(3L, "Q3");
        r27.put(4L, "Q4");
        r26.put(TextStyle.SHORT, r27);
        HashMap r28 = new HashMap();
        r28.put(1L, "1st quarter");
        r28.put(2L, "2nd quarter");
        r28.put(3L, "3rd quarter");
        r28.put(4L, "4th quarter");
        r26.put(TextStyle.FULL, r28);
        return createLocaleStore(r26);
    L26:
        return "";
    }

    private static <A, B> Map.Entry<A, B> createEntry(A r1, B r2) {
        return new AbstractMap.SimpleImmutableEntry(r1, r2);
    }

    private static LocaleStore createLocaleStore(Map<TextStyle, Map<Long, String>> r2) {
        r2.put(TextStyle.FULL_STANDALONE, r2.get(TextStyle.FULL));
        r2.put(TextStyle.SHORT_STANDALONE, r2.get(TextStyle.SHORT));
        if (r2.containsKey(TextStyle.NARROW) == false) goto L8;
        if (r2.containsKey(TextStyle.NARROW_STANDALONE) == true) goto L8;
        r2.put(TextStyle.NARROW_STANDALONE, r2.get(TextStyle.NARROW));
    L8:
        return new LocaleStore(r2);
    }
}
