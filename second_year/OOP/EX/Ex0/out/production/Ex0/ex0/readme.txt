EXO Project

at this project we implement the data structure of unadjusted graph.
we implement a three class.

NodeData class:

This class present a single Node.
every node have some parameters.
first for every node have a unique key id, that help us to find and recognize it at the graph.
its given buy counter.
an addition, for every node have a list for all is neighbor. its sava at HashMap data structure for a fast action.
and have a string info and int tag that helpful for Graph Algorithm.
at the start, info initialized to "false" that its mean not visited, and tad set to -1, that its mean no connected to src.

Graph_DS class:

This class present a Graph.
all the node at the graph sava at HashMap for a fast runtime and direct access for every node at the graph.
also, for this class have some methode like get a key, connect tow nodes and creat between them a edge.
remove and add node to the graph and more.

Graph_Algo class:

At this we have some action and algorithm on the graph.
the complicated method used at BFS algorithm.
the BFS algorithm its an algorithm to find the southwest way between tow nodes at the graph.
we used this algo for check if the graph is "connected graph",
that its mean all the nodes at the graph have a path between them, and to check the shortest path between
tow nodes and return the number, and the nodes at the way.
