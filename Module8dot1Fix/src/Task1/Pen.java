package Task1;

public class Pen {
    private Color color;
    private boolean isCapped;

    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");

        private final String color;

        Color(String color) {
            this.color = color;
        };

        @Override
        public String toString() {
            return color;
        }
    }

    public Pen() {
        this.color = Color.RED;
        this.isCapped = true;
    }

    public Pen(Color color) {
        this.color = color;
        this.isCapped = true;
    }

    public void capOff() {
        this.isCapped = false;
    }

    public void capOn() {
        this.isCapped = true;
    }

    public String draw() {
        if (!isCapped) {
            return "Drawing " + color;
        } else {
            return "";
        }
    }

    public void changeColor(Color color) {
        if (isCapped) {
            this.color = color;
        }
    }
}
