package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: loaded from: classes.dex */
public final class MenuCompat {
    private MenuCompat() {
    }

    @SuppressLint({"NewApi"})
    public static void setGroupDividerEnabled(Menu r1, boolean r2) {
        if ((r1 instanceof SupportMenu) == false) goto L5;
        ((SupportMenu) r1).setGroupDividerEnabled(r2);
        return;
    L5:
        r1.setGroupDividerEnabled(r2);
    }

    @Deprecated
    public static void setShowAsAction(MenuItem r0, int r1) {
        r0.setShowAsAction(r1);
    }
}
