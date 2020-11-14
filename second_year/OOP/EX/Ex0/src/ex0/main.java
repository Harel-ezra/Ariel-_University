package ex0;

public class main {
    public static void main(String[]args)
    {
        graph g=new Graph_DS();
        for(int i=0; i<20; i++)
        {
            node_data n = new NodeData();
            g.addNode(n);
            g.connect(i, i-1);
        }
        graph g1=new Graph_DS(g);
        graph g2=new Graph_DS(g1);
        graph_algorithms ga=new Graph_Algo(g1);
        System.out.println(g.edgeSize());
        System.out.println(g1.edgeSize());
        System.out.println(g2.edgeSize());
    }
}
