package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(16)
class NotificationCompatJellybean {
    static final String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
    static final String EXTRA_DATA_ONLY_REMOTE_INPUTS = "android.support.dataRemoteInputs";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final String KEY_CHOICES = "choices";
    private static final String KEY_DATA_ONLY_REMOTE_INPUTS = "dataOnlyRemoteInputs";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_LABEL = "label";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_RESULT_KEY = "resultKey";
    private static final String KEY_SEMANTIC_ACTION = "semanticAction";
    private static final String KEY_SHOWS_USER_INTERFACE = "showsUserInterface";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static final Object sActionsLock = null;
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock = null;

    static {
        sExtrasLock = new Object();
        sActionsLock = new Object();
    }

    private NotificationCompatJellybean() {
    }

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> r4) {
        int r0 = r4.size();
        SparseArray<Bundle> r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        Bundle r3 = r4.get(r2);
        if (r3 == null) goto L9;
        if (r1 != null) goto L8;
        r1 = new SparseArray();
    L8:
        r1.put(r2, r3);
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r1;
    }

    private static boolean ensureActionReflectionReadyLocked() {
        if (sActionsAccessFailed == false) goto L15;
        return false;
    L15:
    L11:
        e = move-exception;
        Log.e(TAG, "Unable to access notification actions", e);
        sActionsAccessFailed = true;
    L14:
        return !sActionsAccessFailed;
    L8:
        if (sActionsField != null) goto L14;
        Class<?> r3 = Class.forName("android.app.Notification$Action");     // Catch: Throwable -> L11
        sActionIconField = r3.getDeclaredField(KEY_ICON);     // Catch: Throwable -> L11
        sActionTitleField = r3.getDeclaredField(KEY_TITLE);     // Catch: Throwable -> L11
        sActionIntentField = r3.getDeclaredField(KEY_ACTION_INTENT);     // Catch: Throwable -> L11
        Field r4 = Notification.class.getDeclaredField("actions");     // Catch: Throwable -> L11
        sActionsField = r4;     // Catch: Throwable -> L11
        r4.setAccessible(true);     // Catch: Throwable -> L11
        goto L14
    }

    private static RemoteInput fromBundle(Bundle r9) {
        ArrayList<String> r0 = r9.getStringArrayList(KEY_ALLOWED_DATA_TYPES);
        HashSet r8 = new HashSet();
        if (r0 == null) goto L9;
        Iterator<String> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r8.add(r1.next());
    L9:
        return new RemoteInput(r9.getString(KEY_RESULT_KEY), r9.getCharSequence(KEY_LABEL), r9.getCharSequenceArray(KEY_CHOICES), r9.getBoolean(KEY_ALLOW_FREE_FORM_INPUT), 0, r9.getBundle(KEY_EXTRAS), r8);
    }

    private static RemoteInput[] fromBundleArray(Bundle[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        RemoteInput[] r0 = new RemoteInput[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = fromBundle(r3[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public static NotificationCompat.Action getAction(Notification r5, int r6) {
        Object r0 = sActionsLock;
        monitor-enter(r0);
        Object[] r2 = getActionObjectsLocked(r5);     // Catch: Throwable -> L16 IllegalAccessException -> L18
        if (r2 == null) goto L20;
        Object r3 = r2[r6];     // Catch: Throwable -> L16 IllegalAccessException -> L18
        Bundle r7 = getExtras(r5);     // Catch: Throwable -> L16 IllegalAccessException -> L18
        if (r7 == null) goto L12;
        SparseArray r8 = r7.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);     // Catch: Throwable -> L16 IllegalAccessException -> L18
        if (r8 == null) goto L12;
        Bundle r9 = (Bundle) r8.get(r6);     // Catch: Throwable -> L16 IllegalAccessException -> L18
    L13:
        NotificationCompat.Action r10 = readAction(sActionIconField.getInt(r3), (CharSequence) sActionTitleField.get(r3), (PendingIntent) sActionIntentField.get(r3), r9);     // Catch: Throwable -> L16 IllegalAccessException -> L18
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r10;
    L12:
        r9 = null;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return null;
    L18:
        e = move-exception;
        Log.e(TAG, "Unable to access notification actions", e);     // Catch: Throwable -> L16
        sActionsAccessFailed = true;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public static int getActionCount(Notification r1) {
        Object r0 = sActionsLock;
        monitor-enter(r0);
        Object[] r2 = getActionObjectsLocked(r1);     // Catch: Throwable -> L10
        if (r2 == null) goto L7;
        int r3 = r2.length;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L7:
        r3 = 0;
    L10:
        th = move-exception;
        throw th;
    }

    static NotificationCompat.Action getActionFromBundle(Bundle r15) {
        Bundle r1 = r15.getBundle(KEY_EXTRAS);
        boolean r2 = false;
        if (r1 == null) goto L5;
        r2 = r1.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES, false);
    L5:
        boolean r10 = r2;
        return new NotificationCompat.Action(r15.getInt(KEY_ICON), r15.getCharSequence(KEY_TITLE), (PendingIntent) r15.getParcelable(KEY_ACTION_INTENT), r15.getBundle(KEY_EXTRAS), fromBundleArray(getBundleArrayFromBundle(r15, KEY_REMOTE_INPUTS)), fromBundleArray(getBundleArrayFromBundle(r15, KEY_DATA_ONLY_REMOTE_INPUTS)), r10, r15.getInt(KEY_SEMANTIC_ACTION), r15.getBoolean(KEY_SHOWS_USER_INTERFACE), false, false);
    }

    private static Object[] getActionObjectsLocked(Notification r4) {
        Object r0 = sActionsLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (ensureActionReflectionReadyLocked() == true) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return null;
    L18:
        Object[] r5 = (Object[]) sActionsField.get(r4);     // Catch: IllegalAccessException -> L11 Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r5;
    L11:
        e = move-exception;
        Log.e(TAG, "Unable to access notification actions", e);     // Catch: Throwable -> L15
        sActionsAccessFailed = true;     // Catch: Throwable -> L15
        return null;
    }

    private static Bundle[] getBundleArrayFromBundle(Bundle r3, String r4) {
        Parcelable[] r0 = r3.getParcelableArray(r4);
        if ((r0 instanceof Bundle[]) == true) goto L9;
        if (r0 == null) goto L9;
        Bundle[] r1 = (Bundle[]) Arrays.copyOf(r0, r0.length, Bundle[].class);
        r3.putParcelableArray(r4, r1);
        return r1;
    L9:
        return (Bundle[]) r0;
    }

    static Bundle getBundleForAction(NotificationCompat.Action r4) {
        Bundle r0 = new Bundle();
        IconCompat r1 = r4.getIconCompat();
        if (r1 == null) goto L5;
        int r2 = r1.getResId();
    L6:
        r0.putInt(KEY_ICON, r2);
        r0.putCharSequence(KEY_TITLE, r4.getTitle());
        r0.putParcelable(KEY_ACTION_INTENT, r4.getActionIntent());
        if (r4.getExtras() == null) goto L9;
        Bundle r3 = new Bundle(r4.getExtras());
    L10:
        r3.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, r4.getAllowGeneratedReplies());
        r0.putBundle(KEY_EXTRAS, r3);
        r0.putParcelableArray(KEY_REMOTE_INPUTS, toBundleArray(r4.getRemoteInputs()));
        r0.putBoolean(KEY_SHOWS_USER_INTERFACE, r4.getShowsUserInterface());
        r0.putInt(KEY_SEMANTIC_ACTION, r4.getSemanticAction());
        return r0;
    L9:
        r3 = new Bundle();
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public static Bundle getExtras(Notification r6) {
        Object r0 = sExtrasLock;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (sExtrasFieldAccessFailed == false) goto L34;
        monitor-exit(r0);     // Catch: Throwable -> L30
        return null;
    L34:
    L25:
        e = e;
        String r3 = TAG;
        String r4 = "Unable to access notification extras";
    L24:
        Log.e(r3, r4, e);     // Catch: Throwable -> L30
        sExtrasFieldAccessFailed = true;     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
        return null;
    L22:
        e = e;
        r3 = TAG;
        r4 = "Unable to access notification extras";
        goto L24
    L10:
        if (sExtrasField != null) goto L17;
        Field r5 = Notification.class.getDeclaredField(KEY_EXTRAS);     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
        if (Bundle.class.isAssignableFrom(r5.getType()) == true) goto L16;
        Log.e(TAG, "Notification.extras field is not of type Bundle");     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
        sExtrasFieldAccessFailed = true;     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
        return null;
    L16:
        r5.setAccessible(true);     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
        sExtrasField = r5;     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
    L17:
        Bundle r7 = (Bundle) sExtrasField.get(r6);     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
        if (r7 != null) goto L20;
        r7 = new Bundle();     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
        sExtrasField.set(r6, r7);     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L25 Throwable -> L30
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L30
        return r7;
    }

    public static NotificationCompat.Action readAction(int r13, CharSequence r14, PendingIntent r15, Bundle r16) {
        if (r16 == null) goto L5;
        RemoteInput[] r0 = fromBundleArray(getBundleArrayFromBundle(r16, NotificationCompatExtras.EXTRA_REMOTE_INPUTS));
        RemoteInput[] r5 = r0;
        RemoteInput[] r6 = fromBundleArray(getBundleArrayFromBundle(r16, EXTRA_DATA_ONLY_REMOTE_INPUTS));
        boolean r7 = r16.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES);
    L7:
        return new NotificationCompat.Action(r13, r14, r15, r16, r5, r6, r7, 0, true, false, false);
    L5:
        r5 = null;
        r6 = null;
        r7 = false;
        goto L7
    }

    private static Bundle toBundle(RemoteInput r3) {
        Bundle r0 = new Bundle();
        r0.putString(KEY_RESULT_KEY, r3.getResultKey());
        r0.putCharSequence(KEY_LABEL, r3.getLabel());
        r0.putCharSequenceArray(KEY_CHOICES, r3.getChoices());
        r0.putBoolean(KEY_ALLOW_FREE_FORM_INPUT, r3.getAllowFreeFormInput());
        r0.putBundle(KEY_EXTRAS, r3.getExtras());
        Set<String> r4 = r3.getAllowedDataTypes();
        if (r4 != null) goto L5;
    L11:
        return r0;
    L5:
        if (r4.isEmpty() == true) goto L11;
        ArrayList<String> r1 = new ArrayList(r4.size());
        Iterator<String> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r1.add(r5.next());
        goto L8
    L10:
        r0.putStringArrayList(KEY_ALLOWED_DATA_TYPES, r1);
        goto L11
    }

    private static Bundle[] toBundleArray(RemoteInput[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Bundle[] r0 = new Bundle[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = toBundle(r3[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder r3, NotificationCompat.Action r4) {
        IconCompat r0 = r4.getIconCompat();
        if (r0 == null) goto L5;
        int r1 = r0.getResId();
    L6:
        r3.addAction(r1, r4.getTitle(), r4.getActionIntent());
        Bundle r5 = new Bundle(r4.getExtras());
        if (r4.getRemoteInputs() == null) goto L10;
        r5.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, toBundleArray(r4.getRemoteInputs()));
    L10:
        if (r4.getDataOnlyRemoteInputs() == null) goto L12;
        r5.putParcelableArray(EXTRA_DATA_ONLY_REMOTE_INPUTS, toBundleArray(r4.getDataOnlyRemoteInputs()));
    L12:
        r5.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, r4.getAllowGeneratedReplies());
        return r5;
    L5:
        r1 = 0;
        goto L6
    }
}
