package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import com.bytedanceos.preventdisturb.EventUtils;
import com.qq.taf.jce.JceInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import tmsdk.common.TMSDKContext;
import tmsdk.common.module.update.UpdateConfig;
import tmsdk.common.tcc.TccCryptor;

/* JADX INFO: loaded from: classes5.dex */
public class cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f128a;

    public cc() {
    }

    private static String a(String r2, int r3) {
        return String.format(tb.a(r2), new Object[]{Integer.valueOf(r3)});
    L4:
        th = move-exception;
        q8.b("DataParse", th);
        return "";
    }

    public static List b(String r2, byte[] r3) {
        byte[] r4 = ((mk) z7.a(r3, new mk(), false)).b;
        if (r4 != null) goto L7;
        return null;
    L7:
        return a(r2, r4);
    }

    private static ce a(String r1, Map r2, String r3) {
        ce r0 = new ce();
        r0.e = r1;
        r0.c = Integer.parseInt((String) r2.get(9));
        ArrayList r4 = new ArrayList();
        r0.b = r4;
        r4.add(r3.toLowerCase());
        r0.d = c2.b(tb.c(), r2);
        r0.k = fa.c((String) r2.get(19));
        r0.l = (String) r2.get(20);
        r0.m = (String) r2.get(21);
        r0.n = (int) fa.b((String) r2.get(22));
        return r0;
    }

    protected boolean a(boolean r18, e6 r19) {
        int r1 = 0;
        if (r19 != null) goto L5;
        return false;
    L5:
        k2 r2 = (k2) mg.b(TMSDKContext.getApplicaionContext(), UpdateConfig.intToString(40248) + ".dat", UpdateConfig.intToString(40248), new k2(), "UTF-8");
        if (r2 == null) goto L73;
        if (r2.f299a == null) goto L73;
        HashMap r3 = a(r18);
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        Iterator r7 = r2.f299a.iterator();
    L11:
        String r8 = "0";
        if (r7.hasNext() == false) goto L67;
        j2 r9 = (j2) r7.next();
        if (TextUtils.equals(r9.f281a, "1") == true) goto L20;
        if (TextUtils.equals(r9.f281a, "2") == true) goto L20;
        if (TextUtils.equals(r9.f281a, "3") == false) goto L11;
    L20:
        kd r10 = new kd();
        r10.b = r9.b;
        if (r3 == null) goto L30;
        if (r3.isEmpty() == true) goto L30;
        r10.i = (String) r3.get(r9.c);
        if (TextUtils.isEmpty(r9.d) == false) goto L27;
        String r14 = null;
    L28:
        r10.j = r14;
        goto L30
    L27:
        r14 = (String) r3.get(r9.d);
    L30:
        if (r10.i != null) goto L33;
        r10.i = r9.c;
    L33:
        if (r10.j != null) goto L35;
        r10.j = r9.d;
    L35:
        r10.k = true ^ "1".equals(r9.e);
        if (TextUtils.isEmpty(r9.g) == true) goto L39;
        r8 = r9.g;
    L39:
        r10.h = r8;
        if (TextUtils.isEmpty(r9.f) == true) goto L57;
        String[] r11 = r9.f.split("&");
        if (r11 == null) goto L57;
        int r12 = r11.length;
        int r15 = r1;
    L44:
        if (r15 >= r12) goto L57;
        String r16 = r11[r15];
        Iterator r110 = r7;
        if (r16.length() <= 2) goto L56;
        char r17 = r16.charAt(0);
        String r13 = r16.substring(2);
        switch(r17) {
            case 49: goto L55;
            case 50: goto L54;
            case 51: goto L53;
            case 52: goto L52;
            case 53: goto L51;
            default: goto L56;
        };
    L51:
        r10.g = r13;
        goto L56
    L52:
        r10.f = r13;
        goto L56
    L53:
        r10.e = r13;
        goto L56
    L54:
        r10.d = r13;
        goto L56
    L55:
        r10.c = r13;
    L56:
        r15 = r15 + 1;
        r7 = r110;
    L57:
        Iterator r111 = r7;
        if ("1".equals(r9.f281a) == false) goto L62;
        r4.add(r10);
    L60:
        r7 = r111;
        r1 = 0;
        goto L11
    L62:
        if ("2".equals(r9.f281a) == false) goto L65;
        r5.add(r10);
        goto L60
    L65:
        if ("3".equals(r9.f281a) == false) goto L60;
        r6.add(r10);
        goto L60
    L67:
        kd r20 = new kd();
        r20.c = ".apk";
        r20.h = "0";
        r4.add(r20);
        if (r5.size() <= 0) goto L70;
        r20.h = ((kd) r5.get(0)).h;
    L70:
        r19.b(r6);
        r19.c(r4);
        r19.a(r5);
        r19.a(r20);
        return true;
    L73:
        return false;
    }

    private static List a(String r11, byte[] r12) {
        JceInputStream r4 = new JceInputStream(TccCryptor.decrypt(r12, null));     // Catch: Throwable -> L31
        r4.setServerEncoding("UTF-8");     // Catch: Throwable -> L31
        kk r13 = new kk();     // Catch: Throwable -> L31
        r13.readFrom(r4);     // Catch: Throwable -> L31
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L31
        Iterator r14 = r13.f312a.iterator();     // Catch: Throwable -> L31
    L4:
        if (r14.hasNext() == false) goto L30;
        Map r6 = (Map) r14.next();     // Catch: Throwable -> L31
        String r7 = (String) r6.get(3);     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r7) == false) goto L8;
        String r8 = (String) r6.get(4);     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r8) == true) goto L4;
        ce r9 = a(r11, r6, r8);     // Catch: Throwable -> L31
        r9.p = EventUtils.TO_APPMANAGER_ACTIVITY;     // Catch: Throwable -> L31
        r9.f = (String) r6.get(11);     // Catch: Throwable -> L31
        r9.g = (String) r6.get(12);     // Catch: Throwable -> L31
        r9.h = (String) r6.get(13);     // Catch: Throwable -> L31
        r9.i = (String) r6.get(14);     // Catch: Throwable -> L31
        r9.j = (String) r6.get(15);     // Catch: Throwable -> L31
        String r10 = (String) r6.get(23);     // Catch: Throwable -> L31
        if (r10 == null) goto L26;
        r9.o = fa.a(r10);     // Catch: Throwable -> L31
    L26:
        if (r9.n <= 100) goto L28;
        r9.n = 0;     // Catch: Throwable -> L31
    L28:
        r5.add(r9);     // Catch: Throwable -> L31
        goto L4
    L8:
        ce r15 = a(r11, r6, r7);     // Catch: Throwable -> L31
        r15.p = "3";     // Catch: Throwable -> L31
        String r16 = (String) r6.get(23);     // Catch: Throwable -> L31
        if (r16 == null) goto L12;
        r15.o = fa.a(r16);     // Catch: Throwable -> L31
    L12:
        if (r15.n <= 100) goto L14;
        r15.n = 0;     // Catch: Throwable -> L31
    L14:
        String r17 = (String) r6.get(10);     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r17) == true) goto L19;
        int r18 = Integer.valueOf(r17).intValue();     // Catch: Throwable -> L31
        if (r18 <= 0) goto L19;
        r15.d += "(" + a("in_recent_days", r18) + ")";     // Catch: Throwable -> L31
        r15.j = "0," + r18;     // Catch: Throwable -> L31
        ce r19 = a(r11, r6, r7);     // Catch: Throwable -> L31
        r19.c = 1;     // Catch: Throwable -> L31
        r19.j = "" + r18 + ",-";     // Catch: Throwable -> L31
        r19.d += "(" + a("days_ago", r18) + ")";     // Catch: Throwable -> L31
        r19.p = "3";     // Catch: Throwable -> L31
        r19.o = r15.o;     // Catch: Throwable -> L31
        r5.add(r19);     // Catch: Throwable -> L31
    L19:
        r5.add(r15);     // Catch: Throwable -> L31
        goto L4
    L30:
        return r5;
    L31:
        th = move-exception;
        q8.b("DataParse", th);
        return null;
    }

    protected boolean a(Context r9) {
        this.f128a = new HashMap();
        lk r10 = (lk) mg.a(TMSDKContext.getApplicaionContext(), UpdateConfig.DEEPCLEAN_SDCARD_SCAN_RULE_NAME_V2_SDK, UpdateConfig.intToString(40415), new lk(), "UTF-8");
        if (r10 == null) goto L34;
        ArrayList r11 = r10.f338a;
        if (r11 == null) goto L55;
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L32;
        mk r0 = (mk) r12.next();
        he r1 = new he();
        Iterator r2 = r0.f357a.iterator();
    L12:
        if (r2.hasNext() == false) goto L22;
        Map r3 = (Map) r2.next();
        if (r3.get(2) != null) goto L15;
        if (r3.get(5) == null) goto L12;
        String r5 = new String(TccCryptor.decrypt(c3.a(((String) r3.get(5)).toUpperCase()), null));
        if (r1.b != null) goto L21;
        r1.b = new HashMap();
    L21:
        String r4 = c2.a(tb.c(), r3);
        r1.b.put(r5, new String(TccCryptor.decrypt(c3.a(r4.toUpperCase()), null)));
        goto L12
    L15:
        r1.f246a = ((String) r3.get(2)).toLowerCase();
        goto L12
    L22:
        byte[] r6 = r0.b;
        List r7 = a(r1.f246a, r6);
        r1.c = r7;
        if (r7 == null) goto L9;
        if (r7.size() == 0) goto L9;
        Map r8 = r1.b;
        if (r8 == null) goto L9;
        if (r8.size() == 0) goto L9;
        this.f128a.put(r1.f246a, r1);
        goto L9
    L32:
        return true;
    L55:
        return false;
    L34:
        return false;
    }

    public static HashMap a(boolean r7) {
        k2 r0 = (k2) mg.b(TMSDKContext.getApplicaionContext(), UpdateConfig.intToString(40291) + ".dat", UpdateConfig.intToString(40291), new k2(), "UTF-8");
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.f299a == null) goto L82;
        HashMap r1 = new HashMap();
        if (r7 == false) goto L10;
        int r8 = 0;
    L11:
        Iterator r2 = r0.f299a.iterator();
    L13:
        if (r2.hasNext() == false) goto L24;
        j2 r3 = (j2) r2.next();
        if (TextUtils.isEmpty(r3.f281a) == true) goto L13;
        if (TextUtils.isEmpty(r3.b) == true) goto L13;
        if (TextUtils.equals(String.valueOf(1), r3.f281a) == false) goto L13;
        a(r3, r8, r1);
        goto L13
    L24:
        if (tb.e() == true) goto L51;
        String r9 = h8.d().e().toLowerCase();
        String r4 = h8.d().b().toLowerCase();
        String r5 = h8.d().f().toLowerCase();
        Iterator r6 = r0.f299a.iterator();
    L27:
        if (r6.hasNext() == false) goto L51;
        j2 r10 = (j2) r6.next();
        if (TextUtils.equals(String.valueOf(10), r10.f281a) == false) goto L27;
        if (TextUtils.isEmpty(r10.b) == true) goto L27;
        if (TextUtils.isEmpty(r10.c) == true) goto L27;
        if (TextUtils.isEmpty(r10.f) == true) goto L27;
        if (Pattern.compile(r10.f.toLowerCase()).matcher(r9).matches() == false) goto L27;
        String r11 = r10.g.toLowerCase();
        if (TextUtils.isEmpty(r11) == true) goto L45;
        if (Pattern.compile(r11).matcher(r4).matches() == false) goto L27;
    L45:
        String r12 = r10.h.toLowerCase();
        if (TextUtils.isEmpty(r12) == true) goto L50;
        if (Pattern.compile(r12).matcher(r5).matches() == false) goto L27;
    L50:
        r1.put(r10.b, r10.c);
    L51:
        return r1;
    L10:
        r8 = tb.b();
        goto L11
    L82:
        return null;
    }

    private static void a(j2 r1, int r2, HashMap r3) {
        if (r2 == 0) goto L28;
        if (r2 == 2) goto L25;
        if (r2 == 3) goto L19;
        if (r2 == 4) goto L16;
        if (r2 == 5) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r1.f) == true) goto L32;
        String r4 = r1.b;
        String r5 = r1.f;
    L30:
        r3.put(r4, r5);
        return;
    L32:
        return;
    L16:
        if (TextUtils.isEmpty(r1.e) == true) goto L33;
        r4 = r1.b;
        r5 = r1.e;
        goto L30
    L33:
        return;
    L19:
        if (TextUtils.isEmpty(r1.g) == true) goto L22;
        r4 = r1.b;
        r5 = r1.g;
        goto L30
    L22:
        if (TextUtils.isEmpty(r1.d) == true) goto L34;
    L26:
        r4 = r1.b;
        r5 = r1.d;
        goto L30
    L34:
        return;
    L25:
        if (TextUtils.isEmpty(r1.d) == false) goto L26;
        return;
    L28:
        if (TextUtils.isEmpty(r1.c) == true) goto L36;
        r4 = r1.b;
        r5 = r1.c;
        goto L30
    }
}
