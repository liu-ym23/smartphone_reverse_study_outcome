package obric.widget.tabswitcher.model;

import java.util.List;
import obric.widget.tabswitcher.model.Tab;

/* JADX INFO: loaded from: classes5.dex */
public interface ITabManager<T extends Tab> {
    List<T> getMoreTabs();

    List<T> getTabs();

    void init();

    void replaceTabList(Tab tab, Tab another);

    void updateTabList();
}
