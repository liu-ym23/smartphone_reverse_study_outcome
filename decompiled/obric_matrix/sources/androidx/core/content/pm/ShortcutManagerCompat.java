package androidx.core.content.pm;

import android.app.ActivityManager;
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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
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

    @VisibleForTesting
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;

    @VisibleForTesting
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List<ShortcutInfoChangeListener> sShortcutInfoChangeListeners;
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    @RequiresApi(25)
    private static class Api25Impl {
        private Api25Impl() {
        }

        static String getShortcutInfoWithLowestRank(@NonNull List<ShortcutInfo> r5) {
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
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ShortcutMatchFlags {
    }

    static {
    }

    private ShortcutManagerCompat() {
    }

    public static boolean addDynamicShortcuts(@NonNull Context r5, @NonNull List<ShortcutInfoCompat> r6) {
        List<ShortcutInfoCompat> r1 = removeShortcutsExcludedFromSurface(r6, 1);
        int r2 = Build.VERSION.SDK_INT;
        if (r2 > 29) goto L6;
        convertUriIconsToBitmapIcons(r5, r1);
    L6:
        if (r2 < 25) goto L15;
        ArrayList r3 = new ArrayList();
        Iterator<ShortcutInfoCompat> r4 = r1.iterator();
    L9:
        if (r4.hasNext() == false) goto L12;
        r3.add(r4.next().toShortcutInfo());
        goto L9
    L12:
        if (((ShortcutManager) r5.getSystemService(ShortcutManager.class)).addDynamicShortcuts(r3) == true) goto L15;
        return false;
    L15:
        getShortcutInfoSaverInstance(r5).addShortcuts(r1);
        Iterator<ShortcutInfoChangeListener> r7 = getShortcutInfoListeners(r5).iterator();
    L17:
        if (r7.hasNext() == false) goto L19;
        r7.next().onShortcutAdded(r6);
        goto L17
    L19:
        return true;
    }

    @VisibleForTesting
    static boolean convertUriIconToBitmapIcon(@NonNull Context r6, @NonNull ShortcutInfoCompat r7) {
        IconCompat r0 = r7.mIcon;
        if (r0 != null) goto L5;
        return false;
    L5:
        int r2 = r0.mType;
        if (r2 != 6) goto L8;
    L10:
        InputStream r8 = r0.getUriInputStream(r6);
        if (r8 != null) goto L13;
        return false;
    L13:
        Bitmap r9 = BitmapFactory.decodeStream(r8);
        if (r9 != null) goto L16;
        return false;
    L16:
        if (r2 != 6) goto L18;
        IconCompat r10 = IconCompat.createWithAdaptiveBitmap(r9);
    L19:
        r7.mIcon = r10;
        return true;
    L18:
        r10 = IconCompat.createWithBitmap(r9);
        goto L19
    L8:
        if (r2 == 4) goto L10;
        return true;
    }

    @VisibleForTesting
    static void convertUriIconsToBitmapIcons(@NonNull Context r3, @NonNull List<ShortcutInfoCompat> r4) {
        Iterator r0 = new ArrayList(r4).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ShortcutInfoCompat r1 = (ShortcutInfoCompat) r0.next();
        if (convertUriIconToBitmapIcon(r3, r1) == true) goto L4;
        r4.remove(r1);
        goto L4
    }

    @NonNull
    public static Intent createShortcutResultIntent(@NonNull Context r2, @NonNull ShortcutInfoCompat r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Intent r4 = ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).createShortcutResultIntent(r3.toShortcutInfo());
    L6:
        if (r4 != null) goto L9;
        r4 = new Intent();
    L9:
        return r3.addToIntent(r4);
    L5:
        r4 = null;
        goto L6
    }

    public static void disableShortcuts(@NonNull Context r2, @NonNull List<String> r3, @Nullable CharSequence r4) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).disableShortcuts(r3, r4);
    L5:
        getShortcutInfoSaverInstance(r2).removeShortcuts(r3);
        Iterator<ShortcutInfoChangeListener> r5 = getShortcutInfoListeners(r2).iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r5.next().onShortcutRemoved(r3);
        goto L7
    }

    public static void enableShortcuts(@NonNull Context r4, @NonNull List<ShortcutInfoCompat> r5) {
        List<ShortcutInfoCompat> r0 = removeShortcutsExcludedFromSurface(r5, 1);
        if (Build.VERSION.SDK_INT < 25) goto L9;
        ArrayList r1 = new ArrayList(r5.size());
        Iterator<ShortcutInfoCompat> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.add(r2.next().mId);
        goto L6
    L8:
        ((ShortcutManager) r4.getSystemService(ShortcutManager.class)).enableShortcuts(r1);
    L9:
        getShortcutInfoSaverInstance(r4).addShortcuts(r0);
        Iterator<ShortcutInfoChangeListener> r6 = getShortcutInfoListeners(r4).iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        r6.next().onShortcutAdded(r5);
        goto L11
    }

    @NonNull
    public static List<ShortcutInfoCompat> getDynamicShortcuts(@NonNull Context r4) {
        if (Build.VERSION.SDK_INT < 25) goto L13;
        List<ShortcutInfo> r0 = ((ShortcutManager) r4.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<ShortcutInfo> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.add(new ShortcutInfoCompat.Builder(r4, r2.next()).build());
        goto L6
    L8:
        return r1;
    L13:
        return getShortcutInfoSaverInstance(r4).getShortcuts();
    L12:
        return new ArrayList();
    }

    private static int getIconDimensionInternal(@NonNull Context r4, boolean r5) {
        ActivityManager r0 = (ActivityManager) r4.getSystemService("activity");
        if (Build.VERSION.SDK_INT < 19) goto L9;
        if (r0 == null) goto L9;
        if (r0.isLowRamDevice() == true) goto L9;
        boolean r1 = false;
    L10:
        if (r1 == false) goto L12;
        int r2 = 48;
    L13:
        int r3 = Math.max(1, r2);
        DisplayMetrics r6 = r4.getResources().getDisplayMetrics();
        if (r5 == false) goto L16;
        float r7 = r6.xdpi;
    L18:
        return (int) (r3 * (r7 / 160.0f));
    L16:
        r7 = r6.ydpi;
        goto L18
    L12:
        r2 = 96;
    L9:
        r1 = true;
        goto L10
    }

    public static int getIconMaxHeight(@NonNull Context r2) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).getIconMaxHeight();
    L7:
        return getIconDimensionInternal(r2, false);
    }

    public static int getIconMaxWidth(@NonNull Context r2) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).getIconMaxWidth();
    L7:
        return getIconDimensionInternal(r2, true);
    }

    public static int getMaxShortcutCountPerActivity(@NonNull Context r2) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT >= 25) goto L5;
        return 5;
    L5:
        return ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
    }

    @VisibleForTesting
    static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return sShortcutInfoChangeListeners;
    }

    private static String getShortcutInfoCompatWithLowestRank(@NonNull List<ShortcutInfoCompat> r5) {
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

    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context r8) {
        if (sShortcutInfoChangeListeners != null) goto L24;
        ArrayList r0 = new ArrayList();
        if (Build.VERSION.SDK_INT < 21) goto L21;
        PackageManager r1 = r8.getPackageManager();
        Intent r2 = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
        r2.setPackage(r8.getPackageName());
        Iterator<ResolveInfo> r3 = r1.queryIntentActivities(r2, 128).iterator();
    L8:
        if (r3.hasNext() == false) goto L21;
        ActivityInfo r4 = r3.next().activityInfo;
        if (r4 == null) goto L8;
        Bundle r5 = r4.metaData;
        if (r5 == null) goto L8;
        String r6 = r5.getString(SHORTCUT_LISTENER_META_DATA_KEY);
        if (r6 == null) goto L8;
        r0.add((ShortcutInfoChangeListener) Class.forName(r6, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r8}));     // Catch: Exception -> L25
    L21:
        if (sShortcutInfoChangeListeners != null) goto L24;
        sShortcutInfoChangeListeners = r0;
    L24:
        return sShortcutInfoChangeListeners;
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context r6) {
        if (sShortcutInfoCompatSaver != null) goto L11;
        if (Build.VERSION.SDK_INT < 23) goto L8;
        sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r6});     // Catch: Exception -> L12
    L8:
        if (sShortcutInfoCompatSaver != null) goto L11;
        sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
    L11:
        return sShortcutInfoCompatSaver;
    }

    @NonNull
    public static List<ShortcutInfoCompat> getShortcuts(@NonNull Context r3, int r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L7;
        return ShortcutInfoCompat.fromShortcuts(r3, ((ShortcutManager) r3.getSystemService(ShortcutManager.class)).getShortcuts(r4));
    L7:
        if (r0 < 25) goto L20;
        ShortcutManager r1 = (ShortcutManager) r3.getSystemService(ShortcutManager.class);
        ArrayList r2 = new ArrayList();
        if ((r4 & 1) == 0) goto L12;
        r2.addAll(r1.getManifestShortcuts());
    L12:
        if ((r4 & 2) == 0) goto L15;
        r2.addAll(r1.getDynamicShortcuts());
    L15:
        if ((r4 & 4) == 0) goto L18;
        r2.addAll(r1.getPinnedShortcuts());
    L18:
        return ShortcutInfoCompat.fromShortcuts(r3, r2);
    L20:
        if ((r4 & 2) == 0) goto L24;
        return getShortcutInfoSaverInstance(r3).getShortcuts();
    L24:
        return Collections.emptyList();
    }

    public static boolean isRateLimitingActive(@NonNull Context r2) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).isRateLimitingActive();
    L7:
        if (getShortcuts(r2, 3).size() != getMaxShortcutCountPerActivity(r2)) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isRequestPinShortcutSupported(@NonNull Context r4) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return ((ShortcutManager) r4.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
    L7:
        if (ContextCompat.checkSelfPermission(r4, INSTALL_SHORTCUT_PERMISSION) == 0) goto L9;
        return false;
    L9:
        Iterator<ResolveInfo> r5 = r4.getPackageManager().queryBroadcastReceivers(new Intent(ACTION_INSTALL_SHORTCUT), 0).iterator();
    L11:
        if (r5.hasNext() == false) goto L18;
        String r1 = r5.next().activityInfo.permission;
        if (TextUtils.isEmpty(r1) == true) goto L16;
        if (INSTALL_SHORTCUT_PERMISSION.equals(r1) == false) goto L11;
        return true;
    L16:
        return true;
    L18:
        return false;
    }

    public static boolean pushDynamicShortcut(@NonNull Context r6, @NonNull ShortcutInfoCompat r7) {
        Preconditions.checkNotNull(r6);
        Preconditions.checkNotNull(r7);
        int r0 = Build.VERSION.SDK_INT;
        if (r0 <= 31) goto L5;
    L11:
        int r2 = getMaxShortcutCountPerActivity(r6);
        if (r2 != 0) goto L15;
        return false;
    L15:
        if (r0 > 29) goto L18;
        convertUriIconToBitmapIcon(r6, r7);
    L18:
        if (r0 < 30) goto L21;
        ((ShortcutManager) r6.getSystemService(ShortcutManager.class)).pushDynamicShortcut(r7.toShortcutInfo());
    L29:
        ShortcutInfoCompatSaver<?> r1 = getShortcutInfoSaverInstance(r6);
        List<ShortcutInfoCompat> r4 = r1.getShortcuts();     // Catch: Throwable -> L40 Exception -> L47
        if (r4.size() < r2) goto L33;
        r1.removeShortcuts(Arrays.asList(new String[]{getShortcutInfoCompatWithLowestRank(r4)}));     // Catch: Throwable -> L40 Exception -> L47
    L33:
        r1.addShortcuts(Arrays.asList(new ShortcutInfoCompat[]{r7}));     // Catch: Throwable -> L40 Exception -> L47
        Iterator<ShortcutInfoChangeListener> r3 = getShortcutInfoListeners(r6).iterator();
    L36:
        if (r3.hasNext() == false) goto L38;
        r3.next().onShortcutAdded(Collections.singletonList(r7));
        goto L36
    L38:
        reportShortcutUsed(r6, r7.getId());
        return true;
    L47:
        Iterator<ShortcutInfoChangeListener> r5 = getShortcutInfoListeners(r6).iterator();
    L49:
        if (r5.hasNext() == false) goto L51;
        r5.next().onShortcutAdded(Collections.singletonList(r7));
        goto L49
    L51:
        reportShortcutUsed(r6, r7.getId());
        return false;
    L40:
        th = move-exception;
        Iterator<ShortcutInfoChangeListener> r8 = getShortcutInfoListeners(r6).iterator();
    L43:
        if (r8.hasNext() == false) goto L45;
        r8.next().onShortcutAdded(Collections.singletonList(r7));
        goto L43
    L45:
        reportShortcutUsed(r6, r7.getId());
        throw th;
    L21:
        if (r0 < 25) goto L29;
        ShortcutManager r9 = (ShortcutManager) r6.getSystemService(ShortcutManager.class);
        if (r9.isRateLimitingActive() == false) goto L25;
        return false;
    L25:
        List<ShortcutInfo> r10 = r9.getDynamicShortcuts();
        if (r10.size() < r2) goto L28;
        r9.removeDynamicShortcuts(Arrays.asList(new String[]{Api25Impl.getShortcutInfoWithLowestRank(r10)}));
    L28:
        r9.addDynamicShortcuts(Arrays.asList(new ShortcutInfo[]{r7.toShortcutInfo()}));
        goto L29
    L5:
        if (r7.isExcludedFromSurfaces(1) == false) goto L11;
        Iterator<ShortcutInfoChangeListener> r11 = getShortcutInfoListeners(r6).iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r11.next().onShortcutAdded(Collections.singletonList(r7));
        goto L8
    L10:
        return true;
    }

    public static void removeAllDynamicShortcuts(@NonNull Context r2) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
    L5:
        getShortcutInfoSaverInstance(r2).removeAllShortcuts();
        Iterator<ShortcutInfoChangeListener> r3 = getShortcutInfoListeners(r2).iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r3.next().onAllShortcutsRemoved();
        goto L7
    }

    public static void removeDynamicShortcuts(@NonNull Context r2, @NonNull List<String> r3) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(r3);
    L5:
        getShortcutInfoSaverInstance(r2).removeShortcuts(r3);
        Iterator<ShortcutInfoChangeListener> r4 = getShortcutInfoListeners(r2).iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r4.next().onShortcutRemoved(r3);
        goto L7
    }

    public static void removeLongLivedShortcuts(@NonNull Context r2, @NonNull List<String> r3) {
        if (Build.VERSION.SDK_INT >= 30) goto L6;
        removeDynamicShortcuts(r2, r3);
        return;
    L6:
        ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(r3);
        getShortcutInfoSaverInstance(r2).removeShortcuts(r3);
        Iterator<ShortcutInfoChangeListener> r4 = getShortcutInfoListeners(r2).iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r4.next().onShortcutRemoved(r3);
        goto L8
    }

    @NonNull
    private static List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface(@NonNull List<ShortcutInfoCompat> r3, int r4) {
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

    public static void reportShortcutUsed(@NonNull Context r2, @NonNull String r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r2.getSystemService(ShortcutManager.class)).reportShortcutUsed(r3);
    L5:
        Iterator<ShortcutInfoChangeListener> r4 = getShortcutInfoListeners(r2).iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r4.next().onShortcutUsageReported(Collections.singletonList(r3));
        goto L7
    }

    public static boolean requestPinShortcut(@NonNull Context r11, @NonNull ShortcutInfoCompat r12, @Nullable final IntentSender r13) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 > 31) goto L8;
        if (r12.isExcludedFromSurfaces(1) == false) goto L8;
        return false;
    L8:
        if (r0 < 26) goto L12;
        return ((ShortcutManager) r11.getSystemService(ShortcutManager.class)).requestPinShortcut(r12.toShortcutInfo(), r13);
    L12:
        if (isRequestPinShortcutSupported(r11) == true) goto L14;
        return false;
    L14:
        Intent r4 = r12.addToIntent(new Intent(ACTION_INSTALL_SHORTCUT));
        if (r13 != null) goto L18;
        r11.sendBroadcast(r4);
        return true;
    L18:
        r11.sendOrderedBroadcast(r4, null, new AnonymousClass1(r13), null, -1, null, null);
        return true;
    }

    public static boolean setDynamicShortcuts(@NonNull Context r5, @NonNull List<ShortcutInfoCompat> r6) {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        List<ShortcutInfoCompat> r1 = removeShortcutsExcludedFromSurface(r6, 1);
        if (Build.VERSION.SDK_INT < 25) goto L12;
        ArrayList r2 = new ArrayList(r1.size());
        Iterator<ShortcutInfoCompat> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L9;
        r2.add(r3.next().toShortcutInfo());
        goto L6
    L9:
        if (((ShortcutManager) r5.getSystemService(ShortcutManager.class)).setDynamicShortcuts(r2) == true) goto L12;
        return false;
    L12:
        getShortcutInfoSaverInstance(r5).removeAllShortcuts();
        getShortcutInfoSaverInstance(r5).addShortcuts(r1);
        Iterator<ShortcutInfoChangeListener> r7 = getShortcutInfoListeners(r5).iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        ShortcutInfoChangeListener r4 = r7.next();
        r4.onAllShortcutsRemoved();
        r4.onShortcutAdded(r6);
        goto L14
    L16:
        return true;
    }

    @VisibleForTesting
    static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> r0) {
        sShortcutInfoChangeListeners = r0;
    }

    @VisibleForTesting
    static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> r0) {
        sShortcutInfoCompatSaver = r0;
    }

    public static boolean updateShortcuts(@NonNull Context r5, @NonNull List<ShortcutInfoCompat> r6) {
        List<ShortcutInfoCompat> r1 = removeShortcutsExcludedFromSurface(r6, 1);
        int r2 = Build.VERSION.SDK_INT;
        if (r2 > 29) goto L6;
        convertUriIconsToBitmapIcons(r5, r1);
    L6:
        if (r2 < 25) goto L15;
        ArrayList r3 = new ArrayList();
        Iterator<ShortcutInfoCompat> r4 = r1.iterator();
    L9:
        if (r4.hasNext() == false) goto L12;
        r3.add(r4.next().toShortcutInfo());
        goto L9
    L12:
        if (((ShortcutManager) r5.getSystemService(ShortcutManager.class)).updateShortcuts(r3) == true) goto L15;
        return false;
    L15:
        getShortcutInfoSaverInstance(r5).addShortcuts(r1);
        Iterator<ShortcutInfoChangeListener> r7 = getShortcutInfoListeners(r5).iterator();
    L17:
        if (r7.hasNext() == false) goto L19;
        r7.next().onShortcutUpdated(r6);
        goto L17
    L19:
        return true;
    }
}
