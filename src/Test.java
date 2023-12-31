import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;


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
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getSheep).reversed().thenComparingInt(Node::getWolf));
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

        
       Stack<Node> next = new Stack<>();
        
       // System.out.println(nodes[4].child1.number);

        Node start = new Node(-1);
        start.sheep = 0;
        start.wolf = 0;
        pq.add(start);
        travel(start, nodes[0], visited, pq);
        System.out.println("max: "+pq.peek().sheep);

        return answer;
    }

    public void travel(Node parent, Node current, boolean[] visited, PriorityQueue<Node> pq){

        // 현재 위치에서 상태값 계산
        int sh = pq.peek().sheep;
        int sheep = Math.max(parent.sheep,pq.peek().sheep)+current.sheep;
        int wolf = parent.wolf+current.wolf;
        
        // 양보다 늑대가 많으면 더 이상 탐색하지 않음
         if(sheep > wolf) {
          
         
            current.sheep = sheep;
            current.wolf = wolf;
            visited[current.number] = true;
         }

        // 최대값 갱신
        if(sheep > pq.peek().sheep) {
            pq.add(new Node(current.number, sheep, pq.peek().wolf));
            max = Math.max(max, parent.sheep+current.sheep);
        }

        if(current.child1 != null && !visited[current.child1.number]){
           
            travel(current, current.child1, visited, pq);
       
        }
        if(current.child2 != null && !visited[current.child2.number])
            travel(current, current.child2, visited, pq);
            

   //     return;
    }
    
}
