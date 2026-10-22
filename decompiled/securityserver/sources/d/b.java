package d;

import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static String a(Object r1, String r2) {
        return r2 + r1;
    }

    public static void b(String r1, int r2, float r3) {
        Resources r0 = Resources.getSystem();
        Intrinsics.e(r0, r1);
        MathKt.a(TypedValue.applyDimension(r2, r3, r0.getDisplayMetrics()));
    }
}
