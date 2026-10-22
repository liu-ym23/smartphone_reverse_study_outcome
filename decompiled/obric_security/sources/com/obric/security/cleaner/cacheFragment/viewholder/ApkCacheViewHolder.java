package com.obric.security.cleaner.cacheFragment.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedanceos.oui.OCardListItemExtKt;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.image.OImage;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.security.R;
import com.obric.security.cleaner.CleanerDetailViewModel;
import com.obric.security.cleaner.bigfile.ImageLoadHelper;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: compiled from: ApkCacheViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/security/cleaner/cacheFragment/viewholder/ApkCacheViewHolder;", "Lcom/obric/security/cleaner/cacheFragment/viewholder/RubbishBaseViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "viewModel", "Lcom/obric/security/cleaner/CleanerDetailViewModel;", "onBind", "", "data", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ApkCacheViewHolder extends RubbishBaseViewHolder {
    private CleanerDetailViewModel viewModel;

    public ApkCacheViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    public static final /* synthetic */ CleanerDetailViewModel access$getViewModel$p(ApkCacheViewHolder r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$setViewModel$p(ApkCacheViewHolder r0, CleanerDetailViewModel r1) {
        r0.viewModel = r1;
    }

    @Override // com.obric.security.cleaner.cacheFragment.viewholder.RubbishBaseViewHolder
    public void onBind(final RubbishEntity r13) {
        Intrinsics.checkNotNullParameter(r13, "data");
        View r0 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r0, "itemView");
        Object r1 = r0.getContext();
        TextView r2 = null;
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
        Set<String> r7 = r13.getSinglePathSizeMap().keySet();
        Intrinsics.checkNotNullExpressionValue(r7, "data.singlePathSizeMap.keys");
        Iterator<T> r8 = r7.iterator();
        boolean r9 = false;
    L14:
        if (r8.hasNext() == false) goto L21;
        String r10 = (String) r8.next();
        ImageLoadHelper r11 = ImageLoadHelper.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r10, "it");
        Drawable r12 = r11.getAppIconFromApk(r10);
        if (r12 == null) goto L14;
        OCardListItem r14 = getOCardListItem();
        if (r14 == null) goto L20;
        r14.setAppIcon(r12);
    L20:
        r9 = true;
        goto L14
    L21:
        if (r9 == true) goto L29;
        OCardListItem r15 = getOCardListItem();
        if (r15 == null) goto L25;
        FrameLayout r16 = (FrameLayout) r15.findViewById(R.id.icon_container);
    L26:
        OCardListItem r17 = getOCardListItem();
        Intrinsics.checkNotNull(r17);
        Context r18 = r17.getContext();
        Intrinsics.checkNotNullExpressionValue(r18, "oCardListItem!!.context");
        OImage r19 = new OImage(r18, null, 0, 6, null);
        OCardListItem r20 = getOCardListItem();
        Intrinsics.checkNotNull(r20);
        r19.setImageDrawable(r20.getContext().getDrawable(R.drawable.file_apk));
        r19.setRadiusDp(8.0f);
        if (r16 == null) goto L29;
        r16.addView(r19);
        goto L29
    L25:
        r16 = null;
    L29:
        OCardListItem r21 = getOCardListItem();
        if (r21 == null) goto L32;
        r21.setCardType(1);
    L32:
        OCardListItem r22 = getOCardListItem();
        if (r22 == null) goto L35;
        r22.showIcon(true);
    L35:
        OCardListItem r23 = getOCardListItem();
        if (r23 == null) goto L38;
        r23.setTitle(r13.getAppName());
    L38:
        OCardListItem r24 = getOCardListItem();
        if (r24 == null) goto L41;
        r24.setSubTitle(r13.getDescription());
    L41:
        OCardListItem r25 = getOCardListItem();
        if (r25 == null) goto L44;
        r25.showTitle(true);
    L44:
        OCardListItem r26 = getOCardListItem();
        if (r26 == null) goto L47;
        r26.showSubTitle(true);
    L47:
        View r27 = getOCardListItem().getCustomStartView();
        if ((r27 instanceof OCheckBoxLayout) == true) goto L50;
        r27 = null;
    L50:
        OCheckBoxLayout r28 = (OCheckBoxLayout) r27;
        if (r28 == null) goto L53;
        r28.setOnClickListener(null);
    L53:
        OCardListItem r29 = getOCardListItem();
        if (r29 == null) goto L56;
        View r30 = r29.getCustomStartView();
    L58:
        if ((r30 instanceof OCheckBoxLayout) == true) goto L60;
        r30 = null;
    L60:
        OCheckBoxLayout r31 = (OCheckBoxLayout) r30;
        if (r31 == null) goto L63;
        r31.setOnCheckedChangeListener(null);
    L63:
        OCardListItem r32 = getOCardListItem();
        if (r32 == null) goto L66;
        r32.setDefaultCustomStartView(0);
    L66:
        OCardListItem r33 = getOCardListItem();
        if (r33 == null) goto L69;
        r33.showCustomStart(true);
    L69:
        OCardListItem r34 = getOCardListItem();
        if (r34 == null) goto L72;
        View r35 = r34.getCustomStartView();
    L74:
        if ((r35 instanceof OCheckBoxLayout) == true) goto L76;
        r35 = null;
    L76:
        final OCheckBoxLayout r36 = (OCheckBoxLayout) r35;
        if (r36 == null) goto L82;
        CleanerDetailViewModel r37 = this.viewModel;
        if (r37 == null) goto L81;
        r6 = r37.isSelected(r13);
    L81:
        r36.setChecked(r6);
    L82:
        OCardListItem r38 = getOCardListItem();
        if (r38 == null) goto L85;
        r38.setOnContentClickListener(new AnonymousClass4(this, r36, r13));
    L85:
        OCardListItem r39 = getOCardListItem();
        if (r39 == null) goto L88;
        OCardListItemExtKt.setEndText(r39, getSizeString(r13.getSize()));
    L88:
        OCardListItem r40 = getOCardListItem();
        if (r40 == null) goto L91;
        r2 = (TextView) r40.findViewById(R.id.title);
    L91:
        if (r2 == null) goto L93;
        r2.setSingleLine(true);
    L93:
        if (r2 == null) goto L95;
        r2.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    L95:
        if (r36 == null) goto L103;
        r36.setOnCheckedChangeListener(new AnonymousClass5(this, r13));
        return;
    L103:
        return;
    L72:
        r35 = null;
        goto L74
    L56:
        r30 = null;
        goto L58
    L8:
        r4 = null;
        goto L9
    }
}
