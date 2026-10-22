package up;

import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f22420a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f22421b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f22422c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r5 = new int[AlphaVideoViewType.values().length];
        f22420a = r5;
        r5[AlphaVideoViewType.GL_SURFACE_VIEW.ordinal()] = 1;
        r5[AlphaVideoViewType.GL_TEXTURE_VIEW.ordinal()] = 2;
        int[] r10 = new int[PlayerState.values().length];
        f22421b = r10;
        r10[PlayerState.PREPARED.ordinal()] = 1;
        PlayerState r11 = PlayerState.PAUSED;
        r10[r11.ordinal()] = 2;
        r10[PlayerState.NOT_PREPARED.ordinal()] = 3;
        r10[PlayerState.STOPPED.ordinal()] = 4;
        int[] r12 = new int[PlayerState.values().length];
        f22422c = r12;
        PlayerState r13 = PlayerState.STARTED;
        r12[r13.ordinal()] = 1;
        int[] r14 = new int[PlayerState.values().length];
        d = r14;
        r14[r13.ordinal()] = 1;
        r14[r11.ordinal()] = 2;
    }
}
