package com.android.settings.wifi.assistant;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.wifi.AccessPointInfo;
import com.android.settings.wifi.AccessPointView;
import com.android.settings.wifi.Utils;
import com.android.wifitrackerlib.WifiEntry;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.tag.OTextTag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccessPointUIUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0013\u001a\u00020\u0014*\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/android/settings/wifi/assistant/AccessPointUIUtils;", "", "()V", "TAG", "", "customTitle", "Landroid/widget/TextView;", "Lcom/obric/oui/lisitem/OCardListItem;", "getCustomTitle", "(Lcom/obric/oui/lisitem/OCardListItem;)Landroid/widget/TextView;", "customTitleTag", "Lcom/obric/oui/tag/OTextTag;", "getCustomTitleTag", "(Lcom/obric/oui/lisitem/OCardListItem;)Lcom/obric/oui/tag/OTextTag;", "getSubTitle", "info", "Lcom/android/settings/wifi/AccessPointInfo;", "context", "Landroid/content/Context;", "bindData", "", "point", "Lcom/android/settings/wifi/assistant/SubAccessPoint;", "isMain", "", "Lcom/obric/oui/lisitem/OListItemSettings;", "Lcom/android/wifitrackerlib/WifiEntry;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccessPointUIUtils {
    public static final AccessPointUIUtils INSTANCE = null;
    private static final String TAG = "AccessPointUIUtils";

    static {
        INSTANCE = new AccessPointUIUtils();
    }

    private AccessPointUIUtils() {
    }

    public static /* synthetic */ void bindData$default(AccessPointUIUtils r0, OListItemSettings r1, SubAccessPoint r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        r0.bindData(r1, r2, r3);
    }

    public final void bindData(OListItemSettings r6, SubAccessPoint r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "point");
        AccessPointInfo r0 = r7.getInfo();
        int r2 = 4;
        r6.getContentImgBackground().setVisibility(4);
        r6.setTitleString(r0.ssid);
        boolean r3 = true;
        if (r8 == false) goto L14;
        String r9 = r7.getSummary();
        if (r9.length() <= 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L11;
        r9 = null;
    L11:
        if (r9 != null) goto L13;
        Context r11 = r6.getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "getContext(...)");
        r9 = getSubTitle(r0, r11);
    L13:
        String r12 = r9;
    L15:
        r6.setSubTitleString(r12);
        r6.getMTvSubtitle().setTextColor(r6.getResources().getColor(R.color.oui_text_3));
        ImageView r5 = r6.getMIvContent();
        if (r0.mRssi != Integer.MAX_VALUE) goto L18;
        r5.setImageDrawable(null);
        r5.setVisibility(8);
    L24:
        if (r0.mState == null) goto L26;
    L29:
        FrameLayout r13 = r6.getMTrailingElement();
        if (r3 == false) goto L32;
        r2 = 0;
    L32:
        r13.setVisibility(r2);
        r6.updateState();
        return;
    L26:
        if (r0.mConfig != null) goto L29;
        r3 = false;
        goto L29
    L18:
        r5.setImageResource(R.drawable.wifi_signal);
        r5.setImageLevel(Math.max(0, Math.min(r0.getLevel(), 3)));
        if (r0.security != 0) goto L21;
        int[] r14 = AccessPointView.STATE_NONE;
    L22:
        r5.setImageState(r14, true);
        r5.setVisibility(0);
        goto L24
    L21:
        r14 = AccessPointView.STATE_SECURED;
        goto L22
    L7:
        r10 = false;
        goto L8
    L14:
        r12 = r7.getSummary();
        goto L15
    }

    public static /* synthetic */ void bindData$default(AccessPointUIUtils r0, OCardListItem r1, SubAccessPoint r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        r0.bindData(r1, r2, r3);
    }

    public final void bindData(OCardListItem r8, SubAccessPoint r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "point");
        AccessPointInfo r0 = r9.getInfo();
        r8.setTitle(r0.ssid);
        boolean r2 = true;
        int r3 = 0;
        if (r10 == false) goto L13;
        String r11 = r9.getSummary();
        if (r11.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r11 = null;
    L11:
        if (r11 != null) goto L14;
        Context r12 = r8.getContext();
        Intrinsics.checkNotNullExpressionValue(r12, "getContext(...)");
        r11 = getSubTitle(r0, r12);
    L14:
        r8.setSubTitle(r11);
        r8.showSubTitle(true);
        r8.getSubTitleView().setTextColor(r8.getResources().getColor(R.color.oui_text_3));
        ImageView r13 = r8.getIconView();
        if (r0.mRssi != Integer.MAX_VALUE) goto L17;
        r13.setImageDrawable(null);
        r13.setVisibility(8);
    L22:
        r8.showIcon(true);
        if (r0.mState == null) goto L25;
    L28:
        r8.showCustomEnd(r2);
        TextView r14 = getCustomTitle(r8);
        if (r14 == null) goto L31;
        r14.setText(r0.ssid);
        r8.showTitle(false);
    L31:
        Object r15 = SettingsApplication.getContext().getSystemService(WifiManager.class);
        Intrinsics.checkNotNullExpressionValue(r15, "getSystemService(...)");
        WifiInfo r16 = ((WifiManager) r15).getConnectionInfo();
        if (r10 == false) goto L41;
        OTextTag r7 = getCustomTitleTag(r8);
        if (r7 == null) goto L42;
        r7.setText(R.string.wifi_tag_5g);
        if (r16.is5GHz() == true) goto L39;
        r3 = 8;
    L39:
        r7.setVisibility(r3);
        return;
    L42:
        return;
    L41:
        return;
    L25:
        if (r0.mConfig != null) goto L28;
        r2 = false;
        goto L28
    L17:
        r13.setImageResource(R.drawable.wifi_signal);
        r13.setImageLevel(Math.max(0, Math.min(r0.getLevel(), 3)));
        if (r0.security != 0) goto L20;
        int[] r1 = AccessPointView.STATE_NONE;
    L21:
        r13.setImageState(r1, true);
        r13.setVisibility(0);
        goto L22
    L20:
        r1 = AccessPointView.STATE_SECURED;
        goto L21
    L7:
        r4 = false;
        goto L8
    L13:
        r11 = r9.getSummary();
        goto L14
    }

    private final TextView getCustomTitle(OCardListItem r1) {
        return (TextView) r1.findViewById(R.id.custom_title_text);
    }

    private final OTextTag getCustomTitleTag(OCardListItem r1) {
        return (OTextTag) r1.findViewById(R.id.custom_title_tag);
    }

    private final String getSubTitle(AccessPointInfo r1, Context r2) {
        if (r1.wifiEntry == null) goto L5;
        String r0 = Utils.getWifiEntrySummary(r1.wifiEntry);
        Intrinsics.checkNotNullExpressionValue(r0, "getWifiEntrySummary(...)");
        return r0;
    L5:
        return "";
    }

    public final void bindData(OListItemSettings r3, WifiEntry r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "info");
        r3.getContentImgBackground().setVisibility(4);
        r3.setTitleString(r4.getSsid());
        r3.setSubTitleString(r4.getSummary());
        ImageView r2 = r3.getMIvContent();
        if (r4.getLevel() != (-1)) goto L5;
        r2.setImageDrawable(null);
        r2.setVisibility(8);
    L10:
        r3.updateState();
        return;
    L5:
        r2.setImageResource(R.drawable.wifi_signal);
        r2.setImageLevel(Math.min(r4.getLevel(), 3));
        if (r4.getSecurity() != 0) goto L8;
        int[] r5 = AccessPointView.STATE_NONE;
    L9:
        r2.setImageState(r5, true);
        r2.setVisibility(0);
        goto L10
    L8:
        r5 = AccessPointView.STATE_SECURED;
        goto L9
    }
}
