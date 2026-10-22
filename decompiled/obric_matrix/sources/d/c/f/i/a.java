package d.c.f.i;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d.c.f.i.a$a, reason: collision with other inner class name */
    public static class C0423a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15720b;
    }

    private static boolean a(int r1) {
        if (r1 != 0) goto L4;
    L7:
        return true;
    L4:
        if (r1 == (-2)) goto L7;
        return false;
    }

    public static void b(C0423a r2, float r3, ViewGroup.LayoutParams r4, int r5, int r6) {
        if (r3 <= 0.0f) goto L13;
        if (r4 != null) goto L7;
        return;
    L7:
        if (a(r4.height) == false) goto L10;
        r2.f15720b = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(r2.f15719a) - r5) / r3) + r6), r2.f15720b), BasicMeasure.EXACTLY);
        return;
    L10:
        if (a(r4.width) == false) goto L15;
        r2.f15719a = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(r2.f15720b) - r6) * r3) + r5), r2.f15719a), BasicMeasure.EXACTLY);
        return;
    L15:
        return;
    }
}
