public class TestObj implements Comparable {

    private int num = -1;

    public TestObj(int num) {
        this.num = num;
    }

    private  int getNum() {
        return num;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof TestObj))
            return 1; // we decided this

        TestObj obj = (TestObj) o; // Cast the "object"
        int toCompare =  obj.getNum();
        if (this.getNum() < toCompare) {
            return -1;
        } else if (this.getNum() > toCompare) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "" + this.getNum();
    }
}
