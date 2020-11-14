package ex0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Graph_DS implements graph {
    private HashMap<Integer, node_data> gr;
    private int edge_counter = 0;
    private int MC = 0;

    /**
     * constructor
     */
    public Graph_DS() {
        this.gr = new HashMap<Integer, node_data>();
    }

    /**
     * copy constructor
     */
    public Graph_DS(graph g) {
        //first copy the node at the grape
        this.gr = NodeData.hashDeepCopy(g.getV());
        // second, connect the new grape exactly like the last
        for (node_data node : g.getV()) {
            for (node_data n : node.getNi()) {
                connect(node.getKey(), n.getKey());
            }
        }
    }

    /**
     * return the node by key id node, if no exist return null
     *
     * @return
     */
    @Override
    public node_data getNode(int key) {
        return this.gr.get(key);
    }

    /**
     * return true if there is a edge between the nodes
     *
     * @return
     */
    @Override
    public boolean hasEdge(int node1, int node2) {
        node_data n1 = getNode(node1);
        if (n1 != null) {
            return n1.hasNi(node2);
        }
        return false;
    }

    /**
     * add a new node to the graph
     *
     * @param n
     */
    @Override
    public void addNode(node_data n) {
        if (n != null) {
            this.gr.put(n.getKey(), n);
            this.MC++;
        }
    }

    /**
     * creat a edge between the node1 and node2
     *
     * @param node1
     * @param node2
     */
    @Override
    public void connect(int node1, int node2) {
        node_data n1 = getNode(node1);
        node_data n2 = getNode(node2);
        if ((n1 != null) && (n2 != null)) {
            if ((!n1.hasNi(node2)) && (n1.getKey() != n2.getKey())) {
                n1.addNi(n2);
                n2.addNi(n1);
                this.edge_counter++;
                this.MC++;
            }
        }
    }

    /**
     * return a collection that representing all the
     * nodes at a graph
     *
     * @return
     */
    @Override
    public Collection<node_data> getV() {
        return this.gr.values();
    }

    /**
     * return a collection of neighbor for specific node
     *
     * @param node_id
     * @return
     */
    @Override
    public Collection<node_data> getV(int node_id) {
        if (!this.gr.containsKey(node_id)) {
            Collection<node_data> col = new ArrayList<node_data>();
            return col;
        }
        node_data n = getNode((node_id));
        return n.getNi();
    }

    /**
     * delete the node from the graph, include all is neighbor
     *
     * @param key
     * @return
     */
    @Override
    public node_data removeNode(int key) {
        if (!(gr.containsKey(key))) {
            return null;
        }
        // remove all edge and neighbor of the node from the graph
        for (node_data node : getV(key)) {
            node.removeNode(getNode(key));
            this.edge_counter--;
            this.MC++;
        }
        node_data n = gr.remove(key); // remove the node from the graph and return it
        this.MC++;
        return n;
    }

    /**
     * remove a edge between tow nodes
     *
     * @param node1
     * @param node2
     */
    @Override
    public void removeEdge(int node1, int node2) {
        node_data n1 = getNode(node1);
        node_data n2 = getNode(node2);
        if ((n1 != null) & (n2 != null)) {
            if (n1.hasNi(node2)) {
                n1.removeNode(n2);
                n2.removeNode(n1);
                edge_counter--;
                this.MC++;
            }
        }
    }

    /**
     * return number of nodes at the graph
     *
     * @return
     */
    @Override
    public int nodeSize() {
        return gr.size();
    }

    /**
     * return the number of edge at the graph
     *
     * @return
     */
    @Override
    public int edgeSize() {
        return this.edge_counter;
    }

    /**
     * return the counter of any changes at the graph
     *
     * @return
     */
    @Override
    public int getMC() {
        return this.MC;
    }
}
