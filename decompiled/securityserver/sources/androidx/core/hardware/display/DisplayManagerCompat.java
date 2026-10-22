package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = null;
    private final Context mContext;

    static {
        sInstances = new WeakHashMap();
    }

    private DisplayManagerCompat(Context r1) {
        this.mContext = r1;
    }

    @NonNull
    public static DisplayManagerCompat getInstance(@NonNull Context r2) {
        WeakHashMap<Context, DisplayManagerCompat> r0 = sInstances;
        monitor-enter(r0);
        DisplayManagerCompat r1 = r0.get(r2);     // Catch: Throwable -> L7
        if (r1 != null) goto L9;
        r1 = new DisplayManagerCompat(r2);     // Catch: Throwable -> L7
        r0.put(r2, r1);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Nullable
    public Display getDisplay(int r2) {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplay(r2);
    }

    @NonNull
    public Display[] getDisplays() {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplays();
    }

    @NonNull
    public Display[] getDisplays(@Nullable String r2) {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplays(r2);
    }
}
