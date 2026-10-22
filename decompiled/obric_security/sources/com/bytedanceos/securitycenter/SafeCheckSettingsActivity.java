package com.bytedanceos.securitycenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedance.blockframework.framework.join.IBlockJoin;
import com.bytedance.blockframework.framework.join.IBlockJoinKt;
import com.bytedance.blockframework.framework.join.IBlockScene;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.securitycenter.block.SafeCheckSettingsRootBlock;
import com.obric.security.R;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeCheckSettingsActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedanceos/securitycenter/SafeCheckSettingsActivity;", "Lcom/bytedanceos/security/BaseActivity;", "Lcom/bytedance/blockframework/framework/join/IBlockJoin;", "()V", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "getBlockContext", "()Lcom/bytedance/blockframework/framework/join/IBlockContext;", "blockContext$delegate", "Lkotlin/Lazy;", "blockScene", "Lcom/bytedance/blockframework/framework/join/IBlockScene;", "getBlockScene", "()Lcom/bytedance/blockframework/framework/join/IBlockScene;", "blockScene$delegate", "rootView", "Landroid/widget/RelativeLayout;", "initTitle", "", "observeLifeCycle", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "scene", "", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SafeCheckSettingsActivity extends BaseActivity implements IBlockJoin {
    public static final Companion Companion = null;
    private HashMap _$_findViewCache;
    private final Lazy blockContext$delegate;
    private final Lazy blockScene$delegate;
    private RelativeLayout rootView;

    /* JADX INFO: compiled from: SafeCheckSettingsActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/securitycenter/SafeCheckSettingsActivity$Companion;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final Intent createIntent(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new Intent(r2, SafeCheckSettingsActivity.class);
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

    @JvmStatic
    public static final Intent createIntent(Context r1) {
        return Companion.createIntent(r1);
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
        return "safe_check_settings_page";
    }

    public SafeCheckSettingsActivity() {
        this.blockContext$delegate = LazyKt.lazy(new SafeCheckSettingsActivity$blockContext$2(this));
        this.blockScene$delegate = LazyKt.lazy(SafeCheckSettingsActivity$blockScene$2.INSTANCE);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.activity_safe_check_settings);
        View r4 = findViewById(R.id.safe_check_settings_root);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.safe_check_settings_root)");
        this.rootView = (RelativeLayout) r4;
        initTitle();
        RelativeLayout r0 = this.rootView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        SafeCheckSettingsRootBlock r5 = new SafeCheckSettingsRootBlock(r0, getBlockContext());
        IBlockJoinKt.initRootBlock(this, this, r5);
        observeLifeCycle();
    }

    private final void initTitle() {
        initTitleBar(false, false);
        this.mTitle.setCenterTitle(getString(R.string.settings_application));
    }

    private final void observeLifeCycle() {
        getLifecycle().addObserver(new AnonymousClass1(this));
    }
}
