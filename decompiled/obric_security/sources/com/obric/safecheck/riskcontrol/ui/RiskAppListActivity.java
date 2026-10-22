package com.obric.safecheck.riskcontrol.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.ViewModelProvider;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.safecheck.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: compiled from: RiskAppListActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0003%&'B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u0012\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u001bH\u0014J\b\u0010$\u001a\u00020\u001bH\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppListActivity;", "Landroidx/activity/ComponentActivity;", "()V", "adapter", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppListActivity$RiskAppAdapter;", "emptyView", "Landroid/view/View;", "getEmptyView", "()Landroid/view/View;", "emptyView$delegate", "Lkotlin/Lazy;", "listCard", "getListCard", "listCard$delegate", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "getRecyclerView", "()Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "recyclerView$delegate", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "getTitleBar", "()Lcom/obric/oui/titlebar/OFloatingTitleBar;", "titleBar$delegate", "viewModel", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppListViewModel;", "bindList", "", "items", "", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppListItemUiState;", "initTitleBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setupImmersiveStatusBar", "Companion", "RiskAppAdapter", "RiskAppViewHolder", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskAppListActivity extends ComponentActivity {
    public static final Companion Companion = null;
    private final RiskAppAdapter adapter;
    private final Lazy emptyView$delegate;
    private final Lazy listCard$delegate;
    private final Lazy recyclerView$delegate;
    private final Lazy titleBar$delegate;
    private RiskAppListViewModel viewModel;

    /* JADX INFO: compiled from: RiskAppListActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppListActivity$Companion;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getControlledRiskAppCount", "", "getUncontrolledRiskAppCount", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final Intent createIntent(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new Intent(r2, RiskAppListActivity.class);
        }

        @JvmStatic
        public final int getControlledRiskAppCount(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Context r1 = r2.getApplicationContext();
            RiskControlRuntimeDependencies r3 = RiskControlRuntimeDependencies.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(r1, "appContext");
            r3.ensureInitialized(r1);
            return RiskControlRuntimeDependencies.INSTANCE.getLoadRiskAppsUseCaseFactory().invoke(r1).countControlled();
        }

        @JvmStatic
        public final int getUncontrolledRiskAppCount(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Context r1 = r2.getApplicationContext();
            RiskControlRuntimeDependencies r3 = RiskControlRuntimeDependencies.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(r1, "appContext");
            r3.ensureInitialized(r1);
            return RiskControlRuntimeDependencies.INSTANCE.getLoadRiskAppsUseCaseFactory().invoke(r1).countUncontrolled();
        }
    }

    /* JADX INFO: compiled from: RiskAppListActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppListActivity$RiskAppAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppListActivity$RiskAppViewHolder;", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppListActivity;", "(Lcom/obric/safecheck/riskcontrol/ui/RiskAppListActivity;)V", "items", "", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppListItemUiState;", "getCardPosition", "", "position", "getItemCount", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "nextItems", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private final class RiskAppAdapter extends RecyclerView.Adapter<RiskAppViewHolder> {
        private List<RiskAppListItemUiState> items;
        final /* synthetic */ RiskAppListActivity this$0;

        public RiskAppAdapter(RiskAppListActivity r1) {
            this.this$0 = r1;
            this.items = CollectionsKt.emptyList();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            onBindViewHolder((RiskAppViewHolder) r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
            return onCreateViewHolder(r1, r2);
        }

        public final void submitList(List<RiskAppListItemUiState> r2) {
            Intrinsics.checkNotNullParameter(r2, "nextItems");
            this.items = r2;
            notifyDataSetChanged();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public RiskAppViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r5 = LayoutInflater.from(r3.getContext()).inflate(R.layout.risk_app_list_item, r3, false);
            RiskAppListActivity r2 = this.this$0;
            Intrinsics.checkNotNullExpressionValue(r5, "itemView");
            return new RiskAppViewHolder(r2, r5);
        }

        public void onBindViewHolder(RiskAppViewHolder r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            r2.bind(this.items.get(r3), getCardPosition(r3));
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        private final int getCardPosition(int r3) {
            if (getItemCount() == 1) goto L10;
            if (r3 != 0) goto L7;
            return 1;
        L7:
            if (r3 != (getItemCount() - 1)) goto L9;
            return 3;
        L9:
            return 2;
        L10:
            return 0;
        }
    }

    /* JADX INFO: compiled from: RiskAppListActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppListActivity$RiskAppViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/obric/safecheck/riskcontrol/ui/RiskAppListActivity;Landroid/view/View;)V", "card", "Lcom/obric/oui/lisitem/OCardListItem;", "bind", "", "data", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppListItemUiState;", "cardPosition", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private final class RiskAppViewHolder extends RecyclerView.ViewHolder {
        private final OCardListItem card;
        final /* synthetic */ RiskAppListActivity this$0;

        public RiskAppViewHolder(RiskAppListActivity r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.this$0 = r2;
            super(r3);
            View r4 = r3.findViewById(R.id.risk_app_list_item_card);
            Intrinsics.checkNotNullExpressionValue(r4, "itemView.findViewById(R.….risk_app_list_item_card)");
            this.card = (OCardListItem) r4;
        }

        public static final /* synthetic */ OCardListItem access$getCard$p(RiskAppViewHolder r0) {
            return r0.card;
        }

        public final void bind(final RiskAppListItemUiState r6, int r7) {
            Intrinsics.checkNotNullParameter(r6, "data");
            this.card.setCardType(1);
            OCardListItem.setCardPosition$default(this.card, r7, false, 2, null);
            this.card.setTitle(r6.getAppInfo().getAppName());
            this.card.showTitle(true);
            OCardListItem r8 = this.card;
            RiskAppListActivity r0 = this.this$0;
            if (r6.isInstallationPackage() == false) goto L5;
            int r2 = R.string.install_package;
        L6:
            r8.setSubTitle(r0.getString(r2));
            this.card.showSubTitle(true);
            Drawable r9 = r6.getAppInfo().getIcon();
            if (r9 == null) goto L9;
            this.card.setIcon(r9);
            this.card.showIcon(true);
        L10:
            this.card.setDefaultTailIcon(0);
            this.card.showTailIcon(true);
            final View.OnClickListener r10 = new RiskAppListActivity$RiskAppViewHolder$bind$openDetail$1(this, r6);
            this.itemView.setOnClickListener(r10);
            this.card.setOnClickListener(r10);
            this.card.setOnContentClickListener(new RiskAppListActivity$RiskAppViewHolder$bind$2(this, r10));
            View r11 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(r11, "itemView");
            RiskAppListActivity r5 = this.this$0;
            if (r6.isInstallationPackage() == false) goto L13;
            int r1 = R.string.install_package;
        L14:
            r11.setContentDescription(r5.getString(r1) + ", " + r6.getAppInfo().getAppName());
            return;
        L13:
            r1 = R.string.installed_apps;
            goto L14
        L9:
            this.card.showIcon(false);
            goto L10
        L5:
            r2 = R.string.installed_apps;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.riskcontrol.ui.RiskAppListActivity$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RiskAppListActivity.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C03281 extends MutablePropertyReference0Impl {
        C03281(RiskAppListActivity r7) {
            super(r7, RiskAppListActivity.class, "viewModel", "getViewModel()Lcom/obric/safecheck/riskcontrol/ui/RiskAppListViewModel;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return RiskAppListActivity.access$getViewModel$p((RiskAppListActivity) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r1) {
            RiskAppListActivity.access$setViewModel$p((RiskAppListActivity) this.receiver, (RiskAppListViewModel) r1);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final Intent createIntent(Context r1) {
        return Companion.createIntent(r1);
    }

    @JvmStatic
    public static final int getControlledRiskAppCount(Context r1) {
        return Companion.getControlledRiskAppCount(r1);
    }

    private final View getEmptyView() {
        return (View) this.emptyView$delegate.getValue();
    }

    private final View getListCard() {
        return (View) this.listCard$delegate.getValue();
    }

    private final RecyclerView getRecyclerView() {
        return (RecyclerView) this.recyclerView$delegate.getValue();
    }

    private final OFloatingTitleBar getTitleBar() {
        return (OFloatingTitleBar) this.titleBar$delegate.getValue();
    }

    @JvmStatic
    public static final int getUncontrolledRiskAppCount(Context r1) {
        return Companion.getUncontrolledRiskAppCount(r1);
    }

    public RiskAppListActivity() {
        this.adapter = new RiskAppAdapter(this);
        this.titleBar$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppListActivity$titleBar$2(this));
        this.recyclerView$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppListActivity$recyclerView$2(this));
        this.emptyView$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppListActivity$emptyView$2(this));
        this.listCard$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppListActivity$listCard$2(this));
    }

    public static final /* synthetic */ void access$bindList(RiskAppListActivity r0, List r1) {
        r0.bindList(r1);
    }

    public static final /* synthetic */ RiskAppListViewModel access$getViewModel$p(RiskAppListActivity r1) {
        RiskAppListViewModel r2 = r1.viewModel;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r2;
    }

    public static final /* synthetic */ void access$setViewModel$p(RiskAppListActivity r0, RiskAppListViewModel r1) {
        r0.viewModel = r1;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r4) {
        setupImmersiveStatusBar();
        super.onCreate(r4);
        RiskControlRuntimeDependencies r5 = RiskControlRuntimeDependencies.INSTANCE;
        Context r0 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r0, "applicationContext");
        r5.ensureInitialized(r0);
        setContentView(R.layout.activity_risk_app_list);
        initTitleBar();
        RecyclerView r6 = getRecyclerView();
        RiskAppListActivity r1 = this;
        r6.setLayoutManager(new LinearLayoutManager(r1));
        r6.setAdapter(this.adapter);
        r6.setHasFixedSize(false);
        r6.setItemViewCacheSize(5);
        RiskAppListViewModel r7 = (RiskAppListViewModel) new ViewModelProvider(this, RiskAppListViewModel.Companion.factory(r1)).get(RiskAppListViewModel.class);
        this.viewModel = r7;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r7.getUiState().observe(this, new AnonymousClass2(this));
        RiskAppListViewModel r3 = this.viewModel;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r3.loadControlledApps();
    }

    private final void setupImmersiveStatusBar() {
        boolean r1 = false;
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().addFlags(Integer.MIN_VALUE);
        Window r0 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r0, "window");
        r0.setStatusBarColor(0);
        Window r2 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r2, "window");
        r2.setNavigationBarColor(0);
        Resources r3 = getResources();
        Intrinsics.checkNotNullExpressionValue(r3, "resources");
        if ((r3.getConfiguration().uiMode & 48) != 32) goto L5;
        r1 = true;
    L5:
        Window r4 = getWindow();
        Window r5 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r5, "window");
        new WindowInsetsControllerCompat(r4, r5.getDecorView()).setAppearanceLightStatusBars(!r1);
    }

    private final void initTitleBar() {
        getTitleBar().addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, new AnonymousClass1(this));
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.viewModel == null) goto L9;
        RiskAppListViewModel r1 = this.viewModel;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L7:
        r1.loadControlledApps();
        return;
    }

    private final void bindList(List<RiskAppListItemUiState> r5) {
        View r0 = getEmptyView();
        int r2 = 0;
        if (r5.isEmpty() == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        View r3 = getListCard();
        if (r5.isEmpty() == false) goto L9;
        int r4 = 8;
    L10:
        r3.setVisibility(r4);
        RecyclerView r6 = getRecyclerView();
        if (r5.isEmpty() == false) goto L13;
        r2 = 8;
    L13:
        r6.setVisibility(r2);
        this.adapter.submitList(r5);
        return;
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = 8;
        goto L6
    }
}
