package wp;

import ai.g0;
import android.media.MediaPlayer;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import mn.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements MediaPlayer.OnPreparedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f22895a;

    public b(g0 r5) {
        this.f22895a = r5;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer r5) {
        i r10 = (i) this.f22895a.f210b;
        if (r10 == null) goto L6;
        PlayerController r11 = (PlayerController) r10.f20153a;
        r11.getClass();
        r11.f(PlayerController.c(3, null));
        return;
    }
}
