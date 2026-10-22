package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListPopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class ListPopupWindowCompat {

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static View.OnTouchListener createDragToOpenListener(ListPopupWindow r0, View r1) {
            return r0.createDragToOpenListener(r1);
        }
    }

    private ListPopupWindowCompat() {
    }

    @Nullable
    public static View.OnTouchListener createDragToOpenListener(@NonNull ListPopupWindow r2, @NonNull View r3) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return Api19Impl.createDragToOpenListener(r2, r3);
    }

    @Deprecated
    public static View.OnTouchListener createDragToOpenListener(Object r0, View r1) {
        return createDragToOpenListener((ListPopupWindow) r0, r1);
    }
}
