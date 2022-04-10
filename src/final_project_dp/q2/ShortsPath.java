package final_project_dp.q2;

import final_project_dp.base_classes.IGraph;
import final_project_dp.base_classes.Node;

import java.util.*;

public class ShortsPath<T> {

    private Queue<Node<T>> workingQ; // באיזה קודקודים אני מבקר
    private Set<Node<T>> finished; // סט של מי שאני כבר ביקרתי אצלו בסיבוב הנוכחי
    private Set<Node<T>> visitedVertices; // סט של כל הקודקודים שביקרתי בהם


    public ShortsPath() {
        this.workingQ = new LinkedList<>();
        this.finished = new LinkedHashSet<>();
        this.visitedVertices = new LinkedHashSet<>();
    }

    // עובד
    public Set<T> bfs(IGraph<T> someGraph, T source, T dest){

        Map<T,Node<T>> map = new HashMap<>();

        Node<T> sourceNode = someGraph.getNode(source);
        if(sourceNode == null)
            throw new IllegalArgumentException("source node not on the graph");

        workingQ.add(sourceNode);
        while (!workingQ.isEmpty()){
            Node<T> removed = workingQ.poll();
            finished.add(removed);
            if(!map.containsKey(removed.getData()))
                map.put(removed.getData(),removed);

            if(removed.getData().equals(dest))
                break;


            Collection<Node<T>> reachableNodes = someGraph.getReachableNodes(removed);
            for (Node<T> reachableNode : reachableNodes){
//               removed.getParents().add()
                if(!finished.contains(reachableNode) && !workingQ.contains(reachableNode)){
                    workingQ.add(reachableNode);
                }
            }
        }
        Set<T> returnSet = new LinkedHashSet<>();
        for (Node<T> node: finished){
            System.out.println(node);
            returnSet.add(node.getData());
        }
        finished.clear();
        someGraph.backToRoot();
        return returnSet;
    }

    // לא עובד
    public Set<T> shortsPath(IGraph<T> someGraph, T source, T destination){

        Node<T> sourceNode = new Node<>(source);
        Node<T> destinationNode = new Node<>(destination);


        return null;
    }
}
