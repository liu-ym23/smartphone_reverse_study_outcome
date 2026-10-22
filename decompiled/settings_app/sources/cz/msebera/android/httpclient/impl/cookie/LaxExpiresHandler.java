package cz.msebera.android.httpclient.impl.cookie;

import com.obric.oui.calendar.ODatePickerView;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.Args;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public class LaxExpiresHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
    private static final Pattern DAY_OF_MONTH_PATTERN = null;
    private static final BitSet DELIMS = null;
    private static final Map<String, Integer> MONTHS = null;
    private static final Pattern MONTH_PATTERN = null;
    private static final Pattern TIME_PATTERN = null;
    static final TimeZone UTC = null;
    private static final Pattern YEAR_PATTERN = null;

    @Override // cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return ClientCookie.EXPIRES_ATTR;
    }

    static {
        UTC = TimeZone.getTimeZone("UTC");
        BitSet r0 = new BitSet();
        r0.set(9);
        int r2 = 32;
    L4:
        if (r2 > 47) goto L6;
        r0.set(r2);
        r2 = r2 + 1;
        goto L4
    L6:
        int r3 = 59;
    L8:
        if (r3 > 64) goto L10;
        r0.set(r3);
        r3 = r3 + 1;
        goto L8
    L10:
        int r4 = 91;
    L12:
        if (r4 > 96) goto L14;
        r0.set(r4);
        r4 = r4 + 1;
        goto L12
    L14:
        int r5 = 123;
    L16:
        if (r5 > 126) goto L18;
        r0.set(r5);
        r5 = r5 + 1;
        goto L16
    L18:
        DELIMS = r0;
        ConcurrentHashMap r1 = new ConcurrentHashMap(12);
        r1.put("jan", 0);
        r1.put("feb", 1);
        r1.put("mar", 2);
        r1.put("apr", 3);
        r1.put("may", 4);
        r1.put("jun", 5);
        r1.put("jul", 6);
        r1.put("aug", 7);
        r1.put("sep", 8);
        r1.put("oct", 9);
        r1.put("nov", 10);
        r1.put("dec", 11);
        MONTHS = r1;
        TIME_PATTERN = Pattern.compile("^([0-9]{1,2}):([0-9]{1,2}):([0-9]{1,2})([^0-9].*)?$");
        DAY_OF_MONTH_PATTERN = Pattern.compile("^([0-9]{1,2})([^0-9].*)?$");
        MONTH_PATTERN = Pattern.compile("^(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)(.*)?$", 2);
        YEAR_PATTERN = Pattern.compile("^([0-9]{2,4})([^0-9].*)?$");
    }

    public LaxExpiresHandler() {
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieAttributeHandler
    public void parse(SetCookie r21, String r22) throws MalformedCookieException {
        Args.notNull(r21, "Cookie");
        ParserCursor r4 = new ParserCursor(0, r22.length());
        StringBuilder r5 = new StringBuilder();
        boolean r7 = false;
        int r8 = 0;
        boolean r9 = false;
        boolean r10 = false;
        boolean r11 = false;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L59:
        if (r4.atEnd() == true) goto L27;
        skipDelims(r22, r4);     // Catch: NumberFormatException -> L57
        r5.setLength(0);     // Catch: NumberFormatException -> L57
        copyContent(r22, r4, r5);     // Catch: NumberFormatException -> L57
        if (r5.length() == 0) goto L27;
        if (r7 == true) goto L12;
        Matcher r6 = TIME_PATTERN.matcher(r5);     // Catch: NumberFormatException -> L57
        if (r6.matches() == false) goto L12;
        r13 = Integer.parseInt(r6.group(1));     // Catch: NumberFormatException -> L57
        r14 = Integer.parseInt(r6.group(2));     // Catch: NumberFormatException -> L57
        r15 = Integer.parseInt(r6.group(3));     // Catch: NumberFormatException -> L57
        r7 = true;
    L12:
        if (r9 == true) goto L16;
        Matcher r0 = DAY_OF_MONTH_PATTERN.matcher(r5);     // Catch: NumberFormatException -> L57
        if (r0.matches() == false) goto L16;
        r12 = Integer.parseInt(r0.group(1));     // Catch: NumberFormatException -> L57
        r9 = true;
    L16:
        if (r10 == true) goto L20;
        Matcher r1 = MONTH_PATTERN.matcher(r5);     // Catch: NumberFormatException -> L57
        if (r1.matches() == false) goto L20;
        r16 = MONTHS.get(r1.group(1).toLowerCase(Locale.ROOT)).intValue();     // Catch: NumberFormatException -> L57
        r10 = true;
    L20:
        if (r11 == true) goto L59;
        Matcher r2 = YEAR_PATTERN.matcher(r5);     // Catch: NumberFormatException -> L57
        if (r2.matches() == false) goto L59;
        r8 = Integer.parseInt(r2.group(1));     // Catch: NumberFormatException -> L57
        r11 = true;
    L27:
        if (r7 == false) goto L56;
        if (r9 == false) goto L56;
        if (r10 == false) goto L56;
        if (r11 == false) goto L56;
        if (r8 >= 70) goto L34;
    L36:
        if (r8 < 0) goto L41;
        if (r8 > 69) goto L41;
        r8 = r8 + 2000;
    L41:
        if (r12 < 1) goto L54;
        if (r12 > 31) goto L54;
        if (r8 < 1601) goto L54;
        if (r13 > 23) goto L54;
        if (r14 > 59) goto L54;
        if (r15 > 59) goto L54;
        Calendar r3 = Calendar.getInstance();
        r3.setTimeZone(UTC);
        r3.setTimeInMillis(0);
        r3.set(13, r15);
        r3.set(12, r14);
        r3.set(11, r13);
        r3.set(5, r12);
        r3.set(2, r16);
        r3.set(1, r8);
        r21.setExpiryDate(r3.getTime());
        return;
    L54:
        throw new MalformedCookieException("Invalid 'expires' attribute: " + r22);
    L34:
        if (r8 > 99) goto L36;
        r8 = r8 + ODatePickerView.YEAR_FROM;
    L56:
        throw new MalformedCookieException("Invalid 'expires' attribute: " + r22);
    L58:
        throw new MalformedCookieException("Invalid 'expires' attribute: " + r22);
    }

    private void skipDelims(CharSequence r5, ParserCursor r6) {
        int r4 = r6.getPos();
        int r0 = r6.getPos();
        int r1 = r6.getUpperBound();
    L3:
        if (r0 >= r1) goto L7;
        char r2 = r5.charAt(r0);
        if (DELIMS.get(r2) == false) goto L7;
        r4 = r4 + 1;
        r0 = r0 + 1;
    L7:
        r6.updatePos(r4);
    }

    private void copyContent(CharSequence r5, ParserCursor r6, StringBuilder r7) {
        int r4 = r6.getPos();
        int r0 = r6.getPos();
        int r1 = r6.getUpperBound();
    L3:
        if (r0 >= r1) goto L8;
        char r2 = r5.charAt(r0);
        if (DELIMS.get(r2) == true) goto L8;
        r4 = r4 + 1;
        r7.append(r2);
        r0 = r0 + 1;
    L8:
        r6.updatePos(r4);
    }
}
