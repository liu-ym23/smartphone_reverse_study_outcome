package rf;

import com.bytedance.lynx.media.AbsMediaEngineView;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements VideoEngineCallback, a, VideoEngineInfoListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbsMediaEngineView f21737a;

    public b(AbsMediaEngineView r5) {
        Intrinsics.checkNotNullParameter(r5, "mediaUI");
        this.f21737a = r5;
    }
}
