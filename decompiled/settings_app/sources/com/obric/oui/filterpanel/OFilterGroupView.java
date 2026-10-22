package com.obric.oui.filterpanel;

import android.content.Context;
import android.icu.text.PluralRules;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.filter.OFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OFilterPanelView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001:\u0004>?@AB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J \u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010(\u001a\u00020\nJ\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130\fJ\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\fJ\u0006\u0010+\u001a\u00020#J\u000e\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u001cJ\u000e\u0010.\u001a\u00020&2\u0006\u0010-\u001a\u00020\u001eJ\u000e\u0010/\u001a\u00020&2\u0006\u0010-\u001a\u00020 J\u000e\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u0013J\u000e\u00100\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\nJ\u000e\u00103\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u000fJ(\u00104\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u00105\u001a\u00020\nJ\u0018\u00106\u001a\u00020&2\u0006\u00107\u001a\u00020\n2\b\b\u0002\u00108\u001a\u00020\u000fJ\u000e\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020\nJ\u0010\u0010;\u001a\u00020&2\b\u0010<\u001a\u0004\u0018\u00010\rJ\u0006\u0010=\u001a\u00020&R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "columnCount", "", "curFiltersList", "", "", "enableClickWhenSelected", "", "filterStyle", "filtersList", "", "Lcom/obric/oui/filter/OFilter;", "gridLayout", "Landroid/widget/GridLayout;", "getGridLayout", "()Landroid/widget/GridLayout;", "lessFiltersList", "maxSelectCount", "moreFiltersList", "onFilterClickedListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterClickedListener;", "onFilterDataChangeListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterDataChangeListener;", "onFilterSelectedListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;", "showingMore", "tvShowMore", "Landroid/widget/TextView;", "tvTitle", "addFilterItems", "", "items", "getMaxSelectCount", "getSelectedFilters", "getSelectedIndexes", "getTitle", "registerFilterClickedListener", "listener", "registerFilterDataChangeListener", "registerFilterSelectedListener", "select", "filter", "index", "setEnableClickWhenSelected", "setFilterItems", "initRowCount", "setFilterStyle", "style", "isAlwaysLight", "setMaxSelectCount", "count", "setTitle", "title", "unSelectAll", "Config", "OnFilterClickedListener", "OnFilterDataChangeListener", "OnFilterSelectedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFilterGroupView extends ConstraintLayout {
    private final String TAG;
    private int columnCount;
    private List<? extends CharSequence> curFiltersList;
    private boolean enableClickWhenSelected;
    private int filterStyle;
    private final List<OFilter> filtersList;
    private final GridLayout gridLayout;
    private final List<CharSequence> lessFiltersList;
    private int maxSelectCount;
    private final List<CharSequence> moreFiltersList;
    private OnFilterClickedListener onFilterClickedListener;
    private OnFilterDataChangeListener onFilterDataChangeListener;
    private OnFilterSelectedListener onFilterSelectedListener;
    private boolean showingMore;
    private final TextView tvShowMore;
    private final TextView tvTitle;

    /* JADX INFO: compiled from: OFilterPanelView.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u000fHÆ\u0003Jz\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0005HÖ\u0001J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0005J\u0014\u0010 \u001a\u00020\u00002\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00030\nJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\fJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006C"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView$Config;", "", "title", "", "filterStyle", "", "maxSelectCount", "columnCount", "defaultSelectIndex", "filterItems", "", "onFilterSelectListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;", "initRowCount", "enableClickWhenSelected", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;Ljava/util/List;Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;IZ)V", "getColumnCount", "()I", "setColumnCount", "(I)V", "getDefaultSelectIndex", "()Ljava/lang/Integer;", "setDefaultSelectIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEnableClickWhenSelected", "()Z", "setEnableClickWhenSelected", "(Z)V", "getFilterItems", "()Ljava/util/List;", "setFilterItems", "(Ljava/util/List;)V", "getFilterStyle", "setFilterStyle", "getInitRowCount", "setInitRowCount", "getMaxSelectCount", "setMaxSelectCount", "getOnFilterSelectListener", "()Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;", "setOnFilterSelectListener", "(Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;Ljava/util/List;Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;IZ)Lcom/obric/oui/filterpanel/OFilterGroupView$Config;", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "count", "items", "style", "listener", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Config {
        private int columnCount;
        private Integer defaultSelectIndex;
        private boolean enableClickWhenSelected;
        private List<String> filterItems;
        private Integer filterStyle;
        private int initRowCount;
        private Integer maxSelectCount;
        private OnFilterSelectedListener onFilterSelectListener;
        private String title;

        public Config() {
            this(null, null, null, 0, null, null, null, 0, false, 511, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Config copy$default(Config r10, String r11, Integer r12, Integer r13, int r14, Integer r15, List r16, OnFilterSelectedListener r17, int r18, boolean r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            String r2 = r10.title;
        L7:
            if ((r20 & 2) == 0) goto L9;
            Integer r3 = r10.filterStyle;
        L11:
            if ((r20 & 4) == 0) goto L13;
            Integer r4 = r10.maxSelectCount;
        L15:
            if ((r20 & 8) == 0) goto L17;
            int r5 = r10.columnCount;
        L19:
            if ((r20 & 16) == 0) goto L21;
            Integer r6 = r10.defaultSelectIndex;
        L23:
            if ((r20 & 32) == 0) goto L25;
            List r7 = r10.filterItems;
        L27:
            if ((r20 & 64) == 0) goto L29;
            OnFilterSelectedListener r8 = r10.onFilterSelectListener;
        L31:
            if ((r20 & 128) == 0) goto L33;
            int r9 = r10.initRowCount;
        L35:
            if ((r20 & 256) == 0) goto L37;
            boolean r1 = r10.enableClickWhenSelected;
        L39:
            return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
        L37:
            r1 = r19;
            goto L39
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r2 = r11;
            goto L7
        }

        public final String component1() {
            return this.title;
        }

        public final Integer component2() {
            return this.filterStyle;
        }

        public final Integer component3() {
            return this.maxSelectCount;
        }

        public final int component4() {
            return this.columnCount;
        }

        public final Integer component5() {
            return this.defaultSelectIndex;
        }

        public final List<String> component6() {
            return this.filterItems;
        }

        public final OnFilterSelectedListener component7() {
            return this.onFilterSelectListener;
        }

        public final int component8() {
            return this.initRowCount;
        }

        public final boolean component9() {
            return this.enableClickWhenSelected;
        }

        public final Config copy(String r12, Integer r13, Integer r14, int r15, Integer r16, List<String> r17, OnFilterSelectedListener r18, int r19, boolean r20) {
            return new Config(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Config) == true) goto L8;
            return false;
        L8:
            Config r6 = (Config) r5;
            if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.filterStyle, r6.filterStyle) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.maxSelectCount, r6.maxSelectCount) == true) goto L18;
            return false;
        L18:
            if (this.columnCount == r6.columnCount) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.defaultSelectIndex, r6.defaultSelectIndex) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.filterItems, r6.filterItems) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.onFilterSelectListener, r6.onFilterSelectListener) == true) goto L30;
            return false;
        L30:
            if (this.initRowCount == r6.initRowCount) goto L33;
            return false;
        L33:
            if (this.enableClickWhenSelected == r6.enableClickWhenSelected) goto L35;
            return false;
        L35:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2, types: [int] */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4 */
        public int hashCode() {
            String r0 = this.title;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.filterStyle;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.maxSelectCount;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (((r6 + r8) * 31) + Integer.hashCode(this.columnCount)) * 31;
            Integer r10 = this.defaultSelectIndex;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            List<String> r13 = this.filterItems;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            OnFilterSelectedListener r16 = this.onFilterSelectListener;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            int r17 = (((r15 + r1) * 31) + Integer.hashCode(this.initRowCount)) * 31;
            boolean r18 = this.enableClickWhenSelected;
            ?? r19 = r18;
            if (r18 == false) goto L30;
            r19 = 1;
        L30:
            return r17 + r19;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Config(title=" + this.title + ", filterStyle=" + this.filterStyle + ", maxSelectCount=" + this.maxSelectCount + ", columnCount=" + this.columnCount + ", defaultSelectIndex=" + this.defaultSelectIndex + ", filterItems=" + this.filterItems + ", onFilterSelectListener=" + this.onFilterSelectListener + ", initRowCount=" + this.initRowCount + ", enableClickWhenSelected=" + this.enableClickWhenSelected + ')';
        }

        public Config(String r1, Integer r2, Integer r3, int r4, Integer r5, List<String> r6, OnFilterSelectedListener r7, int r8, boolean r9) {
            this.title = r1;
            this.filterStyle = r2;
            this.maxSelectCount = r3;
            this.columnCount = r4;
            this.defaultSelectIndex = r5;
            this.filterItems = r6;
            this.onFilterSelectListener = r7;
            this.initRowCount = r8;
            this.enableClickWhenSelected = r9;
        }

        public /* synthetic */ Config(String r2, Integer r3, Integer r4, int r5, Integer r6, List r7, OnFilterSelectedListener r8, int r9, boolean r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r11 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r11 & 8) == 0) goto L15;
            r5 = 3;
        L15:
            if ((r11 & 16) == 0) goto L18;
            r6 = null;
        L18:
            if ((r11 & 32) == 0) goto L21;
            r7 = null;
        L21:
            if ((r11 & 64) == 0) goto L24;
            r8 = null;
        L24:
            if ((r11 & 128) == 0) goto L27;
            r9 = Integer.MAX_VALUE;
        L27:
            if ((r11 & 256) == 0) goto L29;
            r10 = true;
        L29:
            this(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        }

        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: setTitle, reason: collision with other method in class */
        public final void m1189setTitle(String r1) {
            this.title = r1;
        }

        public final Integer getFilterStyle() {
            return this.filterStyle;
        }

        public final void setFilterStyle(Integer r1) {
            this.filterStyle = r1;
        }

        public final Integer getMaxSelectCount() {
            return this.maxSelectCount;
        }

        public final void setMaxSelectCount(Integer r1) {
            this.maxSelectCount = r1;
        }

        public final int getColumnCount() {
            return this.columnCount;
        }

        /* JADX INFO: renamed from: setColumnCount, reason: collision with other method in class */
        public final void m1186setColumnCount(int r1) {
            this.columnCount = r1;
        }

        public final Integer getDefaultSelectIndex() {
            return this.defaultSelectIndex;
        }

        public final void setDefaultSelectIndex(Integer r1) {
            this.defaultSelectIndex = r1;
        }

        public final List<String> getFilterItems() {
            return this.filterItems;
        }

        /* JADX INFO: renamed from: setFilterItems, reason: collision with other method in class */
        public final void m1187setFilterItems(List<String> r1) {
            this.filterItems = r1;
        }

        public final OnFilterSelectedListener getOnFilterSelectListener() {
            return this.onFilterSelectListener;
        }

        /* JADX INFO: renamed from: setOnFilterSelectListener, reason: collision with other method in class */
        public final void m1188setOnFilterSelectListener(OnFilterSelectedListener r1) {
            this.onFilterSelectListener = r1;
        }

        public final int getInitRowCount() {
            return this.initRowCount;
        }

        public final void setInitRowCount(int r1) {
            this.initRowCount = r1;
        }

        public final boolean getEnableClickWhenSelected() {
            return this.enableClickWhenSelected;
        }

        public final void setEnableClickWhenSelected(boolean r1) {
            this.enableClickWhenSelected = r1;
        }

        public final Config setTitle(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            m1189setTitle(r2);
            return this;
        }

        public final Config setFilterStyle(int r2) {
            setFilterStyle(Integer.valueOf(r2));
            return this;
        }

        public final Config setMaxSelectCount(int r2) {
            setMaxSelectCount(Integer.valueOf(r2));
            return this;
        }

        public final Config setFilterItems(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "items");
            m1187setFilterItems(r2);
            return this;
        }

        public final Config setOnFilterSelectListener(OnFilterSelectedListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            m1188setOnFilterSelectListener(r2);
            return this;
        }

        public final Config setColumnCount(int r2) {
            m1186setColumnCount(r2);
            return this;
        }
    }

    /* JADX INFO: compiled from: OFilterPanelView.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterClickedListener;", "", "onFilterClicked", "", "filter", "Lcom/obric/oui/filter/OFilter;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFilterClickedListener {
        void onFilterClicked(OFilter r1);
    }

    /* JADX INFO: compiled from: OFilterPanelView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterDataChangeListener;", "", "onDataChange", "", "items", "", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFilterDataChangeListener {
        void onDataChange(List<? extends CharSequence> r1);
    }

    /* JADX INFO: compiled from: OFilterPanelView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;", "", "onFilterSelected", "", "filter", "Lcom/obric/oui/filter/OFilter;", "onFilterUnselected", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFilterSelectedListener {
        void onFilterSelected(OFilter r1);

        void onFilterUnselected(OFilter r1);
    }

    public static /* synthetic */ void $r8$lambda$Pk_iy4cmMZ89IHEc2Ov4kEgWjq0(OFilterGroupView r0, OFilter r1, View r2) {
        m1185addFilterItems$lambda2$lambda1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$aeWq4a7NdxVN2l4VD0d-DHvTeFo, reason: not valid java name */
    public static /* synthetic */ void m1183$r8$lambda$aeWq4a7NdxVN2l4VD0dDHvTeFo(OFilterGroupView r0, Context r1, View r2) {
        m1184_init_$lambda0(r0, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OFilterGroupView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OFilterGroupView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ OnFilterSelectedListener access$getOnFilterSelectedListener$p(OFilterGroupView r0) {
        return r0.onFilterSelectedListener;
    }

    public OFilterGroupView(final Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        this.TAG = "OFilterPanelView";
        this.maxSelectCount = 1;
        this.columnCount = 3;
        this.lessFiltersList = new ArrayList();
        this.moreFiltersList = new ArrayList();
        this.filtersList = new ArrayList();
        this.enableClickWhenSelected = true;
        ConstraintLayout.inflate(r4, R.layout.o_layout_filter_group_view, this);
        OFilterGroupView r6 = this;
        setPadding(OUnitExtensionKt.vdp(r6, 16), 0, OUnitExtensionKt.vdp(r6, 16), OUnitExtensionKt.vdp(r6, 16));
        View r7 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) r7;
        TextView r8 = (TextView) findViewById(R.id.tv_show_more);
        this.tvShowMore = r8;
        View r0 = findViewById(R.id.grid_layout);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.grid_layout)");
        this.gridLayout = (GridLayout) r0;
        r8.setOnClickListener(new OFilterGroupView$$ExternalSyntheticLambda0(this, r4));
    }

    public final GridLayout getGridLayout() {
        return this.gridLayout;
    }

    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    private static final void m1184_init_$lambda0(OFilterGroupView r1, Context r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$context");
        r1.gridLayout.removeAllViews();
        if (r1.showingMore == false) goto L9;
        TextView r4 = r1.tvShowMore;
        if (r4 == null) goto L8;
        r4.setText(r2.getResources().getString(R.string.oui_show_more));
    L8:
        r1.addFilterItems(r1.lessFiltersList, r1.columnCount);
        r1.showingMore = false;
        return;
    L9:
        TextView r5 = r1.tvShowMore;
        if (r5 == null) goto L13;
        r5.setText(r2.getResources().getString(R.string.oui_show_less));
    L13:
        r1.addFilterItems(r1.moreFiltersList, r1.columnCount);
        r1.showingMore = true;
    }

    public final void setTitle(CharSequence r1) {
        this.tvTitle.setText(r1);
    }

    public final TextView getTitle() {
        return this.tvTitle;
    }

    public static /* synthetic */ void setFilterItems$default(OFilterGroupView r0, List r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 3;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = Integer.MAX_VALUE;
    L8:
        r0.setFilterItems(r1, r2, r3);
    }

    public final void setFilterItems(List<? extends CharSequence> r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "items");
        this.columnCount = r5;
        this.gridLayout.setAlignmentMode(0);
        this.gridLayout.setColumnCount(r5);
        this.gridLayout.setRowCount(((r4.size() + r5) - 1) / r5);
        if ((((r4.size() - 1) / r5) + 1) <= r6) goto L8;
        this.moreFiltersList.addAll(r4);
        List<? extends CharSequence> r7 = r4.subList(0, r6 * r5);
        this.lessFiltersList.addAll(r7);
        addFilterItems(r7, r5);
        TextView r3 = this.tvShowMore;
        if (r3 == null) goto L11;
        r3.setVisibility(0);
        return;
    L11:
        return;
    L8:
        addFilterItems(r4, r5);
    }

    static /* synthetic */ void addFilterItems$default(OFilterGroupView r0, List r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 3;
    L5:
        r0.addFilterItems(r1, r2);
    }

    private final void addFilterItems(List<? extends CharSequence> r14, int r15) {
        this.filtersList.clear();
        this.curFiltersList = r14;
        Iterator<T> r0 = r14.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        GridLayout.LayoutParams r5 = new GridLayout.LayoutParams();
        r5.height = -2;
        r5.width = 0;
        OFilterGroupView r6 = this;
        r5.rightMargin = OUnitExtensionKt.vdp(r6, 8);
        r5.topMargin = OUnitExtensionKt.vdp(r6, 5);
        r5.setGravity(17);
        r5.columnSpec = GridLayout.spec(r2 % r15, 1.0f);
        r5.rowSpec = GridLayout.spec(r2 / r15, 1.0f);
        Context r7 = getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        final OFilter r8 = new OFilter(r7, null, 0, true, 6, null);
        r8.setText((CharSequence) r3);
        r8.setStyle(this.filterStyle, true);
        r8.setSelectChangeListener(new OFilterGroupView$addFilterItems$1$1(this));
        r8.setOnClickListener(new OFilterGroupView$$ExternalSyntheticLambda1(this, r8));
        this.filtersList.add(r8);
        getGridLayout().addView(r8, r5);
        r2 = r4;
        goto L4
    L9:
        OnFilterDataChangeListener r13 = this.onFilterDataChangeListener;
        if (r13 == null) goto L17;
        r13.onDataChange(r14);
        return;
    }

    /* JADX INFO: renamed from: addFilterItems$lambda-2$lambda-1, reason: not valid java name */
    private static final void m1185addFilterItems$lambda2$lambda1(OFilterGroupView r2, OFilter r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$oFilter");
        if (r4.isSelected() == true) goto L5;
    L9:
        if (r4 == null) goto L17;
        r2.select((OFilter) r4);
    L11:
        OnFilterClickedListener r5 = r2.onFilterClickedListener;
        if (r5 == null) goto L18;
        r5.onFilterClicked(r3);
        return;
    L18:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.filter.OFilter");
    L5:
        if (r2.maxSelectCount == 1) goto L7;
    L8:
        r3.setSelected(false);
        goto L11
    L7:
        if (r2.enableClickWhenSelected == false) goto L9;
        goto L8
    }

    public final void setMaxSelectCount(int r1) {
        this.maxSelectCount = r1;
    }

    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    public final List<Integer> getSelectedIndexes() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = this.filtersList.iterator();
        int r1 = 0;
    L4:
        if (r4.hasNext() == false) goto L12;
        Object r2 = r4.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OFilter) r2).isSelected() == false) goto L11;
        r0.add(Integer.valueOf(r1));
    L11:
        r1 = r3;
        goto L4
    L12:
        return r0;
    }

    public final List<OFilter> getSelectedFilters() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r3 = this.filtersList.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        OFilter r1 = (OFilter) r3.next();
        if (r1.isSelected() == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public final void registerFilterSelectedListener(OnFilterSelectedListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.onFilterSelectedListener = r2;
    }

    public final void registerFilterDataChangeListener(OnFilterDataChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.onFilterDataChangeListener = r2;
        List<? extends CharSequence> r1 = this.curFiltersList;
        if (r1 == null) goto L7;
        r2.onDataChange(r1);
        return;
    }

    public final void registerFilterClickedListener(OnFilterClickedListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.onFilterClickedListener = r2;
    }

    public static /* synthetic */ void setFilterStyle$default(OFilterGroupView r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.setFilterStyle(r1, r2);
    }

    public final void setFilterStyle(int r2, boolean r3) {
        this.filterStyle = r2;
        Iterator<T> r1 = this.filtersList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((OFilter) r1.next()).setStyle(r2, r3);
        goto L4
    }

    public final void setEnableClickWhenSelected(boolean r1) {
        this.enableClickWhenSelected = r1;
    }

    public final boolean select(int r4) {
        if (r4 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L12;
    L10:
        return false;
    L12:
        this.filtersList.get(r4).setSelected(true);     // Catch: IndexOutOfBoundsException -> L11
        goto L10
    L5:
        if (r4 >= this.filtersList.size()) goto L7;
        r2 = true;
        goto L8
    }

    public final void unSelectAll() {
        Log.d(this.TAG, "unSelectAll() called");
        Iterator<T> r2 = this.filtersList.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        OFilter r0 = (OFilter) r2.next();
        if (r0.isSelected() == false) goto L4;
        r0.setSelected(false);
        goto L4
    }

    public final void select(OFilter r4) {
        Intrinsics.checkNotNullParameter(r4, "filter");
        if (r4.isSelected() == false) goto L5;
        return;
    L5:
        List<OFilter> r0 = this.filtersList;
        int r2 = 0;
        if ((r0 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L19;
        if (((OFilter) r1.next()).isSelected() == false) goto L12;
        r2 = r2 + 1;
        if (r2 >= 0) goto L12;
        CollectionsKt.throwCountOverflow();
    L19:
        if (r2 < this.maxSelectCount) goto L21;
        unSelectAll();
    L21:
        r4.setSelected(true);
        return;
    L8:
        if (r0.isEmpty() == false) goto L10;
        goto L10
    }
}
