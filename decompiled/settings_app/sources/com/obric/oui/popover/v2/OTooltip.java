package com.obric.oui.popover.v2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.slice.core.SliceHints;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: OTooltip.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/popover/v2/OTooltip;", "", "()V", "DEFAULT_AUTO_DISMISS_MILLIS", "", "DEFAULT_MARGIN_DP", "", "DEFAULT_MAX_WIDTH_DP", "DEFAULT_MIN_HEIGHT_DP", "DEFAULT_PADDING_HORIZONTAL_DP", "DEFAULT_PADDING_VERTICAL_DP", "", "TAG", "", "show", "Lcom/obric/oui/popover/v2/OPopover;", "activity", "Landroid/app/Activity;", "anchor", "Landroid/view/View;", "text", "autoDismissMillis", "Builder", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTooltip {
    private static final long DEFAULT_AUTO_DISMISS_MILLIS = 2000;
    private static final int DEFAULT_MARGIN_DP = 8;
    private static final int DEFAULT_MAX_WIDTH_DP = 240;
    private static final int DEFAULT_MIN_HEIGHT_DP = 48;
    private static final int DEFAULT_PADDING_HORIZONTAL_DP = 16;
    private static final double DEFAULT_PADDING_VERTICAL_DP = 10.5d;
    public static final OTooltip INSTANCE = null;
    private static final String TAG = "OTooltip";

    /* JADX INFO: compiled from: OTooltip.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0006J\u0010\u0010\"\u001a\u00020\u00002\b\b\u0001\u0010#\u001a\u00020\bJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\bJ\u0014\u0010&\u001a\u00020\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010(\u001a\u00020\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0012J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010/\u001a\u00020\u00002\b\b\u0001\u0010#\u001a\u00020\bJ\u000e\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u0019J\f\u00102\u001a\u00020\r*\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/oui/popover/v2/OTooltip$Builder;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "autoDismissMillis", "", "bgColor", "", "gravity", "margin", "onDismiss", "Lkotlin/Function0;", "", "onShow", "popFocusable", "", "shortcutKeyboardText", "", "shortcutName", "subText", "", "text", "textColor", "createContentView", "Landroid/view/View;", "createPopover", "Lcom/obric/oui/popover/v2/OPopover;", "contentView", "createShortcutView", "createTextView", "Landroid/widget/TextView;", "setAutoDismissMillis", SliceHints.SUBTYPE_MILLIS, "setBgColor", "color", "setGravity", "setMargin", "setOnDismissListener", "listener", "setOnShowListener", "setPopFocusable", "setShortcut", "name", "keyboardText", "setSubText", "setText", "setTextColor", "show", "anchor", "applyTooltipTextStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private final Activity activity;
        private long autoDismissMillis;
        private int bgColor;
        private int gravity;
        private int margin;
        private Function0<Unit> onDismiss;
        private Function0<Unit> onShow;
        private boolean popFocusable;
        private CharSequence shortcutKeyboardText;
        private CharSequence shortcutName;
        private String subText;
        private String text;
        private int textColor;

        /* JADX INFO: renamed from: $r8$lambda$Cj5d-O0-R6CakkrHSMJL9yY3bhI, reason: not valid java name */
        public static /* synthetic */ void m1313$r8$lambda$Cj5dO0R6CakkrHSMJL9yY3bhI(Ref.ObjectRef r0) {
            m1314createPopover$lambda13(r0);
        }

        public Builder(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            this.activity = r3;
            this.text = "";
            this.subText = "";
            this.shortcutName = "";
            this.shortcutKeyboardText = "";
            this.gravity = 80;
            this.margin = OUnitExtensionKt.cdp(r3, 8);
            this.autoDismissMillis = OTooltip.DEFAULT_AUTO_DISMISS_MILLIS;
            this.popFocusable = true;
        }

        public static final /* synthetic */ long access$getAutoDismissMillis$p(Builder r2) {
            return r2.autoDismissMillis;
        }

        public static final /* synthetic */ Function0 access$getOnDismiss$p(Builder r0) {
            return r0.onDismiss;
        }

        public static final /* synthetic */ Function0 access$getOnShow$p(Builder r0) {
            return r0.onShow;
        }

        public final Builder setText(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.text = r2;
            return this;
        }

        public final Builder setSubText(String r2) {
            Intrinsics.checkNotNullParameter(r2, "subText");
            this.subText = r2;
            return this;
        }

        public final Builder setShortcut(CharSequence r2, CharSequence r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "keyboardText");
            this.shortcutName = r2;
            this.shortcutKeyboardText = r3;
            return this;
        }

        public final Builder setGravity(int r2) {
            this.gravity = r2;
            return this;
        }

        public final Builder setMargin(int r2) {
            this.margin = r2;
            return this;
        }

        public final Builder setAutoDismissMillis(long r2) {
            this.autoDismissMillis = r2;
            return this;
        }

        public final Builder setPopFocusable(boolean r2) {
            this.popFocusable = r2;
            return this;
        }

        public final Builder setTextColor(int r2) {
            this.textColor = r2;
            return this;
        }

        public final Builder setBgColor(int r2) {
            this.bgColor = r2;
            return this;
        }

        public final Builder setOnDismissListener(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.onDismiss = r2;
            return this;
        }

        public final Builder setOnShowListener(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.onShow = r2;
            return this;
        }

        public final OPopover show(View r13) {
            Intrinsics.checkNotNullParameter(r13, "anchor");
            OPopover r0 = createPopover(createContentView());
            OPopoverHelperEx.showPopoverSmartly$default(OPopoverHelperEx.INSTANCE, r0, r13, this.gravity, false, this.margin, this.popFocusable, 0, 0, 192, null);
            return r0;
        }

        private final View createContentView() {
            boolean r1 = true;
            if (this.shortcutName.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L15;
            if (this.shortcutKeyboardText.length() > 0) goto L11;
            r1 = false;
        L11:
            if (r1 == true) goto L15;
            return createTextView();
        L15:
            return createShortcutView();
        L5:
            r0 = false;
            goto L6
        }

        private final TextView createTextView() {
            TextView r0 = new TextView(this.activity);
            if (this.subText.length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            String r2 = this.text;
        L9:
            r0.setText(r2);
            applyTooltipTextStyle(r0);
            TextView r6 = r0;
            r0.setMaxWidth(OUnitExtensionKt.vdp(r6, 240));
            r0.setMinHeight(OUnitExtensionKt.vdp(r6, 48));
            r0.setGravity(8388627);
            r0.setPadding(OUnitExtensionKt.vdp(r6, 16), OUnitExtensionKt.vdp(r6, OTooltip.DEFAULT_PADDING_VERTICAL_DP), OUnitExtensionKt.vdp(r6, 16), OUnitExtensionKt.vdp(r6, OTooltip.DEFAULT_PADDING_VERTICAL_DP));
            r0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            return r0;
        L8:
            r2 = this.text + '\n' + this.subText;
            goto L9
        L5:
            r1 = false;
            goto L6
        }

        private final View createShortcutView() {
            View r0 = View.inflate(this.activity, R.layout.o_tooltip_shortcut, null);
            ((TextView) r0.findViewById(R.id.o_tooltip_shortcut_name)).setText(this.shortcutName);
            ((TextView) r0.findViewById(R.id.o_tooltip_shortcut_keyboard_text)).setText(this.shortcutKeyboardText);
            Intrinsics.checkNotNullExpressionValue(r0, "inflate(\n            act…cutKeyboardText\n        }");
            return r0;
        }

        private final void applyTooltipTextStyle(TextView r2) {
            TextViewCompat.setTextAppearance(r2, R.style.Subtitle_3_Regular);
            int r1 = this.textColor;
            if (r1 != 0) goto L6;
            r1 = ContextCompat.getColor(r2.getContext(), R.color.oui_toast_text);
        L6:
            r2.setTextColor(r1);
        }

        /* JADX WARN: Type inference failed for: r6v5, types: [T, java.lang.ref.WeakReference] */
        private final OPopover createPopover(View r6) {
            final Ref.ObjectRef r0 = new Ref.ObjectRef();
            OPopover.Builder r7 = new OPopover.Builder(this.activity).setView(r6).setHideVirtualKey(false);
            long r1 = this.autoDismissMillis;
            if (r1 <= 0) goto L5;
            r7.setAutoDismissDelayMillis(r1);
        L5:
            int r2 = this.bgColor;
            if (r2 == 0) goto L8;
            r7.setBgColor(r2);
        L8:
            final Runnable r3 = new OTooltip$Builder$$ExternalSyntheticLambda0(r0);
            r7.setOnDismissListener(new OTooltip$Builder$createPopover$1(r0, r3, this));
            r7.setOnShowListener(new OTooltip$Builder$createPopover$2(this, r0, r3));
            OPopover r5 = r7.build();
            r0.element = new WeakReference(r5);
            return r5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: createPopover$lambda-13, reason: not valid java name */
        private static final void m1314createPopover$lambda13(Ref.ObjectRef r1) {
            Intrinsics.checkNotNullParameter(r1, "$popoverRef");
            WeakReference r2 = (WeakReference) r1.element;
            if (r2 != null) goto L5;
            OPopover r3 = null;
        L6:
            if (r3 != null) goto L8;
            return;
        L8:
            if (r3.isShowing() == false) goto L13;
            r3.dismiss();
            return;
        L13:
            return;
        L5:
            r3 = (OPopover) r2.get();
            goto L6
        }
    }

    static {
        INSTANCE = new OTooltip();
    }

    @JvmStatic
    public static final OPopover show(Activity r8, View r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "anchor");
        Intrinsics.checkNotNullParameter(r10, "text");
        return show$default(r8, r9, r10, 0, 8, null);
    }

    private OTooltip() {
    }

    public static /* synthetic */ OPopover show$default(Activity r0, View r1, String r2, long r3, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r3 = DEFAULT_AUTO_DISMISS_MILLIS;
    L6:
        return show(r0, r1, r2, r3);
    }

    @JvmStatic
    public static final OPopover show(Activity r1, View r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r2, "anchor");
        Intrinsics.checkNotNullParameter(r3, "text");
        return new Builder(r1).setText(r3).setAutoDismissMillis(r4).show(r2);
    }
}
