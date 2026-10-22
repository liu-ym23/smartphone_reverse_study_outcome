package d.b.s.a.j0;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f14824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f14825b;

    static {
    }

    @Nullable
    public static String a() {
        return f14825b;
    }

    public static void b(String r3) {
        f14824a = r3;
        f14825b = r3 + "_" + UUID.randomUUID().toString().replace("-", "");
    }

    public static void c(String r1) {
        if (TextUtils.equals(f14824a, r1) == true) goto L5;
        return;
    L5:
        f14824a = null;
        f14825b = null;
    }
}
