package hpah.core;

public class Wand {

    private Core core;
    private int size;

    public Wand(Core inputCore, int inputSize){
        core = inputCore;
        size = inputSize;
    }

    public Core getCore(){
        return core;
    }

    public int getSize() {
        return size;
    }
}
