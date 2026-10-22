package com.obric.oui.banner;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import h.a.b1;
import h.a.m0;
import h.a.n0;
import h.a.s2;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0010R\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020#8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010+R\"\u0010.\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u0010\u0006¨\u00065"}, d2 = {"Lcom/obric/oui/banner/BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "force", "Lkotlin/f0;", "a", "(Z)V", "", "position", "Lcom/obric/oui/banner/a;", "data", "d", "(ILcom/obric/oui/banner/a;)V", "e", "(Lcom/obric/oui/banner/a;)V", "c", "()V", "f", "g", "h", "i", "I", "getCurrentPosition", "()I", "setCurrentPosition", "(I)V", "currentPosition", "Lcom/obric/oui/banner/i/a;", "b", "Lcom/obric/oui/banner/i/a;", "getBannerOperator", "()Lcom/obric/oui/banner/i/a;", "j", "(Lcom/obric/oui/banner/i/a;)V", "bannerOperator", "Lh/a/m0;", "Lh/a/m0;", "getSelectScope", "()Lh/a/m0;", "setSelectScope", "(Lh/a/m0;)V", "selectScope", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "selectPositionObserver", "Z", "isSelected", "()Z", "setSelected", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public abstract class BannerViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.oui.banner.i.a f10779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected m0 f10781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Observer<Integer> f10782e;

    static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BannerViewHolder f10783a;

        a(BannerViewHolder r1) {
            this.f10783a = r1;
        }

        public final void a(Integer r3) {
            BannerViewHolder.b(this.f10783a, false, 1, null);
        }

        @Override // androidx.lifecycle.Observer
        public /* bridge */ /* synthetic */ void onChanged(Object r1) {
            a((Integer) r1);
        }
    }

    public BannerViewHolder(View r2) {
        o.f(r2, "view");
        super(r2);
        this.f10780c = -1;
        this.f10782e = new a(this);
    }

    private final void a(boolean r4) {
        com.obric.oui.banner.i.a r0 = this.f10779b;
        Integer r1 = null;
        if (r0 == null) goto L7;
        LiveData<Integer> r2 = r0.getSelectedPosition();
        if (r2 == null) goto L7;
        Integer r3 = r2.getValue();
    L8:
        int r5 = this.f10780c;
        if (r3 != null) goto L12;
    L17:
        com.obric.oui.banner.i.a r6 = this.f10779b;
        if (r6 == null) goto L22;
        LiveData<Integer> r7 = r6.getSelectedPosition();
        if (r7 == null) goto L22;
        r1 = r7.getValue();
    L22:
        int r8 = this.f10780c;
        if (r1 != null) goto L26;
    L27:
        if (r4 == false) goto L29;
    L30:
        h();
        return;
    L29:
        if (this.f10778a == true) goto L30;
        return;
    L26:
        if (r1.intValue() != r8) goto L27;
        return;
    L12:
        if (r3.intValue() != r5) goto L17;
        if (r4 == false) goto L15;
    L16:
        g();
        goto L17
    L15:
        if (this.f10778a == true) goto L17;
    L7:
        r3 = null;
        goto L8
    }

    static /* synthetic */ void b(BannerViewHolder r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.a(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkSelectStatus");
    }

    @CallSuper
    public void c() {
        com.obric.oui.banner.i.a r0 = this.f10779b;
        if (r0 == null) goto L8;
        LiveData<Integer> r1 = r0.getSelectedPosition();
        if (r1 == null) goto L9;
        r1.observeForever(this.f10782e);
        return;
    L9:
        return;
    }

    @CallSuper
    public final void d(int r2, com.obric.oui.banner.a r3) {
        o.f(r3, "data");
        this.f10780c = r2;
        e(r3);
        a(true);
    }

    public abstract void e(com.obric.oui.banner.a r1);

    @CallSuper
    public void f() {
        com.obric.oui.banner.i.a r0 = this.f10779b;
        if (r0 == null) goto L7;
        LiveData<Integer> r1 = r0.getSelectedPosition();
        if (r1 == null) goto L7;
        r1.removeObserver(this.f10782e);
    L7:
        h();
    }

    @CallSuper
    public void g() {
        this.f10781d = n0.a(b1.c().plus(s2.b(null, 1, null)));
        this.f10778a = true;
    }

    @CallSuper
    public void h() {
        m0 r0 = this.f10781d;
        if (r0 != null) goto L5;
    L9:
        this.f10778a = false;
        return;
    L5:
        if (r0 == null) goto L7;
        n0.d(r0, null, 1, null);
        goto L9
    L7:
        o.v("selectScope");
        throw null;
    }

    public void i() {
    }

    public final void j(com.obric.oui.banner.i.a r1) {
        this.f10779b = r1;
    }
}
