package obric.widget.tabswitcher;

import obric.widget.tabswitcher.model.TabBrick;

/* JADX INFO: loaded from: classes5.dex */
public interface Pickable {
    void cancelPick(TabBrick tabBrick);

    TabBrick peek(float rawX, float rawY);

    TabBrick pick(float rawX, float rawY);

    void update(TabBrick tabBrick, float rawX, float rawY);
}
