package android.view.accessibility;

import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ObricAccessibilityManagerImpl implements IObricAccessibilityManager {
    private static final String TAG = "ObricAccessibilityManagerImpl";
    private transient AccessibilityManager mBase;
    private Pair<Integer, Integer> mInvervalPair;
    private final HashMap<Integer, SendAccessibilityEvent> mSendAccessibilityEventMap;

    private class SendAccessibilityEvent implements Runnable {
        private final AccessibilityEvent mEvent;
        private long mTimeStamp;
        final /* synthetic */ ObricAccessibilityManagerImpl this$0;

        /* JADX INFO: renamed from: -$$Nest$fputmTimeStamp, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m55$$Nest$fputmTimeStamp(SendAccessibilityEvent r0, long r1) {
            r0.mTimeStamp = r1;
        }

        public SendAccessibilityEvent(ObricAccessibilityManagerImpl r3, AccessibilityEvent event) {
            this.this$0 = r3;
            this.mEvent = event;
            this.mTimeStamp = SystemClock.uptimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ObricAccessibilityManagerImpl.m53$$Nest$fgetmBase(this.this$0).isEnabled() == false) goto L6;
            this.mTimeStamp = SystemClock.uptimeMillis();
            ObricAccessibilityManagerImpl.m53$$Nest$fgetmBase(this.this$0).sendAccessibilityEvent(this.mEvent);
            return;
        }

        public long getTimeStamp() {
            return this.mTimeStamp;
        }

        public void setTimeStamp(long timeStamp) {
            this.mTimeStamp = timeStamp;
        }

        public void removeCallback() {
            ObricAccessibilityManagerImpl.m53$$Nest$fgetmBase(this.this$0).mHandler.removeCallbacks(this);
        }

        public void postOrRun(long l) {
            ObricAccessibilityManagerImpl.m54$$Nest$fgetmSendAccessibilityEventMap(this.this$0).put(Integer.valueOf(this.mEvent.getEventType()), this);
            if (l > 0) goto L5;
            run();
            return;
        L5:
            ObricAccessibilityManagerImpl.m53$$Nest$fgetmBase(this.this$0).mHandler.postDelayed(this, l);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBase, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilityManager m53$$Nest$fgetmBase(ObricAccessibilityManagerImpl r0) {
        return r0.mBase;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSendAccessibilityEventMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m54$$Nest$fgetmSendAccessibilityEventMap(ObricAccessibilityManagerImpl r0) {
        return r0.mSendAccessibilityEventMap;
    }

    public ObricAccessibilityManagerImpl(AccessibilityManager base) {
        this.mInvervalPair = new Pair(-1, -1);
        this.mSendAccessibilityEventMap = new HashMap();
        this.mBase = base;
    }

    public boolean requestSendAccessibilityEventForObric(AccessibilityEvent event) {
        int eventType = event.getEventType();
        if (((Integer) this.mInvervalPair.first).intValue() != (-1)) goto L5;
    L18:
        return false;
    L5:
        if (((Integer) this.mInvervalPair.second).intValue() == (-1)) goto L18;
        if ((((Integer) this.mInvervalPair.first).intValue() & eventType) == 0) goto L17;
        int interval = ((Integer) this.mInvervalPair.second).intValue();
        long currentTime = SystemClock.uptimeMillis();
        SendAccessibilityEvent newSendAccessibilityEvent = new SendAccessibilityEvent(this, event);
        SendAccessibilityEvent oldSendAccessibilityEvent = this.mSendAccessibilityEventMap.get(Integer.valueOf(eventType));
        if (oldSendAccessibilityEvent != null) goto L12;
    L14:
        newSendAccessibilityEvent.postOrRun(0);
        return true;
    L12:
        if ((currentTime - oldSendAccessibilityEvent.getTimeStamp()) >= interval) goto L14;
        oldSendAccessibilityEvent.removeCallback();
        SendAccessibilityEvent.m55$$Nest$fputmTimeStamp(newSendAccessibilityEvent, oldSendAccessibilityEvent.getTimeStamp());
        newSendAccessibilityEvent.postOrRun(((long) interval) - (currentTime - oldSendAccessibilityEvent.getTimeStamp()));
        return true;
    L17:
        return false;
    }

    public void setMinumumIntervalObric(int eventType, int interval) {
        Log.d(TAG, "setMinumumIntervalObric of " + eventType + " to: " + interval);
        this.mInvervalPair = new Pair(Integer.valueOf(eventType), Integer.valueOf(interval));
    }
}
