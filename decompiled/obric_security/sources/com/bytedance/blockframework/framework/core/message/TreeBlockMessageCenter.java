package com.bytedance.blockframework.framework.core.message;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.blockframework.contract.BlockImplWrapper;
import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.core.BlockUnitHandler;
import com.bytedance.blockframework.interaction.BaseBlockMessageCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TreeBlockMessageCenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/blockframework/framework/core/message/TreeBlockMessageCenter;", "Lcom/bytedance/blockframework/interaction/BaseBlockMessageCenter;", "()V", "registerService", "", ExifInterface.GPS_DIRECTION_TRUE, "klass", "Ljava/lang/Class;", "blockImplWrapper", "Lcom/bytedance/blockframework/contract/BlockImplWrapper;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class TreeBlockMessageCenter extends BaseBlockMessageCenter {
    public TreeBlockMessageCenter() {
    }

    @Override // com.bytedance.blockframework.interaction.BaseBlockMessageCenter, com.bytedance.blockframework.interaction.IBlockMessageCenter
    public <T> void registerService(Class<T> r3, BlockImplWrapper r4) {
        Intrinsics.checkNotNullParameter(r3, "klass");
        Intrinsics.checkNotNullParameter(r4, "blockImplWrapper");
        Object r2 = r4.getImpl();
        if ((r2 instanceof BaseBlock) == false) goto L5;
        BaseBlock<?, ?> r5 = (BaseBlock) r2;
    L6:
        if (r5 == null) goto L13;
        BlockUnitHandler r0 = r5.getParent$blockframework_release();
        if (r0 == null) goto L10;
        r0.registerService(r3, r4);
    L10:
        BlockUnitHandler r6 = r5.getParent$blockframework_release();
        if (r6 == null) goto L5;
        r5 = r6.getAttachBlock();
        goto L6
    L5:
        r5 = null;
        goto L6
    L13:
        return;
    L14:
        r5 = null;
        goto L6
    }
}
