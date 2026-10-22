package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: loaded from: classes.dex */
public final class MenuCompat {

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static void setGroupDividerEnabled(Menu r0, boolean r1) {
            r0.setGroupDividerEnabled(r1);
        }
    }

    private MenuCompat() {
    }

    public static void setGroupDividerEnabled(@NonNull Menu r2, boolean r3) {
        if ((r2 instanceof SupportMenu) == false) goto L6;
        ((SupportMenu) r2).setGroupDividerEnabled(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        Api28Impl.setGroupDividerEnabled(r2, r3);
        return;
    }

    @Deprecated
    public static void setShowAsAction(MenuItem r0, int r1) {
        r0.setShowAsAction(r1);
    }
}
