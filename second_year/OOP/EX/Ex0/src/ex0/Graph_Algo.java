package ex0;

import java.util.*;

public class Graph_Algo implements graph_algorithms {
    private graph grAl;

    /**
     * constructor
     */
    public Graph_Algo() {
        this.grAl = new Graph_DS(); //new Graph_DS();
    }

    public Graph_Algo(graph g) {
        this.grAl = g;
    }

    /**
     * init the pointer graph to this one that got
     *
     * @param g
     */
    @Override
    public void init(graph g) {
        this.grAl = g;
    }

    /**
     * made deep copy ot the graph
     *
     * @return
     */
    @Override
    public graph copy() {
        graph grNew = new Graph_DS(this.grAl);
        return grNew;
    }

    /**
     * return true or false if all the node are connected together
     * at anything way - that its meaning "connected graph"
     * used BFS algorithm:
     * the BFS algorithm return number that present counter node
     * are connected.
     * if this number = size of node at the graph its connected graph.
     * @return
     */
    @Override
    public boolean isConnected() {
        if (grAl.nodeSize() <= 1) {
            // graph with nodes or only one is connected graph.
            return true;
        }
        node_data n = grAl.getV().iterator().next();
        int j = BFS(n);
        cleanNodeDetails();
        return (j == grAl.nodeSize());
    }

    /**
     * return the length of the shortest way between 2 nodes,
     * src and dest
     * used BFS algorithm:
     * at BFS algorithm we used at the private NodeData tag to set the
     * length from src
     * @param src  - start node
     * @param dest - end (target) node
     * @return
     */
    @Override
    public int shortestPathDist(int src, int dest) {
        if (!grAl.getV().contains(grAl.getNode(src)) || !grAl.getV().contains(grAl.getNode(dest))) {
            return -1;
        }
        BFS(grAl.getNode(src));
        int l = grAl.getNode(dest).getTag();
        cleanNodeDetails();
        return l;
    }

    /**
     * return the description of the shortest way between 2 nodes, src and dest
     * used at BFS algorithm:
     * after we done BFS algo, we start from the dest node and looking
     * his father, we recognize is at tag-1.
     * we do it until we arrive to the start node.
     * all the way we save a list for the way.
     * @param src  - start node
     * @param dest - end (target) node
     * @return
     */
    @Override
    public List<node_data> shortestPath(int src, int dest) {
        List<node_data> list = new ArrayList<node_data>();
        if (!grAl.getV().contains(grAl.getNode(src)) || !grAl.getV().contains(grAl.getNode(dest))) { //if no have a path return empty list
            return list;
        }
        BFS(grAl.getNode(src));
        node_data n = grAl.getNode(dest);
        if (n.getTag() == -1) {
            cleanNodeDetails();
            return list;
        }
        list.add(0, n);
        // loop to find the wat from the dest to the src by go back
        while ((n.getTag() != 0) )
             {
            for (node_data ni : n.getNi()) {
                if (ni.getTag() == (n.getTag() - 1)) {
                    list.add(0, ni);
                    n = ni;
                    break;
                }
            }
        }
        cleanNodeDetails();
        return list;
    }

    /**
     * BFS algorithm:
     * got start node, and return int number that present the number
     * of node that connect together.
     * every time we pop the head node at the queue
     * and check if is neighbor pass away at the queue, if not
     * we push them the the queue.
     * we finish after the queue is empty.
     */
    private int BFS(node_data src) {
        int counter = 0;
        Queue<node_data> que = new LinkedList<node_data>();
        que.add(src);
        src.setInfo("true");
        counter++;
        src.setTag(0);
        while (!que.isEmpty()) {
            node_data i = que.poll();
            // counter++;
            Collection<node_data> ni = i.getNi();
            for (node_data n : ni) {
                if (n.getInfo().equals("false")) {
                    n.setInfo("true");
                    que.add(n);
                    counter++;
                    n.setTag(i.getTag() + 1);
                }
            }
        }
        return counter;
    }

    /**
     * clear the node info adn tag at the graph back.
     */
    private void cleanNodeDetails() {
        for (node_data n : grAl.getV()) {
            n.setInfo("false");
            n.setTag(-1);
        }
    }

}
