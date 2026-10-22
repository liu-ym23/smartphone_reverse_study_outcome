package com.bytedance.blockframework.framework.base;

import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoBindBlock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002¨\u0006\t"}, d2 = {"Lcom/bytedance/blockframework/framework/base/NoBindBlock;", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "bindModel", "", "model", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class NoBindBlock extends BaseBlock {
    public NoBindBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public /* bridge */ /* synthetic */ void bindModel(IBlockModel r1) {
        bindModel((Void) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void bindModel(Void r1) {
        super.bindModel((IBlockModel) r1);
    }
}
