package com.bytedance.blockframework.framework.core.message;

import android.content.Context;
import com.bytedance.blockframework.contract.AbstractBlock;
import com.bytedance.blockframework.contract.AbstractBlockManager;
import com.bytedance.blockframework.interaction.BaseBlockMessageCenter;
import com.bytedance.blockframework.interaction.IBlockMessageCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockContractManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/blockframework/framework/core/message/BlockContractManager;", "Lcom/bytedance/blockframework/contract/AbstractBlockManager;", "context", "Landroid/content/Context;", "messageCenter", "Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;", "(Landroid/content/Context;Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;)V", "getMessageCenter", "()Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;", "setMessageCenter", "(Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;)V", "onRegisterBlock", "", "block", "Lcom/bytedance/blockframework/contract/AbstractBlock;", "onUnregisterBlock", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlockContractManager extends AbstractBlockManager {
    private IBlockMessageCenter messageCenter;

    @Override // com.bytedance.blockframework.contract.AbstractBlockManager
    public void onRegisterBlock(AbstractBlock r1) {
        Intrinsics.checkNotNullParameter(r1, "block");
    }

    @Override // com.bytedance.blockframework.contract.AbstractBlockManager
    public void onUnregisterBlock(AbstractBlock r1) {
        Intrinsics.checkNotNullParameter(r1, "block");
    }

    public BlockContractManager(Context r2, IBlockMessageCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "messageCenter");
        super(r2, r3);
        this.messageCenter = r3;
    }

    public /* synthetic */ BlockContractManager(Context r1, BaseBlockMessageCenter r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new BaseBlockMessageCenter();
    L5:
        this(r1, r2);
    }

    public final IBlockMessageCenter getMessageCenter() {
        return this.messageCenter;
    }

    public final void setMessageCenter(IBlockMessageCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.messageCenter = r2;
    }
}
