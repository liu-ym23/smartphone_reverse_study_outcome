package androidx.slice.builders.impl;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.Slice;
import androidx.slice.SliceItem;
import androidx.slice.SliceSpec;
import androidx.slice.builders.GridRowBuilder;
import androidx.slice.builders.SliceAction;
import androidx.slice.core.SliceHints;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ListBuilderBasicImpl extends TemplateBuilderImpl implements ListBuilder {
    private IconCompat mIconCompat;
    boolean mIsError;
    private Set<String> mKeywords;
    private SliceAction mSliceAction;
    private CharSequence mSubtitle;
    private CharSequence mTitle;

    @Override // androidx.slice.builders.impl.ListBuilder
    public void addAction(SliceAction r1) {
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void setSeeMoreAction(PendingIntent r1) {
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void setSeeMoreRow(androidx.slice.builders.ListBuilder.RowBuilder r1) {
    }

    public ListBuilderBasicImpl(Slice.Builder r1, SliceSpec r2) {
        super(r1, r2);
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void addRow(androidx.slice.builders.ListBuilder.RowBuilder r2) {
        if (this.mTitle != null) goto L8;
        if (r2.getTitle() == null) goto L8;
        this.mTitle = r2.getTitle();
    L8:
        if (this.mSubtitle != null) goto L13;
        if (r2.getSubtitle() == null) goto L13;
        this.mSubtitle = r2.getSubtitle();
    L13:
        if (this.mSliceAction != null) goto L18;
        if (r2.getPrimaryAction() == null) goto L18;
        this.mSliceAction = r2.getPrimaryAction();
    L18:
        if (this.mSliceAction != null) goto L23;
        if (r2.getTitleAction() == null) goto L23;
        this.mSliceAction = r2.getTitleAction();
    L23:
        if (this.mIconCompat == null) goto L25;
        return;
    L25:
        if (r2.getTitleIcon() == null) goto L29;
        this.mIconCompat = r2.getTitleIcon();
        return;
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void addGridRow(GridRowBuilder r4) {
        Iterator<GridRowBuilder.CellBuilder> r0 = r4.getCells().iterator();
    L4:
        if (r0.hasNext() == false) goto L26;
        GridRowBuilder.CellBuilder r1 = r0.next();
        if (this.mTitle != null) goto L17;
        if (r1.getTitle() == null) goto L11;
        this.mTitle = r1.getTitle();
        goto L17
    L11:
        if (r1.getSubtitle() == null) goto L14;
        this.mTitle = r1.getSubtitle();
        goto L17
    L14:
        if (r1.getCellDescription() == null) goto L17;
        this.mTitle = r1.getCellDescription();
    L17:
        if (this.mSubtitle != null) goto L22;
        if (r1.getSubtitle() == null) goto L22;
        this.mSubtitle = r1.getSubtitle();
    L22:
        if (this.mTitle == null) goto L4;
        if (this.mSubtitle == null) goto L4;
    L26:
        if (this.mSliceAction == null) goto L28;
        return;
    L28:
        if (r4.getPrimaryAction() == null) goto L42;
        SliceAction r5 = r4.getPrimaryAction();
        this.mSliceAction = r5;
        if (this.mTitle == null) goto L32;
        return;
    L32:
        if (r5.getTitle() == null) goto L44;
        this.mTitle = this.mSliceAction.getTitle();
        return;
    L44:
        return;
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void setHeader(androidx.slice.builders.ListBuilder.HeaderBuilder r2) {
        if (r2.getTitle() == null) goto L6;
        this.mTitle = r2.getTitle();
    L6:
        if (r2.getSubtitle() == null) goto L9;
        this.mSubtitle = r2.getSubtitle();
    L9:
        if (r2.getPrimaryAction() == null) goto L12;
        this.mSliceAction = r2.getPrimaryAction();
        return;
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void addInputRange(androidx.slice.builders.ListBuilder.InputRangeBuilder r2) {
        if (this.mTitle != null) goto L8;
        if (r2.getTitle() == null) goto L8;
        this.mTitle = r2.getTitle();
    L8:
        if (this.mSubtitle != null) goto L13;
        if (r2.getSubtitle() == null) goto L13;
        this.mSubtitle = r2.getSubtitle();
    L13:
        if (this.mSliceAction != null) goto L18;
        if (r2.getPrimaryAction() == null) goto L18;
        this.mSliceAction = r2.getPrimaryAction();
    L18:
        if (this.mIconCompat == null) goto L20;
        return;
    L20:
        if (r2.getThumb() == null) goto L24;
        this.mIconCompat = r2.getThumb();
        return;
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void addRange(androidx.slice.builders.ListBuilder.RangeBuilder r2) {
        if (this.mTitle != null) goto L8;
        if (r2.getTitle() == null) goto L8;
        this.mTitle = r2.getTitle();
    L8:
        if (this.mSubtitle != null) goto L13;
        if (r2.getSubtitle() == null) goto L13;
        this.mSubtitle = r2.getSubtitle();
    L13:
        if (this.mSliceAction == null) goto L15;
        return;
    L15:
        if (r2.getPrimaryAction() == null) goto L19;
        this.mSliceAction = r2.getPrimaryAction();
        return;
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void setColor(int r3) {
        getBuilder().addInt(r3, "color", new String[0]);
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void setKeywords(Set<String> r1) {
        this.mKeywords = r1;
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void setTtl(long r4) {
        long r0 = -1;
        if (r4 == (-1)) goto L6;
        r0 = getClock().currentTimeMillis() + r4;
    L6:
        getBuilder().addTimestamp(r0, SliceHints.SUBTYPE_MILLIS, new String[]{"ttl"});
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void setTtl(Duration r3) {
        if (r3 != null) goto L4;
        long r0 = -1;
    L5:
        setTtl(r0);
        return;
    L4:
        r0 = r3.toMillis();
        goto L5
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void setIsError(boolean r1) {
        this.mIsError = r1;
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void setLayoutDirection(int r3) {
        getBuilder().addInt(r3, "layout_direction", new String[0]);
    }

    @Override // androidx.slice.builders.impl.TemplateBuilderImpl
    public void apply(Slice.Builder r9) {
        if (this.mIsError == false) goto L6;
        r9.addHints(new String[]{"error"});
    L6:
        if (this.mKeywords == null) goto L12;
        Slice.Builder r0 = new Slice.Builder(getBuilder());
        Iterator<String> r3 = this.mKeywords.iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        r0.addText(r3.next(), null, new String[0]);
        goto L9
    L11:
        r9.addSubSlice(r0.addHints(new String[]{"keywords"}).build());
    L12:
        Slice.Builder r1 = new Slice.Builder(getBuilder());
        SliceAction r4 = this.mSliceAction;
        if (r4 == null) goto L26;
        if (this.mTitle != null) goto L20;
        if (r4.getTitle() == null) goto L20;
        this.mTitle = this.mSliceAction.getTitle();
    L20:
        if (this.mIconCompat == null) goto L22;
    L24:
        this.mSliceAction.setPrimaryAction(r1);
        goto L26
    L22:
        if (this.mSliceAction.getIcon() == null) goto L24;
        this.mIconCompat = this.mSliceAction.getIcon();
    L26:
        if (this.mTitle == null) goto L29;
        r1.addItem(new SliceItem(this.mTitle, "text", null, new String[]{"title"}));
    L29:
        if (this.mSubtitle == null) goto L31;
        r1.addItem(new SliceItem(this.mSubtitle, "text", null, new String[0]));
    L31:
        IconCompat r8 = this.mIconCompat;
        if (r8 == null) goto L34;
        r9.addIcon(r8, null, new String[]{"title"});
    L34:
        r9.addSubSlice(r1.build());
    }
}
