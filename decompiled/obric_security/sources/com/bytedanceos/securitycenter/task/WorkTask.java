package com.bytedanceos.securitycenter.task;

import android.content.Context;
import android.os.AsyncTask;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WorkTask {
    private long mFinishTime;
    private long mStartTime;
    private TaskStatus mStatus;
    private TaskResult mTaskResult;
    private WorkListener mWorkListener;

    public static final enum TaskResult extends Enum<TaskResult> {
        private static final /* synthetic */ TaskResult[] $VALUES = null;
        public static final TaskResult FAILED = null;
        public static final TaskResult SUCCESS = null;

        private static /* synthetic */ TaskResult[] $values() {
            return new TaskResult[]{SUCCESS, FAILED};
        }

        private TaskResult(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static TaskResult valueOf(String name) {
            return (TaskResult) Enum.valueOf(TaskResult.class, name);
        }

        public static TaskResult[] values() {
            return (TaskResult[]) $VALUES.clone();
        }

        static {
            SUCCESS = new TaskResult("SUCCESS", 0);
            FAILED = new TaskResult("FAILED", 1);
            $VALUES = $values();
        }
    }

    public static final enum TaskStatus extends Enum<TaskStatus> {
        private static final /* synthetic */ TaskStatus[] $VALUES = null;
        public static final TaskStatus FINISHED = null;
        public static final TaskStatus STARTED = null;

        private static /* synthetic */ TaskStatus[] $values() {
            return new TaskStatus[]{STARTED, FINISHED};
        }

        private TaskStatus(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static TaskStatus valueOf(String name) {
            return (TaskStatus) Enum.valueOf(TaskStatus.class, name);
        }

        public static TaskStatus[] values() {
            return (TaskStatus[]) $VALUES.clone();
        }

        static {
            STARTED = new TaskStatus("STARTED", 0);
            FINISHED = new TaskStatus("FINISHED", 1);
            $VALUES = $values();
        }
    }

    public interface WorkListener {
        void onWorkFinish(WorkTask wk);

        void onWorkStart(WorkTask wk);
    }

    public static final enum WorkType extends Enum<WorkType> {
        private static final /* synthetic */ WorkType[] $VALUES = null;
        public static final WorkType CLEAN = null;
        public static final WorkType NONE = null;
        public static final WorkType SCAN = null;

        private static /* synthetic */ WorkType[] $values() {
            return new WorkType[]{NONE, SCAN, CLEAN};
        }

        private WorkType(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static WorkType valueOf(String name) {
            return (WorkType) Enum.valueOf(WorkType.class, name);
        }

        public static WorkType[] values() {
            return (WorkType[]) $VALUES.clone();
        }

        static {
            NONE = new WorkType("NONE", 0);
            SCAN = new WorkType("SCAN", 1);
            CLEAN = new WorkType("CLEAN", 2);
            $VALUES = $values();
        }
    }

    protected abstract void excute(WorkType type);

    public void onCreate(Context context) {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public WorkTask() {
    }

    public void excuteTask(final WorkType type) {
        this.mStatus = TaskStatus.STARTED;
        this.mStartTime = System.currentTimeMillis();
        WorkListener r0 = this.mWorkListener;
        if (r0 == null) goto L5;
        r0.onWorkStart(this);
    L5:
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new AnonymousClass1(this, type));
    }

    protected void reportFinish(TaskResult result) {
        this.mStatus = TaskStatus.FINISHED;
        this.mTaskResult = result;
        this.mFinishTime = System.currentTimeMillis();
        WorkListener r3 = this.mWorkListener;
        if (r3 == null) goto L6;
        r3.onWorkFinish(this);
        return;
    }

    public void onDestory(Context context) {
        this.mWorkListener = null;
    }

    public void setWorkListener(WorkListener listener) {
        this.mWorkListener = listener;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public void setStartTime(long startTime) {
        this.mStartTime = startTime;
    }

    public long getFinishTime() {
        return this.mFinishTime;
    }

    public void setFinishTime(long finishTime) {
        this.mFinishTime = finishTime;
    }

    public boolean isStarted() {
        if (this.mStatus != TaskStatus.STARTED) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFinished() {
        if (this.mStatus != TaskStatus.FINISHED) goto L5;
        return true;
    L5:
        return false;
    }

    public TaskResult getTaskResult() {
        return this.mTaskResult;
    }
}
