package up;

import com.obric.common.oea.style.scene.alpha.AlphaView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PlayerController f22424b;

    public /* synthetic */ c(PlayerController r5, int r10) {
        this.f22423a = r10;
        this.f22424b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f22423a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        zm.c r5 = this.f22424b.f;
        if (r5 == null) goto L12;
        ((AlphaView) r5.f23470b).getListener();
        return;
    L12:
        return;
    L8:
        zm.c r10 = this.f22424b.f;
        if (r10 == null) goto L13;
        ((AlphaView) r10.f23470b).getListener();
        return;
    }
}
