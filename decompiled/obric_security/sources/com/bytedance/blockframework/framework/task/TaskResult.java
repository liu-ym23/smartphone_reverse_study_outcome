package com.bytedance.blockframework.framework.task;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Task.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00028\u0000X\u0086.¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/blockframework/framework/task/TaskResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TaskResult<T> {
    public T value;

    public TaskResult() {
    }

    public final T getValue() {
        T r0 = this.value;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("value");
        return (T) Unit.INSTANCE;
    }

    public final void setValue(T r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.value = r2;
    }
}
