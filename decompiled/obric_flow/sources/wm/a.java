package wm;

import android.view.MotionEvent;
import com.lynx.tasm.behavior.event.EventTarget$PointerEventsValue;
import java.util.HashMap;
import java.util.Map;
import on.d;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends b {
    boolean blockNativeEvent(MotionEvent r5);

    boolean consumeSlideEvent(float r5);

    boolean dispatchEvent(d r5);

    boolean dispatchTouch(MotionEvent r5);

    boolean enableTouchPseudoPropagation();

    boolean eventThrough(float r5, float r10);

    HashMap getChildrenLynxPageUI();

    Map getEvents();

    int getGestureArenaMemberId();

    a getParentLynxPageUI();

    int getPseudoStatus();

    a getRootLynxPageUI();

    int getSign();

    boolean hasConsumeSlideEventAngles();

    boolean ignoreFocus();

    boolean isFocusable();

    void offResponseChain();

    void onEventBubble(boolean r5, long r10);

    void onEventCapture(boolean r5, long r10);

    void onEventFire(boolean r5, long r10);

    void onFocusChanged(boolean r5, boolean r10);

    void onPseudoStatusChanged(int r5, int r10);

    void onResponseChain();

    a parent();

    EventTarget$PointerEventsValue pointerEvents();

    void setEventID(long r5);

    void startEventBubble(long r5);

    void startEventCapture(long r5);

    void startEventFire(boolean r5, long r10);
}
