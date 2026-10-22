package com.android.settings.localepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.app.LocaleStore;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class LocaleDragAndDropAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private static final String CFGKEY_SELECTED_LOCALES = "selectedLocales";
    private static final String TAG = "LocaleDragAndDropAdapter";
    private final Context mContext;
    private boolean mDragEnabled;
    private final List<LocaleStore.LocaleInfo> mFeedItemList;
    private final ItemTouchHelper mItemTouchHelper;
    private LocaleList mLocalesSetLast;
    private LocaleList mLocalesToSetNext;
    private NumberFormat mNumberFormatter;
    private RecyclerView mParentView;
    private boolean mRemoveMode;

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener {
        private final LocaleDragCell mLocaleDragCell;
        final /* synthetic */ LocaleDragAndDropAdapter this$0;

        public CustomViewHolder(LocaleDragAndDropAdapter r1, LocaleDragCell r2) {
            this.this$0 = r1;
            super(r2);
            this.mLocaleDragCell = r2;
            r2.getDragHandle().setOnTouchListener(this);
        }

        public LocaleDragCell getLocaleDragCell() {
            return this.mLocaleDragCell;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r1, MotionEvent r2) {
            if (LocaleDragAndDropAdapter.access$000(this.this$0) == true) goto L5;
            return false;
        L5:
            if (MotionEventCompat.getActionMasked(r2) != 0) goto L11;
            LocaleDragAndDropAdapter.access$100(this.this$0).startDrag(this);
            return false;
        L11:
            return false;
        }
    }

    static /* synthetic */ boolean access$000(LocaleDragAndDropAdapter r0) {
        return r0.mDragEnabled;
    }

    static /* synthetic */ ItemTouchHelper access$100(LocaleDragAndDropAdapter r0) {
        return r0.mItemTouchHelper;
    }

    static /* synthetic */ LocaleList access$200(LocaleDragAndDropAdapter r0) {
        return r0.mLocalesToSetNext;
    }

    static /* synthetic */ LocaleList access$202(LocaleDragAndDropAdapter r0, LocaleList r1) {
        r0.mLocalesToSetNext = r1;
        return r1;
    }

    static /* synthetic */ LocaleList access$300(LocaleDragAndDropAdapter r0) {
        return r0.mLocalesSetLast;
    }

    static /* synthetic */ LocaleList access$302(LocaleDragAndDropAdapter r0, LocaleList r1) {
        r0.mLocalesSetLast = r1;
        return r1;
    }

    static /* synthetic */ NumberFormat access$402(LocaleDragAndDropAdapter r0, NumberFormat r1) {
        r0.mNumberFormatter = r1;
        return r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((CustomViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public LocaleDragAndDropAdapter(Context r5, List<LocaleStore.LocaleInfo> r6) {
        this.mParentView = null;
        final int r1 = 0;
        this.mRemoveMode = false;
        this.mDragEnabled = true;
        this.mNumberFormatter = NumberFormat.getNumberInstance();
        this.mLocalesToSetNext = null;
        this.mLocalesSetLast = null;
        this.mFeedItemList = r6;
        this.mContext = r5;
        final float r7 = TypedValue.applyDimension(1, 8.0f, r5.getResources().getDisplayMetrics());
        final int r2 = 3;
        this.mItemTouchHelper = new ItemTouchHelper(new AnonymousClass1(this, r2, r1, r7));
    }

    public void setRecyclerView(RecyclerView r1) {
        this.mParentView = r1;
        this.mItemTouchHelper.attachToRecyclerView(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new CustomViewHolder(this, (LocaleDragCell) LayoutInflater.from(this.mContext).inflate(R.layout.locale_drag_cell, r3, false));
    }

    public void onBindViewHolder(CustomViewHolder r6, int r7) {
        LocaleStore.LocaleInfo r0 = this.mFeedItemList.get(r7);
        final LocaleDragCell r8 = r6.getLocaleDragCell();
        r8.setLabelAndDescription(r0.getFullNameNative(), r0.getFullNameInUiLanguage());
        r8.setLocalized(r0.isTranslated());
        boolean r2 = true;
        r8.setMiniLabel(this.mNumberFormatter.format(r7 + 1));
        r8.setShowCheckbox(this.mRemoveMode);
        r8.setShowMiniLabel(!this.mRemoveMode);
        boolean r1 = false;
        if (this.mRemoveMode == false) goto L5;
    L7:
        r2 = false;
    L8:
        r8.setShowHandle(r2);
        if (this.mRemoveMode == false) goto L11;
        r1 = r0.getChecked();
    L11:
        r8.setChecked(r1);
        r8.setTag(r0);
        r8.getCheckbox().setOnCheckedChangeListener(new AnonymousClass2(this, r8));
        return;
    L5:
        if (this.mDragEnabled == false) goto L7;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<LocaleStore.LocaleInfo> r0 = this.mFeedItemList;
        if (r0 == null) goto L5;
        int r1 = r0.size();
    L7:
        if (r1 >= 2) goto L9;
    L12:
        setDragEnabled(false);
    L13:
        return r1;
    L9:
        if (this.mRemoveMode == true) goto L12;
        setDragEnabled(true);
        goto L13
    L5:
        r1 = 0;
        goto L7
    }

    void onItemMove(int r5, int r6) {
        if (r5 < 0) goto L5;
        if (r6 < 0) goto L5;
        LocaleStore.LocaleInfo r0 = this.mFeedItemList.get(r5);
        this.mFeedItemList.remove(r5);
        this.mFeedItemList.add(r6, r0);
    L6:
        notifyItemChanged(r5);
        notifyItemChanged(r6);
        notifyItemMoved(r5, r6);
        return;
    L5:
        OLog.e(TAG, String.format(Locale.US, "Negative position in onItemMove %d -> %d", new Object[]{Integer.valueOf(r5), Integer.valueOf(r6)}));
        goto L6
    }

    void setRemoveMode(boolean r4) {
        this.mRemoveMode = r4;
        int r5 = this.mFeedItemList.size();
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        this.mFeedItemList.get(r1).setChecked(false);
        notifyItemChanged(r1);
        r1 = r1 + 1;
        goto L3
    }

    boolean isRemoveMode() {
        return this.mRemoveMode;
    }

    void removeItem(int r3) {
        int r0 = this.mFeedItemList.size();
        if (r0 > 1) goto L5;
        return;
    L5:
        if (r3 < 0) goto L10;
        if (r3 >= r0) goto L11;
        this.mFeedItemList.remove(r3);
        notifyDataSetChanged();
        return;
    L11:
        return;
    }

    void removeChecked() {
        int r0 = this.mFeedItemList.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (this.mFeedItemList.get(r0).getChecked() == false) goto L7;
        this.mFeedItemList.remove(r0);
    L7:
        r0 = r0 - 1;
        goto L3
    L8:
        notifyDataSetChanged();
        doTheUpdate();
    }

    int getCheckedCount() {
        Iterator<LocaleStore.LocaleInfo> r2 = this.mFeedItemList.iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L8;
        if (r2.next().getChecked() == false) goto L4;
        r0 = r0 + 1;
        goto L4
    L8:
        return r0;
    }

    LocaleStore.LocaleInfo getFirstChecked() {
        Iterator<LocaleStore.LocaleInfo> r2 = this.mFeedItemList.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        LocaleStore.LocaleInfo r0 = r2.next();
        if (r0.getChecked() == false) goto L4;
        return r0;
    L8:
        return null;
    }

    void addLocale(LocaleStore.LocaleInfo r2) {
        this.mFeedItemList.add(r2);
        notifyItemInserted(this.mFeedItemList.size() - 1);
        doTheUpdate();
    }

    public void doTheUpdate() {
        int r0 = this.mFeedItemList.size();
        Locale[] r1 = new Locale[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this.mFeedItemList.get(r2).getLocale();
        r2 = r2 + 1;
        goto L3
    L5:
        updateLocalesWhenAnimationStops(new LocaleList(r1));
    }

    public void updateLocalesWhenAnimationStops(LocaleList r2) {
        if (r2.equals(this.mLocalesToSetNext) == false) goto L5;
        return;
    L5:
        LocaleList.setDefault(r2);
        this.mLocalesToSetNext = r2;
        this.mParentView.getItemAnimator().isRunning(new AnonymousClass3(this));
    }

    private void setDragEnabled(boolean r1) {
        this.mDragEnabled = r1;
    }

    public void saveState(Bundle r4) {
        if (r4 == null) goto L16;
        ArrayList<String> r0 = new ArrayList();
        Iterator<LocaleStore.LocaleInfo> r3 = this.mFeedItemList.iterator();
    L5:
        if (r3.hasNext() == false) goto L9;
        LocaleStore.LocaleInfo r1 = r3.next();
        if (r1.getChecked() == false) goto L5;
        r0.add(r1.getId());
        goto L5
    L9:
        r4.putStringArrayList(CFGKEY_SELECTED_LOCALES, r0);
        return;
    }

    public void restoreState(Bundle r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.mRemoveMode == false) goto L18;
        ArrayList<String> r5 = r4.getStringArrayList(CFGKEY_SELECTED_LOCALES);
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.isEmpty() == true) goto L20;
        Iterator<LocaleStore.LocaleInfo> r0 = this.mFeedItemList.iterator();
    L12:
        if (r0.hasNext() == false) goto L14;
        LocaleStore.LocaleInfo r1 = r0.next();
        r1.setChecked(r5.contains(r1.getId()));
        goto L12
    L14:
        notifyItemRangeChanged(0, this.mFeedItemList.size());
        return;
    L20:
        return;
    }
}
