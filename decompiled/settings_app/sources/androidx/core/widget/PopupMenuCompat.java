package androidx.core.widget;

import android.view.View;
import android.widget.PopupMenu;

/* JADX INFO: loaded from: classes.dex */
public final class PopupMenuCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static View.OnTouchListener getDragToOpenListener(PopupMenu r0) {
            return r0.getDragToOpenListener();
        }
    }

    private PopupMenuCompat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object r0) {
        return Api19Impl.getDragToOpenListener((PopupMenu) r0);
    }
}
