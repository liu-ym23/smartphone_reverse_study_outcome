package com.drakeet.multitype;

import android.content.Context;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemViewDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001dJ+\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00028\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0016¢\u0006\u0002\u0010\u001fJ\u001d\u0010 \u001a\u00028\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H&¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020'2\u0006\u0010\u001c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010(J\u0015\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010*J\u0015\u0010+\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010*J\u0015\u0010,\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010*R\"\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR0\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006-"}, d2 = {"Lcom/drakeet/multitype/ItemViewDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "()V", "_adapter", "Lcom/drakeet/multitype/MultiTypeAdapter;", "get_adapter$multitype$annotations", "get_adapter$multitype", "()Lcom/drakeet/multitype/MultiTypeAdapter;", "set_adapter$multitype", "(Lcom/drakeet/multitype/MultiTypeAdapter;)V", "adapter", "getAdapter", "value", "", "adapterItems", "getAdapterItems", "()Ljava/util/List;", "setAdapterItems", "(Ljava/util/List;)V", "getItemId", "", "item", "(Ljava/lang/Object;)J", "onBindViewHolder", "", "holder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/lang/Object;)V", "payloads", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "onCreateViewHolder", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onFailedToRecycleView", "", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "onViewAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onViewDetachedFromWindow", "onViewRecycled", "multitype"}, k = 1, mv = {1, 4, 2})
public abstract class ItemViewDelegate<T, VH extends RecyclerView.ViewHolder> {
    private MultiTypeAdapter _adapter;

    public static /* synthetic */ void get_adapter$multitype$annotations() {
    }

    public long getItemId(T r1) {
        return -1;
    }

    public abstract void onBindViewHolder(VH r1, T r2);

    public abstract VH onCreateViewHolder(Context r1, ViewGroup r2);

    public boolean onFailedToRecycleView(VH r1) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        return false;
    }

    public void onViewAttachedToWindow(VH r1) {
        Intrinsics.checkNotNullParameter(r1, "holder");
    }

    public void onViewDetachedFromWindow(VH r1) {
        Intrinsics.checkNotNullParameter(r1, "holder");
    }

    public void onViewRecycled(VH r1) {
        Intrinsics.checkNotNullParameter(r1, "holder");
    }

    public ItemViewDelegate() {
    }

    public final MultiTypeAdapter get_adapter$multitype() {
        return this._adapter;
    }

    public final void set_adapter$multitype(MultiTypeAdapter r1) {
        this._adapter = r1;
    }

    public final MultiTypeAdapter getAdapter() {
        MultiTypeAdapter r0 = this._adapter;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        return r0;
    L7:
        throw new IllegalStateException("This " + this + " has not been attached to MultiTypeAdapter yet. You should not call the method before registering the delegate.");
    }

    public final List<Object> getAdapterItems() {
        return getAdapter().getItems();
    }

    public final void setAdapterItems(List<? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        getAdapter().setItems(r2);
    }

    public void onBindViewHolder(VH r2, T r3, List<? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        onBindViewHolder(r2, r3);
    }
}
