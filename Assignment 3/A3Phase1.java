public class A3Phase1{
    public static String rulerSequence(int n){
        String prev;
        String result;
        if(n == 1){
            return "0";
        }if(n <= 0){
            return "";
        }
        prev = rulerSequence(n - 1);
        result = prev + (n-1) + prev;
        return  result;
    }
    public static void printAAN(String[] adjectives, String[] nouns){
        if(adjectives == null || nouns == null){
            return;
        }
        printAANRecursively(adjectives, nouns, 0, 0, 0);
    }

    public static void printAANRecursively(String[] adj, String[] n, int i, int j, int k){
        if(i >= adj.length){
            return;
        }
        if(j >= adj.length){
            printAANRecursively(adj, n, i+1, 0, 0);
            return;
        }
        if(i==j){
            printAANRecursively(adj, n, i, j+1, 0);
            return;
        }
        if(k >= n.length){
            printAANRecursively(adj, n, i, j+1, 0);
            return;
        }
        System.out.println(adj[i] + " " + adj[j] + " " + n[k]);
        printAANRecursively(adj, n, i, j, k + 1);


    }

    public static void main(String[] args) {
        String result = rulerSequence(8);
        System.out.println(result);

        String[] adjective = { "hypothetical", "spherical" };
        String[] nouns = { "universe", "cow" };

        printAAN(adjective, nouns);



    }
}