package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface MenuProvider {
    void onCreateMenu(@NonNull Menu r1, @NonNull MenuInflater r2);

    default void onMenuClosed(@NonNull Menu r1) {
    }

    boolean onMenuItemSelected(@NonNull MenuItem r1);

    default void onPrepareMenu(@NonNull Menu r1) {
    }
}
