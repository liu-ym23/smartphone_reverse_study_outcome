package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class ListViewCompat {

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static boolean canScrollList(ListView r0, int r1) {
            return r0.canScrollList(r1);
        }

        @DoNotInline
        static void scrollListBy(ListView r0, int r1) {
            r0.scrollListBy(r1);
        }
    }

    private ListViewCompat() {
    }

    public static boolean canScrollList(@NonNull ListView r4, int r5) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        int r0 = r4.getChildCount();
        if (r0 != 0) goto L9;
        return false;
    L9:
        int r2 = r4.getFirstVisiblePosition();
        if (r5 <= 0) goto L17;
        int r6 = r4.getChildAt(r0 - 1).getBottom();
        if ((r2 + r0) < r4.getCount()) goto L16;
        if (r6 > (r4.getHeight() - r4.getListPaddingBottom())) goto L16;
        return false;
    L16:
        return true;
    L17:
        int r7 = r4.getChildAt(0).getTop();
        if (r2 > 0) goto L22;
        if (r7 < r4.getListPaddingTop()) goto L22;
        return false;
    L22:
        return true;
    L5:
        return Api19Impl.canScrollList(r4, r5);
    }

    public static void scrollListBy(@NonNull ListView r2, int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        Api19Impl.scrollListBy(r2, r3);
        return;
    L5:
        int r0 = r2.getFirstVisiblePosition();
        if (r0 != (-1)) goto L8;
        return;
    L8:
        View r1 = r2.getChildAt(0);
        if (r1 != null) goto L11;
        return;
    L11:
        r2.setSelectionFromTop(r0, r1.getTop() - r3);
    }
}
