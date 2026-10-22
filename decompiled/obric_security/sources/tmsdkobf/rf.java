package tmsdkobf;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public final class rf implements Serializable {
    private static rf[] c = null;
    public static final rf d = null;
    public static final rf e = null;
    public static final rf f = null;
    public static final rf g = null;
    public static final rf h = null;
    public static final rf i = null;
    public static final rf j = null;
    public static final rf k = null;
    public static final rf l = null;
    public static final rf m = null;
    public static final rf n = null;
    public static final rf o = null;
    public static final rf p = null;
    public static final rf q = null;
    public static final rf r = null;
    public static final rf s = null;
    public static final rf t = null;
    static final /* synthetic */ boolean u = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f480a;
    private String b;

    static {
        c = new rf[17];
        d = new rf(0, 0, "CHECK_REGULAR");
        e = new rf(1, 1, "CHECK_COCKHORSE");
        f = new rf(2, 2, "CHECK_DEFAULT_CHEAT");
        g = new rf(3, 3, "CHECK_MONEY_CHEAT");
        h = new rf(4, 4, "CHECK_SP_SERVICE");
        i = new rf(5, 5, "CHECK_STEAL_ACCOUNT");
        j = new rf(6, 6, "CHECK_TIPS_CHEAT");
        k = new rf(7, 7, "CHECK_TIPS_DEFAULT");
        l = new rf(8, 8, "CHECK_GAMES_HANG");
        m = new rf(9, 9, "CHECK_MAKE_MONEY");
        n = new rf(10, 10, "CHECK_SEX");
        o = new rf(11, 11, "CHECK_PRIVATE_SERVER");
        p = new rf(12, 12, "CHECK_MSG_REACTIONARY");
        q = new rf(13, 13, "CHECK_MSG_WHITE");
        r = new rf(14, 18, "CHECK_MSG_SHADINESS");
        s = new rf(15, 19, "CHECK_MSG_BLOG");
        t = new rf(16, 20, "CHECK_MAX");
    }

    private rf(int r2, int r3, String r4) {
        new String();
        this.b = r4;
        this.f480a = r3;
        c[r2] = this;
    }

    public int a() {
        return this.f480a;
    }

    public String toString() {
        return this.b;
    }
}
