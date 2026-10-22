package com.android.settings.applications.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.icu.lang.UCharacter;
import android.icu.text.PluralRules;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.popover.v2.OPopoverHelperEx;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OPopoverHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002./B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b26\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\nH\u0007JZ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b26\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\nH\u0007J2\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ(\u0010\u001d\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001cH\u0002J0\u0010%\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ(\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020&2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ>\u0010)\u001a\u0004\u0018\u00010\u00132\u0006\u0010*\u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007J:\u0010+\u001a\u0004\u0018\u00010\u00132\u0006\u0010*\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-2\b\u0010!\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¨\u00060"}, d2 = {"Lcom/android/settings/applications/utils/OPopoverHelper;", "", "()V", "addPopoverItem", "", "builder", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "title", "", "onClick", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "pos", "imageRes", "createCustomPopover", "Lcom/obric/oui/popover/v2/OPopover;", "context", "Landroid/app/Activity;", "data", "", "Lcom/android/settings/applications/utils/Item;", "listener", "Lcom/android/settings/applications/utils/OnPopoverItemClickListener;", "widthBroad", "", "createPopover", "decideOffsetInfo", "Lcom/android/settings/applications/utils/OPopoverHelper$OffsetInfo;", "popover", "anchorView", MaterialConfigFormatNames.DIRECTION, "Lcom/android/settings/applications/utils/OPopoverHelper$Direct;", "isMiddle", "getCustomPopoverView", "Landroid/content/Context;", "datas", "getPopoverView", "showPopoverList", "activity", "showPopoverListInDialog", "dialog", "Landroid/app/Dialog;", "Direct", "OffsetInfo", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OPopoverHelper {
    public static final OPopoverHelper INSTANCE = null;

    /* JADX INFO: compiled from: OPopoverHelper.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/android/settings/applications/utils/OPopoverHelper$Direct;", "", "(Ljava/lang/String;I)V", "TOP_LEFT", "TOP_RIGHT", "TOP_MID", "BOTTOM_LEFT", "BOTTOM_RIGHT", "BOTTOM_MID", "LEFT", "RIGHT", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final enum Direct extends Enum<Direct> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Direct[] $VALUES = null;
        public static final Direct BOTTOM_LEFT = null;
        public static final Direct BOTTOM_MID = null;
        public static final Direct BOTTOM_RIGHT = null;
        public static final Direct LEFT = null;
        public static final Direct RIGHT = null;
        public static final Direct TOP_LEFT = null;
        public static final Direct TOP_MID = null;
        public static final Direct TOP_RIGHT = null;

        private static final /* synthetic */ Direct[] $values() {
            return new Direct[]{TOP_LEFT, TOP_RIGHT, TOP_MID, BOTTOM_LEFT, BOTTOM_RIGHT, BOTTOM_MID, LEFT, RIGHT};
        }

        public static EnumEntries<Direct> getEntries() {
            return $ENTRIES;
        }

        public static Direct valueOf(String r1) {
            return (Direct) Enum.valueOf(Direct.class, r1);
        }

        public static Direct[] values() {
            return (Direct[]) $VALUES.clone();
        }

        private Direct(String r1, int r2) {
            super(r1, r2);
        }

        static {
            TOP_LEFT = new Direct("TOP_LEFT", 0);
            TOP_RIGHT = new Direct("TOP_RIGHT", 1);
            TOP_MID = new Direct("TOP_MID", 2);
            BOTTOM_LEFT = new Direct("BOTTOM_LEFT", 3);
            BOTTOM_RIGHT = new Direct("BOTTOM_RIGHT", 4);
            BOTTOM_MID = new Direct("BOTTOM_MID", 5);
            LEFT = new Direct("LEFT", 6);
            RIGHT = new Direct("RIGHT", 7);
            Direct[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }
    }

    /* JADX INFO: compiled from: OPopoverHelper.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/android/settings/applications/utils/OPopoverHelper$OffsetInfo;", "", "xOffset", "", "yOffset", "arrowOffset", "", "(IIF)V", "getArrowOffset", "()F", "setArrowOffset", "(F)V", "getXOffset", "()I", "setXOffset", "(I)V", "getYOffset", "setYOffset", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class OffsetInfo {
        private float arrowOffset;
        private int xOffset;
        private int yOffset;

        public OffsetInfo() {
            this(0, 0, 0.0f, 7, null);
        }

        public static /* synthetic */ OffsetInfo copy$default(OffsetInfo r0, int r1, int r2, float r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.xOffset;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.yOffset;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.arrowOffset;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.xOffset;
        }

        public final int component2() {
            return this.yOffset;
        }

        public final float component3() {
            return this.arrowOffset;
        }

        public final OffsetInfo copy(int r1, int r2, float r3) {
            return new OffsetInfo(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof OffsetInfo) == true) goto L8;
            return false;
        L8:
            OffsetInfo r6 = (OffsetInfo) r5;
            if (this.xOffset == r6.xOffset) goto L12;
            return false;
        L12:
            if (this.yOffset == r6.yOffset) goto L15;
            return false;
        L15:
            if (Float.compare(this.arrowOffset, r6.arrowOffset) == 0) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.xOffset) * 31) + Integer.hashCode(this.yOffset)) * 31) + Float.hashCode(this.arrowOffset);
        }

        public String toString() {
            return "OffsetInfo(xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", arrowOffset=" + this.arrowOffset + ')';
        }

        public OffsetInfo(int r1, int r2, float r3) {
            this.xOffset = r1;
            this.yOffset = r2;
            this.arrowOffset = r3;
        }

        public /* synthetic */ OffsetInfo(int r2, int r3, float r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = 0.0f;
        L11:
            this(r2, r3, r4);
        }

        public final int getXOffset() {
            return this.xOffset;
        }

        public final void setXOffset(int r1) {
            this.xOffset = r1;
        }

        public final int getYOffset() {
            return this.yOffset;
        }

        public final void setYOffset(int r1) {
            this.yOffset = r1;
        }

        public final float getArrowOffset() {
            return this.arrowOffset;
        }

        public final void setArrowOffset(float r1) {
            this.arrowOffset = r1;
        }
    }

    /* JADX INFO: compiled from: OPopoverHelper.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Direct.values().length];
            r0[Direct.TOP_RIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[Direct.BOTTOM_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[Direct.TOP_LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[Direct.BOTTOM_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[Direct.TOP_MID.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[Direct.BOTTOM_MID.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[Direct.LEFT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[Direct.RIGHT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new OPopoverHelper();
    }

    @JvmStatic
    public static final OPopover showPopoverList(Activity r8, View r9, List<Item> r10, OnPopoverItemClickListener r11) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r10, "data");
        return showPopoverList$default(r8, r9, r10, r11, false, 16, null);
    }

    private OPopoverHelper() {
    }

    public final View getPopoverView(Context r5, List<Item> r6, OnPopoverItemClickListener r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "data");
        OPopoverEntranceMenuView.Builder r4 = new OPopoverEntranceMenuView.Builder(r5);
        View r0 = LayoutInflater.from(r5).inflate(R.layout.settings_popover_list_layout, null, false);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView r1 = (RecyclerView) r0;
        r1.setLayoutManager(new LinearLayoutManager(r5));
        InnerPopoverAdapter r8 = new InnerPopoverAdapter(r6, r7);
        r1.setAdapter(r8);
        r4.addTopView(r1);
        r8.notifyDataSetChanged();
        return r4.build();
    }

    public final OPopover createPopover(Activity r2, List<Item> r3, OnPopoverItemClickListener r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "data");
        Activity r5 = r2;
        View r1 = getPopoverView(r5, r3, r4);
        if (r1 != null) goto L7;
        return null;
    L7:
        return new OPopover.Builder(r5).setView(r1).build();
    }

    public static /* synthetic */ OPopover showPopoverList$default(Activity r0, View r1, List r2, OnPopoverItemClickListener r3, boolean r4, int r5, Object r6) {
        if ((r5 & 16) == 0) goto L6;
        r4 = false;
    L6:
        return showPopoverList(r0, r1, r2, r3, r4);
    }

    @JvmStatic
    public static final OPopover showPopoverList(Activity r14, View r15, List<Item> r16, OnPopoverItemClickListener r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r14, "activity");
        Intrinsics.checkNotNullParameter(r16, "data");
        OPopover r0 = INSTANCE.createCustomPopover(r14, r16, r17, r18);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r15 == null) goto L8;
        OPopoverHelperEx.showPopoverSmartly$default(OPopoverHelperEx.INSTANCE, r0, r15, 83, false, 0, false, 0, 0, UCharacter.UnicodeBlock.SIDDHAM_ID, null);
    L8:
        return r0;
    }

    public final OPopover showPopoverListInDialog(Activity r20, Dialog r21, View r22, List<Item> r23, OnPopoverItemClickListener r24) {
        Intrinsics.checkNotNullParameter(r20, "activity");
        Intrinsics.checkNotNullParameter(r21, "dialog");
        Intrinsics.checkNotNullParameter(r23, "data");
        OPopover r0 = createCustomPopover$default(this, r20, r23, r24, false, 8, null);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r22 == null) goto L8;
        r0.setIsShowInDialog(true);
        OPopoverHelperEx.showPopoverSmartly$default(OPopoverHelperEx.INSTANCE, r0, r22, 83, false, 0, false, 0, 0, UCharacter.UnicodeBlock.SIDDHAM_ID, null);
    L8:
        return r0;
    }

    public final View getCustomPopoverView(Context r17, List<Item> r18, final OnPopoverItemClickListener r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "datas");
        OPopoverEntranceMenuView.Builder r2 = new OPopoverEntranceMenuView.Builder(r17);
        r2.enableOption();
        if (r20 == false) goto L5;
        OPopoverEntranceMenuView.WidthLevel r0 = OPopoverEntranceMenuView.WidthLevel.WIDTH_LEVEL_BROAD;
    L6:
        r2.setWidthLevel(r0);
        Iterator<T> r1 = r18.iterator();
    L8:
        if (r1.hasNext() == false) goto L11;
        Item r3 = (Item) r1.next();
        OPopoverEntranceMenuView.Builder.addPopoverLeftOptionItem$default(r2, null, null, null, r3.getTitle(), r3.getSubTitle(), false, false, r3.isSelect(), new OPopoverHelper$getCustomPopoverView$builder$1$1$1(r19), 103, null);
        goto L8
    L11:
        return r2.build();
    L5:
        r0 = OPopoverEntranceMenuView.WidthLevel.WIDTH_LEVEL_STANDARD;
        goto L6
    }

    public static /* synthetic */ OPopover createCustomPopover$default(OPopoverHelper r0, Activity r1, List r2, OnPopoverItemClickListener r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        return r0.createCustomPopover(r1, r2, r3, r4);
    }

    public final OPopover createCustomPopover(Activity r2, List<Item> r3, OnPopoverItemClickListener r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "data");
        Activity r6 = r2;
        View r1 = getCustomPopoverView(r6, r3, r4, r5);
        if (r1 != null) goto L7;
        return null;
    L7:
        return new OPopover.Builder(r6).setView(r1).build();
    }

    private final OffsetInfo decideOffsetInfo(OPopover r7, View r8, Direct r9, boolean r10) {
        OffsetInfo r6 = new OffsetInfo(0, 0, 0.0f, 7, null);
        switch(WhenMappings.$EnumSwitchMapping$0[r9.ordinal()]) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L25;
        };
    L20:
        r6.setXOffset(r8.getMeasuredWidth() - r7.getMeasuredWidth());
        r6.setArrowOffset(1000.0f);
        if (r9 != Direct.TOP_RIGHT) goto L23;
        int r11 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
    L24:
        r6.setYOffset(r11);
        goto L25
    L23:
        r11 = -MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
    L25:
        if (r10 == false) goto L27;
        r6.setXOffset(0);
    L27:
        return r6;
    L6:
        if (r9 != Direct.LEFT) goto L8;
        int r12 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
    L9:
        r6.setXOffset(r12);
        goto L25
    L8:
        r12 = -MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        goto L9
    L11:
        if (r9 != Direct.TOP_MID) goto L13;
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
    L14:
        r6.setYOffset(r13);
        goto L25
    L13:
        r13 = -MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        goto L14
    L16:
        if (r9 != Direct.TOP_LEFT) goto L18;
        int r14 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
    L19:
        r6.setYOffset(r14);
        goto L25
    L18:
        r14 = -MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        goto L19
    }

    @JvmStatic
    public static final void addPopoverItem(OPopoverEntranceMenuView.Builder r13, int r14, CharSequence r15, Function2<? super View, ? super Integer, Unit> r16) {
        Intrinsics.checkNotNullParameter(r13, "builder");
        Intrinsics.checkNotNullParameter(r15, "title");
        Intrinsics.checkNotNullParameter(r16, "onClick");
        OPopoverEntranceMenuView.Builder.addPopoverItem$default(r13, Integer.valueOf(r14), null, null, r15, null, null, false, null, r16, UCharacter.UnicodeBlock.PSALTER_PAHLAVI_ID, null);
    }

    @JvmStatic
    public static final void addPopoverItem(OPopoverEntranceMenuView.Builder r13, CharSequence r14, Function2<? super View, ? super Integer, Unit> r15) {
        Intrinsics.checkNotNullParameter(r13, "builder");
        Intrinsics.checkNotNullParameter(r14, "title");
        Intrinsics.checkNotNullParameter(r15, "onClick");
        OPopoverEntranceMenuView.Builder.addPopoverItem$default(r13, null, null, null, r14, null, null, false, null, r15, UCharacter.UnicodeBlock.SHORTHAND_FORMAT_CONTROLS_ID, null);
    }
}
