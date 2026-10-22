package androidx.work.impl.model;

import androidx.arch.core.util.Function;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.tracing.internal.TracingConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: WorkSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 J2\u00020\u0001:\u0003JKLB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0000¢\u0006\u0002\u0010\bBË\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0003\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020\u0017\u0012\b\b\u0002\u0010#\u001a\u00020\u0017¢\u0006\u0002\u0010$J\u0006\u0010-\u001a\u00020\u0011J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0015HÆ\u0003J\t\u00100\u001a\u00020\u0017HÆ\u0003J\t\u00101\u001a\u00020\u0019HÆ\u0003J\t\u00102\u001a\u00020\u0011HÆ\u0003J\t\u00103\u001a\u00020\u0011HÆ\u0003J\t\u00104\u001a\u00020\u0011HÆ\u0003J\t\u00105\u001a\u00020\u0011HÆ\u0003J\t\u00106\u001a\u00020\u001fHÆ\u0003J\t\u00107\u001a\u00020!HÆ\u0003J\t\u00108\u001a\u00020\u0017HÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003J\t\u0010:\u001a\u00020\u0017HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u000eHÆ\u0003J\t\u0010?\u001a\u00020\u0011HÆ\u0003J\t\u0010@\u001a\u00020\u0011HÆ\u0003J\t\u0010A\u001a\u00020\u0011HÆ\u0003JÓ\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00172\b\b\u0002\u0010#\u001a\u00020\u0017HÆ\u0001J\u0013\u0010C\u001a\u00020\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010D\u001a\u00020\u001fJ\t\u0010E\u001a\u00020\u0017HÖ\u0001J\u000e\u0010F\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020\u0011J\u000e\u0010H\u001a\u00020G2\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010H\u001a\u00020G2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J\b\u0010I\u001a\u00020\u0003H\u0016R\u0012\u0010\u001a\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b)\u0010(R\u0012\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010,R\u0012\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Landroidx/work/impl/model/WorkSpec;", "", SlardarConfigConsts.CONFIG_ID, "", "workerClassName_", "(Ljava/lang/String;Ljava/lang/String;)V", "newId", "other", "(Ljava/lang/String;Landroidx/work/impl/model/WorkSpec;)V", "state", "Landroidx/work/WorkInfo$State;", "workerClassName", "inputMergerClassName", "input", "Landroidx/work/Data;", "output", "initialDelay", "", "intervalDuration", "flexDuration", "constraints", "Landroidx/work/Constraints;", "runAttemptCount", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "backoffDelayDuration", "lastEnqueueTime", "minimumRetentionDuration", "scheduleRequestedAt", "expedited", "", "outOfQuotaPolicy", "Landroidx/work/OutOfQuotaPolicy;", "periodCount", "generation", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Ljava/lang/String;Ljava/lang/String;Landroidx/work/Data;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJJJZLandroidx/work/OutOfQuotaPolicy;II)V", "getGeneration", "()I", "isBackedOff", "()Z", "isPeriodic", "getPeriodCount", "setPeriodCount", "(I)V", "calculateNextRunTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "hasConstraints", "hashCode", "setBackoffDelayDuration", "", "setPeriodic", "toString", "Companion", "IdAndState", "WorkInfoPojo", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WorkSpec {
    public static final Companion Companion = null;
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    private static final String TAG = null;
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER = null;
    public long backoffDelayDuration;
    public BackoffPolicy backoffPolicy;
    public Constraints constraints;
    public boolean expedited;
    public long flexDuration;
    private final int generation;
    public final String id;
    public long initialDelay;
    public Data input;
    public String inputMergerClassName;
    public long intervalDuration;
    public long lastEnqueueTime;
    public long minimumRetentionDuration;
    public OutOfQuotaPolicy outOfQuotaPolicy;
    public Data output;
    private int periodCount;
    public int runAttemptCount;
    public long scheduleRequestedAt;
    public WorkInfo.State state;
    public String workerClassName;

    /* JADX INFO: compiled from: WorkSpec.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/work/impl/model/WorkSpec$Companion;", "", "()V", "SCHEDULE_NOT_REQUESTED_YET", "", "TAG", "", "WORK_INFO_MAPPER", "Landroidx/arch/core/util/Function;", "", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "Landroidx/work/WorkInfo;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: WorkSpec.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/work/impl/model/WorkSpec$IdAndState;", "", SlardarConfigConsts.CONFIG_ID, "", "state", "Landroidx/work/WorkInfo$State;", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class IdAndState {
        public String id;
        public WorkInfo.State state;

        public static /* synthetic */ IdAndState copy$default(IdAndState r0, String r1, WorkInfo.State r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.id;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.state;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.id;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final IdAndState copy(String r1, WorkInfo.State r2) {
            Intrinsics.checkNotNullParameter(r1, SlardarConfigConsts.CONFIG_ID);
            Intrinsics.checkNotNullParameter(r2, "state");
            return new IdAndState(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof IdAndState) == true) goto L8;
            return false;
        L8:
            IdAndState r6 = (IdAndState) r5;
            if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
            return false;
        L12:
            if (this.state == r6.state) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.state.hashCode();
        }

        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + this.state + ')';
        }

        public IdAndState(String r2, WorkInfo.State r3) {
            Intrinsics.checkNotNullParameter(r2, SlardarConfigConsts.CONFIG_ID);
            Intrinsics.checkNotNullParameter(r3, "state");
            this.id = r2;
            this.state = r3;
        }
    }

    /* JADX INFO: compiled from: WorkSpec.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f¢\u0006\u0002\u0010\u000eJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\fHÆ\u0003J[\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\fHÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\tHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001J\u0006\u00103\u001a\u000204R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001c¨\u00065"}, d2 = {"Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "", SlardarConfigConsts.CONFIG_ID, "", "state", "Landroidx/work/WorkInfo$State;", "output", "Landroidx/work/Data;", "runAttemptCount", "", "generation", TracingConstants.KEY_TAGS, "", "progress", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Landroidx/work/Data;IILjava/util/List;Ljava/util/List;)V", "getGeneration", "()I", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getOutput", "()Landroidx/work/Data;", "setOutput", "(Landroidx/work/Data;)V", "getProgress", "()Ljava/util/List;", "setProgress", "(Ljava/util/List;)V", "getRunAttemptCount", "setRunAttemptCount", "(I)V", "getState", "()Landroidx/work/WorkInfo$State;", "setState", "(Landroidx/work/WorkInfo$State;)V", "getTags", "setTags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "toWorkInfo", "Landroidx/work/WorkInfo;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class WorkInfoPojo {
        private final int generation;
        private String id;
        private Data output;
        private List<Data> progress;
        private int runAttemptCount;
        private WorkInfo.State state;
        private List<String> tags;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WorkInfoPojo copy$default(WorkInfoPojo r5, String r6, WorkInfo.State r7, Data r8, int r9, int r10, List r11, List r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r6 = r5.id;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r7 = r5.state;
        L8:
            WorkInfo.State r15 = r7;
            if ((r13 & 4) == 0) goto L11;
            r8 = r5.output;
        L11:
            Data r0 = r8;
            if ((r13 & 8) == 0) goto L14;
            r9 = r5.runAttemptCount;
        L14:
            int r1 = r9;
            if ((r13 & 16) == 0) goto L17;
            r10 = r5.generation;
        L17:
            int r2 = r10;
            if ((r13 & 32) == 0) goto L20;
            r11 = r5.tags;
        L20:
            List r3 = r11;
            if ((r13 & 64) == 0) goto L23;
            r12 = r5.progress;
        L23:
            String r16 = r6;
            return r5.copy(r16, r15, r0, r1, r2, r3, r12);
        }

        public final String component1() {
            return this.id;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final Data component3() {
            return this.output;
        }

        public final int component4() {
            return this.runAttemptCount;
        }

        public final int component5() {
            return this.generation;
        }

        public final List<String> component6() {
            return this.tags;
        }

        public final List<Data> component7() {
            return this.progress;
        }

        public final WorkInfoPojo copy(String r9, WorkInfo.State r10, Data r11, int r12, int r13, List<String> r14, List<Data> r15) {
            Intrinsics.checkNotNullParameter(r9, SlardarConfigConsts.CONFIG_ID);
            Intrinsics.checkNotNullParameter(r10, "state");
            Intrinsics.checkNotNullParameter(r11, "output");
            Intrinsics.checkNotNullParameter(r14, TracingConstants.KEY_TAGS);
            Intrinsics.checkNotNullParameter(r15, "progress");
            return new WorkInfoPojo(r9, r10, r11, r12, r13, r14, r15);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof WorkInfoPojo) == true) goto L8;
            return false;
        L8:
            WorkInfoPojo r6 = (WorkInfoPojo) r5;
            if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
            return false;
        L12:
            if (this.state == r6.state) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.output, r6.output) == true) goto L18;
            return false;
        L18:
            if (this.runAttemptCount == r6.runAttemptCount) goto L21;
            return false;
        L21:
            if (this.generation == r6.generation) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.tags, r6.tags) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.progress, r6.progress) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            return (((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.output.hashCode()) * 31) + Integer.hashCode(this.runAttemptCount)) * 31) + Integer.hashCode(this.generation)) * 31) + this.tags.hashCode()) * 31) + this.progress.hashCode();
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.id + ", state=" + this.state + ", output=" + this.output + ", runAttemptCount=" + this.runAttemptCount + ", generation=" + this.generation + ", tags=" + this.tags + ", progress=" + this.progress + ')';
        }

        public WorkInfoPojo(String r2, WorkInfo.State r3, Data r4, int r5, int r6, List<String> r7, List<Data> r8) {
            Intrinsics.checkNotNullParameter(r2, SlardarConfigConsts.CONFIG_ID);
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "output");
            Intrinsics.checkNotNullParameter(r7, TracingConstants.KEY_TAGS);
            Intrinsics.checkNotNullParameter(r8, "progress");
            this.id = r2;
            this.state = r3;
            this.output = r4;
            this.runAttemptCount = r5;
            this.generation = r6;
            this.tags = r7;
            this.progress = r8;
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.id = r2;
        }

        public final WorkInfo.State getState() {
            return this.state;
        }

        public final void setState(WorkInfo.State r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.state = r2;
        }

        public final Data getOutput() {
            return this.output;
        }

        public final void setOutput(Data r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.output = r2;
        }

        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        public final void setRunAttemptCount(int r1) {
            this.runAttemptCount = r1;
        }

        public final int getGeneration() {
            return this.generation;
        }

        public final List<String> getTags() {
            return this.tags;
        }

        public final void setTags(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.tags = r2;
        }

        public final List<Data> getProgress() {
            return this.progress;
        }

        public final void setProgress(List<Data> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.progress = r2;
        }

        public final WorkInfo toWorkInfo() {
            if ((!this.progress.isEmpty()) == false) goto L5;
            Data r0 = this.progress.get(0);
        L7:
            return new WorkInfo(UUID.fromString(this.id), this.state, this.output, this.tags, r0, this.runAttemptCount, this.generation);
        L5:
            r0 = Data.EMPTY;
            goto L7
        }
    }

    public static /* synthetic */ List $r8$lambda$y9atJMoLCgYQy678LpcIhQEVh6Q(List r0) {
        return WORK_INFO_MAPPER$lambda$1(r0);
    }

    public static /* synthetic */ WorkSpec copy$default(WorkSpec r17, String r18, WorkInfo.State r19, String r20, String r21, Data r22, Data r23, long r24, long r26, long r28, Constraints r30, int r31, BackoffPolicy r32, long r33, long r35, long r37, long r39, boolean r41, OutOfQuotaPolicy r42, int r43, int r44, int r45, Object r46) {
        if ((r45 & 1) == 0) goto L5;
        String r2 = r17.id;
    L7:
        if ((r45 & 2) == 0) goto L9;
        WorkInfo.State r3 = r17.state;
    L11:
        if ((r45 & 4) == 0) goto L13;
        String r4 = r17.workerClassName;
    L15:
        if ((r45 & 8) == 0) goto L17;
        String r5 = r17.inputMergerClassName;
    L19:
        if ((r45 & 16) == 0) goto L21;
        Data r6 = r17.input;
    L23:
        if ((r45 & 32) == 0) goto L25;
        Data r7 = r17.output;
    L27:
        if ((r45 & 64) == 0) goto L29;
        long r8 = r17.initialDelay;
    L31:
        if ((r45 & 128) == 0) goto L33;
        long r10 = r17.intervalDuration;
    L35:
        if ((r45 & 256) == 0) goto L37;
        long r12 = r17.flexDuration;
    L39:
        if ((r45 & 512) == 0) goto L41;
        Constraints r14 = r17.constraints;
    L43:
        if ((r45 & 1024) == 0) goto L45;
        int r15 = r17.runAttemptCount;
    L46:
        int r34 = r15;
        if ((r45 & 2048) == 0) goto L49;
        BackoffPolicy r16 = r17.backoffPolicy;
    L50:
        BackoffPolicy r36 = r16;
        Constraints r38 = r14;
        if ((r45 & 4096) == 0) goto L53;
        long r110 = r17.backoffDelayDuration;
    L54:
        long r310 = r110;
        if ((r45 & 8192) == 0) goto L57;
        long r111 = r17.lastEnqueueTime;
    L58:
        long r311 = r111;
        if ((r45 & 16384) == 0) goto L61;
        long r112 = r17.minimumRetentionDuration;
    L62:
        long r312 = r112;
        if ((r45 & 32768) == 0) goto L65;
        long r113 = r17.scheduleRequestedAt;
    L66:
        long r313 = r113;
        if ((r45 & 65536) == 0) goto L69;
        boolean r114 = r17.expedited;
    L71:
        if ((131072 & r45) == 0) goto L73;
        OutOfQuotaPolicy r115 = r17.outOfQuotaPolicy;
    L74:
        OutOfQuotaPolicy r47 = r115;
        if ((r45 & 262144) == 0) goto L77;
        int r116 = r17.periodCount;
    L79:
        if ((r45 & 524288) == 0) goto L81;
        int r1 = r17.generation;
    L83:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r10, r12, r38, r34, r36, r310, r311, r312, r313, r114, r47, r116, r1);
    L81:
        r1 = r44;
        goto L83
    L77:
        r116 = r43;
        goto L79
    L73:
        r115 = r42;
        goto L74
    L69:
        r114 = r41;
        goto L71
    L65:
        r113 = r39;
        goto L66
    L61:
        r112 = r37;
        goto L62
    L57:
        r111 = r35;
        goto L58
    L53:
        r110 = r33;
        goto L54
    L49:
        r16 = r32;
        goto L50
    L45:
        r15 = r31;
        goto L46
    L41:
        r14 = r30;
        goto L43
    L37:
        r12 = r28;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final Constraints component10() {
        return this.constraints;
    }

    public final int component11() {
        return this.runAttemptCount;
    }

    public final BackoffPolicy component12() {
        return this.backoffPolicy;
    }

    public final long component13() {
        return this.backoffDelayDuration;
    }

    public final long component14() {
        return this.lastEnqueueTime;
    }

    public final long component15() {
        return this.minimumRetentionDuration;
    }

    public final long component16() {
        return this.scheduleRequestedAt;
    }

    public final boolean component17() {
        return this.expedited;
    }

    public final OutOfQuotaPolicy component18() {
        return this.outOfQuotaPolicy;
    }

    public final int component19() {
        return this.periodCount;
    }

    public final WorkInfo.State component2() {
        return this.state;
    }

    public final int component20() {
        return this.generation;
    }

    public final String component3() {
        return this.workerClassName;
    }

    public final String component4() {
        return this.inputMergerClassName;
    }

    public final Data component5() {
        return this.input;
    }

    public final Data component6() {
        return this.output;
    }

    public final long component7() {
        return this.initialDelay;
    }

    public final long component8() {
        return this.intervalDuration;
    }

    public final long component9() {
        return this.flexDuration;
    }

    public final WorkSpec copy(String r30, WorkInfo.State r31, String r32, String r33, Data r34, Data r35, long r36, long r38, long r40, Constraints r42, int r43, BackoffPolicy r44, long r45, long r47, long r49, long r51, boolean r53, OutOfQuotaPolicy r54, int r55, int r56) {
        Intrinsics.checkNotNullParameter(r30, SlardarConfigConsts.CONFIG_ID);
        Intrinsics.checkNotNullParameter(r31, "state");
        Intrinsics.checkNotNullParameter(r32, "workerClassName");
        Intrinsics.checkNotNullParameter(r34, "input");
        Intrinsics.checkNotNullParameter(r35, "output");
        Intrinsics.checkNotNullParameter(r42, "constraints");
        Intrinsics.checkNotNullParameter(r44, "backoffPolicy");
        Intrinsics.checkNotNullParameter(r54, "outOfQuotaPolicy");
        return new WorkSpec(r30, r31, r32, r33, r34, r35, r36, r38, r40, r42, r43, r44, r45, r47, r49, r51, r53, r54, r55, r56);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof WorkSpec) == true) goto L8;
        return false;
    L8:
        WorkSpec r9 = (WorkSpec) r8;
        if (Intrinsics.areEqual(this.id, r9.id) == true) goto L12;
        return false;
    L12:
        if (this.state == r9.state) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.workerClassName, r9.workerClassName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.inputMergerClassName, r9.inputMergerClassName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.input, r9.input) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.output, r9.output) == true) goto L27;
        return false;
    L27:
        if (this.initialDelay == r9.initialDelay) goto L30;
        return false;
    L30:
        if (this.intervalDuration == r9.intervalDuration) goto L33;
        return false;
    L33:
        if (this.flexDuration == r9.flexDuration) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.constraints, r9.constraints) == true) goto L39;
        return false;
    L39:
        if (this.runAttemptCount == r9.runAttemptCount) goto L42;
        return false;
    L42:
        if (this.backoffPolicy == r9.backoffPolicy) goto L45;
        return false;
    L45:
        if (this.backoffDelayDuration == r9.backoffDelayDuration) goto L48;
        return false;
    L48:
        if (this.lastEnqueueTime == r9.lastEnqueueTime) goto L51;
        return false;
    L51:
        if (this.minimumRetentionDuration == r9.minimumRetentionDuration) goto L54;
        return false;
    L54:
        if (this.scheduleRequestedAt == r9.scheduleRequestedAt) goto L57;
        return false;
    L57:
        if (this.expedited == r9.expedited) goto L60;
        return false;
    L60:
        if (this.outOfQuotaPolicy == r9.outOfQuotaPolicy) goto L63;
        return false;
    L63:
        if (this.periodCount == r9.periodCount) goto L66;
        return false;
    L66:
        if (this.generation == r9.generation) goto L68;
        return false;
    L68:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [int] */
    /* JADX WARN: Type inference failed for: r1v32, types: [int] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v39 */
    public int hashCode() {
        int r0 = ((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.workerClassName.hashCode()) * 31;
        String r1 = this.inputMergerClassName;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((((((((((((((((((((((((r0 + r2) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31) + Long.hashCode(this.initialDelay)) * 31) + Long.hashCode(this.intervalDuration)) * 31) + Long.hashCode(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + Integer.hashCode(this.runAttemptCount)) * 31) + this.backoffPolicy.hashCode()) * 31) + Long.hashCode(this.backoffDelayDuration)) * 31) + Long.hashCode(this.lastEnqueueTime)) * 31) + Long.hashCode(this.minimumRetentionDuration)) * 31) + Long.hashCode(this.scheduleRequestedAt)) * 31;
        boolean r4 = this.expedited;
        ?? r5 = r4;
        if (r4 == false) goto L10;
        r5 = 1;
    L10:
        return ((((((r3 + r5) * 31) + this.outOfQuotaPolicy.hashCode()) * 31) + Integer.hashCode(this.periodCount)) * 31) + Integer.hashCode(this.generation);
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public WorkSpec(String r11, WorkInfo.State r12, String r13, String r14, Data r15, Data r16, long r17, long r19, long r21, Constraints r23, int r24, BackoffPolicy r25, long r26, long r28, long r30, long r32, boolean r34, OutOfQuotaPolicy r35, int r36, int r37) {
        Intrinsics.checkNotNullParameter(r11, SlardarConfigConsts.CONFIG_ID);
        Intrinsics.checkNotNullParameter(r12, "state");
        Intrinsics.checkNotNullParameter(r13, "workerClassName");
        Intrinsics.checkNotNullParameter(r15, "input");
        Intrinsics.checkNotNullParameter(r16, "output");
        Intrinsics.checkNotNullParameter(r23, "constraints");
        Intrinsics.checkNotNullParameter(r25, "backoffPolicy");
        Intrinsics.checkNotNullParameter(r35, "outOfQuotaPolicy");
        this.id = r11;
        this.state = r12;
        this.workerClassName = r13;
        this.inputMergerClassName = r14;
        this.input = r15;
        this.output = r16;
        this.initialDelay = r17;
        this.intervalDuration = r19;
        this.flexDuration = r21;
        this.constraints = r23;
        this.runAttemptCount = r24;
        this.backoffPolicy = r25;
        this.backoffDelayDuration = r26;
        this.lastEnqueueTime = r28;
        this.minimumRetentionDuration = r30;
        this.scheduleRequestedAt = r32;
        this.expedited = r34;
        this.outOfQuotaPolicy = r35;
        this.periodCount = r36;
        this.generation = r37;
    }

    public /* synthetic */ WorkSpec(String r31, WorkInfo.State r32, String r33, String r34, Data r35, Data r36, long r37, long r39, long r41, Constraints r43, int r44, BackoffPolicy r45, long r46, long r48, long r50, long r52, boolean r54, OutOfQuotaPolicy r55, int r56, int r57, int r58, DefaultConstructorMarker r59) {
        if ((r58 & 2) == 0) goto L5;
        WorkInfo.State r4 = WorkInfo.State.ENQUEUED;
    L7:
        if ((r58 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r58 & 16) == 0) goto L13;
        Data r1 = Data.EMPTY;
        Intrinsics.checkNotNullExpressionValue(r1, "EMPTY");
        Data r7 = r1;
    L15:
        if ((r58 & 32) == 0) goto L17;
        Data r2 = Data.EMPTY;
        Intrinsics.checkNotNullExpressionValue(r2, "EMPTY");
        Data r8 = r2;
    L19:
        if ((r58 & 64) == 0) goto L21;
        long r9 = 0;
    L23:
        if ((r58 & 128) == 0) goto L25;
        long r11 = 0;
    L27:
        if ((r58 & 256) == 0) goto L29;
        long r13 = 0;
    L31:
        if ((r58 & 512) == 0) goto L33;
        Constraints r15 = Constraints.NONE;
    L35:
        if ((r58 & 1024) == 0) goto L37;
        int r16 = 0;
    L39:
        if ((r58 & 2048) == 0) goto L41;
        BackoffPolicy r17 = BackoffPolicy.EXPONENTIAL;
    L43:
        if ((r58 & 4096) == 0) goto L45;
        long r18 = 30000;
    L47:
        if ((r58 & 8192) == 0) goto L49;
        long r20 = 0;
    L51:
        if ((r58 & 16384) == 0) goto L53;
        long r22 = 0;
    L55:
        if ((32768 & r58) == 0) goto L57;
        long r24 = -1;
    L59:
        if ((65536 & r58) == 0) goto L61;
        boolean r26 = false;
    L63:
        if ((131072 & r58) == 0) goto L65;
        OutOfQuotaPolicy r27 = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
    L67:
        if ((262144 & r58) == 0) goto L69;
        int r28 = 0;
    L71:
        if ((r58 & 524288) == 0) goto L73;
        int r29 = 0;
    L74:
        this(r31, r4, r33, r6, r7, r8, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24, r26, r27, r28, r29);
        return;
    L73:
        r29 = r57;
        goto L74
    L69:
        r28 = r56;
        goto L71
    L65:
        r27 = r55;
        goto L67
    L61:
        r26 = r54;
        goto L63
    L57:
        r24 = r52;
        goto L59
    L53:
        r22 = r50;
        goto L55
    L49:
        r20 = r48;
        goto L51
    L45:
        r18 = r46;
        goto L47
    L41:
        r17 = r45;
        goto L43
    L37:
        r16 = r44;
        goto L39
    L33:
        r15 = r43;
        goto L35
    L29:
        r13 = r41;
        goto L31
    L25:
        r11 = r39;
        goto L27
    L21:
        r9 = r37;
        goto L23
    L17:
        r8 = r36;
        goto L19
    L13:
        r7 = r35;
        goto L15
    L9:
        r6 = r34;
        goto L11
    L5:
        r4 = r32;
        goto L7
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final void setPeriodCount(int r1) {
        this.periodCount = r1;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public WorkSpec(String r31, String r32) {
        Intrinsics.checkNotNullParameter(r31, SlardarConfigConsts.CONFIG_ID);
        Intrinsics.checkNotNullParameter(r32, "workerClassName_");
        this(r31, null, r32, null, null, null, 0, 0, 0, null, 0, null, 0, 0, 0, 0, false, null, 0, 0, 1048570, null);
    }

    public WorkSpec(String r33, WorkSpec r34) {
        Intrinsics.checkNotNullParameter(r33, "newId");
        Intrinsics.checkNotNullParameter(r34, "other");
        String r4 = r34.workerClassName;
        this(r33, r34.state, r4, r34.inputMergerClassName, new Data(r34.input), new Data(r34.output), r34.initialDelay, r34.intervalDuration, r34.flexDuration, new Constraints(r34.constraints), r34.runAttemptCount, r34.backoffPolicy, r34.backoffDelayDuration, r34.lastEnqueueTime, r34.minimumRetentionDuration, r34.scheduleRequestedAt, r34.expedited, r34.outOfQuotaPolicy, r34.periodCount, 0, 524288, null);
    }

    public final void setBackoffDelayDuration(long r10) {
        if (r10 <= WorkRequest.MAX_BACKOFF_MILLIS) goto L6;
        Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value");
    L6:
        if (r10 >= WorkRequest.MIN_BACKOFF_MILLIS) goto L8;
        Logger.get().warning(TAG, "Backoff delay duration less than minimum value");
    L8:
        this.backoffDelayDuration = RangesKt.coerceIn(r10, WorkRequest.MIN_BACKOFF_MILLIS, WorkRequest.MAX_BACKOFF_MILLIS);
    }

    public final boolean isPeriodic() {
        if (this.intervalDuration == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isBackedOff() {
        if (this.state == WorkInfo.State.ENQUEUED) goto L5;
    L7:
        return false;
    L5:
        if (this.runAttemptCount <= 0) goto L7;
        return true;
    }

    public final void setPeriodic(long r6) {
        if (r6 >= 900000) goto L5;
        Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
    L5:
        setPeriodic(RangesKt.coerceAtLeast(r6, 900000), RangesKt.coerceAtLeast(r6, 900000));
    }

    public final void setPeriodic(long r9, long r11) {
        if (r9 >= 900000) goto L5;
        Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
    L5:
        this.intervalDuration = RangesKt.coerceAtLeast(r9, 900000);
        if (r11 >= 300000) goto L9;
        Logger.get().warning(TAG, "Flex duration lesser than minimum allowed value; Changed to 300000");
    L9:
        if (r11 <= this.intervalDuration) goto L11;
        Logger.get().warning(TAG, "Flex duration greater than interval duration; Changed to " + r9);
    L11:
        this.flexDuration = RangesKt.coerceIn(r11, 300000, this.intervalDuration);
    }

    public final long calculateNextRunTime() {
        boolean r1 = false;
        if (isBackedOff() == true) goto L5;
        long r3 = 0;
        if (isPeriodic() == false) goto L27;
        int r0 = this.periodCount;
        long r5 = this.lastEnqueueTime;
        if (r0 != 0) goto L16;
        r5 = r5 + this.initialDelay;
    L16:
        long r7 = this.flexDuration;
        long r9 = this.intervalDuration;
        if (r7 == r9) goto L19;
        r1 = true;
    L19:
        if (r1 == false) goto L23;
        if (r0 != 0) goto L22;
        r3 = ((long) (-1)) * r7;
    L22:
        r5 = r5 + r9;
    L33:
        return r5 + r3;
    L23:
        if (r0 == 0) goto L33;
        r3 = r9;
        goto L33
    L27:
        long r2 = this.lastEnqueueTime;
        if (r2 != 0) goto L31;
        r2 = System.currentTimeMillis();
    L31:
        return this.initialDelay + r2;
    L5:
        if (this.backoffPolicy != BackoffPolicy.LINEAR) goto L7;
        r1 = true;
    L7:
        if (r1 == false) goto L9;
        long r4 = this.backoffDelayDuration * ((long) this.runAttemptCount);
    L32:
        return this.lastEnqueueTime + RangesKt.coerceAtMost(r4, WorkRequest.MAX_BACKOFF_MILLIS);
    L9:
        r4 = (long) Math.scalb(this.backoffDelayDuration, this.runAttemptCount - 1);
        goto L32
    }

    public final boolean hasConstraints() {
        return !Intrinsics.areEqual(Constraints.NONE, this.constraints);
    }

    public String toString() {
        return "{WorkSpec: " + this.id + '}';
    }

    static {
        Companion = new Companion(null);
        String r0 = Logger.tagWithPrefix("WorkSpec");
        Intrinsics.checkNotNullExpressionValue(r0, "tagWithPrefix(\"WorkSpec\")");
        TAG = r0;
        WORK_INFO_MAPPER = new WorkSpec$$ExternalSyntheticLambda0();
    }

    private static final List WORK_INFO_MAPPER$lambda$1(List r2) {
        if (r2 == null) goto L8;
        List r3 = r2;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r4 = r3.iterator();
    L5:
        if (r4.hasNext() == false) goto L11;
        r0.add(((WorkInfoPojo) r4.next()).toWorkInfo());
        goto L5
    L11:
        return r0;
    L8:
        return null;
    }
}
