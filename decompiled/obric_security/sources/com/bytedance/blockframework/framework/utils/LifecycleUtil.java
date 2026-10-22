package com.bytedance.blockframework.framework.utils;

import androidx.lifecycle.Lifecycle;
import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.monitor.BlockLoggerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LifecycleUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b¨\u0006\t"}, d2 = {"Lcom/bytedance/blockframework/framework/utils/LifecycleUtil;", "", "()V", "handleLifecycleState", "", "state", "Landroidx/lifecycle/Lifecycle$State;", "block", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LifecycleUtil {
    public static final LifecycleUtil INSTANCE = null;

    /* JADX INFO: compiled from: LifecycleUtil.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Lifecycle.State.values().length];
            r0[Lifecycle.State.CREATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[Lifecycle.State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[Lifecycle.State.RESUMED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[Lifecycle.State.DESTROYED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new LifecycleUtil();
    }

    private LifecycleUtil() {
    }

    public final void handleLifecycleState(Lifecycle.State r2, BaseBlock<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "block");
        BlockLoggerKt.logger("LifecycleUtil", r2 + " --- " + r3.getBlockKey() + "---" + r3.getLifecycle().getCurrentState());
        int r1 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r1 == 1) goto L39;
        if (r1 == 2) goto L30;
        if (r1 == 3) goto L21;
        if (r1 == 4) goto L12;
        return;
    L12:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L15;
        r3.performPause();
    L15:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) < 0) goto L18;
        r3.performStop();
    L18:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) < 0) goto L48;
        r3.performDestroy();
        return;
    L48:
        return;
    L21:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L23;
        return;
    L23:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L26;
        r3.performCreate();
    L26:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) >= 0) goto L28;
        r3.performStart();
    L28:
        r3.performResume();
        return;
    L30:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) >= 0) goto L36;
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L34;
        r3.performCreate();
    L34:
        r3.performStart();
        return;
    L36:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) <= 0) goto L53;
        r3.performPause();
        return;
    L53:
        return;
    L39:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L42;
        r3.performCreate();
        return;
    L42:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) <= 0) goto L45;
        r3.performPause();
    L45:
        if (r3.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) <= 0) goto L56;
        r3.performStop();
        return;
    }
}
