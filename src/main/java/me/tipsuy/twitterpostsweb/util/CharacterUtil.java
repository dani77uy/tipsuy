package me.tipsuy.twitterpostsweb.util;

import java.util.Objects;

import com.vdurmont.emoji.EmojiManager;

/**
 * @author Daniel Baharian
 * @since 3 oct. 2021
 */
public class CharacterUtil {

   private static final String LETTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

   private static final String NEGRITA_SERIF = "\uD835\uDFCE\uD835\uDFCF\uD835\uDFD0\uD835\uDFD1\uD835\uDFD2\uD835\uDFD3\uD835\uDFD4\uD835\uDFD5"
         + "\uD835\uDFD6\uD835\uDFD7\uD835\uDC00\uD835\uDC01\uD835\uDC02\uD835\uDC03\uD835\uDC04\uD835\uDC05\uD835\uDC06\uD835\uDC07\uD835\uDC08"
         + "\uD835\uDC09\uD835\uDC0A\uD835\uDC0B\uD835\uDC0C\uD835\uDC0D\uD835\uDC0E\uD835\uDC0F\uD835\uDC10\uD835\uDC11\uD835\uDC12\uD835\uDC13"
         + "\uD835\uDC14\uD835\uDC15\uD835\uDC16\uD835\uDC17\uD835\uDC18\uD835\uDC19\uD835\uDC1A\uD835\uDC1B\uD835\uDC1C\uD835\uDC1D\uD835\uDC1E"
         + "\uD835\uDC1F\uD835\uDC20\uD835\uDC21\uD835\uDC22\uD835\uDC23\uD835\uDC24\uD835\uDC25\uD835\uDC26\uD835\uDC27\uD835\uDC28\uD835\uDC29"
         + "\uD835\uDC2A\uD835\uDC2B\uD835\uDC2C\uD835\uDC2D\uD835\uDC2E\uD835\uDC2F\uD835\uDC30\uD835\uDC31\uD835\uDC32\uD835\uDC33";

   private static final String NEGRITA_SANS = "\uD835\uDFEC\uD835\uDFED\uD835\uDFEE\uD835\uDFEF\uD835\uDFF0\uD835\uDFF1\uD835\uDFF2\uD835\uDFF3"
         + "\uD835\uDFF4\uD835\uDFF5\uD835\uDDD4\uD835\uDDD5\uD835\uDDD6\uD835\uDDD7\uD835\uDDD8\uD835\uDDD9\uD835\uDDDA\uD835\uDDDB\uD835\uDDDC"
         + "\uD835\uDDDD\uD835\uDDDE\uD835\uDDDF\uD835\uDDE0\uD835\uDDE1\uD835\uDDE2\uD835\uDDE3\uD835\uDDE4\uD835\uDDE5\uD835\uDDE6\uD835\uDDE7"
         + "\uD835\uDDE8\uD835\uDDE9\uD835\uDDEA\uD835\uDDEB\uD835\uDDEC\uD835\uDDED\uD835\uDDEE\uD835\uDDEF\uD835\uDDF0\uD835\uDDF1\uD835\uDDF2"
         + "\uD835\uDDF3\uD835\uDDF4\uD835\uDDF5\uD835\uDDF6\uD835\uDDF7\uD835\uDDF8\uD835\uDDF9\uD835\uDDFA\uD835\uDDFB\uD835\uDDFC\uD835\uDDFD"
         + "\uD835\uDDFE\uD835\uDDFF\uD835\uDE00\uD835\uDE01\uD835\uDE02\uD835\uDE03\uD835\uDE04\uD835\uDE05\uD835\uDE06\uD835\uDE07";

   private static final String SCRIPT_NEGRITA = "\uD835\uDCD0\uD835\uDCD1\uD835\uDCD2\uD835\uDCD3\uD835\uDCD4\uD835\uDCD5\uD835\uDCD6\uD835\uDCD7"
         + "\uD835\uDCD8\uD835\uDCD9\uD835\uDCDA\uD835\uDCDB\uD835\uDCDC\uD835\uDCDD\uD835\uDCDE\uD835\uDCDF\uD835\uDCE0\uD835\uDCE1\uD835\uDCE2"
         + "\uD835\uDCE3\uD835\uDCE4\uD835\uDCE5\uD835\uDCE6\uD835\uDCE7\uD835\uDCE8\uD835\uDCE9\uD835\uDCEA\uD835\uDCEB\uD835\uDCEC\uD835\uDCED"
         + "\uD835\uDCEE\uD835\uDCEF\uD835\uDCF0\uD835\uDCF1\uD835\uDCF2\uD835\uDCF3\uD835\uDCF4\uD835\uDCF5\uD835\uDCF6\uD835\uDCF7\uD835\uDCF8"
         + "\uD835\uDCF9\uD835\uDCFA\uD835\uDCFB\uD835\uDCFC\uD835\uDCFD\uD835\uDCFE\uD835\uDCFF\uD835\uDD00\uD835\uDD01\uD835\uDD02\uD835\uDD03";

