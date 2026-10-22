package wp;

import ai.g0;
import android.media.MediaPlayer;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import jg.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements MediaPlayer.OnCompletionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f22894a;

    public a(g0 r5) {
        this.f22894a = r5;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer r5) {
        k r10 = (k) this.f22894a.f209a;
        if (r10 == null) goto L6;
        PlayerController r11 = (PlayerController) r10.f18339b;
        PlayerController.a(r11).e();
        r11.e = PlayerState.PAUSED;
        r11.b();
        return;
    }
}
