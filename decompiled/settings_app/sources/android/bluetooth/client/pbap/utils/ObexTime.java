package android.bluetooth.client.pbap.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class ObexTime {
    private Date mDate;

    public ObexTime(String r9) {
        Matcher r10 = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})T(\\d{2})(\\d{2})(\\d{2})(([+-])(\\d{2})(\\d{2}))?").matcher(r9);
        if (r10.matches() == false) goto L12;
        Calendar r0 = Calendar.getInstance();
        r0.set(Integer.parseInt(r10.group(1)), Integer.parseInt(r10.group(2)) - 1, Integer.parseInt(r10.group(3)), Integer.parseInt(r10.group(4)), Integer.parseInt(r10.group(5)), Integer.parseInt(r10.group(6)));
        if (r10.group(7) == null) goto L10;
        int r1 = Integer.parseInt(r10.group(9));
        int r2 = r1 * 60;
        int r3 = ((r2 + Integer.parseInt(r10.group(10))) * 60) * 1000;
        if (r10.group(8).equals("-") == false) goto L9;
        r3 = -r3;
    L9:
        TimeZone r11 = TimeZone.getTimeZone("UTC");
        r11.setRawOffset(r3);
        r0.setTimeZone(r11);
    L10:
        this.mDate = r0.getTime();
        return;
    }

    public ObexTime(Date r1) {
        this.mDate = r1;
    }

    public Date getTime() {
        return this.mDate;
    }

    public String toString() {
        if (this.mDate != null) goto L6;
        return null;
    L6:
        Calendar r0 = Calendar.getInstance();
        r0.setTime(this.mDate);
        return String.format(Locale.US, "%04d%02d%02dT%02d%02d%02d", new Object[]{Integer.valueOf(r0.get(1)), Integer.valueOf(r0.get(2) + 1), Integer.valueOf(r0.get(5)), Integer.valueOf(r0.get(11)), Integer.valueOf(r0.get(12)), Integer.valueOf(r0.get(13))});
    }
}
