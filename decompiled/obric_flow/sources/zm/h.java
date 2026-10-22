package zm;

import android.graphics.Matrix;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.event.EventTarget$EnableStatus;
import com.lynx.tasm.behavior.event.EventTarget$PointerEventsValue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class h extends ClickableSpan implements wm.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f23490c;
    public final HashMap d;
    public final EventTarget$EnableStatus e;
    public final EventTarget$EnableStatus f;
    public final EventTarget$PointerEventsValue g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ReadableMap f23491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f23492i;

    public h(int r5, HashMap r10, EventTarget$EnableStatus r11, boolean r12, EventTarget$EnableStatus r13, EventTarget$PointerEventsValue r14, ReadableMap r15) {
        new JavaOnlyMap();
        new Matrix();
        this.f23488a = r5;
        this.f23490c = null;
        this.e = r11;
        this.f = r13;
        this.g = r14;
        this.f23491h = r15;
        this.f23492i = r12;
        if (r10 == null) goto L6;
        HashMap r16 = new HashMap();
        this.d = r16;
        r16.putAll(r10);
        return;
    L6:
        this.d = null;
    }

    @Override // wm.a
    public final boolean blockNativeEvent(MotionEvent r5) {
        return false;
    }

    @Override // wm.a
    public final boolean consumeSlideEvent(float r5) {
        return false;
    }

    @Override // wm.a
    public final boolean dispatchEvent(on.d r5) {
        return false;
    }

    @Override // wm.a
    public final boolean dispatchTouch(MotionEvent r5) {
        return false;
    }

    @Override // wm.a
    public final boolean enableTouchPseudoPropagation() {
        return this.f23492i;
    }

    @Override // wm.a
    public final boolean eventThrough(float r5, float r10) {
        EventTarget$EnableStatus r11 = EventTarget$EnableStatus.f10244a;
        EventTarget$EnableStatus r12 = this.f;
        if (r12 != r11) goto L7;
        return true;
    L7:
        if (r12 != EventTarget$EnableStatus.f10245b) goto L9;
        return false;
    L9:
        wm.a r13 = (wm.a) this.f23490c.get();
        if (r13 != null) goto L12;
        return false;
    L12:
        return r13.eventThrough(r5, r10);
    }

    @Override // wm.a
    public final HashMap getChildrenLynxPageUI() {
        return null;
    }

    @Override // wm.a
    public final Map getEvents() {
        return this.d;
    }

    @Override // wm.a
    public final int getGestureArenaMemberId() {
        return 0;
    }

    @Override // wm.a
    public final wm.a getParentLynxPageUI() {
        return null;
    }

    @Override // wm.a
    public final int getPseudoStatus() {
        return this.f23489b;
    }

    @Override // wm.a
    public final wm.a getRootLynxPageUI() {
        return null;
    }

    @Override // wm.a
    public final int getSign() {
        return this.f23488a;
    }

    @Override // wm.a
    public final boolean hasConsumeSlideEventAngles() {
        return false;
    }

    @Override // wm.a
    public final boolean ignoreFocus() {
        EventTarget$EnableStatus r5 = EventTarget$EnableStatus.f10244a;
        EventTarget$EnableStatus r10 = this.e;
        if (r10 != r5) goto L7;
        return true;
    L7:
        if (r10 != EventTarget$EnableStatus.f10245b) goto L10;
        return false;
    L10:
        if (((wm.a) this.f23490c.get()) != null) goto L12;
        return false;
    L12:
        return ((wm.a) this.f23490c.get()).ignoreFocus();
    }

    @Override // wm.a
    public final boolean isFocusable() {
        return false;
    }

    @Override // wm.a
    public final void offResponseChain() {
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r5) {
    }

    @Override // wm.a
    public final void onEventBubble(boolean r5, long r10) {
        throw null;
    }

    @Override // wm.a
    public final void onEventCapture(boolean r5, long r10) {
        throw null;
    }

    @Override // wm.a
    public final void onEventFire(boolean r5, long r10) {
        throw null;
    }

    @Override // wm.a
    public final void onFocusChanged(boolean r5, boolean r10) {
    }

    @Override // wm.a
    public final void onPseudoStatusChanged(int r5, int r10) {
        this.f23489b = r10;
    }

    @Override // wm.a
    public final void onResponseChain() {
    }

    @Override // wm.a
    public final wm.a parent() {
        return (wm.a) this.f23490c.get();
    }

    @Override // wm.a
    public final EventTarget$PointerEventsValue pointerEvents() {
        EventTarget$PointerEventsValue r5 = EventTarget$PointerEventsValue.f10249c;
        EventTarget$PointerEventsValue r10 = this.g;
        if (r10 == r5) goto L6;
        return r10;
    L6:
        if (((wm.a) this.f23490c.get()) == null) goto L10;
        return ((wm.a) this.f23490c.get()).pointerEvents();
    L10:
        return EventTarget$PointerEventsValue.f10247a;
    }

    @Override // wm.a
    public final void setEventID(long r5) {
    }

    @Override // wm.a
    public final void startEventBubble(long r5) {
    }

    @Override // wm.a
    public final void startEventCapture(long r5) {
    }

    @Override // wm.a
    public final void startEventFire(boolean r5, long r10) {
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
    }
}
