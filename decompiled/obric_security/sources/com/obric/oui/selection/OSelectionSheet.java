package com.obric.oui.selection;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSelectionSheet.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016JD\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0016¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet;", "Lcom/obric/oui/sheet/OInsetSheet;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/selection/OSelectionSheet$Companion$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/selection/OSelectionSheet$Companion$Modifier;)V", "dismiss", "", "genHeaderView", "Landroid/view/View;", "title", "", "titleBarControlType", "Lcom/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType;", "onClose", "Lkotlin/Function0;", "onConfirm", InvokeHistoryActivity.PREF_SHOW, "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionSheet extends OInsetSheet {
    public static final Companion Companion = null;
    private static final String TAG = "OSelectionSheet";

    /* JADX INFO: compiled from: OSelectionSheet.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet$Companion;", "", "()V", "TAG", "", "ItemStyle", "Modifier", "SelectionType", "TitleBarControlType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: OSelectionSheet.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet$Companion$ItemStyle;", "", "(Ljava/lang/String;I)V", "TEXT_ONLY", "ICON_AND_TEXT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum ItemStyle extends Enum<ItemStyle> {
            private static final /* synthetic */ ItemStyle[] $VALUES = null;
            public static final ItemStyle ICON_AND_TEXT = null;
            public static final ItemStyle TEXT_ONLY = null;

            private static final /* synthetic */ ItemStyle[] $values() {
                return new ItemStyle[]{TEXT_ONLY, ICON_AND_TEXT};
            }

            public static ItemStyle valueOf(String r1) {
                return (ItemStyle) Enum.valueOf(ItemStyle.class, r1);
            }

            public static ItemStyle[] values() {
                return (ItemStyle[]) $VALUES.clone();
            }

            private ItemStyle(String r1, int r2) {
                super(r1, r2);
            }

            static {
                TEXT_ONLY = new ItemStyle("TEXT_ONLY", 0);
                ICON_AND_TEXT = new ItemStyle("ICON_AND_TEXT", 1);
                $VALUES = $values();
            }
        }

        /* JADX INFO: compiled from: OSelectionSheet.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\fR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet$Companion$Modifier;", "", MaterialConfigFormatNames.WIDTH, "Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "title", "", "titleBarControlType", "Lcom/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType;", "onClose", "Lkotlin/Function0;", "", "onConfirm", "(Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;Ljava/lang/String;Lcom/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClose", "()Lkotlin/jvm/functions/Function0;", "getOnConfirm", "getTitle", "()Ljava/lang/String;", "getTitleBarControlType", "()Lcom/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType;", "getWidth", "()Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Modifier {
            private final Function0<Unit> onClose;
            private final Function0<Unit> onConfirm;
            private final String title;
            private final TitleBarControlType titleBarControlType;
            private final OInsetSheet.PanelWidth width;

            public Modifier(OInsetSheet.PanelWidth r2, String r3, TitleBarControlType r4, Function0<Unit> r5, Function0<Unit> r6) {
                Intrinsics.checkNotNullParameter(r2, MaterialConfigFormatNames.WIDTH);
                Intrinsics.checkNotNullParameter(r3, "title");
                Intrinsics.checkNotNullParameter(r4, "titleBarControlType");
                this.width = r2;
                this.title = r3;
                this.titleBarControlType = r4;
                this.onClose = r5;
                this.onConfirm = r6;
            }

            public final OInsetSheet.PanelWidth getWidth() {
                return this.width;
            }

            public final String getTitle() {
                return this.title;
            }

            public final TitleBarControlType getTitleBarControlType() {
                return this.titleBarControlType;
            }

            public final Function0<Unit> getOnClose() {
                return this.onClose;
            }

            public final Function0<Unit> getOnConfirm() {
                return this.onConfirm;
            }
        }

        /* JADX INFO: compiled from: OSelectionSheet.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet$Companion$SelectionType;", "", "(Ljava/lang/String;I)V", "SINGLE", "MULTI", "NONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum SelectionType extends Enum<SelectionType> {
            private static final /* synthetic */ SelectionType[] $VALUES = null;
            public static final SelectionType MULTI = null;
            public static final SelectionType NONE = null;
            public static final SelectionType SINGLE = null;

            private static final /* synthetic */ SelectionType[] $values() {
                return new SelectionType[]{SINGLE, MULTI, NONE};
            }

            public static SelectionType valueOf(String r1) {
                return (SelectionType) Enum.valueOf(SelectionType.class, r1);
            }

            public static SelectionType[] values() {
                return (SelectionType[]) $VALUES.clone();
            }

            private SelectionType(String r1, int r2) {
                super(r1, r2);
            }

            static {
                SINGLE = new SelectionType("SINGLE", 0);
                MULTI = new SelectionType("MULTI", 1);
                NONE = new SelectionType("NONE", 2);
                $VALUES = $values();
            }
        }

        /* JADX INFO: compiled from: OSelectionSheet.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheet$Companion$TitleBarControlType;", "", "(Ljava/lang/String;I)V", "CLOSE_ONLY", "CLOSE_AND_CONFIRM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum TitleBarControlType extends Enum<TitleBarControlType> {
            private static final /* synthetic */ TitleBarControlType[] $VALUES = null;
            public static final TitleBarControlType CLOSE_AND_CONFIRM = null;
            public static final TitleBarControlType CLOSE_ONLY = null;

            private static final /* synthetic */ TitleBarControlType[] $values() {
                return new TitleBarControlType[]{CLOSE_ONLY, CLOSE_AND_CONFIRM};
            }

            public static TitleBarControlType valueOf(String r1) {
                return (TitleBarControlType) Enum.valueOf(TitleBarControlType.class, r1);
            }

            public static TitleBarControlType[] values() {
                return (TitleBarControlType[]) $VALUES.clone();
            }

            private TitleBarControlType(String r1, int r2) {
                super(r1, r2);
            }

            static {
                CLOSE_ONLY = new TitleBarControlType("CLOSE_ONLY", 0);
                CLOSE_AND_CONFIRM = new TitleBarControlType("CLOSE_AND_CONFIRM", 1);
                $VALUES = $values();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OSelectionSheet.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Companion.TitleBarControlType.values().length];
            r0[Companion.TitleBarControlType.CLOSE_AND_CONFIRM.ordinal()] = 1;
            r0[Companion.TitleBarControlType.CLOSE_ONLY.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$C_uKxvBHuKXq5TuoNBBCDiHf9D4(Function0 r0, View r1) {
        m514genHeaderView$lambda3$lambda1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ilgb8mtrps1JrDvBktuORu2GFGM(Function0 r0, View r1) {
        m516genHeaderView$lambda5$lambda4(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$o4EdQL1X-gtz5teagfL-38EIwSI, reason: not valid java name */
    public static /* synthetic */ void m513$r8$lambda$o4EdQL1Xgtz5teagfL38EIwSI(Function0 r0, View r1) {
        m515genHeaderView$lambda3$lambda2(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public OSelectionSheet(Context r8, Companion.Modifier r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "modifier");
        super(r8);
        setRootWidth(r9.getWidth());
        setHeaderView(genHeaderView(r8, r9.getTitle(), r9.getTitleBarControlType(), r9.getOnClose(), r9.getOnConfirm()));
        setClearDimFlag(false);
        getContentContainer().setPadding(OUnitExtensionKt.cdp(r8, 6), 0, OUnitExtensionKt.cdp(r8, 6), OUnitExtensionKt.cdp(r8, 6));
        getFooterContainer().setVisibility(8);
    }

    @Override // com.obric.oui.sheet.OInsetSheet, android.app.Dialog
    public void show() {
        super.show();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "show failed", e);
    }

    @Override // com.obric.oui.sheet.OInsetSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "dismiss failed", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ View genHeaderView$default(OSelectionSheet r7, Context r8, String r9, Companion.TitleBarControlType r10, Function0 r11, Function0 r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L5;
        Function0 r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        Function0 r6 = null;
    L11:
        return r7.genHeaderView(r8, r9, r10, r5, r6);
    L9:
        r6 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    private final View genHeaderView(Context r8, String r9, Companion.TitleBarControlType r10, final Function0<Unit> r11, final Function0<Unit> r12) {
        int r7 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r7 != 1) goto L5;
        OInsetSheetTitleBar r13 = new OInsetSheetTitleBar(r8, null, 0, 6, null);
        r13.setTitleText(r9);
        r13.setShowLeftBack(false);
        OButton r14 = r13.createNeutralButton(r8, r13.getMLeftContainer());
        r14.setButtonSourceBitmap(R.drawable.o_ic_close);
        r14.setOnClickListener(new OSelectionSheet$$ExternalSyntheticLambda0(r11));
        OButton r15 = r13.createPrimaryLightButton(r8, r13.getMRightContainer());
        r15.setButtonSourceBitmap(R.drawable.o_ic_confirm, r8.getColor(R.color.oui_accent_7_fg));
        r15.setOnClickListener(new OSelectionSheet$$ExternalSyntheticLambda1(r12));
        return r13;
    L5:
        if (r7 != 2) goto L8;
        OInsetSheetTitleBar r16 = new OInsetSheetTitleBar(r8, null, 0, 6, null);
        r16.setTitleText(r9);
        r16.setShowLeftBack(false);
        OButton r17 = r16.createUnderstatedButton(r8, r16.getMRightContainer());
        r17.setButtonSourceBitmap(R.drawable.o_ic_xmark_fill, r8.getColor(R.color.oui_basic_text_4));
        r17.setOnClickListener(new OSelectionSheet$$ExternalSyntheticLambda2(r11));
        return r16;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: genHeaderView$lambda-3$lambda-1, reason: not valid java name */
    private static final void m514genHeaderView$lambda3$lambda1(Function0 r0, View r1) {
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    /* JADX INFO: renamed from: genHeaderView$lambda-3$lambda-2, reason: not valid java name */
    private static final void m515genHeaderView$lambda3$lambda2(Function0 r0, View r1) {
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    /* JADX INFO: renamed from: genHeaderView$lambda-5$lambda-4, reason: not valid java name */
    private static final void m516genHeaderView$lambda5$lambda4(Function0 r0, View r1) {
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }
}
