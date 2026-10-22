package com.obric.security.ota;

import android.os.UpdateEngine;
import android.os.UpdateEngineCallback;
import com.obric.olog.OLog;
import kotlin.Metadata;

/* JADX INFO: compiled from: UpdateProgressManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/obric/security/ota/UpdateProgressManager;", "", "()V", "callBack", "Landroid/os/UpdateEngineCallback;", "updateEngine", "Landroid/os/UpdateEngine;", "getUpdateEngine", "()Landroid/os/UpdateEngine;", "setUpdateEngine", "(Landroid/os/UpdateEngine;)V", "bind", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdateProgressManager {
    private UpdateEngineCallback callBack;
    private UpdateEngine updateEngine;

    public UpdateProgressManager() {
        this.updateEngine = new UpdateEngine();
        this.callBack = new OtaUpdateEngineCallback();
    }

    public final UpdateEngine getUpdateEngine() {
        return this.updateEngine;
    }

    public final void setUpdateEngine(UpdateEngine r1) {
        this.updateEngine = r1;
    }

    public final void bind() {
        OLog.d("OceanDownloaderHelper", "bind");
        UpdateEngine r0 = this.updateEngine;
        if (r0 == null) goto L6;
        r0.bind(this.callBack);
        return;
    }
}
