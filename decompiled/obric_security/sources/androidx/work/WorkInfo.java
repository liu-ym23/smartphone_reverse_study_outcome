package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: loaded from: classes.dex */
public final class WorkInfo {
    private final int mGeneration;
    private UUID mId;
    private Data mOutputData;
    private Data mProgress;
    private int mRunAttemptCount;
    private State mState;
    private Set<String> mTags;

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State BLOCKED = null;
        public static final State CANCELLED = null;
        public static final State ENQUEUED = null;
        public static final State FAILED = null;
        public static final State RUNNING = null;
        public static final State SUCCEEDED = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{ENQUEUED, RUNNING, SUCCEEDED, FAILED, BLOCKED, CANCELLED};
        }

        private State(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static State valueOf(String name) {
            return (State) Enum.valueOf(State.class, name);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            ENQUEUED = new State("ENQUEUED", 0);
            RUNNING = new State(DebugCoroutineInfoImplKt.RUNNING, 1);
            SUCCEEDED = new State("SUCCEEDED", 2);
            FAILED = new State("FAILED", 3);
            BLOCKED = new State("BLOCKED", 4);
            CANCELLED = new State("CANCELLED", 5);
            $VALUES = $values();
        }

        public boolean isFinished() {
            if (this != SUCCEEDED) goto L5;
        L10:
            return true;
        L5:
            if (this == FAILED) goto L10;
            if (this == CANCELLED) goto L10;
            return false;
        }
    }

    public WorkInfo(UUID id, State state, Data outputData, List<String> tags, Data progress, int runAttemptCount, int generation) {
        this.mId = id;
        this.mState = state;
        this.mOutputData = outputData;
        this.mTags = new HashSet(tags);
        this.mProgress = progress;
        this.mRunAttemptCount = runAttemptCount;
        this.mGeneration = generation;
    }

    public UUID getId() {
        return this.mId;
    }

    public State getState() {
        return this.mState;
    }

    public Data getOutputData() {
        return this.mOutputData;
    }

    public Set<String> getTags() {
        return this.mTags;
    }

    public Data getProgress() {
        return this.mProgress;
    }

    public int getRunAttemptCount() {
        return this.mRunAttemptCount;
    }

    public int getGeneration() {
        return this.mGeneration;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L30:
        return false;
    L8:
        if (getClass() != o.getClass()) goto L30;
        WorkInfo r4 = (WorkInfo) o;
        if (this.mRunAttemptCount == r4.mRunAttemptCount) goto L14;
        return false;
    L14:
        if (this.mGeneration == r4.mGeneration) goto L17;
        return false;
    L17:
        if (this.mId.equals(r4.mId) == true) goto L20;
        return false;
    L20:
        if (this.mState == r4.mState) goto L23;
        return false;
    L23:
        if (this.mOutputData.equals(r4.mOutputData) == true) goto L26;
        return false;
    L26:
        if (this.mTags.equals(r4.mTags) == true) goto L29;
        return false;
    L29:
        return this.mProgress.equals(r4.mProgress);
    }

    public int hashCode() {
        return (((((((((((this.mId.hashCode() * 31) + this.mState.hashCode()) * 31) + this.mOutputData.hashCode()) * 31) + this.mTags.hashCode()) * 31) + this.mProgress.hashCode()) * 31) + this.mRunAttemptCount) * 31) + this.mGeneration;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.mId + "', mState=" + this.mState + ", mOutputData=" + this.mOutputData + ", mTags=" + this.mTags + ", mProgress=" + this.mProgress + '}';
    }
}
