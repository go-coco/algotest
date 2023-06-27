public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Test t = new Test();

        int[] info = {0,1,0,1,0,0};
        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{4,5}};


        t.solve(info, edges);
    }
}
