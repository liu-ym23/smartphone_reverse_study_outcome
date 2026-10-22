package uf;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.lynx.base.log.LynxLog;
import com.ss.ttvideoengine.DataSource;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.model.VideoRef;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pf.b f22338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public of.e f22339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rf.a f22340c;
    public DataSource d;

    public b(Context r5) {
        super(r5, null, 0);
        this.f22338a = null;
        this.f22339b = null;
    }

    public static Resolution b(String r5) {
        Resolution[] r10 = Resolution.values();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        Resolution r13 = r10[r12];
        if (TextUtils.equals(r5, r13.toString(VideoRef.TYPE_VIDEO)) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L9:
        return Resolution.Standard;
    }

    public final boolean c() {
        if (this.f22338a != null) goto L5;
    L9:
        LynxLog.b(4, "BaseMediaView", "setUpController first before any action");
        return false;
    L5:
        if (this.f22339b == null) goto L9;
        return true;
    }

    public int getDuration() {
        if (c() == true) goto L7;
        return -1;
    L7:
        return this.f22339b.i();
    }

    public void setDataSource(DataSource r5) {
        this.d = r5;
    }

    public void setLoop(boolean r5) {
        if (c() == true) goto L5;
        return;
    L5:
        this.f22339b.h(r5);
    }

    public void setMediaVideoEngineCallback(rf.a r5) {
        this.f22340c = r5;
    }

    public void setMute(boolean r5) {
        if (c() == true) goto L5;
        return;
    L5:
        this.f22339b.j(r5);
    }

    public void setResolution(String r5) {
        if (c() == true) goto L5;
        return;
    L5:
        this.f22339b.e(b(r5));
    }

    public void setSpeed(float r5) {
        if (c() == true) goto L5;
        return;
    L5:
        this.f22339b.b(r5);
    }

    public void setVideoEngineCallback(VideoEngineCallback r5) {
    }

    public void setVideoEngineInfoListener(VideoEngineInfoListener r5) {
    }
}
