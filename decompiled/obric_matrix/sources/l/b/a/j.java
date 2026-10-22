package l.b.a;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.ss.ttuploader.TTUploadResolver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class j extends t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected byte[] f21605f;

    public j(String r3) {
        this.f21605f = l.b.h.g.e(r3);
        z();     // Catch: ParseException -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalArgumentException("invalid date string: " + e.getMessage());
    }

    j(byte[] r3) {
        if (r3.length < 4) goto L16;
        this.f21605f = r3;
        if (E(0) == false) goto L14;
        if (E(1) == false) goto L14;
        if (E(2) == false) goto L14;
        if (E(3) == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
    L16:
        throw new IllegalArgumentException("GeneralizedTime string too short");
    }

    private boolean E(int r3) {
        byte[] r2 = this.f21605f;
        if (r2.length > r3) goto L5;
    L9:
        return false;
    L5:
        if (r2[r3] < 48) goto L9;
        if (r2[r3] > 57) goto L9;
        return true;
    }

    private String F(String r7) {
        String r0 = r7.substring(14);
        int r2 = 1;
    L4:
        if (r2 >= r0.length()) goto L11;
        char r3 = r0.charAt(r2);
        if ('0' > r3) goto L11;
        if (r3 > '9') goto L11;
        r2 = r2 + 1;
    L11:
        int r4 = r2 - 1;
        if (r4 <= 3) goto L15;
        String r1 = r0.substring(0, 4) + r0.substring(r2);
        StringBuilder r5 = new StringBuilder();
    L14:
        r5.append(r7.substring(0, 14));
        r5.append(r1);
        return r5.toString();
    L15:
        if (r4 != 1) goto L18;
        r1 = r0.substring(0, r2) + "00" + r0.substring(r2);
        r5 = new StringBuilder();
        goto L14
    L18:
        if (r4 != 2) goto L24;
        r1 = r0.substring(0, r2) + BDLocationException.ERROR_TIMEOUT + r0.substring(r2);
        r5 = new StringBuilder();
        goto L14
    L24:
        return r7;
    }

    private SimpleDateFormat w() {
        if (B() == false) goto L6;
        SimpleDateFormat r3 = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
    L12:
        r3.setTimeZone(new SimpleTimeZone(0, "Z"));
        return r3;
    L6:
        if (D() == false) goto L9;
        r3 = new SimpleDateFormat("yyyyMMddHHmmssz");
        goto L12
    L9:
        if (C() == false) goto L11;
        r3 = new SimpleDateFormat("yyyyMMddHHmmz");
        goto L12
    L11:
        r3 = new SimpleDateFormat("yyyyMMddHHz");
        goto L12
    }

    private String x(String r10) {
        TimeZone r2 = TimeZone.getDefault();
        int r3 = r2.getRawOffset();
        if (r3 >= 0) goto L5;
        r3 = -r3;
        String r5 = "-";
    L6:
        int r6 = r3 / 3600000;
        int r4 = (r3 - (((r6 * 60) * 60) * 1000)) / TTUploadResolver.HOST_MAX_CACHE_TIME;
        if (r2.useDaylightTime() == false) goto L20;
        if (B() == false) goto L13;
        r10 = F(r10);     // Catch: ParseException -> L21
    L13:
        if (r2.inDaylightTime(w().parse(r10 + "GMT" + r5 + y(r6) + ":" + y(r4))) == false) goto L20;
        if (r5.equals("+") == false) goto L17;
        int r11 = 1;
    L18:
        r6 = r6 + r11;
        goto L20
    L17:
        r11 = -1;
    L20:
        return "GMT" + r5 + y(r6) + ":" + y(r4);
    L5:
        r5 = "+";
        goto L6
    }

    private String y(int r2) {
        if (r2 >= 10) goto L7;
        return BDLocationException.ERROR_TIMEOUT + r2;
    L7:
        return Integer.toString(r2);
    }

    public String A() {
        String r0 = l.b.h.g.b(this.f21605f);
        if (r0.charAt(r0.length() - 1) == 'Z') goto L5;
        int r1 = r0.length() - 6;
        char r3 = r0.charAt(r1);
        if (r3 == '-') goto L10;
        if (r3 == '+') goto L10;
    L12:
        int r2 = r0.length() - 5;
        char r4 = r0.charAt(r2);
        if (r4 == '-') goto L24;
        if (r4 == '+') goto L24;
        int r5 = r0.length() - 3;
        char r6 = r0.charAt(r5);
        if (r6 == '-') goto L23;
        if (r6 == '+') goto L23;
        return r0 + x(r0);
    L23:
        return r0.substring(0, r5) + "GMT" + r0.substring(r5) + ":00";
    L24:
        StringBuilder r7 = new StringBuilder();
        r7.append(r0.substring(0, r2));
        r7.append("GMT");
        int r8 = r2 + 3;
        r7.append(r0.substring(r2, r8));
        r7.append(":");
        r7.append(r0.substring(r8));
        return r7.toString();
    L10:
        if (r0.indexOf("GMT") != (r1 - 3)) goto L12;
        return r0;
    L5:
        return r0.substring(0, r0.length() - 1) + "GMT+00:00";
    }

    protected boolean B() {
        int r1 = 0;
    L3:
        byte[] r2 = this.f21605f;
        if (r1 == r2.length) goto L12;
        if (r2[r1] != 46) goto L11;
        if (r1 != 14) goto L11;
        return true;
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        return false;
    }

    protected boolean C() {
        if (E(10) == true) goto L5;
    L7:
        return false;
    L5:
        if (E(11) == false) goto L7;
        return true;
    }

    protected boolean D() {
        if (E(12) == true) goto L5;
    L7:
        return false;
    L5:
        if (E(13) == false) goto L7;
        return true;
    }

    @Override // l.b.a.n
    public int hashCode() {
        return l.b.h.a.j(this.f21605f);
    }

    @Override // l.b.a.t
    boolean n(t r2) {
        if ((r2 instanceof j) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.a(this.f21605f, ((j) r2).f21605f);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.n(r3, 24, this.f21605f);
    }

    @Override // l.b.a.t
    int p() {
        int r1 = this.f21605f.length;
        return (c2.a(r1) + 1) + r1;
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }

    @Override // l.b.a.t
    t u() {
        return new t0(this.f21605f);
    }

    @Override // l.b.a.t
    t v() {
        return new t0(this.f21605f);
    }

    public Date z() {
        String r0 = l.b.h.g.b(this.f21605f);
        if (r0.endsWith("Z") == false) goto L16;
        if (B() == false) goto L8;
        SimpleDateFormat r2 = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
    L14:
        r2.setTimeZone(new SimpleTimeZone(0, "Z"));
    L34:
        if (B() == false) goto L37;
        r0 = F(r0);
    L37:
        return u1.a(r2.parse(r0));
    L8:
        if (D() == false) goto L11;
        r2 = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        goto L14
    L11:
        if (C() == false) goto L13;
        r2 = new SimpleDateFormat("yyyyMMddHHmm'Z'");
        goto L14
    L13:
        r2 = new SimpleDateFormat("yyyyMMddHH'Z'");
        goto L14
    L16:
        if (r0.indexOf(45) <= 0) goto L18;
    L32:
        r0 = A();
        r2 = w();
        goto L34
    L18:
        if (r0.indexOf(43) > 0) goto L32;
        if (B() == false) goto L25;
        SimpleDateFormat r1 = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
    L23:
        r2 = r1;
        r2.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        goto L34
    L25:
        if (D() == false) goto L28;
        r1 = new SimpleDateFormat("yyyyMMddHHmmss");
        goto L23
    L28:
        if (C() == false) goto L30;
        r1 = new SimpleDateFormat("yyyyMMddHHmm");
        goto L23
    L30:
        r1 = new SimpleDateFormat("yyyyMMddHH");
        goto L23
    }
}
