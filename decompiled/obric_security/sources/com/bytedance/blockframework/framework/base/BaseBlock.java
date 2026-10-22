package com.bytedance.blockframework.framework.base;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.blockframework.contract.AbstractLifecycleBlock;
import com.bytedance.blockframework.framework.core.BlockGenerator;
import com.bytedance.blockframework.framework.core.BlockUnitHandler;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.core.message.TreeBlockMessageCenter;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedance.blockframework.framework.utils.BlockExtKt;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseBlock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010)\u001a\u00020\nH\u0016J\u0017\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010,J\u000e\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0013H\u0016J+\u00103\u001a\u0004\u0018\u0001H4\"\u0004\b\u0002\u001042\f\u00105\u001a\b\u0012\u0004\u0012\u0002H40.2\u0006\u0010)\u001a\u00020\u0019H\u0016¢\u0006\u0002\u00106J\b\u00107\u001a\u00020\u0019H\u0016J\b\u00108\u001a\u00020\nH\u0016J\b\u00109\u001a\u00020\nH\u0016J\b\u0010:\u001a\u00020\nH\u0016J\b\u0010;\u001a\u00020\nH\u0017J\b\u0010<\u001a\u00020\nH\u0016J\b\u0010=\u001a\u00020\nH\u0016J\b\u0010>\u001a\u00020\nH\u0016J\b\u0010?\u001a\u00020\nH\u0016J\b\u0010@\u001a\u00020\nH\u0016R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0007R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010 \u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006A"}, d2 = {"Lcom/bytedance/blockframework/framework/base/BaseBlock;", "DATA", "MODEL", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "Lcom/bytedance/blockframework/contract/AbstractLifecycleBlock;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "activeTask", "Lkotlin/Function0;", "", "getActiveTask", "()Lkotlin/jvm/functions/Function0;", "setActiveTask", "(Lkotlin/jvm/functions/Function0;)V", "getBlockContext", "()Lcom/bytedance/blockframework/framework/join/IBlockContext;", "setBlockContext", "blockName", "", "getBlockName", "()Ljava/lang/String;", "blockName$delegate", "Lkotlin/Lazy;", "immediateBind", "", "getImmediateBind$blockframework_release", "()Z", "setImmediateBind$blockframework_release", "(Z)V", "isBlockActivated", "setBlockActivated", "lazyActive", "getLazyActive", "setLazyActive", "parent", "Lcom/bytedance/blockframework/framework/core/BlockUnitHandler;", "getParent$blockframework_release", "()Lcom/bytedance/blockframework/framework/core/BlockUnitHandler;", "setParent$blockframework_release", "(Lcom/bytedance/blockframework/framework/core/BlockUnitHandler;)V", "activeIfNeed", "bindModel", "model", "(Lcom/bytedance/blockframework/framework/core/IBlockModel;)V", "defineBlockService", "Ljava/lang/Class;", "generateSubBlocks", "generator", "Lcom/bytedance/blockframework/framework/core/BlockGenerator;", "getBlockKey", "getBlockService", ExifInterface.GPS_DIRECTION_TRUE, "klass", "(Ljava/lang/Class;Z)Ljava/lang/Object;", "isActive", "onCreate", "onDestroy", "onPause", "onPrepared", "onRegister", "onResume", AgentConstants.ON_START, "onStop", "onUnRegister", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class BaseBlock<DATA, MODEL extends IBlockModel<DATA>> extends AbstractLifecycleBlock {
    private Function0<Unit> activeTask;
    private IBlockContext blockContext;
    private final Lazy blockName$delegate;
    private boolean immediateBind;
    private boolean isBlockActivated;
    private boolean lazyActive;
    private BlockUnitHandler parent;

    public void bindModel(MODEL r1) {
    }

    @Override // com.bytedance.blockframework.contract.AbstractBlock
    public Class<?> defineBlockService() {
        return null;
    }

    public void generateSubBlocks(BlockGenerator r1) {
        Intrinsics.checkNotNullParameter(r1, "generator");
    }

    @Override // com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onCreate() {
    }

    @Override // com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onDestroy() {
    }

    @Override // com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onPause() {
    }

    public void onRegister() {
    }

    @Override // com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onResume() {
    }

    @Override // com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onStart() {
    }

    @Override // com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onStop() {
    }

    @Override // com.bytedance.blockframework.contract.AbstractBlock, com.bytedance.blockframework.interaction.StateAndEventModel
    public void onUnRegister() {
    }

    public BaseBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        this.blockContext = r2;
        this.blockName$delegate = LazyKt.lazy(new BaseBlock$blockName$2(this));
        this.isBlockActivated = true;
    }

    public final IBlockContext getBlockContext() {
        return this.blockContext;
    }

    public final void setBlockContext(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.blockContext = r2;
    }

    private final String getBlockName() {
        return (String) this.blockName$delegate.getValue();
    }

    public final BlockUnitHandler getParent$blockframework_release() {
        return this.parent;
    }

    public final void setParent$blockframework_release(BlockUnitHandler r1) {
        this.parent = r1;
    }

    public final boolean getImmediateBind$blockframework_release() {
        return this.immediateBind;
    }

    public final void setImmediateBind$blockframework_release(boolean r1) {
        this.immediateBind = r1;
    }

    public boolean getLazyActive() {
        return this.lazyActive;
    }

    public void setLazyActive(boolean r1) {
        this.lazyActive = r1;
    }

    public boolean isBlockActivated() {
        return this.isBlockActivated;
    }

    public void setBlockActivated(boolean r1) {
        this.isBlockActivated = r1;
    }

    public Function0<Unit> getActiveTask() {
        return this.activeTask;
    }

    public void setActiveTask(Function0<Unit> r1) {
        this.activeTask = r1;
    }

    public void activeIfNeed() {
        if (isActive() == true) goto L8;
        Function0<Unit> r1 = getActiveTask();
        if (r1 == null) goto L9;
        r1.invoke();
        return;
    L9:
        return;
    }

    public String getBlockKey() {
        return getBlockName();
    }

    @Override // com.bytedance.blockframework.contract.AbstractBlock, com.bytedance.blockframework.interaction.StateAndEventModel
    @Deprecated(message = "please use onRegister()", replaceWith = @ReplaceWith(expression = "onRegister()", imports = {}))
    public void onPrepared() {
        onRegister();
    }

    @Override // com.bytedance.blockframework.contract.AbstractBlock
    public boolean isActive() {
        return isBlockActivated();
    }

    @Override // com.bytedance.blockframework.contract.AbstractBlock
    public <T> T getBlockService(Class<T> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "klass");
        if ((getBlockBlockMessageCenter() instanceof TreeBlockMessageCenter) == false) goto L12;
        BlockUnitHandler r1 = BlockExtKt.blockHandler(this);
        T r0 = (T) r1.queryService(r2, r3);
    L5:
        if (r0 != null) goto L10;
        r1 = r1.getAttachBlock().parent;
        if (r1 == null) goto L10;
        r0 = (T) r1.queryService(r2, r3);
    L10:
        return r0;
    L12:
        return (T) getBlockBlockMessageCenter().queryService(this, r2, r3);
    }
}
