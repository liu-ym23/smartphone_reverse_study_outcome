package com.bytedance.apm.trace.api.wrapper;

import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.apm.trace.api.TracingMode;
import com.bytedance.apm.trace.model.wrapper.ParallelTracingWrapper;
import com.bytedance.apm.trace.model.wrapper.SerialTracingWrapper;

/* JADX INFO: loaded from: classes.dex */
public class TracingWrapperFactory {

    /* JADX INFO: renamed from: com.bytedance.apm.trace.api.wrapper.TracingWrapperFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$apm$trace$api$wrapper$TracingWrapperMode = null;

        static {
            int[] r0 = new int[TracingWrapperMode.values().length];
            $SwitchMap$com$bytedance$apm$trace$api$wrapper$TracingWrapperMode = r0;
            r0[TracingWrapperMode.PARALLEL_WRAPPER_MODE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$apm$trace$api$wrapper$TracingWrapperMode[TracingWrapperMode.SERIAL_WRAPPER_MODE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public TracingWrapperFactory() {
    }

    public static ITracingWrapper create(String r1, TracingMode r2, TracingWrapperMode r3) {
        return create(r1, r2, r3, false);
    }

    public static ITracingWrapper create(String r1, TracingMode r2, TracingWrapperMode r3, boolean r4) {
        int r5 = AnonymousClass1.$SwitchMap$com$bytedance$apm$trace$api$wrapper$TracingWrapperMode[r3.ordinal()];
        if (r5 == 1) goto L11;
        if (r5 == 2) goto L9;
        return null;
    L9:
        return new SerialTracingWrapper(new TracingContext(r1, r2, r4));
    L11:
        return new ParallelTracingWrapper(new TracingContext(r1, r2, r4));
    }
}
