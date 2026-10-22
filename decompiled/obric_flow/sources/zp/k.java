package zp;

import android.view.ViewGroup;
import com.obric.common.oea.style.scene.alpha.AlphaView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;

/* JADX INFO: loaded from: classes2.dex */
public interface k {
    void a();

    void b(float r5, float r10);

    void c(AlphaView r5);

    void d(AlphaView r5);

    void e();

    int getMeasuredHeight();

    int getMeasuredWidth();

    ScaleType getScaleType();

    void onPause();

    void release();

    void requestRender();

    void setLayoutParams(ViewGroup.LayoutParams r5);

    void setPlayerController(up.a r5);

    void setVideoRenderer(xp.b r5);
}
