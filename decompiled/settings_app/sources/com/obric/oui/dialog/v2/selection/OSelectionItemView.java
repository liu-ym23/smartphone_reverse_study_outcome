package com.obric.oui.dialog.v2.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.android.settingslib.drawer.EntriesProvider;
import com.obric.common.oui.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.v2.common.ODialogListItemView;
import com.obric.oui.utils.KtExt;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSelectionItemView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\f¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionItemView;", "Lcom/obric/oui/dialog/v2/common/ODialogListItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getCheckMark", "Landroid/view/View;", EntriesProvider.METHOD_IS_CHECKED, "", "setCheckStyle", "", "style", "Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion$CheckStyle;", "setChecked", "checked", "toggleCheckState", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionItemView extends ODialogListItemView {
    public static final Companion Companion = null;
    private static final String TAG = "OSelectionItemView";

    /* JADX INFO: compiled from: OSelectionItemView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion;", "", "()V", "TAG", "", "CheckStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: OSelectionItemView.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion$CheckStyle;", "", "(Ljava/lang/String;I)V", "NONE", "ICON", "CHECKBOX", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum CheckStyle extends Enum<CheckStyle> {
            private static final /* synthetic */ CheckStyle[] $VALUES = null;
            public static final CheckStyle CHECKBOX = null;
            public static final CheckStyle ICON = null;
            public static final CheckStyle NONE = null;

            private static final /* synthetic */ CheckStyle[] $values() {
                return new CheckStyle[]{NONE, ICON, CHECKBOX};
            }

            public static CheckStyle valueOf(String r1) {
                return (CheckStyle) Enum.valueOf(CheckStyle.class, r1);
            }

            public static CheckStyle[] values() {
                return (CheckStyle[]) $VALUES.clone();
            }

            private CheckStyle(String r1, int r2) {
                super(r1, r2);
            }

            static {
                NONE = new CheckStyle("NONE", 0);
                ICON = new CheckStyle("ICON", 1);
                CHECKBOX = new CheckStyle("CHECKBOX", 2);
                $VALUES = $values();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OSelectionItemView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Companion.CheckStyle.values().length];
            r0[Companion.CheckStyle.ICON.ordinal()] = 1;
            r0[Companion.CheckStyle.CHECKBOX.ordinal()] = 2;
            r0[Companion.CheckStyle.NONE.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ OSelectionItemView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OSelectionItemView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        setCheckStyle(Companion.CheckStyle.NONE);
        showDivider(true);
    }

    public final void setCheckStyle(Companion.CheckStyle r5) {
        Intrinsics.checkNotNullParameter(r5, "style");
        int r6 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        OCheckBox r1 = null;
        if (r6 != 1) goto L5;
        ImageView r7 = new ImageView(getContext());
        r7.setImageDrawable(ResourcesCompat.getDrawable(r7.getContext().getResources(), R.drawable.oui_select_list_item_checker, null));
        r1 = r7;
    L13:
        if (r1 == null) goto L15;
        FrameLayout r8 = new FrameLayout(getContext());
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 17;
        r8.addView(r1, r0);
        setTrailingView(r8, new ViewGroup.LayoutParams(OUnitExtensionKt.vdp(this, 32), -2));
        return;
    L15:
        getTrailingContainer().setVisibility(8);
        return;
    L5:
        if (r6 != 2) goto L7;
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        r1 = new OCheckBox(r2);
        goto L13
    L7:
        if (r6 == 3) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    public final void setChecked(boolean r2) {
        View r1 = getCheckMark();
        if ((r1 instanceof OCheckBox) == false) goto L6;
        ((OCheckBox) r1).setChecked(r2);
        return;
    L6:
        if ((r1 instanceof ImageView) == false) goto L12;
        ImageView r3 = (ImageView) r1;
        if (r2 == false) goto L10;
        int r4 = 0;
    L11:
        r3.setVisibility(r4);
        return;
    L10:
        r4 = 4;
        goto L11
    L12:
        L.d(TAG, "checkMark is not OCheckBox or ImageView");
    }

    public final void toggleCheckState() {
        setChecked(!isChecked());
    }

    public final boolean isChecked() {
        View r2 = getCheckMark();
        if ((r2 instanceof OCheckBox) == false) goto L6;
        return ((OCheckBox) r2).isChecked();
    L6:
        if ((r2 instanceof ImageView) == false) goto L11;
        if (((ImageView) r2).getVisibility() != 0) goto L11;
        return true;
    L11:
        return false;
    }

    private final View getCheckMark() {
        KtExt r0 = KtExt.INSTANCE;
        View r3 = getTrailingContainer().getChildAt(0);
        if (r3 != null) goto L6;
    L4:
        r3 = null;
    L7:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 != null) goto L11;
        return null;
    L11:
        return r4.getChildAt(0);
    L6:
        if ((r3 instanceof ViewGroup) == false) goto L4;
        goto L4
    }
}
