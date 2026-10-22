package com.obric.oui.banner;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.banner.interfaces.BannerOperator;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.MainDispatcherLoader;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class BannerViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f173a;
    public BannerOperator b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ContextScope f174d;
    public final Observer e;

    public BannerViewHolder(View r1) {
        super(r1);
        this.c = -1;
        this.e = new BannerViewHolder$selectPositionObserver$1(this);
    }

    public final void a(boolean r5) {
        BannerOperator r0 = this.b;
        Integer r1 = null;
        if (r0 == null) goto L7;
        LiveData r2 = r0.getSelectedPosition();
        if (r2 == null) goto L7;
        Integer r3 = (Integer) r2.getValue();
    L8:
        int r4 = this.c;
        if (r3 != null) goto L12;
    L21:
        BannerOperator r6 = this.b;
        if (r6 == null) goto L26;
        LiveData r7 = r6.getSelectedPosition();
        if (r7 == null) goto L26;
        r1 = (Integer) r7.getValue();
    L26:
        int r8 = this.c;
        if (r1 != null) goto L30;
    L31:
        if (r5 == false) goto L33;
    L34:
        c();
        return;
    L33:
        if (this.f173a == true) goto L34;
        return;
    L30:
        if (r1.intValue() != r8) goto L31;
        return;
    L12:
        if (r3.intValue() != r4) goto L21;
        if (r5 == false) goto L15;
    L16:
        ExecutorCoroutineDispatcher r9 = Dispatchers.f372a;
        MainCoroutineDispatcher r10 = MainDispatcherLoader.f422a;
        CompletableJob r11 = SupervisorKt.a();
        r10.getClass();
        CoroutineContext r12 = CoroutineContext.DefaultImpls.a(r10, r11);
        if (r12.f(Job.g) != null) goto L20;
        r12 = r12.i(new JobImpl(null));
    L20:
        this.f174d = new ContextScope(r12);
        this.f173a = true;
        goto L21
    L15:
        if (this.f173a == true) goto L21;
    L7:
        r3 = null;
        goto L8
    }

    public abstract void b(BannerData r1);

    public final void c() {
        ContextScope r0 = this.f174d;
        if (r0 == null) goto L9;
        Job r1 = (Job) r0.b.f(Job.g);
        if (r1 == null) goto L8;
        r1.a(null);
        goto L9
    L8:
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + r0).toString());
    L9:
        this.f173a = false;
    }
}