   private static final String CIRCLES = "⓪①②③④⑤⑥⑦⑧⑨ⒶⒷⒸⒹⒺⒻⒼⒽⒾⒿⓀⓁⓂⓃⓄⓅⓆⓇⓈⓉⓊⓋⓌⓍⓎⓏⓐⓑⓒⓓⓔⓕⓖⓗⓘⓙⓚⓛⓜⓝⓞⓟⓠⓡⓢⓣⓤⓥⓦⓧⓨⓩ";

   private static final String CURSIVE = "\uD835\uDCD0\uD835\uDCD1\uD835\uDCD2\uD835\uDCD3\uD835\uDCD4\uD835\uDCD5\uD835\uDCD6\uD835\uDCD7\uD835"
         + "\uDCD8\uD835\uDCD9\uD835\uDCDA\uD835\uDCDB\uD835\uDCDC\uD835\uDCDD\uD835\uDCDE\uD835\uDCDF\uD835\uDCE0\uD835\uDCE1\uD835\uDCE2\uD835"
         + "\uDCE3\uD835\uDCE4\uD835\uDCE5\uD835\uDCE6\uD835\uDCE7\uD835\uDCE8\uD835\uDCE9\uD835\uDCEA\uD835\uDCEB\uD835\uDCEC\uD835\uDCED\uD835"
         + "\uDCEE\uD835\uDCEF\uD835\uDCF0\uD835\uDCF1\uD835\uDCF2\uD835\uDCF3\uD835\uDCF4\uD835\uDCF5\uD835\uDCF6\uD835\uDCF7\uD835\uDCF8\uD835"
         + "\uDCF9\uD835\uDCFA\uD835\uDCFB\uD835\uDCFC\uD835\uDCFD\uD835\uDCFE\uD835\uDCFF\uD835\uDD00\uD835\uDD01\uD835\uDD02\uD835\uDD03";

   private static final String GOTHIC = "\uD835\uDD6C\uD835\uDD6D\uD835\uDD6E\uD835\uDD6F\uD835\uDD70\uD835\uDD71\uD835\uDD72\uD835\uDD73\uD835"
         + "\uDD74\uD835\uDD75\uD835\uDD76\uD835\uDD77\uD835\uDD78\uD835\uDD79\uD835\uDD7A\uD835\uDD7B\uD835\uDD7C\uD835\uDD7D\uD835\uDD7E\uD835"
         + "\uDD7F\uD835\uDD80\uD835\uDD81\uD835\uDD82\uD835\uDD83\uD835\uDD84\uD835\uDD85\uD835\uDD86\uD835\uDD87\uD835\uDD88\uD835\uDD89\uD835"
         + "\uDD8A\uD835\uDD8B\uD835\uDD8C\uD835\uDD8D\uD835\uDD8E\uD835\uDD8F\uD835\uDD90\uD835\uDD91\uD835\uDD92\uD835\uDD93\uD835\uDD94\uD835"
         + "\uDD95\uD835\uDD96\uD835\uDD97\uD835\uDD98\uD835\uDD99\uD835\uDD9A\uD835\uDD9B\uD835\uDD9C\uD835\uDD9D\uD835\uDD9E\uD835\uDD9F";

   private static final String HANDWRITE = "\uD835\uDFF6\uD835\uDFF7\uD835\uDFF8\uD835\uDFF9\uD835\uDFFA\uD835\uDFFB\uD835\uDFFC\uD835\uDFFD\uD835"
         + "\uDFFE\uD835\uDFFF\uD835\uDE70\uD835\uDE71\uD835\uDE72\uD835\uDE73\uD835\uDE74\uD835\uDE75\uD835\uDE76\uD835\uDE77\uD835\uDE78\uD835"
         + "\uDE79\uD835\uDE7A\uD835\uDE7B\uD835\uDE7C\uD835\uDE7D\uD835\uDE7E\uD835\uDE7F\uD835\uDE80\uD835\uDE81\uD835\uDE82\uD835\uDE83\uD835"
         + "\uDE84\uD835\uDE85\uD835\uDE86\uD835\uDE87\uD835\uDE88\uD835\uDE89\uD835\uDE8A\uD835\uDE8B\uD835\uDE8C\uD835\uDE8D\uD835\uDE8E\uD835"
         + "\uDE8F\uD835\uDE90\uD835\uDE91\uD835\uDE92\uD835\uDE93\uD835\uDE94\uD835\uDE95\uD835\uDE96\uD835\uDE97\uD835\uDE98\uD835\uDE99\uD835"
         + "\uDE9A\uD835\uDE9B\uD835\uDE9C\uD835\uDE9D\uD835\uDE9E\uD835\uDE9F\uD835\uDEA0\uD835\uDEA1\uD835\uDEA2\uD835\uDEA3";

