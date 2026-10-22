package com.obric.oui.picker.reels.views;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.popover.SpringInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: WheelView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r*\u0001B\u0018\u0000 \u0098\u00012\u00020\u0001:\u0006\u0098\u0001\u0099\u0001\u009a\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0007H\u0002J\u0010\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020\u0007H\u0002J\b\u0010q\u001a\u00020oH\u0002J\u0018\u0010r\u001a\u00020o2\u0006\u0010s\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u0016H\u0002J\u0018\u0010u\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u0007H\u0002J\n\u0010x\u001a\u0004\u0018\u00010yH\u0002J\b\u0010z\u001a\u00020\u0007H\u0002J\u0010\u0010{\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010|\u001a\u00020\u0007H\u0002J\u0012\u0010}\u001a\u00020o2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010~\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0014\u0010\u007f\u001a\u00020o2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0014J\u001b\u0010\u0082\u0001\u001a\u00020o2\u0007\u0010\u0083\u0001\u001a\u00020\u00072\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u0085\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0086\u0001\u001a\u00020oH\u0002J\t\u0010\u0087\u0001\u001a\u00020oH\u0002J\u0019\u0010\u000f\u001a\u00020o2\u0006\u0010\u000b\u001a\u00020\u00072\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u0016J%\u0010\u0089\u0001\u001a\u00020o2\u0016\u0010\u008a\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u008c\u00010\u008b\u0001\"\u00030\u008c\u0001¢\u0006\u0003\u0010\u008d\u0001J\u001a\u0010\u0089\u0001\u001a\u00020o2\u0011\u0010\u008a\u0001\u001a\f\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u008e\u0001J#\u0010\u0089\u0001\u001a\u00020o2\u0011\u0010\u008a\u0001\u001a\f\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u0007J,\u0010\u0090\u0001\u001a\u00020o2\u000e\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u008e\u00012\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010\u0092\u0001J\u0017\u0010\u0093\u0001\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u0016J\u0010\u0010\u0094\u0001\u001a\u00020o2\u0007\u0010\u0095\u0001\u001a\u00020\u0012J\t\u0010\u0096\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u0097\u0001\u001a\u00020oH\u0002R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010%\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010R\u0011\u0010(\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b)\u0010\u000eR\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00101\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u0010\u0010R\u000e\u00104\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010CR$\u0010D\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u000e\"\u0004\bF\u0010\u0010R$\u0010G\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000e\"\u0004\bI\u0010\u0010R\u000e\u0010J\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010K\u001a\u0002002\u0006\u0010 \u001a\u0002008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001d\"\u0004\bR\u0010\u001fR$\u0010S\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010\u000e\"\u0004\bU\u0010\u0010R\u000e\u0010V\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010W\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\\\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010]\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010\u000e\"\u0004\b_\u0010\u0010R$\u0010`\u001a\u0002002\u0006\u0010 \u001a\u0002008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010M\"\u0004\bb\u0010OR\u000e\u0010c\u001a\u00020dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010g\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0014\"\u0004\bi\u0010jR\u000e\u0010k\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009b\u0001"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/obric/oui/picker/reels/views/WheelView$WheelAdapter;", "index", "currentIndex", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "currentItem", "", "getCurrentItem", "()Ljava/lang/CharSequence;", "hasSettledSinceDrag", "", "highlightConorRadiusPx", "getHighlightConorRadiusPx", "setHighlightConorRadiusPx", "horizontalPaddingPx", "cyclic", "isCyclic", "()Z", "setCyclic", "(Z)V", "value", "itemCount", "getItemCount", "setItemCount", "itemHeight", "itemHeightPx", "getItemHeightPx", "setItemHeightPx", "itemSize", "getItemSize", "lastCenterIndex", "lastChangedDataIndex", "lastHapticIndex", "layoutManager", "Lcom/obric/oui/picker/reels/views/WheelLayoutManager;", "maxTextWidth", "", "normalTextColor", "getNormalTextColor", "setNormalTextColor", "normalTextSizePx", "onWheelChangedListener", "Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;", "getOnWheelChangedListener", "()Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;", "setOnWheelChangedListener", "(Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;)V", "pendingInitialIndex", "pendingInitialScrollPosition", "pendingVerifyCenterAdapterPosition", "programmaticScrolling", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "scrollListener", "com/obric/oui/picker/reels/views/WheelView$scrollListener$1", "Lcom/obric/oui/picker/reels/views/WheelView$scrollListener$1;", "selectedItemHeightPx", "getSelectedItemHeightPx", "setSelectedItemHeightPx", "selectedTextColor", "getSelectedTextColor", "setSelectedTextColor", "selectedTextSizePx", "selectedTextSizePxProp", "getSelectedTextSizePxProp", "()F", "setSelectedTextSizePxProp", "(F)V", "showDivider", "getShowDivider", "setShowDivider", "startIndex", "getStartIndex", "setStartIndex", "suppressNextSnapOnce", "tagGap", "getTagGap", "()Ljava/lang/Integer;", "setTagGap", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "textColor", "getTextColor", "setTextColor", "textSizePx", "getTextSizePx", "setTextSizePx", "tvTag", "Landroid/widget/TextView;", "userScrolling", "visibleRowCount", "wheelTagText", "getWheelTagText", "setWheelTagText", "(Ljava/lang/CharSequence;)V", "wheelTextSizePx", "adapterToDataIndex", "adapterPos", "animateMove", "", "delta", "applyPendingInitialSelection", "centerToPosition", "position", "animate", "dataToAdapterPosition", "dataIndex", "dataSize", "findCenterChild", "Landroid/view/View;", "findNearestCenterIndex", "getItem", "halfRows", "initAttrs", "isValidDataIndex", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "recyclerCenterY", "refreshDimensionCache", "scheduleInitialSelectionIfNeeded", "animated", "setEntries", "entries", "", "", "([Ljava/lang/String;)V", "", "selectedIndex", "setItems", "items", "(Ljava/util/List;Ljava/lang/Integer;)V", "setSelectedIndex", "setTagText", "tag", "snapToNearestCenter", "updateRecyclerPaddingForCenter", "Companion", "WheelAdapter", "WheelVH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WheelView extends FrameLayout {
    public static final Companion Companion = null;
    public static final int REPEAT = 1000;
    public static final float TAG_TEXT_SIZE = 14.0f;
    public static final int VISIBLE_ROW_COUNT = 5;
    public static final float WHEEL_TEXT_SIZE = 22.0f;
    private final WheelAdapter adapter;
    private boolean hasSettledSinceDrag;
    private int highlightConorRadiusPx;
    private int horizontalPaddingPx;
    private boolean isCyclic;
    private int itemHeight;
    private int lastCenterIndex;
    private int lastChangedDataIndex;
    private int lastHapticIndex;
    private final WheelLayoutManager layoutManager;
    private float maxTextWidth;
    private int normalTextColor;
    private float normalTextSizePx;
    private OnWheelChangedListener onWheelChangedListener;
    private int pendingInitialIndex;
    private int pendingInitialScrollPosition;
    private int pendingVerifyCenterAdapterPosition;
    private boolean programmaticScrolling;
    private final RecyclerView recyclerView;
    private final WheelView$scrollListener$1 scrollListener;
    private int selectedTextColor;
    private float selectedTextSizePx;
    private boolean showDivider;
    private boolean suppressNextSnapOnce;
    private Integer tagGap;
    private final TextView tvTag;
    private boolean userScrolling;
    private int visibleRowCount;
    private CharSequence wheelTagText;
    private float wheelTextSizePx;

    /* JADX INFO: compiled from: WheelView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelView$Companion;", "", "()V", "REPEAT", "", "TAG_TEXT_SIZE", "", "VISIBLE_ROW_COUNT", "WHEEL_TEXT_SIZE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: WheelView.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0014\u0010\u0014\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelView$WheelAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/picker/reels/views/WheelView$WheelVH;", "(Lcom/obric/oui/picker/reels/views/WheelView;)V", "items", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "data", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class WheelAdapter extends RecyclerView.Adapter<WheelVH> {
        private final ArrayList<CharSequence> items;
        final /* synthetic */ WheelView this$0;

        /* JADX INFO: renamed from: $r8$lambda$-hiUQtXCVHVcc7PeTm4UTxaKV2s, reason: not valid java name */
        public static /* synthetic */ void m1276$r8$lambda$hiUQtXCVHVcc7PeTm4UTxaKV2s(WheelVH r0, WheelView r1, View r2) {
            m1278onBindViewHolder$lambda1(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$HpN9wxXpLkJX-D57GBYDCDDOCE0, reason: not valid java name */
        public static /* synthetic */ void m1277$r8$lambda$HpN9wxXpLkJXD57GBYDCDDOCE0(WheelVH r0, WheelView r1, View r2) {
            m1279onBindViewHolder$lambda2(r0, r1, r2);
        }

        public WheelAdapter(WheelView r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            this.items = new ArrayList();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            onBindViewHolder((WheelVH) r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
            return onCreateViewHolder(r1, r2);
        }

        public final ArrayList<CharSequence> getItems() {
            return this.items;
        }

        public final void setItems(List<? extends CharSequence> r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.items.clear();
            this.items.addAll(r2);
            notifyDataSetChanged();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public WheelVH onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            TextView r5 = new TextView(r3.getContext());
            WheelView r2 = this.this$0;
            r5.setId(R.id.text1);
            r5.setLayoutParams(new RecyclerView.LayoutParams(-1, WheelView.access$getItemHeight$p(r2)));
            r5.setGravity(17);
            r5.setTextSize(0, WheelView.access$getWheelTextSizePx$p(r2));
            r5.setIncludeFontPadding(false);
            return new WheelVH(r5);
        }

        public void onBindViewHolder(final WheelVH r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "holder");
            int r6 = WheelView.access$adapterToDataIndex(this.this$0, r5);
            if (this.this$0.isCyclic() == false) goto L6;
            r4.getText().setAlpha(1.0f);
            r4.getText().setTextSize(0, WheelView.access$getWheelTextSizePx$p(this.this$0));
            r4.getText().setText(this.items.get(r6));
            View r7 = r4.itemView;
            final WheelView r3 = this.this$0;
            r7.setOnClickListener(new WheelView$WheelAdapter$$ExternalSyntheticLambda0(r4, r3));
            return;
        L6:
            if (WheelView.access$isValidDataIndex(this.this$0, r6) == false) goto L8;
            r4.getText().setAlpha(1.0f);
            r4.getText().setTextSize(0, WheelView.access$getWheelTextSizePx$p(this.this$0));
            r4.getText().setText(this.items.get(r6));
            View r8 = r4.itemView;
            final WheelView r9 = this.this$0;
            r8.setOnClickListener(new WheelView$WheelAdapter$$ExternalSyntheticLambda1(r4, r9));
            return;
        L8:
            r4.getText().setAlpha(0.0f);
            r4.getText().setText("");
            r4.itemView.setOnClickListener(null);
        }

        /* JADX INFO: renamed from: onBindViewHolder$lambda-1, reason: not valid java name */
        private static final void m1278onBindViewHolder$lambda1(WheelVH r0, WheelView r1, View r2) {
            Intrinsics.checkNotNullParameter(r0, "$holder");
            Intrinsics.checkNotNullParameter(r1, "this$0");
            int r3 = r0.getAdapterPosition();
            if (r3 == (-1)) goto L8;
            int r4 = WheelView.access$adapterToDataIndex(r1, r3);
            if (WheelView.access$isValidDataIndex(r1, r4) == false) goto L9;
            r1.setSelectedIndex(r4, true);
            return;
        L9:
            return;
        }

        /* JADX INFO: renamed from: onBindViewHolder$lambda-2, reason: not valid java name */
        private static final void m1279onBindViewHolder$lambda2(WheelVH r0, WheelView r1, View r2) {
            Intrinsics.checkNotNullParameter(r0, "$holder");
            Intrinsics.checkNotNullParameter(r1, "this$0");
            int r3 = r0.getAdapterPosition();
            if (r3 == (-1)) goto L8;
            int r4 = WheelView.access$adapterToDataIndex(r1, r3);
            if (WheelView.access$isValidDataIndex(r1, r4) == false) goto L9;
            r1.setSelectedIndex(r4, true);
            return;
        L9:
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int r0 = this.items.size();
            if (r0 != 0) goto L7;
            return 0;
        L7:
            if (this.this$0.isCyclic() == false) goto L10;
            return r0 * 1000;
        L10:
            return r0 + (WheelView.access$halfRows(this.this$0) * 2);
        }
    }

    /* JADX INFO: compiled from: WheelView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelView$WheelVH;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class WheelVH extends RecyclerView.ViewHolder {
        private final TextView text;

        public WheelVH(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            View r3 = r2.findViewById(R.id.text1);
            Intrinsics.checkNotNullExpressionValue(r3, "itemView.findViewById(android.R.id.text1)");
            this.text = (TextView) r3;
        }

        public final TextView getText() {
            return this.text;
        }
    }

    public static /* synthetic */ void $r8$lambda$VS3Xi1CyPKGWLO94txn69VTpgHo(WheelView r0) {
        m1275setItems$lambda6(r0);
    }

    public static /* synthetic */ void $r8$lambda$toCAjgMsRAXHyeV5CDigBN6ANes(WheelView r0) {
        m1273_init_$lambda0(r0);
    }

    public static /* synthetic */ void $r8$lambda$y6wEQn5FkPvsTz7M1m__J20kjNE(WheelView r0, int r1) {
        m1274centerToPosition$lambda7(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public WheelView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public WheelView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ WheelView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ int access$adapterToDataIndex(WheelView r0, int r1) {
        return r0.adapterToDataIndex(r1);
    }

    public static final /* synthetic */ void access$centerToPosition(WheelView r0, int r1, boolean r2) {
        r0.centerToPosition(r1, r2);
    }

    public static final /* synthetic */ int access$findNearestCenterIndex(WheelView r0) {
        return r0.findNearestCenterIndex();
    }

    public static final /* synthetic */ WheelAdapter access$getAdapter$p(WheelView r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ boolean access$getHasSettledSinceDrag$p(WheelView r0) {
        return r0.hasSettledSinceDrag;
    }

    public static final /* synthetic */ int access$getItemHeight$p(WheelView r0) {
        return r0.itemHeight;
    }

    public static final /* synthetic */ int access$getLastChangedDataIndex$p(WheelView r0) {
        return r0.lastChangedDataIndex;
    }

    public static final /* synthetic */ int access$getLastHapticIndex$p(WheelView r0) {
        return r0.lastHapticIndex;
    }

    public static final /* synthetic */ int access$getPendingVerifyCenterAdapterPosition$p(WheelView r0) {
        return r0.pendingVerifyCenterAdapterPosition;
    }

    public static final /* synthetic */ boolean access$getProgrammaticScrolling$p(WheelView r0) {
        return r0.programmaticScrolling;
    }

    public static final /* synthetic */ boolean access$getSuppressNextSnapOnce$p(WheelView r0) {
        return r0.suppressNextSnapOnce;
    }

    public static final /* synthetic */ boolean access$getUserScrolling$p(WheelView r0) {
        return r0.userScrolling;
    }

    public static final /* synthetic */ float access$getWheelTextSizePx$p(WheelView r0) {
        return r0.wheelTextSizePx;
    }

    public static final /* synthetic */ int access$halfRows(WheelView r0) {
        return r0.halfRows();
    }

    public static final /* synthetic */ boolean access$isValidDataIndex(WheelView r0, int r1) {
        return r0.isValidDataIndex(r1);
    }

    public static final /* synthetic */ void access$setHasSettledSinceDrag$p(WheelView r0, boolean r1) {
        r0.hasSettledSinceDrag = r1;
    }

    public static final /* synthetic */ void access$setLastCenterIndex$p(WheelView r0, int r1) {
        r0.lastCenterIndex = r1;
    }

    public static final /* synthetic */ void access$setLastChangedDataIndex$p(WheelView r0, int r1) {
        r0.lastChangedDataIndex = r1;
    }

    public static final /* synthetic */ void access$setLastHapticIndex$p(WheelView r0, int r1) {
        r0.lastHapticIndex = r1;
    }

    public static final /* synthetic */ void access$setPendingVerifyCenterAdapterPosition$p(WheelView r0, int r1) {
        r0.pendingVerifyCenterAdapterPosition = r1;
    }

    public static final /* synthetic */ void access$setProgrammaticScrolling$p(WheelView r0, boolean r1) {
        r0.programmaticScrolling = r1;
    }

    public static final /* synthetic */ void access$setSuppressNextSnapOnce$p(WheelView r0, boolean r1) {
        r0.suppressNextSnapOnce = r1;
    }

    public static final /* synthetic */ void access$setUserScrolling$p(WheelView r0, boolean r1) {
        r0.userScrolling = r1;
    }

    public static final /* synthetic */ boolean access$snapToNearestCenter(WheelView r0) {
        return r0.snapToNearestCenter();
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [com.obric.oui.picker.reels.views.WheelView$scrollListener$1] */
    public WheelView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        WheelLayoutManager r9 = new WheelLayoutManager(r6);
        this.layoutManager = r9;
        WheelAdapter r0 = new WheelAdapter(this);
        this.adapter = r0;
        WheelView r1 = this;
        this.itemHeight = OUnitExtensionKt.vdp(r1, 50.0f);
        this.visibleRowCount = 5;
        this.wheelTextSizePx = OUnitExtensionKt.vdpFloat(r1, 22.0f);
        this.normalTextSizePx = OUnitExtensionKt.vdpFloat(r1, 22.0f);
        this.selectedTextSizePx = OUnitExtensionKt.vdpFloat(r1, 22.0f);
        this.lastHapticIndex = -1;
        this.lastCenterIndex = -1;
        this.lastChangedDataIndex = -1;
        this.pendingInitialScrollPosition = -1;
        this.pendingVerifyCenterAdapterPosition = -1;
        this.highlightConorRadiusPx = OUnitExtensionKt.vdp(r1, 8);
        this.selectedTextColor = ContextCompat.getColor(r6, com.obric.common.oui.R.color.oui_accent_6_bg);
        this.normalTextColor = ContextCompat.getColor(r6, com.obric.common.oui.R.color.oui_basic_text_1);
        ?? r2 = new WheelView$scrollListener$1(this);
        this.scrollListener = r2;
        refreshDimensionCache();
        FrameLayout.inflate(r6, com.obric.common.oui.R.layout.o_wheel_view, this);
        setTagGap(Integer.valueOf(OUnitExtensionKt.vdp(r1, 2)));
        View r10 = findViewById(com.obric.common.oui.R.id.recycler);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.recycler)");
        RecyclerView r11 = (RecyclerView) r10;
        this.recyclerView = r11;
        View r3 = findViewById(com.obric.common.oui.R.id.tv_tag);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.tv_tag)");
        this.tvTag = (TextView) r3;
        r11.setLayoutManager(r9);
        r9.setHeadTailPaddingItems(halfRows());
        r11.setAdapter(r0);
        r11.setClipToPadding(false);
        r11.setOverScrollMode(0);
        r11.addOnScrollListener((RecyclerView.OnScrollListener) r2);
        r11.getViewTreeObserver().addOnGlobalLayoutListener(new WheelView$$ExternalSyntheticLambda1(this));
        initAttrs(r7);
    }

    public final boolean getShowDivider() {
        return this.showDivider;
    }

    public final void setShowDivider(boolean r1) {
        this.showDivider = r1;
    }

    public final int getHighlightConorRadiusPx() {
        return this.highlightConorRadiusPx;
    }

    public final void setHighlightConorRadiusPx(int r1) {
        this.highlightConorRadiusPx = r1;
    }

    public final boolean isCyclic() {
        return this.isCyclic;
    }

    public final void setCyclic(boolean r2) {
        this.isCyclic = r2;
        this.layoutManager.setCyclic(r2);
        WheelLayoutManager r0 = this.layoutManager;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setHeadTailPaddingItems(r3);
        requestLayout();
        return;
    L5:
        r3 = halfRows();
        goto L6
    }

    public final CharSequence getWheelTagText() {
        return this.wheelTagText;
    }

    public final void setWheelTagText(CharSequence r1) {
        this.wheelTagText = r1;
    }

    public final Integer getTagGap() {
        return this.tagGap;
    }

    public final void setTagGap(Integer r1) {
        this.tagGap = r1;
        requestLayout();
    }

    public final int getSelectedTextColor() {
        return this.selectedTextColor;
    }

    public final void setSelectedTextColor(int r2) {
        this.selectedTextColor = r2;
        this.layoutManager.setSelectedTextColor(r2);
        this.recyclerView.requestLayout();
    }

    public final int getNormalTextColor() {
        return this.normalTextColor;
    }

    public final void setNormalTextColor(int r2) {
        this.normalTextColor = r2;
        this.layoutManager.setNormalTextColor(r2);
        this.recyclerView.requestLayout();
    }

    public final OnWheelChangedListener getOnWheelChangedListener() {
        return this.onWheelChangedListener;
    }

    public final void setOnWheelChangedListener(OnWheelChangedListener r1) {
        this.onWheelChangedListener = r1;
    }

    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    private static final void m1273_init_$lambda0(WheelView r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.updateRecyclerPaddingForCenter();
        r1.applyPendingInitialSelection();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
        requestLayout();
    }

    private final void refreshDimensionCache() {
        this.horizontalPaddingPx = OUnitExtensionKt.vdp(this, 28);
    }

    private final void initAttrs(AttributeSet r18) {
        TypedArray r1 = getContext().obtainStyledAttributes(r18, com.obric.common.oui.R.styleable.OWheelView);
        Intrinsics.checkNotNullExpressionValue(r1, "context.obtainStyledAttr…, R.styleable.OWheelView)");
        boolean r2 = r1.getBoolean(com.obric.common.oui.R.styleable.OWheelView_oui_wheelCyclic, false);
        int r4 = r1.getInt(com.obric.common.oui.R.styleable.OWheelView_oui_wheelStartIndex, 0);
        int r5 = r1.getInt(com.obric.common.oui.R.styleable.OWheelView_oui_wheelItemCount, 5);
        WheelView r7 = this;
        int r6 = r1.getDimensionPixelOffset(com.obric.common.oui.R.styleable.OWheelView_oui_wheelItemHeight, OUnitExtensionKt.vdp(r7, 50));
        int r8 = r1.getDimensionPixelSize(com.obric.common.oui.R.styleable.OWheelView_oui_wheelTextSize, OUnitExtensionKt.vdp(r7, 22.0f));
        int r10 = r1.getDimensionPixelSize(com.obric.common.oui.R.styleable.OWheelView_oui_wheelTextSize, OUnitExtensionKt.vdp(r7, 14.0f));
        int r11 = r1.getColor(com.obric.common.oui.R.styleable.OWheelView_oui_wheelTextColor, ContextCompat.getColor(getContext(), com.obric.common.res.R.color.oui_basic_text_1));
        int r12 = r1.getColor(com.obric.common.oui.R.styleable.OWheelView_oui_wheelSelectedTextColor, ContextCompat.getColor(getContext(), com.obric.common.res.R.color.oui_accent_6_bg));
        int r9 = r1.getDimensionPixelSize(com.obric.common.oui.R.styleable.OWheelView_oui_wheelSelectedTextSize, OUnitExtensionKt.vdp(r7, 22.0f));
        CharSequence[] r13 = r1.getTextArray(com.obric.common.oui.R.styleable.OWheelView_oui_wheelEntries);
        if (r13 != null) goto L5;
        ArrayList r14 = null;
    L9:
        r1.recycle();
        setCyclic(r2);
        this.pendingInitialIndex = r4;
        this.visibleRowCount = r5;
        this.itemHeight = r6;
        float r3 = r8;
        this.normalTextSizePx = r3;
        float r15 = r9;
        this.selectedTextSizePx = r15;
        this.wheelTextSizePx = RangesKt.coerceAtLeast(r15, r3);
        setSelectedTextColor(r12);
        this.tvTag.setTextSize(0, r10);
        this.tvTag.setTextColor(r11);
        if (r14 == null) goto L12;
        setItems$default(this, r14, null, 2, null);
        return;
    L12:
        scheduleInitialSelectionIfNeeded();
        return;
    L5:
        ArrayList r16 = new ArrayList(r13.length);
        int r17 = r13.length;
        int r19 = 0;
    L6:
        if (r19 >= r17) goto L8;
        r16.add(r13[r19].toString());
        r19 = r19 + 1;
        goto L6
    L8:
        r14 = r16;
        goto L9
    }

    public final int getStartIndex() {
        return this.pendingInitialIndex;
    }

    public final void setStartIndex(int r3) {
        this.pendingInitialIndex = r3;
        if (this.adapter.getItems().size() <= 0) goto L6;
        setSelectedIndex(RangesKt.coerceIn(r3, 0, this.adapter.getItems().size() - 1), false);
        return;
    }

    public final int getItemCount() {
        return this.visibleRowCount;
    }

    public final void setItemCount(int r2) {
        this.visibleRowCount = r2;
        WheelLayoutManager r3 = this.layoutManager;
        if (this.isCyclic == false) goto L5;
        int r0 = 0;
    L6:
        r3.setHeadTailPaddingItems(r0);
        requestLayout();
        return;
    L5:
        r0 = halfRows();
        goto L6
    }

    public final int getItemHeightPx() {
        return this.itemHeight;
    }

    public final void setItemHeightPx(int r1) {
        this.itemHeight = r1;
        this.adapter.notifyDataSetChanged();
        requestLayout();
    }

    public final int getSelectedItemHeightPx() {
        return this.itemHeight;
    }

    public final void setSelectedItemHeightPx(int r1) {
        this.itemHeight = r1;
        this.adapter.notifyDataSetChanged();
        requestLayout();
    }

    public final float getTextSizePx() {
        return this.normalTextSizePx;
    }

    public final void setTextSizePx(float r2) {
        this.normalTextSizePx = r2;
        this.wheelTextSizePx = Math.max(r2, this.selectedTextSizePx);
        this.adapter.notifyDataSetChanged();
        requestLayout();
    }

    public final int getTextColor() {
        return this.normalTextColor;
    }

    public final void setTextColor(int r1) {
        setNormalTextColor(r1);
    }

    public final float getSelectedTextSizePxProp() {
        return this.selectedTextSizePx;
    }

    public final void setSelectedTextSizePxProp(float r2) {
        this.selectedTextSizePx = r2;
        this.wheelTextSizePx = Math.max(this.normalTextSizePx, r2);
        this.adapter.notifyDataSetChanged();
        requestLayout();
    }

    public final int getItemSize() {
        return this.adapter.getItems().size();
    }

    public final CharSequence getItem(int r1) {
        return (CharSequence) CollectionsKt.getOrNull(this.adapter.getItems(), r1);
    }

    public final int getCurrentIndex() {
        int r0 = findNearestCenterIndex();
        if (r0 != (-1)) goto L5;
        return 0;
    L5:
        int r1 = adapterToDataIndex(r0);
        if (isValidDataIndex(r1) == true) goto L8;
        return 0;
    L8:
        return r1;
    }

    public final void setCurrentIndex(int r2) {
        setCurrentIndex(r2, false);
    }

    public final CharSequence getCurrentItem() {
        return getItem(getCurrentIndex());
    }

    public static /* synthetic */ void setCurrentIndex$default(WheelView r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.setCurrentIndex(r1, r2);
    }

    public final void setCurrentIndex(int r4, boolean r5) {
        int r0 = getCurrentIndex();
        int r6 = setSelectedIndex(r4, r5);
        int r1 = this.adapter.getItems().size();
        if (r1 <= 0) goto L18;
        int r7 = RangesKt.coerceIn(r4, 0, r1 - 1);
        if (r0 == r7) goto L19;
        OnWheelChangedListener r2 = this.onWheelChangedListener;
        if (r2 == null) goto L10;
        r2.onChanged(r0, r7);
    L10:
        OnWheelChangedListener r3 = this.onWheelChangedListener;
        if (r3 == null) goto L14;
        r3.onStopped(r7);
    L14:
        this.lastChangedDataIndex = r7;
        if (r6 == (-1)) goto L20;
        this.lastCenterIndex = r6;
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void setEntries(String... r3) {
        Intrinsics.checkNotNullParameter(r3, "entries");
        setItems$default(this, ArraysKt.toList(r3), null, 2, null);
    }

    public final void setEntries(List<String> r4) {
        if (r4 != null) goto L5;
        ArrayList r1 = null;
    L10:
        if (r1 != null) goto L12;
        r1 = CollectionsKt.emptyList();
    L12:
        setItems$default(this, r1, null, 2, null);
        return;
    L5:
        List<String> r5 = r4;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        r2.add((String) r6.next());
        goto L7
    L9:
        r1 = r2;
        goto L10
    }

    public final void setEntries(List<String> r3, int r4) {
        if (r3 != null) goto L4;
        ArrayList r5 = null;
    L9:
        if (r5 != null) goto L11;
        r5 = CollectionsKt.emptyList();
    L11:
        setItems(r5, Integer.valueOf(r4));
        return;
    L4:
        List<String> r6 = r3;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        r0.add((String) r7.next());
        goto L6
    L8:
        r5 = r0;
        goto L9
    }

    public final void setTagText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.wheelTagText = r2;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        this.tvTag.setVisibility(8);
        return;
    L11:
        this.tvTag.setVisibility(0);
        this.tvTag.setText(this.wheelTagText);
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    private final void scheduleInitialSelectionIfNeeded() {
        int r0 = this.adapter.getItems().size();
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = RangesKt.coerceIn(this.pendingInitialIndex, 0, r0 - 1);
        if (this.isCyclic == false) goto L8;
        int r2 = ((r0 * 1000) / 2) + r1;
    L9:
        this.pendingInitialScrollPosition = r2;
        if (this.recyclerView.getChildCount() <= 0) goto L13;
        applyPendingInitialSelection();
        return;
    L13:
        return;
    L8:
        r2 = halfRows() + r1;
        goto L9
    }

    private final void applyPendingInitialSelection() {
        int r0 = this.pendingInitialScrollPosition;
        if (r0 != (-1)) goto L6;
        return;
    L6:
        if (this.adapter.getItems().size() != 0) goto L9;
        return;
    L9:
        if (this.recyclerView.getChildCount() != 0) goto L11;
        return;
    L11:
        this.pendingInitialScrollPosition = -1;
        centerToPosition(r0, false);
    }

    static /* synthetic */ void setItems$default(WheelView r0, List r1, Integer r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setItems(r1, r2);
    }

    private final void setItems(List<? extends CharSequence> r7, Integer r8) {
        this.pendingVerifyCenterAdapterPosition = -1;
        if (r8 != null) goto L5;
        Integer r9 = null;
    L10:
        if (r9 == null) goto L13;
        this.pendingInitialIndex = r9.intValue();
    L13:
        boolean r1 = !Intrinsics.areEqual(this.adapter.getItems(), r7);
        if (r1 == false) goto L16;
        this.recyclerView.stopScroll();
        this.adapter.setItems(r7);
    L16:
        TextView r2 = new TextView(getContext());
        r2.setTextSize(22.0f);
        TextPaint r3 = r2.getPaint();
        this.maxTextWidth = 0.0f;
        Iterator<? extends CharSequence> r4 = r7.iterator();
    L18:
        if (r4.hasNext() == false) goto L22;
        float r5 = r3.measureText(r4.next().toString());
        if (r5 <= this.maxTextWidth) goto L18;
        this.maxTextWidth = r5;
        goto L18
    L22:
        ViewGroup.LayoutParams r6 = this.tvTag.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L29;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r6;
        int r11 = (int) (this.maxTextWidth / 2.0f);
        Integer r12 = this.tagGap;
        if (r12 != null) goto L27;
        int r13 = 0;
    L28:
        r10.setMarginStart(r11 + (r13 * 2));
        this.tvTag.setLayoutParams(r6);
        goto L29
    L27:
        r13 = r12.intValue();
    L29:
        if (r9 != null) goto L31;
    L37:
        post(new WheelView$$ExternalSyntheticLambda2(this));
        return;
    L31:
        if ((!r7.isEmpty()) == false) goto L37;
        if (r1 == false) goto L36;
        this.pendingInitialScrollPosition = dataToAdapterPosition(r9.intValue(), r7.size());
        if (this.recyclerView.getChildCount() <= 0) goto L37;
        applyPendingInitialSelection();
        goto L37
    L36:
        setSelectedIndex(r9.intValue(), false);
        goto L37
    L5:
        int r14 = r8.intValue();
        if (r7.isEmpty() == true) goto L9;
        r14 = RangesKt.coerceIn(r14, 0, r7.size() - 1);
    L9:
        r9 = Integer.valueOf(r14);
        goto L10
    }

    /* JADX INFO: renamed from: setItems$lambda-6, reason: not valid java name */
    private static final void m1275setItems$lambda6(WheelView r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.requestLayout();
        r2.updateRecyclerPaddingForCenter();
        if (r2.pendingInitialScrollPosition == (-1)) goto L5;
        r2.applyPendingInitialSelection();
        return;
    L5:
        r2.scheduleInitialSelectionIfNeeded();
    }

    public final int setSelectedIndex(int r7, boolean r8) {
        this.pendingInitialScrollPosition = -1;
        this.pendingVerifyCenterAdapterPosition = -1;
        int r1 = this.adapter.getItems().size();
        if (r1 != 0) goto L6;
        this.pendingInitialIndex = r7;
        return -1;
    L6:
        int r9 = RangesKt.coerceIn(r7, 0, r1 - 1);
        this.pendingInitialIndex = r9;
        if (this.isCyclic == false) goto L13;
        int r2 = findNearestCenterIndex();
        if (this.recyclerView.getChildCount() <= 0) goto L12;
        if (r2 == (-1)) goto L12;
        int r0 = this.adapter.getItemCount();
        int r3 = (r2 - (r2 % r1)) + r9;
        Ref.IntRef r10 = new Ref.IntRef();
        r10.element = r3;
        Ref.IntRef r4 = new Ref.IntRef();
        r4.element = Math.abs(r3 - r2);
        setSelectedIndex$tryPos(r0, r2, r4, r10, r3 - r1);
        setSelectedIndex$tryPos(r0, r2, r4, r10, r3 + r1);
        int r11 = r10.element;
    L14:
        centerToPosition(r11, r8);
        return r11;
    L12:
        r11 = r9 + ((r1 * 1000) / 2);
        goto L14
    L13:
        r11 = r9 + halfRows();
        goto L14
    }

    private static final void setSelectedIndex$tryPos(int r1, int r2, Ref.IntRef r3, Ref.IntRef r4, int r5) {
        boolean r0 = false;
        if (r5 < 0) goto L6;
        if (r5 >= r1) goto L6;
        r0 = true;
    L6:
        if (r0 == false) goto L11;
        int r6 = Math.abs(r5 - r2);
        if (r6 >= r3.element) goto L12;
        r4.element = r5;
        r3.element = r6;
        return;
    L12:
        return;
    }

    private final int dataToAdapterPosition(int r3, int r4) {
        int r5 = RangesKt.coerceIn(r3, 0, r4 - 1);
        if (this.isCyclic == false) goto L6;
        return ((r4 * 1000) / 2) + r5;
    L6:
        return r5 + halfRows();
    }

    private final void centerToPosition(final int r2, boolean r3) {
        this.recyclerView.stopScroll();
        if (r3 == false) goto L7;
        this.programmaticScrolling = true;
        this.pendingVerifyCenterAdapterPosition = r2;
        int r4 = this.layoutManager.computeDeltaToCenterAtPosition(r2);
        if (r4 == 0) goto L9;
        animateMove(r4);
        return;
    L9:
        return;
    L7:
        this.programmaticScrolling = true;
        this.recyclerView.scrollToPosition(r2);
        post(new WheelView$$ExternalSyntheticLambda0(this, r2));
    }

    /* JADX INFO: renamed from: centerToPosition$lambda-7, reason: not valid java name */
    private static final void m1274centerToPosition$lambda7(WheelView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        View r0 = r2.layoutManager.findViewByPosition(r3);
        if (r0 == null) goto L7;
        int r4 = ((r0.getTop() + r0.getBottom()) / 2) - r2.recyclerCenterY();
        if (r4 == 0) goto L9;
        r2.recyclerView.scrollBy(0, r4);
        r2.suppressNextSnapOnce = true;
        return;
    L9:
        return;
    L7:
        r2.pendingInitialScrollPosition = r3;
    }

    private final int halfRows() {
        return RangesKt.coerceAtLeast((this.visibleRowCount + 2) / 2, 1);
    }

    private final int adapterToDataIndex(int r3) {
        int r0 = this.adapter.getItems().size();
        if (r0 != 0) goto L7;
        return -1;
    L7:
        if (this.isCyclic == false) goto L12;
        int r4 = r3 % r0;
        if (r4 < 0) goto L14;
        return r4;
    L14:
        return r4 + r0;
    L12:
        return r3 - halfRows();
    }

    private final boolean isValidDataIndex(int r2) {
        if (r2 >= 0) goto L5;
        return false;
    L5:
        if (r2 >= this.adapter.getItems().size()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r5, int r6) {
        View.MeasureSpec.makeMeasureSpec((((int) (((this.itemHeight / ((float) Math.tan(0.5235988f))) * 2.0f) + this.itemHeight)) + getPaddingTop()) + getPaddingBottom(), 1073741824);
        int r0 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        int r2 = Math.max((int) (this.maxTextWidth + this.horizontalPaddingPx), getMinimumWidth());
        if (r0 == Integer.MIN_VALUE) goto L6;
        if (r0 == 1073741824) goto L7;
        r7 = r2;
    L7:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r7, 1073741824), r6);
        return;
    L6:
        r7 = Math.min(r2, r7);
        goto L7
    }

    private final boolean snapToNearestCenter() {
        this.recyclerView.stopScroll();
        int r0 = this.layoutManager.computeSnapDeltaToNearestCenter();
        if (r0 == 0) goto L6;
        this.suppressNextSnapOnce = true;
        animateMove(r0);
        return true;
    L6:
        return false;
    }

    private final void animateMove(int r4) {
        if (r4 == 0) goto L5;
        this.programmaticScrolling = true;
        SpringInterpolator r0 = new SpringInterpolator(0.61f);
        this.recyclerView.smoothScrollBy(0, r4, r0, 400);
        return;
    }

    private final void updateRecyclerPaddingForCenter() {
        if (this.recyclerView.getHeight() > 0) goto L5;
        return;
    L5:
        RecyclerView r0 = this.recyclerView;
        r0.setPadding(r0.getPaddingLeft(), 0, this.recyclerView.getPaddingRight(), 0);
    }

    private final View findCenterChild() {
        int r0 = recyclerCenterY();
        int r1 = this.recyclerView.getChildCount();
        View r2 = null;
        float r3 = Float.MAX_VALUE;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L11;
        r4 = r4 + 1;
        View r5 = this.recyclerView.getChildAt(r4);
        if (r5 == null) goto L3;
        float r6 = Math.abs(((r5.getTop() + r5.getBottom()) / 2.0f) - r0);
        if (r6 >= r3) goto L3;
        r2 = r5;
        r3 = r6;
        goto L3
    L11:
        return r2;
    }

    private final int findNearestCenterIndex() {
        int r0 = this.layoutManager.getNearestCenterAdapterIndex();
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        View r1 = findCenterChild();
        if (r1 != null) goto L9;
        return -1;
    L9:
        return this.recyclerView.getChildAdapterPosition(r1);
    }

    private final int recyclerCenterY() {
        return ((this.recyclerView.getPaddingTop() + this.recyclerView.getHeight()) - this.recyclerView.getPaddingBottom()) / 2;
    }
}
