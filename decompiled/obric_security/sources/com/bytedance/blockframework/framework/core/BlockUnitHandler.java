package com.bytedance.blockframework.framework.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import com.bytedance.blockframework.contract.AbstractBlock;
import com.bytedance.blockframework.contract.BlockImplWrapper;
import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.base.IUIBlock;
import com.bytedance.blockframework.framework.config.BlockInit;
import com.bytedance.blockframework.framework.monitor.BlockLogger;
import com.bytedance.blockframework.framework.utils.BlockExtKt;
import com.bytedance.blockframework.interaction.Event;
import com.bytedance.blockframework.interaction.IObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockUnitHandler.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 62\u00020\u0001:\u00016B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0018\u001a\u00020\u0019J$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0006\u0010 \u001a\u00020\u0019J\b\u0010!\u001a\u0004\u0018\u00010\u001cJ\u0014\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050#J\u000e\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u001cJ\u0016\u0010&\u001a\u00020\u00192\u000e\u0010'\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0012J+\u0010+\u001a\u0004\u0018\u0001H,\"\u0004\b\u0000\u0010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0\u00112\b\b\u0002\u0010.\u001a\u00020)¢\u0006\u0002\u0010/J\"\u00100\u001a\u00020\u00192\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00120\u00132\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\"\u00103\u001a\u00020\u0019\"\u0004\b\u0000\u0010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0\u00112\u0006\u00104\u001a\u00020\u0017J\u0018\u00105\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u0019\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR/\u0010\u000f\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00130\f0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u0004\u0012\u00020\u00170\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/blockframework/framework/core/BlockUnitHandler;", "", "context", "Landroid/content/Context;", "attachBlock", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "lifecycleHandler", "Lcom/bytedance/blockframework/framework/core/BlockLifeCycleDispatcher;", "(Landroid/content/Context;Lcom/bytedance/blockframework/framework/base/BaseBlock;Lcom/bytedance/blockframework/framework/core/BlockLifeCycleDispatcher;)V", "getAttachBlock", "()Lcom/bytedance/blockframework/framework/base/BaseBlock;", "childList", "", "getContext", "()Landroid/content/Context;", "eventToObserverMap", "", "Ljava/lang/Class;", "Lcom/bytedance/blockframework/interaction/Event;", "Lcom/bytedance/blockframework/interaction/IObserver;", "getEventToObserverMap", "()Ljava/util/Map;", "serviceMap", "Lcom/bytedance/blockframework/contract/BlockImplWrapper;", "activeView", "", "addViewInPlaceholder", "view", "Landroid/view/View;", "placeHolder", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "attachLifecycle", "getAttachView", "getChildBlocks", "", "installView", "target", "loadBlock", "subBlock", "notifyEvent", "", "event", "queryService", ExifInterface.GPS_DIRECTION_TRUE, "klass", "activeIfNeed", "(Ljava/lang/Class;Z)Ljava/lang/Object;", "registerObserver", "observer", "eventClass", "registerService", "blockImplWrapper", "replaceSelfWithView", "Companion", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlockUnitHandler {
    public static final Companion Companion = null;
    private final BaseBlock<?, ?> attachBlock;
    private final List<BaseBlock<?, ?>> childList;
    private final Context context;
    private final Map<Class<Event>, List<IObserver<Event>>> eventToObserverMap;
    private final BlockLifeCycleDispatcher lifecycleHandler;
    private final Map<Class<?>, BlockImplWrapper> serviceMap;

    /* JADX INFO: compiled from: BlockUnitHandler.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b¨\u0006\t"}, d2 = {"Lcom/bytedance/blockframework/framework/core/BlockUnitHandler$Companion;", "", "()V", "create", "Lcom/bytedance/blockframework/framework/core/BlockUnitHandler;", "context", "Landroid/content/Context;", "block", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final BlockUnitHandler create(Context r2, BaseBlock<?, ?> r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "block");
            return new BlockUnitHandler(r2, r3, new BlockLifeCycleDispatcher(r3));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BlockUnitHandler(Context r2, BaseBlock<?, ?> r3, BlockLifeCycleDispatcher r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attachBlock");
        Intrinsics.checkNotNullParameter(r4, "lifecycleHandler");
        this.context = r2;
        this.attachBlock = r3;
        this.lifecycleHandler = r4;
        this.childList = new ArrayList();
        this.serviceMap = new LinkedHashMap();
        this.eventToObserverMap = new LinkedHashMap();
    }

    public static final /* synthetic */ BlockLifeCycleDispatcher access$getLifecycleHandler$p(BlockUnitHandler r0) {
        return r0.lifecycleHandler;
    }

    public final Context getContext() {
        return this.context;
    }

    public final BaseBlock<?, ?> getAttachBlock() {
        return this.attachBlock;
    }

    public final Map<Class<Event>, List<IObserver<Event>>> getEventToObserverMap() {
        return this.eventToObserverMap;
    }

    public final void registerObserver(IObserver<Event> r2, Class<Event> r3) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        Intrinsics.checkNotNullParameter(r3, "eventClass");
        ArrayList r0 = this.eventToObserverMap.get(r3);
        if (r0 != null) goto L6;
        r0 = new ArrayList();
        this.eventToObserverMap.put(r3, r0);
    L6:
        if (r0.contains(r2) == true) goto L9;
        r0.add(r2);
        return;
    }

    public final boolean notifyEvent(Event r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        List<IObserver<Event>> r2 = this.eventToObserverMap.get(r3.getClass());
        if (r2 != null) goto L6;
        return false;
    L6:
        Iterator<IObserver<Event>> r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L18;
        IObserver<Event> r0 = r4.next();
        if ((r0 instanceof AbstractBlock) == false) goto L15;
        if (((AbstractBlock) r0).isActive() == false) goto L8;
    L15:
        if (r0.onEvent(r3) == false) goto L8;
        if (r3.getCanIntercept() == false) goto L8;
        return true;
    L18:
        return true;
    }

    public final void attachLifecycle() {
        final Lifecycle r0 = this.attachBlock.getLifecycle();
        BlockExtKt.syncInvoke(new AnonymousClass1(r0, this));
    }

    public final void loadBlock(BaseBlock<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "subBlock");
        r2.setParent$blockframework_release(this);
        this.childList.add(r2);
    }

    public final void installView(View r6) {
        Intrinsics.checkNotNullParameter(r6, "target");
        IObserver r0 = this.attachBlock;
        BaseBlock r2 = null;
        if ((r0 instanceof IUIBlock) == false) goto L5;
        IUIBlock r1 = (IUIBlock) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        View r3 = getAttachView();
        if (r1.customGenerateView(r6, r3) == false) goto L13;
        r1.setContainerView(r6);
        return;
    L13:
        if (r1.getUiConfig().getParentId() != (-1)) goto L16;
        r1.setContainerView(r6);
        return;
    L16:
        if (r3 == null) goto L18;
        View r4 = r3.findViewById(r1.getUiConfig().getParentId());
    L19:
        if (r4 != null) goto L34;
        if (BlockInit.INSTANCE.logOptEnable() == true) goto L23;
    L24:
        StringBuilder r7 = new StringBuilder();
        if ((r1 instanceof BaseBlock) == false) goto L27;
        r2 = (BaseBlock) r1;
    L27:
        if (r2 == null) goto L30;
        String r5 = r2.getBlockKey();
        if (r5 == null) goto L30;
    L31:
        BlockExtKt.uploadException(new RuntimeException(r7.append(r5).append(" placeHolder is Null").toString()), true);
        return;
    L30:
        r5 = "";
        goto L31
    L23:
        if (BlockLogger.Companion.debug() == true) goto L24;
        return;
    L34:
        if (r1.getUiConfig().getReplaceParent() == false) goto L36;
        replaceSelfWithView(r6, r4);
    L37:
        r1.setContainerView(r6);
        return;
    L36:
        addViewInPlaceholder(r6, r4, r1.getUiConfig().getLayoutParams());
        goto L37
    L18:
        r4 = null;
        goto L19
    L5:
        r1 = null;
        goto L6
    }

    private final void replaceSelfWithView(View r2, View r3) {
        ViewParent r1 = r3.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L5;
        ViewGroup r4 = (ViewGroup) r1;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        int r0 = r4.indexOfChild(r3);
        r4.removeViewInLayout(r3);
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if (r5 == null) goto L11;
        r4.addView(r2, r0, r5);
        return;
    L11:
        r4.addView(r2, r0);
        return;
    L5:
        r4 = null;
        goto L6
    }

    static /* synthetic */ void addViewInPlaceholder$default(BlockUnitHandler r0, View r1, View r2, ViewGroup.LayoutParams r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.addViewInPlaceholder(r1, r2, r3);
    }

    private final void addViewInPlaceholder(View r1, View r2, ViewGroup.LayoutParams r3) {
        if ((r2 instanceof ViewGroup) == false) goto L5;
        ViewGroup r4 = (ViewGroup) r2;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        if (r3 == null) goto L10;
        r4.addView(r1, r3);
        return;
    L10:
        r4.addView(r1);
        return;
    L5:
        r4 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void activeView() {
        IObserver r1 = this.attachBlock;
        if ((r1 instanceof IUIBlock) == false) goto L5;
        IUIBlock r2 = (IUIBlock) r1;
    L6:
        if (r2 != 0) goto L8;
        return;
    L8:
        View r0 = r2.getView();
        if (r0 == null) goto L12;
        r2.onViewCreated(r0);
        ((BaseBlock) r2).setBlockActivated(true);
        return;
    L12:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final View getAttachView() {
        BaseBlock<?, ?> r4 = this.attachBlock;
        View r3 = null;
    L3:
        boolean r2 = false;
    L4:
        if (r2 == true) goto L20;
        if ((r4 instanceof IUIBlock) == false) goto L8;
        IUIBlock r5 = (IUIBlock) r4;
    L9:
        if (r5 == null) goto L11;
        r3 = r5.getView();
    L12:
        if (r4 == null) goto L16;
        BlockUnitHandler r6 = r4.getParent$blockframework_release();
        if (r6 == null) goto L16;
        r4 = r6.attachBlock;
    L17:
        if (r3 != null) goto L19;
        if (r4 != null) goto L3;
    L19:
        r2 = true;
    L16:
        r4 = null;
        goto L17
    L11:
        r3 = null;
        goto L12
    L8:
        r5 = null;
        goto L9
    L20:
        return r3;
    }

    public final <T> void registerService(Class<T> r4, BlockImplWrapper r5) {
        Intrinsics.checkNotNullParameter(r4, "klass");
        Intrinsics.checkNotNullParameter(r5, "blockImplWrapper");
        if (this.serviceMap.containsKey(r4) == true) goto L5;
    L9:
        this.serviceMap.put(r4, r5);
        return;
    L5:
        if (BlockInit.INSTANCE.logOptEnable() == true) goto L7;
    L8:
        BlockExtKt.uploadException(new RuntimeException("registerService " + r4 + " already exists"), true);
        goto L9
    L7:
        if (BlockLogger.Companion.debug() == false) goto L9;
        goto L8
    }

    public static /* synthetic */ Object queryService$default(BlockUnitHandler r0, Class r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.queryService(r1, r2);
    }

    public final <T> T queryService(Class<T> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "klass");
        if (this.serviceMap.containsKey(r3) == false) goto L19;
        BlockImplWrapper r0 = this.serviceMap.get(r3);
        if (r0 == null) goto L7;
        Object r1 = r0.getImpl();
    L8:
        if (r4 == true) goto L10;
    L15:
        BlockImplWrapper r2 = this.serviceMap.get(r3);
        if (r2 != null) goto L25;
        return null;
    L25:
        return (T) r2.getImpl();
    L10:
        if ((r1 instanceof BaseBlock) == false) goto L12;
        BaseBlock r5 = (BaseBlock) r1;
    L13:
        if (r5 == null) goto L15;
        r5.activeIfNeed();
        goto L15
    L12:
        r5 = null;
        goto L13
    L7:
        r1 = null;
        goto L8
    L19:
        if (BlockInit.INSTANCE.logOptEnable() == true) goto L21;
    L22:
        BlockExtKt.uploadException(new RuntimeException("queryService " + r3 + " not find"), false);
        return null;
    L21:
        if (BlockLogger.Companion.debug() == true) goto L22;
        return null;
    }

    public final List<BaseBlock<?, ?>> getChildBlocks() {
        return this.childList;
    }
}
