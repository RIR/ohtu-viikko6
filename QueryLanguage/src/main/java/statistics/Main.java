package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

//        Matcher m = new And(new HasAtLeast(10, "goals"),
//                new HasAtLeast(30, "assists"),
//                new PlaysIn("PHI")
//        );
//
//        Matcher m2 = new Or(new HasAtLeast(1000, "goals"),
//                new HasAtLeast(50, "assists"));
//
//        Matcher m3 = new Not(new HasAtLeast(5, "goals"),
//                new HasAtLeast(5, "assists"));
//
//
//        System.out.println("");
//        System.out.println("Lista 2 Or");
//        System.out.println("");
//
//        for (Player player : stats.matches(m2)) {
//            System.out.println(player);
//        }
//
//        System.out.println("");
//        System.out.println("Lista 3 Not");
//        System.out.println("");
//        
//        for (Player player : stats.matches(m3)) {
//            System.out.println(player);
//        }
        QueryBuilder query = new QueryBuilder();

       Matcher m = query.oneOf(
                        query.playsIn("PHI")
                             .hasAtLeast(10, "goals")
                             .hasFewerThan(20, "assists").build(),
 
                        query.playsIn("EDM")
                             .hasAtLeast(60, "points").build()
                       ).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

    }
}
