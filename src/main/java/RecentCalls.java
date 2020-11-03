import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * You have a RecentCounter class which counts the number of recent requests within a certain time frame.
 *
 * Implement the RecentCounter class:
 *
 * RecentCounter() Initializes the counter with zero recent requests.
 * int ping(int t) Adds a new request at time t, where t represents some time in milliseconds,
 * and returns the number of requests that has happened in the past 3000 milliseconds (including the new request).
 * Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
 * It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
 */
public class RecentCalls {
    public class RecentCounter {
        ArrayList<Integer> slideWindow;

        public RecentCounter() {
            this.slideWindow = new ArrayList<>();
        }

        public int ping(int t) {
            this.slideWindow.add(t);

            while (this.slideWindow.get(0) < t - 3000) {
                this.slideWindow.remove(0);
            }

            return this.slideWindow.size();
        }
    }

    @Test
    public void test() {
        RecentCounter recentCounter = new RecentCounter();
        Assert.assertEquals(recentCounter.ping(1), 1);
        Assert.assertEquals(recentCounter.ping(100), 2);
        Assert.assertEquals(recentCounter.ping(3001), 3);
        Assert.assertEquals(recentCounter.ping(3002), 3);
        Assert.assertEquals(recentCounter.ping(6003), 1);
    }
}
