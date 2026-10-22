package com.obric.matrix.account.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.matrix.account.databinding.AccountCountryListHeadViewBinding;
import com.obric.matrix.account.databinding.AccountCountryListItemViewBinding;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0017J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/account/ui/CountryCodeItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/matrix/account/ui/CountryCodeItemAdapter$ViewHolder;", "myList", "", "Lcom/obric/matrix/account/ui/Country;", "listener", "Lcom/obric/matrix/account/ui/OnItemClickListener;", "(Ljava/util/List;Lcom/obric/matrix/account/ui/OnItemClickListener;)V", "HEADER_VIEW_TYPE", "", "ITEM_VIEW_TYPE", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CountryCodeItemAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<l> f8748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f8749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f8751d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/account/ui/CountryCodeItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View r2) {
            kotlin.n0.d.o.f(r2, "itemView");
            super(r2);
        }
    }

    public CountryCodeItemAdapter(List<l> r2, o r3) {
        kotlin.n0.d.o.f(r2, "myList");
        kotlin.n0.d.o.f(r3, "listener");
        this.f8748a = r2;
        this.f8749b = r3;
        this.f8751d = 1;
    }

    public static /* synthetic */ void c(CountryCodeItemAdapter r0, int r1, View r2) {
        e(r0, r1, r2);
    }

    private static final void e(CountryCodeItemAdapter r2, int r3, View r4) {
        kotlin.n0.d.o.f(r2, "this$0");
        r2.f8749b.a(r2.f8748a.get(r3).a(), r2.f8748a.get(r3).c(), r2.f8748a.get(r3).b());
    }

    @SuppressLint({"SetTextI18n"})
    public void d(ViewHolder r4, final int r5) {
        kotlin.n0.d.o.f(r4, "holder");
        if (getItemViewType(r5) != this.f8751d) goto L9;
        r4.itemView.setOnClickListener(new c(this, r5));
        ((TextView) r4.itemView.findViewById(com.obric.matrix.account.g.f8484k)).setText(this.f8748a.get(r5).b());
        ((TextView) r4.itemView.findViewById(com.obric.matrix.account.g.f8482i)).setText('+' + this.f8748a.get(r5).c());
        if (r5 != (getItemCount() - 1)) goto L7;
        View r3 = r4.itemView.findViewById(com.obric.matrix.account.g.n);
        int r6 = 8;
    L8:
        r3.setVisibility(r6);
        return;
    L7:
        r3 = r4.itemView.findViewById(com.obric.matrix.account.g.n);
        r6 = 0;
        goto L8
    L9:
        ((TextView) r4.itemView.findViewById(com.obric.matrix.account.g.r)).setText(this.f8748a.get(r5).b());
    }

    public ViewHolder f(ViewGroup r4, int r5) {
        kotlin.n0.d.o.f(r4, "parent");
        if (r5 != this.f8751d) goto L6;
        AccountCountryListItemViewBinding r3 = AccountCountryListItemViewBinding.c(LayoutInflater.from(r4.getContext()), r4, false);
        kotlin.n0.d.o.e(r3, "inflate(LayoutInflater.f…            parent,false)");
        ConstraintLayout r6 = r3.b();
        kotlin.n0.d.o.e(r6, "binding.root");
        return new ViewHolder(r6);
    L6:
        AccountCountryListHeadViewBinding r7 = AccountCountryListHeadViewBinding.c(LayoutInflater.from(r4.getContext()), r4, false);
        kotlin.n0.d.o.e(r7, "inflate(LayoutInflater.f…            parent,false)");
        ConstraintLayout r8 = r7.b();
        kotlin.n0.d.o.e(r8, "binding.root");
        return new ViewHolder(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f8748a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r2) {
        if (kotlin.n0.d.o.a(this.f8748a.get(r2).a(), "") == false) goto L6;
        return this.f8750c;
    L6:
        return this.f8751d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        d((ViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return f(r1, r2);
    }
}
