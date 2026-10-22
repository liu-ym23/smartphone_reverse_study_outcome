package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: loaded from: classes.dex */
public final class MenuCompat {

    static class Api28Impl {
        private Api28Impl() {
        }

        static void setGroupDividerEnabled(Menu r0, boolean r1) {
            r0.setGroupDividerEnabled(r1);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem r0, int r1) {
        r0.setShowAsAction(r1);
    }

    public static void setGroupDividerEnabled(Menu r1, boolean r2) {
        if ((r1 instanceof SupportMenu) == false) goto L5;
        ((SupportMenu) r1).setGroupDividerEnabled(r2);
        return;
    L5:
        Api28Impl.setGroupDividerEnabled(r1, r2);
    }

    private MenuCompat() {
    }
}
