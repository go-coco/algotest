import java.util.Comparator;
import java.util.PriorityQueue;


public class Test {

    int max = 0;

    class Node{
        int sheep, wolf, number;
        boolean visited;
        Node child1, child2;

        public Node(int num){
            this.number=num;
        }

        public Node(int num, int sheep, int wolf){
            this.sheep = sheep;
            this.wolf = wolf;
            this.number=num;
        }

        public int getSheep(){
            return this.sheep;
        }

        public int getWolf(){
            return this.wolf;
        }
     

        public void setSheepOrWolf(int sep){
            switch(sep){
                case 0 : this.sheep = 1; break;
                case 1 : this.wolf = 1; break;
            }
        }

    }

    public int solve(int[] info, int[][] edges){
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getSheep).thenComparingInt(Node::getWolf));
        boolean[] visited = new boolean[info.length];
        Node[] nodes = new Node[info.length];

      
        for(int i = 0; i<info.length; i++){
          nodes[i] = new Node(i);   
          nodes[i].setSheepOrWolf(info[i]);
        }

   
        for(int i = 0; i<info.length; i++){
            for(int[] arr : edges){
                if(i == arr[0]){
                if(nodes[arr[0]].child1 == null) {
                     nodes[arr[0]].child1 = nodes[arr[1]];
                }
                else if(nodes[arr[0]].child2 == null) {
                    nodes[arr[0]].child2 = nodes[arr[1]];
                }
                else break;
                }
            }
          
        }

        
        Node n = null;
        while(!pq.isEmpty()){
            n = pq.poll();
            System.out.println(n.number+ " "+ n.sheep+ ", "+n.wolf);
        }

        
       // System.out.println(nodes[4].child1.number);

        Node start = new Node(-1);
        start.sheep = 0;
        start.wolf = 0;
        travel(start, nodes[0], visited, pq);
        System.out.println("max: "+max);

        return answer;
    }

    public void travel(Node parent, Node current, boolean[] visited, PriorityQueue<Node> pq){

        // 최대값 갱신
        if(parent.sheep+current.sheep > pq.peek().sheep) {
            pq.add(new Node(current.number, parent.sheep+current.sheep, pq.peek().wolf));
            max = Math.max(max, parent.sheep+current.sheep);
         }

         

        if(current.child1 != null && parent.sheep+current.sheep > ){
            int newSheep = current.sheep+current.child1.sheep;
            int newWolf = current.wolf+current.child1.wolf;
                 travel(current, current.child1, visited, pq);
       
        }
        if(current.child2 != null)
            travel(current, current.child2, visited, pq);
            

        return;
    }
    
}
