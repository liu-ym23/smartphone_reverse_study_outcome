package com.obric.security.health.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedance.blockframework.framework.join.IBlockJoin;
import com.bytedance.blockframework.framework.join.IBlockJoinKt;
import com.bytedance.blockframework.framework.join.IBlockScene;
import com.bytedanceos.security.BaseActivity;
import com.obric.security.R;
import com.obric.security.health.score.HealthScoreLog;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OptimizeCenterActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/security/health/ui/OptimizeCenterActivity;", "Lcom/bytedanceos/security/BaseActivity;", "Lcom/bytedance/blockframework/framework/join/IBlockJoin;", "()V", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "getBlockContext", "()Lcom/bytedance/blockframework/framework/join/IBlockContext;", "blockContext$delegate", "Lkotlin/Lazy;", "blockScene", "Lcom/bytedance/blockframework/framework/join/IBlockScene;", "getBlockScene", "()Lcom/bytedance/blockframework/framework/join/IBlockScene;", "blockScene$delegate", "rootBlock", "Lcom/obric/security/health/ui/OptimizeCenterRootBlock;", "viewModel", "Lcom/obric/security/health/ui/OptimizeCenterViewModel;", "createRootBlockListener", "Lcom/obric/security/health/ui/OptimizeCenterRootBlock$Listener;", "initTitle", "", "observeLifeCycle", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "scene", "", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class OptimizeCenterActivity extends BaseActivity implements IBlockJoin {
    private static final Companion Companion = null;

    @Deprecated
    private static final String SOURCE = "OptimizeCenterActivity";
    private HashMap _$_findViewCache;
    private final Lazy blockContext$delegate;
    private final Lazy blockScene$delegate;
    private OptimizeCenterRootBlock rootBlock;
    private OptimizeCenterViewModel viewModel;

    /* JADX INFO: compiled from: OptimizeCenterActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/security/health/ui/OptimizeCenterActivity$Companion;", "", "()V", "SOURCE", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            r0[Lifecycle.Event.ON_START.ordinal()] = 2;
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            r0[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockJoin
    public IBlockContext getBlockContext() {
        return (IBlockContext) this.blockContext$delegate.getValue();
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockJoin
    public IBlockScene getBlockScene() {
        return (IBlockScene) this.blockScene$delegate.getValue();
    }

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        return "optimize_center_page";
    }

    public OptimizeCenterActivity() {
        this.blockContext$delegate = LazyKt.lazy(new OptimizeCenterActivity$blockContext$2(this));
        this.blockScene$delegate = LazyKt.lazy(OptimizeCenterActivity$blockScene$2.INSTANCE);
    }

    public static final /* synthetic */ OptimizeCenterRootBlock access$getRootBlock$p(OptimizeCenterActivity r0) {
        return r0.rootBlock;
    }

    public static final /* synthetic */ OptimizeCenterViewModel access$getViewModel$p(OptimizeCenterActivity r1) {
        OptimizeCenterViewModel r2 = r1.viewModel;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r2;
    }

    public static final /* synthetic */ void access$setRootBlock$p(OptimizeCenterActivity r0, OptimizeCenterRootBlock r1) {
        r0.rootBlock = r1;
    }

    public static final /* synthetic */ void access$setViewModel$p(OptimizeCenterActivity r0, OptimizeCenterViewModel r1) {
        r0.viewModel = r1;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r6) {
        super.onCreate(r6);
        HealthScoreLog r0 = HealthScoreLog.INSTANCE;
        StringBuilder r1 = new StringBuilder("onCreate savedInstanceState=");
        if (r6 == null) goto L5;
        boolean r2 = true;
    L6:
        r0.i(SOURCE, r1.append(r2).toString());
        this.viewModel = (OptimizeCenterViewModel) new ViewModelProvider(this).get(OptimizeCenterViewModel.class);
        setContentView(R.layout.activity_optimize_center);
        initTitle();
        ViewGroup r3 = (ViewGroup) findViewById(R.id.optimize_root_container);
        Intrinsics.checkNotNullExpressionValue(r3, "rootContainer");
        OptimizeCenterRootBlock r4 = new OptimizeCenterRootBlock(r3, createRootBlockListener(), getBlockContext());
        this.rootBlock = r4;
        OptimizeCenterActivity r5 = this;
        Intrinsics.checkNotNull(r4);
        IBlockJoinKt.initRootBlock(this, r5, r4);
        observeLifeCycle();
        OptimizeCenterViewModel r7 = this.viewModel;
        if (r7 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        r7.getUiState().observe(this, new C03821(this));
        if (r6 != null) goto L16;
        OptimizeCenterViewModel r8 = this.viewModel;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r8.startOptimize(r5);
        return;
    L16:
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        HealthScoreLog.INSTANCE.d(SOURCE, "onResume");
        OptimizeCenterViewModel r3 = this.viewModel;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r3.refreshResultOnResume();
    }

    private final void initTitle() {
        initTitleBar(false, false);
        this.mTitle.setCenterTitle(getString(R.string.onestep_optimize));
    }

    private final OptimizeCenterRootBlock.Listener createRootBlockListener() {
        return new AnonymousClass1(this);
    }

    private final void observeLifeCycle() {
        getLifecycle().addObserver(new C03811(this));
    }
}
