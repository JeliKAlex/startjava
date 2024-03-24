public class Jaeger {

    private String modelName;
    private String mark;
    private String origin;
    private float height;
    private float weight;
    private int strength;
    private int armor;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public Jaeger() {

    }

    public Jaeger(String modelName, String mark, String origin, float height, float weight,
            int strength, int armor) {
        this.modelName = modelName;
        this.mark = mark;
        this.origin = origin;
        this.height = height;
        this.weight = weight;
        this.strength = strength;
        this.armor = armor;
    }

    public void getInfo(){
        System.out.println("\nModel Name: " + modelName + "\nMark: " + mark + "\nOrigin: " + origin +
                "\nHeight: " + height + "\nWeight: " + weight + "\nStrength: " + strength +
                "\nArmor: " + armor);
    }

    public boolean drift() {
        System.out.println("\n" + modelName + " drifting");
        return true;
    }

    public void jump() {
        System.out.println("\n" + modelName + " jumping");
    }

    public void fight() {
        System.out.println("\n" + modelName + " fighting");
    }

    public void move() {
        System.out.println("\n" + modelName + " moving");
    }

    public String scanKaiju() {
        return "scanning";
    }

    public void useVortexCannon() {
        System.out.println("\n" + modelName + " activated");
    }
}
