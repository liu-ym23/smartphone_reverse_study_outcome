package androidx.slice.builders.impl;

import android.app.PendingIntent;
import android.net.Uri;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Pair;
import androidx.slice.Clock;
import androidx.slice.Slice;
import androidx.slice.SliceItem;
import androidx.slice.SliceSpec;
import androidx.slice.SystemClock;
import androidx.slice.builders.GridRowBuilder;
import androidx.slice.builders.SliceAction;
import androidx.slice.core.SliceHints;
import androidx.slice.core.SliceQuery;
import com.android.settings.inputmethod.UserDictionaryAddWordContents;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ListBuilderV1Impl extends TemplateBuilderImpl implements ListBuilder {
    private boolean mFirstRowChecked;
    private boolean mFirstRowHasText;
    private boolean mIsError;
    private boolean mIsFirstRowTypeValid;
    private Set<String> mKeywords;
    private List<Slice> mSliceActions;
    private Slice mSliceHeader;

    public static class HeaderBuilderImpl extends TemplateBuilderImpl {
        private CharSequence mContentDescr;
        private SliceAction mPrimaryAction;
        private SliceItem mSubtitleItem;
        private SliceItem mSummaryItem;
        private SliceItem mTitleItem;

        HeaderBuilderImpl(ListBuilderV1Impl r2) {
            super(r2.createChildBuilder(), null);
        }

        private HeaderBuilderImpl(Uri r2) {
            super(new Slice.Builder(r2), null);
        }

        void fillFrom(androidx.slice.builders.ListBuilder.HeaderBuilder r3) {
            if (r3.getUri() == null) goto L5;
            setBuilder(new Slice.Builder(r3.getUri()));
        L5:
            setPrimaryAction(r3.getPrimaryAction());
            if (r3.getLayoutDirection() == (-1)) goto L9;
            setLayoutDirection(r3.getLayoutDirection());
        L9:
            if (r3.getTitle() == null) goto L11;
        L12:
            setTitle(r3.getTitle(), r3.isTitleLoading());
        L14:
            if (r3.getSubtitle() == null) goto L16;
        L17:
            setSubtitle(r3.getSubtitle(), r3.isSubtitleLoading());
        L19:
            if (r3.getSummary() == null) goto L21;
        L22:
            setSummary(r3.getSummary(), r3.isSummaryLoading());
        L24:
            if (r3.getContentDescription() == null) goto L27;
            setContentDescription(r3.getContentDescription());
            return;
        L27:
            return;
        L21:
            if (r3.isSummaryLoading() == false) goto L24;
        L16:
            if (r3.isSubtitleLoading() == false) goto L19;
        L11:
            if (r3.isTitleLoading() == false) goto L14;
            goto L12
        }

        @Override // androidx.slice.builders.impl.TemplateBuilderImpl
        public void apply(Slice.Builder r4) {
            SliceItem r0 = this.mTitleItem;
            if (r0 == null) goto L5;
            r4.addItem(r0);
        L5:
            SliceItem r1 = this.mSubtitleItem;
            if (r1 == null) goto L8;
            r4.addItem(r1);
        L8:
            SliceItem r2 = this.mSummaryItem;
            if (r2 == null) goto L11;
            r4.addItem(r2);
        L11:
            CharSequence r3 = this.mContentDescr;
            if (r3 == null) goto L14;
            r4.addText(r3, "content_description", new String[0]);
        L14:
            SliceAction r5 = this.mPrimaryAction;
            if (r5 == null) goto L18;
            r5.setPrimaryAction(r4);
        L18:
            if (this.mSubtitleItem == null) goto L20;
            return;
        L20:
            if (this.mTitleItem == null) goto L23;
            return;
        L23:
            throw new IllegalStateException("Header requires a title or subtitle to be set.");
        }

        private void setTitle(CharSequence r5, boolean r6) {
            SliceItem r0 = new SliceItem(r5, "text", null, new String[]{"title"});
            this.mTitleItem = r0;
            if (r6 == false) goto L6;
            r0.addHint("partial");
            return;
        }

        private void setSubtitle(CharSequence r5, boolean r6) {
            SliceItem r0 = new SliceItem(r5, "text", null, new String[0]);
            this.mSubtitleItem = r0;
            if (r6 == false) goto L6;
            r0.addHint("partial");
            return;
        }

        private void setSummary(CharSequence r5, boolean r6) {
            SliceItem r0 = new SliceItem(r5, "text", null, new String[]{"summary"});
            this.mSummaryItem = r0;
            if (r6 == false) goto L6;
            r0.addHint("partial");
            return;
        }

        private void setPrimaryAction(SliceAction r1) {
            this.mPrimaryAction = r1;
        }

        private void setContentDescription(CharSequence r1) {
            this.mContentDescr = r1;
        }

        private void setLayoutDirection(int r3) {
            getBuilder().addInt(r3, "layout_direction", new String[0]);
        }
    }

    public static class InputRangeBuilderImpl extends RangeBuilderImpl {
        private PendingIntent mAction;
        private IconCompat mThumb;

        InputRangeBuilderImpl(Slice.Builder r2, androidx.slice.builders.ListBuilder.InputRangeBuilder r3) {
            super(r2, null);
            this.mValueSet = r3.isValueSet();
            this.mMin = r3.getMin();
            this.mMax = r3.getMax();
            this.mValue = r3.getValue();
            this.mTitle = r3.getTitle();
            this.mSubtitle = r3.getSubtitle();
            this.mContentDescr = r3.getContentDescription();
            this.mPrimaryAction = r3.getPrimaryAction();
            this.mLayoutDir = r3.getLayoutDirection();
            this.mAction = r3.getInputAction();
            this.mThumb = r3.getThumb();
        }

        @Override // androidx.slice.builders.impl.ListBuilderV1Impl.RangeBuilderImpl, androidx.slice.builders.impl.TemplateBuilderImpl
        public void apply(Slice.Builder r5) {
            if (this.mAction == null) goto L10;
            Slice.Builder r0 = new Slice.Builder(r5);
            super.apply(r0);
            IconCompat r1 = this.mThumb;
            if (r1 == null) goto L7;
            r0.addIcon(r1, null, new String[0]);
        L7:
            r5.addAction(this.mAction, r0.build(), "range").addHints(new String[]{"list_item"});
            return;
        L10:
            throw new IllegalStateException("Input ranges must have an associated action.");
        }
    }

    public static class RangeBuilderImpl extends TemplateBuilderImpl {
        protected CharSequence mContentDescr;
        protected int mLayoutDir;
        protected int mMax;
        protected int mMin;
        protected SliceAction mPrimaryAction;
        protected CharSequence mSubtitle;
        protected CharSequence mTitle;
        protected int mValue;
        protected boolean mValueSet;

        RangeBuilderImpl(Slice.Builder r2, androidx.slice.builders.ListBuilder.RangeBuilder r3) {
            super(r2, null);
            this.mMin = 0;
            this.mMax = 100;
            this.mValue = 0;
            this.mValueSet = false;
            this.mLayoutDir = -1;
            if (r3 == null) goto L6;
            this.mValueSet = r3.isValueSet();
            this.mMax = r3.getMax();
            this.mValue = r3.getValue();
            this.mTitle = r3.getTitle();
            this.mSubtitle = r3.getSubtitle();
            this.mContentDescr = r3.getContentDescription();
            this.mPrimaryAction = r3.getPrimaryAction();
            this.mLayoutDir = r3.getLayoutDirection();
            return;
        }

        @Override // androidx.slice.builders.impl.TemplateBuilderImpl
        public void apply(Slice.Builder r5) {
            if (this.mValueSet == true) goto L5;
            this.mValue = this.mMin;
        L5:
            int r0 = this.mMin;
            int r1 = this.mValue;
            if (r0 > r1) goto L28;
            int r2 = this.mMax;
            if (r1 > r2) goto L28;
            if (r0 >= r2) goto L28;
            CharSequence r3 = this.mTitle;
            if (r3 == null) goto L13;
            r5.addText(r3, null, new String[]{"title"});
        L13:
            CharSequence r4 = this.mSubtitle;
            if (r4 == null) goto L16;
            r5.addText(r4, null, new String[0]);
        L16:
            CharSequence r6 = this.mContentDescr;
            if (r6 == null) goto L19;
            r5.addText(r6, "content_description", new String[0]);
        L19:
            SliceAction r7 = this.mPrimaryAction;
            if (r7 == null) goto L22;
            r7.setPrimaryAction(r5);
        L22:
            int r8 = this.mLayoutDir;
            if (r8 == (-1)) goto L25;
            r5.addInt(r8, "layout_direction", new String[0]);
        L25:
            r5.addHints(new String[]{"list_item"}).addInt(this.mMin, SliceHints.SUBTYPE_MIN, new String[0]).addInt(this.mMax, "max", new String[0]).addInt(this.mValue, "value", new String[0]);
            return;
        L28:
            throw new IllegalArgumentException("Invalid range values, min=" + this.mMin + ", value=" + this.mValue + ", max=" + this.mMax + " ensure value falls within (min, max) and min < max.");
        }

        boolean hasText() {
            if (this.mTitle == null) goto L5;
        L8:
            return true;
        L5:
            if (this.mSubtitle != null) goto L8;
            return false;
        }
    }

    public static class RowBuilderImpl extends TemplateBuilderImpl {
        private CharSequence mContentDescr;
        private ArrayList<Slice> mEndItems;
        private SliceAction mPrimaryAction;
        private Slice mStartItem;
        private SliceItem mSubtitleItem;
        private SliceItem mTitleItem;

        private RowBuilderImpl(ListBuilderV1Impl r2) {
            super(r2.createChildBuilder(), null);
            this.mEndItems = new ArrayList();
        }

        private RowBuilderImpl(Uri r2) {
            super(new Slice.Builder(r2), null);
            this.mEndItems = new ArrayList();
        }

        RowBuilderImpl(Slice.Builder r2) {
            super(r2, null);
            this.mEndItems = new ArrayList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void fillFrom(androidx.slice.builders.ListBuilder.RowBuilder r7) {
            if (r7.getUri() == null) goto L5;
            setBuilder(new Slice.Builder(r7.getUri()));
        L5:
            setPrimaryAction(r7.getPrimaryAction());
            if (r7.getLayoutDirection() == (-1)) goto L9;
            setLayoutDirection(r7.getLayoutDirection());
        L9:
            if (r7.getTitleAction() == null) goto L11;
        L22:
            setTitleItem(r7.getTitleAction(), r7.isTitleActionLoading());
        L24:
            if (r7.getTitle() == null) goto L26;
        L27:
            setTitle(r7.getTitle(), r7.isTitleLoading());
        L29:
            if (r7.getSubtitle() == null) goto L31;
        L32:
            setSubtitle(r7.getSubtitle(), r7.isSubtitleLoading());
        L34:
            if (r7.getContentDescription() == null) goto L36;
            setContentDescription(r7.getContentDescription());
        L36:
            List<Object> r0 = r7.getEndItems();
            List<Integer> r1 = r7.getEndTypes();
            List<Boolean> r8 = r7.getEndLoads();
            int r2 = 0;
        L38:
            if (r2 >= r0.size()) goto L50;
            int r3 = r1.get(r2).intValue();
            if (r3 != 0) goto L42;
            addEndItem(((Long) r0.get(r2)).longValue());
        L49:
            r2 = r2 + 1;
            goto L38
        L42:
            if (r3 != 1) goto L44;
            Pair r4 = (Pair) r0.get(r2);
            addEndItem((IconCompat) r4.first, ((Integer) r4.second).intValue(), r8.get(r2).booleanValue());
            goto L49
        L44:
            if (r3 != 2) goto L49;
            addEndItem((SliceAction) r0.get(r2), r8.get(r2).booleanValue());
            goto L49
        L50:
            return;
        L31:
            if (r7.isSubtitleLoading() == false) goto L34;
        L26:
            if (r7.isTitleLoading() == false) goto L29;
        L11:
            if (r7.isTitleActionLoading() == true) goto L22;
            if (r7.getTitleIcon() == null) goto L16;
        L21:
            setTitleItem(r7.getTitleIcon(), r7.getTitleImageMode(), r7.isTitleItemLoading());
            goto L24
        L16:
            if (r7.isTitleItemLoading() == true) goto L21;
            if (r7.getTimeStamp() == (-1)) goto L24;
            setTitleItem(r7.getTimeStamp());
            goto L24
        }

        private void setTitleItem(long r4) {
            this.mStartItem = new Slice.Builder(getBuilder()).addTimestamp(r4, null, new String[0]).addHints(new String[]{"title"}).build();
        }

        protected void setTitleItem(IconCompat r2, int r3) {
            setTitleItem(r2, r3, false);
        }

        private void setTitleItem(IconCompat r4, int r5, boolean r6) {
            ArrayList r0 = new ArrayList();
            if (r5 == 0) goto L6;
            r0.add("no_tint");
        L6:
            if (r5 != 2) goto L9;
            r0.add("large");
        L9:
            if (r6 == false) goto L11;
            r0.add("partial");
        L11:
            Slice.Builder r7 = new Slice.Builder(getBuilder()).addIcon(r4, null, r0);
            if (r6 == false) goto L14;
            r7.addHints(new String[]{"partial"});
        L14:
            this.mStartItem = r7.addHints(new String[]{"title"}).build();
        }

        private void setTitleItem(SliceAction r2) {
            setTitleItem(r2, false);
        }

        private void setTitleItem(SliceAction r3, boolean r4) {
            Slice.Builder r0 = new Slice.Builder(getBuilder()).addHints(new String[]{"title"});
            if (r4 == false) goto L5;
            r0.addHints(new String[]{"partial"});
        L5:
            this.mStartItem = r3.buildSlice(r0);
        }

        private void setPrimaryAction(SliceAction r1) {
            this.mPrimaryAction = r1;
        }

        private void setTitle(CharSequence r2) {
            setTitle(r2, false);
        }

        private void setTitle(CharSequence r5, boolean r6) {
            SliceItem r0 = new SliceItem(r5, "text", null, new String[]{"title"});
            this.mTitleItem = r0;
            if (r6 == false) goto L6;
            r0.addHint("partial");
            return;
        }

        protected void setSubtitle(CharSequence r2) {
            setSubtitle(r2, false);
        }

        private void setSubtitle(CharSequence r5, boolean r6) {
            SliceItem r0 = new SliceItem(r5, "text", null, new String[0]);
            this.mSubtitleItem = r0;
            if (r6 == false) goto L6;
            r0.addHint("partial");
            return;
        }

        protected void addEndItem(long r4) {
            this.mEndItems.add(new Slice.Builder(getBuilder()).addTimestamp(r4, null, new String[0]).build());
        }

        private void addEndItem(IconCompat r2, int r3) {
            addEndItem(r2, r3, false);
        }

        private void addEndItem(IconCompat r4, int r5, boolean r6) {
            ArrayList r0 = new ArrayList();
            if (r5 == 0) goto L6;
            r0.add("no_tint");
        L6:
            if (r5 != 2) goto L9;
            r0.add("large");
        L9:
            if (r6 == false) goto L11;
            r0.add("partial");
        L11:
            Slice.Builder r7 = new Slice.Builder(getBuilder()).addIcon(r4, null, r0);
            if (r6 == false) goto L14;
            r7.addHints(new String[]{"partial"});
        L14:
            this.mEndItems.add(r7.build());
        }

        private void addEndItem(SliceAction r2) {
            addEndItem(r2, false);
        }

        private void addEndItem(SliceAction r3, boolean r4) {
            Slice.Builder r0 = new Slice.Builder(getBuilder());
            if (r4 == false) goto L5;
            r0.addHints(new String[]{"partial"});
        L5:
            this.mEndItems.add(r3.buildSlice(r0));
        }

        private void setContentDescription(CharSequence r1) {
            this.mContentDescr = r1;
        }

        private void setLayoutDirection(int r3) {
            getBuilder().addInt(r3, "layout_direction", new String[0]);
        }

        boolean hasText() {
            if (this.mTitleItem == null) goto L5;
        L8:
            return true;
        L5:
            if (this.mSubtitleItem != null) goto L8;
            return false;
        }

        @Override // androidx.slice.builders.impl.TemplateBuilderImpl
        public void apply(Slice.Builder r4) {
            Slice r0 = this.mStartItem;
            if (r0 == null) goto L5;
            r4.addSubSlice(r0);
        L5:
            SliceItem r1 = this.mTitleItem;
            if (r1 == null) goto L8;
            r4.addItem(r1);
        L8:
            SliceItem r2 = this.mSubtitleItem;
            if (r2 == null) goto L11;
            r4.addItem(r2);
        L11:
            int r3 = 0;
        L13:
            if (r3 >= this.mEndItems.size()) goto L15;
            r4.addSubSlice(this.mEndItems.get(r3));
            r3 = r3 + 1;
            goto L13
        L15:
            CharSequence r5 = this.mContentDescr;
            if (r5 == null) goto L18;
            r4.addText(r5, "content_description", new String[0]);
        L18:
            SliceAction r6 = this.mPrimaryAction;
            if (r6 == null) goto L23;
            r6.setPrimaryAction(r4);
            return;
        }
    }

    public ListBuilderV1Impl(Slice.Builder r2, SliceSpec r3) {
        this(r2, r3, new SystemClock());
    }

    public ListBuilderV1Impl(Slice.Builder r1, SliceSpec r2, Clock r3) {
        super(r1, r2, r3);
    }

    @Override // androidx.slice.builders.impl.TemplateBuilderImpl
    public void apply(Slice.Builder r6) {
        r6.addLong(getClock().currentTimeMillis(), SliceHints.SUBTYPE_MILLIS, new String[]{"last_updated"});
        Slice r0 = this.mSliceHeader;
        if (r0 == null) goto L6;
        r6.addSubSlice(r0);
    L6:
        if (this.mSliceActions == null) goto L13;
        Slice.Builder r1 = new Slice.Builder(r6);
        int r2 = 0;
    L9:
        if (r2 >= this.mSliceActions.size()) goto L11;
        r1.addSubSlice(this.mSliceActions.get(r2));
        r2 = r2 + 1;
        goto L9
    L11:
        r6.addSubSlice(r1.addHints(new String[]{"actions"}).build());
    L13:
        if (this.mIsError == false) goto L16;
        r6.addHints(new String[]{"error"});
    L16:
        if (this.mKeywords == null) goto L25;
        Slice.Builder r7 = new Slice.Builder(getBuilder());
        Iterator<String> r3 = this.mKeywords.iterator();
    L19:
        if (r3.hasNext() == false) goto L21;
        r7.addText(r3.next(), null, new String[0]);
        goto L19
    L21:
        getBuilder().addSubSlice(r7.addHints(new String[]{"keywords"}).build());
        return;
    }

    @Override // androidx.slice.builders.impl.TemplateBuilderImpl
    public Slice build() {
        Slice r0 = super.build();
        boolean r3 = true;
        if (SliceQuery.find(r0, null, "partial", null) == null) goto L5;
        boolean r1 = true;
    L7:
        if (SliceQuery.find(r0, "slice", "list_item", null) == null) goto L10;
        r3 = false;
    L10:
        String[] r4 = {UserDictionaryAddWordContents.EXTRA_SHORTCUT, "title"};
        SliceItem r5 = SliceQuery.find(r0, "action", r4, null);
        List<SliceItem> r2 = SliceQuery.findAll(r0, "slice", r4, null);
        if (r1 == true) goto L20;
        if (r3 == true) goto L20;
        if (r5 != null) goto L20;
        if (r2 == null) goto L19;
        if (r2.isEmpty() == false) goto L20;
    L19:
        throw new IllegalStateException("A slice requires a primary action; ensure one of your builders has called #setPrimaryAction with a valid SliceAction.");
    L20:
        boolean r6 = this.mFirstRowChecked;
        if (r6 == true) goto L23;
    L27:
        if (r6 == true) goto L29;
    L33:
        return r0;
    L29:
        if (this.mFirstRowHasText == true) goto L33;
        throw new IllegalStateException("A slice requires the first row to have some text.");
    L23:
        if (this.mIsFirstRowTypeValid == true) goto L27;
        throw new IllegalStateException("A slice cannot have the first row be constructed from a GridRowBuilder, consider using #setHeader.");
    L5:
        r1 = false;
        goto L7
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void addRow(androidx.slice.builders.ListBuilder.RowBuilder r3) {
        RowBuilderImpl r0 = new RowBuilderImpl(createChildBuilder());
        r0.fillFrom(r3);
        checkRow(true, r0.hasText());
        addRow(r0);
    }

    public void addRow(RowBuilderImpl r3) {
        checkRow(true, r3.hasText());
        r3.getBuilder().addHints(new String[]{"list_item"});
        getBuilder().addSubSlice(r3.build());
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void addGridRow(GridRowBuilder r3) {
        checkRow(false, false);
        GridRowBuilderListV1Impl r0 = new GridRowBuilderListV1Impl(this, r3);
        r0.getBuilder().addHints(new String[]{"list_item"});
        getBuilder().addSubSlice(r0.build());
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void setHeader(androidx.slice.builders.ListBuilder.HeaderBuilder r2) {
        this.mIsFirstRowTypeValid = true;
        this.mFirstRowHasText = true;
        this.mFirstRowChecked = true;
        HeaderBuilderImpl r0 = new HeaderBuilderImpl(this);
        r0.fillFrom(r2);
        this.mSliceHeader = r0.build();
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void addAction(SliceAction r3) {
        if (this.mSliceActions != null) goto L5;
        this.mSliceActions = new ArrayList();
    L5:
        Slice.Builder r0 = new Slice.Builder(getBuilder()).addHints(new String[]{"actions"});
        this.mSliceActions.add(r3.buildSlice(r0));
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void addInputRange(androidx.slice.builders.ListBuilder.InputRangeBuilder r3) {
        InputRangeBuilderImpl r0 = new InputRangeBuilderImpl(createChildBuilder(), r3);
        checkRow(true, r0.hasText());
        getBuilder().addSubSlice(r0.build(), "range");
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void addRange(androidx.slice.builders.ListBuilder.RangeBuilder r3) {
        RangeBuilderImpl r0 = new RangeBuilderImpl(createChildBuilder(), r3);
        checkRow(true, r0.hasText());
        getBuilder().addSubSlice(r0.build(), "range");
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void setSeeMoreRow(androidx.slice.builders.ListBuilder.RowBuilder r3) {
        RowBuilderImpl r0 = new RowBuilderImpl(createChildBuilder());
        r0.fillFrom(r3);
        r0.getBuilder().addHints(new String[]{"see_more"});
        getBuilder().addSubSlice(r0.build());
    }

    @Override // androidx.slice.builders.impl.ListBuilder
    public void setSeeMoreAction(PendingIntent r5) {
        getBuilder().addSubSlice(new Slice.Builder(getBuilder()).addHints(new String[]{"see_more"}).addAction(r5, new Slice.Builder(getBuilder()).addHints(new String[]{"see_more"}).build(), null).build());
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

    private void checkRow(boolean r2, boolean r3) {
        if (this.mFirstRowChecked == true) goto L6;
        this.mFirstRowChecked = true;
        this.mIsFirstRowTypeValid = r2;
        this.mFirstRowHasText = r3;
        return;
    }
}
