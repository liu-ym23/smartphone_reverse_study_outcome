package com.bytedance.blockframework.framework.utils;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.config.BlockInit;
import com.bytedance.blockframework.framework.core.BlockUnitHandler;
import com.bytedance.blockframework.framework.core.message.TreeBlockMessageCenter;
import com.bytedance.blockframework.framework.join.IBlockDepend;
import com.bytedance.blockframework.framework.monitor.BlockLogger;
import com.bytedance.blockframework.framework.performance.ThreadProcessor;
import com.bytedance.blockframework.interaction.BaseBlockMessageCenter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;

/* JADX INFO: compiled from: BlockExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0014\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a \u0010\u000b\u001a\u00020\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u001a\u0012\u0010\r\u001a\u00020\u000e*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f\u001a3\u0010\u000f\u001a\u0018\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u0010\"\u0006\b\u0000\u0010\u0011\u0018\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fH\u0086\b\u001a5\u0010\u0012\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u0002H\u00110\u0010\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u0013*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fH\u0086\b\u001a=\u0010\u0014\u001a\u00020\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2)\u0010\u0004\u001a%\u0012\u001b\u0012\u0019\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00030\u0015\u001a=\u0010\u0019\u001a\u00020\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2)\u0010\u0004\u001a%\u0012\u001b\u0012\u0019\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00030\u0015¨\u0006\u001a"}, d2 = {"getDefaultCenter", "Lcom/bytedance/blockframework/interaction/BaseBlockMessageCenter;", "syncInvoke", "", "action", "Lkotlin/Function0;", "uploadException", "exception", "", "needThrow", "", "afterBind", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "blockHandler", "Lcom/bytedance/blockframework/framework/core/BlockUnitHandler;", "blockService", "Lkotlin/properties/ReadOnlyProperty;", ExifInterface.GPS_DIRECTION_TRUE, "findDepend", "Lcom/bytedance/blockframework/framework/join/IBlockDepend;", "traverseBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "block", "traverseSubBlock", "blockframework_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BlockExtKt {
    public static /* synthetic */ void $r8$lambda$FSggkyCGkSW8W9w3HbjZxx6gUOE(Function0 r0) {
        syncInvoke$lambda$2(r0);
    }

    public static final BaseBlockMessageCenter getDefaultCenter() {
        if (BlockInit.INSTANCE.useTreeMessageCenterEnable() == false) goto L6;
        return new TreeBlockMessageCenter();
    L6:
        return new BaseBlockMessageCenter();
    }

    public static final BlockUnitHandler blockHandler(BaseBlock<?, ?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getBlockContext().findBlockHandler(r1);
    }

    public static final /* synthetic */ <T> ReadOnlyProperty<BaseBlock<?, ?>, T> blockService(final BaseBlock<?, ?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.needClassReification();
        return new AnonymousClass1(r1);
    }

    public static final /* synthetic */ <T extends IBlockDepend> ReadOnlyProperty<BaseBlock<?, ?>, T> findDepend(final BaseBlock<?, ?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.needClassReification();
        return (ReadOnlyProperty) new C01341(r1);
    }

    public static final void traverseBlock(BaseBlock<?, ?> r1, Function1<? super BaseBlock<?, ?>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "action");
        r2.invoke(r1);
        Iterator<T> r3 = blockHandler(r1).getChildBlocks().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        traverseBlock((BaseBlock) r3.next(), r2);
        goto L4
    }

    public static final void traverseSubBlock(BaseBlock<?, ?> r1, Function1<? super BaseBlock<?, ?>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "action");
        Iterator<T> r3 = blockHandler(r1).getChildBlocks().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        traverseBlock((BaseBlock) r3.next(), r2);
        goto L4
    }

    public static final void afterBind(BaseBlock<?, ?> r1, Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "action");
        r1.getBlockContext().addAfterBindTask(r2);
    }

    public static final void syncInvoke(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        ThreadProcessor.INSTANCE.main().post(new BlockExtKt$$ExternalSyntheticLambda0(r2));
    }

    private static final void syncInvoke$lambda$2(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        r1.invoke();
    }

    public static final void uploadException(Throwable r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "exception");
        if (BlockLogger.Companion.debug() == true) goto L5;
        return;
    L5:
        if (r2 == true) goto L7;
        return;
    L7:
        throw r1;
    }
}
