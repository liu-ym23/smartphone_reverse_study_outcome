package com.bytedance.blockframework.interaction;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.blockframework.contract.AbstractBlock;
import com.bytedance.blockframework.contract.BlockImplWrapper;
import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.config.BlockInit;
import com.bytedance.blockframework.framework.core.BlockUnitHandler;
import com.bytedance.blockframework.framework.monitor.BlockLogger;
import com.bytedance.blockframework.framework.utils.BlockExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TreeConstrainBlockMessageCenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016J3\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0005\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\n0\b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ=\u0010\u000f\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\n0\b2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\u00020\u0004\"\u0004\b\u0000\u0010\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\n0\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/blockframework/interaction/TreeConstrainBlockMessageCenter;", "Lcom/bytedance/blockframework/interaction/BaseBlockMessageCenter;", "()V", "handleUnexpectedServiceDepend", "", "block", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "klass", "Ljava/lang/Class;", "queryService", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/blockframework/contract/AbstractBlock;", "activeIfNeed", "", "(Lcom/bytedance/blockframework/contract/AbstractBlock;Ljava/lang/Class;Z)Ljava/lang/Object;", "queryTargetCoreTreeService", "(Lcom/bytedance/blockframework/framework/base/BaseBlock;Ljava/lang/Class;Z)Ljava/lang/Object;", "registerService", "blockImplWrapper", "Lcom/bytedance/blockframework/contract/BlockImplWrapper;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class TreeConstrainBlockMessageCenter extends BaseBlockMessageCenter {
    public void handleUnexpectedServiceDepend(BaseBlock<?, ?> r1, Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "klass");
    }

    public TreeConstrainBlockMessageCenter() {
    }

    @Override // com.bytedance.blockframework.interaction.BaseBlockMessageCenter, com.bytedance.blockframework.interaction.IBlockMessageCenter
    public <T> void registerService(Class<T> r4, BlockImplWrapper r5) {
        Intrinsics.checkNotNullParameter(r4, "klass");
        Intrinsics.checkNotNullParameter(r5, "blockImplWrapper");
        Object r0 = r5.getImpl();
        BlockUnitHandler r2 = null;
        if ((r0 instanceof BaseBlock) == false) goto L5;
        BaseBlock r1 = (BaseBlock) r0;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.getParent$blockframework_release();
    L8:
        if (r2 != null) goto L11;
        super.registerService(r4, r5);
        return;
    L11:
        BlockUnitHandler r3 = r1.getParent$blockframework_release();
        if (r3 == null) goto L15;
        r3.registerService(r4, r5);
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.blockframework.interaction.BaseBlockMessageCenter, com.bytedance.blockframework.interaction.IBlockMessageCenter
    public <T> T queryService(AbstractBlock r10, Class<T> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "block");
        Intrinsics.checkNotNullParameter(r11, "klass");
        if ((r10 instanceof BaseBlock) == false) goto L5;
        BaseBlock<?, ?> r13 = (BaseBlock) r10;
        if (r13.getParent$blockframework_release() != null) goto L11;
        T r0 = (T) queryService(r11, r12);
        if (r0 == null) goto L11;
        return r0;
    L11:
        BlockUnitHandler r1 = r13.getParent$blockframework_release();
        BaseBlock r2 = null;
        if (r1 == null) goto L14;
        T r3 = (T) r1.queryService(r11, r12);
    L15:
        if (r3 == null) goto L17;
        return r3;
    L17:
        BlockUnitHandler r4 = r13.getParent$blockframework_release();
        if (r4 != null) goto L20;
        r4 = BlockExtKt.blockHandler(r13);
    L20:
        Iterator<T> r5 = r4.getChildBlocks().iterator();
        BaseBlock<?, ?> r6 = null;
    L22:
        if (r5.hasNext() == false) goto L26;
        BaseBlock<?, ?> r7 = (BaseBlock) r5.next();
        if ((r7 instanceof CoreTreeLayerBlock) == false) goto L22;
        r6 = r7;
        goto L22
    L26:
        boolean r8 = r6 instanceof BaseBlock;
        if (r8 == false) goto L29;
        BaseBlock<?, ?> r9 = r6;
    L30:
        if (r9 == null) goto L34;
        BlockUnitHandler r14 = BlockExtKt.blockHandler(r9);
        if (r14 == null) goto L34;
        T r15 = (T) r14.queryService(r11, r12);
    L35:
        if (r15 == null) goto L37;
        return r15;
    L37:
        if (r8 == true) goto L40;
        r6 = null;
    L40:
        T r16 = (T) queryTargetCoreTreeService(r6, r11, r12);
        if (r16 == 0) goto L43;
    L67:
        if (r12 == true) goto L69;
    L73:
        return r16;
    L69:
        if ((r16 instanceof BaseBlock) == false) goto L71;
        r2 = (BaseBlock) r16;
    L71:
        if (r2 == null) goto L73;
        r2.activeIfNeed();
        goto L73
    L43:
        if (BlockInit.INSTANCE.logOptEnable() == true) goto L45;
    L46:
        BlockExtKt.uploadException(new RuntimeException("TreeConstrainBlockMessageCenter queryService " + r11 + " not find"), false);
    L48:
        if (BlockLogger.Companion.debug() == false) goto L67;
        if (BlockInit.INSTANCE.enableDebugDependencyCheck() == false) goto L67;
        BlockUnitHandler r17 = r13.getParent$blockframework_release();
        if (r17 == null) goto L54;
        BaseBlock<?, ?> r18 = r17.getAttachBlock();
    L55:
        if (r18 == null) goto L57;
        BlockUnitHandler r19 = r18.getParent$blockframework_release();
    L58:
        if (r19 == null) goto L62;
        BlockUnitHandler r20 = r18.getParent$blockframework_release();
        if (r20 == null) goto L54;
        r18 = r20.getAttachBlock();
        goto L55
    L54:
        r18 = null;
        goto L55
    L62:
        if (r18 == null) goto L64;
        Object r21 = IBlockMessageCenter.DefaultImpls.queryService$default(this, r18, r11, false, 4, null);
    L65:
        if (r21 == null) goto L67;
        handleUnexpectedServiceDepend(r13, r11);
        goto L67
    L64:
        r21 = null;
        goto L65
    L57:
        r19 = null;
        goto L58
    L74:
        r18 = null;
        goto L55
    L45:
        if (BlockLogger.Companion.debug() == false) goto L48;
    L34:
        r15 = null;
        goto L35
    L29:
        r9 = null;
        goto L30
    L14:
        r3 = null;
        goto L15
    L5:
        return (T) super.queryService(r11, r12);
    }

    private final <T> T queryTargetCoreTreeService(BaseBlock<?, ?> r5, Class<T> r6, boolean r7) {
        BaseBlock<?, ?> r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        BlockUnitHandler r8 = BlockExtKt.blockHandler(r5);
        if (r8 == null) goto L15;
        List<BaseBlock<?, ?>> r9 = r8.getChildBlocks();
        if (r9 == null) goto L15;
        Iterator<T> r10 = r9.iterator();
        BaseBlock<?, ?> r1 = null;
    L11:
        if (r10.hasNext() == false) goto L17;
        BaseBlock<?, ?> r2 = (BaseBlock) r10.next();
        if ((r2 instanceof CoreTreeLayerBlock) == false) goto L11;
        r1 = r2;
    L17:
        if (((CoreTreeLayerBlock) r1) != null) goto L19;
        return null;
    L19:
        boolean r11 = r1 instanceof BaseBlock;
        if (r11 == false) goto L22;
        BaseBlock<?, ?> r3 = r1;
    L23:
        if (r3 == null) goto L27;
        BlockUnitHandler r4 = BlockExtKt.blockHandler(r3);
        if (r4 == null) goto L27;
        T r12 = (T) r4.queryService(r6, r7);
    L28:
        if (r12 == null) goto L30;
        return r12;
    L30:
        if (r11 == false) goto L33;
        r0 = r1;
    L33:
        return (T) queryTargetCoreTreeService(r0, r6, r7);
    L27:
        r12 = null;
        goto L28
    L22:
        r3 = null;
    L15:
        r1 = null;
        goto L17
    }
}
