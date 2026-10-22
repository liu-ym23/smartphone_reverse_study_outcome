package com.obric.securitycenter.nodisturb.setting.slot;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.Utils;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.securitycenter.nodisturb.R;
import com.obric.securitycenter.nodisturb.sms.keyword.SMSKeywordsFilterActivity;
import com.obric.slot.Slot;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmsKeywordSlot.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/securitycenter/nodisturb/setting/slot/SmsKeywordSlot;", "Lcom/obric/slot/Slot;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cardItem", "Lcom/obric/oui/lisitem/OCardListItem;", "bindView", "", "view", "Landroid/view/View;", "createView", "onPositioned", Utils.INTENT_KEY_INDEX, "", PerfConsts.PERF_DISK_TOTAL, "querySmsKeywordCount", "contentResolver", "Landroid/content/ContentResolver;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmsKeywordSlot extends Slot {
    private OCardListItem cardItem;

    public static /* synthetic */ void $r8$lambda$9clQlS_HavwYI6J6UScXqvoX5VE(OCardListItem r0, View r1) {
        createView$lambda$1$lambda$0(r0, r1);
    }

    public SmsKeywordSlot(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.obric.slot.Slot
    public View createView() {
        final OCardListItem r6 = new OCardListItem(getContext(), null, 0, 6, null);
        this.cardItem = r6;
        r6.setTitle(r6.getContext().getString(R.string.sms_keyword_filter));
        r6.setSubTitle(r6.getContext().getString(R.string.network_optimization_subtitle_sms));
        r6.showSubTitle(true);
        r6.setDefaultTailIcon(0);
        r6.showTailIcon(true);
        r6.setOnContentClickListener(new SmsKeywordSlot$$ExternalSyntheticLambda0(r6));
        return r6;
    }

    private static final void createView$lambda$1$lambda$0(OCardListItem r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "$this_apply");
        r2.getContext().startActivity(new Intent(r2.getContext(), SMSKeywordsFilterActivity.class));
    }

    @Override // com.obric.slot.Slot
    public void onPositioned(View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        OCardListItem r1 = this.cardItem;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardItem");
        r1 = null;
    L5:
        OCardListItem.setCardPosition$default(r1, SlotExtKt.cardPositionOf(r3, r4), false, 2, null);
    }

    @Override // com.obric.slot.Slot
    public void bindView(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        ContentResolver r11 = getContext().getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r11, "context.contentResolver");
        int r12 = querySmsKeywordCount(r11);
        OCardListItem r3 = null;
        if (r12 <= 0) goto L12;
        OCardListItem r4 = this.cardItem;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("cardItem");
        r4 = null;
    L7:
        OCardListItem.setEndDetailText$default(r4, getContext().getString(R.string.list_total_count, new Object[]{String.valueOf(r12)}), 0, 2, null);
        OCardListItem r9 = this.cardItem;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("cardItem");
    L11:
        r3.showCustomEnd(true);
        return;
    L10:
        r3 = r9;
        goto L11
    L12:
        OCardListItem r13 = this.cardItem;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("cardItem");
        r13 = null;
    L15:
        OCardListItem.setEndDetailText$default(r13, "", 0, 2, null);
    }

    private final int querySmsKeywordCount(ContentResolver r7) {
        Uri r1 = Uri.parse("content://com.obric.nodisturb.provider/keyword");
        Cursor r6 = r7.query(r1, new String[]{"COUNT(*) AS total"}, null, null, null);
        int r8 = 0;
        if (r6 != null) goto L5;
    L8:
        return r8;
    L5:
        if (r6.moveToFirst() == false) goto L7;
        r8 = r6.getInt(r6.getColumnIndex(PerfConsts.PERF_DISK_TOTAL));
    L7:
        r6.close();
        goto L8
    }
}
