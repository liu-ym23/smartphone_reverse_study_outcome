package com.bytedance.blockframework.framework.join;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.config.BlockInit;
import com.bytedance.blockframework.framework.core.BlockCoreManager;
import com.bytedance.blockframework.framework.core.BlockUnitHandler;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.monitor.BlockLogger;
import com.bytedance.blockframework.framework.task.BlockInflater;
import com.bytedance.blockframework.framework.task.DefaultInflaterProvider;
import com.bytedance.blockframework.framework.utils.BlockExtKt;
import com.bytedance.blockframework.interaction.Event;
import com.bytedance.blockframework.interaction.IBlockMessageCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockContextImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016J)\u0010\u0011\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0012\"\u000e\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00120\u00142\u0006\u0010\u0015\u001a\u0002H\u0013¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001eH\u0016J%\u0010\u001f\u001a\u0002H \"\b\b\u0000\u0010 *\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\tH\u0016¢\u0006\u0002\u0010\"J'\u0010#\u001a\u0004\u0018\u0001H \"\b\b\u0000\u0010 *\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\tH\u0016¢\u0006\u0002\u0010\"J#\u0010$\u001a\u0004\u0018\u0001H \"\u0004\b\u0000\u0010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\tH\u0016¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\fH\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0003H\u0016J9\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,2\u000e\u0010-\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e2\u0006\u0010.\u001a\u00020(2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0000¢\u0006\u0002\b1J\u0010\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u000204H\u0016J-\u00105\u001a\u00020\u000e\"\b\b\u0000\u0010 *\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\t2\u0006\u00106\u001a\u0002H H\u0016¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020(H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/blockframework/framework/join/BlockContextImpl;", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "blockScene", "Lcom/bytedance/blockframework/framework/join/IBlockScene;", "(Lcom/bytedance/blockframework/framework/join/IBlockScene;)V", "blockCore", "Lcom/bytedance/blockframework/framework/core/BlockCoreManager;", "dependMap", "", "Ljava/lang/Class;", "Lcom/bytedance/blockframework/framework/join/IBlockDepend;", "inflater", "Lcom/bytedance/blockframework/framework/task/BlockInflater;", "addAfterBindTask", "", "action", "Lkotlin/Function0;", "bindBlockModel", "D", "M", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "model", "(Lcom/bytedance/blockframework/framework/core/IBlockModel;)V", "dispatchLifecycleState", "state", "Landroidx/lifecycle/Lifecycle$State;", "dispatchLifecycleState$blockframework_release", "findBlockHandler", "Lcom/bytedance/blockframework/framework/core/BlockUnitHandler;", "block", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "findDepend", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "(Ljava/lang/Class;)Lcom/bytedance/blockframework/framework/join/IBlockDepend;", "findDependOrNull", "getBlockService", "(Ljava/lang/Class;)Ljava/lang/Object;", "getLayoutInflater", "getMessageCenter", "Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;", "getScene", "initRootBlock", "context", "Landroid/content/Context;", "rootBlock", "messageCenter", "parent", "Landroid/view/View;", "initRootBlock$blockframework_release", "notifyEvent", "event", "Lcom/bytedance/blockframework/interaction/Event;", "registerDepend", "depend", "(Ljava/lang/Class;Lcom/bytedance/blockframework/framework/join/IBlockDepend;)V", "setLayoutInflater", "setMessageCenter", "center", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlockContextImpl implements IBlockContext {
    private final BlockCoreManager blockCore;
    private final IBlockScene blockScene;
    private final Map<Class<?>, IBlockDepend> dependMap;
    private BlockInflater inflater;

    public BlockContextImpl(IBlockScene r2) {
        Intrinsics.checkNotNullParameter(r2, "blockScene");
        this.blockScene = r2;
        this.blockCore = new BlockCoreManager();
        this.dependMap = new LinkedHashMap();
    }

    public static /* synthetic */ void initRootBlock$blockframework_release$default(BlockContextImpl r0, Context r1, BaseBlock r2, IBlockMessageCenter r3, View r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.initRootBlock$blockframework_release(r1, r2, r3, r4);
    }

    public final void initRootBlock$blockframework_release(Context r3, BaseBlock<?, ?> r4, IBlockMessageCenter r5, View r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "rootBlock");
        Intrinsics.checkNotNullParameter(r5, "messageCenter");
        this.blockCore.initScene(this.blockScene);
        this.blockCore.initRootBlock(r3, r4, r5, r6);
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockContext
    public IBlockScene getScene() {
        return this.blockScene;
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockContext
    public <T extends IBlockDepend> void registerDepend(Class<T> r4, T r5) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        Intrinsics.checkNotNullParameter(r5, "depend");
        if (this.dependMap.containsKey(r4) == true) goto L5;
    L9:
        this.dependMap.put(r4, r5);
        return;
    L5:
        if (BlockInit.INSTANCE.logOptEnable() == true) goto L7;
    L8:
        BlockExtKt.uploadException(new RuntimeException("registerService " + r4 + " already exists"), true);
        goto L9
    L7:
        if (BlockLogger.Companion.debug() == false) goto L9;
        goto L8
    }

    public final <D, M extends IBlockModel<D>> void bindBlockModel(M r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        this.blockCore.bindBlockModel(r2);
    }

    public final void dispatchLifecycleState$blockframework_release(Lifecycle.State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.blockCore.dispatchLifecycleState(r2);
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockContext
    public <T extends IBlockDepend> T findDepend(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        if (this.dependMap.containsKey(r2) == false) goto L7;
        IBlockDepend r1 = this.dependMap.get(r2);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type T of com.bytedance.blockframework.framework.join.BlockContextImpl.findDepend");
        return (T) r1;
    L7:
        throw new Exception();
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockContext
    public <T extends IBlockDepend> T findDependOrNull(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        IBlockDepend r1 = this.dependMap.get(r2);
        if ((r1 instanceof IBlockDepend) == true) goto L7;
        return null;
    L7:
        return (T) r1;
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockContext
    public <T> T getBlockService(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return (T) this.blockCore.getBlockService(r2);
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockContext
    public void notifyEvent(Event r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.blockCore.notifyEvent(r2);
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockContext
    public void setMessageCenter(IBlockMessageCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "center");
        this.blockCore.setMessageCenter(r2);
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockContext
    public IBlockMessageCenter getMessageCenter() {
        return this.blockCore.getMessageCenter();
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockContext
    public BlockUnitHandler findBlockHandler(BaseBlock<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        return this.blockCore.findBlockHandler(r2);
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockContext
    public void setLayoutInflater(BlockInflater r2) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        this.inflater = r2;
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockContext
    public BlockInflater getLayoutInflater() {
        BlockInflater r0 = this.inflater;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return DefaultInflaterProvider.INSTANCE.getInflater();
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockContext
    public void addAfterBindTask(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.blockCore.addAfterBindTask(r2);
    }
}
