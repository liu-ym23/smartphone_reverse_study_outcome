package com.android.settingslib.datetime;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.icu.text.TimeZoneFormat;
import android.icu.text.TimeZoneNames;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TtsSpan;
import androidx.core.text.BidiFormatter;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import com.GlobalProxyLancet;
import com.android.i18n.timezone.CountryTimeZones;
import com.android.i18n.timezone.TimeZoneFinder;
import com.android.internal.app.LocaleHelper;
import com.android.settings.utils.HanziToPinyin;
import com.android.settingslib.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ZoneGetter {

    @Deprecated
    public static final String KEY_DISPLAYNAME = "name";
    public static final String KEY_DISPLAY_LABEL = "display_label";

    @Deprecated
    public static final String KEY_GMT = "gmt";
    public static final String KEY_ID = "id";
    public static final String KEY_OFFSET = "offset";
    public static final String KEY_OFFSET_LABEL = "offset_label";
    private static final String TAG = "ZoneGetter";
    private static final String XMLTAG_TIMEZONE = "timezone";

    public static final class ZoneGetterData {
        public final CharSequence[] gmtOffsetTexts;
        public final Set<String> localZoneIds;
        public final String[] olsonIdsToDisplay;
        public final TimeZone[] timeZones;
        public final int zoneCount;

        public ZoneGetterData(Context r7) {
            Locale r0 = r7.getResources().getConfiguration().locale;
            TimeZoneFormat r1 = TimeZoneFormat.getInstance(r0);
            Date r2 = new Date();
            List r8 = ZoneGetter.access$000(r7);
            int r3 = r8.size();
            this.zoneCount = r3;
            this.olsonIdsToDisplay = new String[r3];
            this.timeZones = new TimeZone[r3];
            this.gmtOffsetTexts = new CharSequence[r3];
            int r4 = 0;
        L4:
            if (r4 >= this.zoneCount) goto L6;
            String r5 = (String) r8.get(r4);
            this.olsonIdsToDisplay[r4] = r5;
            TimeZone r6 = TimeZone.getTimeZone(r5);
            this.timeZones[r4] = r6;
            this.gmtOffsetTexts[r4] = ZoneGetter.getGmtOffsetText(r1, r0, r6, r2);
            r4 = r4 + 1;
            goto L4
        L6:
            List<String> r9 = lookupTimeZoneIdsByCountry(r0.getCountry());
            if (r9 == null) goto L9;
            HashSet r10 = new HashSet(r9);
        L10:
            this.localZoneIds = r10;
            return;
        L9:
            r10 = new HashSet();
            goto L10
        }

        public List<String> lookupTimeZoneIdsByCountry(String r1) {
            CountryTimeZones r0 = TimeZoneFinder.getInstance().lookupCountryTimeZones(r1);
            if (r0 != null) goto L7;
            return null;
        L7:
            return extractTimeZoneIds(r0.getTimeZoneMappings());
        }

        private static List<String> extractTimeZoneIds(List<CountryTimeZones.TimeZoneMapping> r2) {
            ArrayList r0 = new ArrayList(r2.size());
            Iterator<CountryTimeZones.TimeZoneMapping> r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L7;
            r0.add(r3.next().getTimeZoneId());
            goto L4
        L7:
            return Collections.unmodifiableList(r0);
        }
    }

    public ZoneGetter() {
    }

    static /* synthetic */ List access$000(Context r0) {
        return readTimezonesToDisplay(r0);
    }

    public static CharSequence getTimeZoneOffsetAndName(Context r2, TimeZone r3, Date r4) {
        Locale r5 = r2.getResources().getConfiguration().locale;
        CharSequence r0 = getGmtOffsetText(TimeZoneFormat.getInstance(r5), r5, r3, r4);
        String r6 = capitalizeForStandaloneDisplay(r5, getZoneLongName(r5, TimeZoneNames.getInstance(r5), r3, r4));
        if (r6 != null) goto L6;
        return r0;
    L6:
        return TextUtils.concat(new CharSequence[]{r0, HanziToPinyin.Token.SEPARATOR, r6});
    }

    public static String capitalizeForStandaloneDisplay(Locale r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return r2;
    L6:
        return LocaleHelper.toSentenceCase(r2, r1);
    }

    public static List<Map<String, Object>> getZonesList(Context r14) {
        Locale r0 = r14.getResources().getConfiguration().locale;
        Date r7 = new Date();
        TimeZoneNames r8 = TimeZoneNames.getInstance(r0);
        ZoneGetterData r9 = new ZoneGetterData(r14);
        boolean r15 = shouldUseExemplarLocationForLocalNames(r0, r9, r8);
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L4:
        if (r11 >= r9.zoneCount) goto L9;
        TimeZone r12 = r9.timeZones[r11];
        CharSequence r13 = r9.gmtOffsetTexts[r11];
        CharSequence r1 = getTimeZoneDisplayName(r0, r9, r8, r15, r12, r9.olsonIdsToDisplay[r11]);
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = r13;
    L8:
        r10.add(createDisplayEntry(r12, r13, r1, r12.getOffset(r7.getTime())));
        r11 = r11 + 1;
        goto L4
    L9:
        return r10;
    }

    private static Map<String, Object> createDisplayEntry(TimeZone r2, CharSequence r3, CharSequence r4, int r5) {
        HashMap r0 = new HashMap();
        r0.put("id", r2.getID());
        r0.put("name", r4.toString());
        r0.put(KEY_DISPLAY_LABEL, r4);
        r0.put(KEY_GMT, r3.toString());
        r0.put(KEY_OFFSET_LABEL, r3);
        r0.put("offset", Integer.valueOf(r5));
        return r0;
    }

    private static List<String> readTimezonesToDisplay(Context r6) {
        ArrayList r1 = new ArrayList();
        XmlResourceParser r7 = r6.getResources().getXml(R.xml.timezones);     // Catch: IOException -> L37 XmlPullParserException -> L38
    L40:
    L30:
        th = move-exception;
        if (r7 != null) goto L42;
    L36:
        throw th;     // Catch: IOException -> L37 XmlPullParserException -> L38
    L42:
        r7.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L37 XmlPullParserException -> L38
        goto L36
    L5:
        if (r7.next() != 2) goto L40;
        r7.next();     // Catch: Throwable -> L30
    L8:
        if (r7.getEventType() == 3) goto L27;
    L11:
        if (r7.getEventType() == 2) goto L20;
        if (r7.getEventType() == 1) goto L15;
        r7.next();     // Catch: Throwable -> L30
        goto L11
    L15:
        if (r7 == null) goto L17;
        r7.close();     // Catch: IOException -> L37 XmlPullParserException -> L38
    L17:
        return r1;
    L20:
        if (r7.getName().equals("timezone") == false) goto L23;
        r1.add(r7.getAttributeValue(0));     // Catch: Throwable -> L30
    L23:
        if (r7.getEventType() == 3) goto L25;
        r7.next();     // Catch: Throwable -> L30
        goto L23
    L25:
        r7.next();     // Catch: Throwable -> L30
        goto L8
    L27:
        if (r7 == null) goto L39;
        r7.close();     // Catch: IOException -> L37 XmlPullParserException -> L38
    L39:
        return r1;
    L37:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Unable to read timezones.xml file");
    L38:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Ill-formatted timezones.xml file");
        goto L39
    }

    private static boolean shouldUseExemplarLocationForLocalNames(Locale r6, ZoneGetterData r7, TimeZoneNames r8) {
        HashSet r0 = new HashSet();
        Date r1 = new Date();
        int r3 = 0;
    L4:
        if (r3 >= r7.zoneCount) goto L15;
        if (r7.localZoneIds.contains(r7.olsonIdsToDisplay[r3]) == false) goto L14;
        CharSequence r4 = getZoneLongName(r6, r8, r7.timeZones[r3], r1);
        if (r4 != null) goto L11;
        r4 = r7.gmtOffsetTexts[r3];
    L11:
        if (r0.add(r4) == true) goto L14;
        return true;
    L14:
        r3 = r3 + 1;
        goto L4
    L15:
        return false;
    }

    private static CharSequence getTimeZoneDisplayName(Locale r1, ZoneGetterData r2, TimeZoneNames r3, boolean r4, TimeZone r5, String r6) {
        Date r0 = new Date();
        if (r2.localZoneIds.contains(r6) == false) goto L6;
        if (r4 == true) goto L6;
        boolean r7 = true;
    L7:
        if (r7 == true) goto L20;
        String r8 = android.icu.util.TimeZone.getCanonicalID(r5.getID());
        if (r8 != null) goto L12;
        r8 = r5.getID();
    L12:
        String r9 = capitalizeForStandaloneDisplay(r1, r3.getExemplarLocationName(r8));
        if (r9 == null) goto L19;
        if (r9.isEmpty() == true) goto L19;
        return r9;
    L19:
        return getZoneLongName(r1, r3, r5, r0);
    L20:
        return getZoneLongName(r1, r3, r5, r0);
    L6:
        r7 = false;
        goto L7
    }

    private static String getZoneLongName(Locale r3, TimeZoneNames r4, TimeZone r5, Date r6) {
        if (r5.inDaylightTime(r6) == false) goto L5;
        TimeZoneNames.NameType r0 = TimeZoneNames.NameType.LONG_DAYLIGHT;
    L7:
        return capitalizeForStandaloneDisplay(r3, r4.getDisplayName(getCanonicalZoneId(r5), r0, r6.getTime()));
    L5:
        r0 = TimeZoneNames.NameType.LONG_STANDARD;
        goto L7
    }

    private static String getCanonicalZoneId(TimeZone r1) {
        String r2 = r1.getID();
        String r0 = android.icu.util.TimeZone.getCanonicalID(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r2;
    }

    private static void appendWithTtsSpan(SpannableStringBuilder r2, CharSequence r3, TtsSpan r4) {
        int r0 = r2.length();
        r2.append(r3);
        r2.setSpan(r4, r0, r2.length(), 0);
    }

    private static String formatDigits(int r4, int r5, String r6) {
        int r0 = r4 / 10;
        int r1 = r4 % 10;
        StringBuilder r2 = new StringBuilder(r5);
        if (r4 < 10) goto L5;
    L6:
        r2.append(r6.charAt(r0));
    L7:
        r2.append(r6.charAt(r1));
        return r2.toString();
    L5:
        if (r5 != 2) goto L7;
        goto L6
    }

    public static CharSequence getGmtOffsetText(TimeZoneFormat r12, Locale r13, TimeZone r14, Date r15) {
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        String r1 = r12.getGMTPattern();
        int r2 = r1.indexOf("{0}");
        boolean r4 = false;
        if (r2 != (-1)) goto L5;
        String r3 = "GMT";
        String r5 = "";
    L7:
        if (r3.isEmpty() == true) goto L9;
        appendWithTtsSpan(r0, r3, new TtsSpan.TextBuilder(r3).build());
    L9:
        int r16 = r14.getOffset(r15.getTime());
        if (r16 >= 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        r16 = -r16;
        TimeZoneFormat.GMTOffsetPatternType r7 = TimeZoneFormat.GMTOffsetPatternType.NEGATIVE_HM;
    L16:
        String r8 = r12.getGMTOffsetPattern(r7);
        String r17 = r12.getGMTOffsetDigits();
        long r9 = r16;
        int r18 = (int) (r9 / 3600000);
        int r10 = Math.abs((int) (r9 / 60000)) % 60;
        int r11 = 0;
    L18:
        if (r11 >= r8.length()) goto L45;
        char r19 = r8.charAt(r11);
        if (r19 != '+') goto L22;
    L42:
        String r20 = String.valueOf(r19);
        appendWithTtsSpan(r0, r20, new TtsSpan.VerbatimBuilder(r20).build());
    L43:
        r11 = r11 + 1;
        goto L18
    L22:
        if (r19 == '-') goto L42;
        if (r19 == 8722) goto L42;
        if (r19 != 'H') goto L29;
    L32:
        int r21 = r11 + 1;
        if (r21 < r8.length()) goto L35;
    L37:
        r21 = r11;
        int r22 = 1;
    L38:
        if (r19 != 'H') goto L40;
        String r23 = "hour";
        int r24 = r18;
    L41:
        appendWithTtsSpan(r0, formatDigits(r24, r22, r17), new TtsSpan.MeasureBuilder().setNumber(r24).setUnit(r23).build());
        r11 = r21;
        goto L43
    L40:
        r23 = "minute";
        r24 = r10;
        goto L41
    L35:
        if (r8.charAt(r21) != r19) goto L37;
        r22 = 2;
        goto L38
    L29:
        if (r19 == 'm') goto L32;
        r0.append(r19);
        goto L43
    L45:
        if (r5.isEmpty() == true) goto L47;
        appendWithTtsSpan(r0, r5, new TtsSpan.TextBuilder(r5).build());
    L47:
        SpannableString r110 = new SpannableString(r0);
        BidiFormatter r111 = BidiFormatter.getInstance();
        if (TextUtils.getLayoutDirectionFromLocale(r13) != 1) goto L50;
        r4 = true;
    L50:
        if (r4 == false) goto L52;
        TextDirectionHeuristicCompat r112 = TextDirectionHeuristicsCompat.RTL;
    L54:
        return r111.unicodeWrap(r110, r112);
    L52:
        r112 = TextDirectionHeuristicsCompat.LTR;
        goto L54
    L15:
        r7 = TimeZoneFormat.GMTOffsetPatternType.POSITIVE_HM;
        goto L16
    L12:
        r6 = false;
        goto L13
    L5:
        String r25 = r1.substring(0, r2);
        r5 = r1.substring(r2 + 3);
        r3 = r25;
        goto L7
    }
}
