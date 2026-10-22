package wp;

import ai.g0;
import android.media.MediaPlayer;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements MediaPlayer.OnErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f22896a;

    public c(g0 r5) {
        this.f22896a = r5;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer r5, int r10, int r11) {
        k6.a r12 = (k6.a) this.f22896a.f211c;
        if (r12 == null) goto L7;
        Intrinsics.checkNotNullParameter("", "desc");
        PlayerController r13 = (PlayerController) r12.f18623a;
        r13.getClass();
        r13.b();
        return false;
    L7:
        return false;
    }
}
