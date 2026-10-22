package com.obric.oui.privacy;

import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Size;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.adapter.PrivacySheetAdapter;
import com.obric.oui.privacy.recyclerview.PrivacyTopDownAlphaMaskRecyclerView;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.StyleUtil;
import com.obric.oui.window.OWindowConfigController;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OPrivacySheet.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002J8\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0002J\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u001a\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\"\u001a\u0004\u0018\u00010\fJ(\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020\u0019H\u0002J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010(\u001a\u00020\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/oui/privacy/OPrivacySheet;", "", "context", "Landroid/content/Context;", "config", "Lcom/obric/oui/privacy/OPrivacySheetConfig;", "(Landroid/content/Context;Lcom/obric/oui/privacy/OPrivacySheetConfig;)V", "listener", "Lcom/obric/oui/privacy/OPrivacySheetListener;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "sheet", "Lcom/obric/oui/sheet/v2/OSheet;", "buildBodyView", "Landroid/view/View;", "buildDescView", "Lcom/obric/oui/text/OTextView;", "buildFooterView", "buildHeaderView", "descView", "createSingleButton", "Lcom/obric/oui/button/OButton;", "text", "", "styleRes", "", "onClickListener", "Lkotlin/Function1;", "", "dismiss", "dismissImmediately", "getHeaderLayoutRemovePadding", "windowSize", "Landroid/util/Size;", "getSheet", "setHeaderPadding", "windowHeightDp", "header", "shouldRemovePadding", "setListener", InvokeHistoryActivity.PREF_SHOW, "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPrivacySheet {
    public static final Companion Companion = null;
    private static final int DEFAULT_FADE_EDGE_DP = 75;
    private static final int MAX_SMALL_WINDOW_HEIGHT = 650;
    private static final int TEXT_CONTAINER_HORIZONTAL_MARGIN = 32;
    private final OPrivacySheetConfig config;
    private final Context context;
    private OPrivacySheetListener listener;
    private RecyclerView recyclerView;
    private OSheet sheet;

    /* JADX INFO: compiled from: OPrivacySheet.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/privacy/OPrivacySheet$Companion;", "", "()V", "DEFAULT_FADE_EDGE_DP", "", "MAX_SMALL_WINDOW_HEIGHT", "TEXT_CONTAINER_HORIZONTAL_MARGIN", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.privacy.OPrivacySheet$createSingleButton$1, reason: invalid class name */
    /* JADX INFO: compiled from: OPrivacySheet.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButton;", "styledContext", "Landroid/content/Context;", "<anonymous parameter 1>", "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function3<Context, Integer, Integer, OButton> {
        final /* synthetic */ Function1<View, Unit> $onClickListener;
        final /* synthetic */ String $text;

        /* JADX INFO: renamed from: $r8$lambda$2wmdQuYgj-iuBj3fAam_S_4iXU0, reason: not valid java name */
        public static /* synthetic */ void m458$r8$lambda$2wmdQuYgjiuBj3fAam_S_4iXU0(Function1 r0, View r1) {
            m459invoke$lambda1$lambda0(r0, r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(String r1, Function1<? super View, Unit> r2) {
            this.$text = r1;
            this.$onClickListener = r2;
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ OButton invoke(Context r1, Integer r2, Integer r3) {
            return invoke(r1, r2.intValue(), r3.intValue());
        }

        public final OButton invoke(Context r9, int r10, int r11) {
            Intrinsics.checkNotNullParameter(r9, "styledContext");
            OButton r12 = new OButton(r9, null, 0, 0, null, 28, null);
            String r13 = this.$text;
            final Function1<View, Unit> r8 = this.$onClickListener;
            r12.setText(r13);
            r12.setLayoutParams(new ViewGroup.LayoutParams(-1, r11));
            if (r8 != null) goto L5;
            View.OnClickListener r14 = null;
        L6:
            r12.setOnClickListener(r14);
            return r12;
        L5:
            r14 = new OPrivacySheet$createSingleButton$1$$ExternalSyntheticLambda0(r8);
            goto L6
        }

        /* JADX INFO: renamed from: invoke$lambda-1$lambda-0, reason: not valid java name */
        private static final void m459invoke$lambda1$lambda0(Function1 r0, View r1) {
            r0.invoke(r1);
        }
    }

    public static /* synthetic */ boolean $r8$lambda$SNqyyxorUev9Kjw5AAS74ufXRus(OPrivacySheet r0, DialogInterface r1, int r2, KeyEvent r3) {
        return m457show$lambda2$lambda1(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$k3Bw9yWk_ygm646Bg5LgyOG-uks, reason: not valid java name */
    public static /* synthetic */ void m455$r8$lambda$k3Bw9yWk_ygm646Bg5LgyOGuks(OPrivacySheet r0, DialogInterface r1) {
        m456show$lambda2$lambda0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public OPrivacySheet(Context r2, OPrivacySheetConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.context = r2;
        this.config = r3;
    }

    public static final /* synthetic */ OPrivacySheetConfig access$getConfig$p(OPrivacySheet r0) {
        return r0.config;
    }

    public static final /* synthetic */ OPrivacySheetListener access$getListener$p(OPrivacySheet r0) {
        return r0.listener;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(OPrivacySheet r0) {
        return r0.recyclerView;
    }

    public static final /* synthetic */ void access$setHeaderPadding(OPrivacySheet r0, int r1, View r2, Size r3, int r4) {
        r0.setHeaderPadding(r1, r2, r3, r4);
    }

    public final OPrivacySheet setListener(OPrivacySheetListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.listener = r2;
        return this;
    }

    public final OPrivacySheet show() {
        OSheet r8 = new OSheet(this.context, 0, 0, false, false, 14, null);
        r8.setHeightMode(OSheet.HeightMode.FULL_HEIGHT);
        r8.setCanceledOnTouchOutside(false);
        r8.setCancelable(false);
        r8.setSheetBgColor(ContextCompat.getColor(r8.getContext(), R.color.oui_bg_base_2));
        OTextView r0 = buildDescView();
        final View r1 = buildHeaderView(r0);
        Size r2 = OWindowConfigController.getFullWindowSize(r1.getContext());
        Context r3 = r8.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        int r4 = OUnitExtensionKt.px2dp(r3, r2.getHeight());
        final int r5 = getHeaderLayoutRemovePadding(r2, r0);
        setHeaderPadding(r4, r1, r2, r5);
        r8.setHeaderView(r1);
        r8.setBodyView(buildBodyView());
        r8.setFooterView(buildFooterView());
        r8.setClearDimFlag(!this.config.getEnableDim());
        r8.setOnDismissListener(new OPrivacySheet$$ExternalSyntheticLambda0(this));
        if (this.config.getCancelable() == false) goto L5;
        r8.setOnKeyListener(new OPrivacySheet$$ExternalSyntheticLambda1(this));
    L5:
        r8.setOnConfigurationListener(new OPrivacySheet$show$oSheet$1$3(this, r1, r5));
        this.sheet = r8;
        r8.setEnableEnterAnim(this.config.getEnableEnterAnim());
        r8.show();
        return this;
    }

    /* JADX INFO: renamed from: show$lambda-2$lambda-0, reason: not valid java name */
    private static final void m456show$lambda2$lambda0(OPrivacySheet r0, DialogInterface r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OPrivacySheetListener r2 = r0.listener;
        if (r2 == null) goto L7;
        r2.onDismiss();
        return;
    }

    /* JADX INFO: renamed from: show$lambda-2$lambda-1, reason: not valid java name */
    private static final boolean m457show$lambda2$lambda1(OPrivacySheet r1, DialogInterface r2, int r3, KeyEvent r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r3 == 4) goto L5;
    L16:
        return false;
    L5:
        if (r4 != null) goto L8;
    L6:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L16;
        OPrivacySheetListener r6 = r1.listener;
        if (r6 == null) goto L15;
        r6.onBackPressed();
    L15:
        return true;
    L8:
        if (r4.getAction() != 1) goto L6;
        r5 = true;
        goto L10
    }

    private final void setHeaderPadding(int r2, View r3, Size r4, int r5) {
        if (r2 <= MAX_SMALL_WINDOW_HEIGHT) goto L5;
        r3.setPadding(0, (int) (r4.getHeight() * 0.135f), 0, (int) ((r4.getHeight() * 0.10375f) - r5));
        return;
    L5:
        r3.setPadding(0, OUnitExtensionKt.vdp(r3, 20), 0, OUnitExtensionKt.vdp(r3, 12));
    }

    public final void dismiss() {
        OSheet r0 = this.sheet;     // Catch: Exception -> L7
        if (r0 == null) goto L10;
        r0.dismiss();     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public final void dismissImmediately() {
        OSheet r0 = this.sheet;     // Catch: Exception -> L7
        if (r0 == null) goto L10;
        r0.dismissImmediately();     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public final OSheet getSheet() {
        return this.sheet;
    }

    private final View buildHeaderView(OTextView r14) {
        LinearLayout r0 = new LinearLayout(this.context);
        r0.setOrientation(1);
        r0.setGravity(1);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        OImageAppIcon r2 = new OImageAppIcon(this.context, null, 0, 6, null);
        int r5 = r2.getContext().getResources().getDimensionPixelSize(R.dimen.oui_image_size_xl);
        r2.setLayoutParams(new LinearLayout.LayoutParams(r5, r5));
        String r6 = this.config.getAppIconPackageName();
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L11;
        r2.setImagePackageName(this.config.getAppIconPackageName());
    L11:
        r0.addView(r2);
        LinearLayout r3 = new LinearLayout(this.context);
        r3.setOrientation(1);
        r3.setGravity(1);
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-1, -2);
        Context r4 = r3.getContext();
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        r8.leftMargin = OUnitExtensionKt.cdp(r4, 32);
        Context r9 = r3.getContext();
        Intrinsics.checkNotNullExpressionValue(r9, "context");
        r8.rightMargin = OUnitExtensionKt.cdp(r9, 32);
        Context r10 = r3.getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        r8.topMargin = OUnitExtensionKt.cdp(r10, 20);
        r3.setLayoutParams(r8);
        OTextView r11 = new OTextView(new ContextThemeWrapper(this.context, R.style.Title_4_Bold), null, 0, null, 14, null);
        r11.setIncludeFontPadding(true);
        r11.setTextColor(ContextCompat.getColor(r11.getContext(), R.color.oui_basic_text_1));
        r11.setText(this.config.getAppName());
        r11.setGravity(17);
        r11.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r3.addView(r11);
        if (r14 == null) goto L14;
        r3.addView(r14);
    L14:
        r0.addView(r3);
        return r0;
    L5:
        if (StringsKt.isBlank(r6) == true) goto L8;
        r7 = false;
        goto L9
    }

    private final OTextView buildDescView() {
        String r0 = this.config.getAppDescription();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L15;
        OTextView r2 = new OTextView(new ContextThemeWrapper(this.context, R.style.Body_1_Regular), null, 0, null, 14, null);
        r2.setIncludeFontPadding(true);
        r2.setTextColor(ContextCompat.getColor(r2.getContext(), R.color.oui_basic_text_3));
        r2.setText(this.config.getAppDescription());
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.ENGLISH.getLanguage()) == false) goto L13;
        int r9 = 17;
    L14:
        r2.setGravity(r9);
        r2.setMaxLines(3);
        r2.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        Context r3 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        r10.topMargin = OUnitExtensionKt.cdp(r3, 8);
        r2.setLayoutParams(r10);
        return r2;
    L13:
        r9 = GravityCompat.START;
        goto L14
    L15:
        return null;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final int getHeaderLayoutRemovePadding(Size r3, OTextView r4) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        r4.measure(View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(r3.getWidth() - (OUnitExtensionKt.cdp(this.context, 32) * 2), 0), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return (RangesKt.coerceAtLeast(r4.getLineCount(), 1) - 1) * r4.getLineHeight();
    }

    private final View buildBodyView() {
        int r0 = OUnitExtensionKt.px2dp(this.context, OWindowConfigController.getFullWindowSize(this.context).getHeight());
        FrameLayout r1 = new FrameLayout(this.context);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -1);
        Context r4 = r1.getContext();
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        r2.bottomMargin = OUnitExtensionKt.cdp(r4, 8);
        r1.setLayoutParams(r2);
        final PrivacyTopDownAlphaMaskRecyclerView r3 = new PrivacyTopDownAlphaMaskRecyclerView(this.context, null, 0, 6, null);
        r3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r0 <= MAX_SMALL_WINDOW_HEIGHT) goto L5;
        Context r5 = r3.getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        int r6 = OUnitExtensionKt.cdp(r5, 16);
        Context r7 = r3.getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        r3.setPadding(0, r6, 0, OUnitExtensionKt.cdp(r7, 16));
    L6:
        Context r8 = r3.getContext();
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        r3.setFadeEdgeLength(OUnitExtensionKt.cdpFloat(r8, 75));
        r3.setFadeTop(true);
        r3.setFadeBottom(true);
        r3.setDynamicFade(true);
        r3.setBackgroundColor(0);
        r3.setClipToPadding(false);
        r3.setLayoutManager(new LinearLayoutManager(r3.getContext()));
        r3.setAdapter(new PrivacySheetAdapter(this.config.getItems()));
        r3.addItemDecoration(new OPrivacySheet$buildBodyView$2$1(this, r3));
        PrivacyTopDownAlphaMaskRecyclerView r9 = r3;
        this.recyclerView = r9;
        r1.addView(r9);
        return r1;
    L5:
        r3.setPadding(0, 0, 0, 0);
        goto L6
    }

    private final View buildFooterView() {
        LinearLayout r1 = new LinearLayout(this.context);
        r1.setOrientation(1);
        r1.setGravity(1);
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Context r3 = r1.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        int r4 = OUnitExtensionKt.cdp(r3, 20);
        Context r8 = r1.getContext();
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        int r9 = OUnitExtensionKt.cdp(r8, 16);
        Context r10 = r1.getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        int r7 = OUnitExtensionKt.cdp(r10, 20);
        Context r11 = r1.getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        r1.setPadding(r4, r9, r7, OUnitExtensionKt.cdp(r11, 8));
        if (this.config.getPrivacyPolicyText() == null) goto L17;
        final OTextView r5 = new OTextView(new ContextThemeWrapper(this.context, R.style.Button_1_Regular), null, 0, null, 14, null);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r5.setTextColor(ContextCompat.getColor(r5.getContext(), R.color.oui_basic_text_1));
        r5.setGravity(GravityCompat.START);
        String r12 = this.config.getPrivacyPolicyText();
        List<String> r13 = this.config.getPrivacyPolicyLinkTexts();
        if ((!r13.isEmpty()) == false) goto L15;
        String r14 = r12;
        SpannableString r15 = new SpannableString(r14);
        Iterator<String> r16 = r13.iterator();
    L8:
        if (r16.hasNext() == false) goto L14;
        String r17 = r16.next();
        int r18 = 0;
    L10:
        final String r19 = r17;
        int r110 = StringsKt.indexOf$default(r14, r17, r18, false, 4, null);
        if (r110 < 0) goto L8;
        r18 = r110 + r19.length();
        r15.setSpan(new OPrivacySheet$buildFooterView$policyTextView$1$1(this, r19, r5), r110, r18, 33);
        r17 = r19;
        goto L10
    L14:
        r5.setText(r15);
        r5.setMovementMethod(LinkMovementMethod.getInstance());
        r5.setHighlightColor(0);
    L16:
        r1.addView(r5);
        goto L17
    L15:
        r5.setText(r12);
    L17:
        LinearLayout r6 = new LinearLayout(this.context);
        r6.setOrientation(1);
        r6.setGravity(1);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-1, -2);
        Context r20 = r6.getContext();
        Intrinsics.checkNotNullExpressionValue(r20, "context");
        r2.topMargin = OUnitExtensionKt.cdp(r20, 14);
        r6.setLayoutParams(r2);
        Context r21 = r6.getContext();
        Intrinsics.checkNotNullExpressionValue(r21, "context");
        int r22 = OUnitExtensionKt.cdp(r21, 4);
        Context r23 = r6.getContext();
        Intrinsics.checkNotNullExpressionValue(r23, "context");
        r6.setPadding(r22, 0, OUnitExtensionKt.cdp(r23, 4), 0);
        Context r24 = this.context;
        String r25 = this.config.getAgreeButtonText();
        if (r25 != null) goto L20;
        r25 = this.context.getString(R.string.oui_agree);
        Intrinsics.checkNotNullExpressionValue(r25, "context.getString(R.string.oui_agree)");
    L20:
        r6.addView(createSingleButton(r24, r25, R.style.OStyleV2_OButton_L_Standard_Primary, new OPrivacySheet$buildFooterView$agreeButton$1(this)));
        Context r26 = this.context;
        String r27 = this.config.getExitButtonText();
        if (r27 != null) goto L23;
        r27 = this.context.getString(R.string.oui_exit);
        Intrinsics.checkNotNullExpressionValue(r27, "context.getString(R.string.oui_exit)");
    L23:
        OButton r0 = createSingleButton(r26, r27, R.style.OStyleV2_OButton_L_Trans_Neutral, new OPrivacySheet$buildFooterView$exitButton$1(this));
        LinearLayout.LayoutParams r28 = new LinearLayout.LayoutParams(-1, -2);
        Context r29 = r0.getContext();
        Intrinsics.checkNotNullExpressionValue(r29, "context");
        r28.topMargin = OUnitExtensionKt.cdp(r29, 12);
        r0.setLayoutParams(r28);
        r6.addView(r0);
        r1.addView(r6);
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ OButton createSingleButton$default(OPrivacySheet r0, Context r1, String r2, int r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.createSingleButton(r1, r2, r3, r4);
    }

    private final OButton createSingleButton(Context r1, String r2, int r3, Function1<? super View, Unit> r4) {
        return (OButton) StyleUtil.createWidgetWithStyle(r1, r3, new AnonymousClass1(r2, r4));
    }
}
