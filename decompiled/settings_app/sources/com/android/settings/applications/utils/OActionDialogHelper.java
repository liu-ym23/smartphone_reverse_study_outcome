package com.android.settings.applications.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.dialog.v2.action.OActionDialog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OActionDialogHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J<\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\u0016"}, d2 = {"Lcom/android/settings/applications/utils/OActionDialogHelper;", "", "()V", "genContentView", "Landroid/view/View;", "viewGroup", "Landroid/view/ViewGroup;", "actions", "", "Lcom/android/settings/applications/utils/ActionItem;", "listener", "Lcom/android/settings/applications/utils/OnOActionDialogItemClickListener;", "genItemDataList", "", "Lcom/android/settings/applications/utils/ActionDialogItemData;", "showOActionDialog", "Lcom/obric/oui/dialog/v2/action/OActionDialog;", "activity", "Landroid/app/Activity;", "title", "", "subTitle", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OActionDialogHelper {
    public static final OActionDialogHelper INSTANCE = null;

    static {
        INSTANCE = new OActionDialogHelper();
    }

    private OActionDialogHelper() {
    }

    public static final /* synthetic */ View access$genContentView(OActionDialogHelper r0, ViewGroup r1, List r2, OnOActionDialogItemClickListener r3) {
        return r0.genContentView(r1, r2, r3);
    }

    @JvmStatic
    public static final OActionDialog showOActionDialog(Activity r3, String r4, String r5, final List<ActionItem> r6, final OnOActionDialogItemClickListener r7) {
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "subTitle");
        Intrinsics.checkNotNullParameter(r6, "actions");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new OActionDialog(r3, new OActionDialog.Modifier(r4, r5, new OActionDialogHelper$showOActionDialog$dialog$1(r6, r7)));
    }

    private final View genContentView(ViewGroup r7, List<ActionItem> r8, final OnOActionDialogItemClickListener r9) {
        RecyclerView r0 = new RecyclerView(r7.getContext());
        r0.setOverScrollMode(2);
        r0.setLayoutManager(new LinearLayoutManager(r0.getContext()));
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r0.addItemDecoration(new ActionDialogItemDecoration(MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics())), 4));
        Context r10 = r7.getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "getContext(...)");
        ActionDialogAdapter r1 = new ActionDialogAdapter(r10);
        r0.setAdapter(r1);
        r1.setItems(genItemDataList(r8));
        r1.setOnItemClickListener(new AnonymousClass1(r9));
        return r0;
    }

    private final List<ActionDialogItemData> genItemDataList(List<ActionItem> r6) {
        ArrayList r5 = new ArrayList();
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.add(new ActionDialogItemData(r6.get(r1).getTitle(), r6.get(r1).getActionStyle()));
        r1 = r1 + 1;
        goto L3
    L5:
        return r5;
    }
}
