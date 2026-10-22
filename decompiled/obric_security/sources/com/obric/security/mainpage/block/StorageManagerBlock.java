package com.obric.security.mainpage.block;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.blockframework.framework.base.UIBlock;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.storage.StorageMeasurement;
import com.bytedanceos.utils.ByteConverter;
import com.bytedanceos.utils.ByteUnitPair;
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

/* JADX INFO: compiled from: StorageManagerBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u001fH\u0002J\b\u0010(\u001a\u00020\u001fH\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/obric/security/mainpage/block/StorageManagerBlock;", "Lcom/bytedance/blockframework/framework/base/UIBlock;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureData;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureModel;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "holderDepend", "Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", "getHolderDepend", "()Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", "holderDepend$delegate", "Lkotlin/properties/ReadOnlyProperty;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", PushLog.KEY_LABEL, "Lcom/obric/oui/text/OTextView;", "mMeasure", "Lcom/bytedanceos/storage/StorageMeasurement;", "mReceiver", "Lcom/bytedanceos/storage/StorageMeasurement$MeasurementReceiver;", "title", "getTitle", "()Lcom/obric/oui/text/OTextView;", "setTitle", "(Lcom/obric/oui/text/OTextView;)V", "bindModel", "", "model", "formatSize", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "layoutResource", "", "measure", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class StorageManagerBlock extends UIBlock<KeyFeatureData, KeyFeatureModel> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty holderDepend$delegate;
    private ImageView icon;
    private OTextView label;
    private StorageMeasurement mMeasure;
    private final StorageMeasurement.MeasurementReceiver mReceiver;
    private OTextView title;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(StorageManagerBlock.class, "holderDepend", "getHolderDepend()Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", 0))};
    }

    private final IHolderBlockDepend getHolderDepend() {
        return (IHolderBlockDepend) this.holderDepend$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock
    public int layoutResource() {
        return R.layout.key_feature_item_block;
    }

    public StorageManagerBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
        this.mReceiver = new StorageManagerBlock$mReceiver$1(this);
        this.holderDepend$delegate = new StorageManagerBlock$$special$$inlined$findDepend$1(this);
    }

    public static final /* synthetic */ String access$formatSize(StorageManagerBlock r0, long r1) {
        return r0.formatSize(r1);
    }

    public static final /* synthetic */ OTextView access$getLabel$p(StorageManagerBlock r0) {
        return r0.label;
    }

    public static final /* synthetic */ void access$setLabel$p(StorageManagerBlock r0, OTextView r1) {
        r0.label = r1;
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
    public void onViewCreated(final View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        this.icon = (ImageView) r4.findViewById(R.id.icon);
        this.title = (OTextView) r4.findViewById(R.id.title);
        this.label = (OTextView) r4.findViewById(R.id.label);
        ImageView r0 = this.icon;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.setImageDrawable(AppCompatResources.getDrawable(r0.getContext(), R.drawable.storage_manager));
    L5:
        OTextView r3 = this.title;
        View r1 = null;
        if (r3 == null) goto L14;
        if (r3 == null) goto L11;
        Context r2 = r3.getContext();
        if (r2 == null) goto L11;
        String r5 = r2.getString(R.string.storage_manager);
    L12:
        r3.setText(r5);
    L11:
        r5 = null;
    L14:
        if ((r4 instanceof OUILinearLayout) == false) goto L17;
        r1 = r4;
    L17:
        OUILinearLayout r6 = (OUILinearLayout) r1;
        if (r6 == null) goto L20;
        r6.setRadius(DisplayHelper.dpToPx(16));
    L20:
        r4.setOnClickListener(new AnonymousClass1(r4));
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onResume() {
        OTextView r0 = this.label;
        if (r0 == null) goto L5;
        Context r1 = r0.getContext();
    L6:
        PreferenceMgr r2 = PreferenceMgr.getInstance(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "PreferenceMgr.getInstance(label?.context)");
        if (r2.isAllowed() == true) goto L9;
        return;
    L9:
        if (this.mMeasure != null) goto L17;
        OTextView r3 = this.label;
        if (r3 == null) goto L13;
        Context r4 = r3.getContext();
    L14:
        StorageMeasurement r5 = StorageMeasurement.getInstance(r4, null);
        this.mMeasure = r5;
        if (r5 == null) goto L17;
        r5.setMeasureDetail(false);
        goto L17
    L13:
        r4 = null;
    L17:
        StorageMeasurement r6 = this.mMeasure;
        if (r6 == null) goto L20;
        r6.setReceiver(this.mReceiver);
    L20:
        measure();
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void measure() {
        StorageMeasurement r0 = this.mMeasure;
        if (r0 == null) goto L5;
        r0.setMeasureDetail(false);
    L5:
        StorageMeasurement r1 = this.mMeasure;
        if (r1 == null) goto L8;
        r1.invalidate();
    L8:
        StorageMeasurement r2 = this.mMeasure;
        if (r2 == null) goto L12;
        r2.measure();
        return;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onPause() {
        StorageMeasurement r0 = this.mMeasure;
        if (r0 == null) goto L6;
        r0.resetReciver();
        return;
    }

    private final String formatSize(long r2) {
        ByteUnitPair r1 = ByteConverter.convert(r2, "B", 1000);
        return r1.getValue() + r1.getUnit();
    }

    public void bindModel(KeyFeatureModel r1) {
        super.bindModel(r1);
    }
}
