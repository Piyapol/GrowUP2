package com.example.xeus_labmacbook.growup.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by DuckWalkZ on 11/3/2560.
 */

public class ClockContract {
    /**
     * This authority is used for writing to or querying from the clock
     * provider.
     */
    public static final String AUTHORITY = "com.numberx.kkmctimer";

    /**
     * This utility class cannot be instantiated
     */
    private ClockContract() {}

    /**
     * Constants for tables with AlarmSettings.
     */
    private interface AlarmSettingColumns extends BaseColumns {
        /**
         * This string is used to indicate no ringtone.
         */
        public static final Uri NO_RINGTONE_URI = Uri.EMPTY;

        /**
         * This string is used to indicate no ringtone.
         */
        public static final String NO_RINGTONE = NO_RINGTONE_URI.toString();

        /**
         * True if alarm should vibrate
         * <p>Type: BOOLEAN</p>
         */
        public static final String VIBRATE = "vibrate";

        /**
         * Alarm label.
         *
         * <p>Type: STRING</p>
         */
        public static final String LABEL = "label";

        /**
         * Audio alert to play when alarm triggers. Null entry
         * means use system default and entry that equal
         * Uri.EMPTY.toString() means no ringtone.
         *
         * <p>Type: STRING</p>
         */
        public static final String RINGTONE = "ringtone";
    }

    /**
     * Constants for the Alarms table, which contains the user created alarms.
     */
    protected interface AlarmsColumns extends AlarmSettingColumns, BaseColumns {
        /**
         * The content:// style URL for this table.
         */
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/alarms");

        /**
         * Hour in 24-hour localtime 0 - 23.
         * <p>Type: INTEGER</p>
         */
        public static final String HOUR = "hour";

        /**
         * Minutes in localtime 0 - 59.
         * <p>Type: INTEGER</p>
         */
        public static final String MINUTES = "minutes";

        /**
         * Days of the week encoded as a bit set.
         * <p>Type: INTEGER</p>
         *
         * {@link DayOfWeek}
         */
        public static final String DAYS_OF_WEEK = "daysofweek";

        /**
         * True if alarm is active.
         * <p>Type: BOOLEAN</p>
         */
        public static final String ENABLED = "enabled";

        /**
         * Determine if alarm is deleted after it has been used.
         * <p>Type: INTEGER</p>
         */
        public static final String DELETE_AFTER_USE = "delete_after_use";

        /**
         * The ID of this alarm as it is stored into the KKMCTimer server.
         * <p>Type: INTEGER</p>
         */
        public static final String KKMCTIMER_ID = "kkmctimer_id";

        /**
         * The timestamp, seconds in unix epoch, of the last time this alarm was modified.
         * <p>Type: LONG</p>
         */
        public static final String TIMESTAMP = "timestamp";
    }

    /**
     * Constants for the Instance table, which contains the state of each alarm.
     */
    protected interface InstancesColumns extends AlarmSettingColumns, BaseColumns {
        /**
         * The content:// style URL for this table.
         */
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/instances");

        /**
         * Alarm state when to show no notification.
         *
         * Can transitions to:
         * LOW_NOTIFICATION_STATE
         */
        public static final int SILENT_STATE = 0;

        /**
         * Alarm state to show low priority alarm notification.
         *
         * Can transitions to:
         * HIDE_NOTIFICATION_STATE
         * HIGH_NOTIFICATION_STATE
         * DISMISSED_STATE
         */
        public static final int LOW_NOTIFICATION_STATE = 1;

        /**
         * Alarm state to hide low priority alarm notification.
         *
         * Can transitions to:
         * HIGH_NOTIFICATION_STATE
         */
        public static final int HIDE_NOTIFICATION_STATE = 2;

        /**
         * Alarm state to show high priority alarm notification.
         *
         * Can transitions to:
         * DISMISSED_STATE
         * FIRED_STATE
         */
        public static final int HIGH_NOTIFICATION_STATE = 3;

        /**
         * Alarm state when alarm is in snooze.
         *
         * Can transitions to:
         * DISMISSED_STATE
         * FIRED_STATE
         */
        public static final int SNOOZE_STATE = 4;

        /**
         * Alarm state when alarm is being fired.
         *
         * Can transitions to:
         * DISMISSED_STATE
         * SNOOZED_STATE
         * MISSED_STATE
         */
        public static final int FIRED_STATE = 5;

        /**
         * Alarm state when alarm has been missed.
         *
         * Can transitions to:
         * DISMISSED_STATE
         */
        public static final int MISSED_STATE = 6;

        /**
         * Alarm state when alarm is done.
         */
        public static final int DISMISSED_STATE = 7;

        /**
         * Alarm year.
         *
         * <p>Type: INTEGER</p>
         */
        public static final String YEAR = "year";

        /**
         * Alarm month in year.
         *
         * <p>Type: INTEGER</p>
         */
        public static final String MONTH = "month";

        /**
         * Alarm day in month.
         *
         * <p>Type: INTEGER</p>
         */
        public static final String DAY = "day";

        /**
         * Alarm hour in 24-hour localtime 0 - 23.
         * <p>Type: INTEGER</p>
         */
        public static final String HOUR = "hour";

        /**
         * Alarm minutes in localtime 0 - 59
         * <p>Type: INTEGER</p>
         */
        public static final String MINUTES = "minutes";

        /**
         * Foreign key to Alarms table
         * <p>Type: INTEGER (long)</p>
         */
        public static final String ALARM_ID = "alarm_id";

        /**
         * Key to KKMCTimer server alarm
         * <p>Type: INTEGER (long)</p>
         */
        public static final String KKMCTIMER_ID = "kkmctimer_id";

        /**
         * Timestamp, in seconds unix epoch, of the last time this alarm was modified
         * <p>Type: INTEGER (long)</p>
         */
        public static final String TIMESTAMP = "timestamp";

        /**
         * Alarm state
         * <p>Type: INTEGER</p>
         */
        public static final String ALARM_STATE = "alarm_state";
    }

    /**
     * Constants for the Cities table, which contains all selectable cities.
     */
    protected interface CitiesColumns {
        /**
         * The content:// style URL for this table.
         */
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/cities");

        /**
         * Primary id for city.
         * <p>Type: STRING</p>
         */
        public static final String CITY_ID = "city_id";

        /**
         * City name.
         * <p>Type: STRING</p>
         */
        public static final String CITY_NAME = "city_name";

        /**
         * Timezone name of city.
         * <p>Type: STRING</p>
         */
        public static final String TIMEZONE_NAME = "timezone_name";

        /**
         * Timezone offset.
         * <p>Type: INTEGER</p>
         */
        public static final String TIMEZONE_OFFSET = "timezone_offset";
    }
}
