package com.obric.taskmanager;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TaskManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/taskmanager/TaskWithCallback;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/Callable;", "()V", "onError", "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class TaskWithCallback<T> implements Callable<T> {
    public void onError(Exception r1) {
        Intrinsics.checkNotNullParameter(r1, "error");
    }

    public void onSuccess(Object r1) {
    }

    public TaskWithCallback() {
    }
}
