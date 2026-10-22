package rn;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    boolean canConsumeGesture(float r5, float r10);

    int getGestureArenaMemberId();

    Map getGestureDetectorMap();

    Map getGestureHandlers();

    int getMemberScrollX();

    int getMemberScrollY();

    int getScrollContainerDirection();

    int getSign();

    boolean isAtBorder(boolean r5);

    void onGestureScrollBy(float r5, float r10);

    void onInvalidate();
}
