package com.drakeet.multitype;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004:\u0001$B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0004J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u001d\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0017\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0018J+\u0010\u0015\u001a\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J#\u0010\u001a\u001a\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00020\u001eH&¢\u0006\u0002\u0010\u001fJ\u001d\u0010\u001c\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016R\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u00020\b*\u00020\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005*\u00020\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\b*\u00020\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\n¨\u0006%"}, d2 = {"Lcom/drakeet/multitype/ViewDelegate;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroid/view/View;", "Lcom/drakeet/multitype/ItemViewDelegate;", "Lcom/drakeet/multitype/ViewDelegate$Holder;", "()V", "absoluteAdapterPosition", "", "getAbsoluteAdapterPosition", "(Landroid/view/View;)I", "bindingAdapterPosition", "getBindingAdapterPosition", "holder", "getHolder", "(Landroid/view/View;)Lcom/drakeet/multitype/ViewDelegate$Holder;", "layoutPosition", "getLayoutPosition", "getRecyclerLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "view", "onBindView", "", "item", "(Landroid/view/View;Ljava/lang/Object;)V", "(Lcom/drakeet/multitype/ViewDelegate$Holder;Landroid/view/View;Ljava/lang/Object;)V", "onBindViewHolder", "(Lcom/drakeet/multitype/ViewDelegate$Holder;Ljava/lang/Object;)V", "onCreateView", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)Landroid/view/View;", "onCreateViewHolder", "Holder", "multitype"}, k = 1, mv = {1, 4, 2})
public abstract class ViewDelegate<T, V extends View> extends ItemViewDelegate<T, Holder<V>> {

    /* JADX INFO: compiled from: ViewDelegate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/drakeet/multitype/ViewDelegate$Holder;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroid/view/View;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "Landroid/view/View;", "multitype"}, k = 1, mv = {1, 4, 2})
    public static final class Holder<V extends View> extends RecyclerView.ViewHolder {
        private final V view;

        public Holder(V r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.view = r2;
        }

        public final V getView() {
            return this.view;
        }
    }

    public abstract void onBindView(V r1, T r2);

    public abstract V onCreateView(Context r1);

    public ViewDelegate() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.drakeet.multitype.ItemViewDelegate
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, Object r2) {
        onBindViewHolder((Holder) r1, r2);
    }

    @Override // com.drakeet.multitype.ItemViewDelegate
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(Context r1, ViewGroup r2) {
        return onCreateViewHolder(r1, r2);
    }

    protected final Holder<V> getHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$holder");
        Holder<V> r1 = holder(r2);
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalAccessException("The view holder property can only be called after onCreateView()!");
    }

    protected final int getLayoutPosition(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutPosition");
        return getHolder(r2).getLayoutPosition();
    }

    protected final int getAbsoluteAdapterPosition(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$absoluteAdapterPosition");
        return getHolder(r2).getAbsoluteAdapterPosition();
    }

    protected final int getBindingAdapterPosition(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$bindingAdapterPosition");
        return getHolder(r2).getBindingAdapterPosition();
    }

    public V onCreateView(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "parent");
        return (V) onCreateView(r2);
    }

    public void onBindView(Holder<V> r2, V r3, T r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "view");
        r3.setTag(R.id.tagViewHolder, r2);
        onBindView(r3, r4);
    }

    protected final RecyclerView.LayoutParams getRecyclerLayoutParams(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L7;
        return (RecyclerView.LayoutParams) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    private final Holder<V> holder(View r1) {
        Object r0 = r1.getTag(R.id.tagViewHolder);
        if ((r0 instanceof Holder) == true) goto L6;
        r0 = null;
    L6:
        return (Holder) r0;
    }

    @Override // com.drakeet.multitype.ItemViewDelegate
    public Holder<V> onCreateViewHolder(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new Holder(onCreateView(r2, r3));
    }

    public void onBindViewHolder(Holder<V> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        onBindView(r2, r2.getView(), r3);
    }
}
