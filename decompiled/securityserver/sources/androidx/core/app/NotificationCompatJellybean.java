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
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.String r0 = "Unable to access notification actions"
            java.lang.String r1 = "NotificationCompat"
            boolean r2 = androidx.core.app.NotificationCompatJellybean.sActionsAccessFailed
            if (r2 == 0) goto La
            r0 = 0
            return r0
        La:
            r2 = 1
            java.lang.reflect.Field r3 = androidx.core.app.NotificationCompatJellybean.sActionsField     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3d
            if (r3 != 0) goto L4a
            java.lang.String r3 = "android.app.Notification$Action"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3d
            java.lang.String r4 = "icon"
            java.lang.reflect.Field r4 = r3.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3d
            androidx.core.app.NotificationCompatJellybean.sActionIconField = r4     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3d
            java.lang.String r4 = "title"
            java.lang.reflect.Field r4 = r3.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3d
            androidx.core.app.NotificationCompatJellybean.sActionTitleField = r4     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3d
            java.lang.String r4 = "actionIntent"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3d
            androidx.core.app.NotificationCompatJellybean.sActionIntentField = r3     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3d
            java.lang.Class<android.app.Notification> r3 = android.app.Notification.class
            java.lang.String r4 = "actions"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3d
            androidx.core.app.NotificationCompatJellybean.sActionsField = r3     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3d
            r3.setAccessible(r2)     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3d
            goto L4a
        L3b:
            r3 = move-exception
            goto L3f
        L3d:
            r3 = move-exception
            goto L45
        L3f:
            android.util.Log.e(r1, r0, r3)
            androidx.core.app.NotificationCompatJellybean.sActionsAccessFailed = r2
            goto L4a
        L45:
            android.util.Log.e(r1, r0, r3)
            androidx.core.app.NotificationCompatJellybean.sActionsAccessFailed = r2
        L4a:
            boolean r0 = androidx.core.app.NotificationCompatJellybean.sActionsAccessFailed
            r0 = r0 ^ r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompatJellybean.ensureActionReflectionReadyLocked():boolean");
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
        Object[] r2 = getActionObjectsLocked(r5);     // Catch: Throwable -> L12 IllegalAccessException -> L14
        if (r2 == null) goto L21;
        Object r3 = r2[r6];     // Catch: Throwable -> L12 IllegalAccessException -> L14
        Bundle r7 = getExtras(r5);     // Catch: Throwable -> L12 IllegalAccessException -> L14
        if (r7 == null) goto L16;
        SparseArray r8 = r7.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);     // Catch: Throwable -> L12 IllegalAccessException -> L14
        if (r8 == null) goto L16;
        Bundle r9 = (Bundle) r8.get(r6);     // Catch: Throwable -> L12 IllegalAccessException -> L14
    L17:
        NotificationCompat.Action r10 = readAction(sActionIconField.getInt(r3), (CharSequence) sActionTitleField.get(r3), (PendingIntent) sActionIntentField.get(r3), r9);     // Catch: Throwable -> L12 IllegalAccessException -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r10;
    L16:
        r9 = null;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    L14:
        e = move-exception;
        Log.e(TAG, "Unable to access notification actions", e);     // Catch: Throwable -> L12
        sActionsAccessFailed = true;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public static int getActionCount(Notification r1) {
        Object r0 = sActionsLock;
        monitor-enter(r0);
        Object[] r2 = getActionObjectsLocked(r1);     // Catch: Throwable -> L7
        if (r2 == null) goto L9;
        int r3 = r2.length;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L9:
        r3 = 0;
    L7:
        th = move-exception;
        throw th;
    }

    public static NotificationCompat.Action getActionFromBundle(Bundle r14) {
        Bundle r1 = r14.getBundle(KEY_EXTRAS);
        boolean r2 = false;
        if (r1 == null) goto L5;
        r2 = r1.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES, false);
    L5:
        boolean r10 = r2;
        return new NotificationCompat.Action(r14.getInt(KEY_ICON), r14.getCharSequence(KEY_TITLE), (PendingIntent) r14.getParcelable(KEY_ACTION_INTENT), r14.getBundle(KEY_EXTRAS), fromBundleArray(getBundleArrayFromBundle(r14, KEY_REMOTE_INPUTS)), fromBundleArray(getBundleArrayFromBundle(r14, KEY_DATA_ONLY_REMOTE_INPUTS)), r10, r14.getInt(KEY_SEMANTIC_ACTION), r14.getBoolean(KEY_SHOWS_USER_INTERFACE), false);
    }

    private static Object[] getActionObjectsLocked(Notification r4) {
        Object r0 = sActionsLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (ensureActionReflectionReadyLocked() == true) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L19:
        Object[] r5 = (Object[]) sActionsField.get(r4);     // Catch: Throwable -> L8 IllegalAccessException -> L13
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r5;
    L13:
        e = move-exception;
        Log.e(TAG, "Unable to access notification actions", e);     // Catch: Throwable -> L8
        sActionsAccessFailed = true;     // Catch: Throwable -> L8
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

    public static Bundle getBundleForAction(NotificationCompat.Action r4) {
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
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sExtrasFieldAccessFailed == false) goto L36;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L36:
    L20:
        e = move-exception;
        Log.e(TAG, "Unable to access notification extras", e);     // Catch: Throwable -> L8
    L30:
        sExtrasFieldAccessFailed = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L18:
        e = move-exception;
        Log.e(TAG, "Unable to access notification extras", e);     // Catch: Throwable -> L8
        goto L30
    L12:
        if (sExtrasField != null) goto L23;
        Field r3 = Notification.class.getDeclaredField(KEY_EXTRAS);     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
        if (Bundle.class.isAssignableFrom(r3.getType()) == true) goto L22;
        Log.e(TAG, "Notification.extras field is not of type Bundle");     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
        sExtrasFieldAccessFailed = true;     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L22:
        r3.setAccessible(true);     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
        sExtrasField = r3;     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
    L23:
        Bundle r4 = (Bundle) sExtrasField.get(r6);     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
        if (r4 != null) goto L26;
        r4 = new Bundle();     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
        sExtrasField.set(r6, r4);     // Catch: Throwable -> L8 NoSuchFieldException -> L18 IllegalAccessException -> L20
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r4;
    }

    public static NotificationCompat.Action readAction(int r12, CharSequence r13, PendingIntent r14, Bundle r15) {
        if (r15 == null) goto L4;
        RemoteInput[] r0 = fromBundleArray(getBundleArrayFromBundle(r15, NotificationCompatExtras.EXTRA_REMOTE_INPUTS));
        RemoteInput[] r5 = r0;
        RemoteInput[] r6 = fromBundleArray(getBundleArrayFromBundle(r15, EXTRA_DATA_ONLY_REMOTE_INPUTS));
        boolean r7 = r15.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES);
    L6:
        return new NotificationCompat.Action(r12, r13, r14, r15, r5, r6, r7, 0, true, false);
    L4:
        r5 = null;
        r6 = null;
        r7 = false;
        goto L6
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
