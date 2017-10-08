class Entity{
    public static int counter = 0;
    private int id;
    public Entity(){
        this.id = counter;
        counter++;
    }
    public int showId(){
        return this.id;
    }
}


public class Application {

        public static void main (String[] args) {
            for (int i = 0; i < 10; i++){
                Entity e =  new Entity();
                System.out.println(e.showId());
            }
        }
}
