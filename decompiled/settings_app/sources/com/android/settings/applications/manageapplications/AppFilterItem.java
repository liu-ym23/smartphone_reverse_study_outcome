package com.android.settings.applications.manageapplications;

import com.android.settingslib.applications.ApplicationsState;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class AppFilterItem implements Comparable<AppFilterItem> {
    private final ApplicationsState.AppFilter mFilter;
    private final int mFilterType;
    private final int mTitle;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(AppFilterItem r1) {
        return compareTo2(r1);
    }

    public AppFilterItem(ApplicationsState.AppFilter r1, int r2, int r3) {
        this.mTitle = r3;
        this.mFilterType = r2;
        this.mFilter = r1;
    }

    public int getTitle() {
        return this.mTitle;
    }

    public ApplicationsState.AppFilter getFilter() {
        return this.mFilter;
    }

    public int getFilterType() {
        return this.mFilterType;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(AppFilterItem r1) {
        if (r1 != null) goto L5;
        return 1;
    L5:
        if (this != r1) goto L9;
        return 0;
    L9:
        return this.mFilterType - r1.mFilterType;
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if ((r5 instanceof AppFilterItem) == true) goto L8;
        return false;
    L8:
        if (this != r5) goto L10;
        return true;
    L10:
        AppFilterItem r6 = (AppFilterItem) r5;
        if (this.mTitle == r6.mTitle) goto L13;
        return false;
    L13:
        if (this.mFilterType == r6.mFilterType) goto L15;
        return false;
    L15:
        if (this.mFilter == r6.mFilter) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mFilter, Integer.valueOf(this.mTitle), Integer.valueOf(this.mFilterType)});
    }
}
