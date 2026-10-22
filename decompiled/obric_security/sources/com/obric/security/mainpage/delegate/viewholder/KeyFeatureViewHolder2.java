package com.obric.security.mainpage.delegate.viewholder;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.blockframework.framework.join.BlockContextImpl;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedance.blockframework.framework.join.IBlockJoin;
import com.bytedance.blockframework.framework.join.IBlockJoinKt;
import com.bytedance.blockframework.framework.join.IBlockScene;
import com.obric.security.mainpage.block.KeyFeatureBlock;
import com.obric.security.mainpage.block.depend.IHolderBlockDepend;
import com.obric.security.mainpage.delegate.data.KeyFeatureData;
import com.obric.security.mainpage.delegate.data.KeyFeatureModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyFeatureViewHolder2.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aR\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/security/mainpage/delegate/viewholder/KeyFeatureViewHolder2;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/blockframework/framework/join/IBlockJoin;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "getBlockContext", "()Lcom/bytedance/blockframework/framework/join/IBlockContext;", "blockContext$delegate", "Lkotlin/Lazy;", "blockScene", "Lcom/bytedance/blockframework/framework/join/IBlockScene;", "getBlockScene", "()Lcom/bytedance/blockframework/framework/join/IBlockScene;", "blockScene$delegate", "holderDepend", "Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", "rootBlock", "Lcom/obric/security/mainpage/block/KeyFeatureBlock;", "initKeyFeatureBlock", "", "observeLifeCycle", "onBind", "appInfo", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureData;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class KeyFeatureViewHolder2 extends RecyclerView.ViewHolder implements IBlockJoin {
    private final Lazy blockContext$delegate;
    private final Lazy blockScene$delegate;
    private final IHolderBlockDepend holderDepend;
    private final View itemView;
    private KeyFeatureBlock rootBlock;

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

    @Override // com.bytedance.blockframework.framework.join.IBlockJoin
    public IBlockContext getBlockContext() {
        return (IBlockContext) this.blockContext$delegate.getValue();
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockJoin
    public IBlockScene getBlockScene() {
        return (IBlockScene) this.blockScene$delegate.getValue();
    }

    public KeyFeatureViewHolder2(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.itemView = r2;
        this.holderDepend = new KeyFeatureViewHolder2$holderDepend$1(this);
        this.blockContext$delegate = LazyKt.lazy(new KeyFeatureViewHolder2$blockContext$2(this));
        this.blockScene$delegate = LazyKt.lazy(KeyFeatureViewHolder2$blockScene$2.INSTANCE);
    }

    public final void onBind(KeyFeatureData r2) {
        Intrinsics.checkNotNullParameter(r2, "appInfo");
        KeyFeatureModel r0 = new KeyFeatureModel(r2);
        IBlockContext r1 = getBlockContext();
        if ((r1 instanceof BlockContextImpl) == false) goto L5;
        BlockContextImpl r3 = (BlockContextImpl) r1;
    L6:
        if (r3 == null) goto L9;
        r3.bindBlockModel(r0);
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void initKeyFeatureBlock() {
        View r1 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r1, "itemView");
        KeyFeatureBlock r0 = new KeyFeatureBlock(r1, getBlockContext());
        IHolderBlockDepend r2 = this.holderDepend;
        getBlockContext().registerDepend(IHolderBlockDepend.class, r2);
        Unit r3 = Unit.INSTANCE;
        this.rootBlock = r0;
        View r4 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r4, "itemView");
        Context r5 = r4.getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "itemView.context");
        KeyFeatureBlock r6 = this.rootBlock;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootBlock");
    L5:
        IBlockJoinKt.initRootBlock(this, r5, r6);
        IBlockJoinKt.dispatchOnCreate(this);
        observeLifeCycle();
    }

    private final void observeLifeCycle() {
        View r0 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r0, "itemView");
        Object r1 = r0.getContext();
        if ((r1 instanceof LifecycleOwner) == true) goto L5;
        r1 = null;
    L5:
        LifecycleOwner r2 = (LifecycleOwner) r1;
        if (r2 == null) goto L11;
        Lifecycle r3 = r2.getLifecycle();
        if (r3 == null) goto L12;
        r3.addObserver(new AnonymousClass1(this));
        return;
    L12:
        return;
    }
}
