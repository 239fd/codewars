public class MorseCodeDecoder {
    public static String decode(String morseCode) {
      String morseDecode = "";
      for(String word : morseCode.trim().split("   ")){
        for(String letter : word.split("\\s+")){
                    morseDecode += MorseCode.get(letter);

        }
              morseDecode += ' ';

      }
              return morseDecode.trim();

    }

}
