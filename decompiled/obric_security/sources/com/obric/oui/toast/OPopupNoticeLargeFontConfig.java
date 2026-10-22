package com.obric.oui.toast;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPopupNoticeLargeFontConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\u00020\u000e*\u00020\u000eH\u0002J\f\u0010\u000f\u001a\u00020\u000e*\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/toast/OPopupNoticeLargeFontConfig;", "", "popupNoticeBuilder", "Lcom/obric/oui/toast/OPopupNotice$Builder;", "(Lcom/obric/oui/toast/OPopupNotice$Builder;)V", "_FIXED_LARGE_FONT_SCALE", "", "getPopupNoticeBuilder", "()Lcom/obric/oui/toast/OPopupNotice$Builder;", "initConfig", "", "contentView", "Landroid/view/View;", "limitLineSpacing", "Landroid/widget/TextView;", "limitTextSize", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopupNoticeLargeFontConfig {
    private final float _FIXED_LARGE_FONT_SCALE;
    private final OPopupNotice.Builder popupNoticeBuilder;

    public OPopupNoticeLargeFontConfig(OPopupNotice.Builder r2) {
        Intrinsics.checkNotNullParameter(r2, "popupNoticeBuilder");
        this.popupNoticeBuilder = r2;
        this._FIXED_LARGE_FONT_SCALE = 1.15f;
    }

    public final OPopupNotice.Builder getPopupNoticeBuilder() {
        return this.popupNoticeBuilder;
    }

    public final void initConfig(View r3) {
        Intrinsics.checkNotNullParameter(r3, "contentView");
        if (this.popupNoticeBuilder.getLeftView() != null) goto L8;
        View r0 = r3.findViewById(R.id.fl_left_container);
        if (r0 == null) goto L8;
        ViewExtensionsKt.makeGone(r0);
    L8:
        TextView r1 = (TextView) r3.findViewById(R.id.tv_left);
        if (r1 == null) goto L15;
        TextView r2 = limitTextSize(r1);
        if (r2 == null) goto L15;
        limitLineSpacing(r2);
    L15:
        TextView r4 = (TextView) r3.findViewById(R.id.tv_left_subtitle);
        if (r4 == null) goto L22;
        TextView r5 = limitTextSize(r4);
        if (r5 == null) goto L22;
        limitLineSpacing(r5);
    L22:
        OButton r6 = (OButton) r3.findViewById(R.id.tv_right);
        if (r6 == null) goto L26;
        limitTextSize(r6);
    L26:
        ImageView r7 = (ImageView) r3.findViewById(R.id.iv_right);
        if (r7 == null) goto L34;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L35;
        r8.width = (int) (r8.width * this._FIXED_LARGE_FONT_SCALE);
        r8.height = (int) (r8.height * this._FIXED_LARGE_FONT_SCALE);
        return;
    L35:
        return;
    }

    private final TextView limitTextSize(TextView r3) {
        r3.setTextSize(0, (r3.getTextSize() / r3.getContext().getResources().getConfiguration().fontScale) * this._FIXED_LARGE_FONT_SCALE);
        return r3;
    }

    private final TextView limitLineSpacing(TextView r2) {
        r2.setLineSpacing(3.0f, 1.0f);
        return r2;
    }
}