   public static String getNumberEmoji(int i) {
      switch (i) {
         case 0 : return EmojiManager.getForAlias("zero").getUnicode();
         case 1 : return EmojiManager.getForAlias("one").getUnicode();
         case 2 : return EmojiManager.getForAlias("two").getUnicode();
         case 3 : return EmojiManager.getForAlias("three").getUnicode();
         case 4 : return EmojiManager.getForAlias("four").getUnicode();
         case 5 : return EmojiManager.getForAlias("five").getUnicode();
         case 6 : return EmojiManager.getForAlias("six").getUnicode();
         case 7 : return EmojiManager.getForAlias("seven").getUnicode();
         case 8 : return EmojiManager.getForAlias("eight").getUnicode();
         case 9 : return EmojiManager.getForAlias("nine").getUnicode();
         default: return Integer.toString(i);
      }
   }

   public static void main(String[] args) {
      System.out.println(convertWordToStyle(4, "PENAROL penarol"));
      System.out.println(convertWordToStyle(7, "Seras eterno como el tiempo y floreceras en cada primavera"));
   }

   public static String convertWordToStyle(int style, String word) {
      final var result = new StringBuilder();
      for (Character c : word.toCharArray()) {
         result.append(getLetter(style, c));
      }
      return result.toString();
   }

   public static String getCountryEmojiFlag(String alias) {
      if (Objects.nonNull(EmojiManager.getForAlias(alias))) {
         return EmojiManager.getForAlias(alias).getUnicode();
      }
      switch (alias) {
         case "en" : return "\uD83C\uDFF4\uDB40\uDC67\uDB40\uDC62\uDB40\uDC65\uDB40\uDC6E\uDB40\uDC67\uDB40\uDC7F";
         case "sc" : return "\uD83C\uDFF4\uDB40\uDC67\uDB40\uDC62\uDB40\uDC73\uDB40\uDC63\uDB40\uDC74\uDB40\uDC7F";
         case "wa" : return "\uD83C\uDFF4\uDB40\uDC67\uDB40\uDC62\uDB40\uDC77\uDB40\uDC6C\uDB40\uDC73\uDB40\uDC7F";
         case "ni" : return "\uD83C\uDDEC\uD83C\uDDE7";
      }
      throw new IllegalArgumentException("Invalid alias");
   }

   private static String getLetter(int style, char letter) {
      try {
         switch (style) {
            case 1: {
               return NEGRITA_SERIF.substring(LETTERS.lastIndexOf(letter) * 2, LETTERS.lastIndexOf(letter) * 2 + 2);
            }
            case 2: {
               return NEGRITA_SANS.substring(LETTERS.lastIndexOf(letter) * 2, LETTERS.lastIndexOf(letter) * 2 + 2);
            }
            case 3: {
               return SCRIPT_NEGRITA.substring((LETTERS.lastIndexOf(letter)-10) * 2, (LETTERS.lastIndexOf(letter)-10) * 2 + 2);
            }
            case 4 : {
               return CIRCLES.substring(LETTERS.lastIndexOf(letter), LETTERS.lastIndexOf(letter) + 1);
            }
            case 5: {
               return CURSIVE.substring((LETTERS.lastIndexOf(letter)-10) * 2, (LETTERS.lastIndexOf(letter)-10) * 2 + 2);
            }
            case 6: {
               return GOTHIC.substring((LETTERS.lastIndexOf(letter)-10) * 2, (LETTERS.lastIndexOf(letter)-10) * 2 + 2);
            }
            case 7: {
               return HANDWRITE.substring(LETTERS.lastIndexOf(letter) * 2, LETTERS.lastIndexOf(letter) * 2 + 2);
            }
            default: {
               return Character.toString(letter);
            }
         }
      } catch (IndexOutOfBoundsException ex) {
         return Character.toString(letter);
      }
   }

}
