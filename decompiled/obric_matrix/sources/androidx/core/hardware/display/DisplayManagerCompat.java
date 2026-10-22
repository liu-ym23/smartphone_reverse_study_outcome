package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = null;
    private final Context mContext;

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static Display getDisplay(DisplayManager r0, int r1) {
            return r0.getDisplay(r1);
        }

        @DoNotInline
        static Display[] getDisplays(DisplayManager r0) {
            return r0.getDisplays();
        }
    }

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
        DisplayManagerCompat r1 = r0.get(r2);     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
        r1 = new DisplayManagerCompat(r2);     // Catch: Throwable -> L9
        r0.put(r2, r1);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    @Nullable
    public Display getDisplay(int r3) {
        int r0 = Build.VERSION.SDK_INT;
        Context r2 = this.mContext;
        if (r0 >= 17) goto L5;
        Display r4 = ((WindowManager) r2.getSystemService("window")).getDefaultDisplay();
        if (r4.getDisplayId() != r3) goto L9;
        return r4;
    L9:
        return null;
    L5:
        return Api17Impl.getDisplay((DisplayManager) r2.getSystemService("display"), r3);
    }

    @NonNull
    public Display[] getDisplays() {
        int r0 = Build.VERSION.SDK_INT;
        Context r2 = this.mContext;
        if (r0 < 17) goto L7;
        return Api17Impl.getDisplays((DisplayManager) r2.getSystemService("display"));
    L7:
        return new Display[]{((WindowManager) r2.getSystemService("window")).getDefaultDisplay()};
    }

    @NonNull
    public Display[] getDisplays(@Nullable String r3) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getDisplays((DisplayManager) this.mContext.getSystemService("display"));
    L7:
        if (r3 != null) goto L11;
        return new Display[0];
    L11:
        return new Display[]{((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay()};
    }
}
