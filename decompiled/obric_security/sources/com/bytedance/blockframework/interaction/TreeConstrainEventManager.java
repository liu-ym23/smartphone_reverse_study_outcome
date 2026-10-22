package com.bytedance.blockframework.interaction;

import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.config.BlockInit;
import com.bytedance.blockframework.framework.core.BlockUnitHandler;
import com.bytedance.blockframework.framework.monitor.BlockLogger;
import com.bytedance.blockframework.framework.utils.BlockExtKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TreeConstrainEventManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\r\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/blockframework/interaction/TreeConstrainEventManager;", "Lcom/bytedance/blockframework/interaction/EventManager;", "()V", "findLowerObserver", "", "block", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "event", "Lcom/bytedance/blockframework/interaction/Event;", "handleUnexpectedEventDepend", "", "Lcom/bytedance/blockframework/interaction/StateAndEventModel;", "notifyEvent", "registerObserver", "observer", "Lcom/bytedance/blockframework/interaction/IObserver;", "eventClass", "Ljava/lang/Class;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class TreeConstrainEventManager extends EventManager {
    public void handleUnexpectedEventDepend(StateAndEventModel r1, Event r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public TreeConstrainEventManager() {
    }

    @Override // com.bytedance.blockframework.interaction.EventManager, com.bytedance.blockframework.interaction.IEventManager
    public void registerObserver(IObserver<Event> r2, Class<Event> r3) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        Intrinsics.checkNotNullParameter(r3, "eventClass");
        if ((r2 instanceof BaseBlock) == true) goto L6;
        super.registerObserver(r2, r3);
        return;
    L6:
        BaseBlock r1 = (BaseBlock) r2;
        if (r1.getParent$blockframework_release() != null) goto L10;
        BlockExtKt.blockHandler(r1).registerObserver(r2, r3);
        return;
    L10:
        BlockUnitHandler r4 = r1.getParent$blockframework_release();
        if (r4 == null) goto L14;
        r4.registerObserver(r2, r3);
        return;
    }

    @Override // com.bytedance.blockframework.interaction.EventManager, com.bytedance.blockframework.interaction.IEventManager
    public boolean notifyEvent(StateAndEventModel r4, Event r5) {
        Intrinsics.checkNotNullParameter(r4, "block");
        Intrinsics.checkNotNullParameter(r5, "event");
        boolean r0 = r4 instanceof BaseBlock;
        if (r0 == true) goto L7;
        return super.notifyEvent(r4, r5);
    L7:
        if (r0 == false) goto L9;
        BaseBlock<?, ?> r1 = (BaseBlock) r4;
    L10:
        if (r1 == null) goto L12;
        BlockUnitHandler r2 = r1.getParent$blockframework_release();
    L13:
        if (r2 == null) goto L21;
        BlockUnitHandler r3 = r1.getParent$blockframework_release();
        if (r3 == null) goto L17;
        r3.notifyEvent(r5);
    L17:
        BlockUnitHandler r6 = r1.getParent$blockframework_release();
        if (r6 == null) goto L9;
        r1 = r6.getAttachBlock();
        goto L10
    L9:
        r1 = null;
        goto L10
    L21:
        if (BlockLogger.Companion.debug() == true) goto L23;
        return true;
    L23:
        if (BlockInit.INSTANCE.enableDebugDependencyCheck() == true) goto L25;
        return true;
    L25:
        if (findLowerObserver((BaseBlock) r4, r5) == false) goto L39;
        handleUnexpectedEventDepend(r4, r5);
        return true;
    L39:
        return true;
    L12:
        r2 = null;
        goto L13
    L29:
        r1 = null;
        goto L10
    }

    private final boolean findLowerObserver(BaseBlock<?, ?> r6, Event r7) {
        boolean r0 = false;
        if (r6 != null) goto L6;
        return false;
    L6:
        if ((r6 instanceof CoreTreeLayerBlock) == false) goto L8;
        BlockUnitHandler r8 = BlockExtKt.blockHandler(r6);
    L9:
        BaseBlock<?, ?> r1 = null;
        if (r8 == null) goto L19;
        List<BaseBlock<?, ?>> r9 = r8.getChildBlocks();
        if (r9 == null) goto L19;
        Iterator<T> r10 = r9.iterator();
        BaseBlock<?, ?> r2 = null;
    L15:
        if (r10.hasNext() == false) goto L21;
        BaseBlock<?, ?> r3 = (BaseBlock) r10.next();
        if ((r3 instanceof CoreTreeLayerBlock) == false) goto L15;
        r2 = r3;
    L21:
        if (((CoreTreeLayerBlock) r2) != null) goto L23;
        return false;
    L23:
        boolean r11 = r2 instanceof BaseBlock;
        if (r11 == false) goto L26;
        BaseBlock<?, ?> r4 = r2;
    L27:
        if (r4 == null) goto L33;
        BlockUnitHandler r5 = BlockExtKt.blockHandler(r4);
        if (r5 == null) goto L33;
        Map<Class<Event>, List<IObserver<Event>>> r12 = r5.getEventToObserverMap();
        if (r12 == null) goto L33;
        List<IObserver<Event>> r13 = r12.get(r7.getClass());
    L35:
        if (r13 != null) goto L37;
    L39:
        if (r0 == false) goto L41;
        return true;
    L41:
        if (r11 == false) goto L44;
        r1 = r2;
    L44:
        return findLowerObserver(r1, r7);
    L37:
        if ((!r13.isEmpty()) != true) goto L39;
        r0 = true;
    L33:
        r13 = null;
        goto L35
    L26:
        r4 = null;
    L19:
        r2 = null;
        goto L21
    L8:
        r8 = r6.getParent$blockframework_release();
        goto L9
    }
}
