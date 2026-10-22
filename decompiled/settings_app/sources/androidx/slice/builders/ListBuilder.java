package androidx.slice.builders;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Pair;
import androidx.slice.Slice;
import androidx.slice.SliceSpecs;
import androidx.slice.builders.impl.ListBuilderBasicImpl;
import androidx.slice.builders.impl.ListBuilderV1Impl;
import androidx.slice.builders.impl.TemplateBuilderImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ListBuilder extends TemplateSliceBuilder {
    public static final int ICON_IMAGE = 0;
    public static final long INFINITY = -1;
    public static final int LARGE_IMAGE = 2;
    public static final int SMALL_IMAGE = 1;
    public static final int UNKNOWN_IMAGE = 3;
    private boolean mHasSeeMore;
    private androidx.slice.builders.impl.ListBuilder mImpl;

    public static class HeaderBuilder {
        private CharSequence mContentDescription;
        private int mLayoutDirection;
        private SliceAction mPrimaryAction;
        private CharSequence mSubtitle;
        private boolean mSubtitleLoading;
        private CharSequence mSummary;
        private boolean mSummaryLoading;
        private CharSequence mTitle;
        private boolean mTitleLoading;
        private final Uri mUri;

        public HeaderBuilder() {
            this.mUri = null;
        }

        public HeaderBuilder(Uri r1) {
            this.mUri = r1;
        }

        public HeaderBuilder(ListBuilder r1) {
            this();
        }

        public HeaderBuilder(ListBuilder r1, Uri r2) {
            this(r2);
        }

        public HeaderBuilder setTitle(CharSequence r2) {
            return setTitle(r2, false);
        }

        public HeaderBuilder setTitle(CharSequence r1, boolean r2) {
            this.mTitle = r1;
            this.mTitleLoading = r2;
            return this;
        }

        public HeaderBuilder setSubtitle(CharSequence r2) {
            return setSubtitle(r2, false);
        }

        public HeaderBuilder setSubtitle(CharSequence r1, boolean r2) {
            this.mSubtitle = r1;
            this.mSubtitleLoading = r2;
            return this;
        }

        public HeaderBuilder setSummary(CharSequence r2) {
            return setSummary(r2, false);
        }

        public HeaderBuilder setSummary(CharSequence r1, boolean r2) {
            this.mSummary = r1;
            this.mSummaryLoading = r2;
            return this;
        }

        public HeaderBuilder setPrimaryAction(SliceAction r1) {
            this.mPrimaryAction = r1;
            return this;
        }

        public HeaderBuilder setContentDescription(CharSequence r1) {
            this.mContentDescription = r1;
            return this;
        }

        public HeaderBuilder setLayoutDirection(int r1) {
            this.mLayoutDirection = r1;
            return this;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public CharSequence getTitle() {
            return this.mTitle;
        }

        public boolean isTitleLoading() {
            return this.mTitleLoading;
        }

        public CharSequence getSubtitle() {
            return this.mSubtitle;
        }

        public boolean isSubtitleLoading() {
            return this.mSubtitleLoading;
        }

        public CharSequence getSummary() {
            return this.mSummary;
        }

        public boolean isSummaryLoading() {
            return this.mSummaryLoading;
        }

        public SliceAction getPrimaryAction() {
            return this.mPrimaryAction;
        }

        public CharSequence getContentDescription() {
            return this.mContentDescription;
        }

        public int getLayoutDirection() {
            return this.mLayoutDirection;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageMode {
    }

    public static class InputRangeBuilder {
        private PendingIntent mAction;
        private CharSequence mContentDescription;
        private PendingIntent mInputAction;
        private int mLayoutDirection;
        private int mMax;
        private int mMin;
        private SliceAction mPrimaryAction;
        private CharSequence mSubtitle;
        private IconCompat mThumb;
        private CharSequence mTitle;
        private int mValue;
        private boolean mValueSet;

        public InputRangeBuilder() {
            this.mMin = 0;
            this.mMax = 100;
            this.mValue = 0;
            this.mValueSet = false;
            this.mLayoutDirection = -1;
        }

        public InputRangeBuilder(ListBuilder r2) {
            this.mMin = 0;
            this.mMax = 100;
            this.mValue = 0;
            this.mValueSet = false;
            this.mLayoutDirection = -1;
        }

        public InputRangeBuilder setMin(int r1) {
            this.mMin = r1;
            return this;
        }

        public InputRangeBuilder setMax(int r1) {
            this.mMax = r1;
            return this;
        }

        public InputRangeBuilder setValue(int r2) {
            this.mValueSet = true;
            this.mValue = r2;
            return this;
        }

        public InputRangeBuilder setTitle(CharSequence r1) {
            this.mTitle = r1;
            return this;
        }

        public InputRangeBuilder setSubtitle(CharSequence r1) {
            this.mSubtitle = r1;
            return this;
        }

        public InputRangeBuilder setInputAction(PendingIntent r1) {
            this.mInputAction = r1;
            return this;
        }

        public InputRangeBuilder setThumb(IconCompat r1) {
            this.mThumb = r1;
            return this;
        }

        public InputRangeBuilder setPrimaryAction(SliceAction r1) {
            this.mPrimaryAction = r1;
            return this;
        }

        public InputRangeBuilder setContentDescription(CharSequence r1) {
            this.mContentDescription = r1;
            return this;
        }

        public InputRangeBuilder setLayoutDirection(int r1) {
            this.mLayoutDirection = r1;
            return this;
        }

        public int getMin() {
            return this.mMin;
        }

        public int getMax() {
            return this.mMax;
        }

        public int getValue() {
            return this.mValue;
        }

        public boolean isValueSet() {
            return this.mValueSet;
        }

        public CharSequence getTitle() {
            return this.mTitle;
        }

        public CharSequence getSubtitle() {
            return this.mSubtitle;
        }

        public PendingIntent getAction() {
            return this.mAction;
        }

        public PendingIntent getInputAction() {
            return this.mInputAction;
        }

        public IconCompat getThumb() {
            return this.mThumb;
        }

        public SliceAction getPrimaryAction() {
            return this.mPrimaryAction;
        }

        public CharSequence getContentDescription() {
            return this.mContentDescription;
        }

        public int getLayoutDirection() {
            return this.mLayoutDirection;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LayoutDirection {
    }

    public static class RangeBuilder {
        private CharSequence mContentDescription;
        private int mLayoutDirection;
        private int mMax;
        private SliceAction mPrimaryAction;
        private CharSequence mSubtitle;
        private CharSequence mTitle;
        private int mValue;
        private boolean mValueSet;

        public RangeBuilder() {
            this.mMax = 100;
            this.mValueSet = false;
            this.mLayoutDirection = -1;
        }

        public RangeBuilder(ListBuilder r1) {
            this.mMax = 100;
            this.mValueSet = false;
            this.mLayoutDirection = -1;
        }

        public RangeBuilder setMax(int r1) {
            this.mMax = r1;
            return this;
        }

        public RangeBuilder setValue(int r2) {
            this.mValueSet = true;
            this.mValue = r2;
            return this;
        }

        public RangeBuilder setTitle(CharSequence r1) {
            this.mTitle = r1;
            return this;
        }

        public RangeBuilder setSubtitle(CharSequence r1) {
            this.mSubtitle = r1;
            return this;
        }

        public RangeBuilder setPrimaryAction(SliceAction r1) {
            this.mPrimaryAction = r1;
            return this;
        }

        public RangeBuilder setContentDescription(CharSequence r1) {
            this.mContentDescription = r1;
            return this;
        }

        public RangeBuilder setLayoutDirection(int r1) {
            this.mLayoutDirection = r1;
            return this;
        }

        public int getValue() {
            return this.mValue;
        }

        public int getMax() {
            return this.mMax;
        }

        public boolean isValueSet() {
            return this.mValueSet;
        }

        public CharSequence getTitle() {
            return this.mTitle;
        }

        public CharSequence getSubtitle() {
            return this.mSubtitle;
        }

        public SliceAction getPrimaryAction() {
            return this.mPrimaryAction;
        }

        public CharSequence getContentDescription() {
            return this.mContentDescription;
        }

        public int getLayoutDirection() {
            return this.mLayoutDirection;
        }
    }

    public static class RowBuilder {
        public static final int TYPE_ACTION = 2;
        public static final int TYPE_ICON = 1;
        public static final int TYPE_TIMESTAMP = 0;
        private CharSequence mContentDescription;
        private List<Object> mEndItems;
        private List<Boolean> mEndLoads;
        private List<Integer> mEndTypes;
        private boolean mHasDefaultToggle;
        private boolean mHasEndActionOrToggle;
        private boolean mHasEndImage;
        private boolean mHasTimestamp;
        private int mLayoutDirection;
        private SliceAction mPrimaryAction;
        private CharSequence mSubtitle;
        private boolean mSubtitleLoading;
        private long mTimeStamp;
        private CharSequence mTitle;
        private SliceAction mTitleAction;
        private boolean mTitleActionLoading;
        private IconCompat mTitleIcon;
        private int mTitleImageMode;
        private boolean mTitleItemLoading;
        private boolean mTitleLoading;
        private final Uri mUri;

        public RowBuilder() {
            this.mTimeStamp = -1;
            this.mLayoutDirection = -1;
            this.mEndItems = new ArrayList();
            this.mEndTypes = new ArrayList();
            this.mEndLoads = new ArrayList();
            this.mUri = null;
        }

        public RowBuilder(Uri r3) {
            this.mTimeStamp = -1;
            this.mLayoutDirection = -1;
            this.mEndItems = new ArrayList();
            this.mEndTypes = new ArrayList();
            this.mEndLoads = new ArrayList();
            this.mUri = r3;
        }

        public RowBuilder(ListBuilder r1) {
            this();
        }

        public RowBuilder(ListBuilder r1, Uri r2) {
            this(r2);
        }

        public RowBuilder(Context r1, Uri r2) {
            this(r2);
        }

        public RowBuilder setTitleItem(long r2) {
            if (this.mHasTimestamp == true) goto L7;
            this.mTimeStamp = r2;
            this.mHasTimestamp = true;
            return this;
        L7:
            throw new IllegalArgumentException("Trying to add a timestamp when one has already been added");
        }

        public RowBuilder setTitleItem(IconCompat r2, int r3) {
            return setTitleItem(r2, r3, false);
        }

        public RowBuilder setTitleItem(IconCompat r2, int r3, boolean r4) {
            this.mTitleAction = null;
            this.mTitleIcon = r2;
            this.mTitleImageMode = r3;
            this.mTitleItemLoading = r4;
            return this;
        }

        public RowBuilder setTitleItem(SliceAction r2) {
            return setTitleItem(r2, false);
        }

        public RowBuilder setTitleItem(SliceAction r1, boolean r2) {
            this.mTitleAction = r1;
            this.mTitleIcon = null;
            this.mTitleImageMode = 0;
            this.mTitleActionLoading = r2;
            return this;
        }

        public RowBuilder setPrimaryAction(SliceAction r1) {
            this.mPrimaryAction = r1;
            return this;
        }

        public RowBuilder setTitle(CharSequence r2) {
            return setTitle(r2, false);
        }

        public RowBuilder setTitle(CharSequence r1, boolean r2) {
            this.mTitle = r1;
            this.mTitleLoading = r2;
            return this;
        }

        public RowBuilder setSubtitle(CharSequence r2) {
            return setSubtitle(r2, false);
        }

        public RowBuilder setSubtitle(CharSequence r1, boolean r2) {
            this.mSubtitle = r1;
            this.mSubtitleLoading = r2;
            return this;
        }

        public RowBuilder addEndItem(long r2) {
            if (this.mHasTimestamp == true) goto L7;
            this.mEndItems.add(Long.valueOf(r2));
            this.mEndTypes.add(0);
            this.mEndLoads.add(false);
            this.mHasTimestamp = true;
            return this;
        L7:
            throw new IllegalArgumentException("Trying to add a timestamp when one has already been added");
        }

        public RowBuilder addEndItem(IconCompat r2, int r3) {
            return addEndItem(r2, r3, false);
        }

        public RowBuilder addEndItem(IconCompat r3, int r4, boolean r5) {
            if (this.mHasEndActionOrToggle == true) goto L7;
            this.mEndItems.add(new Pair(r3, Integer.valueOf(r4)));
            this.mEndTypes.add(1);
            this.mEndLoads.add(Boolean.valueOf(r5));
            this.mHasEndImage = true;
            return this;
        L7:
            throw new IllegalArgumentException("Trying to add an icon to end items when anaction has already been added. End items cannot have a mixture of actions and icons.");
        }

        public RowBuilder addEndItem(SliceAction r2) {
            return addEndItem(r2, false);
        }

        public RowBuilder addEndItem(SliceAction r3, boolean r4) {
            if (this.mHasEndImage == true) goto L11;
            if (this.mHasDefaultToggle == true) goto L9;
            this.mEndItems.add(r3);
            this.mEndTypes.add(2);
            this.mEndLoads.add(Boolean.valueOf(r4));
            this.mHasDefaultToggle = r3.getImpl().isDefaultToggle();
            this.mHasEndActionOrToggle = true;
            return this;
        L9:
            throw new IllegalStateException("Only one non-custom toggle can be added in a single row. If you would like to include multiple toggles in a row, set a custom icon for each toggle.");
        L11:
            throw new IllegalArgumentException("Trying to add an action to end items when anicon has already been added. End items cannot have a mixture of actions and icons.");
        }

        public RowBuilder setContentDescription(CharSequence r1) {
            this.mContentDescription = r1;
            return this;
        }

        public RowBuilder setLayoutDirection(int r1) {
            this.mLayoutDirection = r1;
            return this;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public boolean hasEndActionOrToggle() {
            return this.mHasEndActionOrToggle;
        }

        public boolean hasEndImage() {
            return this.mHasEndImage;
        }

        public boolean hasDefaultToggle() {
            return this.mHasDefaultToggle;
        }

        public boolean hasTimestamp() {
            return this.mHasTimestamp;
        }

        public long getTimeStamp() {
            return this.mTimeStamp;
        }

        public boolean isTitleItemLoading() {
            return this.mTitleItemLoading;
        }

        public int getTitleImageMode() {
            return this.mTitleImageMode;
        }

        public IconCompat getTitleIcon() {
            return this.mTitleIcon;
        }

        public SliceAction getTitleAction() {
            return this.mTitleAction;
        }

        public SliceAction getPrimaryAction() {
            return this.mPrimaryAction;
        }

        public CharSequence getTitle() {
            return this.mTitle;
        }

        public boolean isTitleLoading() {
            return this.mTitleLoading;
        }

        public CharSequence getSubtitle() {
            return this.mSubtitle;
        }

        public boolean isSubtitleLoading() {
            return this.mSubtitleLoading;
        }

        public CharSequence getContentDescription() {
            return this.mContentDescription;
        }

        public int getLayoutDirection() {
            return this.mLayoutDirection;
        }

        public List<Object> getEndItems() {
            return this.mEndItems;
        }

        public List<Integer> getEndTypes() {
            return this.mEndTypes;
        }

        public List<Boolean> getEndLoads() {
            return this.mEndLoads;
        }

        public boolean isTitleActionLoading() {
            return this.mTitleActionLoading;
        }
    }

    public ListBuilder(Context r1, Uri r2) {
        super(r1, r2);
    }

    public ListBuilder(Context r1, Uri r2, long r3) {
        super(r1, r2);
        this.mImpl.setTtl(r3);
    }

    public ListBuilder(Context r1, Uri r2, Duration r3) {
        super(r1, r2);
        this.mImpl.setTtl(r3);
    }

    @Override // androidx.slice.builders.TemplateSliceBuilder
    public Slice build() {
        return ((TemplateBuilderImpl) this.mImpl).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.slice.builders.TemplateSliceBuilder
    void setImpl(TemplateBuilderImpl r1) {
        this.mImpl = (androidx.slice.builders.impl.ListBuilder) r1;
    }

    public ListBuilder addRow(RowBuilder r2) {
        this.mImpl.addRow(r2);
        return this;
    }

    public ListBuilder addRow(Consumer<RowBuilder> r2) {
        RowBuilder r0 = new RowBuilder(this);
        r2.accept(r0);
        return addRow(r0);
    }

    public ListBuilder addGridRow(GridRowBuilder r2) {
        this.mImpl.addGridRow(r2);
        return this;
    }

    public ListBuilder addGridRow(Consumer<GridRowBuilder> r2) {
        GridRowBuilder r0 = new GridRowBuilder(this);
        r2.accept(r0);
        return addGridRow(r0);
    }

    public ListBuilder setHeader(HeaderBuilder r2) {
        this.mImpl.setHeader(r2);
        return this;
    }

    public ListBuilder setHeader(Consumer<HeaderBuilder> r2) {
        HeaderBuilder r0 = new HeaderBuilder(this);
        r2.accept(r0);
        return setHeader(r0);
    }

    public ListBuilder addAction(SliceAction r2) {
        this.mImpl.addAction(r2);
        return this;
    }

    public ListBuilder setColor(int r1) {
        return setAccentColor(r1);
    }

    public ListBuilder setAccentColor(int r2) {
        this.mImpl.setColor(r2);
        return this;
    }

    public ListBuilder setKeywords(List<String> r3) {
        if (r3 == null) goto L4;
        this.mImpl.setKeywords(new HashSet(r3));
    L4:
        return this;
    }

    public ListBuilder setKeywords(Set<String> r2) {
        this.mImpl.setKeywords(r2);
        return this;
    }

    public ListBuilder setLayoutDirection(int r2) {
        this.mImpl.setLayoutDirection(r2);
        return this;
    }

    public ListBuilder setSeeMoreRow(RowBuilder r2) {
        if (this.mHasSeeMore == true) goto L7;
        this.mImpl.setSeeMoreRow(r2);
        this.mHasSeeMore = true;
        return this;
    L7:
        throw new IllegalArgumentException("Trying to add see more row when one has already been added");
    }

    public ListBuilder setSeeMoreRow(Consumer<RowBuilder> r2) {
        RowBuilder r0 = new RowBuilder(this);
        r2.accept(r0);
        if (this.mHasSeeMore == true) goto L7;
        this.mImpl.setSeeMoreRow(r0);
        this.mHasSeeMore = true;
        return this;
    L7:
        throw new IllegalArgumentException("Trying to add see more row when one has already been added");
    }

    public ListBuilder setSeeMoreAction(PendingIntent r2) {
        if (this.mHasSeeMore == true) goto L7;
        this.mImpl.setSeeMoreAction(r2);
        this.mHasSeeMore = true;
        return this;
    L7:
        throw new IllegalArgumentException("Trying to add see more action when one has already been added");
    }

    public ListBuilder setIsError(boolean r2) {
        this.mImpl.setIsError(r2);
        return this;
    }

    @Override // androidx.slice.builders.TemplateSliceBuilder
    protected TemplateBuilderImpl selectImpl(Uri r3) {
        if (checkCompatible(SliceSpecs.LIST, r3) == false) goto L7;
        return new ListBuilderV1Impl(getBuilder(), SliceSpecs.LIST, getClock());
    L7:
        if (checkCompatible(SliceSpecs.BASIC, r3) == true) goto L9;
        return null;
    L9:
        return new ListBuilderBasicImpl(getBuilder(), SliceSpecs.BASIC);
    }

    public androidx.slice.builders.impl.ListBuilder getImpl() {
        return this.mImpl;
    }

    public ListBuilder addInputRange(InputRangeBuilder r2) {
        this.mImpl.addInputRange(r2);
        return this;
    }

    public ListBuilder addInputRange(Consumer<InputRangeBuilder> r2) {
        InputRangeBuilder r0 = new InputRangeBuilder(this);
        r2.accept(r0);
        return addInputRange(r0);
    }

    public ListBuilder addRange(RangeBuilder r2) {
        this.mImpl.addRange(r2);
        return this;
    }

    public ListBuilder addRange(Consumer<RangeBuilder> r2) {
        RangeBuilder r0 = new RangeBuilder(this);
        r2.accept(r0);
        return addRange(r0);
    }
}
