package com.obric.security.cleaner.cacheFragment.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.image.OImage;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.security.R;
import com.obric.security.cleaner.CleanerDetailViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: compiled from: SystemCacheViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/security/cleaner/cacheFragment/viewholder/SystemCacheViewHolder;", "Lcom/obric/security/cleaner/cacheFragment/viewholder/RubbishBaseViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "viewModel", "Lcom/obric/security/cleaner/CleanerDetailViewModel;", "onBind", "", "data", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SystemCacheViewHolder extends RubbishBaseViewHolder {
    private CleanerDetailViewModel viewModel;

    public SystemCacheViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    public static final /* synthetic */ CleanerDetailViewModel access$getViewModel$p(SystemCacheViewHolder r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$setViewModel$p(SystemCacheViewHolder r0, CleanerDetailViewModel r1) {
        r0.viewModel = r1;
    }

    @Override // com.obric.security.cleaner.cacheFragment.viewholder.RubbishBaseViewHolder
    public void onBind(final RubbishEntity r11) {
        Intrinsics.checkNotNullParameter(r11, "data");
        View r0 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r0, "itemView");
        Object r1 = r0.getContext();
        View r2 = null;
        if ((r1 instanceof ViewModelStoreOwner) == true) goto L5;
        r1 = null;
    L5:
        ViewModelStoreOwner r3 = (ViewModelStoreOwner) r1;
        if (r3 == null) goto L8;
        CleanerDetailViewModel r4 = (CleanerDetailViewModel) new ViewModelProvider(r3).get(CleanerDetailViewModel.class);
    L9:
        this.viewModel = r4;
        OCardListItem r5 = getOCardListItem();
        boolean r6 = false;
        if (r5 == null) goto L12;
        r5.setVisibility(0);
    L12:
        OCardListItem r7 = getOCardListItem();
        if (r7 == null) goto L15;
        FrameLayout r8 = (FrameLayout) r7.findViewById(R.id.icon_container);
    L16:
        OCardListItem r9 = getOCardListItem();
        Intrinsics.checkNotNull(r9);
        Context r10 = r9.getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "oCardListItem!!.context");
        OImage r12 = new OImage(r10, null, 0, 6, null);
        OCardListItem r13 = getOCardListItem();
        Intrinsics.checkNotNull(r13);
        r12.setImageDrawable(r13.getContext().getDrawable(R.drawable.file_unknown));
        r12.setRadiusDp(8.0f);
        if (r8 == null) goto L19;
        r8.addView(r12);
    L19:
        OCardListItem r14 = getOCardListItem();
        if (r14 == null) goto L22;
        r14.setCardType(1);
    L22:
        OCardListItem r15 = getOCardListItem();
        if (r15 == null) goto L25;
        r15.showIcon(true);
    L25:
        OCardListItem r16 = getOCardListItem();
        if (r16 == null) goto L28;
        r16.setTitle(r11.getDescription());
    L28:
        OCardListItem r17 = getOCardListItem();
        if (r17 == null) goto L31;
        r17.showTitle(true);
    L31:
        OCardListItem r18 = getOCardListItem();
        if (r18 == null) goto L34;
        OCardListItem.setEndDetailText$default(r18, getSizeString(r11.getSize()), 0, 2, null);
    L34:
        OCardListItem r19 = getOCardListItem();
        if (r19 == null) goto L37;
        r19.showCustomEnd(true);
    L37:
        View r20 = getOCardListItem().getCustomStartView();
        if ((r20 instanceof OCheckBoxLayout) == true) goto L40;
        r20 = null;
    L40:
        OCheckBoxLayout r21 = (OCheckBoxLayout) r20;
        if (r21 == null) goto L43;
        r21.setOnClickListener(null);
    L43:
        OCardListItem r22 = getOCardListItem();
        if (r22 == null) goto L46;
        View r23 = r22.getCustomStartView();
    L48:
        if ((r23 instanceof OCheckBoxLayout) == true) goto L50;
        r23 = null;
    L50:
        OCheckBoxLayout r24 = (OCheckBoxLayout) r23;
        if (r24 == null) goto L53;
        r24.setOnCheckedChangeListener(null);
    L53:
        OCardListItem r25 = getOCardListItem();
        if (r25 == null) goto L56;
        r25.setDefaultCustomStartView(0);
    L56:
        OCardListItem r26 = getOCardListItem();
        if (r26 == null) goto L59;
        r26.showCustomStart(true);
    L59:
        OCardListItem r27 = getOCardListItem();
        if (r27 == null) goto L62;
        View r28 = r27.getCustomStartView();
    L64:
        if ((r28 instanceof OCheckBoxLayout) == false) goto L67;
        r2 = r28;
    L67:
        final OCheckBoxLayout r29 = (OCheckBoxLayout) r2;
        if (r29 == null) goto L73;
        CleanerDetailViewModel r30 = this.viewModel;
        if (r30 == null) goto L72;
        r6 = r30.isSelected(r11);
    L72:
        r29.setChecked(r6);
    L73:
        OCardListItem r31 = getOCardListItem();
        if (r31 == null) goto L76;
        r31.showCustomStart(true);
    L76:
        OCardListItem r32 = getOCardListItem();
        if (r32 == null) goto L79;
        r32.setOnContentClickListener(new AnonymousClass3(this, r29, r11));
    L79:
        if (r29 == null) goto L82;
        r29.setOnCheckedChangeListener(new AnonymousClass4(this, r11));
        return;
    L82:
        return;
    L62:
        r28 = null;
        goto L64
    L46:
        r23 = null;
        goto L48
    L15:
        r8 = null;
        goto L16
    L8:
        r4 = null;
        goto L9
    }
}
