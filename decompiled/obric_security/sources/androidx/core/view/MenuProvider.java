package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public interface MenuProvider {
    void onCreateMenu(Menu r1, MenuInflater r2);

    default void onMenuClosed(Menu r1) {
    }

    boolean onMenuItemSelected(MenuItem r1);

    default void onPrepareMenu(Menu r1) {
    }
}
