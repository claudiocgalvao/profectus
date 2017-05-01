package br.com.gti.profectus.tools.dateTime;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.LocalDate;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;

/**	
 * DateHelper.
 */
@Slf4j
public abstract class DateHelper {

    private static final Integer DAYS_MONTH_31 = 31;

    /**
     * Description.
     */
    public static final SimpleDateFormat DATE_YEAR = new SimpleDateFormat("yyyy");

    /**
     * Description.
     */
    public static final SimpleDateFormat DATE_MONTH = new SimpleDateFormat("MM");

    /**
     * Description.
     */
    public static final SimpleDateFormat DATE_DAY = new SimpleDateFormat("dd");

    /**
     * Description.
     */
    public static final SimpleDateFormat DATE_YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Description.
     */
    public static final SimpleDateFormat DATE_YYYY_MM = new SimpleDateFormat("yyyy-MM");

    /**
     * Description.
     */
    public static final SimpleDateFormat DATETIME_YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Description.
     */
    public static final SimpleDateFormat DATETIME_YYYY_MM_DD_HHMMSS = new SimpleDateFormat("yyyy-MM-dd_HHmmss");

    /**
     * Description.
     */
    public static final SimpleDateFormat DATETIME_YYYY_MM_DD_HH_MM = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     * Description.
     */
    public static final SimpleDateFormat DATETIME_DD_MM_YYYY_HH_MM = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    /**
     * Description.
     */
    public static final SimpleDateFormat DATETIME_DD_MM_YYYY_HH_MM_SS = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    /**
     * Description.
     */
    public static final SimpleDateFormat DATE_DD_MM_YYYY = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Description.
     */
    public static final SimpleDateFormat HOUR_HH_MM_SS = new SimpleDateFormat("HH:mm:ss");

    /**
     * Description.
     */
    public static final SimpleDateFormat HOUR_HH_MM = new SimpleDateFormat("HH:mm");

    /**
     * Description.
     */
    public static final SimpleDateFormat DAY_DD_MM_YYYY = new SimpleDateFormat("EEEE, dd MMM yyyy");

    /**
     * Description.
     */
    public static final SimpleDateFormat DATETIME_DD_MM_YYYY_HH_MM_SS_BAR_SEPARATOR = new SimpleDateFormat(
            "dd/MM/yyyy HH:mm:ss");

    /**
     * Description.
     */
    public static final SimpleDateFormat DATE_DD_MM_YYYY_BAR_SEPARATOR = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Formata a data invertida sem traços ou barra YYYYMMDD.
     */
    public static final SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");

    private static final Integer INFINITE_YEARS = 9999;

    /**
     * Constructor.
     */
    private DateHelper() {
    }

    /**
     * String to Date.
     * @param date
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date parseToDateTime(String date, SimpleDateFormat format) throws ParseException {
        return format.parse(date);
    }

    /**
     * String to java.sql.Date.
     * @param date
     * @param format
     * @return
     * @throws ParseException
     */
    public static java.sql.Date parseToSqlDate(String date, SimpleDateFormat format) throws ParseException {
        return new java.sql.Date(format.parse(date).getTime());
    }

    /**
     * Date to String.
     * @param date
     * @param format
     * @return
     */
    public static String formatDateTime(Date date, SimpleDateFormat format) {
        if (date != null) {
            return format.format(date);
        } else {
            return "";
        }
    }

    /**
     * Date to Time.
     * @ date
     * @return
     * @throws ParseException
     */
    public static String formatToTime(Date date) throws ParseException {
        return HOUR_HH_MM_SS.format(date);
    }

    /**
     * Date to Timestamp format oracle SQL.
     * @param date
     * @return
     */
    public static Timestamp parseToTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    /**
     * Verify business day String date.
     * @param date
     * @param format
     * @return
     * @throws ParseException
     */
    public static boolean isBusinessDay(String date, SimpleDateFormat format) throws ParseException {
        Date dateToVerify = format.parse(date);
        Calendar cDateToVerify = new GregorianCalendar();
        cDateToVerify.setTime(dateToVerify);
        int dayOfWeek = cDateToVerify.get(Calendar.DAY_OF_WEEK);
        return Calendar.SATURDAY == dayOfWeek || Calendar.SUNDAY == dayOfWeek ? false : true;
    }

    /**
     * Verify business day by Date Object.
     * @param date
     * @return
     * @throws ParseException
     */
    public static boolean isBusinessDay(Date date) throws ParseException {
        Calendar cDateToVerify = new GregorianCalendar();
        cDateToVerify.setTime(date);
        int dayOfWeek = cDateToVerify.get(Calendar.DAY_OF_WEEK);
        return Calendar.SATURDAY == dayOfWeek || Calendar.SUNDAY == dayOfWeek ? false : true;
    }

    /**
     * Verify Expired Date.
     * @param date
     * @return Boolean
     * @throws ParseException
     */
    public static boolean isExpiredDate(Date date) throws ParseException {
        Boolean resp = Boolean.FALSE;
        Calendar cDateToVerify = new GregorianCalendar();
        cDateToVerify.setTime(date);
        Calendar today = new GregorianCalendar();
        if (cDateToVerify.get(Calendar.YEAR) != INFINITE_YEARS && cDateToVerify.before(today)) {
            resp = Boolean.TRUE;
        }
        return resp;
    }

