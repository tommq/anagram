import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

public class Anagram {



    public static void main(String [] args) throws Exception
    {
        HashSet<String> desiredHashes = new HashSet<>();
        desiredHashes.add("e4820b45d2277f3844eac66c903e84be");
        desiredHashes.add("23170acc097c24edb98fc5488ab033fe");
        desiredHashes.add("665e5bcb0c20062fe8abaaf4628bb154");
        List<String> anagram = List.of("poultryoutwitsants".split(""));




        List<String> words = new ArrayList<>();
        MessageDigest MD5 = getMD5();

        File inputF = new File("wordlist");

        InputStream inputFS = new FileInputStream(inputF);

        BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
        words.addAll(br.lines().collect(Collectors.toList()));
        br.close();

        var newwords = words.parallelStream().filter(word -> anagram.containsAll(List.of(word.split(""))) ).collect(Collectors.toList());
        newwords = new ArrayList<>(new LinkedHashSet<>(newwords));
        System.out.println(newwords.size());
        System.out.println(newwords);






    }





    private static MessageDigest getMD5(){
        try {
            MessageDigest MD = MessageDigest.getInstance("MD5");
            return MD;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;

    }

}
