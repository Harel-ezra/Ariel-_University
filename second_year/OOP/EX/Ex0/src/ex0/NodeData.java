package ex0;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class NodeData implements node_data {
    private static int node_Counter = 0;
    private int key_id;
    private HashMap<Integer, node_data> neighbor_nodes;
    private String info = "false"; // visited or not
    private int tag = -1; // length from src

    /**
     * constructor
     */
    public NodeData() {
        this.key_id = node_Counter;
        node_Counter++;
        this.neighbor_nodes = new HashMap<Integer, node_data>();
    }

    public NodeData(String info) {
        this.key_id = node_Counter;
        node_Counter++;
        this.info = info;
        this.neighbor_nodes = new HashMap<Integer, node_data>();
    }

    public NodeData(int tag) {
        this.key_id = node_Counter;
        node_Counter++;
        this.tag = tag;
        this.neighbor_nodes = new HashMap<Integer, node_data>();
    }

    /**
     * copy constructor
     */
    public NodeData(node_data node) {
        this.key_id = node.getKey();
        this.info = node.getInfo();
        this.tag = node.getTag();
        this.neighbor_nodes = new HashMap<Integer, node_data>();
    }


    /**
     * return the key ID fit to this node
     */
    @Override
    public int getKey() {
        return this.key_id;
    }

    /**
     * return a collection with all neighbor nodes of this node.
     * @return
     */
    @Override
    public Collection<node_data> getNi() {
        return this.neighbor_nodes.values();
    }

    /**
     * return if the key are in neighbor collection, that it mean that the
     * are neighbor
     */
    @Override
    public boolean hasNi(int key) {
        return neighbor_nodes.containsKey(key);
    }

    /**
     * adds the node data to this node data neighbor collection, that its mean, make a connect between them.
     * @param t
     */
    @Override
    public void addNi(node_data t)
    {
        if(t!=null)
        {
            neighbor_nodes.put(t.getKey(), t);
        }
    }

    /**
     * remove edge from this node, that its mean disconnect both node.
     * @param node
     */
    @Override
    public void removeNode(node_data node) {
        if (node != null)
        {
            neighbor_nodes.remove(node.getKey());
        }
    }

    /**
     * return the info of this node
     *
     * @return
     */
    @Override
    public String getInfo() {
        return this.info;
    }

    /**
     * set info node
     *
     * @param s
     */
    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    /**
     * return the node tag
     * @return
     */
    @Override
    public int getTag() {
        return this.tag;
    }

    /**
     * set tag for this node
     * @param t - the new value of the tag
     */
    @Override
    public void setTag(int t) {
        this.tag = t;
    }

    /**
     * methode to do a deep copy for a hashMap
     * get collection and return hashMap
     * used to copy grape and neighbor collection
     * @return
     */
    public static HashMap<Integer, node_data> hashDeepCopy(Collection<node_data> col) {
        HashMap<Integer, node_data> newHashMap = new HashMap<Integer, node_data>();
        for (node_data n : col) {
            node_data newNode = new NodeData(n);
            newHashMap.put(newNode.getKey(), newNode);
        }
        return newHashMap;


    }

}