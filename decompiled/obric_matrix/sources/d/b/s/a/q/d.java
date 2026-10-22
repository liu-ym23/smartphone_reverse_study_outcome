package d.b.s.a.q;

import com.ss.android.i.j;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static String a() {
        return e("/passport/mobile/check_code/");
    }

    protected static String b() {
        return j.k().c();
    }

    public static String c() {
        return e("/passport/account/info/v2/");
    }

    public static String d() {
        return e("/passport/password/reset_by_ticket/");
    }

    public static String e(String r2) {
        return "https://" + b() + r2;
    }

    public static String f() {
        return e("/passport/user/logout/");
    }

    public static String g() {
        return e("/passport/user/login/");
    }
}
