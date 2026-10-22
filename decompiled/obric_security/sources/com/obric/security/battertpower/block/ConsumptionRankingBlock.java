package com.obric.security.battertpower.block;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.blockframework.framework.async.AsyncUIBlock;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OContextExtensionKt;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.obric.security.R;
import com.obric.security.battertpower.AppPowerProfileData;
import com.obric.security.battertpower.BatteryPowerActivityViewModel;
import com.obric.security.battertpower.PercentAdapter;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.security.monitor.PerformanceScenes;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ConsumptionRankingBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u001fH\u0002J\b\u0010*\u001a\u00020\u001fH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/security/battertpower/block/ConsumptionRankingBlock;", "Lcom/bytedance/blockframework/framework/async/AsyncUIBlock;", "Ljava/util/Objects;", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "adapter", "Lcom/obric/security/battertpower/PercentAdapter;", "batteryPowerActivityViewModel", "Lcom/obric/security/battertpower/BatteryPowerActivityViewModel;", "clear", "Lcom/obric/oui/button/OButton;", "consumptionRankingRoot", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getConsumptionRankingRoot", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setConsumptionRankingRoot", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "dropdown", "Landroid/widget/ImageView;", "listFpsSession", "Lcom/obric/security/monitor/PerformanceMonitors$FpsSceneSession;", "listFpsStarted", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "showAllContainer", "Lcom/obric/oui/lisitem/OCardListItem;", "enableAsyncBind", "initShowAll", "", "rootView", "Landroid/view/View;", "layoutResource", "", "onViewCreated", "view", "scrollToTop", "scrollView", "Lcom/obric/oui/bouncelayout/ONestedScrollView;", "startListFps", "stopListFps", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ConsumptionRankingBlock extends AsyncUIBlock<Objects, IBlockModel<Objects>> {
    private PercentAdapter adapter;
    private BatteryPowerActivityViewModel batteryPowerActivityViewModel;
    private OButton clear;
    private ConstraintLayout consumptionRankingRoot;
    private ImageView dropdown;
    private final PerformanceMonitors.FpsSceneSession listFpsSession;
    private boolean listFpsStarted;
    private RecyclerView recyclerView;
    private OCardListItem showAllContainer;

    @Override // com.bytedance.blockframework.framework.async.IAsyncBind
    public boolean enableAsyncBind() {
        return false;
    }

    @Override // com.bytedance.blockframework.framework.async.AsyncUIBlock
    public int layoutResource() {
        return R.layout.consumption_ranking;
    }

    public static final /* synthetic */ PercentAdapter access$getAdapter$p(ConsumptionRankingBlock r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ OButton access$getClear$p(ConsumptionRankingBlock r0) {
        return r0.clear;
    }

    public static final /* synthetic */ ImageView access$getDropdown$p(ConsumptionRankingBlock r0) {
        return r0.dropdown;
    }

    public static final /* synthetic */ void access$scrollToTop(ConsumptionRankingBlock r0, ONestedScrollView r1) {
        r0.scrollToTop(r1);
    }

    public static final /* synthetic */ void access$setAdapter$p(ConsumptionRankingBlock r0, PercentAdapter r1) {
        r0.adapter = r1;
    }

    public static final /* synthetic */ void access$setClear$p(ConsumptionRankingBlock r0, OButton r1) {
        r0.clear = r1;
    }

    public static final /* synthetic */ void access$setDropdown$p(ConsumptionRankingBlock r0, ImageView r1) {
        r0.dropdown = r1;
    }

    public static final /* synthetic */ void access$startListFps(ConsumptionRankingBlock r0) {
        r0.startListFps();
    }

    public static final /* synthetic */ void access$stopListFps(ConsumptionRankingBlock r0) {
        r0.stopListFps();
    }

    public ConsumptionRankingBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
        this.listFpsSession = new PerformanceMonitors.FpsSceneSession(PerformanceScenes.FPS_BATTERY_POWER_CONSUMPTION_RANKING_LIST);
    }

    public final ConstraintLayout getConsumptionRankingRoot() {
        return this.consumptionRankingRoot;
    }

    public final void setConsumptionRankingRoot(ConstraintLayout r1) {
        this.consumptionRankingRoot = r1;
    }

    @Override // com.bytedance.blockframework.framework.async.AsyncUIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public void onViewCreated(final View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Object r0 = r5.getContext();
        Context r2 = null;
        if ((r0 instanceof ViewModelStoreOwner) == true) goto L5;
        r0 = null;
    L5:
        ViewModelStoreOwner r1 = (ViewModelStoreOwner) r0;
        if (r1 == null) goto L8;
        this.batteryPowerActivityViewModel = (BatteryPowerActivityViewModel) new ViewModelProvider(r1).get(BatteryPowerActivityViewModel.class);
    L8:
        this.consumptionRankingRoot = (ConstraintLayout) r5.findViewById(R.id.consumption_ranking_root);
        this.recyclerView = (RecyclerView) r5.findViewById(R.id.recyclerView_battery_profile);
        this.showAllContainer = (OCardListItem) r5.findViewById(R.id.show_all_container);
        OButton r3 = (OButton) r5.findViewById(R.id.clear);
        this.clear = r3;
        if (r3 == null) goto L11;
        r3.setOnClickListener(new ViewOnClickListenerC03482(this));
    L11:
        this.adapter = new PercentAdapter();
        RecyclerView r4 = this.recyclerView;
        if (r4 == null) goto L14;
        r4.setLayoutManager(new LinearLayoutManager(r5.getContext()));
    L14:
        RecyclerView r6 = this.recyclerView;
        if (r6 == null) goto L17;
        r6.setAdapter(this.adapter);
    L17:
        RecyclerView r7 = this.recyclerView;
        if (r7 == null) goto L20;
        RecyclerView.ItemAnimator r8 = (RecyclerView.ItemAnimator) null;
        r7.setItemAnimator(null);
    L20:
        RecyclerView r9 = this.recyclerView;
        if (r9 == null) goto L23;
        r9.addOnScrollListener(new C03493(this));
    L23:
        r5.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC03504(this));
        initShowAll(r5);
        Context r10 = r5.getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "view.context");
        ComponentCallbacks2 r11 = OContextExtensionKt.getActivity(r10);
        if ((r11 instanceof LifecycleOwner) == true) goto L26;
        r11 = null;
    L26:
        LifecycleOwner r12 = (LifecycleOwner) r11;
        if (r12 != null) goto L33;
        Context r13 = r5.getContext();
        if ((r13 instanceof LifecycleOwner) == false) goto L32;
        r2 = r13;
    L32:
        r12 = (LifecycleOwner) r2;
    L33:
        r5.setVisibility(8);
        if (r12 == null) goto L41;
        BatteryPowerActivityViewModel r14 = this.batteryPowerActivityViewModel;
        if (r14 == null) goto L42;
        MutableLiveData<List<AppPowerProfileData>> r15 = r14.getAppPowerProfileData();
        if (r15 == null) goto L43;
        r15.observe(r12, new AnonymousClass5(r5));
        return;
    L43:
        return;
    L42:
        return;
    }

    private final void startListFps() {
        if (this.listFpsStarted == false) goto L5;
        return;
    L5:
        this.listFpsStarted = true;
        this.listFpsSession.start();
    }

    private final void stopListFps() {
        if (this.listFpsStarted == true) goto L5;
        return;
    L5:
        this.listFpsStarted = false;
        this.listFpsSession.stop();
    }

    private final void initShowAll(View r13) {
        final BatteryPowerActivityViewModel r0 = this.batteryPowerActivityViewModel;
        if (r0 != null) goto L5;
        return;
    L5:
        final OCardListItem r1 = this.showAllContainer;
        if (r1 != null) goto L8;
        return;
    L8:
        Context r2 = r13.getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "rootView.context");
        ComponentCallbacks2 r3 = OContextExtensionKt.getActivity(r2);
        final ONestedScrollView r5 = null;
        if ((r3 instanceof LifecycleOwner) == true) goto L11;
        r3 = null;
    L11:
        LifecycleOwner r4 = (LifecycleOwner) r3;
        if (r4 != null) goto L17;
        Object r6 = r13.getContext();
        if ((r6 instanceof LifecycleOwner) == true) goto L16;
        r6 = null;
    L16:
        r4 = (LifecycleOwner) r6;
    L17:
        if (r4 != null) goto L19;
        return;
    L19:
        View r7 = LayoutInflater.from(r13.getContext()).inflate(R.layout.expand_more, (ViewGroup) r1.findViewById(R.id.custom_start_container), false);
        this.dropdown = (ImageView) r7.findViewById(R.id.dropdown);
        final OTextView r8 = (OTextView) r7.findViewById(R.id.show_all_text);
        r1.setOnContentClickListener(new AnonymousClass1(r0));
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics())));
        r9.gravity = 17;
        Intrinsics.checkNotNullExpressionValue(r7, "itemView");
        r7.setLayoutParams(r9);
        OCardListItem.setCardPosition$default(r1, 3, false, 2, null);
        r1.setCardType(2);
        r1.setCustomStartView(r7);
        r1.showCustomStart(true);
        Context r14 = r13.getContext();
        Intrinsics.checkNotNullExpressionValue(r14, "rootView.context");
        Activity r15 = OContextExtensionKt.getActivity(r14);
        if ((r15 instanceof Activity) == true) goto L22;
        r15 = null;
    L22:
        if (r15 == null) goto L24;
        r5 = (ONestedScrollView) r15.findViewById(R.id.main_view);
    L24:
        Intrinsics.checkNotNull(r5);
        r0.getDropdown().observe(r4, new AnonymousClass2(this, r8, r0, r5));
        r0.getAppPowerProfileData().observe(r4, new AnonymousClass3(this, r0));
        r0.getDropdownShow().observe(r4, new AnonymousClass4(this, r1));
        if (Intrinsics.areEqual(r0.getDropdownShow().getValue(), true) == false) goto L32;
        ImageView r16 = this.dropdown;
        if (r16 == null) goto L29;
        r16.setVisibility(0);
    L29:
        r1.setVisibility(0);
        PercentAdapter r12 = this.adapter;
        if (r12 == null) goto L39;
        r12.setDropdown(true);
        return;
    L39:
        return;
    L32:
        ImageView r17 = this.dropdown;
        if (r17 == null) goto L35;
        r17.setVisibility(8);
    L35:
        r1.setVisibility(8);
        PercentAdapter r18 = this.adapter;
        if (r18 == null) goto L41;
        r18.setDropdown(false);
        return;
    }

    private final void scrollToTop(ONestedScrollView r1) {
        if (r1 == null) goto L5;
        r1.scrollTo(0, 0);
        return;
    }
}
