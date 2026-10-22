package com.obric.security.health.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.blockframework.framework.base.UIBlock;
import com.bytedance.blockframework.framework.core.BlockGenerator;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.core.SubBlockCreator;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedance.blockframework.interaction.Event;
import com.obric.oui.actionbar.v2.OBottomActionBarNormalHorizontal;
import com.obric.oui.button.OButton;
import com.obric.oui.utils.StyleUtil;
import com.obric.security.R;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.mainpage.util.DisplaySizeStableContext;
import com.obric.security.mainpage.view.RotatePannelManager2;
import com.obric.security.mainpage.view.RotatePannelView2;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OptimizeCenterRootBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 D2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0002DEB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0015H\u0002J\u0010\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0015H\u0002J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\f2\u0006\u0010-\u001a\u00020\u000eH\u0002J\u0018\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000eH\u0002J\u0010\u00101\u001a\u00020'2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u0002052\u0006\u0010(\u001a\u00020\u0015H\u0002J\b\u00106\u001a\u00020\u000eH\u0016J\u0012\u00107\u001a\u00020\u00152\b\u00108\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020'H\u0002J\b\u0010=\u001a\u00020'H\u0016J\u000e\u0010>\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0012J\u0010\u0010?\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0012H\u0002J\u0010\u0010@\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0012H\u0002J\u0010\u0010A\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0012H\u0002J\u0018\u0010B\u001a\u00020'2\u0006\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000eH\u0002J\u0018\u0010C\u001a\u00020'2\u0006\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000eH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/obric/security/health/ui/OptimizeCenterRootBlock;", "Lcom/bytedance/blockframework/framework/base/UIBlock;", "Ljava/util/Objects;", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "rootView", "Landroid/view/ViewGroup;", "listener", "Lcom/obric/security/health/ui/OptimizeCenterRootBlock$Listener;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Landroid/view/ViewGroup;Lcom/obric/security/health/ui/OptimizeCenterRootBlock$Listener;Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "footerButton", "Lcom/obric/oui/button/OButton;", "footerButtonStyle", "", "footerContainer", "Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalHorizontal;", "latestDisplayState", "Lcom/obric/security/health/ui/OptimizeCenterUiState;", "latestState", "optimizeScroll", "Landroid/view/View;", "panelAnimationFinished", "", "panelContainer", "panelFinished", "panelStarted", "pendingResultState", "resultBlock", "Lcom/obric/security/health/ui/OptimizeResultBlock;", "resultContainer", "resultPanelScore", "Ljava/lang/Integer;", "rotatePanelManager", "Lcom/obric/security/mainpage/view/RotatePannelManager2;", "runningBlock", "Lcom/obric/security/health/ui/OptimizeRunningBlock;", "runningContainer", "applyStablePanelSpacing", "", "view", "bindViews", "displayState", "state", "ensureFooterButton", "styleRes", "finishOptimizePanelIfNeeded", "manager", "score", "generateSubBlocks", "generator", "Lcom/bytedance/blockframework/framework/core/BlockGenerator;", "inflateStableRotatePanel", "Lcom/obric/security/mainpage/view/RotatePannelView2;", "layoutResource", "onCreateView", "parent", "onEvent", "event", "Lcom/bytedance/blockframework/interaction/Event;", "onFooterClick", "onRegister", "render", "renderContent", "renderFooter", "renderScorePanel", "showResultPanelIfNeeded", "startOptimizePanelIfNeeded", "Companion", "Listener", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class OptimizeCenterRootBlock extends UIBlock<Objects, IBlockModel<Objects>> {
    private static final Companion Companion = null;

    @Deprecated
    private static final int MAX_SCORE = 100;

    @Deprecated
    private static final float OPTIMIZE_PANEL_HEIGHT_DP = 232.0f;

    @Deprecated
    private static final float PANEL_TOP_MARGIN_DP = 8.0f;

    @Deprecated
    private static final float PANEL_TOP_PADDING_DP = 112.0f;

    @Deprecated
    private static final int RESULT_BUTTON_STYLE = 0;

    @Deprecated
    private static final float ROTATE_PANEL_SIZE_DP = 212.0f;

    @Deprecated
    private static final int RUNNING_BUTTON_STYLE = 0;

    @Deprecated
    private static final String SOURCE = "OptimizeCenterRootBlock";
    private OButton footerButton;
    private int footerButtonStyle;
    private OBottomActionBarNormalHorizontal footerContainer;
    private OptimizeCenterUiState latestDisplayState;
    private OptimizeCenterUiState latestState;
    private final Listener listener;
    private View optimizeScroll;
    private boolean panelAnimationFinished;
    private View panelContainer;
    private boolean panelFinished;
    private boolean panelStarted;
    private OptimizeCenterUiState pendingResultState;
    private OptimizeResultBlock resultBlock;
    private View resultContainer;
    private Integer resultPanelScore;
    private final ViewGroup rootView;
    private RotatePannelManager2 rotatePanelManager;
    private OptimizeRunningBlock runningBlock;
    private View runningContainer;

    /* JADX INFO: compiled from: OptimizeCenterRootBlock.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/security/health/ui/OptimizeCenterRootBlock$Companion;", "", "()V", "MAX_SCORE", "", "OPTIMIZE_PANEL_HEIGHT_DP", "", "PANEL_TOP_MARGIN_DP", "PANEL_TOP_PADDING_DP", "RESULT_BUTTON_STYLE", "ROTATE_PANEL_SIZE_DP", "RUNNING_BUTTON_STYLE", "SOURCE", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: OptimizeCenterRootBlock.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/obric/security/health/ui/OptimizeCenterRootBlock$Listener;", "", "onCancelOptimize", "", "onFinishPage", "onOptimizeAnimationEnd", "onOptimizeTodoItem", "itemId", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public interface Listener {
        void onCancelOptimize();

        void onFinishPage();

        void onOptimizeAnimationEnd();

        void onOptimizeTodoItem(String r1);
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[OptimizeCenterPhase.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[OptimizeCenterPhase.OPTIMIZING.ordinal()] = 1;
            r0[OptimizeCenterPhase.OPTIMIZED.ordinal()] = 2;
            r0[OptimizeCenterPhase.RESULT.ordinal()] = 3;
            int[] r1 = new int[OptimizeCenterPhase.values().length];
            $EnumSwitchMapping$1 = r1;
            r1[OptimizeCenterPhase.OPTIMIZING.ordinal()] = 1;
            r1[OptimizeCenterPhase.OPTIMIZED.ordinal()] = 2;
            r1[OptimizeCenterPhase.RESULT.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.ui.OptimizeCenterRootBlock$ensureFooterButton$1, reason: invalid class name */
    /* JADX INFO: compiled from: OptimizeCenterRootBlock.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButton;", "styledContext", "Landroid/content/Context;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "invoke"}, k = 3, mv = {1, 4, 3})
    static final class AnonymousClass1 extends Lambda implements Function3<Context, Integer, Integer, OButton> {
        final /* synthetic */ OptimizeCenterRootBlock this$0;

        AnonymousClass1(OptimizeCenterRootBlock r1) {
            this.this$0 = r1;
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ OButton invoke(Context r1, Integer r2, Integer r3) {
            return invoke(r1, r2.intValue(), r3.intValue());
        }

        public final OButton invoke(Context r9, int r10, int r11) {
            Intrinsics.checkNotNullParameter(r9, "styledContext");
            OButton r12 = new OButton(r9, null, 0, 0, null, 28, null);
            r12.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            r12.setTextSize(16.0f);
            r12.setOnClickListener(new OptimizeCenterRootBlock$ensureFooterButton$1$$special$$inlined$apply$lambda$1(this));
            return r12;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.ui.OptimizeCenterRootBlock$generateSubBlocks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OptimizeCenterRootBlock.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/blockframework/framework/core/SubBlockCreator;", "invoke"}, k = 3, mv = {1, 4, 3})
    static final class C03831 extends Lambda implements Function1<SubBlockCreator, Unit> {
        final /* synthetic */ OptimizeCenterRootBlock this$0;

        C03831(OptimizeCenterRootBlock r1) {
            this.this$0 = r1;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubBlockCreator r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SubBlockCreator r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            r2.addBlock(new C00591(this));
            r2.addBlock(new AnonymousClass2(this));
        }
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock
    public int layoutResource() {
        return -1;
    }

    public static final /* synthetic */ OptimizeCenterUiState access$getLatestState$p(OptimizeCenterRootBlock r0) {
        return r0.latestState;
    }

    public static final /* synthetic */ Listener access$getListener$p(OptimizeCenterRootBlock r0) {
        return r0.listener;
    }

    public static final /* synthetic */ boolean access$getPanelAnimationFinished$p(OptimizeCenterRootBlock r0) {
        return r0.panelAnimationFinished;
    }

    public static final /* synthetic */ boolean access$getPanelFinished$p(OptimizeCenterRootBlock r0) {
        return r0.panelFinished;
    }

    public static final /* synthetic */ OptimizeCenterUiState access$getPendingResultState$p(OptimizeCenterRootBlock r0) {
        return r0.pendingResultState;
    }

    public static final /* synthetic */ OptimizeResultBlock access$getResultBlock$p(OptimizeCenterRootBlock r0) {
        return r0.resultBlock;
    }

    public static final /* synthetic */ Integer access$getResultPanelScore$p(OptimizeCenterRootBlock r0) {
        return r0.resultPanelScore;
    }

    public static final /* synthetic */ OptimizeRunningBlock access$getRunningBlock$p(OptimizeCenterRootBlock r0) {
        return r0.runningBlock;
    }

    public static final /* synthetic */ void access$onFooterClick(OptimizeCenterRootBlock r0) {
        r0.onFooterClick();
    }

    public static final /* synthetic */ void access$setLatestState$p(OptimizeCenterRootBlock r0, OptimizeCenterUiState r1) {
        r0.latestState = r1;
    }

    public static final /* synthetic */ void access$setPanelAnimationFinished$p(OptimizeCenterRootBlock r0, boolean r1) {
        r0.panelAnimationFinished = r1;
    }

    public static final /* synthetic */ void access$setPanelFinished$p(OptimizeCenterRootBlock r0, boolean r1) {
        r0.panelFinished = r1;
    }

    public static final /* synthetic */ void access$setPendingResultState$p(OptimizeCenterRootBlock r0, OptimizeCenterUiState r1) {
        r0.pendingResultState = r1;
    }

    public static final /* synthetic */ void access$setResultBlock$p(OptimizeCenterRootBlock r0, OptimizeResultBlock r1) {
        r0.resultBlock = r1;
    }

    public static final /* synthetic */ void access$setResultPanelScore$p(OptimizeCenterRootBlock r0, Integer r1) {
        r0.resultPanelScore = r1;
    }

    public static final /* synthetic */ void access$setRunningBlock$p(OptimizeCenterRootBlock r0, OptimizeRunningBlock r1) {
        r0.runningBlock = r1;
    }

    public OptimizeCenterRootBlock(ViewGroup r11, Listener r12, IBlockContext r13) {
        Intrinsics.checkNotNullParameter(r11, "rootView");
        Intrinsics.checkNotNullParameter(r12, "listener");
        Intrinsics.checkNotNullParameter(r13, "blockContext");
        super(r13);
        this.rootView = r11;
        this.listener = r12;
        this.latestDisplayState = new OptimizeCenterUiState(null, 0, null, null, null, null, 63, null);
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public View onCreateView(View r1) {
        bindViews(this.rootView);
        OptimizeCenterUiState r2 = this.latestState;
        if (r2 == null) goto L6;
        render(r2);
    L6:
        return this.rootView;
    }

    private final void bindViews(View r3) {
        this.optimizeScroll = r3.findViewById(R.id.optimize_scroll);
        this.panelContainer = r3.findViewById(R.id.optimize_panel_container);
        this.runningContainer = r3.findViewById(R.id.optimize_running_container);
        this.resultContainer = r3.findViewById(R.id.optimize_result_container);
        this.footerContainer = (OBottomActionBarNormalHorizontal) r3.findViewById(R.id.optimize_footer);
        applyStablePanelSpacing(r3);
        RotatePannelView2 r4 = inflateStableRotatePanel(r3);
        RotatePannelManager2 r0 = new RotatePannelManager2(r4);
        r0.setMaxScore(100);
        r0.setRotateListener(new OptimizeCenterRootBlock$bindViews$$inlined$apply$lambda$1(this));
        Unit r1 = Unit.INSTANCE;
        this.rotatePanelManager = r0;
        ViewGroup r2 = r4.getScoreGroup();
        if (r2 == null) goto L6;
        r2.setOnClickListener(null);
        return;
    }

    private final void applyStablePanelSpacing(View r8) {
        View r0 = this.optimizeScroll;
        if (r0 == null) goto L16;
        int r2 = 0;
        if (r0 == null) goto L7;
        int r3 = r0.getPaddingLeft();
    L8:
        DisplaySizeStableContext r4 = DisplaySizeStableContext.INSTANCE;
        Context r5 = r8.getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "view.context");
        int r6 = r4.dpToPx(r5, PANEL_TOP_PADDING_DP);
        View r7 = this.optimizeScroll;
        if (r7 == null) goto L11;
        int r9 = r7.getPaddingRight();
    L12:
        View r10 = this.optimizeScroll;
        if (r10 == null) goto L15;
        r2 = r10.getPaddingBottom();
    L15:
        r0.setPadding(r3, r6, r9, r2);
        goto L16
    L11:
        r9 = 0;
        goto L12
    L7:
        r3 = 0;
    L16:
        View r11 = this.panelContainer;
        if (r11 == null) goto L27;
        if (r11 == null) goto L25;
        ViewGroup.LayoutParams r1 = r11.getLayoutParams();
        if (r1 == null) goto L25;
        DisplaySizeStableContext r12 = DisplaySizeStableContext.INSTANCE;
        Context r13 = r8.getContext();
        Intrinsics.checkNotNullExpressionValue(r13, "view.context");
        r1.height = r12.dpToPx(r13, OPTIMIZE_PANEL_HEIGHT_DP);
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        DisplaySizeStableContext r14 = DisplaySizeStableContext.INSTANCE;
        Context r15 = r8.getContext();
        Intrinsics.checkNotNullExpressionValue(r15, "view.context");
        ((ViewGroup.MarginLayoutParams) r1).topMargin = r14.dpToPx(r15, 8.0f);
    L24:
        Unit r16 = Unit.INSTANCE;
    L26:
        r11.setLayoutParams(r1);
    L25:
        r1 = null;
    L27:
        View r17 = r8.findViewById(R.id.optimize_rotate_panel_container);
        Intrinsics.checkNotNullExpressionValue(r17, "view.findViewById<ViewGr…e_rotate_panel_container)");
        View r18 = r8.findViewById(R.id.optimize_rotate_panel_container);
        Intrinsics.checkNotNullExpressionValue(r18, "view.findViewById<ViewGr…e_rotate_panel_container)");
        ViewGroup.LayoutParams r19 = ((ViewGroup) r18).getLayoutParams();
        DisplaySizeStableContext r20 = DisplaySizeStableContext.INSTANCE;
        Context r21 = r8.getContext();
        Intrinsics.checkNotNullExpressionValue(r21, "view.context");
        r19.width = r20.dpToPx(r21, ROTATE_PANEL_SIZE_DP);
        DisplaySizeStableContext r22 = DisplaySizeStableContext.INSTANCE;
        Context r23 = r8.getContext();
        Intrinsics.checkNotNullExpressionValue(r23, "view.context");
        r19.height = r22.dpToPx(r23, ROTATE_PANEL_SIZE_DP);
        Unit r24 = Unit.INSTANCE;
        ((ViewGroup) r17).setLayoutParams(r19);
    }

    private final RotatePannelView2 inflateStableRotatePanel(View r3) {
        ViewGroup r2 = (ViewGroup) r3.findViewById(R.id.optimize_rotate_panel_container);
        r2.removeAllViews();
        DisplaySizeStableContext r0 = DisplaySizeStableContext.INSTANCE;
        Context r4 = r3.getContext();
        Intrinsics.checkNotNullExpressionValue(r4, "view.context");
        View r5 = LayoutInflater.from(r0.create(r4)).inflate(R.layout.rotate_pannel_view, r2, false);
        r2.addView(r5);
        View r6 = r5.findViewById(R.id.main_rotate_pannel);
        Intrinsics.checkNotNullExpressionValue(r6, "rotatePanelRoot.findView…(R.id.main_rotate_pannel)");
        return (RotatePannelView2) r6;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public void generateSubBlocks(BlockGenerator r2) {
        Intrinsics.checkNotNullParameter(r2, "generator");
        r2.generate(new C03831(this));
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public void onRegister() {
        subscribe(this, OptimizeTodoItemClickEvent.class);
    }

    @Override // com.bytedance.blockframework.contract.AbstractBlock, com.bytedance.blockframework.interaction.IObserver
    public boolean onEvent(Event r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof OptimizeTodoItemClickEvent) == false) goto L6;
        OptimizeTodoItemClickEvent r2 = (OptimizeTodoItemClickEvent) r5;
        HealthScoreLog.INSTANCE.i(SOURCE, "todoItemClick itemId=" + r2.getItemId());
        this.listener.onOptimizeTodoItem(r2.getItemId());
    L6:
        return super.onEvent(r5);
    }

    public final void render(OptimizeCenterUiState r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        this.latestState = r3;
        if (this.rotatePanelManager != null) goto L5;
    L9:
        HealthScoreLog.INSTANCE.d(SOURCE, "render deferred phase=" + r3.getPhase() + " score=" + r3.getDisplayScore());
        return;
    L5:
        if (this.footerContainer == null) goto L9;
        OptimizeCenterUiState r0 = displayState(r3);
        this.latestDisplayState = r0;
        renderContent(r0);
        renderFooter(r0);
        renderScorePanel(r3);
    }

    private final void renderContent(OptimizeCenterUiState r6) {
        int r2 = 0;
        if (r6.getPhase() != OptimizeCenterPhase.RESULT) goto L5;
        boolean r0 = true;
    L6:
        View r1 = this.runningContainer;
        if (r1 == null) goto L12;
        if (r0 == false) goto L10;
        int r4 = 8;
    L11:
        r1.setVisibility(r4);
        goto L12
    L10:
        r4 = 0;
    L12:
        View r3 = this.resultContainer;
        if (r3 == null) goto L18;
        if (r0 == true) goto L17;
        r2 = 8;
    L17:
        r3.setVisibility(r2);
    L18:
        if (r0 == false) goto L22;
        OptimizeResultBlock r5 = this.resultBlock;
        if (r5 == null) goto L26;
        r5.render(r6);
        return;
    L26:
        return;
    L22:
        OptimizeRunningBlock r7 = this.runningBlock;
        if (r7 == null) goto L28;
        r7.render(r6);
        return;
    L28:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void renderFooter(OptimizeCenterUiState r6) {
        OBottomActionBarNormalHorizontal r0 = this.footerContainer;
        boolean r1 = true;
        if (r0 == null) goto L10;
        if (r6.getPhase() != OptimizeCenterPhase.RESULT) goto L7;
        boolean r3 = true;
    L8:
        r0.showDivider(r3);
        goto L10
    L7:
        r3 = false;
    L10:
        if (r6.getPhase() != OptimizeCenterPhase.RESULT) goto L12;
        int r2 = RESULT_BUTTON_STYLE;
    L13:
        OButton r5 = ensureFooterButton(r2);
        if (r5 == null) goto L27;
        String r4 = r6.getBottomAction();
        if (r4.length() == 0) goto L19;
        r1 = false;
    L19:
        if (r1 == false) goto L25;
        View r7 = r5.getRootView();
        Intrinsics.checkNotNullExpressionValue(r7, "rootView");
        Context r8 = r7.getContext();
        if (r6.getPhase() != OptimizeCenterPhase.RESULT) goto L23;
        int r9 = R.string.optimize_action_finish;
    L24:
        r4 = r8.getString(r9);
        Intrinsics.checkNotNullExpressionValue(r4, "rootView.context.getStri…     },\n                )");
        goto L25
    L23:
        r9 = R.string.optimize_action_cancel;
    L25:
        r5.setText(r4);
        return;
    L27:
        return;
    L12:
        r2 = RUNNING_BUTTON_STYLE;
        goto L13
    }

    private final OButton ensureFooterButton(int r5) {
        OBottomActionBarNormalHorizontal r0 = this.footerContainer;
        if (r0 != null) goto L5;
        return null;
    L5:
        OButton r2 = this.footerButton;
        if (r2 != null) goto L8;
    L10:
        this.footerButtonStyle = r5;
        OButton r3 = (OButton) null;
        this.footerButton = null;
        Context r1 = r0.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "container.context");
        OButton r6 = (OButton) StyleUtil.createWidgetWithStyle(r1, r5, new AnonymousClass1(this));
        r0.setButtons(CollectionsKt.listOf(r6));
        Unit r4 = Unit.INSTANCE;
        this.footerButton = r6;
        return r6;
    L8:
        if (this.footerButtonStyle != r5) goto L10;
        return r2;
    }

    private final OptimizeCenterUiState displayState(OptimizeCenterUiState r13) {
        if (r13.getPhase() != OptimizeCenterPhase.OPTIMIZING) goto L7;
        OptimizeCenterUiState r0 = (OptimizeCenterUiState) null;
        this.pendingResultState = null;
        return r13;
    L7:
        if (r13.getPhase() != OptimizeCenterPhase.RESULT) goto L10;
        OptimizeCenterUiState r1 = (OptimizeCenterUiState) null;
        this.pendingResultState = null;
        return r13;
    L10:
        this.pendingResultState = r13;
        if (this.panelAnimationFinished == false) goto L13;
        OptimizeCenterUiState r2 = (OptimizeCenterUiState) null;
        this.pendingResultState = null;
        HealthScoreLog.INSTANCE.i(SOURCE, "displayState optimized animationAlreadyFinished");
        this.listener.onOptimizeAnimationEnd();
    L13:
        HealthScoreLog.INSTANCE.i(SOURCE, "displayState holdOptimizedUntilAnimationEnd score=" + r13.getDisplayScore() + " panelAnimationFinished=" + this.panelAnimationFinished);
        OptimizeCenterPhase r4 = OptimizeCenterPhase.OPTIMIZING;
        String r9 = this.rootView.getContext().getString(R.string.optimize_action_cancel);
        Intrinsics.checkNotNullExpressionValue(r9, "rootView.context.getStri…g.optimize_action_cancel)");
        return OptimizeCenterUiState.copy$default(r13, r4, 0, null, null, null, r9, 30, null);
    }

    private final void renderScorePanel(OptimizeCenterUiState r4) {
        RotatePannelManager2 r0 = this.rotatePanelManager;
        if (r0 != null) goto L5;
        return;
    L5:
        OptimizeCenterPhase r1 = r4.getPhase();
        int r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r2 != 1) goto L8;
        startOptimizePanelIfNeeded(r0, r4.getDisplayScore());
        return;
    L8:
        if (r2 != 2) goto L10;
        finishOptimizePanelIfNeeded(r0, r4.getDisplayScore());
        return;
    L10:
        if (r2 != 3) goto L18;
        showResultPanelIfNeeded(r0, r4.getDisplayScore());
        return;
    }

    private final void startOptimizePanelIfNeeded(RotatePannelManager2 r4, int r5) {
        if (this.panelStarted == false) goto L5;
        return;
    L5:
        HealthScoreLog.INSTANCE.i(SOURCE, "startOptimizePanel score=" + r5);
        this.panelStarted = true;
        this.panelFinished = false;
        this.panelAnimationFinished = false;
        Integer r2 = (Integer) null;
        this.resultPanelScore = null;
        r4.setMaxScore(100);
        r4.startOptimizeFromScore(RangesKt.coerceIn(r5, 0, 100));
    }

    private final void finishOptimizePanelIfNeeded(RotatePannelManager2 r7, int r8) {
        int r9 = RangesKt.coerceIn(r8, 0, 100);
        if (this.panelFinished == false) goto L6;
        return;
    L6:
        if (this.panelStarted == true) goto L9;
        HealthScoreLog.INSTANCE.i(SOURCE, "finishOptimizePanel withoutStart score=" + r9);
        this.panelStarted = true;
        this.panelFinished = true;
        this.panelAnimationFinished = true;
        this.resultPanelScore = Integer.valueOf(r9);
        r7.finishOptimizeToScore(r9, false);
        this.listener.onOptimizeAnimationEnd();
        return;
    L9:
        this.resultPanelScore = Integer.valueOf(r9);
        HealthScoreLog.INSTANCE.i(SOURCE, "finishOptimizePanel score=" + r9);
        r7.finishOptimizeToScore(r9, false);
        this.panelFinished = true;
    }

    private final void showResultPanelIfNeeded(RotatePannelManager2 r7, int r8) {
        int r9 = RangesKt.coerceIn(r8, 0, 100);
        if (this.panelStarted == false) goto L11;
        Integer r1 = this.resultPanelScore;
        if (r1 != null) goto L8;
    L9:
        this.resultPanelScore = Integer.valueOf(r9);
        HealthScoreLog.INSTANCE.i(SOURCE, "showResultPanel updateScore score=" + r9);
        r7.updateResultScoreTo(r9, false);
        return;
    L8:
        if (r1.intValue() != r9) goto L9;
        return;
    L11:
        HealthScoreLog.INSTANCE.i(SOURCE, "showResultPanel firstShow score=" + r9);
        this.panelStarted = true;
        this.panelFinished = true;
        this.panelAnimationFinished = true;
        this.resultPanelScore = Integer.valueOf(r9);
        r7.setMaxScore(100);
        r7.finishOptimizeToScore(r9, false);
    }

    private final void onFooterClick() {
        if (this.pendingResultState != null) goto L5;
    L8:
        HealthScoreLog.INSTANCE.i(SOURCE, "footerClick phase=" + this.latestDisplayState.getPhase());
        int r0 = WhenMappings.$EnumSwitchMapping$1[this.latestDisplayState.getPhase().ordinal()];
        if (r0 != 1) goto L11;
    L16:
        this.listener.onCancelOptimize();
        return;
    L11:
        if (r0 == 2) goto L16;
        if (r0 != 3) goto L19;
        this.listener.onFinishPage();
        return;
    L19:
        return;
    L5:
        if (this.panelAnimationFinished == true) goto L8;
        HealthScoreLog.INSTANCE.d(SOURCE, "footerClick ignored pendingResult=true animationFinished=false");
    }

    static {
        Companion = new Companion(null);
        RUNNING_BUTTON_STYLE = 2131821269;
        RESULT_BUTTON_STYLE = 2131821270;
    }
}
