package com.obric.matrix.opush.base.network;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/opush/base/network/ITaskAfterNetworkAvailableService;", "", "addNetworkAvailableListener", "", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", TypedValues.Custom.S_BOOLEAN, "addTaskAfterNetworkAvailable", "runnable", "Ljava/lang/Runnable;", "init", "context", "Landroid/content/Context;", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface c {
    void a(Runnable r1);

    void init(Context r1);
}
