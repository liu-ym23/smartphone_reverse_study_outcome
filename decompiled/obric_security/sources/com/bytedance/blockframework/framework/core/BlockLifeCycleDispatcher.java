package com.bytedance.blockframework.framework.core;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.utils.BlockExtKt;
import com.bytedance.blockframework.framework.utils.LifecycleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockLifeCycleDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/blockframework/framework/core/BlockLifeCycleDispatcher;", "Landroidx/lifecycle/LifecycleEventObserver;", "parentBlock", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "(Lcom/bytedance/blockframework/framework/base/BaseBlock;)V", "TAG", "", "onCreate", "", "onDestroy", "onPause", "onResume", AgentConstants.ON_START, "onStateChanged", DBHelper.BATTERY_COL_SOURCE, "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "onStop", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlockLifeCycleDispatcher implements LifecycleEventObserver {
    private final String TAG;
    private final BaseBlock<?, ?> parentBlock;

    /* JADX INFO: compiled from: BlockLifeCycleDispatcher.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[Lifecycle.Event.ON_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[Lifecycle.Event.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public BlockLifeCycleDispatcher(BaseBlock<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "parentBlock");
        this.parentBlock = r2;
        this.TAG = "BlockLifeCycleDispatcher";
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.checkNotNullParameter(r3, "event");
        switch(WhenMappings.$EnumSwitchMapping$0[r3.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L17;
        };
    L5:
        onDestroy();
        return;
    L6:
        onStop();
        return;
    L7:
        onPause();
        return;
    L8:
        onResume();
        return;
    L9:
        onStart();
        return;
    L10:
        onCreate();
        return;
    }

    private final void onCreate() {
        Iterator<T> r3 = BlockExtKt.blockHandler(this.parentBlock).getChildBlocks().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        BaseBlock<?, ?> r0 = (BaseBlock) r3.next();
        LifecycleUtil.INSTANCE.handleLifecycleState(Lifecycle.State.CREATED, r0);
        goto L4
    }

    private final void onStart() {
        List<BaseBlock<?, ?>> r3 = BlockExtKt.blockHandler(this.parentBlock).getChildBlocks();
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r1 = r4.next();
        if ((!((BaseBlock) r1).getLazyActive()) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        Iterator r5 = r0.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        LifecycleUtil.INSTANCE.handleLifecycleState(Lifecycle.State.STARTED, (BaseBlock) r5.next());
        goto L10
    }

    private final void onResume() {
        List<BaseBlock<?, ?>> r3 = BlockExtKt.blockHandler(this.parentBlock).getChildBlocks();
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r1 = r4.next();
        if ((!((BaseBlock) r1).getLazyActive()) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        Iterator r5 = r0.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        LifecycleUtil.INSTANCE.handleLifecycleState(Lifecycle.State.RESUMED, (BaseBlock) r5.next());
        goto L10
    }

    private final void onPause() {
        List<BaseBlock<?, ?>> r3 = BlockExtKt.blockHandler(this.parentBlock).getChildBlocks();
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r1 = r4.next();
        if ((!((BaseBlock) r1).getLazyActive()) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        Iterator r5 = r0.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        LifecycleUtil.INSTANCE.handleLifecycleState(Lifecycle.State.STARTED, (BaseBlock) r5.next());
        goto L10
    }

    private final void onStop() {
        List<BaseBlock<?, ?>> r3 = BlockExtKt.blockHandler(this.parentBlock).getChildBlocks();
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r1 = r4.next();
        if ((!((BaseBlock) r1).getLazyActive()) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        Iterator r5 = r0.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        LifecycleUtil.INSTANCE.handleLifecycleState(Lifecycle.State.CREATED, (BaseBlock) r5.next());
        goto L10
    }

    private final void onDestroy() {
        List<BaseBlock<?, ?>> r0 = BlockExtKt.blockHandler(this.parentBlock).getChildBlocks();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((!((BaseBlock) r3).getLazyActive()) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        LifecycleUtil.INSTANCE.handleLifecycleState(Lifecycle.State.DESTROYED, (BaseBlock) r4.next());
        goto L10
    L12:
        this.parentBlock.getLifecycle().removeObserver(this);
    }
}
