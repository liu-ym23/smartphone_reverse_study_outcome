package obric.widget.tabswitcher;

import obric.widget.tabswitcher.model.TabBrick;

/* JADX INFO: loaded from: classes5.dex */
public interface Putable {
    public static final int PUT_END = 1;
    public static final int PUT_START = 0;

    TabBrick arouse(float rawX, float rawY);

    void disarouse(TabBrick tabBrick);

    TabBrick peek(float rawX, float rawY);

    void put(int putState, TabBrick tabBrick, float rawX, float rawY);
}
