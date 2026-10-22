package sf;

import com.bytedance.ai.ex.widget.WidgetView;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.TTVideoEngine;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import m.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends f0 {
    public final /* synthetic */ c f;
    public final /* synthetic */ String g;

    public b(c r5, String r10) {
        this.f = r5;
        this.g = r10;
    }

    @Override // m.f0
    public final int a() {
        if (Intrinsics.areEqual(WidgetView.UI_MODE_LIGHT, this.g) == false) goto L6;
        return 2;
    L6:
        return 0;
    }

    @Override // m.f0
    public final void h(TTVideoEngine r10, pf.b r11) {
        Intrinsics.checkNotNullParameter(r10, "engine");
        Intrinsics.checkNotNullParameter(r11, "item");
        WeakReference r5 = new WeakReference(r10);
        c r12 = this.f;
        r12.d = r5;
        String r13 = r11.f21336k;
        if (r13 != null) goto L5;
    L8:
        String r14 = r11.f21337l;
        if (r14 != null) goto L11;
    L14:
        pf.a r15 = r11.f21339n;
        r10.setIsMute(r15.f21326a);
        r10.setLooping(r15.f21327b);
        double r16 = r15.f21328c;
        if (0.0d <= r16) goto L17;
    L19:
        float r17 = r15.d;
        PlaybackParams r18 = new PlaybackParams();
        r18.setSpeed(r17);
        r10.setPlaybackParams(r18);
        ReadableMap r19 = r15.g;
        if (r19 == null) goto L27;
        ReadableMapKeySetIterator r20 = r19.keySetIterator();
    L23:
        if (r20.hasNextKey() == false) goto L27;
        String r21 = r20.nextKey();
        String r22 = r19.getString(r21, "");
        if (r22.length() <= 0) goto L23;
        r10.setCustomHeader(r21, r22);
    L27:
        int r23 = r11.f21338m;
        if (r23 <= 0) goto L30;
        r10.setStartTime(r23);
    L30:
        int r24 = r11.f21335j;
        if (r24 <= 0) goto L33;
        r10.setIntOption(161, r24);
    L33:
        Map r25 = r12.e;
        if (r25 == null) goto L36;
        r12.i(r25);
    L36:
        r12.e = null;
        return;
    L17:
        if (r16 > 1.0d) goto L19;
        r10.setIntOption(415, 1);
        float r26 = r15.f21328c;
        r10.setVolume(r26, r26);
        goto L19
    L11:
        if (r14.length() == 0) goto L14;
        r10.setSubTag(r11.f21337l);
        goto L14
    L5:
        if (r13.length() == 0) goto L8;
        r10.setTag(r11.f21336k);
        goto L8
    }
}
