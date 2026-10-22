package tmsdkobf;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Pattern;
import tmsdk.common.TMSDKContext;
import tmsdk.common.module.update.UpdateConfig;

/* JADX INFO: loaded from: classes5.dex */
public abstract class f8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Properties f197a;

    static {
        f197a = new Properties();
    }

    private static String a(j2 r2, int r3) {
        if (r2 != null) goto L6;
        return "";
    L6:
        switch(r3) {
            case 1: goto L35;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L29;
            case 5: goto L27;
            case 6: goto L21;
            case 7: goto L15;
            case 8: goto L9;
            default: goto L7;
        };
    L7:
        return "";
    L9:
        if (TextUtils.isEmpty(r2.h) == false) goto L13;
        return a(r2, 4);
    L13:
        return r2.h;
    L15:
        if (TextUtils.isEmpty(r2.g) == false) goto L19;
        return a(r2, 4);
    L19:
        return r2.g;
    L21:
        if (TextUtils.isEmpty(r2.f) == false) goto L25;
        return a(r2, 5);
    L25:
        return r2.f;
    L27:
        return r2.e;
    L29:
        return r2.d;
    L31:
        return r2.c;
    L33:
        return r2.b;
    L35:
        return r2.f281a;
    }

    public static boolean b() {
        String r0 = h8.d().e().toLowerCase();
        if (TextUtils.equals(r0, "zh") == false) goto L5;
    L14:
        return true;
    L5:
        if (TextUtils.equals(r0, "zho") == true) goto L14;
        if (TextUtils.equals(r0, "chi") == true) goto L14;
        if (TextUtils.equals(r0, "en") == true) goto L14;
        if (TextUtils.equals(r0, "eng") == true) goto L14;
        return false;
    }

    public static boolean c() {
        f197a.clear();     // Catch: Throwable -> L55
        k2 r0 = (k2) mg.a(TMSDKContext.getApplicaionContext(), UpdateConfig.MULTI_LANGUAGE_APPGROUP_DESC, UpdateConfig.intToString(42610), new k2(), "UTF-8");     // Catch: Throwable -> L55
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.f299a == null) goto L100;
        int r1 = a() + 3;     // Catch: Throwable -> L55
        Iterator r2 = r0.f299a.iterator();     // Catch: Throwable -> L55
    L9:
        if (r2.hasNext() == false) goto L23;
        j2 r3 = (j2) r2.next();     // Catch: Throwable -> L55
        if (r3 == null) goto L9;
        if (TextUtils.equals(r3.f281a, String.valueOf(100)) == false) goto L9;
        if (TextUtils.isEmpty(r3.b) == true) goto L9;
        if (TextUtils.isEmpty(r3.c) == true) goto L9;
        if (TextUtils.isEmpty(r3.d) == true) goto L9;
        f197a.setProperty(r3.b, a(r3, r1));     // Catch: Throwable -> L55
        goto L9
    L23:
        if (b() == true) goto L58;
        String r4 = h8.d().e().toLowerCase();     // Catch: Throwable -> L55
        String r5 = h8.d().b().toLowerCase();     // Catch: Throwable -> L55
        String r6 = h8.d().f().toLowerCase();     // Catch: Throwable -> L55
        Iterator r7 = r0.f299a.iterator();     // Catch: Throwable -> L55
    L25:
        if (r7.hasNext() == false) goto L58;
        j2 r8 = (j2) r7.next();     // Catch: Throwable -> L55
        if (r8 == null) goto L25;
        if (TextUtils.equals(r8.f281a, String.valueOf(110)) == false) goto L25;
        if (TextUtils.isEmpty(r8.b) == true) goto L25;
        if (TextUtils.isEmpty(r8.c) == true) goto L25;
        if (TextUtils.isEmpty(r8.f) == true) goto L25;
        if (Pattern.compile(r8.f.toLowerCase()).matcher(r4).matches() == false) goto L25;
        String r9 = r8.g.toLowerCase();     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r9) == true) goto L46;
        if (Pattern.compile(r9).matcher(r5).matches() == false) goto L25;
    L46:
        String r10 = r8.h.toLowerCase();     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r10) == true) goto L51;
        if (Pattern.compile(r10).matcher(r6).matches() == false) goto L25;
    L51:
        f197a.setProperty(r8.b, r8.c);     // Catch: Throwable -> L55
    L58:
        return !f197a.isEmpty();
    L100:
        return false;
    L55:
        th = move-exception;
        q8.b("LangResUtil", th);
        goto L58
    }

    public static int a() {
        String r0 = h8.d().e().toLowerCase();
        String r1 = h8.d().f().toLowerCase();
        if (TextUtils.equals(r0, "zh") == false) goto L5;
    L28:
        String r2 = h8.d().b().toLowerCase();
        if (TextUtils.equals(r1, "hans") == false) goto L32;
        return 1;
    L32:
        if (TextUtils.equals(r1, "hant") == false) goto L41;
        if (TextUtils.equals(r2, "tw") == false) goto L36;
    L39:
        return 3;
    L36:
        if (TextUtils.equals(r2, "twn") == true) goto L39;
        return 2;
    L41:
        if (TextUtils.equals(r2, "tw") == false) goto L43;
    L59:
        return 3;
    L43:
        if (TextUtils.equals(r2, "twn") == true) goto L59;
        if (TextUtils.equals(r2, "hk") == false) goto L48;
    L58:
        return 2;
    L48:
        if (TextUtils.equals(r2, "hkg") == true) goto L58;
        if (TextUtils.equals(r2, "mo") == true) goto L58;
        if (TextUtils.equals(r2, "mac") == true) goto L58;
        if (TextUtils.equals(r2, "cn") == true) goto L57;
        TextUtils.equals(r2, "chn");
    L57:
        return 1;
    L5:
        if (TextUtils.equals(r0, "zho") == true) goto L28;
        if (TextUtils.equals(r0, "chi") == true) goto L28;
        if (TextUtils.equals(r0, "bo") == false) goto L12;
        return 4;
    L12:
        if (TextUtils.equals(r0, "bod") == false) goto L15;
        return 4;
    L15:
        if (TextUtils.equals(r0, "ug") == false) goto L17;
        return 5;
    L17:
        if (TextUtils.equals(r0, "uig") == false) goto L20;
        return 5;
    L20:
        if (TextUtils.equals(r0, "en") == true) goto L60;
        TextUtils.equals(r0, "eng");
        return 0;
    L60:
        return 0;
    }
}
