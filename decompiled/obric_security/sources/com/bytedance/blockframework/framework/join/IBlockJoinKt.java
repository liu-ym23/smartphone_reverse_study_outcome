package com.bytedance.blockframework.framework.join;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.utils.BlockExtKt;
import com.bytedance.blockframework.interaction.BaseBlockMessageCenter;
import com.bytedance.blockframework.interaction.IBlockMessageCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IBlockJoin.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a2\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0003H\u0086\b¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0006\b\u0000\u0010\t\u0018\u0001*\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\n\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\f\u001a\u00020\r\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0005\u001a\u001e\u0010\u0014\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u0015*\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u0016\u001a \u0010\u0017\u001a\u0004\u0018\u0001H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u0015*\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u0016\u001a\u0012\u0010\u0018\u001a\u00020\u0019*\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b\u001a\"\u0010\u001c\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 \u001a8\u0010\u001c\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u001a&\u0010%\u001a\u00020\u0001\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u0015*\u00020\u00052\u0006\u0010&\u001a\u0002H\tH\u0086\b¢\u0006\u0002\u0010'¨\u0006("}, d2 = {"bindBlockModel", "", "DATA", "MODEL", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "Lcom/bytedance/blockframework/framework/join/IBlockJoin;", "model", "(Lcom/bytedance/blockframework/framework/join/IBlockJoin;Lcom/bytedance/blockframework/framework/core/IBlockModel;)V", "blockService", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/bytedance/blockframework/framework/join/IBlockJoin;)Ljava/lang/Object;", "dispatchBlockLifecycle", "state", "Landroidx/lifecycle/Lifecycle$State;", "dispatchOnCreate", "dispatchOnDestroy", "dispatchOnPause", "dispatchOnResume", "dispatchOnStart", "dispatchOnStop", "findDepend", "Lcom/bytedance/blockframework/framework/join/IBlockDepend;", "(Lcom/bytedance/blockframework/framework/join/IBlockJoin;)Lcom/bytedance/blockframework/framework/join/IBlockDepend;", "findDependOrNull", "getBlockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "scene", "Lcom/bytedance/blockframework/framework/join/IBlockScene;", "initRootBlock", "context", "Landroid/content/Context;", "rootBlock", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "messageCenter", "Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;", "parent", "Landroid/view/View;", "registerDepend", "depend", "(Lcom/bytedance/blockframework/framework/join/IBlockJoin;Lcom/bytedance/blockframework/framework/join/IBlockDepend;)V", "blockframework_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class IBlockJoinKt {
    public static final void initRootBlock(IBlockJoin r2, Context r3, BaseBlock<?, ?> r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "rootBlock");
        IBlockContext r5 = r2.getBlockContext();
        if ((r5 instanceof BlockContextImpl) == false) goto L5;
        BlockContextImpl r6 = (BlockContextImpl) r5;
    L6:
        if (r6 == null) goto L9;
        r6.initRootBlock$blockframework_release(r3, r4, BlockExtKt.getDefaultCenter(), null);
        return;
    L9:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public static /* synthetic */ void initRootBlock$default(IBlockJoin r0, Context r1, BaseBlock r2, BaseBlockMessageCenter r3, View r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = BlockExtKt.getDefaultCenter();
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        initRootBlock(r0, r1, r2, r3, r4);
    }

    public static final void initRootBlock(IBlockJoin r1, Context r2, BaseBlock<?, ?> r3, IBlockMessageCenter r4, View r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootBlock");
        Intrinsics.checkNotNullParameter(r4, "messageCenter");
        IBlockContext r6 = r1.getBlockContext();
        if ((r6 instanceof BlockContextImpl) == false) goto L5;
        BlockContextImpl r7 = (BlockContextImpl) r6;
    L6:
        if (r7 == null) goto L9;
        r7.initRootBlock$blockframework_release(r2, r3, r4, r5);
        return;
    L9:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public static final /* synthetic */ <DATA, MODEL extends IBlockModel<DATA>> void bindBlockModel(IBlockJoin r1, MODEL r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "model");
        IBlockContext r3 = r1.getBlockContext();
        if ((r3 instanceof BlockContextImpl) == false) goto L5;
        BlockContextImpl r4 = (BlockContextImpl) r3;
    L6:
        if (r4 == null) goto L9;
        r4.bindBlockModel(r2);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static final void dispatchBlockLifecycle(IBlockJoin r1, Lifecycle.State r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "state");
        IBlockContext r3 = r1.getBlockContext();
        if ((r3 instanceof BlockContextImpl) == false) goto L5;
        BlockContextImpl r4 = (BlockContextImpl) r3;
    L6:
        if (r4 == null) goto L9;
        r4.dispatchLifecycleState$blockframework_release(r2);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static final void dispatchOnCreate(IBlockJoin r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        dispatchBlockLifecycle(r1, Lifecycle.State.CREATED);
    }

    public static final void dispatchOnStart(IBlockJoin r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        dispatchBlockLifecycle(r1, Lifecycle.State.STARTED);
    }

    public static final void dispatchOnResume(IBlockJoin r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        dispatchBlockLifecycle(r1, Lifecycle.State.RESUMED);
    }

    public static final void dispatchOnPause(IBlockJoin r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        dispatchBlockLifecycle(r1, Lifecycle.State.STARTED);
    }

    public static final void dispatchOnStop(IBlockJoin r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        dispatchBlockLifecycle(r1, Lifecycle.State.CREATED);
    }

    public static final void dispatchOnDestroy(IBlockJoin r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        dispatchBlockLifecycle(r1, Lifecycle.State.DESTROYED);
    }

    public static final /* synthetic */ <T extends IBlockDepend> void registerDepend(IBlockJoin r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "depend");
        IBlockContext r4 = r2.getBlockContext();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        r4.registerDepend(IBlockDepend.class, r3);
    }

    public static final /* synthetic */ <T> T blockService(IBlockJoin r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        IBlockContext r3 = r2.getBlockContext();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) r3.getBlockService(Object.class);
    }

    public static final /* synthetic */ <T extends IBlockDepend> T findDepend(IBlockJoin r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        IBlockContext r3 = r2.getBlockContext();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) r3.findDepend(IBlockDepend.class);
    }

    public static final /* synthetic */ <T extends IBlockDepend> T findDependOrNull(IBlockJoin r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        IBlockContext r3 = r2.getBlockContext();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) r3.findDependOrNull(IBlockDepend.class);
    }

    public static final IBlockContext getBlockContext(IBlockJoin r1, IBlockScene r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "scene");
        return new BlockContextImpl(r2);
    }
}
