package d.b.b.o;

import android.os.Build;
import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
public class j {
    public static void a(String r2) {
        if (a.d() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 18) goto L9;
        Trace.beginSection(r2);
        return;
    }

    public static void b() {
        if (a.d() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 18) goto L9;
        Trace.endSection();
        return;
    }
}
