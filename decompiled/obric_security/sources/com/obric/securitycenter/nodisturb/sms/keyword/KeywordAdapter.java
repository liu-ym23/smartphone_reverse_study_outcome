package com.obric.securitycenter.nodisturb.sms.keyword;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.obric.securitycenter.nodisturb.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: KeywordAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\n\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0014\u0010\u0015\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$VH;", "onItemDelete", "Lkotlin/Function1;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordItem;", "", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$Entry;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "data", "", "DiffCallback", "EmptyEntry", "EmptyViewHolder", "Entry", "EntryType", "KeywordEntry", "KeywordViewHolder", "TipsEntry", "TipsViewHolder", "VH", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KeywordAdapter extends RecyclerView.Adapter<VH> {
    private final List<Entry> items;
    private final Function1<KeywordItem, Unit> onItemDelete;

    /* JADX INFO: compiled from: KeywordAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$Entry;", "newItems", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DiffCallback extends DiffUtil.Callback {
        private final List<Entry> newItems;
        private final List<Entry> oldItems;

        /* JADX WARN: Multi-variable type inference failed */
        public DiffCallback(List<? extends Entry> r2, List<? extends Entry> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldItems");
            Intrinsics.checkNotNullParameter(r3, "newItems");
            this.oldItems = r2;
            this.newItems = r3;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldItems.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newItems.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int r2, int r3) {
            Entry r4 = this.oldItems.get(r2);
            Entry r1 = this.newItems.get(r3);
            if (r4.getType() == r1.getType()) goto L7;
            return false;
        L7:
            if ((r4 instanceof KeywordEntry) == true) goto L9;
            return true;
        L9:
            if ((r1 instanceof KeywordEntry) == true) goto L11;
            return true;
        L11:
            return Intrinsics.areEqual(((KeywordEntry) r4).getKeyword(), ((KeywordEntry) r1).getKeyword());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int r2, int r3) {
            Entry r4 = this.oldItems.get(r2);
            Entry r1 = this.newItems.get(r3);
            if ((r4 instanceof KeywordEntry) == true) goto L5;
            return true;
        L5:
            if ((r1 instanceof KeywordEntry) == true) goto L7;
            return true;
        L7:
            return Intrinsics.areEqual(((KeywordEntry) r4).getKeyword(), ((KeywordEntry) r1).getKeyword());
        }
    }

    /* JADX INFO: compiled from: KeywordAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$EmptyEntry;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$Entry;", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "", "(I)V", "getHeight", "()I", "setHeight", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EmptyEntry extends Entry {
        private int height;

        public EmptyEntry(int r2) {
            super(EntryType.Empty.INSTANCE.getType());
            this.height = r2;
        }

        public final int getHeight() {
            return this.height;
        }

        public final void setHeight(int r1) {
            this.height = r1;
        }
    }

    /* JADX INFO: compiled from: KeywordAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$EmptyViewHolder;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$VH;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$Entry;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EmptyViewHolder extends VH {
        public EmptyViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }

        @Override // com.obric.securitycenter.nodisturb.sms.keyword.KeywordAdapter.VH
        public void bind(Entry r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            if ((r2 instanceof EmptyEntry) == false) goto L9;
            View r1 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(r1, "itemView");
            ViewGroup.LayoutParams r0 = r1.getLayoutParams();
            if (r0 == null) goto L8;
            r0.height = ((EmptyEntry) r2).getHeight();
            r1.setLayoutParams(r0);
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    /* JADX INFO: compiled from: KeywordAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$Entry;", "", "type", "", "(I)V", "getType", "()I", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class Entry {
        private final int type;

        public Entry(int r1) {
            this.type = r1;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: KeywordAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$EntryType;", "", "type", "", "(I)V", "getType", "()I", "Empty", "Keyword", "Tips", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$EntryType$Empty;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$EntryType$Keyword;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$EntryType$Tips;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class EntryType {
        private final int type;

        /* JADX INFO: compiled from: KeywordAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$EntryType$Empty;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$EntryType;", "()V", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Empty extends EntryType {
            public static final Empty INSTANCE = null;

            static {
                INSTANCE = new Empty();
            }

            private Empty() {
                super(2, null);
            }
        }

        /* JADX INFO: compiled from: KeywordAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$EntryType$Keyword;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$EntryType;", "()V", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Keyword extends EntryType {
            public static final Keyword INSTANCE = null;

            static {
                INSTANCE = new Keyword();
            }

            private Keyword() {
                super(1, null);
            }
        }

        /* JADX INFO: compiled from: KeywordAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$EntryType$Tips;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$EntryType;", "()V", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Tips extends EntryType {
            public static final Tips INSTANCE = null;

            static {
                INSTANCE = new Tips();
            }

            private Tips() {
                super(0, null);
            }
        }

        public /* synthetic */ EntryType(int r1, DefaultConstructorMarker r2) {
            this(r1);
        }

        private EntryType(int r1) {
            this.type = r1;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: KeywordAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$KeywordEntry;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$Entry;", "keyword", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordItem;", "(Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordItem;)V", "getKeyword", "()Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordItem;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class KeywordEntry extends Entry {
        private final KeywordItem keyword;

        public final KeywordItem getKeyword() {
            return this.keyword;
        }

        public KeywordEntry(KeywordItem r2) {
            Intrinsics.checkNotNullParameter(r2, "keyword");
            super(EntryType.Keyword.INSTANCE.getType());
            this.keyword = r2;
        }
    }

    /* JADX INFO: compiled from: KeywordAdapter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$KeywordViewHolder;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$VH;", "itemView", "Landroid/view/View;", "onItemDelete", "Lkotlin/Function1;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordItem;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "btnDelete", "tvTitle", "Lcom/obric/oui/text/OTextView;", "bind", "item", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$Entry;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class KeywordViewHolder extends VH {
        private final View btnDelete;
        private final Function1<KeywordItem, Unit> onItemDelete;
        private final OTextView tvTitle;

        public static /* synthetic */ void $r8$lambda$j6mHifyu_mA0vuiSYvXpbXk3JLk(KeywordViewHolder r0, Entry r1, View r2) {
            bind$lambda$0(r0, r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public KeywordViewHolder(View r2, Function1<? super KeywordItem, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "onItemDelete");
            super(r2);
            this.onItemDelete = r3;
            View r4 = r2.findViewById(R.id.keyword_title);
            Intrinsics.checkNotNullExpressionValue(r4, "itemView.findViewById(R.id.keyword_title)");
            this.tvTitle = (OTextView) r4;
            View r5 = r2.findViewById(R.id.delete_icon);
            Intrinsics.checkNotNullExpressionValue(r5, "itemView.findViewById(R.id.delete_icon)");
            this.btnDelete = r5;
        }

        @Override // com.obric.securitycenter.nodisturb.sms.keyword.KeywordAdapter.VH
        public void bind(final Entry r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            if ((r3 instanceof KeywordEntry) == false) goto L6;
            this.tvTitle.setText(((KeywordEntry) r3).getKeyword().getText());
            this.btnDelete.setOnClickListener(new KeywordAdapter$KeywordViewHolder$$ExternalSyntheticLambda0(this, r3));
            return;
        }

        private static final void bind$lambda$0(KeywordViewHolder r0, Entry r1, View r2) {
            Intrinsics.checkNotNullParameter(r0, "this$0");
            Intrinsics.checkNotNullParameter(r1, "$item");
            r0.onItemDelete.invoke(((KeywordEntry) r1).getKeyword());
        }
    }

    /* JADX INFO: compiled from: KeywordAdapter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$TipsEntry;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$Entry;", "()V", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class TipsEntry extends Entry {
        public TipsEntry() {
            super(EntryType.Tips.INSTANCE.getType());
        }
    }

    /* JADX INFO: compiled from: KeywordAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$TipsViewHolder;", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$VH;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class TipsViewHolder extends VH {
        public TipsViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    /* JADX INFO: compiled from: KeywordAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter$Entry;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class VH extends RecyclerView.ViewHolder {
        public void bind(Entry r1) {
            Intrinsics.checkNotNullParameter(r1, "item");
        }

        public VH(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((VH) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KeywordAdapter(Function1<? super KeywordItem, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemDelete");
        this.onItemDelete = r2;
        this.items = new ArrayList();
    }

    public final void setData(List<KeywordItem> r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        ArrayList r0 = new ArrayList();
        List<KeywordItem> r6 = r5;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r1.add(new KeywordEntry((KeywordItem) r7.next()));
        goto L4
    L6:
        r0.addAll(r1);
        r0.add(new TipsEntry());
        r0.add(new EmptyEntry(MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()))));
        DiffUtil.DiffResult r8 = DiffUtil.calculateDiff(new DiffCallback(this.items, r0));
        Intrinsics.checkNotNullExpressionValue(r8, "calculateDiff(DiffCallback(items, newItems))");
        this.items.clear();
        this.items.addAll(r0);
        r8.dispatchUpdatesTo(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != EntryType.Tips.INSTANCE.getType()) goto L7;
        View r3 = LayoutInflater.from(r4.getContext()).inflate(R.layout.nodisturd_keyword_tips, r4, false);
        Intrinsics.checkNotNullExpressionValue(r3, "view");
        return new TipsViewHolder(r3);
    L7:
        if (r5 != EntryType.Keyword.INSTANCE.getType()) goto L11;
        View r6 = LayoutInflater.from(r4.getContext()).inflate(R.layout.item_keyword, r4, false);
        Intrinsics.checkNotNullExpressionValue(r6, "view");
        return new KeywordViewHolder(r6, this.onItemDelete);
    L11:
        if (r5 != EntryType.Empty.INSTANCE.getType()) goto L15;
        View r7 = new View(r4.getContext());
        r7.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        return new EmptyViewHolder(r7);
    L15:
        throw new IllegalArgumentException("viewType is not support");
    }

    public void onBindViewHolder(VH r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        r2.bind(this.items.get(r3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r1) {
        return this.items.get(r1).getType();
    }
}
