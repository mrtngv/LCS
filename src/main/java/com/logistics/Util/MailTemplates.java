package com.logistics.Util;

public class MailTemplates {

    public static final String senderSubject_mail = "Успешно регистрирана пратка";
    public static final String receiverSubject_mail  = "Очаквана пратка";
    public static final String senderSubject_rejectedMail = "Отказана пратка";
    public static final String senderSubject_deliveredMail = "Успешно пристигнала пратка";

    private static String buildFirstPart(String firstName) {
        return mailTemplate1_logo_and_address_to_person + "Здравейте, " +firstName + ",</p>";
    }

    private static String buildMiddlePartSender(String code) {
        return mailTemplate1_middle_part + code + mailTemplate1_middle_part_afterCode;
    }

    public static String buildSenderMail(String firstName, String code) {
        return buildFirstPart(firstName) + buildMiddlePartSender(code) + mailTemplate1_end_part;
    }

    public static String buildRejectedMail(String firstName, String code, String address, String city, boolean isOffice) {
        String officeOrPrivateAddress = "на личен адрес: град ";
        if (isOffice) {
            officeOrPrivateAddress= "в офис: град ";
        }
        return buildFirstPart(firstName) + mailTemplate2_middle_part + " Пратката ви с код " + code + " е отказана от получателя." +
                " Ще ви я върнем " + officeOrPrivateAddress + city + ", " + address + mailTemplate1_middle_part_afterCode + mailTemplate1_end_part;

    }

    public static String buildDeliveredMail(String firstName, String code) {
        return buildFirstPart(firstName) + mailTemplate2_middle_part + " Пратката Ви с код " + code + " е доставена успешно и приета от получател." + mailTemplate1_middle_part_afterCode + mailTemplate1_end_part;
    }

    public static String buildReceiverMail(String firstName, String code, String city, String address, boolean isOffice, String date) {
        String officeOrPrivateAdress = "личен адрес: град";
        if(isOffice) {
            officeOrPrivateAdress="офис: град ";
        }
        return buildFirstPart(firstName) + mailTemplate2_middle_part + " Очаквайте пратка до " + officeOrPrivateAdress + city + " , "
                + address + " с ориентировачна дата за доставка " + date + "." + mailTemplate2_middle_part2 + code + mailTemplate1_middle_part_afterCode + mailTemplate1_end_part;

    }

    private static final String mailTemplate1_logo_and_address_to_person = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
            "<head>\n" +
            "<meta charset=\"UTF-8\">\n" +
            "<meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
            "<meta name=\"x-apple-disable-message-reformatting\">\n" +
            "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "<meta content=\"telephone=no\" name=\"format-detection\">\n" +
            "<title></title>\n" +
            "<!--[if (mso 16)]>\n" +
            "<style type=\"text/css\">\n" +
            "a {text-decoration: none;}\n" +
            "</style>\n" +
            "<![endif]-->\n" +
            "<!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]-->\n" +
            "<!--[if gte mso 9]>\n" +
            "<xml>\n" +
            "<o:OfficeDocumentSettings>\n" +
            "<o:AllowPNG></o:AllowPNG>\n" +
            "<o:PixelsPerInch>96</o:PixelsPerInch>\n" +
            "</o:OfficeDocumentSettings>\n" +
            "</xml>\n" +
            "<![endif]-->\n" +
            "<style type=\"text/css\">\n" +
            "#outlook a {\n" +
            "padding:0;\n" +
            "}\n" +
            ".es-button {\n" +
            "mso-style-priority:100!important;\n" +
            "text-decoration:none!important;\n" +
            "}\n" +
            "a[x-apple-data-detectors] {\n" +
            "color:inherit!important;\n" +
            "text-decoration:none!important;\n" +
            "font-size:inherit!important;\n" +
            "font-family:inherit!important;\n" +
            "font-weight:inherit!important;\n" +
            "line-height:inherit!important;\n" +
            "}\n" +
            ".es-desk-hidden {\n" +
            "display:none;\n" +
            "float:left;\n" +
            "overflow:hidden;\n" +
            "width:0;\n" +
            "max-height:0;\n" +
            "line-height:0;\n" +
            "mso-hide:all;\n" +
            "}\n" +
            "[data-ogsb] .es-button {\n" +
            "border-width:0!important;\n" +
            "padding:10px 20px 10px 20px!important;\n" +
            "}\n" +
            "@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1 { font-size:30px!important; text-align:center; line-height:120%!important } h2 { font-size:26px!important; text-align:center; line-height:120%!important } h3 { font-size:20px!important; text-align:center; line-height:120%!important } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:30px!important } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:26px!important } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important } .es-menu td a { font-size:16px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:16px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:16px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:block!important } a.es-button, button.es-button { font-size:20px!important; display:block!important; border-width:10px 0px 10px 0px!important } .es-adaptive table, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } }\n" +
            "</style>\n" +
            "</head>\n" +
            "<body style=\"padding:0;-webkit-text-size-adjust:100%;width:100%;-ms-text-size-adjust:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;Margin:0\">\n" +
            "<div class=\"es-wrapper-color\" style=\"background-color:#F6F6F6\">\n" +
            "<!--[if gte mso 9]>\n" +
            "<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
            "<v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>\n" +
            "</v:background>\n" +
            "<![endif]-->\n" +
            "<table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"padding:0;background-repeat:repeat;border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;width:100%;background-position:center top;border-collapse:collapse;Margin:0;height:100%\">\n" +
            "<tr>\n" +
            "<td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
            "<table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"border-spacing:0px;mso-table-rspace:0pt;table-layout:fixed !important;mso-table-lspace:0pt;width:100%;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "<table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"background-color:#FFFFFF;border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;width:600px;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td align=\"left\" style=\"padding:0;padding-top:20px;padding-left:20px;Margin:0;padding-right:20px\">\n" +
            "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td valign=\"top\" align=\"center\" style=\"padding:0;width:560px;Margin:0\">\n" +
            "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td align=\"center\" style=\"padding:0;font-size:0px;Margin:0\"><img class=\"adapt-img\" src=\"https://rnjzmp.stripocdn.email/content/guids/CABINET_545d339d60fc47d358c589e25df46709/images/53771621637468780.jpg\" alt style=\"border:0;outline:none;-ms-interpolation-mode:bicubic;display:block;text-decoration:none\" width=\"480\" height=\"80\"></td>\n" +
            "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td align=\"left\" style=\"padding-top:20px;padding-left:20px;padding-bottom:20px;Margin:0;padding-right:20px\">\n" +
            "<table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td align=\"left\" style=\"padding:0;width:560px;Margin:0\">\n" +
            "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"color:#333333;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\">";

