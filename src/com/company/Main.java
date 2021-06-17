package com.company;

public class Main {

    public static int shift = 1;
    public static char[] separators = {'.', ',', ' ', '\n'};
    public static String textEncrypted = "Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв. Ъы зёюивй жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв. \n" +
            "Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх. \n" +
            "Ф юэимюб чхни южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч. \n" +
            "Ю зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад чжъви шхёвдгюмгдви. \n" +
            "Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню. \n" +
            "Въгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.\n";

    public static String lowerChars = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static String upperChars = lowerChars.toUpperCase();

    public static void main(String[] args) {
        while (shift < 34) {
            textDecrypt();
            shift++;
        }
    }

    public static void textDecrypt() {
        String textDecryptResult = "";
        Boolean skip = false;
        Boolean isUp = false;
        for (char encryptedChar : textEncrypted.toCharArray()) {

            for (char separatorChar : separators) {
                if (encryptedChar == separatorChar) {
                    textDecryptResult += encryptedChar;
                    skip = true;
                    break;
                }
            }
            if (!skip) {
                int position = lowerChars.indexOf(encryptedChar);
                if (position == -1) {
                    position = upperChars.indexOf(encryptedChar);
                    isUp = true;
                }

                position += shift;
                if (position > lowerChars.length() - 1) {
                    position = position - lowerChars.length();
                }

                if (isUp)
                    textDecryptResult += upperChars.charAt(position);
                else
                    textDecryptResult += lowerChars.charAt(position);


                isUp = false;
            } else {
                skip = false;
            }
        }
        System.out.println("Сдвиг:" + shift);
        System.out.println(textDecryptResult + "\n");
    }
}
