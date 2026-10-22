package com.obric.security.health.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.blockframework.framework.base.UIBlock;
import com.bytedance.blockframework.framework.core.BlockGenerator;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedanceos.security.Utils;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.security.R;
import com.obric.security.health.model.HealthCheckItemSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: compiled from: OptimizeResultBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J*\u0010'\u001a\b\u0012\u0004\u0012\u00020!0(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0(H\u0002J\b\u0010,\u001a\u00020\u000fH\u0016J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\nJ\u0016\u00104\u001a\u00020$2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020!0(H\u0002J\u0016\u00105\u001a\u00020$2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150(H\u0002J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u000fH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00068"}, d2 = {"Lcom/obric/security/health/ui/OptimizeResultBlock;", "Lcom/bytedance/blockframework/framework/base/UIBlock;", "Ljava/util/Objects;", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "completedContainer", "Landroid/widget/LinearLayout;", "pendingState", "Lcom/obric/security/health/ui/OptimizeCenterUiState;", "todoContainer", "viewContext", "Landroid/content/Context;", "dp", "", "getDp", "(I)I", "actionButton", "Lcom/obric/oui/button/OButton;", "item", "Lcom/obric/security/health/model/HealthCheckItemSnapshot;", "actionText", "", "cardPosition", Utils.INTENT_KEY_INDEX, PerfConsts.PERF_DISK_FILE_SIZE, "completedTitle", "createCompletedItem", "Lcom/obric/oui/lisitem/OCardListItem;", "position", "createCompletedModuleHeader", "module", "Lcom/obric/security/health/ui/CompletedModuleUi;", "createTodoItem", "generateSubBlocks", "", "generator", "Lcom/bytedance/blockframework/framework/core/BlockGenerator;", "groupCompletedItems", "", "items", "modules", "Lcom/obric/security/health/ui/OptimizeModuleUi;", "layoutResource", "moduleName", "onViewCreated", "view", "Landroid/view/View;", "problemTitle", "render", "state", "renderCompletedModules", "renderTodoItems", "ruleText", "resId", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class OptimizeResultBlock extends UIBlock<Objects, IBlockModel<Objects>> {
    private LinearLayout completedContainer;
    private OptimizeCenterUiState pendingState;
    private LinearLayout todoContainer;
    private Context viewContext;

    /* JADX INFO: renamed from: com.obric.security.health.ui.OptimizeResultBlock$render$1, reason: invalid class name */
    /* JADX INFO: compiled from: OptimizeResultBlock.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        AnonymousClass1(OptimizeResultBlock r7) {
            super(r7, OptimizeResultBlock.class, "viewContext", "getViewContext()Landroid/content/Context;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return OptimizeResultBlock.access$getViewContext$p((OptimizeResultBlock) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r1) {
            OptimizeResultBlock.access$setViewContext$p((OptimizeResultBlock) this.receiver, (Context) r1);
        }
    }

    private final int cardPosition(int r1, int r2) {
        if (r2 > 1) goto L5;
        return 0;
    L5:
        if (r1 != 0) goto L8;
        return 1;
    L8:
        if (r1 != (r2 - 1)) goto L10;
        return 3;
    L10:
        return 2;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public void generateSubBlocks(BlockGenerator r1) {
        Intrinsics.checkNotNullParameter(r1, "generator");
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock
    public int layoutResource() {
        return R.layout.optimize_center_result_block;
    }

    public static final /* synthetic */ Context access$getViewContext$p(OptimizeResultBlock r1) {
        Context r2 = r1.viewContext;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
    L5:
        return r2;
    }

    public static final /* synthetic */ void access$setViewContext$p(OptimizeResultBlock r0, Context r1) {
        r0.viewContext = r1;
    }

    public OptimizeResultBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Context r0 = r3.getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "view.context");
        this.viewContext = r0;
        this.todoContainer = (LinearLayout) r3.findViewById(R.id.optimize_todo_container);
        this.completedContainer = (LinearLayout) r3.findViewById(R.id.optimize_completed_container);
        OptimizeCenterUiState r4 = this.pendingState;
        if (r4 == null) goto L6;
        OptimizeCenterUiState r1 = (OptimizeCenterUiState) null;
        this.pendingState = null;
        render(r4);
        return;
    }

    public final void render(OptimizeCenterUiState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        if (this.viewContext != null) goto L6;
        this.pendingState = r2;
        return;
    L6:
        renderTodoItems(r2.getTodoItems());
        renderCompletedModules(groupCompletedItems(r2.getCompletedItems(), r2.getModules()));
    }

    private final void renderTodoItems(List<HealthCheckItemSnapshot> r7) {
        LinearLayout r0 = this.todoContainer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeAllViews();
        Iterator<T> r1 = r7.iterator();
        int r2 = 0;
    L7:
        if (r1.hasNext() == false) goto L12;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        r0.addView(createTodoItem((HealthCheckItemSnapshot) r3, cardPosition(r2, r7.size())));
        r2 = r4;
        goto L7
    }

    private final void renderCompletedModules(List<CompletedModuleUi> r14) {
        LinearLayout r0 = this.completedContainer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeAllViews();
        Iterator<T> r15 = r14.iterator();
        int r2 = 0;
    L7:
        if (r15.hasNext() == false) goto L25;
        Object r3 = r15.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        CompletedModuleUi r5 = (CompletedModuleUi) r3;
        Context r6 = this.viewContext;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
    L14:
        OUILinearLayout r12 = new OUILinearLayout(r6, null, 0, null, 14, null);
        r12.setOrientation(1);
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-1, -2);
        if (r2 <= 0) goto L17;
        r7.topMargin = getDp(12);
    L17:
        Unit r8 = Unit.INSTANCE;
        r12.setLayoutParams(r7);
        int r9 = r5.getItems().size() + 1;
        r12.addView(createCompletedModuleHeader(r5, cardPosition(0, r9)));
        Iterator<T> r10 = r5.getItems().iterator();
        int r11 = 0;
    L19:
        if (r10.hasNext() == false) goto L24;
        Object r13 = r10.next();
        int r16 = r11 + 1;
        if (r11 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        r12.addView(createCompletedItem((HealthCheckItemSnapshot) r13, cardPosition(r16, r9)));
        r11 = r16;
        goto L19
    L24:
        r0.addView(r12);
        r2 = r4;
        goto L7
    }

    private final OCardListItem createTodoItem(HealthCheckItemSnapshot r8, int r9) {
        Context r1 = this.viewContext;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
    L5:
        OCardListItem r6 = new OCardListItem(r1, null, 0, 6, null);
        r6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        OCardListItem.setCardPosition$default(r6, r9, false, 2, null);
        r6.setTitle(problemTitle(r8));
        r6.setSubTitle(null);
        r6.showSubTitle(false);
        if (r8.isNavigateFixable() == false) goto L8;
        r6.setCustomEndView(actionButton(r8));
        r6.showCustomEnd(true);
    L9:
        return r6;
    L8:
        r6.showCustomEnd(false);
        goto L9
    }

    private final OCardListItem createCompletedModuleHeader(CompletedModuleUi r8, int r9) {
        Context r1 = this.viewContext;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
    L5:
        OCardListItem r6 = new OCardListItem(r1, null, 0, 6, null);
        r6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        OCardListItem.setCardPosition$default(r6, r9, false, 2, null);
        r6.setIcon(r8.getModuleUi().getIconResId());
        r6.showIcon(true);
        r6.setTitle(moduleName(r8));
        r6.setSubTitle(null);
        r6.showSubTitle(false);
        r6.showTailIcon(false);
        r6.showCustomEnd(false);
        r6.showDivider(true);
        return r6;
    }

    private final OCardListItem createCompletedItem(HealthCheckItemSnapshot r8, int r9) {
        Context r1 = this.viewContext;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
    L5:
        OCardListItem r6 = new OCardListItem(r1, null, 0, 6, null);
        r6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        OCardListItem.setCardPosition$default(r6, r9, false, 2, null);
        r6.setTitle(completedTitle(r8));
        r6.setSubTitle(null);
        r6.showSubTitle(false);
        r6.showCustomEnd(false);
        r6.setTailIcon(R.drawable.o_ic_radio_tick_checked);
        r6.showTailIcon(true);
        return r6;
    }

    private final OButton actionButton(final HealthCheckItemSnapshot r4) {
        Context r0 = this.viewContext;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
    L5:
        View r1 = LayoutInflater.from(r0).inflate(R.layout.optimize_result_action_button, null);
        if (r1 == null) goto L10;
        OButton r2 = (OButton) r1;
        r2.setText(actionText(r4));
        r2.setOnClickListener(new OptimizeResultBlock$actionButton$$inlined$apply$lambda$1(this, r4));
        return r2;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    }

    private final List<CompletedModuleUi> groupCompletedItems(List<HealthCheckItemSnapshot> r5, List<OptimizeModuleUi> r6) {
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator<T> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Object r0 = r7.next();
        String r1 = ((HealthCheckItemSnapshot) r0).getModuleId();
        Object r2 = r4.get(r1);
        if (r2 != null) goto L8;
        r2 = (List) new ArrayList();
        r4.put(r1, r2);
    L8:
        ((List) r2).add(r0);
        goto L4
    L9:
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r6.iterator();
    L11:
        if (r9.hasNext() == false) goto L23;
        OptimizeModuleUi r3 = (OptimizeModuleUi) r9.next();
        List r10 = (List) r4.get(r3.getModuleId());
        CompletedModuleUi r11 = null;
        if (r10 != null) goto L15;
    L20:
        if (r11 == null) goto L11;
        r8.add(r11);
        goto L11
    L15:
        if ((!r10.isEmpty()) == true) goto L18;
        r10 = null;
    L18:
        if (r10 == null) goto L20;
        r11 = new CompletedModuleUi(r3, r10);
        goto L20
    L23:
        return r8;
    }

    private final String moduleName(CompletedModuleUi r3) {
        Integer r4 = Integer.valueOf(r3.getModuleUi().getTitleResId());
        if (r4.intValue() == 0) goto L5;
        boolean r0 = true;
    L6:
        String r1 = null;
        if (r0 == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L15;
        int r5 = r4.intValue();
        Context r2 = this.viewContext;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
    L14:
        r1 = r2.getString(r5);
    L15:
        if (r1 != null) goto L18;
        return "";
    L18:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    private final String completedTitle(HealthCheckItemSnapshot r1) {
        return ruleText(r1.getCompletedTitleResId());
    }

    private final String problemTitle(HealthCheckItemSnapshot r1) {
        return ruleText(r1.getProblemTitleResId());
    }

    private final String actionText(HealthCheckItemSnapshot r4) {
        Context r3 = this.viewContext;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
    L5:
        String r5 = r3.getString(r4.getActionTextResId(), new Object[]{Integer.valueOf(r4.getScore())});
        Intrinsics.checkNotNullExpressionValue(r5, "viewContext.getString(it…ionTextResId, item.score)");
        return r5;
    }

    private final String ruleText(int r3) {
        Integer r4 = Integer.valueOf(r3);
        if (r4.intValue() == 0) goto L5;
        boolean r0 = true;
    L6:
        String r1 = null;
        if (r0 == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L15;
        int r5 = r4.intValue();
        Context r2 = this.viewContext;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
    L14:
        r1 = r2.getString(r5);
    L15:
        if (r1 != null) goto L18;
        return "";
    L18:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    private final int getDp(int r2) {
        float r3 = r2;
        Context r1 = this.viewContext;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
    L5:
        Resources r4 = r1.getResources();
        Intrinsics.checkNotNullExpressionValue(r4, "viewContext.resources");
        return (int) ((r3 * r4.getDisplayMetrics().density) + 0.5f);
    }
}
