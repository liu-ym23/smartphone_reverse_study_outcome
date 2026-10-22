package kotlinx.coroutines.debug;

import android.annotation.SuppressLint;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.lang.instrument.ClassFileTransformer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({WsChannelMultiProcessSharedProvider.ALL_TYPE})
public final class AgentPremain {

    @Metadata
    public static final class DebugProbesTransformer implements ClassFileTransformer {
        static {
        }
    }

    static {
        Object r0 = null;
        String r1 = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");     // Catch: Throwable -> L7
        if (r1 == null) goto L9;
        Object r2 = Boolean.valueOf(Boolean.parseBoolean(r1));     // Catch: Throwable -> L7
    L12:
        if ((r2 instanceof Result.Failure) == true) goto L16;
        r0 = r2;
    L16:
        if (((Boolean) r0) != null) goto L22;
        ConcurrentWeakMap r3 = DebugProbesImpl.f393a;
        return;
    L22:
        return;
    L9:
        r2 = null;
    L7:
        th = move-exception;
        r2 = ResultKt.a(th);
        goto L12
    }
}
