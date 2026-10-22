package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.bytedance.apm.constant.AgentConstants;
import com.obric.common.oui.R;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.panel.OBasePanelDialog;
import com.obric.oui.panel.OBasicPanelFragment;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OActionSheet.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "使用 OInsetSheet")
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 A2\u00020\u0001:\u0003@ABB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020(H\u0016J\u001a\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u0002032\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u000e\u0010>\u001a\u00020?2\u0006\u0010)\u001a\u00020&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020&0\nj\b\u0012\u0004\u0012\u00020&`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/obric/oui/sheet/OActionSheet;", "Lcom/obric/oui/panel/OBasicPanelFragment;", "()V", "mActionContainer", "Landroid/widget/LinearLayout;", "getMActionContainer", "()Landroid/widget/LinearLayout;", "setMActionContainer", "(Landroid/widget/LinearLayout;)V", "mActions", "Ljava/util/ArrayList;", "Lcom/obric/oui/sheet/OActionSheet$Action;", "Lkotlin/collections/ArrayList;", "mCancelBtnClickListener", "Landroid/view/View$OnClickListener;", "getMCancelBtnClickListener", "()Landroid/view/View$OnClickListener;", "setMCancelBtnClickListener", "(Landroid/view/View$OnClickListener;)V", "mSubTitle", "", "getMSubTitle", "()Ljava/lang/CharSequence;", "setMSubTitle", "(Ljava/lang/CharSequence;)V", "mSubTitleText", "Landroid/widget/TextView;", "getMSubTitleText", "()Landroid/widget/TextView;", "setMSubTitleText", "(Landroid/widget/TextView;)V", "mTitle", "getMTitle", "setMTitle", "mTitleText", "getMTitleText", "setMTitleText", "onDismissListeners", "Landroid/content/DialogInterface$OnDismissListener;", "addOnDismissListener", "", "listener", "getSpecColor", "", "scene", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", AgentConstants.ON_START, "onViewCreated", "view", "removeOnDismissListener", "", "Action", "Companion", "OActionSheetBuilder", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OActionSheet extends OBasicPanelFragment {
    public static final Companion Companion = null;
    public static final String DIVIDER_LINE = "divider_line";
    public static final String DIVIDER_VIEW = "divider_view";
    public static final String EXTENSION_SUBTITLE = "extension_subtitle";
    public static final String EXTENSION_TITLE = "extension_title";
    public static final String ITEM_SUBTITLE = "item_subtitle";
    public static final String ITEM_TITLE = "item_title";
    public static final String TAG = "OActionSheet";
    private LinearLayout mActionContainer;
    private ArrayList<Action> mActions;
    private View.OnClickListener mCancelBtnClickListener;
    private CharSequence mSubTitle;
    private TextView mSubTitleText;
    private CharSequence mTitle;
    private TextView mTitleText;
    private final ArrayList<DialogInterface.OnDismissListener> onDismissListeners;

    /* JADX INFO: compiled from: OActionSheet.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B[\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00128\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014RL\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/sheet/OActionSheet$Action;", "", "title", "", "subTitle", "highlight", "", "onClick", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Landroidx/fragment/app/DialogFragment;", "dialog", "", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLkotlin/jvm/functions/Function2;)V", "getHighlight", "()Z", "setHighlight", "(Z)V", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "setOnClick", "(Lkotlin/jvm/functions/Function2;)V", "getSubTitle", "()Ljava/lang/CharSequence;", "setSubTitle", "(Ljava/lang/CharSequence;)V", "getTitle", "setTitle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Action {
        private boolean highlight;
        private Function2<? super View, ? super DialogFragment, Unit> onClick;
        private CharSequence subTitle;
        private CharSequence title;

        public Action(CharSequence r1, CharSequence r2, boolean r3, Function2<? super View, ? super DialogFragment, Unit> r4) {
            this.title = r1;
            this.subTitle = r2;
            this.highlight = r3;
            this.onClick = r4;
        }

        public final boolean getHighlight() {
            return this.highlight;
        }

        public final CharSequence getSubTitle() {
            return this.subTitle;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final void setHighlight(boolean r1) {
            this.highlight = r1;
        }

        public final void setSubTitle(CharSequence r1) {
            this.subTitle = r1;
        }

        public final void setTitle(CharSequence r1) {
            this.title = r1;
        }

        public final Function2<View, DialogFragment, Unit> getOnClick() {
            return this.onClick;
        }

        public final void setOnClick(Function2<? super View, ? super DialogFragment, Unit> r1) {
            this.onClick = r1;
        }
    }

    /* JADX INFO: compiled from: OActionSheet.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/sheet/OActionSheet$Companion;", "", "()V", "DIVIDER_LINE", "", "DIVIDER_VIEW", "EXTENSION_SUBTITLE", "EXTENSION_TITLE", "ITEM_SUBTITLE", "ITEM_TITLE", "TAG", "build", "Lcom/obric/oui/sheet/OActionSheet;", "block", "Lkotlin/Function1;", "Lcom/obric/oui/sheet/OActionSheet$OActionSheetBuilder;", "", "Lkotlin/ExtensionFunctionType;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final OActionSheet build(Function1<? super OActionSheetBuilder, Unit> r1) {
            Intrinsics.checkNotNullParameter(r1, "block");
            OActionSheetBuilder r0 = new OActionSheetBuilder();
            r1.invoke(r0);
            return r0.build();
        }
    }

    /* JADX INFO: compiled from: OActionSheet.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JT\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r28\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011JH\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r28\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\nJ\u001a\u0010 \u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\r2\b\u0010\"\u001a\u0004\u0018\u00010\rR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/oui/sheet/OActionSheet$OActionSheetBuilder;", "", "()V", "actions", "Ljava/util/ArrayList;", "Lcom/obric/oui/sheet/OActionSheet$Action;", "Lkotlin/collections/ArrayList;", "autoSwitchDayNight", "", "cancelBtnOnClickListener", "Landroid/view/View$OnClickListener;", "disableAutoAdaptHeight", "subTitle", "", "title", "addAction", "onClick", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Landroidx/fragment/app/DialogFragment;", "dialog", "", "addHighlightAction", "autoSwitch", "build", "Lcom/obric/oui/sheet/OActionSheet;", MaterialConfigFormatNames.DISABLE, "setCancelBtnClickListener", "listener", "setTitle", "t", "st", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OActionSheetBuilder {
        private ArrayList<Action> actions;
        private boolean autoSwitchDayNight;
        private View.OnClickListener cancelBtnOnClickListener;
        private boolean disableAutoAdaptHeight;
        private CharSequence subTitle;
        private CharSequence title;

        public OActionSheetBuilder() {
            this.actions = new ArrayList();
        }

        public final OActionSheetBuilder addAction(CharSequence r4, CharSequence r5, Function2<? super View, ? super DialogFragment, Unit> r6) {
            this.actions.add(new Action(r4, r5, false, r6));
            return this;
        }

        public final OActionSheetBuilder addHighlightAction(CharSequence r5, Function2<? super View, ? super DialogFragment, Unit> r6) {
            Intrinsics.checkNotNullParameter(r5, "title");
            this.actions.add(new Action(r5, null, true, r6));
            return this;
        }

        public final OActionSheetBuilder setTitle(CharSequence r1, CharSequence r2) {
            this.title = r1;
            this.subTitle = r2;
            return this;
        }

        public final OActionSheetBuilder setCancelBtnClickListener(View.OnClickListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.cancelBtnOnClickListener = r2;
            return this;
        }

        public final OActionSheetBuilder autoSwitchDayNight(boolean r1) {
            this.autoSwitchDayNight = r1;
            return this;
        }

        public final OActionSheetBuilder disableAutoAdaptHeight(boolean r1) {
            this.disableAutoAdaptHeight = r1;
            return this;
        }

        public final OActionSheet build() {
            OActionSheet r0 = new OActionSheet();
            OActionSheet.access$setMActions$p(r0, this.actions);
            r0.setMTitle(this.title);
            r0.setMSubTitle(this.subTitle);
            r0.setMCancelBtnClickListener(this.cancelBtnOnClickListener);
            r0.setAutoSwitchDayNight(this.autoSwitchDayNight);
            r0.setDisableAutoAdaptHeight(this.disableAutoAdaptHeight);
            return r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$8_Dz1BGVTp9wfUk_M9d2zaF1fY8(OActionSheet r0, View r1) {
        m518onViewCreated$lambda2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$TaPZfDvmVJhSGHgmjYFh07l2P-8, reason: not valid java name */
    public static /* synthetic */ void m517$r8$lambda$TaPZfDvmVJhSGHgmjYFh07l2P8(Action r0, OActionSheet r1, View r2) {
        m519onViewCreated$lambda4$lambda3(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ void access$setMActions$p(OActionSheet r0, ArrayList r1) {
        r0.mActions = r1;
    }

    public OActionSheet() {
        this.mActions = new ArrayList();
        this.onDismissListeners = new ArrayList();
    }

    public final CharSequence getMTitle() {
        return this.mTitle;
    }

    public final void setMTitle(CharSequence r1) {
        this.mTitle = r1;
    }

    public final CharSequence getMSubTitle() {
        return this.mSubTitle;
    }

    public final void setMSubTitle(CharSequence r1) {
        this.mSubTitle = r1;
    }

    public final View.OnClickListener getMCancelBtnClickListener() {
        return this.mCancelBtnClickListener;
    }

    public final void setMCancelBtnClickListener(View.OnClickListener r1) {
        this.mCancelBtnClickListener = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(R.layout.o_view_action_sheet, r2, false);
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r5) {
        Context r0 = requireContext();
        Intrinsics.checkNotNullExpressionValue(r0, "requireContext()");
        OBasePanelDialog r6 = new OBasePanelDialog(r0, 0, 2, null);
        r6.setExpandable(false);
        r6.setRemoveMinHeight(true);
        r6.setDisableAutoAdaptHeight(getDisableAutoAdaptHeight());
        return r6;
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onDismiss(r2);
        Iterator<T> r1 = this.onDismissListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((DialogInterface.OnDismissListener) r1.next()).onDismiss(r2);
        goto L4
    }

    public final void addOnDismissListener(DialogInterface.OnDismissListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.onDismissListeners.add(r2);
    }

    public final boolean removeOnDismissListener(DialogInterface.OnDismissListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        return this.onDismissListeners.remove(r2);
    }

    public final TextView getMTitleText() {
        return this.mTitleText;
    }

    public final void setMTitleText(TextView r1) {
        this.mTitleText = r1;
    }

    public final TextView getMSubTitleText() {
        return this.mSubTitleText;
    }

    public final void setMSubTitleText(TextView r1) {
        this.mSubTitleText = r1;
    }

    public final LinearLayout getMActionContainer() {
        return this.mActionContainer;
    }

    public final void setMActionContainer(LinearLayout r1) {
        this.mActionContainer = r1;
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        LinearLayout r16 = (LinearLayout) r14.findViewById(R.id.action_sheet_layout);
        if (getAutoSwitchDayNight() == false) goto L5;
        Drawable r0 = ContextCompat.getDrawable(requireContext(), R.drawable.o_action_sheet_daynight_bg);
    L6:
        if (r16 == null) goto L9;
        r16.setBackground(r0);
    L9:
        r14.findViewById(R.id.divider_view).setBackgroundColor(getSpecColor(DIVIDER_VIEW));
        LinearLayout r17 = (LinearLayout) r14.findViewById(R.id.title_container);
        TextView r1 = (TextView) r17.findViewById(R.id.action_title);
        this.mTitleText = r1;
        if (r1 == null) goto L13;
        r1.setTextColor(getSpecColor(EXTENSION_TITLE));
    L13:
        TextView r2 = (TextView) r17.findViewById(R.id.action_sub_title);
        this.mSubTitleText = r2;
        if (r2 == null) goto L17;
        r2.setTextColor(getSpecColor(EXTENSION_SUBTITLE));
    L17:
        View r3 = r17.findViewById(R.id.top_divider);
        r3.setBackgroundColor(getSpecColor(DIVIDER_LINE));
        r3.setVisibility(4);
        CharSequence r4 = this.mTitle;
        if (r4 == null) goto L31;
        TextView r7 = this.mTitleText;
        if (r7 == null) goto L23;
        r7.setText(r4);
    L23:
        TextView r5 = this.mTitleText;
        if (r5 == null) goto L27;
        r5.setVisibility(0);
    L27:
        TextView r6 = this.mSubTitleText;
        if (r6 == null) goto L39;
        r6.setMaxLines(1);
    L39:
        CharSequence r8 = this.mSubTitle;
        if (r8 == null) goto L49;
        TextView r9 = this.mSubTitleText;
        if (r9 == null) goto L45;
        r9.setText(r8);
    L45:
        TextView r10 = this.mSubTitleText;
        if (r10 == null) goto L54;
        r10.setVisibility(0);
    L54:
        if (this.mTitle == null) goto L56;
    L58:
        TextView r11 = (TextView) r14.findViewById(R.id.cancel_action);
        if (r11 == null) goto L62;
        r11.setTextColor(getSpecColor(ITEM_TITLE));
    L62:
        r11.setAccessibilityDelegate(new AnonymousClass1());
        r11.setOnClickListener(new OActionSheet$$ExternalSyntheticLambda0(this));
        this.mActionContainer = (LinearLayout) r14.findViewById(R.id.action_container);
        Iterator<T> r18 = this.mActions.iterator();
    L64:
        if (r18.hasNext() == false) goto L96;
        final Action r12 = (Action) r18.next();
        View r13 = LayoutInflater.from(getContext()).inflate(R.layout.o_item_action_sheet, getMActionContainer(), false);
        r13.setOnClickListener(new OActionSheet$$ExternalSyntheticLambda1(r12, this));
        TextView r19 = (TextView) r13.findViewById(R.id.action_title);
        TextView r110 = (TextView) r13.findViewById(R.id.action_sub_title);
        View r111 = r13.findViewById(R.id.top_divider);
        if (r19 == null) goto L69;
        r19.setTextColor(getSpecColor(ITEM_TITLE));
    L69:
        if (r110 == null) goto L72;
        r110.setTextColor(getSpecColor(ITEM_SUBTITLE));
    L72:
        if (r111 == null) goto L76;
        r111.setBackgroundColor(getSpecColor(DIVIDER_LINE));
    L76:
        if (this.mActions.indexOf(r12) == 0) goto L78;
    L80:
        r111.setVisibility(0);
    L82:
        if (r12.getTitle() == null) goto L84;
        r19.setText(r12.getTitle());
        r19.setVisibility(0);
        r13.setContentDescription(r12.getTitle());
        r110.setMaxLines(1);
    L86:
        if (r12.getSubTitle() == null) goto L88;
        r110.setText(r12.getSubTitle());
        r110.setVisibility(0);
        r13.setContentDescription(r13.getContentDescription() + ", " + r12.getSubTitle());
    L90:
        if (r12.getHighlight() == false) goto L92;
        r19.setTextColor(ContextCompat.getColor(requireContext(), R.color.Negative));
    L92:
        r13.setAccessibilityDelegate(new OActionSheet$onViewCreated$3$2(r12));
        LinearLayout r20 = getMActionContainer();
        if (r20 == null) goto L64;
        r20.addView(r13);
        goto L64
    L88:
        r110.setVisibility(8);
        goto L90
    L84:
        r19.setVisibility(8);
        r110.setMaxLines(2);
        goto L86
    L78:
        if (r17.getVisibility() != 8) goto L80;
        r111.setVisibility(4);
        goto L82
    L96:
        return;
    L56:
        if (this.mSubTitle != null) goto L58;
        r17.setVisibility(8);
        goto L58
    L49:
        TextView r21 = this.mSubTitleText;
        if (r21 == null) goto L54;
        r21.setVisibility(8);
        goto L54
    L31:
        TextView r22 = this.mTitleText;
        if (r22 == null) goto L35;
        r22.setVisibility(8);
    L35:
        TextView r23 = this.mSubTitleText;
        if (r23 == null) goto L39;
        r23.setMaxLines(2);
        goto L39
    L5:
        r0 = ContextCompat.getDrawable(requireContext(), R.drawable.o_action_sheet_const_bg);
        goto L6
    }

    /* JADX INFO: renamed from: onViewCreated$lambda-2, reason: not valid java name */
    private static final void m518onViewCreated$lambda2(OActionSheet r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        View.OnClickListener r0 = r1.mCancelBtnClickListener;
        if (r0 == null) goto L6;
        r0.onClick(r2);
    L6:
        r1.dismissAllowingStateLoss();
    }

    /* JADX INFO: renamed from: onViewCreated$lambda-4$lambda-3, reason: not valid java name */
    private static final void m519onViewCreated$lambda4$lambda3(Action r1, OActionSheet r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "$action");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Function2<View, DialogFragment, Unit> r4 = r1.getOnClick();
        if (r4 == null) goto L6;
        Intrinsics.checkNotNullExpressionValue(r3, "it");
        r4.invoke(r3, r2);
    L6:
        r2.dismissAllowingStateLoss();
    }

    private final int getSpecColor(String r2) {
        switch(r2.hashCode()) {
            case -1951390164: goto L41;
            case -1672427580: goto L34;
            case -1210163878: goto L27;
            case -1209866229: goto L20;
            case 1704015448: goto L13;
            case 1915336728: goto L6;
            default: goto L47;
        };
    L47:
        int r3 = 0;
    L49:
        return ContextCompat.getColor(requireContext(), r3);
    L6:
        if (r2.equals(EXTENSION_SUBTITLE) == false) goto L47;
        if (getAutoSwitchDayNight() == false) goto L11;
        r3 = R.color.TextTertiary;
        goto L49
    L11:
        r3 = R.color.TextReverse3;
        goto L49
    L13:
        if (r2.equals(EXTENSION_TITLE) == false) goto L47;
        if (getAutoSwitchDayNight() == false) goto L18;
        r3 = R.color.TextTertiary;
        goto L49
    L18:
        r3 = R.color.TextReverse3;
        goto L49
    L20:
        if (r2.equals(DIVIDER_VIEW) == false) goto L47;
        if (getAutoSwitchDayNight() == false) goto L25;
        r3 = R.color.BGPlaceholderDefault;
        goto L49
    L25:
        r3 = R.color.BGInputReverse;
        goto L49
    L27:
        if (r2.equals(DIVIDER_LINE) == false) goto L47;
        if (getAutoSwitchDayNight() == false) goto L32;
        r3 = R.color.LinePrimary;
        goto L49
    L32:
        r3 = R.color.LineReverse2;
        goto L49
    L34:
        if (r2.equals(ITEM_SUBTITLE) == false) goto L47;
        if (getAutoSwitchDayNight() == false) goto L39;
        r3 = R.color.TextTertiary;
        goto L49
    L39:
        r3 = R.color.TextReverse3;
        goto L49
    L41:
        if (r2.equals(ITEM_TITLE) == false) goto L47;
        if (getAutoSwitchDayNight() == false) goto L46;
        r3 = R.color.TextPrimary;
        goto L49
    L46:
        r3 = R.color.TextReverse;
        goto L49
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if ((getDialog() instanceof OBasePanelDialog) == false) goto L9;
        Dialog r1 = getDialog();
        if (r1 == null) goto L8;
        ((OBasePanelDialog) r1).hideHeader();
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.panel.OBasePanelDialog");
    }
}
