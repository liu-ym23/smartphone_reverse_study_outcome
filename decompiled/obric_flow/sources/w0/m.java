package w0;

import com.bytedance.ai.api.model.view.WidgetEvent;

/* JADX INFO: loaded from: classes.dex */
public interface m {
    void onDestroy();

    void onEvent(WidgetEvent r5);

    void onPageError();

    void onPageFinish();

    void onPageStart();

    void onStart();
}
