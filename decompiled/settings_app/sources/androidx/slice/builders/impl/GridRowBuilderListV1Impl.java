package androidx.slice.builders.impl;

import android.app.PendingIntent;
import android.net.Uri;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Pair;
import androidx.slice.Slice;
import androidx.slice.builders.GridRowBuilder;
import androidx.slice.builders.SliceAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GridRowBuilderListV1Impl extends TemplateBuilderImpl {
    private SliceAction mPrimaryAction;

    public static final class CellBuilderImpl extends TemplateBuilderImpl {
        private PendingIntent mContentIntent;

        CellBuilderImpl(GridRowBuilderListV1Impl r2) {
            super(r2.createChildBuilder(), null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void fillFrom(GridRowBuilder.CellBuilder r7) {
            if (r7.getCellDescription() == null) goto L6;
            setContentDescription(r7.getCellDescription());
        L6:
            if (r7.getContentIntent() == null) goto L8;
            setContentIntent(r7.getContentIntent());
        L8:
            List<Object> r0 = r7.getObjects();
            List<Integer> r1 = r7.getTypes();
            List<Boolean> r8 = r7.getLoadings();
            int r2 = 0;
        L10:
            if (r2 >= r0.size()) goto L22;
            int r3 = r1.get(r2).intValue();
            if (r3 != 0) goto L14;
            addText((CharSequence) r0.get(r2), r8.get(r2).booleanValue());
        L21:
            r2 = r2 + 1;
            goto L10
        L14:
            if (r3 != 1) goto L16;
            addTitleText((CharSequence) r0.get(r2), r8.get(r2).booleanValue());
            goto L21
        L16:
            if (r3 != 2) goto L21;
            Pair r4 = (Pair) r0.get(r2);
            addImage((IconCompat) r4.first, ((Integer) r4.second).intValue(), r8.get(r2).booleanValue());
            goto L21
        }

        private CellBuilderImpl(Uri r2) {
            super(new Slice.Builder(r2), null);
        }

        private void addText(CharSequence r2) {
            addText(r2, false);
        }

        private void addText(CharSequence r2, boolean r3) {
            if (r3 == false) goto L4;
            String[] r4 = {"partial"};
        L5:
            getBuilder().addText(r2, null, r4);
            return;
        L4:
            r4 = new String[0];
            goto L5
        }

        private void addTitleText(CharSequence r2) {
            addTitleText(r2, false);
        }

        private void addTitleText(CharSequence r2, boolean r3) {
            if (r3 == false) goto L5;
            String[] r4 = {"partial", "title"};
        L6:
            getBuilder().addText(r2, null, r4);
            return;
        L5:
            r4 = new String[]{"title"};
            goto L6
        }

        private void addImage(IconCompat r2, int r3) {
            addImage(r2, r3, false);
        }

        private void addImage(IconCompat r3, int r4, boolean r5) {
            ArrayList r0 = new ArrayList();
            if (r4 == 0) goto L6;
            r0.add("no_tint");
        L6:
            if (r4 != 2) goto L8;
            r0.add("large");
        L8:
            if (r5 == false) goto L10;
            r0.add("partial");
        L10:
            getBuilder().addIcon(r3, null, r0);
        }

        private void setContentIntent(PendingIntent r1) {
            this.mContentIntent = r1;
        }

        private void setContentDescription(CharSequence r3) {
            getBuilder().addText(r3, "content_description", new String[0]);
        }

        @Override // androidx.slice.builders.impl.TemplateBuilderImpl
        public void apply(Slice.Builder r3) {
            getBuilder().addHints(new String[]{"horizontal"});
            PendingIntent r0 = this.mContentIntent;
            if (r0 == null) goto L5;
            r3.addAction(r0, getBuilder().build(), null);
            return;
        L5:
            r3.addSubSlice(getBuilder().build());
        }
    }

    public GridRowBuilderListV1Impl(ListBuilderV1Impl r2, GridRowBuilder r3) {
        super(r2.createChildBuilder(), null);
        if (r3.getLayoutDirection() == (-1)) goto L6;
        setLayoutDirection(r3.getLayoutDirection());
    L6:
        if (r3.getDescription() == null) goto L9;
        setContentDescription(r3.getDescription());
    L9:
        if (r3.getSeeMoreIntent() == null) goto L12;
        setSeeMoreAction(r3.getSeeMoreIntent());
    L15:
        if (r3.getPrimaryAction() == null) goto L17;
        setPrimaryAction(r3.getPrimaryAction());
    L17:
        Iterator<GridRowBuilder.CellBuilder> r4 = r3.getCells().iterator();
    L19:
        if (r4.hasNext() == false) goto L21;
        addCell(r4.next());
        goto L19
    L21:
        return;
    L12:
        if (r3.getSeeMoreCell() == null) goto L15;
        setSeeMoreCell(r3.getSeeMoreCell());
        goto L15
    }

    @Override // androidx.slice.builders.impl.TemplateBuilderImpl
    public void apply(Slice.Builder r2) {
        r2.addHints(new String[]{"horizontal"});
        SliceAction r1 = this.mPrimaryAction;
        if (r1 == null) goto L6;
        r1.setPrimaryAction(r2);
        return;
    }

    public void addCell(GridRowBuilder.CellBuilder r2) {
        CellBuilderImpl r0 = new CellBuilderImpl(this);
        r0.fillFrom(r2);
        r0.apply(getBuilder());
    }

    public void setSeeMoreCell(GridRowBuilder.CellBuilder r3) {
        CellBuilderImpl r0 = new CellBuilderImpl(this);
        r0.fillFrom(r3);
        r0.getBuilder().addHints(new String[]{"see_more"});
        r0.apply(getBuilder());
    }

    public void setSeeMoreAction(PendingIntent r4) {
        getBuilder().addSubSlice(new Slice.Builder(getBuilder()).addHints(new String[]{"see_more"}).addAction(r4, new Slice.Builder(getBuilder()).build(), null).build());
    }

    public void setPrimaryAction(SliceAction r1) {
        this.mPrimaryAction = r1;
    }

    public void setContentDescription(CharSequence r3) {
        getBuilder().addText(r3, "content_description", new String[0]);
    }

    public void setLayoutDirection(int r3) {
        getBuilder().addInt(r3, "layout_direction", new String[0]);
    }
}
