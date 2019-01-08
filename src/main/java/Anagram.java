import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Anagram {

    static HashSet<String> desiredHashes;

    public static void main(String [] args) throws Exception
    {
        desiredHashes = new HashSet<>();
        desiredHashes.add("e4820b45d2277f3844eac66c903e84be");
        desiredHashes.add("23170acc097c24edb98fc5488ab033fe");
        desiredHashes.add("665e5bcb0c20062fe8abaaf4628bb154");
        List<String> anagram = List.of("poultryoutwitsants".split(""));


        List<String> words = new ArrayList<>();

        File inputF = new File("wordlist");

        InputStream inputFS = new FileInputStream(inputF);

        BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
        words.addAll(br.lines().collect(Collectors.toList()));
        br.close();

        List<String> newwords = words.parallelStream().filter(word -> anagram.containsAll(List.of(word.split(""))) ).collect(Collectors.toList());
        newwords = new ArrayList<>(new LinkedHashSet<>(newwords));
        System.out.println(newwords.size());
        System.out.println(newwords);

        newwords.parallelStream().forEach(word -> {
            if(compareHashes(word)){
                System.out.println(word);
            }
        });


    }

    private static boolean compareHashes(String word) {
        String hash = org.apache.commons.codec.digest.DigestUtils.md5Hex(word);
        return desiredHashes.contains(hash);
    }

}
