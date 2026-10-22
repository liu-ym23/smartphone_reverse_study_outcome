package com.android.settings.dashboard;

import android.app.Activity;
import android.graphics.drawable.Icon;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.android.settings.base.BaseFragment;
import com.android.settingslib.drawer.DashboardCategory;
import com.android.settingslib.drawer.Tile;
import com.obric.oui.lisitem.OCardListItem;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface DashboardFeatureProvider {

    public interface OnIconLoadedListener {
        void onIconLoaded(Icon r1);
    }

    public interface OnTitleLoadedListener {
        void onTitleLoaded(String r1, String r2);
    }

    List<DynamicDataObserver> bindOUIToTileAndGetObservers(Activity r1, BaseFragment r2, boolean r3, OCardListItem r4, Tile r5, String r6, int r7);

    List<DynamicDataObserver> bindPreferenceToTileAndGetObservers(FragmentActivity r1, DashboardFragment r2, boolean r3, Preference r4, Tile r5, String r6, int r7);

    List<DashboardCategory> getAllCategories();

    String getDashboardKeyForTile(Tile r1);

    void getIconFromUri(Tile r1, boolean r2, OnIconLoadedListener r3);

    DashboardCategory getTilesForCategory(String r1);

    void getTitleAndSummaryFromUri(Tile r1, OnTitleLoadedListener r2);

    String getTitleFromUri(Tile r1);

    void openTileIntent(FragmentActivity r1, Tile r2);
}
