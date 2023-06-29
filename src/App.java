public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Test t = new Test();

        System.out.println(Error.valueOf("E0000").getError());

        System.out.println(Enum.valueOf(Error.class, "E0000"));
      System.out.println(Error.E0000.getError());
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{0,8},{1,4},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};


        t.solve(info, edges);
    }
}
