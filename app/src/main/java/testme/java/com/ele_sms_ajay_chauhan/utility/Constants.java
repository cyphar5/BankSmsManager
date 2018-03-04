package testme.java.com.ele_sms_ajay_chauhan.utility;

import java.util.SimpleTimeZone;

/**
 * Created by achau on 03-03-2018.
 */

public class Constants {

    // regex patterns

    public static String regex_amount = "(?=[Mm][Rr][Pp][.]?|[Ii][Nn][Rr][.]?|[Rr][Ss][.]?)" ;
    public static String regex_merachant = "(?i)(?:\\sat\\s|in\\*)([A-Za-z0-9]*\\s?-?\\s?[A-Za-z0-9]*\\s?-?\\.?)" ;
    public static String regex_card = "(?i)(?:\\smade on|ur|made a\\s|in\\*)([A-Za-z]*\\s?-?\\s[A-Za-z]*\\s?-?\\s[A-Za-z]*\\s?-?)" ;
    public static String transaction ="(?=.*[Cc]ard.*|.*[Cc]redit.*)(?=.*[Ss]pent.*)(?=.*[Ii][Nn][Rr].*|.*[Rr][Ss][.]?.*|.*[Mm][Rr][Pp].*)";
    public static String card_num = "(?=XX.*|[Ee]nd.*)";
    public static String transaction_date = "(?=[Oo][Nn][ ]{1}[0-9]{1}.*)" ;
    public static String transaction_new_date = "^(?:(?:31(\\/|-|\\.|\\w)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.|\\w)(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.|\\w)(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.|\\w)(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$" ;
}
