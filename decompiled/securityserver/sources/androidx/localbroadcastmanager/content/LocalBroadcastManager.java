package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.apm.constant.CommonKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = null;
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts;
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> mReceivers;

    public static final class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        public BroadcastRecord(Intent r1, ArrayList<ReceiverRecord> r2) {
            this.intent = r1;
            this.receivers = r2;
        }
    }

    public static final class ReceiverRecord {
        boolean broadcasting;
        boolean dead;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        public ReceiverRecord(IntentFilter r1, BroadcastReceiver r2) {
            this.filter = r1;
            this.receiver = r2;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder(128);
            r0.append("Receiver{");
            r0.append(this.receiver);
            r0.append(" filter=");
            r0.append(this.filter);
            if (this.dead == false) goto L5;
            r0.append(" DEAD");
        L5:
            r0.append("}");
            return r0.toString();
        }
    }

    static {
        mLock = new Object();
    }

    private LocalBroadcastManager(Context r2) {
        this.mReceivers = new HashMap();
        this.mActions = new HashMap();
        this.mPendingBroadcasts = new ArrayList();
        this.mAppContext = r2;
        final Looper r3 = r2.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r3);
    }

    @NonNull
    public static LocalBroadcastManager getInstance(@NonNull Context r2) {
        Object r0 = mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L9;
        mInstance = new LocalBroadcastManager(r2.getApplicationContext());     // Catch: Throwable -> L7
    L9:
        LocalBroadcastManager r3 = mInstance;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    }

    public void executePendingBroadcasts() {
    L2:
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r0 = this.mReceivers;
        monitor-enter(r0);
        int r1 = this.mPendingBroadcasts.size();     // Catch: Throwable -> L8
        if (r1 <= 0) goto L6;
        BroadcastRecord[] r2 = new BroadcastRecord[r1];     // Catch: Throwable -> L8
        this.mPendingBroadcasts.toArray(r2);     // Catch: Throwable -> L8
        this.mPendingBroadcasts.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        int r3 = 0;
    L13:
        if (r3 >= r1) goto L2;
        BroadcastRecord r4 = r2[r3];
        int r5 = r4.receivers.size();
        int r6 = 0;
    L15:
        if (r6 >= r5) goto L20;
        ReceiverRecord r7 = r4.receivers.get(r6);
        if (r7.dead == true) goto L19;
        r7.receiver.onReceive(this.mAppContext, r4.intent);
    L19:
        r6 = r6 + 1;
        goto L15
    L20:
        r3 = r3 + 1;
        goto L13
    L6:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void registerReceiver(@NonNull BroadcastReceiver r7, @NonNull IntentFilter r8) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r0 = this.mReceivers;
        monitor-enter(r0);
        ReceiverRecord r1 = new ReceiverRecord(r8, r7);     // Catch: Throwable -> L7
        ArrayList<ReceiverRecord> r2 = this.mReceivers.get(r7);     // Catch: Throwable -> L7
        if (r2 != null) goto L9;
        r2 = new ArrayList(1);     // Catch: Throwable -> L7
        this.mReceivers.put(r7, r2);     // Catch: Throwable -> L7
    L9:
        r2.add(r1);     // Catch: Throwable -> L7
        int r9 = 0;
    L11:
        if (r9 >= r8.countActions()) goto L16;
        String r3 = r8.getAction(r9);     // Catch: Throwable -> L7
        ArrayList<ReceiverRecord> r4 = this.mActions.get(r3);     // Catch: Throwable -> L7
        if (r4 != null) goto L15;
        r4 = new ArrayList(1);     // Catch: Throwable -> L7
        this.mActions.put(r3, r4);     // Catch: Throwable -> L7
    L15:
        r4.add(r1);     // Catch: Throwable -> L7
        r9 = r9 + 1;     // Catch: Throwable -> L7
        goto L11
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean sendBroadcast(@NonNull Intent r23) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r4 = this.mReceivers;
        monitor-enter(r4);
        String r12 = r23.getAction();     // Catch: Throwable -> L10
        String r13 = r23.resolveTypeIfNeeded(this.mAppContext.getContentResolver());     // Catch: Throwable -> L10
        Uri r14 = r23.getData();     // Catch: Throwable -> L10
        String r15 = r23.getScheme();     // Catch: Throwable -> L10
        Set<String> r16 = r23.getCategories();     // Catch: Throwable -> L10
        boolean r10 = true;
        if ((r23.getFlags() & 8) == 0) goto L7;
        Object[] r17 = true;
    L8:
        if (r17 == false) goto L12;
        Log.v(TAG, "Resolving type " + r13 + " scheme " + r15 + " of intent " + r23);     // Catch: Throwable -> L10
    L12:
        ArrayList<ReceiverRecord> r3 = this.mActions.get(r23.getAction());     // Catch: Throwable -> L10
        if (r3 == null) goto L62;
        if (r17 == false) goto L16;
        Log.v(TAG, "Action list: " + r3);     // Catch: Throwable -> L10
    L16:
        ArrayList r2 = null;
        int r9 = 0;
    L18:
        if (r9 >= r3.size()) goto L50;
        ReceiverRecord r8 = r3.get(r9);     // Catch: Throwable -> L10
        if (r17 == false) goto L23;
        Log.v(TAG, "Matching against filter " + r8.filter);     // Catch: Throwable -> L10
    L23:
        if (r8.broadcasting == false) goto L27;
        if (r17 == false) goto L26;
        Log.v(TAG, "  Filter's target already added");     // Catch: Throwable -> L10
    L26:
        ArrayList<ReceiverRecord> r19 = r3;
        int r20 = r9;
        String r21 = r12;
        boolean r18 = r10;
    L49:
        r9 = r20 + 1;     // Catch: Throwable -> L10
        r10 = r18;
        r3 = r19;
        r12 = r21;
        goto L18
    L27:
        String r6 = r12;
        r19 = r3;
        r20 = r9;
        r21 = r12;
        r18 = r10;
        int r5 = r8.filter.match(r6, r13, r15, r14, r16, TAG);     // Catch: Throwable -> L10
        if (r5 < 0) goto L34;
        if (r17 == false) goto L31;
        Log.v(TAG, "  Filter matched!  match=0x" + Integer.toHexString(r5));     // Catch: Throwable -> L10
    L31:
        if (r2 != null) goto L33;
        r2 = new ArrayList();     // Catch: Throwable -> L10
    L33:
        r2.add(r8);     // Catch: Throwable -> L10
        r8.broadcasting = r18;     // Catch: Throwable -> L10
        goto L49
    L34:
        if (r17 == false) goto L49;
        if (r5 != (-4)) goto L38;
        String r7 = CommonKey.KEY_CATEGORY;
    L48:
        Log.v(TAG, "  Filter did not match: " + r7);     // Catch: Throwable -> L10
        goto L49
    L38:
        if (r5 != (-3)) goto L40;
        r7 = "action";
        goto L48
    L40:
        if (r5 != (-2)) goto L42;
        r7 = "data";
        goto L48
    L42:
        if (r5 == (-1)) goto L44;
        r7 = "unknown reason";
        goto L48
    L44:
        r7 = "type";
        goto L48
    L50:
        boolean r110 = r10;
        if (r2 == null) goto L61;
        int r11 = 0;
    L54:
        if (r11 >= r2.size()) goto L56;
        ((ReceiverRecord) r2.get(r11)).broadcasting = false;     // Catch: Throwable -> L10
        r11 = r11 + 1;     // Catch: Throwable -> L10
        goto L54
    L56:
        this.mPendingBroadcasts.add(new BroadcastRecord(r23, r2));     // Catch: Throwable -> L10
        if (this.mHandler.hasMessages(r110 ? 1 : 0) == true) goto L59;
        this.mHandler.sendEmptyMessage(r110 ? 1 : 0);     // Catch: Throwable -> L10
    L59:
        monitor-exit(r4);     // Catch: Throwable -> L10
        return r110;
    L61:
        boolean r22 = false;
    L63:
        monitor-exit(r4);     // Catch: Throwable -> L10
        return r22;
    L62:
        r22 = false;
        goto L63
    L7:
        r17 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public void sendBroadcastSync(@NonNull Intent r1) {
        if (sendBroadcast(r1) == false) goto L6;
        executePendingBroadcasts();
        return;
    }

    public void unregisterReceiver(@NonNull BroadcastReceiver r12) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r0 = this.mReceivers;
        monitor-enter(r0);
        ArrayList<ReceiverRecord> r1 = this.mReceivers.remove(r12);     // Catch: Throwable -> L8
        if (r1 != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int r2 = r1.size() - 1;     // Catch: Throwable -> L8
    L11:
        if (r2 < 0) goto L28;
        ReceiverRecord r4 = r1.get(r2);     // Catch: Throwable -> L8
        r4.dead = true;     // Catch: Throwable -> L8
        int r5 = 0;
    L14:
        if (r5 >= r4.filter.countActions()) goto L27;
        String r6 = r4.filter.getAction(r5);     // Catch: Throwable -> L8
        ArrayList<ReceiverRecord> r7 = this.mActions.get(r6);     // Catch: Throwable -> L8
        if (r7 == null) goto L26;
        int r8 = r7.size() - 1;     // Catch: Throwable -> L8
    L18:
        if (r8 < 0) goto L24;
        ReceiverRecord r9 = r7.get(r8);     // Catch: Throwable -> L8
        if (r9.receiver != r12) goto L22;
        r9.dead = true;     // Catch: Throwable -> L8
        r7.remove(r8);     // Catch: Throwable -> L8
    L22:
        r8 = r8 - 1;     // Catch: Throwable -> L8
        goto L18
    L24:
        if (r7.size() > 0) goto L26;
        this.mActions.remove(r6);     // Catch: Throwable -> L8
    L26:
        r5 = r5 + 1;     // Catch: Throwable -> L8
        goto L14
    L27:
        r2 = r2 - 1;     // Catch: Throwable -> L8
        goto L11
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
