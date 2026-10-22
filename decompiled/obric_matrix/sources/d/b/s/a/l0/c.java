package d.b.s.a.l0;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a() {
        d.b.s.a.a0.a.d("AccountReflectUtils", "addTokenInterceptor start");     // Catch: Exception -> L5
        Class.forName("com.ss.android.account.token.TTTokenUtils").getMethod("addTokenInterceptor", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L5
        d.b.s.a.a0.a.d("AccountReflectUtils", "addTokenInterceptor success");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.b.s.a.a0.a.c("AccountReflectUtils", "addTokenInterceptor failed", e);
    }
}