    private static final String mailTemplate1_middle_part = "<p style=\"color:#333333;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\"><br></p><p style=\"color:#333333;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\">Вашата пратка е успешно регистрирана.</p><p style=\"color:#333333;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\">Можете да проследите статуса ѝ от нашия&nbsp;сайт в секция \"<em><a target=\"_blank\" style=\"color:#1c496c;-webkit-text-size-adjust:none;text-decoration:underline;-ms-text-size-adjust:none;font-size:14px;line-height:21px;mso-line-height-rule:exactly\" href=\"https://logistic-company-cscb025.herokuapp.com/#/package/track\">Проследи <span style=\"font-family:'courier new', courier, 'lucida sans typewriter', 'lucida typewriter', monospace\"></span>пратка</a></em>\".</p><p style=\"color:#333333;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\">Кодът на пратката е: <strong>";
    private static final String mailTemplate1_middle_part_afterCode = "</strong></p><p style=\"color:#333333;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\"><br></p><p style=\"color:#333333;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\">Приятен и успешен ден,</p><p style=\"color:#333333;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\">Екипът на Needy<br><br></p></td>";
    private static final String mailTemplate2_middle_part="<p style=\"color:#333333;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\"><br></p><p style=\"color:#333333;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\">";
    private static final String mailTemplate2_middle_part2 = "</p><p style=\\\"color:#333333;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\\\">Повече информация относно пратката можете да намерите в нашия сайт в секция \"<em><a target=\"_blank\" style=\"color:#1c496c;-webkit-text-size-adjust:none;text-decoration:underline;-ms-text-size-adjust:none;font-size:14px;line-height:21px;mso-line-height-rule:exactly\" href=\"https://logistic-company-cscb025.herokuapp.com/#/package/track\">Проследи <span style=\"font-family:'courier new', courier, 'lucida sans typewriter', 'lucida typewriter', monospace\"></span>пратка</a></em>\".</p><p style=\"color:#333333;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\">Кодът на пратката е: <strong>";
    private static final String mailTemplate1_end_part = "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "</table>\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\" style=\"background-color:transparent;background-repeat:repeat;border-spacing:0px;mso-table-rspace:0pt;table-layout:fixed !important;mso-table-lspace:0pt;width:100%;background-position:center top;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "<table class=\"es-footer-body\" style=\"background-color:#ffffff;border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;width:600px;border-collapse:collapse\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\">\n" +
            "<tr>\n" +
            "<td style=\"background-color:#ffffff;padding:0;padding-top:20px;padding-left:20px;Margin:0;padding-right:20px\" bgcolor=\"#ffffff\" align=\"left\">\n" +
            "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td valign=\"top\" align=\"center\" style=\"padding:0;width:560px;Margin:0\">\n" +
            "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td align=\"center\" style=\"padding:0;padding-top:10px;padding-bottom:10px;font-size:0px;Margin:0\">\n" +
            "<table class=\"es-table-not-adapt es-social\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a target=\"_blank\" href=\"https://github.com/mrtngv/LC-UI\" style=\"color:#FFFFFF;-webkit-text-size-adjust:none;text-decoration:underline;-ms-text-size-adjust:none;font-size:14px;mso-line-height-rule:exactly\"><img title=\"Facebook\" src=\"https://rnjzmp.stripocdn.email/content/guids/CABINET_545d339d60fc47d358c589e25df46709/images/38061621638464012.png\" alt=\"Fb\" width=\"32\" height=\"32\" style=\"border:0;outline:none;-ms-interpolation-mode:bicubic;display:block;text-decoration:none\"></a></td>\n" +
            "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a target=\"_blank\" href=\"https://logistic-company-cscb025.herokuapp.com/#/\" style=\"color:#FFFFFF;-webkit-text-size-adjust:none;text-decoration:underline;-ms-text-size-adjust:none;font-size:14px;mso-line-height-rule:exactly\"><img title=\"Twitter\" src=\"https://rnjzmp.stripocdn.email/content/guids/CABINET_545d339d60fc47d358c589e25df46709/images/80491621638770750.png\" alt=\"Tw\" width=\"32\" height=\"30\" style=\"border:0;outline:none;-ms-interpolation-mode:bicubic;display:block;text-decoration:none\"></a></td>\n" +
            "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a target=\"_blank\" href=\"https://github.com/mrtngv/LCS\" style=\"color:#FFFFFF;-webkit-text-size-adjust:none;text-decoration:underline;-ms-text-size-adjust:none;font-size:14px;mso-line-height-rule:exactly\"><img title=\"Instagram\" src=\"https://rnjzmp.stripocdn.email/content/guids/CABINET_545d339d60fc47d358c589e25df46709/images/38061621638464012.png\" alt=\"Inst\" width=\"32\" height=\"32\" style=\"border:0;outline:none;-ms-interpolation-mode:bicubic;display:block;text-decoration:none\"></a></td>\n" +
            "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0\"><a target=\"_blank\" href=\"https://logistics-engine.herokuapp.com/\" style=\"color:#FFFFFF;-webkit-text-size-adjust:none;text-decoration:underline;-ms-text-size-adjust:none;font-size:14px;mso-line-height-rule:exactly\"><img title=\"Youtube\" src=\"https://rnjzmp.stripocdn.email/content/guids/CABINET_545d339d60fc47d358c589e25df46709/images/80491621638770750.png\" alt=\"Yt\" width=\"32\" height=\"30\" style=\"border:0;outline:none;-ms-interpolation-mode:bicubic;display:block;text-decoration:none\"></a></td>\n" +
            "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td align=\"center\" style=\"padding:0;padding-top:5px;padding-bottom:5px;Margin:0\"><p style=\"color:#999999;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\">ул.&nbsp;„ Монтевидео“ 21, 1618 ж.к. Овча купел 2, София</p><p style=\"color:#999999;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\">Тел: +359 884 842 248</p><p style=\"color:#999999;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;mso-line-height-rule:exactly;Margin:0\"><span style=\"text-decoration: underline;\">Свържете се с нас</span> / <span style=\"text-decoration: underline;\">GDPR</span> / <span style=\"text-decoration: underline;\">Отписване</span> / <span style=\"text-decoration: underline;\">Условия</span></p></td>\n" +
            "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "</table>\n" +
            "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-header\" align=\"center\" style=\"background-color:transparent;background-repeat:repeat;border-spacing:0px;mso-table-rspace:0pt;table-layout:fixed !important;mso-table-lspace:0pt;width:100%;background-position:center top;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "<table bgcolor=\"#ffffff\" class=\"es-header-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"background-color:#FFFFFF;border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;width:600px;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td style=\"background-color:transparent;padding-top:20px;padding-left:20px;padding-bottom:20px;background-position:left bottom;Margin:0;padding-right:20px\" bgcolor=\"transparent\" align=\"left\">\n" +
            "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td valign=\"top\" align=\"center\" style=\"padding:0;width:560px;Margin:0\">\n" +
            "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td align=\"center\" style=\"padding:20px;font-size:0;Margin:0\">\n" +
            "<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-spacing:0px;mso-table-rspace:0pt;mso-table-lspace:0pt;border-collapse:collapse\">\n" +
            "<tr>\n" +
            "<td style=\"padding:0;margin:0px 0px 0px 0px;background:none;width:100%;border-bottom:1px solid #cccccc;Margin:0;height:1px\"></td>\n" +
            "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "</table></td>\n" +
            "</tr>\n" +
            "</table>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";


}