    /**
     * Return Quantity Business Days.
     * @param dateStart
     * @param dateFinish
     * @return
     */
    public static int returnQtdWorkingDays(Date dateStart, Date dateFinish) {
        int iBusinessDays = 0;
        LocalDate dateStartTemp = new LocalDate(dateStart);
        LocalDate dateFinishTemp = new LocalDate(dateFinish);
        Calendar calendar = new GregorianCalendar();
        while (!dateStartTemp.isAfter(dateFinishTemp)) {
            calendar.setTime(dateStartTemp.toDate());
            try {
                if (isBusinessDay(calendar.getTime())) {
                    iBusinessDays++;
                }
            } catch (ParseException e) {
                log.error(e.getLocalizedMessage(), e);
            }
            dateStartTemp = dateStartTemp.plusDays(1);
        }
        return iBusinessDays;
    }

    /**
     * Return Calculate quantity Business Days.
     * @param date
     * @return
     */
    public static int calcQtdeWorkingDaysByYear(Date date) {
        Calendar calStart = new GregorianCalendar();
        Calendar calFin = new GregorianCalendar();
        //Get Date Start
        calStart.setTime(date);
        calStart.set(Calendar.DAY_OF_MONTH, 01);
        calStart.set(Calendar.MONTH, Calendar.JANUARY);
        //Get Date Finish
        calFin.set(Calendar.YEAR, calStart.get(Calendar.YEAR));
        calFin.set(Calendar.MONTH, Calendar.DECEMBER);
        calStart.set(Calendar.DAY_OF_MONTH, DAYS_MONTH_31);
        //Return Quantity Days
        return returnQtdWorkingDays(calStart.getTime(), calFin.getTime());
    }

    /**
     * isDate.
     * @author claudio.cesar
     * @since 04/09/2015
     * @param dateStr
     * @return
     * @throws java.text.ParseException
     */
    public static boolean isDate(String dateStr) throws java.text.ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = new GregorianCalendar();

        // gerando o calendar
        cal.setTime(df.parse(dateStr));

        // separando os dados da string para comparacao e validacao
        String[] data = dateStr.split("-");
        String dia = data[2];
        String mes = data[1];
        String ano = data[0];

        // testando se hah discrepancia entre a data que foi
        // inserida no caledar e a data que foi passada como
        // string. se houver diferenca, a data passada era
        // invalida
        if ((new Integer(dia)).intValue() != (new Integer(cal.get(Calendar.DAY_OF_MONTH))).intValue()) {
            // dia nao casou
            return (false);
        } else
            if ((new Integer(mes)).intValue() != (new Integer(cal.get(Calendar.MONTH) + 1)).intValue()) {
                // mes nao casou
                return (false);
            } else
                if ((new Integer(ano)).intValue() != (new Integer(cal.get(Calendar.YEAR))).intValue()) {
                    // ano nao casou
                    return (false);
                }

        return (true);
    }

    /**
     * Validate Final Date Before Initial Date.
     * @since 24/09/2015
     * @param bindingResult
     * @param fieldNameInitialDate
     * @param fieldNameFinalDate
     * @param messagesProperties
     */
    public static boolean validateFinalDateBeforeInitialDate(final BindingResult bindingResult,
            final String fieldNameInitialDate,
            final String fieldNameFinalDate,
            final String messagesProperties) {

        Boolean reaply = null;
        Assert.notNull(bindingResult, "Errors object must not be null");
        Object valueInitialDate = bindingResult.getFieldValue(fieldNameInitialDate);
        Object valueFinalDate = bindingResult.getFieldValue(fieldNameFinalDate);
        try {

            Date initialDateInitial = parseToDateTime(valueInitialDate.toString(), DATE_YYYY_MM_DD);
            Date finalDateFinal = parseToDateTime(valueFinalDate.toString(), DATE_YYYY_MM_DD);

            if (finalDateFinal.before(initialDateInitial)) {
                reaply = false;
                bindingResult.rejectValue(fieldNameFinalDate, messagesProperties);

            } else {
                reaply = true;
            }

        } catch (ParseException e) {
            reaply = false;
            bindingResult.rejectValue(fieldNameInitialDate, messagesProperties);
            bindingResult.rejectValue(fieldNameFinalDate, messagesProperties);
        }
        return reaply;
    }

    /**
     * Is Final Date Before Initial Date.
     * @since 28/09/2015
     * @param bindingResult
     * @param initialDate
     * @param finalDate
     */
    public static boolean isFinalDateBeforeInitialDate(String initialDate, final String finalDate) {

        Boolean reaply = null;
        try {

            Date dateInitial = parseToDateTime(initialDate.toString(), DATE_YYYY_MM_DD);
            Date dateFinal = parseToDateTime(finalDate.toString(), DATE_YYYY_MM_DD);

            if (dateFinal.before(dateInitial)) {
                reaply = false;

            } else {
                reaply = true;
            }

        } catch (ParseException e) {
            reaply = false;
        }
        return reaply;
    }

    /**
     * ChangeDate.
     * @author claudio.cesar
     * @since 17/12/2015
     * @param numberDays
     * @return Date
     */
    public static Date changeDate(Integer numberDays) {

        java.util.Calendar cal = Calendar.getInstance();

        try {
            cal.add(Calendar.DATE, numberDays);

        } catch (Exception e) {
            log.error("DateHelper.changeDate: ", e);
        }

        return cal.getTime();
    }
}
