package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ListViewCompat {
    private ListViewCompat() {
    }

    public static boolean canScrollList(@NonNull ListView r0, int r1) {
        return r0.canScrollList(r1);
    }

    public static void scrollListBy(@NonNull ListView r0, int r1) {
        r0.scrollListBy(r1);
    }
}
