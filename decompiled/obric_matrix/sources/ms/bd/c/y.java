package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.system.Os;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    public interface a {
    }

    public interface b {
    }

    public interface c {
        void a();

        void a(Throwable r1);
    }

    public static void a(Context r3, String r4) {
        if (Build.VERSION.SDK_INT >= 21) goto L8;
    L5:
        new z(new b0(), new w()).c(r3, r4, null, null);
        return;
    L8:
        Os.setenv("28d7fdd567361198183fa7b8e", "a7", true);     // Catch: Exception -> L7
        goto L5
    }

    public static boolean b(CharSequence r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }
}
