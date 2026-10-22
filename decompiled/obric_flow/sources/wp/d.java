package wp;

import ai.g0;
import android.media.MediaPlayer;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import g8.g;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements MediaPlayer.OnInfoListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f22897a;

    public d(g0 r5) {
        this.f22897a = r5;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer r5, int r10, int r11) {
        if (r10 != 3) goto L9;
        g r12 = (g) this.f22897a.d;
        if (r12 == null) goto L10;
        PlayerController.a((PlayerController) r12.f17073b).a();
        return false;
    L10:
        return false;
    L9:
        return false;
    }
}
