package Localizator;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.text.*;

public class LocalBundy {
    public void playWithFormattingNumbers() {
        // Formatting Numbers
        double myNummy = 1234.568;
        var us = NumberFormat.getInstance(Locale.US);
        System.out.println(us.format(myNummy)); /* 1,234.568 */
        var it = NumberFormat.getInstance(Locale.ITALY);
        System.out.println(it.format(myNummy)); /* 1.234,568 */
        var ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(ca.format(myNummy)); /* 1 234,568 */
    }

    public void playWithFormattingCurrencies() {
        // Formatting Currencies
        double myPrice = 12.3;
        var ussy = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(ussy.format(myPrice)); /* $12.30 */
        var uk = NumberFormat.getCurrencyInstance(Locale.UK);
        System.out.println(uk.format(myPrice)); /* £12.30 */
        var deutsch = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(deutsch.format(myPrice)); /* 12,30 € */
    }

    public void playWithFormattingPercentages() {
        // Formatting Percentages
        double discount = 0.151;

        var uspercent = NumberFormat.getPercentInstance(Locale.US);
        System.out.println(uspercent.format(discount)); /* 15% */
        var gerpercent = NumberFormat.getPercentInstance(Locale.GERMANY);
        System.out.println(gerpercent.format(discount)); /* 15 % */
    }

    public void playWithParsingNumbers() {
        // Parsing Numbers
        String myNumStr = "15.72";
        var usns = NumberFormat.getInstance(Locale.US);
        // System.out.println(usns.parse(myNumStr)); /* Java.Text.ParseException */
    }

    public void playWithParsingNumbersWithCurrency() throws ParseException {
        // Parsing Numbers with Currency
        String myNum1 = "15.72";
        var usMyNum1 = NumberFormat.getInstance(Locale.US);
        System.out.println(usMyNum1.parse(myNum1)); /* 15.72 */

        String myNum2 = "15.72";
        var frMyNum2 = NumberFormat.getInstance(Locale.FRANCE);
        System.out.println(frMyNum2.parse(myNum2));

        // Parsing numbers with currency (example in Tutorial doesn't work as expected, so it was commented out):
        // String price123 = "$12,345.67";
        // var us123 = NumberFormat.getInstance(Locale.US);
        // double priceValue123 = (Double) us123.parse(price123);
        // System.out.println(priceValue123); /* 12345.67 */
    }

    public void playWithUsingCompactNumberFormat() {
        // Using CompactNumberFormat (new in Java 17!)
        int myNum234 = 8_765_432;
        var us234 = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(us234.format(myNum234)); /* 9M */
        var us235 = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        System.out.println(us235.format(myNum234)); /* 9 million */
        var gm234 = NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.SHORT);
        System.out.println(gm234.format(myNum234)); /* 9 Mio. */
        var gm235 = NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.LONG);
        System.out.println(gm234.format(myNum234)); /* 9 Millionen */
    }

    public void playWithLocalizingDatesAndTimes() {
        var dtdt = LocalDateTime.of(2023, Month.SEPTEMBER, 14, 9, 14, 57);

        var dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        var frfr = new Locale("fr", "FR");
        System.out.println(dtf.withLocale(frfr).format(dtdt)); /* 14/09/2023 */

        var dtf2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        var usus = new Locale("us", "EN");
        System.out.println(dtf2.withLocale(usus).format(dtdt)); /* 2023 Sep 14 */
    }

    public void playWithLocaleDisplaying() {
        var hr = new Locale("hr", "HR");
        var priceHr = 4.32;

        System.out.println(hr.getDisplayLanguage()); /* Croatian */
        System.out.println(hr.getDisplayCountry()); /* Croatia */
        System.out.println(NumberFormat.getCurrencyInstance(hr).format(priceHr)); /* 4,32 HRK */
    }
}
