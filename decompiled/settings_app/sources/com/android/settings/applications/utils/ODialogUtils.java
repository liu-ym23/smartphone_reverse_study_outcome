package com.android.settings.applications.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.oui.forms.OInputLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ODialogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013Jl\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eJ\u0010\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010#\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%J:\u0010&\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\f\u001a\u00020\u000bJB\u0010(\u001a\u00020)2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u001c2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0007¨\u0006-"}, d2 = {"Lcom/android/settings/applications/utils/ODialogUtils;", "", "()V", "genContentView", "Landroid/view/View;", "context", "Landroid/content/Context;", "selectionList", "", "", "listener", "Landroid/view/View$OnClickListener;", "itemClickListener", "genItemDataList", "", "Lcom/android/settings/applications/utils/ActionDialogItemData;", "getInputView", "Lcom/obric/oui/forms/OInputLayout;", "dialog", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog;", "getMiscDialog", "title", "subtitle", "positiveButtonText", "negativeButtonText", "hintText1", "hintText2", "showSecondInput", "", "positiveClickListener", "Lkotlin/Function0;", "", "negativeClickListener", "getPositiveBtn", "Lcom/obric/oui/button/OButton;", "initInputView", "text", "", "showActionDialog", "Lcom/obric/oui/dialog/v2/action/OActionDialog;", "showStatusDialog", "Lcom/obric/oui/dialog/v2/misc/StatusDialog;", "buttonText", "showButton", "onClick", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ODialogUtils {
    public static final ODialogUtils INSTANCE = null;

    static {
        INSTANCE = new ODialogUtils();
    }

    private ODialogUtils() {
    }

    public static final /* synthetic */ View access$genContentView(ODialogUtils r0, Context r1, List r2, List r3, View.OnClickListener r4) {
        return r0.genContentView(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OSimpleFormDialog getMiscDialog$default(ODialogUtils r13, Context r14, String r15, String r16, String r17, String r18, String r19, String r20, boolean r21, Function0 r22, Function0 r23, int r24, Object r25) {
        if ((r24 & 128) == 0) goto L5;
        boolean r10 = false;
    L7:
        if ((r24 & 256) == 0) goto L9;
        Function0 r11 = null;
    L11:
        if ((r24 & 512) == 0) goto L13;
        Function0 r12 = null;
    L15:
        return r13.getMiscDialog(r14, r15, r16, r17, r18, r19, r20, r10, r11, r12);
    L13:
        r12 = r23;
        goto L15
    L9:
        r11 = r22;
        goto L11
    L5:
        r10 = r21;
        goto L7
    }

    public final OSimpleFormDialog getMiscDialog(Context r27, String r28, String r29, String r30, String r31, final String r32, final String r33, boolean r34, Function0<Unit> r35, Function0<Unit> r36) {
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r28, "title");
        Intrinsics.checkNotNullParameter(r29, "subtitle");
        Intrinsics.checkNotNullParameter(r30, "positiveButtonText");
        Intrinsics.checkNotNullParameter(r31, "negativeButtonText");
        Intrinsics.checkNotNullParameter(r32, "hintText1");
        Intrinsics.checkNotNullParameter(r33, "hintText2");
        return new OSimpleFormDialog(r27, new OSimpleFormDialog.Modifier(r28, r29, new OSimpleFormDialog.InputViewConfig(true, false, new ODialogUtils$getMiscDialog$modifier$1(r32), 2, null), new OSimpleFormDialog.InputViewConfig(r34, false, new ODialogUtils$getMiscDialog$modifier$2(r33), 2, null), new OBaseDialog.ButtonConfig(r30, r35, null, 4, null), new OBaseDialog.ButtonConfig(r31, r36, null, 4, null)));
    }

    public final void initInputView(OSimpleFormDialog r2, CharSequence r3) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        Intrinsics.checkNotNullParameter(r3, "text");
        OInputLayout r1 = getInputView(r2);
        if (r1 == null) goto L6;
        r1.setText(r3);
        return;
    }

    public final OInputLayout getInputView(OSimpleFormDialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        FrameLayout r1 = (FrameLayout) r2.findViewById(R.id.simple_form_input_1_container);
        if (r1 == null) goto L5;
        View r3 = r1.getChildAt(0);
    L7:
        if ((r3 instanceof OInputLayout) == true) goto L9;
        return null;
    L9:
        return (OInputLayout) r3;
    L5:
        r3 = null;
        goto L7
    }

    public final OButton getPositiveBtn(OSimpleFormDialog r1) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
        return (OButton) r1.findViewById(R.id.actionPositive);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StatusDialog showStatusDialog$default(ODialogUtils r7, Context r8, String r9, String r10, String r11, boolean r12, Function0 r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L6;
        r13 = null;
    L6:
        return r7.showStatusDialog(r8, r9, r10, r11, r12, r13);
    }

    public final StatusDialog showStatusDialog(Context r8, String r9, String r10, String r11, boolean r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "title");
        Intrinsics.checkNotNullParameter(r10, "subtitle");
        Intrinsics.checkNotNullParameter(r11, "buttonText");
        if (r12 == false) goto L5;
        OBaseDialog.ButtonConfig r14 = new OBaseDialog.ButtonConfig(r11, r13, null, 4, null);
    L7:
        return new StatusDialog(r8, new StatusDialog.Modifier(r9, r10, null, r14));
    L5:
        r14 = null;
        goto L7
    }

    public final OActionDialog showActionDialog(final Context r3, String r4, final List<String> r5, final List<? extends View.OnClickListener> r6, final View.OnClickListener r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "selectionList");
        Intrinsics.checkNotNullParameter(r6, "listener");
        Intrinsics.checkNotNullParameter(r7, "itemClickListener");
        OActionDialog r8 = new OActionDialog(r3, new OActionDialog.Modifier(r4, "", new ODialogUtils$showActionDialog$modifier$1(r3, r5, r6, r7)));
        r8.show();
        return r8;
    }

    private final View genContentView(Context r7, List<String> r8, final List<? extends View.OnClickListener> r9, final View.OnClickListener r10) {
        final RecyclerView r0 = new RecyclerView(r7);
        r0.setOverScrollMode(2);
        r0.setLayoutManager(new LinearLayoutManager(r7));
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r0.addItemDecoration(new ActionDialogItemDecoration(MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics())), r8.size()));
        ActionDialogAdapter r1 = new ActionDialogAdapter(r7);
        r0.setAdapter(r1);
        r1.setItems(genItemDataList(r7, r8));
        r1.setOnItemClickListener(new AnonymousClass1(r9, r0, r10));
        return r0;
    }

    private final List<ActionDialogItemData> genItemDataList(Context r4, List<String> r5) {
        ArrayList r3 = new ArrayList();
        Iterator<String> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r3.add(new ActionDialogItemData(r6.next(), 2132017993));
        goto L4
    L6:
        String r7 = r4.getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        r3.add(new ActionDialogItemData(r7, 2132017993));
        return r3;
    }
}
