package com.obric.oui.dropdown;

import android.app.Activity;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.WorkRequest;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.popover.OPopover;
import com.obric.oui.popover.OPopoverHelperKt;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ODropdownRatio.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "use CardListItem")
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0004J.\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020+2\u0006\u0010(\u001a\u00020)2\u0006\u0010/\u001a\u00020'2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0004J<\u00101\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020)2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00160\u0018H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00160\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u0000@BX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00062"}, d2 = {"Lcom/obric/oui/dropdown/ODropdownRatio;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/obric/oui/dropdown/ODropdown;", "options", "", "defaultOption", "", "(Ljava/util/List;I)V", "alignTriggerWidth", "", "getAlignTriggerWidth", "()Z", "setAlignTriggerWidth", "(Z)V", "autoDismissMs", "", "getAutoDismissMs", "()J", "setAutoDismissMs", "(J)V", "dismiss", "Lkotlin/Function0;", "", "onTextChanged", "Lkotlin/Function1;", "", BaseSwitches.V, "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "valueChangeObservers", "", "Ljava/util/function/Consumer;", "getValueChangeObservers", "()Ljava/util/List;", "generateMenu", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView;", "activity", "Landroid/app/Activity;", "caller", "Lcom/obric/oui/dropdown/ODropdownTrigger;", "popMenu", "Lcom/obric/oui/popover/OPopover;", "dropdown", "menuView", "onDismiss", "start", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ODropdownRatio<V> implements ODropdown {
    private boolean alignTriggerWidth;
    private long autoDismissMs;
    private Function0<Unit> dismiss;
    private Function1<? super CharSequence, Unit> onTextChanged;
    private final List<V> options;
    private V value;
    private final List<Consumer<V>> valueChangeObservers;

    /* JADX WARN: Multi-variable type inference failed */
    public ODropdownRatio(List<? extends V> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "options");
        this.options = r2;
        this.valueChangeObservers = new ArrayList();
        this.value = (V) r2.get(r3);
        this.autoDismissMs = WorkRequest.MIN_BACKOFF_MILLIS;
    }

    public static final /* synthetic */ Function0 access$getDismiss$p(ODropdownRatio r0) {
        return r0.dismiss;
    }

    public static final /* synthetic */ Function1 access$getOnTextChanged$p(ODropdownRatio r0) {
        return r0.onTextChanged;
    }

    public static final /* synthetic */ List access$getOptions$p(ODropdownRatio r0) {
        return r0.options;
    }

    public static final /* synthetic */ void access$setValue(ODropdownRatio r0, Object r1) {
        r0.setValue(r1);
    }

    public /* synthetic */ ODropdownRatio(List r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        this(r1, r2);
    }

    public final List<Consumer<V>> getValueChangeObservers() {
        return this.valueChangeObservers;
    }

    public final V getValue() {
        return this.value;
    }

    private final void setValue(V r2) {
        if (Intrinsics.areEqual(this.value, r2) == false) goto L5;
        return;
    L5:
        this.value = r2;
        Iterator<Consumer<V>> r1 = this.valueChangeObservers.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().accept(r2);
        goto L7
    }

    public final long getAutoDismissMs() {
        return this.autoDismissMs;
    }

    public final void setAutoDismissMs(long r1) {
        this.autoDismissMs = r1;
    }

    public final boolean getAlignTriggerWidth() {
        return this.alignTriggerWidth;
    }

    public final void setAlignTriggerWidth(boolean r1) {
        this.alignTriggerWidth = r1;
    }

    protected final OPopover popMenu(ODropdownTrigger r11, Activity r12, OPopoverEntranceMenuView r13, final Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "dropdown");
        Intrinsics.checkNotNullParameter(r12, "activity");
        Intrinsics.checkNotNullParameter(r13, "menuView");
        Intrinsics.checkNotNullParameter(r14, "onDismiss");
        final OPopover r15 = new OPopover.Builder(r12).setUseDefaultView(false).setView(r13).setAutoDismissDelayMillis(this.autoDismissMs).alignArrowPadding(true).setOnDismissListener(new ODropdownRatio$popMenu$popover$1(r14)).setBgColor(ContextCompat.getColor(r12, R.color.oui_basic_bg_base_2_2_low_elevation)).build();
        this.dismiss = new C02721(r15);
        OPopoverHelperKt.showPopoverSmartly$default(r15, r11, 80, true, 0.0f, 0, 0, false, 120, null);
        return r15;
    }

    protected final OPopoverEntranceMenuView generateMenu(Activity r19, final ODropdownTrigger r20) {
        Intrinsics.checkNotNullParameter(r19, "activity");
        Intrinsics.checkNotNullParameter(r20, "caller");
        Activity r1 = r19;
        OPopoverEntranceMenuView.Builder r3 = new OPopoverEntranceMenuView.Builder(r1);
        r3.enableOption();
        if (this.alignTriggerWidth == false) goto L5;
        r3.setItemWidth(r20.getMeasuredWidth() - OUnitExtensionKt.cdp(r1, 12));
    L5:
        Iterator<V> r2 = this.options.iterator();
    L7:
        if (r2.hasNext() == false) goto L19;
        V r4 = r2.next();
        int r5 = 0;
        if (r4 != null) goto L12;
    L10:
        boolean r12 = false;
    L14:
        String r6 = String.valueOf(r4);
        if ((r4 instanceof IconItem) == false) goto L17;
        r5 = ((IconItem) r4).getIconRes();
    L17:
        OPopoverEntranceMenuView.Builder.addPopoverRightOptionItem$default(r3, false, Integer.valueOf(r5), null, null, r6, null, false, r12, new AnonymousClass1(this, r20), 77, null);
        goto L7
    L12:
        if (r4.equals(this.value) != true) goto L10;
        r12 = true;
        goto L14
    L19:
        return r3.build();
    }

    @Override // com.obric.oui.dropdown.ODropdown
    public void start(ODropdownTrigger r2, Activity r3, Function0<Unit> r4, Function1<? super CharSequence, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "onDismiss");
        Intrinsics.checkNotNullParameter(r5, "onTextChanged");
        this.onTextChanged = r5;
        popMenu(r2, r3, generateMenu(r3, r2), r4);
    }
}
