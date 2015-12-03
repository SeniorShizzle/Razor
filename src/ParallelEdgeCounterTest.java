import java.io.File;

import static org.junit.Assert.*;

/*Razor, 2015

Created Dec 02, 2015 by Esteban Valle

Copyright © 2015  Esteban Valle. All rights reserved.

+1-775-351-4427
esteban@thevalledesign.com
http://facebook.com/SeniorShizzle
*/
public class ParallelEdgeCounterTest {

    @org.junit.Test
    public void testSize() throws Exception {
        Graph graph = new Graph(new In(new File("./src/tinyG.txt")));
        ParallelEdgeCounter counter = new ParallelEdgeCounter(graph);

        System.out.println(counter.size());
        assertEquals(counter.size(), 0);

        graph.addEdge(7, 8);
        //counter = new ParallelEdgeCounter(graph);

        System.out.println(counter.size());
        assertEquals(counter.size(), 1);
    }
}