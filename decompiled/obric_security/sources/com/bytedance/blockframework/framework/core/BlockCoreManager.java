package com.bytedance.blockframework.framework.core;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import com.bytedance.blockframework.contract.AbstractBlock;
import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.base.IUIBlock;
import com.bytedance.blockframework.framework.config.BlockInit;
import com.bytedance.blockframework.framework.core.message.BlockContractManager;
import com.bytedance.blockframework.framework.join.IBlockScene;
import com.bytedance.blockframework.framework.monitor.BlockLoggerKt;
import com.bytedance.blockframework.framework.monitor.BlockMonitor;
import com.bytedance.blockframework.framework.monitor.BlockMonitorKt;
import com.bytedance.blockframework.framework.task.BlockViewBuildTask;
import com.bytedance.blockframework.framework.task.ITaskManager;
import com.bytedance.blockframework.framework.task.TaskManager;
import com.bytedance.blockframework.framework.utils.BlockExtKt;
import com.bytedance.blockframework.framework.utils.LifecycleUtil;
import com.bytedance.blockframework.interaction.Event;
import com.bytedance.blockframework.interaction.IBlockMessageCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockCoreManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010&\u001a\u00020\u00062\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J+\u0010(\u001a\u00020\u0006\"\u0004\b\u0000\u0010)\"\u000e\b\u0001\u0010**\b\u0012\u0004\u0012\u0002H)0+2\u0006\u0010,\u001a\u0002H*H\u0007¢\u0006\u0002\u0010-J?\u0010.\u001a\u00020\u0006\"\u0004\b\u0000\u0010)\"\u000e\b\u0001\u0010**\b\u0012\u0004\u0012\u0002H)0+2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H*0\f2\u0006\u0010,\u001a\u0002H*H\u0002¢\u0006\u0002\u00100J\u0018\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u000204H\u0002J\u000e\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u000207J\u0016\u00108\u001a\u00020\r2\u000e\u0010/\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fJ!\u00109\u001a\u0004\u0018\u0001H:\"\u0004\b\u0000\u0010:2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H:0<¢\u0006\u0002\u0010=J\u0006\u0010>\u001a\u00020\u0014J\b\u0010?\u001a\u00020\u0006H\u0002J?\u0010@\u001a\u00020\u0006\"\u0004\b\u0000\u0010)\"\u000e\b\u0001\u0010**\b\u0012\u0004\u0012\u0002H)0+2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H*0\f2\u0006\u0010,\u001a\u0002H*H\u0002¢\u0006\u0002\u00100J4\u0010A\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0018H\u0007J\u000e\u0010C\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020FJ\u000e\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u0014R*\u0010\u0003\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/bytedance/blockframework/framework/core/BlockCoreManager;", "", "()V", "afterBindTasks", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "blockContractManager", "Lcom/bytedance/blockframework/framework/core/message/BlockContractManager;", "blockHandlerMap", "", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "Lcom/bytedance/blockframework/framework/core/BlockUnitHandler;", "context", "Landroid/content/Context;", "hasBind", "", "isViewCreateCompleted", "messageCenter", "Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;", "pendingBindTask", "rootBlock", "rootView", "Landroid/view/View;", "scene", "Lcom/bytedance/blockframework/framework/join/IBlockScene;", "tagName", "", "getTagName", "()Ljava/lang/String;", "tagName$delegate", "Lkotlin/Lazy;", "taskManager", "Lcom/bytedance/blockframework/framework/task/ITaskManager;", "uiTasks", "", "Lcom/bytedance/blockframework/framework/task/BlockViewBuildTask;", "addAfterBindTask", "action", "bindBlockModel", "D", "M", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "model", "(Lcom/bytedance/blockframework/framework/core/IBlockModel;)V", "bindInner", "block", "(Lcom/bytedance/blockframework/framework/base/BaseBlock;Lcom/bytedance/blockframework/framework/core/IBlockModel;)V", "buildUIBlock", "target", "uiBlock", "Lcom/bytedance/blockframework/framework/base/IUIBlock;", "dispatchLifecycleState", "state", "Landroidx/lifecycle/Lifecycle$State;", "findBlockHandler", "getBlockService", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getMessageCenter", "handleBlockTasks", "immediateBindInner", "initRootBlock", "parentView", "initScene", "notifyEvent", "event", "Lcom/bytedance/blockframework/interaction/Event;", "setMessageCenter", "center", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlockCoreManager {
    private final ArrayList<Function0<Unit>> afterBindTasks;
    private BlockContractManager blockContractManager;
    private Map<BaseBlock<?, ?>, BlockUnitHandler> blockHandlerMap;
    private Context context;
    private boolean hasBind;
    private boolean isViewCreateCompleted;
    private IBlockMessageCenter messageCenter;
    private Function0<Unit> pendingBindTask;
    private BaseBlock<?, ?> rootBlock;
    private View rootView;
    private IBlockScene scene;
    private final Lazy tagName$delegate;
    private ITaskManager taskManager;
    private List<BlockViewBuildTask> uiTasks;

    public BlockCoreManager() {
        this.tagName$delegate = LazyKt.lazy(new BlockCoreManager$tagName$2(this));
        this.uiTasks = new ArrayList();
        this.blockHandlerMap = new LinkedHashMap();
        this.afterBindTasks = new ArrayList();
    }

    public static final /* synthetic */ void access$bindInner(BlockCoreManager r0, BaseBlock r1, IBlockModel r2) {
        r0.bindInner(r1, r2);
    }

    public static final /* synthetic */ void access$buildUIBlock(BlockCoreManager r0, View r1, IUIBlock r2) {
        r0.buildUIBlock(r1, r2);
    }

    public static final /* synthetic */ BlockContractManager access$getBlockContractManager$p(BlockCoreManager r0) {
        return r0.blockContractManager;
    }

    public static final /* synthetic */ Function0 access$getPendingBindTask$p(BlockCoreManager r0) {
        return r0.pendingBindTask;
    }

    public static final /* synthetic */ BaseBlock access$getRootBlock$p(BlockCoreManager r0) {
        return r0.rootBlock;
    }

    public static final /* synthetic */ View access$getRootView$p(BlockCoreManager r0) {
        return r0.rootView;
    }

    public static final /* synthetic */ IBlockScene access$getScene$p(BlockCoreManager r0) {
        return r0.scene;
    }

    public static final /* synthetic */ String access$getTagName(BlockCoreManager r0) {
        return r0.getTagName();
    }

    public static final /* synthetic */ void access$setPendingBindTask$p(BlockCoreManager r0, Function0 r1) {
        r0.pendingBindTask = r1;
    }

    public static final /* synthetic */ void access$setViewCreateCompleted$p(BlockCoreManager r0, boolean r1) {
        r0.isViewCreateCompleted = r1;
    }

    private final String getTagName() {
        return (String) this.tagName$delegate.getValue();
    }

    public final void initScene(IBlockScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.scene = r2;
    }

    public static /* synthetic */ void initRootBlock$default(BlockCoreManager r0, Context r1, BaseBlock r2, IBlockMessageCenter r3, View r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.initRootBlock(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initRootBlock(Context r27, BaseBlock<?, ?> r28, IBlockMessageCenter r29, View r30) {
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r28, "rootBlock");
        Intrinsics.checkNotNullParameter(r29, "messageCenter");
        long r4 = BlockLoggerKt.currentTime();
        BlockMonitor r6 = BlockMonitor.INSTANCE;
        IBlockScene r7 = this.scene;
        IBlockScene r16 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scene");
        r7 = null;
    L5:
        BlockMonitor.record$default(r6, r7.getName(), getTagName(), BlockMonitorKt.TYPE_BLOCK_TREE_INIT, "init_start", 0, 16, null);
        if (r28.getParent$blockframework_release() != null) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == false) goto L32;
        this.context = r27;
        this.rootBlock = r28;
        r28.setImmediateBind$blockframework_release(true);
        IBlockScene r9 = this.scene;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("scene");
        r9 = null;
    L13:
        this.taskManager = new TaskManager(r9, BlockInit.INSTANCE.allTaskMustRunOnMain());
        BlockContractManager r10 = new BlockContractManager(r27, r29);
        this.blockContractManager = r10;
        r10.registerBlock(r28);
        if ((r28 instanceof IUIBlock) == false) goto L22;
        long r11 = BlockLoggerKt.currentTime();
        BlockMonitor r17 = BlockMonitor.INSTANCE;
        IBlockScene r1 = this.scene;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("scene");
        r1 = null;
    L18:
        BlockMonitor.record$default(r17, r1.getName(), r28.getBlockKey(), BlockMonitorKt.TYPE_BLOCK_VIEW_CREATE, "view_create_start", 0, 16, null);
        IUIBlock r2 = (IUIBlock) r28;
        r2.setContainerView(r2.onCreateView(r30));
        BlockMonitor r18 = BlockMonitor.INSTANCE;
        IBlockScene r3 = this.scene;
        if (r3 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("scene");
        r3 = null;
    L21:
        r18.record(r3.getName(), r28.getBlockKey(), BlockMonitorKt.TYPE_BLOCK_VIEW_CREATE, "view_create_end", BlockLoggerKt.currentTime() - r11);
        r2.onViewCreated(r2.getContainerView());
        this.rootView = r2.getContainerView();
    L22:
        r28.setBlockActivated(true);
        BlockUnitHandler r5 = findBlockHandler(r28);
        BlockContractManager r12 = this.blockContractManager;
        if (r12 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("blockContractManager");
        r12 = null;
    L25:
        r28.generateSubBlocks(new BlockGeneratorImpl(r5, r12, this.uiTasks));
        handleBlockTasks();
        BlockMonitor r13 = BlockMonitor.INSTANCE;
        IBlockScene r14 = this.scene;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("scene");
    L29:
        r13.record(r16.getName(), getTagName(), BlockMonitorKt.TYPE_BLOCK_TREE_INIT, "init_end", BlockLoggerKt.currentTime() - r4);
        return;
    L28:
        r16 = r14;
        goto L29
    L32:
        throw new IllegalStateException((r28.getClass().getSimpleName() + " is rootBlock and can't have a parent").toString());
    L8:
        r8 = false;
        goto L9
    }

    private final void handleBlockTasks() {
        ITaskManager r0 = this.taskManager;
        ITaskManager r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("taskManager");
        r0 = null;
    L5:
        r0.addTask(this.uiTasks);
        final long r3 = BlockLoggerKt.currentTime();
        BlockMonitor r5 = BlockMonitor.INSTANCE;
        IBlockScene r1 = this.scene;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("scene");
        r1 = null;
    L8:
        BlockMonitor.record$default(r5, r1.getName(), getTagName(), BlockMonitorKt.TYPE_BLOCK_TREE_CREATE, "build_start", 0, 16, null);
        ITaskManager r4 = this.taskManager;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("taskManager");
    L12:
        r2.handleTasks(new C01321(this), new AnonymousClass2(this), new AnonymousClass3(this, r3));
        return;
    L11:
        r2 = r4;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void buildUIBlock(View r2, IUIBlock r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.blockframework.framework.base.BaseBlock<*, *>");
        BlockUnitHandler r1 = findBlockHandler((BaseBlock) r3);
        r1.installView(r2);
        r1.activeView();
    }

    public final <D, M extends IBlockModel<D>> void bindBlockModel(final M r14) {
        Intrinsics.checkNotNullParameter(r14, "model");
        final long r0 = BlockLoggerKt.currentTime();
        BlockMonitor r2 = BlockMonitor.INSTANCE;
        IBlockScene r3 = this.scene;
        IBlockScene r12 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scene");
        r3 = null;
    L5:
        BlockMonitor.record$default(r2, r3.getName(), getTagName(), BlockMonitorKt.TYPE_BLOCK_TREE_BIND, "bind_start", 0, 16, null);
        this.hasBind = false;
        BaseBlock<?, ?> r4 = this.rootBlock;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootBlock");
        r4 = null;
    L8:
        immediateBindInner(r4, r14);
        if (this.isViewCreateCompleted == false) goto L18;
        this.pendingBindTask = null;
        BaseBlock<?, ?> r5 = this.rootBlock;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("rootBlock");
        r5 = null;
    L13:
        bindInner(r5, r14);
        BlockMonitor r6 = BlockMonitor.INSTANCE;
        IBlockScene r15 = this.scene;
        if (r15 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("scene");
    L17:
        r6.record(r12.getName(), getTagName(), BlockMonitorKt.TYPE_BLOCK_TREE_BIND, "bind_end", BlockLoggerKt.currentTime() - r0);
        return;
    L16:
        r12 = r15;
        goto L17
    L18:
        this.pendingBindTask = new AnonymousClass1(this, r14, r0);
    }

    private final <D, M extends IBlockModel<D>> void immediateBindInner(BaseBlock<D, M> r1, final M r2) {
        BlockExtKt.traverseBlock(r1, new C01331(r2));
    }

    private final <D, M extends IBlockModel<D>> void bindInner(BaseBlock<D, M> r2, final M r3) {
        BlockExtKt.traverseBlock(r2, new C01311(r3));
        this.hasBind = true;
        Iterator<T> r4 = this.afterBindTasks.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((Function0) r4.next()).invoke();
        goto L4
    L6:
        this.afterBindTasks.clear();
    }

    public final void addAfterBindTask(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (this.hasBind == false) goto L5;
        r2.invoke();
        return;
    L5:
        this.afterBindTasks.add(r2);
    }

    public final BlockUnitHandler findBlockHandler(BaseBlock<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        BlockUnitHandler r0 = this.blockHandlerMap.get(r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (this.context != null) goto L7;
        this.context = r3.getContext();
    L7:
        BlockUnitHandler.Companion r1 = BlockUnitHandler.Companion;
        Context r2 = this.context;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r2 = null;
    L10:
        BlockUnitHandler r4 = r1.create(r2, r3);
        this.blockHandlerMap.put(r3, r4);
        r4.attachLifecycle();
        return r4;
    }

    public final void setMessageCenter(IBlockMessageCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "center");
        this.messageCenter = r2;
    }

    public final IBlockMessageCenter getMessageCenter() {
        BlockContractManager r0 = this.blockContractManager;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("blockContractManager");
        r0 = null;
    L6:
        return r0.getMessageCenter();
    }

    public final <T> T getBlockService(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        BaseBlock<?, ?> r3 = this.rootBlock;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootBlock");
        r3 = null;
    L6:
        return (T) AbstractBlock.getBlockService$default(r3, r4, false, 2, null);
    }

    public final void notifyEvent(Event r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        BlockContractManager r1 = this.blockContractManager;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("blockContractManager");
        r1 = null;
    L5:
        r1.notifyEvent(r2);
    }

    public final void dispatchLifecycleState(Lifecycle.State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        LifecycleUtil r0 = LifecycleUtil.INSTANCE;
        BaseBlock<?, ?> r1 = this.rootBlock;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootBlock");
        r1 = null;
    L5:
        r0.handleLifecycleState(r2, r1);
    }
}
