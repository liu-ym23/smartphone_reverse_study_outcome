package com.obric.securitycenter.nodisturb;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ResourceCursorAdapter;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: BlackDetailAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\u0017J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/securitycenter/nodisturb/BlackDetailAdapter;", "Landroid/widget/ResourceCursorAdapter;", "context", "Landroid/content/Context;", "layoutId", "", "c", "Landroid/database/Cursor;", "(Landroid/content/Context;ILandroid/database/Cursor;)V", "TAG", "", "bindView", "", "view", "Landroid/view/View;", "cursor", "formatDateToLocalString", ProviderConstants.Sms.DATE, "Ljava/util/Date;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlackDetailAdapter extends ResourceCursorAdapter {
    private final String TAG;
    private final int layoutId;

    public BlackDetailAdapter(Context r2, int r3, Cursor r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.layoutId = r3;
        this.TAG = "BlackDetailAdapter";
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View r9, Context r10, Cursor r11) {
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "cursor");
        OCardListItem r0 = (OCardListItem) r9.findViewById(R.id.black_item);
        r0.setOnClickListener(null);
        r0.setShowCardBg(true);
        int r3 = r11.getPosition();
        int r4 = r11.getCount();
        if (r4 != 1) goto L5;
        Intrinsics.checkNotNullExpressionValue(r0, "item");
        OCardListItem.setCardPosition$default(r0, 0, false, 2, null);
    L12:
        if (r3 != 0) goto L14;
        ((OSectionTitleBar) r9.findViewById(R.id.custom_title)).setVisibility(0);
    L15:
        int r12 = r11.getColumnIndex("bcl_datetime");
        if (r12 < 0) goto L30;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L22
        r0.setTitle(formatDateToLocalString(new Date(r11.getLong(r12))));     // Catch: Throwable -> L22
        r0.setSubTitle("已拦截来电");     // Catch: Throwable -> L22
        r0.showSubTitle(false);     // Catch: Throwable -> L22
        if (r0.findViewById(R.id.black_detail_sub_title) != null) goto L20;
        LinearLayout r13 = (LinearLayout) r0.findViewById(R.id.title_container);     // Catch: Throwable -> L22
        View r14 = LayoutInflater.from(r10).inflate(R.layout.black_detail_item_sub_title, null);     // Catch: Throwable -> L22
        ImageView r1 = (ImageView) r14.findViewById(R.id.ic_card);     // Catch: Throwable -> L22
        OTextView r2 = (OTextView) r14.findViewById(R.id.sub_title);     // Catch: Throwable -> L22
        r1.setVisibility(8);     // Catch: Throwable -> L22
        r2.setText(r10.getString(R.string.intercept_call_detail_text));     // Catch: Throwable -> L22
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-1, -2);     // Catch: Throwable -> L22
        r15.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));     // Catch: Throwable -> L22
        r14.setLayoutParams(r15);     // Catch: Throwable -> L22
        r13.addView(r14);     // Catch: Throwable -> L22
    L20:
        Object r16 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r17 = Result.m777exceptionOrNullimpl(r16);
        if (r17 == null) goto L31;
        OLog.e(this.TAG, "bindView: ", r17);
        return;
    L31:
        return;
    L22:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L24
    L30:
        return;
    L14:
        ((OSectionTitleBar) r9.findViewById(R.id.custom_title)).setVisibility(8);
        goto L15
    L5:
        if (r3 != 0) goto L8;
        Intrinsics.checkNotNullExpressionValue(r0, "item");
        OCardListItem.setCardPosition$default(r0, 1, false, 2, null);
        goto L12
    L8:
        if (r3 != (r4 - 1)) goto L10;
        Intrinsics.checkNotNullExpressionValue(r0, "item");
        OCardListItem.setCardPosition$default(r0, 3, false, 2, null);
        goto L12
    L10:
        Intrinsics.checkNotNullExpressionValue(r0, "item");
        OCardListItem.setCardPosition$default(r0, 2, false, 2, null);
        goto L12
    }

    private final String formatDateToLocalString(Date r3) {
        Calendar r2 = Calendar.getInstance();
        r2.setTime(r3);
        r2.setTimeZone(TimeZone.getDefault());
        int r0 = Calendar.getInstance().get(1);
        if (r2.get(1) != r0) goto L5;
        String r4 = "MM月dd日 HH:mm";
    L6:
        String r5 = new SimpleDateFormat(r4, Locale.getDefault()).format(r3);
        Intrinsics.checkNotNullExpressionValue(r5, "SimpleDateFormat(pattern…etDefault()).format(date)");
        return r5;
    L5:
        r4 = "yyyy年MM月dd日 HH:mm";
        goto L6
    }
}
