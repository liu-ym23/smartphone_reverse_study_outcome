package com.bytedance.blockframework.framework.task;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ITaskManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&Jt\u0010\b\u001a\u00020\u00032\"\b\u0002\u0010\t\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\u0004\u0018\u0001`\u000b2\"\b\u0002\u0010\f\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\u0004\u0018\u0001`\u000b2\"\b\u0002\u0010\r\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\u0004\u0018\u0001`\u000bH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/blockframework/framework/task/ITaskManager;", "", "addTask", "", "tasks", "", "Lcom/bytedance/blockframework/framework/task/ScheduleTask;", "clear", "handleTasks", "mainFinished", "Lkotlin/Function1;", "Lcom/bytedance/blockframework/framework/task/TasksFinished;", "subFinished", "allFinished", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ITaskManager {

    /* JADX INFO: compiled from: ITaskManager.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void handleTasks$default(ITaskManager r1, Function1 r2, Function1 r3, Function1 r4, int r5, Object r6) {
            if (r6 != null) goto L15;
            if ((r5 & 1) == 0) goto L7;
            r2 = null;
        L7:
            if ((r5 & 2) == 0) goto L10;
            r3 = null;
        L10:
            if ((r5 & 4) == 0) goto L12;
            r4 = null;
        L12:
            r1.handleTasks(r2, r3, r4);
            return;
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleTasks");
        }
    }

    void addTask(List<? extends ScheduleTask> r1);

    void clear();

    void handleTasks(Function1<? super List<? extends ScheduleTask>, Unit> r1, Function1<? super List<? extends ScheduleTask>, Unit> r2, Function1<? super List<? extends ScheduleTask>, Unit> r3);
}
