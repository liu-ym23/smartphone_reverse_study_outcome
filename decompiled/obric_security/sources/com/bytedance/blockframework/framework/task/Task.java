package com.bytedance.blockframework.framework.task;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: Task.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\b\u0010\u0010\u001a\u00020\u0011H&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/blockframework/framework/task/Task;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/bytedance/blockframework/framework/task/ScheduleTask;", "mustMainThread", "", "getMustMainThread", "()Z", "result", "Lcom/bytedance/blockframework/framework/task/TaskResult;", "getResult", "()Lcom/bytedance/blockframework/framework/task/TaskResult;", "taskPriority", "", "getTaskPriority", "()I", "run", "", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface Task<T> extends ScheduleTask {
    @Override // com.bytedance.blockframework.framework.task.ScheduleTask
    boolean getMustMainThread();

    TaskResult<T> getResult();

    @Override // com.bytedance.blockframework.framework.task.ScheduleTask
    int getTaskPriority();

    @Override // com.bytedance.blockframework.framework.task.ScheduleTask
    void run();
}
