# TravelingSalesman

The strategy we wanted to use to test all the routes:
nested loops that would go through every possible route
like going down every branch of a tree diagram

The strategy used to test all the routes:
shuffling the arraylist of cities 2 * n! times to generate
*probably* most of the routes.

Every time a new route is inspected, the cities are gone through in pairs to find the time traveled between each. To find the travel time
the cities are plugged into a helper function which finds those cities
in the scanned distances.

Once the time between each pair is added up, if that route's total time
is better than the best so far it replaces it. The best starts at the
maximum integer value because past that time you should really consider just staying home.
