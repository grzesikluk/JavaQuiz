package quiz2.question2;

/**
 * Created by Lukasz on 2016-12-18.
 */
public class Pixel {

    public Pixel(int x, int y, int[] channels) {
        this.x = x;
        this.y = y;
        this.channels = channels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pixel pixel = (Pixel) o;

        if (x != pixel.x) return false;
        return y == pixel.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getChannels() {
        return channels;
    }

    public void setChannels(int[] channels) {
        this.channels = channels;
    }

    int[] channels;


}
