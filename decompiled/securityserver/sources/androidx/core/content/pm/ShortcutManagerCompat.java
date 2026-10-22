package androidx.core.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutManagerCompat {

    @VisibleForTesting
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";

    @VisibleForTesting
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    /* JADX INFO: renamed from: androidx.core.content.pm.ShortcutManagerCompat$1, reason: invalid class name */
    public class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ IntentSender val$callback;

        public AnonymousClass1(IntentSender r1) {
            this.val$callback = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r7, Intent r8) {
            this.val$callback.sendIntent(r7, 0, null, null, null);     // Catch: IntentSender.SendIntentException -> L4
            return;
        }
    }

    private ShortcutManagerCompat() {
    }

    public static boolean addDynamicShortcuts(@NonNull Context r3, @NonNull List<ShortcutInfoCompat> r4) {
        ArrayList r0 = new ArrayList();
        Iterator<ShortcutInfoCompat> r1 = r4.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0.add(r1.next().toShortcutInfo());
        goto L4
    L7:
        if (((ShortcutManager) r3.getSystemService(ShortcutManager.class)).addDynamicShortcuts(r0) == true) goto L10;
        return false;
    L10:
        getShortcutInfoSaverInstance(r3).addShortcuts(r4);
        return true;
    }

    @NonNull
    public static Intent createShortcutResultIntent(@NonNull Context r1, @NonNull ShortcutInfoCompat r2) {
        Intent r3 = ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).createShortcutResultIntent(r2.toShortcutInfo());
        if (r3 != null) goto L6;
        r3 = new Intent();
    L6:
        return r2.addToIntent(r3);
    }

    @NonNull
    public static List<ShortcutInfoCompat> getDynamicShortcuts(@NonNull Context r4) {
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

    public static int getMaxShortcutCountPerActivity(@NonNull Context r1) {
        return ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context r3) {
        if (sShortcutInfoCompatSaver != null) goto L9;
        sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r3});     // Catch: Exception -> L10
    L6:
        if (sShortcutInfoCompatSaver != null) goto L9;
        sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
    L9:
        return sShortcutInfoCompatSaver;
    }

    public static boolean isRequestPinShortcutSupported(@NonNull Context r1) {
        return ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
    }

    public static void removeAllDynamicShortcuts(@NonNull Context r1) {
        ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        getShortcutInfoSaverInstance(r1).removeAllShortcuts();
    }

    public static void removeDynamicShortcuts(@NonNull Context r1, @NonNull List<String> r2) {
        ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(r2);
        getShortcutInfoSaverInstance(r1).removeShortcuts(r2);
    }

    public static boolean requestPinShortcut(@NonNull Context r1, @NonNull ShortcutInfoCompat r2, @Nullable IntentSender r3) {
        return ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).requestPinShortcut(r2.toShortcutInfo(), r3);
    }

    public static boolean updateShortcuts(@NonNull Context r3, @NonNull List<ShortcutInfoCompat> r4) {
        ArrayList r0 = new ArrayList();
        Iterator<ShortcutInfoCompat> r1 = r4.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0.add(r1.next().toShortcutInfo());
        goto L4
    L7:
        if (((ShortcutManager) r3.getSystemService(ShortcutManager.class)).updateShortcuts(r0) == true) goto L10;
        return false;
    L10:
        getShortcutInfoSaverInstance(r3).addShortcuts(r4);
        return true;
    }
}
