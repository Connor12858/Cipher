import java.util.Random;

public class Cryption {
    static Random r = new Random();
    static int[] alphanums = new int[93];

    public static void SetValues() {
        for (int i = 0; i < 93; i++) {
            alphanums[i] = i + 33;
        }
    }

    public static String Decrypt(String msg) {
        String[] msgA =  msg.split(" ");

        String keyS = "";
        for(int i = 0; i < 4; i++){
            keyS = keyS.concat(msgA[i] + " ");
        }
        int[] keys = GetKeys(keyS);
        int key = (keys[0] + keys[1]) - (keys[0] + keys[2]);

        msg = "";
        for(int i = 4; i < msgA.length; i++){
            msg = msg.concat(msgA[i] + " ");
        }

        for (int i = 0; i < msg.length(); i++) {
            char u = msg.charAt(i);
            if (u != ' ') {
                int k = u;
                if (k <= (33 + (key - 1))) {
                    int q = (k - 33) - 1;
                    k = 126;
                    k -= (key - q);
                } else {
                    k -= key;
                }
                u = (char) k;
                msg = msg.substring(0, i) + u + msg.substring(i + 1);
            }
            key += keys[3];
            if (key >= 92) {
                key = 16;
            }
        }
        return msg;
    }

    private static int[] GetKeys(String key) {
        String[] keys = key.split(" ");
        int[] intKey = new int[4];
        intKey[0] = Integer.parseInt(keys[0]);
        intKey[1] = Integer.parseInt(keys[1]);
        intKey[2] = Integer.parseInt(keys[2]);
        intKey[3] = Integer.parseInt(keys[3]);
        return intKey;
    }

    private static int[] GenerateKeys() {
        int[] keys = new int[4];
        keys[0] = r.nextInt(15);
        keys[1] = r.nextInt(15) + 15;
        keys[2] = r.nextInt(15);
        keys[3] = r.nextInt(8) + 2;
        return keys;
    }

    public static String Encrypt(String msg) {
        int[] keys = GenerateKeys();
        int key = (keys[0] + keys[1]) - (keys[0] + keys[2]);

        for (int i = 0; i < msg.length(); i++) {
            char u = msg.charAt(i);
            if (u != ' ') {
                int k = u;
                if (k >= (126 - (key - 1))) {
                    int q = (126 - k) - 1;
                    k = 33;
                    k += (key - q);
                } else {
                    k += key;
                }
                u = (char) k;
                msg = msg.substring(0, i) + u + msg.substring(i + 1);
            }
            key += keys[3];
            if (key >= 92) {
                key = 16;
            }
        }

        for(int i = keys.length - 1; i >= 0; i--){
            msg = Integer.toString(keys[i]).concat(" " + msg);
        }

        return msg;
    }
}


