package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    public static final class ModeCompat {
        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalDisplaySize;

        public ModeCompat(@NonNull Point r2) {
            Preconditions.checkNotNull(r2, "physicalDisplaySize == null");
            this.mIsNative = true;
            this.mPhysicalDisplaySize = r2;
            this.mMode = null;
        }

        public int getPhysicalHeight() {
            return this.mPhysicalDisplaySize.y;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalDisplaySize.x;
        }

        public boolean isNative() {
            return this.mIsNative;
        }

        @Nullable
        @RequiresApi(23)
        public Display.Mode toMode() {
            return this.mMode;
        }

        @RequiresApi(23)
        public ModeCompat(@NonNull Display.Mode r3, boolean r4) {
            Preconditions.checkNotNull(r3, "Display.Mode == null, can't wrap a null reference");
            this.mIsNative = r4;
            this.mPhysicalDisplaySize = new Point(r3.getPhysicalWidth(), r3.getPhysicalHeight());
            this.mMode = r3;
        }
    }

    private DisplayCompat() {
    }

    private static Point getPhysicalDisplaySize(@NonNull Context r1, @NonNull Display r2) {
        Point r0 = parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (isSonyBravia4kTv(r1) == true) goto L8;
        Point r3 = new Point();
        Display.Mode r4 = r2.getMode();
        r3.x = r4.getPhysicalWidth();
        r3.y = r4.getPhysicalHeight();
        return r3;
    L8:
        return new Point(DISPLAY_SIZE_4K_WIDTH, DISPLAY_SIZE_4K_HEIGHT);
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static ModeCompat[] getSupportedModes(@NonNull Context r6, @NonNull Display r7) {
        Point r8 = getPhysicalDisplaySize(r6, r7);
        Display.Mode[] r9 = r7.getSupportedModes();
        ArrayList r0 = new ArrayList(r9.length);
        int r2 = 0;
        boolean r3 = false;
    L4:
        if (r2 >= r9.length) goto L10;
        if (physicalSizeEquals(r9[r2], r8) == false) goto L8;
        r0.add(r2, new ModeCompat(r9[r2], true));
        r3 = true;
    L9:
        r2 = r2 + 1;
        goto L4
    L8:
        r0.add(r2, new ModeCompat(r9[r2], false));
        goto L9
    L10:
        if (r3 == true) goto L13;
        r0.add(new ModeCompat(r8));
    L13:
        return (ModeCompat[]) r0.toArray(new ModeCompat[0]);
    }

    @Nullable
    private static String getSystemProperty(String r3) {
        Class<?> r0 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L4
        return (String) r0.getMethod("get", new Class[]{String.class}).invoke(r0, new Object[]{r3});
    L4:
        return null;
    }

    private static boolean isSonyBravia4kTv(@NonNull Context r2) {
        if (isTv(r2) == true) goto L5;
    L11:
        return false;
    L5:
        if ("Sony".equals(Build.MANUFACTURER) == false) goto L11;
        if (Build.MODEL.startsWith("BRAVIA") == false) goto L11;
        if (r2.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd") == false) goto L11;
        return true;
    }

    private static boolean isTv(@NonNull Context r1) {
        UiModeManager r2 = (UiModeManager) r1.getSystemService("uimode");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getCurrentModeType() != 4) goto L7;
        return true;
    }

    private static Point parseDisplaySize(@NonNull String r2) {
        String[] r3 = r2.trim().split("x", -1);
        if (r3.length != 2) goto L10;
        int r0 = Integer.parseInt(r3[0]);
        int r4 = Integer.parseInt(r3[1]);
        if (r0 <= 0) goto L10;
        if (r4 <= 0) goto L10;
        return new Point(r0, r4);
    L10:
        throw new NumberFormatException();
    }

    @Nullable
    private static Point parsePhysicalDisplaySizeFromSystemProperties(@NonNull String r0, @NonNull Display r1) {
        if (r1.getDisplayId() != 0) goto L8;
        String r2 = getSystemProperty(r0);
        if (TextUtils.isEmpty(r2) == true) goto L13;
        return parseDisplaySize(r2);
    L14:
        return null;
    L13:
        return null;
    L8:
        return null;
    }

    @RequiresApi(23)
    private static boolean physicalSizeEquals(Display.Mode r2, Point r3) {
        if (r2.getPhysicalWidth() != r3.x) goto L7;
        if (r2.getPhysicalHeight() != r3.y) goto L7;
    L10:
        return true;
    L7:
        if (r2.getPhysicalWidth() == r3.y) goto L9;
    L11:
        return false;
    L9:
        if (r2.getPhysicalHeight() != r3.x) goto L11;
        goto L10
    }
}
