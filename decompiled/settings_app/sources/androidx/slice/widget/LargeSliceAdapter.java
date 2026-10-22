package androidx.slice.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import androidx.slice.SliceItem;
import androidx.slice.core.SliceAction;
import androidx.slice.core.SliceQuery;
import androidx.slice.view.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LargeSliceAdapter extends RecyclerView.Adapter<SliceViewHolder> implements SliceActionView.SliceActionLoadingListener {
    static final int HEADER_INDEX = 0;
    static final int TYPE_DEFAULT = 1;
    static final int TYPE_GRID = 3;
    static final int TYPE_HEADER = 2;
    static final int TYPE_MESSAGE = 4;
    static final int TYPE_MESSAGE_LOCAL = 5;
    boolean mAllowTwoLines;
    int mColor;
    final Context mContext;
    private final IdGenerator mIdGen;
    int mInsetBottom;
    int mInsetEnd;
    int mInsetStart;
    int mInsetTop;
    long mLastUpdated;
    Set<SliceItem> mLoadingActions;
    int mMaxSmallHeight;
    SliceView mParent;
    boolean mShowLastUpdated;
    List<SliceAction> mSliceActions;
    SliceView.OnSliceActionListener mSliceObserver;
    SliceStyle mSliceStyle;
    private List<SliceWrapper> mSlices;
    LargeTemplateView mTemplateView;

    private static class IdGenerator {
        private final ArrayMap<String, Long> mCurrentIds;
        private long mNextLong;
        private final ArrayMap<String, Integer> mUsedIds;

        IdGenerator() {
            this.mNextLong = 0;
            this.mCurrentIds = new ArrayMap();
            this.mUsedIds = new ArrayMap();
        }

        public long getId(SliceItem r6) {
            String r7 = genString(r6);
            if (this.mCurrentIds.containsKey(r7) == true) goto L5;
            ArrayMap<String, Long> r0 = this.mCurrentIds;
            long r1 = this.mNextLong;
            this.mNextLong = 1 + r1;
            r0.put(r7, Long.valueOf(r1));
        L5:
            long r2 = this.mCurrentIds.get(r7).longValue();
            Integer r3 = this.mUsedIds.get(r7);
            if (r3 == null) goto L8;
            int r4 = r3.intValue();
        L9:
            this.mUsedIds.put(r7, Integer.valueOf(r4 + 1));
            return r2 + ((long) (r4 * 10000));
        L8:
            r4 = 0;
            goto L9
        }

        private String genString(SliceItem r2) {
            if ("slice".equals(r2.getFormat()) == true) goto L10;
            if ("action".equals(r2.getFormat()) == true) goto L10;
            return r2.toString();
        L10:
            return String.valueOf(r2.getSlice().getItems().size());
        }

        public void resetUsage() {
            this.mUsedIds.clear();
        }
    }

    public class SliceViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener, View.OnClickListener {
        public final SliceChildView mSliceChildView;
        final /* synthetic */ LargeSliceAdapter this$0;

        public SliceViewHolder(LargeSliceAdapter r1, View r2) {
            this.this$0 = r1;
            super(r2);
            if ((r2 instanceof SliceChildView) == false) goto L5;
            SliceChildView r3 = (SliceChildView) r2;
        L6:
            this.mSliceChildView = r3;
            return;
        L5:
            r3 = null;
            goto L6
        }

        void bind(SliceItem r12, int r13) {
            SliceChildView r0 = this.mSliceChildView;
            if (r0 == null) goto L45;
            if (r12 == null) goto L46;
            r0.setOnClickListener(this);
            this.mSliceChildView.setOnTouchListener(this);
            this.mSliceChildView.setSliceActionLoadingListener(this.this$0);
            if (r13 != 0) goto L9;
            boolean r2 = true;
        L10:
            boolean r9 = ListContent.isValidHeader(r12);
            if (this.this$0.mParent == null) goto L13;
            int r3 = this.this$0.mParent.getMode();
        L14:
            this.mSliceChildView.setLoadingActions(this.this$0.mLoadingActions);
            this.mSliceChildView.setMode(r3);
            this.mSliceChildView.setMaxSmallHeight(this.this$0.mMaxSmallHeight);
            this.mSliceChildView.setTint(this.this$0.mColor);
            this.mSliceChildView.setStyle(this.this$0.mSliceStyle);
            SliceChildView r4 = this.mSliceChildView;
            if (r2 == true) goto L17;
        L19:
            boolean r5 = false;
        L20:
            r4.setShowLastUpdated(r5);
            SliceChildView r6 = this.mSliceChildView;
            if (r2 == false) goto L23;
            long r7 = this.this$0.mLastUpdated;
        L24:
            r6.setLastUpdated(r7);
            if (r13 != 0) goto L27;
            int r8 = this.this$0.mInsetTop;
        L29:
            if (r13 != (this.this$0.getItemCount() - 1)) goto L31;
            int r10 = this.this$0.mInsetBottom;
        L32:
            this.mSliceChildView.setInsets(this.this$0.mInsetStart, r8, this.this$0.mInsetEnd, r10);
            SliceChildView r11 = this.mSliceChildView;
            if ((r11 instanceof RowView) == false) goto L39;
            RowView r14 = (RowView) r11;
            if (this.this$0.getItemCount() != 1) goto L37;
            boolean r15 = true;
        L38:
            r14.setSingleItem(r15);
            goto L39
        L37:
            r15 = false;
        L39:
            this.mSliceChildView.setAllowTwoLines(this.this$0.mAllowTwoLines);
            SliceChildView r16 = this.mSliceChildView;
            if (r2 == false) goto L42;
            List<SliceAction> r17 = this.this$0.mSliceActions;
        L43:
            r16.setSliceActions(r17);
            this.mSliceChildView.setSliceItem(r12, r9, r13, this.this$0.getItemCount(), this.this$0.mSliceObserver);
            this.mSliceChildView.setTag(new int[]{ListContent.getRowType(this.this$0.mContext, r12, r9, this.this$0.mSliceActions), r13});
            return;
        L42:
            r17 = null;
            goto L43
        L31:
            r10 = 0;
            goto L32
        L27:
            r8 = 0;
            goto L29
        L23:
            r7 = -1;
            goto L24
        L17:
            if (this.this$0.mShowLastUpdated == false) goto L19;
            r5 = true;
            goto L20
        L13:
            r3 = 2;
            goto L14
        L9:
            r2 = false;
            goto L10
        L46:
            return;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r2) {
            if (this.this$0.mParent == null) goto L6;
            this.this$0.mParent.setClickInfo((int[]) r2.getTag());
            this.this$0.mParent.performClick();
            return;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r1, MotionEvent r2) {
            if (this.this$0.mTemplateView == null) goto L7;
            this.this$0.mTemplateView.onForegroundActivated(r2);
            return false;
        L7:
            return false;
        }
    }

    protected static class SliceWrapper {
        final long mId;
        final SliceItem mItem;
        final int mType;

        public SliceWrapper(SliceItem r1, IdGenerator r2, int r3) {
            this.mItem = r1;
            this.mType = getFormat(r1);
            this.mId = r2.getId(r1);
        }

        public static int getFormat(SliceItem r2) {
            if ("message".equals(r2.getSubType()) == false) goto L11;
            if (SliceQuery.findSubtype(r2, null, "source") == null) goto L8;
            return 4;
        L8:
            return 5;
        L11:
            if (r2.hasHint("horizontal") == false) goto L15;
            return 3;
        L15:
            if (r2.hasHint("list_item") == true) goto L18;
            return 2;
        L18:
            return 1;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((SliceViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public LargeSliceAdapter(Context r2) {
        this.mIdGen = new IdGenerator();
        this.mSlices = new ArrayList();
        this.mLoadingActions = new HashSet();
        this.mContext = r2;
        setHasStableIds(true);
    }

    public void setParents(SliceView r1, LargeTemplateView r2) {
        this.mParent = r1;
        this.mTemplateView = r2;
    }

    public void setInsets(int r1, int r2, int r3, int r4) {
        this.mInsetStart = r1;
        this.mInsetTop = r2;
        this.mInsetEnd = r3;
        this.mInsetBottom = r4;
    }

    public void setSliceObserver(SliceView.OnSliceActionListener r1) {
        this.mSliceObserver = r1;
    }

    public void setSliceActions(List<SliceAction> r1) {
        this.mSliceActions = r1;
        notifyHeaderChanged();
    }

    public void setSliceItems(List<SliceItem> r5, int r6, int r7) {
        if (r5 != null) goto L4;
        this.mLoadingActions.clear();
        this.mSlices.clear();
    L8:
        this.mColor = r6;
        notifyDataSetChanged();
        return;
    L4:
        this.mIdGen.resetUsage();
        this.mSlices = new ArrayList(r5.size());
        Iterator<SliceItem> r8 = r5.iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        SliceItem r0 = r8.next();
        this.mSlices.add(new SliceWrapper(r0, this.mIdGen, r7));
        goto L6
    }

    public void setStyle(SliceStyle r1) {
        this.mSliceStyle = r1;
        notifyDataSetChanged();
    }

    public void setShowLastUpdated(boolean r2) {
        if (this.mShowLastUpdated == r2) goto L6;
        this.mShowLastUpdated = r2;
        notifyHeaderChanged();
        return;
    }

    public void setLastUpdated(long r3) {
        if (this.mLastUpdated == r3) goto L6;
        this.mLastUpdated = r3;
        notifyHeaderChanged();
        return;
    }

    public void setLoadingActions(Set<SliceItem> r1) {
        if (r1 != null) goto L4;
        this.mLoadingActions.clear();
    L5:
        notifyDataSetChanged();
        return;
    L4:
        this.mLoadingActions = r1;
        goto L5
    }

    public Set<SliceItem> getLoadingActions() {
        return this.mLoadingActions;
    }

    @Override // androidx.slice.widget.SliceActionView.SliceActionLoadingListener
    public void onSliceActionLoading(SliceItem r2, int r3) {
        this.mLoadingActions.add(r2);
        if (getItemCount() <= r3) goto L5;
        notifyItemChanged(r3);
        return;
    L5:
        notifyDataSetChanged();
    }

    public void setAllowTwoLines(boolean r1) {
        this.mAllowTwoLines = r1;
        notifyHeaderChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SliceViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        View r5 = inflateForType(r4);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new SliceViewHolder(this, r5);
    }

    public void setMaxSmallHeight(int r2) {
        if (this.mMaxSmallHeight == r2) goto L6;
        this.mMaxSmallHeight = r2;
        notifyHeaderChanged();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r1) {
        return this.mSlices.get(r1).mType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r1) {
        return this.mSlices.get(r1).mId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mSlices.size();
    }

    public void onBindViewHolder(SliceViewHolder r1, int r2) {
        r1.bind(this.mSlices.get(r2).mItem, r2);
    }

    private void notifyHeaderChanged() {
        if (getItemCount() <= 0) goto L6;
        notifyItemChanged(0);
        return;
    }

    private View inflateForType(int r4) {
        RowView r0 = new RowView(this.mContext);
        if (r4 == 3) goto L12;
        if (r4 == 4) goto L14;
        if (r4 == 5) goto L13;
        return r0;
    L13:
        return LayoutInflater.from(this.mContext).inflate(R.layout.abc_slice_message_local, null);
    L14:
        return LayoutInflater.from(this.mContext).inflate(R.layout.abc_slice_message, null);
    L12:
        return LayoutInflater.from(this.mContext).inflate(R.layout.abc_slice_grid, null);
    }
}
