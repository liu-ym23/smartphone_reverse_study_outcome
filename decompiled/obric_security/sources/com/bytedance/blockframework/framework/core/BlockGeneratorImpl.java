package com.bytedance.blockframework.framework.core;

import com.bytedance.blockframework.framework.core.message.BlockContractManager;
import com.bytedance.blockframework.framework.task.BlockViewBuildTask;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockGenerator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ!\u0010\n\u001a\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/blockframework/framework/core/BlockGeneratorImpl;", "Lcom/bytedance/blockframework/framework/core/BlockGenerator;", "supervisor", "Lcom/bytedance/blockframework/framework/core/BlockUnitHandler;", "contractManager", "Lcom/bytedance/blockframework/framework/core/message/BlockContractManager;", "uiTasks", "", "Lcom/bytedance/blockframework/framework/task/BlockViewBuildTask;", "(Lcom/bytedance/blockframework/framework/core/BlockUnitHandler;Lcom/bytedance/blockframework/framework/core/message/BlockContractManager;Ljava/util/List;)V", "generate", "", "action", "Lkotlin/Function1;", "Lcom/bytedance/blockframework/framework/core/SubBlockCreator;", "Lkotlin/ExtensionFunctionType;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlockGeneratorImpl implements BlockGenerator {
    private final BlockContractManager contractManager;
    private final BlockUnitHandler supervisor;
    private final List<BlockViewBuildTask> uiTasks;

    public BlockGeneratorImpl(BlockUnitHandler r2, BlockContractManager r3, List<BlockViewBuildTask> r4) {
        Intrinsics.checkNotNullParameter(r3, "contractManager");
        Intrinsics.checkNotNullParameter(r4, "uiTasks");
        this.supervisor = r2;
        this.contractManager = r3;
        this.uiTasks = r4;
    }

    public static final /* synthetic */ BlockContractManager access$getContractManager$p(BlockGeneratorImpl r0) {
        return r0.contractManager;
    }

    public static final /* synthetic */ BlockUnitHandler access$getSupervisor$p(BlockGeneratorImpl r0) {
        return r0.supervisor;
    }

    public static final /* synthetic */ List access$getUiTasks$p(BlockGeneratorImpl r0) {
        return r0.uiTasks;
    }

    @Override // com.bytedance.blockframework.framework.core.BlockGenerator
    public void generate(Function1<? super SubBlockCreator, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        r2.invoke(new BlockGeneratorImpl$generate$adder$1(this));
    }
}
