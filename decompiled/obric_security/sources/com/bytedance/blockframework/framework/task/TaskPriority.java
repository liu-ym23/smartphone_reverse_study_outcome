package com.bytedance.blockframework.framework.task;

import kotlin.Metadata;

/* JADX INFO: compiled from: ScheduleTask.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/blockframework/framework/task/TaskPriority;", "", "(Ljava/lang/String;I)V", "Low", "High", "Boot", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum TaskPriority extends Enum<TaskPriority> {
    private static final /* synthetic */ TaskPriority[] $VALUES = null;
    public static final TaskPriority Boot = null;
    public static final TaskPriority High = null;
    public static final TaskPriority Low = null;

    private static final /* synthetic */ TaskPriority[] $values() {
        return new TaskPriority[]{Low, High, Boot};
    }

    public static TaskPriority valueOf(String r1) {
        return (TaskPriority) Enum.valueOf(TaskPriority.class, r1);
    }

    public static TaskPriority[] values() {
        return (TaskPriority[]) $VALUES.clone();
    }

    private TaskPriority(String r1, int r2) {
        super(r1, r2);
    }

    static {
        Low = new TaskPriority("Low", 0);
        High = new TaskPriority("High", 1);
        Boot = new TaskPriority("Boot", 2);
        $VALUES = $values();
    }
}
