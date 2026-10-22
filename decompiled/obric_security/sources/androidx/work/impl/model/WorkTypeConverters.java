package androidx.work.impl.model;

import android.net.Uri;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: compiled from: WorkTypeConverters.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\u0016\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0013H\u0007¨\u0006 "}, d2 = {"Landroidx/work/impl/model/WorkTypeConverters;", "", "()V", "backoffPolicyToInt", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "byteArrayToSetOfTriggers", "", "Landroidx/work/Constraints$ContentUriTrigger;", "bytes", "", "intToBackoffPolicy", "value", "intToNetworkType", "Landroidx/work/NetworkType;", "intToOutOfQuotaPolicy", "Landroidx/work/OutOfQuotaPolicy;", "intToState", "Landroidx/work/WorkInfo$State;", "networkTypeToInt", "networkType", "outOfQuotaPolicyToInt", "policy", "setOfTriggersToByteArray", "triggers", "stateToInt", "state", "BackoffPolicyIds", "NetworkTypeIds", "OutOfPolicyIds", "StateIds", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WorkTypeConverters {
    public static final WorkTypeConverters INSTANCE = null;

    /* JADX INFO: compiled from: WorkTypeConverters.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/work/impl/model/WorkTypeConverters$BackoffPolicyIds;", "", "()V", "EXPONENTIAL", "", "LINEAR", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class BackoffPolicyIds {
        public static final int EXPONENTIAL = 0;
        public static final BackoffPolicyIds INSTANCE = null;
        public static final int LINEAR = 1;

        static {
            INSTANCE = new BackoffPolicyIds();
        }

        private BackoffPolicyIds() {
        }
    }

    /* JADX INFO: compiled from: WorkTypeConverters.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/work/impl/model/WorkTypeConverters$NetworkTypeIds;", "", "()V", "CONNECTED", "", "METERED", "NOT_REQUIRED", "NOT_ROAMING", "TEMPORARILY_UNMETERED", "UNMETERED", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class NetworkTypeIds {
        public static final int CONNECTED = 1;
        public static final NetworkTypeIds INSTANCE = null;
        public static final int METERED = 4;
        public static final int NOT_REQUIRED = 0;
        public static final int NOT_ROAMING = 3;
        public static final int TEMPORARILY_UNMETERED = 5;
        public static final int UNMETERED = 2;

        static {
            INSTANCE = new NetworkTypeIds();
        }

        private NetworkTypeIds() {
        }
    }

    /* JADX INFO: compiled from: WorkTypeConverters.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/work/impl/model/WorkTypeConverters$OutOfPolicyIds;", "", "()V", "DROP_WORK_REQUEST", "", "RUN_AS_NON_EXPEDITED_WORK_REQUEST", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class OutOfPolicyIds {
        public static final int DROP_WORK_REQUEST = 1;
        public static final OutOfPolicyIds INSTANCE = null;
        public static final int RUN_AS_NON_EXPEDITED_WORK_REQUEST = 0;

        static {
            INSTANCE = new OutOfPolicyIds();
        }

        private OutOfPolicyIds() {
        }
    }

    /* JADX INFO: compiled from: WorkTypeConverters.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/work/impl/model/WorkTypeConverters$StateIds;", "", "()V", "BLOCKED", "", "CANCELLED", "COMPLETED_STATES", "", "ENQUEUED", "FAILED", DebugCoroutineInfoImplKt.RUNNING, "SUCCEEDED", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StateIds {
        public static final int BLOCKED = 4;
        public static final int CANCELLED = 5;
        public static final String COMPLETED_STATES = "(2, 3, 5)";
        public static final int ENQUEUED = 0;
        public static final int FAILED = 3;
        public static final StateIds INSTANCE = null;
        public static final int RUNNING = 1;
        public static final int SUCCEEDED = 2;

        static {
            INSTANCE = new StateIds();
        }

        private StateIds() {
        }
    }

    /* JADX INFO: compiled from: WorkTypeConverters.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = null;

        static {
            int[] r0 = new int[WorkInfo.State.values().length];
            r0[WorkInfo.State.ENQUEUED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L62:
            r0[WorkInfo.State.RUNNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L70:
            r0[WorkInfo.State.SUCCEEDED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L46:
            r0[WorkInfo.State.FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L48:
            r0[WorkInfo.State.BLOCKED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L56:
            r0[WorkInfo.State.CANCELLED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L13:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[BackoffPolicy.values().length];
            r1[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L50:
            r1[BackoffPolicy.LINEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L16:
            $EnumSwitchMapping$1 = r1;
            int[] r2 = new int[NetworkType.values().length];
            r2[NetworkType.NOT_REQUIRED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L44:
            r2[NetworkType.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L52:
            r2[NetworkType.UNMETERED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L58:
            r2[NetworkType.NOT_ROAMING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L64:
            r2[NetworkType.METERED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L22:
            $EnumSwitchMapping$2 = r2;
            int[] r3 = new int[OutOfQuotaPolicy.values().length];
            r3[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L68:
            r3[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L25:
            $EnumSwitchMapping$3 = r3;
        }
    }

    static {
        INSTANCE = new WorkTypeConverters();
    }

    private WorkTypeConverters() {
    }

    @JvmStatic
    public static final int stateToInt(WorkInfo.State r1) {
        Intrinsics.checkNotNullParameter(r1, "state");
        switch(WhenMappings.$EnumSwitchMapping$0[r1.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return 5;
    L7:
        return 4;
    L8:
        return 3;
    L9:
        return 2;
    L10:
        return 1;
    L11:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final WorkInfo.State intToState(int r3) {
        if (r3 == 0) goto L21;
        if (r3 == 1) goto L26;
        if (r3 == 2) goto L25;
        if (r3 == 3) goto L24;
        if (r3 == 4) goto L23;
        if (r3 != 5) goto L15;
        return WorkInfo.State.CANCELLED;
    L15:
        throw new IllegalArgumentException("Could not convert " + r3 + " to State");
    L23:
        return WorkInfo.State.BLOCKED;
    L24:
        return WorkInfo.State.FAILED;
    L25:
        return WorkInfo.State.SUCCEEDED;
    L26:
        return WorkInfo.State.RUNNING;
    L21:
        return WorkInfo.State.ENQUEUED;
    }

    @JvmStatic
    public static final int backoffPolicyToInt(BackoffPolicy r2) {
        Intrinsics.checkNotNullParameter(r2, "backoffPolicy");
        int r3 = WhenMappings.$EnumSwitchMapping$1[r2.ordinal()];
        if (r3 != 1) goto L5;
        return 0;
    L5:
        if (r3 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final BackoffPolicy intToBackoffPolicy(int r3) {
        if (r3 == 0) goto L9;
        if (r3 != 1) goto L7;
        return BackoffPolicy.LINEAR;
    L7:
        throw new IllegalArgumentException("Could not convert " + r3 + " to BackoffPolicy");
    L9:
        return BackoffPolicy.EXPONENTIAL;
    }

    @JvmStatic
    public static final int networkTypeToInt(NetworkType r3) {
        Intrinsics.checkNotNullParameter(r3, "networkType");
        int r0 = WhenMappings.$EnumSwitchMapping$2[r3.ordinal()];
        if (r0 == 1) goto L18;
        int r2 = 2;
        if (r0 != 2) goto L7;
        return 1;
    L7:
        if (r0 == 3) goto L22;
        r2 = 4;
        if (r0 != 4) goto L11;
        return 3;
    L11:
        if (r0 == 5) goto L22;
        if (r3 != NetworkType.TEMPORARILY_UNMETERED) goto L16;
        return 5;
    L16:
        throw new IllegalArgumentException("Could not convert " + r3 + " to int");
    L22:
        return r2;
    L18:
        return 0;
    }

    @JvmStatic
    public static final NetworkType intToNetworkType(int r3) {
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L26;
        if (r3 == 2) goto L25;
        if (r3 == 3) goto L24;
        if (r3 == 4) goto L23;
        if (r3 != 5) goto L16;
        return NetworkType.TEMPORARILY_UNMETERED;
    L16:
        throw new IllegalArgumentException("Could not convert " + r3 + " to NetworkType");
    L23:
        return NetworkType.METERED;
    L24:
        return NetworkType.NOT_ROAMING;
    L25:
        return NetworkType.UNMETERED;
    L26:
        return NetworkType.CONNECTED;
    L22:
        return NetworkType.NOT_REQUIRED;
    }

    @JvmStatic
    public static final int outOfQuotaPolicyToInt(OutOfQuotaPolicy r2) {
        Intrinsics.checkNotNullParameter(r2, "policy");
        int r3 = WhenMappings.$EnumSwitchMapping$3[r2.ordinal()];
        if (r3 != 1) goto L5;
        return 0;
    L5:
        if (r3 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final OutOfQuotaPolicy intToOutOfQuotaPolicy(int r3) {
        if (r3 == 0) goto L9;
        if (r3 != 1) goto L7;
        return OutOfQuotaPolicy.DROP_WORK_REQUEST;
    L7:
        throw new IllegalArgumentException("Could not convert " + r3 + " to OutOfQuotaPolicy");
    L9:
        return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
    }

    @JvmStatic
    public static final byte[] setOfTriggersToByteArray(Set<Constraints.ContentUriTrigger> r6) {
        Intrinsics.checkNotNullParameter(r6, "triggers");
        if (r6.isEmpty() == true) goto L5;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        ByteArrayOutputStream r1 = r0;
        ByteArrayOutputStream r2 = r1;     // Catch: Throwable -> L22
        ObjectOutputStream r3 = new ObjectOutputStream(r0);     // Catch: Throwable -> L22
        ObjectOutputStream r4 = r3;     // Catch: Throwable -> L17
        r4.writeInt(r6.size());     // Catch: Throwable -> L17
        Iterator<Constraints.ContentUriTrigger> r7 = r6.iterator();     // Catch: Throwable -> L17
    L10:
        if (r7.hasNext() == false) goto L12;
        Constraints.ContentUriTrigger r5 = r7.next();     // Catch: Throwable -> L17
        r4.writeUTF(r5.getUri().toString());     // Catch: Throwable -> L17
        r4.writeBoolean(r5.isTriggeredForDescendants());     // Catch: Throwable -> L17
        goto L10
    L12:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L14:
        CloseableKt.closeFinally(r3, null);     // Catch: Throwable -> L22
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r1, null);
        byte[] r10 = r0.toByteArray();
        Intrinsics.checkNotNullExpressionValue(r10, "outputStream.toByteArray()");
        return r10;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    L5:
        return new byte[0];
    }

    @JvmStatic
    public static final Set<Constraints.ContentUriTrigger> byteArrayToSetOfTriggers(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        LinkedHashSet r0 = new LinkedHashSet();
        int r2 = 0;
        if (r10.length != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return r0;
    L8:
        ByteArrayInputStream r3 = new ByteArrayInputStream(r10);
        ByteArrayInputStream r11 = r3;
        ByteArrayInputStream r4 = r11;     // Catch: Throwable -> L28
        ObjectInputStream r5 = new ObjectInputStream(r3);     // Catch: IOException -> L23 Throwable -> L28
        ObjectInputStream r6 = r5;     // Catch: Throwable -> L18
        int r7 = r6.readInt();     // Catch: Throwable -> L18
    L13:
        if (r2 >= r7) goto L15;
        Uri r8 = Uri.parse(r6.readUTF());     // Catch: Throwable -> L18
        boolean r9 = r6.readBoolean();     // Catch: Throwable -> L18
        Intrinsics.checkNotNullExpressionValue(r8, "uri");     // Catch: Throwable -> L18
        r0.add(new Constraints.ContentUriTrigger(r8, r9));     // Catch: Throwable -> L18
        r2 = r2 + 1;     // Catch: Throwable -> L18
        goto L13
    L15:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r5, null);     // Catch: IOException -> L23 Throwable -> L28
    L25:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r11, null);
        return r0;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: IOException -> L23 Throwable -> L28
        throw th;     // Catch: IOException -> L23 Throwable -> L28
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L5:
        r1 = false;
        goto L6
    }
}
