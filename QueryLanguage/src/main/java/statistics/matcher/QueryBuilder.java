package statistics.matcher;

/**
 *
 * @author Raine Rantanen
 */
public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {

    }

    public Matcher build() {
        Matcher m = this.matcher;
        this.matcher=null;
        return m;
    }

    public QueryBuilder playsIn(String team) {
        setMatcher(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        setMatcher(new HasAtLeast(value, category) );
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        setMatcher(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }

    public void setMatcher(Matcher matcher) {
        if (this.matcher == null) {
            this.matcher = matcher;
        } else {
            this.matcher = new And(this.matcher, matcher);
        }
    }
}
