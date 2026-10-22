package com.obric.oui.calendar;

import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.calendar.format.TitleFormatter;
import com.obric.oui.calendar.format.WeekDayFormatter;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes4.dex */
public class WeekPagerAdapter extends CalendarPagerAdapter<WeekView> {

    public static class Weekly implements DateRangeIndex {
        private final int count;
        private final DayOfWeek firstDayOfWeek;
        private final CalendarDay min;

        public Weekly(CalendarDay r1, CalendarDay r2, DayOfWeek r3) {
            this.firstDayOfWeek = r3;
            this.min = getFirstDayOfWeek(r1);
            this.count = indexOf(r2) + 1;
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public int getCount() {
            return this.count;
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public int indexOf(CalendarDay r4) {
            WeekFields r0 = WeekFields.of(this.firstDayOfWeek, 1);
            LocalDate r5 = r4.getDate().with(r0.dayOfWeek(), 1);
            return (int) ChronoUnit.WEEKS.between(this.min.getDate(), r5);
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public CalendarDay getItem(int r3) {
            return CalendarDay.from(this.min.getDate().plusWeeks(r3));
        }

        private CalendarDay getFirstDayOfWeek(CalendarDay r3) {
            return CalendarDay.from(r3.getDate().with(WeekFields.of(this.firstDayOfWeek, 1).dayOfWeek(), 1));
        }
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void clearSelections() {
        super.clearSelections();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected /* bridge */ /* synthetic */ CalendarPagerView createView(int r1) {
        return createView(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ void destroyItem(ViewGroup r1, int r2, Object r3) {
        super.destroyItem(r1, r2, r3);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ int getIndexForDay(CalendarDay r1) {
        return super.getIndexForDay(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ CalendarDay getItem(int r1) {
        return super.getItem(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ int getItemPosition(Object r1) {
        return super.getItemPosition(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ CharSequence getPageTitle(int r1) {
        return super.getPageTitle(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ DateRangeIndex getRangeIndex() {
        return super.getRangeIndex();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ List getSelectedDates() {
        return super.getSelectedDates();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ int getShowOtherDates() {
        return super.getShowOtherDates();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected /* bridge */ /* synthetic */ int indexOf(CalendarPagerView r1) {
        return indexOf((WeekView) r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ Object instantiateItem(ViewGroup r1, int r2) {
        return super.instantiateItem(r1, r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void invalidateDecorators() {
        super.invalidateDecorators();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ boolean isShowWeekDays() {
        return super.isShowWeekDays();
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ boolean isViewFromObject(View r1, Object r2) {
        return super.isViewFromObject(r1, r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ CalendarPagerAdapter migrateStateAndReturn(CalendarPagerAdapter r1) {
        return super.migrateStateAndReturn(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void selectRange(CalendarDay r1, CalendarDay r2) {
        super.selectRange(r1, r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setDateSelected(CalendarDay r1, boolean r2) {
        super.setDateSelected(r1, r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setDateTextAppearance(int r1) {
        super.setDateTextAppearance(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setDayFormatter(DayFormatter r1) {
        super.setDayFormatter(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setDayFormatterContentDescription(DayFormatter r1) {
        super.setDayFormatterContentDescription(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setDecorators(List r1) {
        super.setDecorators(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setRangeDates(CalendarDay r1, CalendarDay r2) {
        super.setRangeDates(r1, r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setSelectionColor(int r1) {
        super.setSelectionColor(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setSelectionEnabled(boolean r1) {
        super.setSelectionEnabled(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setShowOtherDates(int r1) {
        super.setShowOtherDates(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setShowWeekDays(boolean r1) {
        super.setShowWeekDays(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setTitleFormatter(TitleFormatter r1) {
        super.setTitleFormatter(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setWeekDayFormatter(WeekDayFormatter r1) {
        super.setWeekDayFormatter(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    public /* bridge */ /* synthetic */ void setWeekDayTextAppearance(int r1) {
        super.setWeekDayTextAppearance(r1);
    }

    public WeekPagerAdapter(MaterialCalendarView r1) {
        super(r1);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected WeekView createView(int r4) {
        return new WeekView(this.mcv, getItem(r4), this.mcv.getFirstDayOfWeek(), this.showWeekDays);
    }

    protected int indexOf(WeekView r1) {
        CalendarDay r2 = r1.getFirstViewDay();
        return getRangeIndex().indexOf(r2);
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected boolean isInstanceOfView(Object r1) {
        return r1 instanceof WeekView;
    }

    @Override // com.obric.oui.calendar.CalendarPagerAdapter
    protected DateRangeIndex createRangeIndex(CalendarDay r2, CalendarDay r3) {
        return new Weekly(r2, r3, this.mcv.getFirstDayOfWeek());
    }
}
