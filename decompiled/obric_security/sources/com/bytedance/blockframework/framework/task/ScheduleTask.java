package com.bytedance.blockframework.framework.task;

import kotlin.Metadata;

/* JADX INFO: compiled from: ScheduleTask.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/blockframework/framework/task/ScheduleTask;", "", "mustMainThread", "", "getMustMainThread", "()Z", "taskPriority", "", "getTaskPriority", "()I", "run", "", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ScheduleTask {
    boolean getMustMainThread();

    int getTaskPriority();

    void run();
}
