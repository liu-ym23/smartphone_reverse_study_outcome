package com.obric.matrix.sdk.push.cross_process;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.obric.matrix.push.common.cross_process.ICrossProcessInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class CrossProcessService extends Service {

    @Nullable
    private ICrossProcessInterface.Stub mBinder;

    public CrossProcessService() {
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent r1) {
        if (this.mBinder != null) goto L6;
        registerCrossProcessMethod();
        this.mBinder = new AnonymousClass1(this);
    L6:
        return this.mBinder;
    }

    public abstract void registerCrossProcessMethod();
}
