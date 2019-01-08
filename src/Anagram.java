import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {



    public static void main(String [] args) throws Exception
    {
        HashSet<String> desiredHashes = new HashSet<>();
        desiredHashes.add("e4820b45d2277f3844eac66c903e84be");
        desiredHashes.add("23170acc097c24edb98fc5488ab033fe");
        desiredHashes.add("665e5bcb0c20062fe8abaaf4628bb154");

        MessageDigest MD5 = getMD5();

        List<String> inputList = new ArrayList<String>();
        File inputF = new File("wordlist");

        InputStream inputFS = new FileInputStream(inputF);

        BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

        // skip the header of the csv

        inputList = br.lines().collect(Collectors.toList());
        br.close();
        desiredHashes.addAll(inputList);
        System.out.println("inputList = " + inputList.size());








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
