package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutManagerCompat {
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List<ShortcutInfoChangeListener> sShortcutInfoChangeListeners;
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    /* JADX INFO: renamed from: androidx.core.content.pm.ShortcutManagerCompat$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ IntentSender val$callback;

        AnonymousClass1(IntentSender r1) {
            this.val$callback = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r7, Intent r8) {
            this.val$callback.sendIntent(r7, 0, null, null, null);     // Catch: IntentSender.SendIntentException -> L4
            return;
        }
    }

    private static class Api25Impl {
        private Api25Impl() {
        }

        static String getShortcutInfoWithLowestRank(List<ShortcutInfo> r5) {
            Iterator<ShortcutInfo> r6 = r5.iterator();
            int r0 = -1;
            String r1 = null;
        L4:
            if (r6.hasNext() == false) goto L8;
            ShortcutInfo r2 = r6.next();
            if (r2.getRank() <= r0) goto L4;
            String r3 = r2.getId();
            r1 = r3;
            r0 = r2.getRank();
            goto L4
        L8:
            return r1;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShortcutMatchFlags {
    }

    static {
    }

    private ShortcutManagerCompat() {
    }

    public static boolean isRequestPinShortcutSupported(Context r1) {
        return ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
    }

    public static boolean requestPinShortcut(Context r2, ShortcutInfoCompat r3, IntentSender r4) {
        if (Build.VERSION.SDK_INT > 31) goto L9;
        if (r3.isExcludedFromSurfaces(1) == false) goto L9;
        return false;
    L9:
        return ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).requestPinShortcut(r3.toShortcutInfo(), r4);
    }

    public static Intent createShortcutResultIntent(Context r1, ShortcutInfoCompat r2) {
        Intent r3 = ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).createShortcutResultIntent(r2.toShortcutInfo());
        if (r3 != null) goto L6;
        r3 = new Intent();
    L6:
        return r2.addToIntent(r3);
    }

    public static List<ShortcutInfoCompat> getShortcuts(Context r1, int r2) {
        return ShortcutInfoCompat.fromShortcuts(r1, ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).getShortcuts(r2));
    }

    public static boolean addDynamicShortcuts(Context r5, List<ShortcutInfoCompat> r6) {
        List<ShortcutInfoCompat> r1 = removeShortcutsExcludedFromSurface(r6, 1);
        ArrayList r2 = new ArrayList();
        Iterator<ShortcutInfoCompat> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r2.add(r3.next().toShortcutInfo());
        goto L4
    L7:
        if (((ShortcutManager) r5.getSystemService(ShortcutManager.class)).addDynamicShortcuts(r2) == true) goto L10;
        return false;
    L10:
        getShortcutInfoSaverInstance(r5).addShortcuts(r1);
        Iterator<ShortcutInfoChangeListener> r7 = getShortcutInfoListeners(r5).iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        r7.next().onShortcutAdded(r6);
        goto L12
    L14:
        return true;
    }

    public static int getMaxShortcutCountPerActivity(Context r1) {
        Preconditions.checkNotNull(r1);
        return ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
    }

    public static boolean isRateLimitingActive(Context r1) {
        Preconditions.checkNotNull(r1);
        return ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).isRateLimitingActive();
    }

    public static int getIconMaxWidth(Context r1) {
        Preconditions.checkNotNull(r1);
        return ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).getIconMaxWidth();
    }

    public static int getIconMaxHeight(Context r1) {
        Preconditions.checkNotNull(r1);
        return ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).getIconMaxHeight();
    }

    public static void reportShortcutUsed(Context r2, String r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).reportShortcutUsed(r3);
        Iterator<ShortcutInfoChangeListener> r4 = getShortcutInfoListeners(r2).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.next().onShortcutUsageReported(Collections.singletonList(r3));
        goto L4
    }

    public static boolean setDynamicShortcuts(Context r5, List<ShortcutInfoCompat> r6) {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        List<ShortcutInfoCompat> r1 = removeShortcutsExcludedFromSurface(r6, 1);
        ArrayList r2 = new ArrayList(r1.size());
        Iterator<ShortcutInfoCompat> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r2.add(r3.next().toShortcutInfo());
        goto L4
    L7:
        if (((ShortcutManager) r5.getSystemService(ShortcutManager.class)).setDynamicShortcuts(r2) == true) goto L10;
        return false;
    L10:
        getShortcutInfoSaverInstance(r5).removeAllShortcuts();
        getShortcutInfoSaverInstance(r5).addShortcuts(r1);
        Iterator<ShortcutInfoChangeListener> r7 = getShortcutInfoListeners(r5).iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        ShortcutInfoChangeListener r4 = r7.next();
        r4.onAllShortcutsRemoved();
        r4.onShortcutAdded(r6);
        goto L12
    L14:
        return true;
    }

    public static List<ShortcutInfoCompat> getDynamicShortcuts(Context r4) {
        List<ShortcutInfo> r0 = ((ShortcutManager) r4.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<ShortcutInfo> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(new ShortcutInfoCompat.Builder(r4, r2.next()).build());
        goto L4
    L6:
        return r1;
    }

    public static boolean updateShortcuts(Context r5, List<ShortcutInfoCompat> r6) {
        List<ShortcutInfoCompat> r1 = removeShortcutsExcludedFromSurface(r6, 1);
        ArrayList r2 = new ArrayList();
        Iterator<ShortcutInfoCompat> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r2.add(r3.next().toShortcutInfo());
        goto L4
    L7:
        if (((ShortcutManager) r5.getSystemService(ShortcutManager.class)).updateShortcuts(r2) == true) goto L10;
        return false;
    L10:
        getShortcutInfoSaverInstance(r5).addShortcuts(r1);
        Iterator<ShortcutInfoChangeListener> r7 = getShortcutInfoListeners(r5).iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        r7.next().onShortcutUpdated(r6);
        goto L12
    L14:
        return true;
    }

    static boolean convertUriIconToBitmapIcon(Context r5, ShortcutInfoCompat r6) {
        if (r6.mIcon != null) goto L5;
        return false;
    L5:
        int r0 = r6.mIcon.mType;
        if (r0 != 6) goto L8;
    L10:
        InputStream r7 = r6.mIcon.getUriInputStream(r5);
        if (r7 != null) goto L13;
        return false;
    L13:
        Bitmap r8 = BitmapFactory.decodeStream(r7);
        if (r8 != null) goto L16;
        return false;
    L16:
        if (r0 != 6) goto L18;
        IconCompat r9 = IconCompat.createWithAdaptiveBitmap(r8);
    L19:
        r6.mIcon = r9;
        return true;
    L18:
        r9 = IconCompat.createWithBitmap(r8);
        goto L19
    L8:
        if (r0 == 4) goto L10;
        return true;
    }

    static void convertUriIconsToBitmapIcons(Context r3, List<ShortcutInfoCompat> r4) {
        Iterator r0 = new ArrayList(r4).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ShortcutInfoCompat r1 = (ShortcutInfoCompat) r0.next();
        if (convertUriIconToBitmapIcon(r3, r1) == true) goto L4;
        r4.remove(r1);
        goto L4
    }

    public static void disableShortcuts(Context r1, List<String> r2, CharSequence r3) {
        ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).disableShortcuts(r2, r3);
        getShortcutInfoSaverInstance(r1).removeShortcuts(r2);
        Iterator<ShortcutInfoChangeListener> r4 = getShortcutInfoListeners(r1).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.next().onShortcutRemoved(r2);
        goto L4
    }

    public static void enableShortcuts(Context r4, List<ShortcutInfoCompat> r5) {
        List<ShortcutInfoCompat> r0 = removeShortcutsExcludedFromSurface(r5, 1);
        ArrayList r1 = new ArrayList(r5.size());
        Iterator<ShortcutInfoCompat> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(r2.next().mId);
        goto L4
    L6:
        ((ShortcutManager) r4.getSystemService(ShortcutManager.class)).enableShortcuts(r1);
        getShortcutInfoSaverInstance(r4).addShortcuts(r0);
        Iterator<ShortcutInfoChangeListener> r6 = getShortcutInfoListeners(r4).iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r6.next().onShortcutAdded(r5);
        goto L8
    }

    public static void removeDynamicShortcuts(Context r1, List<String> r2) {
        ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(r2);
        getShortcutInfoSaverInstance(r1).removeShortcuts(r2);
        Iterator<ShortcutInfoChangeListener> r3 = getShortcutInfoListeners(r1).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().onShortcutRemoved(r2);
        goto L4
    }

    public static void removeAllDynamicShortcuts(Context r1) {
        ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        getShortcutInfoSaverInstance(r1).removeAllShortcuts();
        Iterator<ShortcutInfoChangeListener> r2 = getShortcutInfoListeners(r1).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().onAllShortcutsRemoved();
        goto L4
    }

    public static void removeLongLivedShortcuts(Context r1, List<String> r2) {
        ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(r2);
        getShortcutInfoSaverInstance(r1).removeShortcuts(r2);
        Iterator<ShortcutInfoChangeListener> r3 = getShortcutInfoListeners(r1).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().onShortcutRemoved(r2);
        goto L4
    }

    public static boolean pushDynamicShortcut(Context r6, ShortcutInfoCompat r7) {
        Preconditions.checkNotNull(r6);
        Preconditions.checkNotNull(r7);
        if (Build.VERSION.SDK_INT <= 31) goto L5;
    L11:
        int r0 = getMaxShortcutCountPerActivity(r6);
        if (r0 != 0) goto L14;
        return false;
    L14:
        ((ShortcutManager) r6.getSystemService(ShortcutManager.class)).pushDynamicShortcut(r7.toShortcutInfo());
        ShortcutInfoCompatSaver<?> r3 = getShortcutInfoSaverInstance(r6);
        List<ShortcutInfoCompat> r4 = r3.getShortcuts();     // Catch: Throwable -> L25 Exception -> L32
        if (r4.size() < r0) goto L18;
        r3.removeShortcuts(Arrays.asList(new String[]{getShortcutInfoCompatWithLowestRank(r4)}));     // Catch: Throwable -> L25 Exception -> L32
    L18:
        r3.addShortcuts(Arrays.asList(new ShortcutInfoCompat[]{r7}));     // Catch: Throwable -> L25 Exception -> L32
        Iterator<ShortcutInfoChangeListener> r1 = getShortcutInfoListeners(r6).iterator();
    L21:
        if (r1.hasNext() == false) goto L23;
        r1.next().onShortcutAdded(Collections.singletonList(r7));
        goto L21
    L23:
        reportShortcutUsed(r6, r7.getId());
        return true;
    L32:
        Iterator<ShortcutInfoChangeListener> r2 = getShortcutInfoListeners(r6).iterator();
    L34:
        if (r2.hasNext() == false) goto L36;
        r2.next().onShortcutAdded(Collections.singletonList(r7));
        goto L34
    L36:
        reportShortcutUsed(r6, r7.getId());
        return false;
    L25:
        th = move-exception;
        Iterator<ShortcutInfoChangeListener> r5 = getShortcutInfoListeners(r6).iterator();
    L28:
        if (r5.hasNext() == false) goto L30;
        r5.next().onShortcutAdded(Collections.singletonList(r7));
        goto L28
    L30:
        reportShortcutUsed(r6, r7.getId());
        throw th;
    L5:
        if (r7.isExcludedFromSurfaces(1) == false) goto L11;
        Iterator<ShortcutInfoChangeListener> r8 = getShortcutInfoListeners(r6).iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        r8.next().onShortcutAdded(Collections.singletonList(r7));
        goto L8
    L10:
        return true;
    }

    private static String getShortcutInfoCompatWithLowestRank(List<ShortcutInfoCompat> r5) {
        Iterator<ShortcutInfoCompat> r6 = r5.iterator();
        int r0 = -1;
        String r1 = null;
    L4:
        if (r6.hasNext() == false) goto L8;
        ShortcutInfoCompat r2 = r6.next();
        if (r2.getRank() <= r0) goto L4;
        String r3 = r2.getId();
        r1 = r3;
        r0 = r2.getRank();
        goto L4
    L8:
        return r1;
    }

    static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> r0) {
        sShortcutInfoCompatSaver = r0;
    }

    static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> r0) {
        sShortcutInfoChangeListeners = r0;
    }

    static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return sShortcutInfoChangeListeners;
    }

    private static int getIconDimensionInternal(Context r2, boolean r3) {
        ActivityManager r0 = (ActivityManager) r2.getSystemService("activity");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        int r4 = 48;
    L12:
        int r5 = Math.max(1, r4);
        DisplayMetrics r6 = r2.getResources().getDisplayMetrics();
        if (r3 == false) goto L15;
        float r7 = r6.xdpi;
    L17:
        return (int) (r5 * (r7 / 160.0f));
    L15:
        r7 = r6.ydpi;
        goto L17
    L11:
        r4 = 96;
        goto L12
    L5:
        if (r0.isLowRamDevice() == true) goto L8;
        r1 = false;
        goto L9
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context r6) {
        if (sShortcutInfoCompatSaver != null) goto L9;
        sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r6});     // Catch: Exception -> L10
    L6:
        if (sShortcutInfoCompatSaver != null) goto L9;
        sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
    L9:
        return sShortcutInfoCompatSaver;
    }

    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context r8) {
        if (sShortcutInfoChangeListeners != null) goto L22;
        ArrayList r0 = new ArrayList();
        PackageManager r1 = r8.getPackageManager();
        Intent r2 = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
        r2.setPackage(r8.getPackageName());
        Iterator<ResolveInfo> r3 = r1.queryIntentActivities(r2, 128).iterator();
    L6:
        if (r3.hasNext() == false) goto L19;
        ActivityInfo r4 = r3.next().activityInfo;
        if (r4 == null) goto L6;
        Bundle r5 = r4.metaData;
        if (r5 == null) goto L6;
        String r6 = r5.getString(SHORTCUT_LISTENER_META_DATA_KEY);
        if (r6 == null) goto L6;
        r0.add((ShortcutInfoChangeListener) Class.forName(r6, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r8}));     // Catch: Exception -> L23
        goto L6
    L19:
        if (sShortcutInfoChangeListeners != null) goto L22;
        sShortcutInfoChangeListeners = r0;
    L22:
        return sShortcutInfoChangeListeners;
    }

    private static List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface(List<ShortcutInfoCompat> r3, int r4) {
        Objects.requireNonNull(r3);
        if (Build.VERSION.SDK_INT <= 31) goto L5;
        return r3;
    L5:
        ArrayList r0 = new ArrayList(r3);
        Iterator<ShortcutInfoCompat> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        ShortcutInfoCompat r1 = r5.next();
        if (r1.isExcludedFromSurfaces(r4) == false) goto L7;
        r0.remove(r1);
        goto L7
    L11:
        return r0;
    }
}
