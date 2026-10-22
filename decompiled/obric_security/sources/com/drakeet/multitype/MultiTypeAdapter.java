package com.drakeet.multitype;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: MultiTypeAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B+\b\u0007\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002J\u001d\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001fJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J&\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010*\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010+\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J'\u0010,\u001a\u00020!\"\n\b\u0000\u0010-\u0018\u0001*\u00020\u00052\u0010\u0010.\u001a\f\u0012\u0004\u0012\u0002H-\u0012\u0002\b\u00030/H\u0086\bJ'\u0010,\u001a\u00020!\"\n\b\u0000\u0010-\u0018\u0001*\u00020\u00052\u0010\u00100\u001a\f\u0012\u0004\u0012\u0002H-\u0012\u0002\b\u00030\u001bH\u0086\bJ!\u0010,\u001a\u00020!\"\u0004\b\u0000\u0010-2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H-02H\u0000¢\u0006\u0002\b3J\"\u0010,\u001a\b\u0012\u0004\u0012\u0002H-04\"\u0004\b\u0000\u0010-2\f\u00105\u001a\b\u0012\u0004\u0012\u0002H-06H\u0007J,\u0010,\u001a\u00020!\"\u0004\b\u0000\u0010-2\f\u00105\u001a\b\u0012\u0004\u0012\u0002H-062\u0010\u0010.\u001a\f\u0012\u0004\u0012\u0002H-\u0012\u0002\b\u00030/J,\u0010,\u001a\u00020!\"\u0004\b\u0000\u0010-2\f\u00105\u001a\b\u0012\u0004\u0012\u0002H-062\u0010\u00100\u001a\f\u0012\u0004\u0012\u0002H-\u0012\u0002\b\u00030\u001bJ&\u0010,\u001a\b\u0012\u0004\u0012\u0002H-04\"\b\b\u0000\u0010-*\u00020\u00052\f\u00105\u001a\b\u0012\u0004\u0012\u0002H-07H\u0007J5\u0010,\u001a\u00020!\"\n\b\u0000\u0010-\u0018\u0001*\u00020\u00052\f\u00105\u001a\b\u0012\u0004\u0012\u0002H-072\u0010\u0010.\u001a\f\u0012\u0004\u0012\u0002H-\u0012\u0002\b\u00030/H\u0086\bJ5\u0010,\u001a\u00020!\"\n\b\u0000\u0010-\u0018\u0001*\u00020\u00052\f\u00105\u001a\b\u0012\u0004\u0012\u0002H-072\u0010\u00100\u001a\f\u0012\u0004\u0012\u0002H-\u0012\u0002\b\u00030\u001bH\u0086\bJ\u000e\u00108\u001a\u00020!2\u0006\u0010\b\u001a\u00020\tJ\u0014\u00109\u001a\u00020!2\n\u00105\u001a\u0006\u0012\u0002\b\u000306H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006;"}, d2 = {"Lcom/drakeet/multitype/MultiTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "items", "", "", "initialCapacity", "", GloableSearchConfig.KEY_CONFIGS, "Lcom/drakeet/multitype/Types;", "(Ljava/util/List;ILcom/drakeet/multitype/Types;)V", "getInitialCapacity", "()I", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getTypes", "()Lcom/drakeet/multitype/Types;", "setTypes", "(Lcom/drakeet/multitype/Types;)V", "getItemCount", "getItemId", "", "position", "getItemViewType", "getOutDelegateByViewHolder", "Lcom/drakeet/multitype/ItemViewDelegate;", "holder", "indexInTypesOf", "item", "indexInTypesOf$multitype", "onBindViewHolder", "", "payloads", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "indexViewType", "onFailedToRecycleView", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "register", ExifInterface.GPS_DIRECTION_TRUE, "binder", "Lcom/drakeet/multitype/ItemViewBinder;", "delegate", "type", "Lcom/drakeet/multitype/Type;", "register$multitype", "Lcom/drakeet/multitype/OneToManyFlow;", "clazz", "Ljava/lang/Class;", "Lkotlin/reflect/KClass;", "registerAll", "unregisterAllTypesIfNeeded", "Companion", "multitype"}, k = 1, mv = {1, 4, 2})
public class MultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = null;
    private static final String TAG = "MultiTypeAdapter";
    private final int initialCapacity;
    private List<? extends Object> items;
    private Types types;

    /* JADX INFO: compiled from: MultiTypeAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/drakeet/multitype/MultiTypeAdapter$Companion;", "", "()V", "TAG", "", "multitype"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public MultiTypeAdapter() {
        this(null, 0, null, 7, null);
    }

    public MultiTypeAdapter(List<? extends Object> r7) {
        this(r7, 0, null, 6, null);
    }

    public MultiTypeAdapter(List<? extends Object> r7, int r8) {
        this(r7, r8, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ MultiTypeAdapter(List r1, int r2, MutableTypes r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = new MutableTypes(r2, null, 2, 0 == true ? 1 : 0);
    L11:
        this(r1, r2, r3);
    }

    public List<Object> getItems() {
        return this.items;
    }

    public void setItems(List<? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.items = r2;
    }

    public int getInitialCapacity() {
        return this.initialCapacity;
    }

    public Types getTypes() {
        return this.types;
    }

    public void setTypes(Types r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.types = r2;
    }

    public MultiTypeAdapter(List<? extends Object> r2, int r3, Types r4) {
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r4, GloableSearchConfig.KEY_CONFIGS);
        this.items = r2;
        this.initialCapacity = r3;
        this.types = r4;
    }

    public final <T> void register(Class<T> r3, ItemViewDelegate<T, ?> r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "delegate");
        unregisterAllTypesIfNeeded(r3);
        register$multitype(new Type(r3, r4, new DefaultLinker()));
    }

    public final /* synthetic */ <T> void register(ItemViewDelegate<T, ?> r3) {
        Intrinsics.checkNotNullParameter(r3, "delegate");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        register(Object.class, r3);
    }

    public final /* synthetic */ <T> void register(KClass<T> r2, ItemViewDelegate<T, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        register(Object.class, r3);
    }

    public final <T> void register(Class<T> r2, ItemViewBinder<T, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "binder");
        register(r2, r3);
    }

    public final /* synthetic */ <T> void register(ItemViewBinder<T, ?> r3) {
        Intrinsics.checkNotNullParameter(r3, "binder");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        register(Object.class, r3);
    }

    public final /* synthetic */ <T> void register(KClass<T> r2, ItemViewBinder<T, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "binder");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        register(Object.class, r3);
    }

    public final <T> void register$multitype(Type<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        getTypes().register(r2);
        r2.getDelegate().set_adapter$multitype(this);
    }

    public final <T> OneToManyFlow<T> register(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        unregisterAllTypesIfNeeded(r2);
        return new OneToManyBuilder(this, r2);
    }

    public final <T> OneToManyFlow<T> register(KClass<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return register(JvmClassMappingKt.getJavaClass(r2));
    }

    public final void registerAll(Types r5) {
        Intrinsics.checkNotNullParameter(r5, GloableSearchConfig.KEY_CONFIGS);
        int r0 = r5.getSize();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Type r2 = r5.getType(r1);
        unregisterAllTypesIfNeeded(r2.getClazz());
        register$multitype(r2);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r2) {
        return indexInTypesOf$multitype(r2, getItems().get(r2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        ItemViewDelegate r1 = getTypes().getType(r3).getDelegate();
        Context r4 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r4, "parent.context");
        return r1.onCreateViewHolder(r4, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        onBindViewHolder(r2, r3, CollectionsKt.emptyList());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List<? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        Object r5 = getItems().get(r3);
        getOutDelegateByViewHolder(r2).onBindViewHolder(r2, r5, r4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getItems().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r2) {
        Object r0 = getItems().get(r2);
        int r3 = getItemViewType(r2);
        return getTypes().getType(r3).getDelegate().getItemId(r0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        getOutDelegateByViewHolder(r2).onViewRecycled(r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        return getOutDelegateByViewHolder(r2).onFailedToRecycleView(r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        getOutDelegateByViewHolder(r2).onViewAttachedToWindow(r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        getOutDelegateByViewHolder(r2).onViewDetachedFromWindow(r2);
    }

    private final ItemViewDelegate<Object, RecyclerView.ViewHolder> getOutDelegateByViewHolder(RecyclerView.ViewHolder r1) {
        ItemViewDelegate<Object, RecyclerView.ViewHolder> r0 = getTypes().getType(r1.getItemViewType()).getDelegate();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.drakeet.multitype.ItemViewDelegate<kotlin.Any, androidx.recyclerview.widget.RecyclerView.ViewHolder>");
    }

    public final int indexInTypesOf$multitype(int r3, Object r4) throws DelegateNotFoundException {
        Intrinsics.checkNotNullParameter(r4, "item");
        int r0 = getTypes().firstIndexOf(r4.getClass());
        if (r0 == (-1)) goto L7;
        return r0 + getTypes().getType(r0).getLinker().index(r3, r4);
    L7:
        throw new DelegateNotFoundException(r4.getClass());
    }

    private final void unregisterAllTypesIfNeeded(Class<?> r2) {
        if (getTypes().unregister(r2) == false) goto L6;
        Log.w(TAG, "The type " + r2.getSimpleName() + " you originally registered is now overwritten.");
        return;
    }
}
