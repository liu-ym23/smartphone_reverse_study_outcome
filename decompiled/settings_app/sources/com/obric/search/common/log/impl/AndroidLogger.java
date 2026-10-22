package com.obric.search.common.log.impl;

import android.util.Log;
import com.obric.search.common.log.intf.ILogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidLogger.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/search/common/log/impl/AndroidLogger;", "Lcom/obric/search/common/log/intf/ILogger;", "()V", "debug", "", "tag", "", "message", "error", "info", "warn", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidLogger implements ILogger {
    public AndroidLogger() {
    }

    @Override // com.obric.search.common.log.intf.ILogger
    public void debug(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        Log.d(r1, r2);
    }

    @Override // com.obric.search.common.log.intf.ILogger
    public void info(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        Log.i(r1, r2);
    }

    @Override // com.obric.search.common.log.intf.ILogger
    public void warn(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        Log.w(r1, r2);
    }

    @Override // com.obric.search.common.log.intf.ILogger
    public void error(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        Log.e(r1, r2);
    }
}
