package com.obric.security.health.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.blockframework.framework.base.UIBlock;
import com.bytedance.blockframework.framework.core.BlockGenerator;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedanceos.security.Utils;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.security.R;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: compiled from: OptimizeRunningBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\nJ\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/security/health/ui/OptimizeRunningBlock;", "Lcom/bytedance/blockframework/framework/base/UIBlock;", "Ljava/util/Objects;", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "moduleContainer", "Landroid/widget/LinearLayout;", "pendingState", "Lcom/obric/security/health/ui/OptimizeCenterUiState;", "viewContext", "Landroid/content/Context;", "cardPosition", "", Utils.INTENT_KEY_INDEX, PerfConsts.PERF_DISK_FILE_SIZE, "createModuleItem", "Lcom/obric/oui/lisitem/OCardListItem;", "generateSubBlocks", "", "generator", "Lcom/bytedance/blockframework/framework/core/BlockGenerator;", "layoutResource", "loadingView", "Landroid/view/View;", "moduleTitle", "", "titleResId", "onViewCreated", "view", "render", "state", "updateEndState", "item", "status", "Lcom/obric/security/health/ui/OptimizeModuleStatus;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class OptimizeRunningBlock extends UIBlock<Objects, IBlockModel<Objects>> {
    private LinearLayout moduleContainer;
    private OptimizeCenterUiState pendingState;
    private Context viewContext;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[OptimizeModuleStatus.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[OptimizeModuleStatus.DONE.ordinal()] = 1;
            r0[OptimizeModuleStatus.RUNNING.ordinal()] = 2;
            r0[OptimizeModuleStatus.PENDING.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.health.ui.OptimizeRunningBlock$render$1, reason: invalid class name */
    /* JADX INFO: compiled from: OptimizeRunningBlock.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        AnonymousClass1(OptimizeRunningBlock r7) {
            super(r7, OptimizeRunningBlock.class, "viewContext", "getViewContext()Landroid/content/Context;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return OptimizeRunningBlock.access$getViewContext$p((OptimizeRunningBlock) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r1) {
            OptimizeRunningBlock.access$setViewContext$p((OptimizeRunningBlock) this.receiver, (Context) r1);
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
        return R.layout.optimize_center_running_block;
    }

    public static final /* synthetic */ Context access$getViewContext$p(OptimizeRunningBlock r1) {
        Context r2 = r1.viewContext;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
    L5:
        return r2;
    }

    public static final /* synthetic */ void access$setViewContext$p(OptimizeRunningBlock r0, Context r1) {
        r0.viewContext = r1;
    }

    public OptimizeRunningBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Context r0 = r3.getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "view.context");
        this.viewContext = r0;
        this.moduleContainer = (LinearLayout) r3.findViewById(R.id.optimize_running_card);
        OptimizeCenterUiState r4 = this.pendingState;
        if (r4 == null) goto L6;
        OptimizeCenterUiState r1 = (OptimizeCenterUiState) null;
        this.pendingState = null;
        render(r4);
        return;
    }

    public final void render(OptimizeCenterUiState r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        if (this.viewContext != null) goto L6;
        this.pendingState = r10;
        return;
    L6:
        LinearLayout r0 = this.moduleContainer;
        if (r0 != null) goto L9;
        return;
    L9:
        List<OptimizeModuleUi> r11 = r10.getModules();
        r0.removeAllViews();
        Iterator<T> r1 = r11.iterator();
        int r3 = 0;
    L11:
        if (r1.hasNext() == false) goto L16;
        Object r4 = r1.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        OptimizeModuleUi r6 = (OptimizeModuleUi) r4;
        OCardListItem r7 = createModuleItem();
        OCardListItem.setCardPosition$default(r7, cardPosition(r3, r11.size()), false, 2, null);
        r7.setTitle(moduleTitle(r6.getTitleResId()));
        r7.showTitle(true);
        r7.setSubTitle(r6.getSubtitle());
        r7.showSubTitle(true);
        r7.showTailIcon(false);
        r7.showCustomStart(false);
        updateEndState(r7, r6.getStatus());
        r0.addView(r7);
        r3 = r5;
        goto L11
    }

    private final OCardListItem createModuleItem() {
        Context r1 = this.viewContext;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
    L5:
        OCardListItem r6 = new OCardListItem(r1, null, 0, 6, null);
        r6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r6.showTitle(true);
        r6.showSubTitle(true);
        r6.showTailIcon(false);
        r6.showCustomStart(false);
        return r6;
    }

    private final void updateEndState(OCardListItem r3, OptimizeModuleStatus r4) {
        int r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r5 != 1) goto L5;
        r3.showCustomEnd(false);
        r3.setTailIcon(R.drawable.o_ic_radio_tick_checked);
        r3.showTailIcon(true);
        return;
    L5:
        if (r5 != 2) goto L7;
    L9:
        r3.setCustomEndView(loadingView());
        r3.showCustomEnd(true);
        return;
    L7:
        if (r5 == 3) goto L9;
    }

    private final View loadingView() {
        Context r2 = this.viewContext;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
    L5:
        View r3 = LayoutInflater.from(r2).inflate(R.layout.layout_small_loading, null);
        Intrinsics.checkNotNullExpressionValue(r3, "LayoutInflater.from(view…yout_small_loading, null)");
        return r3;
    }

    private final String moduleTitle(int r3) {
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
}
