package com.obric.oui.selection;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OActionSheet.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J4\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/selection/OActionSheet;", "Lcom/obric/oui/sheet/OInsetSheet;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/selection/OActionSheet$Companion$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/selection/OActionSheet$Companion$Modifier;)V", "dismiss", "", "genHeaderView", "Landroid/view/View;", "title", "", "des", "onClose", "Lkotlin/Function0;", "show", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OActionSheet extends OInsetSheet {
    public static final Companion Companion = null;
    private static final String TAG = "OSelectionSheet";

    /* JADX INFO: compiled from: OActionSheet.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/selection/OActionSheet$Companion;", "", "()V", "TAG", "", "ItemStyle", "Modifier", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: OActionSheet.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/selection/OActionSheet$Companion$ItemStyle;", "", "(Ljava/lang/String;I)V", "LIST_BUTTON", "LIST_TEXT_ONLY", "LIST_ICON_AND_TEXT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum ItemStyle extends Enum<ItemStyle> {
            private static final /* synthetic */ ItemStyle[] $VALUES = null;
            public static final ItemStyle LIST_BUTTON = null;
            public static final ItemStyle LIST_ICON_AND_TEXT = null;
            public static final ItemStyle LIST_TEXT_ONLY = null;

            private static final /* synthetic */ ItemStyle[] $values() {
                return new ItemStyle[]{LIST_BUTTON, LIST_TEXT_ONLY, LIST_ICON_AND_TEXT};
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
                LIST_BUTTON = new ItemStyle("LIST_BUTTON", 0);
                LIST_TEXT_ONLY = new ItemStyle("LIST_TEXT_ONLY", 1);
                LIST_ICON_AND_TEXT = new ItemStyle("LIST_ICON_AND_TEXT", 2);
                $VALUES = $values();
            }
        }

        /* JADX INFO: compiled from: OActionSheet.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/selection/OActionSheet$Companion$Modifier;", "", MaterialConfigFormatNames.WIDTH, "Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "title", "", "des", "onClose", "Lkotlin/Function0;", "", "(Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getDes", "()Ljava/lang/String;", "getOnClose", "()Lkotlin/jvm/functions/Function0;", "getTitle", "getWidth", "()Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Modifier {
            private final String des;
            private final Function0<Unit> onClose;
            private final String title;
            private final OInsetSheet.PanelWidth width;

            public Modifier(OInsetSheet.PanelWidth r2, String r3, String r4, Function0<Unit> r5) {
                Intrinsics.checkNotNullParameter(r2, MaterialConfigFormatNames.WIDTH);
                Intrinsics.checkNotNullParameter(r3, "title");
                this.width = r2;
                this.title = r3;
                this.des = r4;
                this.onClose = r5;
            }

            public /* synthetic */ Modifier(OInsetSheet.PanelWidth r1, String r2, String r3, Function0 r4, int r5, DefaultConstructorMarker r6) {
                if ((r5 & 4) == 0) goto L5;
                r3 = null;
            L5:
                this(r1, r2, r3, r4);
            }

            public final OInsetSheet.PanelWidth getWidth() {
                return this.width;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getDes() {
                return this.des;
            }

            public final Function0<Unit> getOnClose() {
                return this.onClose;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$TkxllKPqZYPpHqqoNjHrEDuOZNI(Function0 r0, View r1) {
        m1371genHeaderView$lambda2$lambda1(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public OActionSheet(Context r5, Companion.Modifier r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "modifier");
        super(r5);
        setRootWidth(r6.getWidth());
        setHeaderView(genHeaderView(r5, r6.getTitle(), r6.getDes(), r6.getOnClose()));
        setClearDimFlag(false);
        getContentContainer().setPadding(OUnitExtensionKt.cdp(r5, 16), OUnitExtensionKt.cdp(r5, 4), OUnitExtensionKt.cdp(r5, 16), OUnitExtensionKt.cdp(r5, 16));
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
    static /* synthetic */ View genHeaderView$default(OActionSheet r0, Context r1, String r2, String r3, Function0 r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.genHeaderView(r1, r2, r3, r4);
    }

    private final View genHeaderView(Context r8, String r9, String r10, final Function0<Unit> r11) {
        LinearLayout r7 = new LinearLayout(r8);
        r7.setOrientation(1);
        r7.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(r8, null, 0, 6, null);
        r0.setTitleText(r9);
        r0.setShowLeftBack(false);
        OButton r12 = r0.createUnderstatedButton(r8, r0.getMRightContainer());
        r12.setButtonSourceBitmap(R.drawable.o_ic_xmark_fill, r8.getColor(R.color.oui_basic_text_4));
        r12.setOnClickListener(new OActionSheet$$ExternalSyntheticLambda0(r11));
        r7.addView(r0);
        r0.setDesText(r10);
        return r7;
    }

    /* JADX INFO: renamed from: genHeaderView$lambda-2$lambda-1, reason: not valid java name */
    private static final void m1371genHeaderView$lambda2$lambda1(Function0 r0, View r1) {
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }
}
