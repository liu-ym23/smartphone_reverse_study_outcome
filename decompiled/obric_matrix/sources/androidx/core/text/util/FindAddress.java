package androidx.core.text.util;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class FindAddress {
    private static final String HOUSE_COMPONENT = "(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)";
    private static final String HOUSE_END = "(?=[,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    private static final String HOUSE_POST_DELIM = ",\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final String HOUSE_PRE_DELIM = ":,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final int MAX_ADDRESS_LINES = 5;
    private static final int MAX_ADDRESS_WORDS = 14;
    private static final int MAX_LOCATION_NAME_DISTANCE = 5;
    private static final int MIN_ADDRESS_WORDS = 4;
    private static final String NL = "\n\u000b\f\r\u0085\u2028\u2029";
    private static final String SP = "\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000";
    private static final String WORD_DELIM = ",*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final String WORD_END = "(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    private static final String WS = "\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    private static final int kMaxAddressNameWordLength = 25;
    private static final Pattern sHouseNumberRe = null;
    private static final Pattern sLocationNameRe = null;
    private static final Pattern sStateRe = null;
    private static final ZipRange[] sStateZipCodeRanges = null;
    private static final Pattern sSuffixedNumberRe = null;
    private static final Pattern sWordRe = null;
    private static final Pattern sZipCodeRe = null;

    private static class ZipRange {
        int mException1;
        int mException2;
        int mHigh;
        int mLow;

        ZipRange(int r1, int r2, int r3, int r4) {
            this.mLow = r1;
            this.mHigh = r2;
            this.mException1 = r3;
            this.mException2 = r4;
        }

        boolean matches(String r3) {
            int r4 = Integer.parseInt(r3.substring(0, 2));
            if (this.mLow > r4) goto L7;
            if (r4 > this.mHigh) goto L7;
        L10:
            return true;
        L7:
            if (r4 == this.mException1) goto L10;
            if (r4 == this.mException2) goto L10;
            return false;
        }
    }

    static {
        sStateZipCodeRanges = new ZipRange[]{new ZipRange(99, 99, -1, -1), new ZipRange(35, 36, -1, -1), new ZipRange(71, 72, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(85, 86, -1, -1), new ZipRange(90, 96, -1, -1), new ZipRange(80, 81, -1, -1), new ZipRange(6, 6, -1, -1), new ZipRange(20, 20, -1, -1), new ZipRange(19, 19, -1, -1), new ZipRange(32, 34, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(30, 31, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(50, 52, -1, -1), new ZipRange(83, 83, -1, -1), new ZipRange(60, 62, -1, -1), new ZipRange(46, 47, -1, -1), new ZipRange(66, 67, 73, -1), new ZipRange(40, 42, -1, -1), new ZipRange(70, 71, -1, -1), new ZipRange(1, 2, -1, -1), new ZipRange(20, 21, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(48, 49, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(63, 65, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(38, 39, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(27, 28, -1, -1), new ZipRange(58, 58, -1, -1), new ZipRange(68, 69, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(7, 8, -1, -1), new ZipRange(87, 88, 86, -1), new ZipRange(88, 89, 96, -1), new ZipRange(10, 14, 0, 6), new ZipRange(43, 45, -1, -1), new ZipRange(73, 74, -1, -1), new ZipRange(97, 97, -1, -1), new ZipRange(15, 19, -1, -1), new ZipRange(6, 6, 0, 9), new ZipRange(96, 96, -1, -1), new ZipRange(2, 2, -1, -1), new ZipRange(29, 29, -1, -1), new ZipRange(57, 57, -1, -1), new ZipRange(37, 38, -1, -1), new ZipRange(75, 79, 87, 88), new ZipRange(84, 84, -1, -1), new ZipRange(22, 24, 20, -1), new ZipRange(6, 9, -1, -1), new ZipRange(5, 5, -1, -1), new ZipRange(98, 99, -1, -1), new ZipRange(53, 54, -1, -1), new ZipRange(24, 26, -1, -1), new ZipRange(82, 83, -1, -1)};
        sWordRe = Pattern.compile("[^,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]+(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sHouseNumberRe = Pattern.compile("(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sStateRe = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+of[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+states[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+of[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+mariana[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+carolina)|(nd|north[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+dakota)|(ne|nebraska)|(nh|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+hampshire)|(nj|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+jersey)|(nm|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+mexico)|(nv|nevada)|(ny|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+rico)|(pw|palau)|(ri|rhode[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+island)|(sc|south[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+carolina)|(sd|south[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+virginia)|(wy|wyoming))(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sLocationNameRe = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sSuffixedNumberRe = Pattern.compile("([0-9]+)(st|nd|rd|th)", 2);
        sZipCodeRe = Pattern.compile("(?:[0-9]{5}(?:-[0-9]{4})?)(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
    }

    private FindAddress() {
    }

    private static int attemptMatch(String r13, MatchResult r14) {
        int r15 = r14.end();
        Matcher r0 = sWordRe.matcher(r13);
        String r4 = "";
        int r9 = -1;
        int r10 = -1;
        boolean r8 = false;
        int r5 = 1;
        int r6 = 1;
        boolean r7 = true;
    L4:
        if (r15 >= r13.length()) goto L58;
        if (r0.find(r15) == false) goto L7;
        if ((r0.end() - r0.start()) > 25) goto L12;
    L14:
        if (r15 >= r0.start()) goto L20;
        int r11 = r15 + 1;
        if (NL.indexOf(r13.charAt(r15)) == (-1)) goto L18;
        r5 = r5 + 1;
    L18:
        r15 = r11;
        goto L14
    L20:
        if (r5 > 5) goto L58;
        r6 = r6 + 1;
        if (r6 > 14) goto L58;
        if (matchHouseNumber(r13, r15) == null) goto L34;
        if (r7 == false) goto L31;
        if (r5 <= 1) goto L31;
        return -r15;
    L31:
        if (r9 != (-1)) goto L57;
        r9 = r15;
    L57:
        r4 = r0.group(0);
        r15 = r0.end();
        goto L4
    L34:
        if (isValidLocationName(r0.group(0)) == false) goto L36;
        r7 = false;
        r8 = true;
        goto L57
    L36:
        if (r6 != 5) goto L39;
        if (r8 == true) goto L39;
        r15 = r0.end();
    L39:
        if (r8 == true) goto L41;
    L56:
        r7 = false;
        goto L57
    L41:
        if (r6 <= 4) goto L56;
        MatchResult r16 = matchState(r13, r15);
        if (r16 == null) goto L56;
        if (r4.equals("et") == true) goto L47;
    L49:
        Matcher r12 = sWordRe.matcher(r13);
        if (r12.find(r16.end()) == true) goto L52;
        r10 = r16.end();
        goto L56
    L52:
        if (isValidZipCode(r12.group(0), r16) == false) goto L56;
        return r12.end();
    L47:
        if (r16.group(0).equals("al") == false) goto L49;
        r15 = r16.end();
        goto L58
    L12:
        int r17 = r0.end();
    L9:
        return -r17;
    L7:
        r17 = r13.length();
    L58:
        if (r10 <= 0) goto L60;
        return r10;
    L60:
        if (r9 > 0) goto L64;
        r9 = r15;
    L64:
        return -r9;
    }

    private static boolean checkHouseNumber(String r5) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r5.length()) goto L10;
        if (Character.isDigit(r5.charAt(r1)) == false) goto L8;
        r2 = r2 + 1;
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        if (r2 <= 5) goto L12;
        return false;
    L12:
        Matcher r6 = sSuffixedNumberRe.matcher(r5);
        if (r6.find() == false) goto L42;
        int r3 = Integer.parseInt(r6.group(1));
        if (r3 != 0) goto L17;
        return false;
    L17:
        String r7 = r6.group(2).toLowerCase(Locale.getDefault());
        int r4 = r3 % 10;
        String r8 = "th";
        if (r4 == 1) goto L37;
        if (r4 == 2) goto L31;
        if (r4 == 3) goto L25;
        return r7.equals("th");
    L25:
        if ((r3 % 100) == 13) goto L29;
        r8 = "rd";
    L29:
        return r7.equals(r8);
    L31:
        if ((r3 % 100) == 12) goto L35;
        r8 = "nd";
    L35:
        return r7.equals(r8);
    L37:
        if ((r3 % 100) == 11) goto L41;
        r8 = "st";
    L41:
        return r7.equals(r8);
    L42:
        return true;
    }

    static String findAddress(String r4) {
        Matcher r0 = sHouseNumberRe.matcher(r4);
        int r2 = 0;
    L4:
        if (r0.find(r2) == false) goto L13;
        if (checkHouseNumber(r0.group(0)) == true) goto L7;
        r2 = r0.end();
        goto L4
    L7:
        int r3 = r0.start();
        int r5 = attemptMatch(r4, r0);
        if (r5 > 0) goto L10;
        r2 = -r5;
        goto L4
    L10:
        return r4.substring(r3, r5);
    L13:
        return null;
    }

    @VisibleForTesting
    public static boolean isValidLocationName(String r1) {
        return sLocationNameRe.matcher(r1).matches();
    }

    @VisibleForTesting
    public static boolean isValidZipCode(String r1) {
        return sZipCodeRe.matcher(r1).matches();
    }

    @VisibleForTesting
    public static boolean isValidZipCode(String r1, String r2) {
        return isValidZipCode(r1, matchState(r2, 0));
    }

    private static boolean isValidZipCode(String r3, MatchResult r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        int r1 = r4.groupCount();
    L6:
        if (r1 <= 0) goto L12;
        int r2 = r1 - 1;
        if (r4.group(r1) != null) goto L9;
        r1 = r2;
        goto L6
    L9:
        r1 = r2;
    L12:
        if (sZipCodeRe.matcher(r3).matches() == true) goto L14;
        return false;
    L14:
        if (sStateZipCodeRanges[r1].matches(r3) == false) goto L20;
        return true;
    L20:
        return false;
    }

    @VisibleForTesting
    public static MatchResult matchHouseNumber(String r3, int r4) {
        if (r4 > 0) goto L5;
    L7:
        Matcher r5 = sHouseNumberRe.matcher(r3).region(r4, r3.length());
        if (r5.lookingAt() == false) goto L12;
        MatchResult r6 = r5.toMatchResult();
        if (checkHouseNumber(r6.group(0)) == false) goto L12;
        return r6;
    L12:
        return null;
    L5:
        if (HOUSE_PRE_DELIM.indexOf(r3.charAt(r4 - 1)) != (-1)) goto L7;
        return null;
    }

    @VisibleForTesting
    public static MatchResult matchState(String r3, int r4) {
        if (r4 > 0) goto L5;
    L7:
        Matcher r5 = sStateRe.matcher(r3).region(r4, r3.length());
        if (r5.lookingAt() == true) goto L10;
        return null;
    L10:
        return r5.toMatchResult();
    L5:
        if (WORD_DELIM.indexOf(r3.charAt(r4 - 1)) != (-1)) goto L7;
        return null;
    }
}
