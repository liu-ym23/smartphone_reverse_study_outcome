package com.obric.security.mainpage.block;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.blockframework.framework.base.UIBlock;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import com.obric.security.R;
import com.obric.security.mainpage.block.depend.IHolderBlockDepend;
import com.obric.security.mainpage.delegate.data.KeyFeatureData;
import com.obric.security.mainpage.delegate.data.KeyFeatureModel;
import com.ss.android.message.log.PushLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import obric.util.DisplayHelper;

/* JADX INFO: compiled from: MemoryCleanBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/obric/security/mainpage/block/MemoryCleanBlock;", "Lcom/bytedance/blockframework/framework/base/UIBlock;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureData;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureModel;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "holderDepend", "Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", "getHolderDepend", "()Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", "holderDepend$delegate", "Lkotlin/properties/ReadOnlyProperty;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", PushLog.KEY_LABEL, "Lcom/obric/oui/text/OTextView;", "title", "getTitle", "()Lcom/obric/oui/text/OTextView;", "setTitle", "(Lcom/obric/oui/text/OTextView;)V", "bindModel", "", "model", "layoutResource", "", "onViewCreated", "view", "Landroid/view/View;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class MemoryCleanBlock extends UIBlock<KeyFeatureData, KeyFeatureModel> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty holderDepend$delegate;
    private ImageView icon;
    private OTextView label;
    private OTextView title;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MemoryCleanBlock.class, "holderDepend", "getHolderDepend()Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", 0))};
    }

    private final IHolderBlockDepend getHolderDepend() {
        return (IHolderBlockDepend) this.holderDepend$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock
    public int layoutResource() {
        return R.layout.key_feature_item_block;
    }

    public MemoryCleanBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
        this.holderDepend$delegate = new MemoryCleanBlock$$special$$inlined$findDepend$1(this);
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public /* bridge */ /* synthetic */ void bindModel(IBlockModel r1) {
        bindModel((KeyFeatureModel) r1);
    }

    public final ImageView getIcon() {
        return this.icon;
    }

    public final void setIcon(ImageView r1) {
        this.icon = r1;
    }

    public final OTextView getTitle() {
        return this.title;
    }

    public final void setTitle(OTextView r1) {
        this.title = r1;
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public void onViewCreated(final View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.icon = (ImageView) r5.findViewById(R.id.icon);
        this.title = (OTextView) r5.findViewById(R.id.title);
        this.label = (OTextView) r5.findViewById(R.id.label);
        String r1 = null;
        if ((r5 instanceof OUILinearLayout) == true) goto L5;
        View r0 = null;
    L6:
        OUILinearLayout r2 = (OUILinearLayout) r0;
        if (r2 == null) goto L9;
        r2.setRadius(DisplayHelper.dpToPx(16));
    L9:
        ImageView r3 = this.icon;
        if (r3 == null) goto L12;
        r3.setImageDrawable(AppCompatResources.getDrawable(r5.getContext(), R.drawable.memory_clean));
    L12:
        OTextView r4 = this.title;
        if (r4 == null) goto L20;
        if (r4 == null) goto L18;
        Context r6 = r4.getContext();
        if (r6 == null) goto L18;
        String r7 = r6.getString(R.string.action_clean_memory);
    L19:
        r4.setText(r7);
    L18:
        r7 = null;
    L20:
        OTextView r8 = this.label;
        if (r8 == null) goto L28;
        OTextView r9 = this.title;
        if (r9 == null) goto L27;
        Context r10 = r9.getContext();
        if (r10 == null) goto L27;
        r1 = r10.getString(R.string.clean_memory_label);
    L27:
        r8.setText(r1);
    L28:
        r5.setOnClickListener(new AnonymousClass1(r5));
        return;
    L5:
        r0 = r5;
        goto L6
    }

    public void bindModel(KeyFeatureModel r1) {
        super.bindModel(r1);
    }
}
