package com.bytedance.blockframework.contract;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.blockframework.framework.monitor.BlockLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractLifecycleBlock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/blockframework/contract/AbstractLifecycleBlock;", "Lcom/bytedance/blockframework/contract/AbstractBlock;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "DEBUG", "", "TAG", "", "kotlin.jvm.PlatformType", "mLifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "onCreate", "", "onDestroy", "onPause", "onResume", AgentConstants.ON_START, "onStop", "performCreate", "performDestroy", "performPause", "performResume", "performStart", "performStop", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbstractLifecycleBlock extends AbstractBlock implements LifecycleOwner {
    private final boolean DEBUG;
    private final String TAG;
    private final LifecycleRegistry mLifecycleRegistry;

    public AbstractLifecycleBlock() {
        this.TAG = getClass().getSimpleName();
        this.DEBUG = BlockLogger.Companion.debug();
        this.mLifecycleRegistry = new LifecycleRegistry(this);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final void performCreate() {
        onCreate();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public void onCreate() {
        if (this.DEBUG == false) goto L6;
        BlockLogger.Companion r0 = BlockLogger.Companion;
        String r2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r2, "TAG");
        r0.log(r2, "onCreate");
        return;
    }

    public final void performStart() {
        onStart();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    public void onStart() {
        if (this.DEBUG == false) goto L6;
        BlockLogger.Companion r0 = BlockLogger.Companion;
        String r2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r2, "TAG");
        r0.log(r2, AgentConstants.ON_START);
        return;
    }

    public final void performResume() {
        onResume();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    public void onResume() {
        if (this.DEBUG == false) goto L6;
        BlockLogger.Companion r0 = BlockLogger.Companion;
        String r2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r2, "TAG");
        r0.log(r2, "onResume");
        return;
    }

    public final void performPause() {
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        onPause();
    }

    public void onPause() {
        if (this.DEBUG == false) goto L6;
        BlockLogger.Companion r0 = BlockLogger.Companion;
        String r2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r2, "TAG");
        r0.log(r2, "onPause");
        return;
    }

    public final void performStop() {
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        onStop();
    }

    public void onStop() {
        if (this.DEBUG == false) goto L6;
        BlockLogger.Companion r0 = BlockLogger.Companion;
        String r2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r2, "TAG");
        r0.log(r2, "onStop");
        return;
    }

    public final void performDestroy() {
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        onDestroy();
    }

    public void onDestroy() {
        if (this.DEBUG == false) goto L6;
        BlockLogger.Companion r0 = BlockLogger.Companion;
        String r2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r2, "TAG");
        r0.log(r2, "onDestroy");
        return;
    }
}
