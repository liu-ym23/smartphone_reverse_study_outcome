package com.bytedance.blockframework.framework.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedance.blockframework.framework.task.BlockInflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UIBlock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ!\u0010\u0013\u001a\u0004\u0018\u0001H\u0014\"\b\b\u0002\u0010\u0014*\u00020\n2\b\b\u0001\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\n\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0019\u001a\u00020\u0016H&J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\nH\u0016R\u001a\u0010\t\u001a\u00020\nX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/blockframework/framework/base/UIBlock;", "DATA", "MODEL", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "Lcom/bytedance/blockframework/framework/base/IUIBlock;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "containerView", "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", "setContainerView", "(Landroid/view/View;)V", "uiConfig", "Lcom/bytedance/blockframework/framework/base/UIBlockConfig;", "getUiConfig", "()Lcom/bytedance/blockframework/framework/base/UIBlockConfig;", "findViewById", ExifInterface.GPS_DIRECTION_TRUE, SlardarConfigConsts.CONFIG_ID, "", "(I)Landroid/view/View;", "getView", "layoutResource", "onCreateView", "parent", "onViewCreated", "", "view", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class UIBlock<DATA, MODEL extends IBlockModel<DATA>> extends BaseBlock<DATA, MODEL> implements IUIBlock {
    public View containerView;
    private final UIBlockConfig uiConfig;

    public abstract int layoutResource();

    @Override // com.bytedance.blockframework.framework.base.IUIBlock
    public void onViewCreated(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public UIBlock(IBlockContext r10) {
        Intrinsics.checkNotNullParameter(r10, "blockContext");
        super(r10);
        this.uiConfig = new UIBlockConfig(0, null, false, false, null, 31, null);
    }

    @Override // com.bytedance.blockframework.framework.base.IUIBlock
    public boolean customGenerateView(View r1, View r2) {
        return IUIBlock.DefaultImpls.customGenerateView(this, r1, r2);
    }

    @Override // com.bytedance.blockframework.framework.base.IUIBlock
    public UIBlockConfig getUiConfig() {
        return this.uiConfig;
    }

    @Override // com.bytedance.blockframework.framework.base.IUIBlock, kotlinx.android.extensions.LayoutContainer
    public View getContainerView() {
        View r0 = this.containerView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
        return null;
    }

    @Override // com.bytedance.blockframework.framework.base.IUIBlock
    public void setContainerView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.containerView = r2;
    }

    @Override // com.bytedance.blockframework.framework.base.IUIBlock
    public View onCreateView(View r4) {
        if (layoutResource() != (-1)) goto L6;
        Intrinsics.checkNotNull(r4);
        return r4;
    L6:
        BlockInflater r0 = getUiConfig().getViewInflater();
        int r3 = layoutResource();
        Intrinsics.checkNotNull(r4);
        Context r1 = r4.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "parent!!.context");
        return r0.getView(r3, r1, (ViewGroup) r4);
    }

    @Override // com.bytedance.blockframework.framework.base.IUIBlock
    public View getView() {
        if (this.containerView != null) goto L7;
        return null;
    L7:
        return getContainerView();
    }

    public final <T extends View> T findViewById(int r1) {
        View r0 = getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.findViewById(r1);
    }
}
