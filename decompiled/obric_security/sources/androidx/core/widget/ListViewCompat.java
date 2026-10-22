package androidx.core.widget;

import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public final class ListViewCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static void scrollListBy(ListView r0, int r1) {
            r0.scrollListBy(r1);
        }

        static boolean canScrollList(ListView r0, int r1) {
            return r0.canScrollList(r1);
        }
    }

    public static void scrollListBy(ListView r0, int r1) {
        Api19Impl.scrollListBy(r0, r1);
    }

    public static boolean canScrollList(ListView r0, int r1) {
        return Api19Impl.canScrollList(r0, r1);
    }

    private ListViewCompat() {
    }
}
