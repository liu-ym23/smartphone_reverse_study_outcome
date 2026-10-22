package rj;

import android.content.Context;
import com.bytedance.ttnet.TTNetInit;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f21776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f21777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f21778c;

    public e(Context r5, boolean r10, boolean r11) {
        this.f21776a = r5;
        this.f21777b = r10;
        this.f21778c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r5 = this.f21777b;
        boolean r10 = this.f21778c;
        TTNetInit.access$000(this.f21776a, r5, r10);
    }
}
