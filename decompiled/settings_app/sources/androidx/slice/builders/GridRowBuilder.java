package androidx.slice.builders;

import android.app.PendingIntent;
import android.net.Uri;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GridRowBuilder {
    private final List<CellBuilder> mCells;
    private CharSequence mDescription;
    private boolean mHasSeeMore;
    private int mLayoutDirection;
    private SliceAction mPrimaryAction;
    private CellBuilder mSeeMoreCell;
    private PendingIntent mSeeMoreIntent;

    public static class CellBuilder {
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_TEXT = 0;
        public static final int TYPE_TITLE = 1;
        private CharSequence mCellDescription;
        private PendingIntent mContentIntent;
        private List<Boolean> mLoadings;
        private List<Object> mObjects;
        private List<Integer> mTypes;

        public CellBuilder() {
            this.mObjects = new ArrayList();
            this.mTypes = new ArrayList();
            this.mLoadings = new ArrayList();
        }

        public CellBuilder(GridRowBuilder r1) {
            this.mObjects = new ArrayList();
            this.mTypes = new ArrayList();
            this.mLoadings = new ArrayList();
        }

        public CellBuilder(GridRowBuilder r1, Uri r2) {
            this.mObjects = new ArrayList();
            this.mTypes = new ArrayList();
            this.mLoadings = new ArrayList();
        }

        public CellBuilder addText(CharSequence r2) {
            return addText(r2, false);
        }

        public CellBuilder addText(CharSequence r2, boolean r3) {
            this.mObjects.add(r2);
            this.mTypes.add(0);
            this.mLoadings.add(Boolean.valueOf(r3));
            return this;
        }

        public CellBuilder addTitleText(CharSequence r2) {
            return addTitleText(r2, false);
        }

        public CellBuilder addTitleText(CharSequence r2, boolean r3) {
            this.mObjects.add(r2);
            this.mTypes.add(1);
            this.mLoadings.add(Boolean.valueOf(r3));
            return this;
        }

        public CellBuilder addImage(IconCompat r2, int r3) {
            return addImage(r2, r3, false);
        }

        public CellBuilder addImage(IconCompat r3, int r4, boolean r5) {
            this.mObjects.add(new Pair(r3, Integer.valueOf(r4)));
            this.mTypes.add(2);
            this.mLoadings.add(Boolean.valueOf(r5));
            return this;
        }

        public CellBuilder setContentIntent(PendingIntent r1) {
            this.mContentIntent = r1;
            return this;
        }

        public CellBuilder setContentDescription(CharSequence r1) {
            this.mCellDescription = r1;
            return this;
        }

        public List<Object> getObjects() {
            return this.mObjects;
        }

        public List<Integer> getTypes() {
            return this.mTypes;
        }

        public List<Boolean> getLoadings() {
            return this.mLoadings;
        }

        public CharSequence getCellDescription() {
            return this.mCellDescription;
        }

        public PendingIntent getContentIntent() {
            return this.mContentIntent;
        }

        public CharSequence getTitle() {
            int r0 = 0;
        L4:
            if (r0 >= this.mObjects.size()) goto L10;
            if (this.mTypes.get(r0).intValue() == 1) goto L8;
            r0 = r0 + 1;
            goto L4
        L8:
            return (CharSequence) this.mObjects.get(r0);
        L10:
            return null;
        }

        public CharSequence getSubtitle() {
            int r0 = 0;
        L4:
            if (r0 >= this.mObjects.size()) goto L10;
            if (this.mTypes.get(r0).intValue() == 0) goto L8;
            r0 = r0 + 1;
            goto L4
        L8:
            return (CharSequence) this.mObjects.get(r0);
        L10:
            return null;
        }
    }

    public GridRowBuilder() {
        this.mCells = new ArrayList();
        this.mLayoutDirection = -1;
    }

    public GridRowBuilder(ListBuilder r1) {
        this.mCells = new ArrayList();
        this.mLayoutDirection = -1;
    }

    public GridRowBuilder addCell(CellBuilder r2) {
        this.mCells.add(r2);
        return this;
    }

    public GridRowBuilder addCell(Consumer<CellBuilder> r2) {
        CellBuilder r0 = new CellBuilder(this);
        r2.accept(r0);
        return addCell(r0);
    }

    public GridRowBuilder setSeeMoreCell(CellBuilder r2) {
        if (this.mHasSeeMore == true) goto L7;
        this.mSeeMoreCell = r2;
        this.mHasSeeMore = true;
        return this;
    L7:
        throw new IllegalStateException("Trying to add see more cell when one has already been added");
    }

    public GridRowBuilder setSeeMoreCell(Consumer<CellBuilder> r2) {
        CellBuilder r0 = new CellBuilder(this);
        r2.accept(r0);
        return setSeeMoreCell(r0);
    }

    public GridRowBuilder setSeeMoreAction(PendingIntent r2) {
        if (this.mHasSeeMore == true) goto L7;
        this.mSeeMoreIntent = r2;
        this.mHasSeeMore = true;
        return this;
    L7:
        throw new IllegalStateException("Trying to add see more action when one has already been added");
    }

    public GridRowBuilder setPrimaryAction(SliceAction r1) {
        this.mPrimaryAction = r1;
        return this;
    }

    public GridRowBuilder setContentDescription(CharSequence r1) {
        this.mDescription = r1;
        return this;
    }

    public GridRowBuilder setLayoutDirection(int r1) {
        this.mLayoutDirection = r1;
        return this;
    }

    public SliceAction getPrimaryAction() {
        return this.mPrimaryAction;
    }

    public List<CellBuilder> getCells() {
        return this.mCells;
    }

    public CellBuilder getSeeMoreCell() {
        return this.mSeeMoreCell;
    }

    public PendingIntent getSeeMoreIntent() {
        return this.mSeeMoreIntent;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public int getLayoutDirection() {
        return this.mLayoutDirection;
    }
}
