package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
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

    private static final class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        BroadcastRecord(Intent r1, ArrayList<ReceiverRecord> r2) {
            this.intent = r1;
            this.receivers = r2;
        }
    }

    private static final class ReceiverRecord {
        boolean broadcasting;
        boolean dead;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter r1, BroadcastReceiver r2) {
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

    public static LocalBroadcastManager getInstance(Context r2) {
        Object r0 = mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L7;
        mInstance = new LocalBroadcastManager(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        LocalBroadcastManager r3 = mInstance;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    }

    private LocalBroadcastManager(Context r2) {
        this.mReceivers = new HashMap();
        this.mActions = new HashMap();
        this.mPendingBroadcasts = new ArrayList();
        this.mAppContext = r2;
        final Looper r3 = r2.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r3);
    }

    public void registerReceiver(BroadcastReceiver r7, IntentFilter r8) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r0 = this.mReceivers;
        monitor-enter(r0);
        ReceiverRecord r1 = new ReceiverRecord(r8, r7);     // Catch: Throwable -> L16
        ArrayList<ReceiverRecord> r2 = this.mReceivers.get(r7);     // Catch: Throwable -> L16
        if (r2 != null) goto L7;
        r2 = new ArrayList(1);     // Catch: Throwable -> L16
        this.mReceivers.put(r7, r2);     // Catch: Throwable -> L16
    L7:
        r2.add(r1);     // Catch: Throwable -> L16
        int r9 = 0;
    L9:
        if (r9 >= r8.countActions()) goto L14;
        String r3 = r8.getAction(r9);     // Catch: Throwable -> L16
        ArrayList<ReceiverRecord> r4 = this.mActions.get(r3);     // Catch: Throwable -> L16
        if (r4 != null) goto L13;
        r4 = new ArrayList(1);     // Catch: Throwable -> L16
        this.mActions.put(r3, r4);     // Catch: Throwable -> L16
    L13:
        r4.add(r1);     // Catch: Throwable -> L16
        r9 = r9 + 1;     // Catch: Throwable -> L16
        goto L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void unregisterReceiver(BroadcastReceiver r12) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r0 = this.mReceivers;
        monitor-enter(r0);
        ArrayList<ReceiverRecord> r1 = this.mReceivers.remove(r12);     // Catch: Throwable -> L28
        if (r1 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L28
        return;
    L8:
        int r2 = r1.size() - 1;     // Catch: Throwable -> L28
    L9:
        if (r2 < 0) goto L26;
        ReceiverRecord r4 = r1.get(r2);     // Catch: Throwable -> L28
        r4.dead = true;     // Catch: Throwable -> L28
        int r5 = 0;
    L12:
        if (r5 >= r4.filter.countActions()) goto L25;
        String r6 = r4.filter.getAction(r5);     // Catch: Throwable -> L28
        ArrayList<ReceiverRecord> r7 = this.mActions.get(r6);     // Catch: Throwable -> L28
        if (r7 == null) goto L24;
        int r8 = r7.size() - 1;     // Catch: Throwable -> L28
    L16:
        if (r8 < 0) goto L22;
        ReceiverRecord r9 = r7.get(r8);     // Catch: Throwable -> L28
        if (r9.receiver != r12) goto L20;
        r9.dead = true;     // Catch: Throwable -> L28
        r7.remove(r8);     // Catch: Throwable -> L28
    L20:
        r8 = r8 - 1;     // Catch: Throwable -> L28
        goto L16
    L22:
        if (r7.size() > 0) goto L24;
        this.mActions.remove(r6);     // Catch: Throwable -> L28
    L24:
        r5 = r5 + 1;     // Catch: Throwable -> L28
        goto L12
    L25:
        r2 = r2 - 1;     // Catch: Throwable -> L28
        goto L9
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean sendBroadcast(Intent r23) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r4 = this.mReceivers;
        monitor-enter(r4);
        String r12 = r23.getAction();     // Catch: Throwable -> L63
        String r13 = r23.resolveTypeIfNeeded(this.mAppContext.getContentResolver());     // Catch: Throwable -> L63
        Uri r14 = r23.getData();     // Catch: Throwable -> L63
        String r15 = r23.getScheme();     // Catch: Throwable -> L63
        Set<String> r16 = r23.getCategories();     // Catch: Throwable -> L63
        boolean r10 = true;
        if ((r23.getFlags() & 8) == 0) goto L7;
        Object[] r17 = true;
    L8:
        if (r17 == false) goto L10;
        Log.v(TAG, "Resolving type " + r13 + " scheme " + r15 + " of intent " + r23);     // Catch: Throwable -> L63
    L10:
        ArrayList<ReceiverRecord> r3 = this.mActions.get(r23.getAction());     // Catch: Throwable -> L63
        if (r3 == null) goto L60;
        if (r17 == false) goto L14;
        Log.v(TAG, "Action list: " + r3);     // Catch: Throwable -> L63
    L14:
        ArrayList r2 = null;
        int r9 = 0;
    L16:
        if (r9 >= r3.size()) goto L48;
        ReceiverRecord r8 = r3.get(r9);     // Catch: Throwable -> L63
        if (r17 == false) goto L21;
        Log.v(TAG, "Matching against filter " + r8.filter);     // Catch: Throwable -> L63
    L21:
        if (r8.broadcasting == false) goto L25;
        if (r17 == false) goto L24;
        Log.v(TAG, "  Filter's target already added");     // Catch: Throwable -> L63
    L24:
        ArrayList<ReceiverRecord> r19 = r3;
        int r20 = r9;
        String r21 = r12;
        boolean r18 = r10;
    L47:
        r9 = r20 + 1;     // Catch: Throwable -> L63
        r10 = r18;
        r3 = r19;
        r12 = r21;
        goto L16
    L25:
        String r6 = r12;
        r19 = r3;
        r20 = r9;
        r21 = r12;
        r18 = r10;
        int r5 = r8.filter.match(r6, r13, r15, r14, r16, TAG);     // Catch: Throwable -> L63
        if (r5 < 0) goto L32;
        if (r17 == false) goto L29;
        Log.v(TAG, "  Filter matched!  match=0x" + Integer.toHexString(r5));     // Catch: Throwable -> L63
    L29:
        if (r2 != null) goto L31;
        r2 = new ArrayList();     // Catch: Throwable -> L63
    L31:
        r2.add(r8);     // Catch: Throwable -> L63
        r8.broadcasting = r18;     // Catch: Throwable -> L63
        goto L47
    L32:
        if (r17 == false) goto L47;
        if (r5 != (-4)) goto L36;
        String r7 = "category";
    L46:
        Log.v(TAG, "  Filter did not match: " + r7);     // Catch: Throwable -> L63
        goto L47
    L36:
        if (r5 != (-3)) goto L38;
        r7 = "action";
        goto L46
    L38:
        if (r5 != (-2)) goto L40;
        r7 = "data";
        goto L46
    L40:
        if (r5 == (-1)) goto L42;
        r7 = "unknown reason";
        goto L46
    L42:
        r7 = "type";
        goto L46
    L48:
        boolean r110 = r10;
        if (r2 == null) goto L59;
        int r11 = 0;
    L52:
        if (r11 >= r2.size()) goto L54;
        ((ReceiverRecord) r2.get(r11)).broadcasting = false;     // Catch: Throwable -> L63
        r11 = r11 + 1;     // Catch: Throwable -> L63
        goto L52
    L54:
        this.mPendingBroadcasts.add(new BroadcastRecord(r23, r2));     // Catch: Throwable -> L63
        if (this.mHandler.hasMessages(r110 ? 1 : 0) == true) goto L57;
        this.mHandler.sendEmptyMessage(r110 ? 1 : 0);     // Catch: Throwable -> L63
    L57:
        monitor-exit(r4);     // Catch: Throwable -> L63
        return r110;
    L59:
        boolean r22 = false;
    L61:
        monitor-exit(r4);     // Catch: Throwable -> L63
        return r22;
    L60:
        r22 = false;
        goto L61
    L7:
        r17 = false;
    L63:
        th = move-exception;
        throw th;
    }

    public void sendBroadcastSync(Intent r1) {
        if (sendBroadcast(r1) == false) goto L6;
        executePendingBroadcasts();
        return;
    }

    void executePendingBroadcasts() {
    L2:
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r0 = this.mReceivers;
        monitor-enter(r0);
        int r1 = this.mPendingBroadcasts.size();     // Catch: Throwable -> L19
        if (r1 <= 0) goto L6;
        BroadcastRecord[] r2 = new BroadcastRecord[r1];     // Catch: Throwable -> L19
        this.mPendingBroadcasts.toArray(r2);     // Catch: Throwable -> L19
        this.mPendingBroadcasts.clear();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L2;
        BroadcastRecord r4 = r2[r3];
        int r5 = r4.receivers.size();
        int r6 = 0;
    L13:
        if (r6 >= r5) goto L18;
        ReceiverRecord r7 = r4.receivers.get(r6);
        if (r7.dead == true) goto L17;
        r7.receiver.onReceive(this.mAppContext, r4.intent);
    L17:
        r6 = r6 + 1;
        goto L13
    L18:
        r3 = r3 + 1;
        goto L11
    L6:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
