import java.util.*;

interface SuperMario {
    void pick(Item item);

    public void receiveHit();

    public boolean fire();

    public int getCointCount();

    public State getCurrentState();
}

enum Item {
    COIN, MUSHROOM, FLOWER
}

enum State {
    DEAD, SMALL_MARIO, BIG_MARIO, FIRE_MARIO
}

class SuperMarioImplementation implements SuperMario {
    private int coin_count;
    private State state;

    public SuperMarioImplementation() {
        this.coin_count = 0;
        this.state = State.SMALL_MARIO;
    }

    public void pick(Item item) {
        if (state != State.DEAD) {
            if (item == Item.COIN) {
                System.out.println("Picked a coin!");
                coin_count++;
            } else if (item == Item.MUSHROOM) {
                System.out.println("Picked a shroom!");
                if (state == State.SMALL_MARIO) {
                    this.state = State.BIG_MARIO;
                }

            } else if (item == Item.FLOWER) {
                System.out.println("Picked a flower!");
                if (state == State.SMALL_MARIO) {
                    this.state = State.BIG_MARIO;
                } else if (state == State.BIG_MARIO) {
                    this.state = State.FIRE_MARIO;
                    System.out.println("Now FIRE!");
                }
            }
        }
    }

    public void receiveHit() {
        if (state != State.DEAD) {
            if (state == State.BIG_MARIO || state == State.FIRE_MARIO) {
                System.out.println("Mario recieved a hit!");
                this.state = State.SMALL_MARIO;
                System.out.println("new state is " + state);
            } else if (state == State.SMALL_MARIO) {
                System.out.println("Mario recieved a hit!");
                this.state = State.DEAD;
                System.out.println("Game over");
            }
        }
    }

    public boolean fire() {
        if (this.state == State.FIRE_MARIO) {
            System.out.println("Mario Fire");
            return true;
        }
        System.out.println("You can't fire");
        return false;
    }

    public int getCointCount() {
        System.out.println("Mario has: " + coin_count + " coins");
        if (coin_count > 10) {
            System.out.println("Mario. lend me?");
        }
        return coin_count;
    }

    public State getCurrentState() {
        System.out.println("Mario's current state" + state);
        return state;
    }

    public State checkCurrentState() {
        return state;
    }
}

public class Mario {
    public static void main(String args[]) {
        SuperMarioImplementation sm = new SuperMarioImplementation();
        Scanner sc = new Scanner(System.in);
        String line = "";
        System.out.println("GET_COINS | GET_STATE | FIRE | SHROOM | COIN | FLOWER | HIT | ");
        System.out.println();
        sm.getCointCount();
        sm.getCurrentState();
        while (true) {
            if (sm.checkCurrentState() == State.DEAD) {
                System.out.println("Whoops. Mario is dead. Game over!");
                break;
            }
            System.out.println("Enter a command or enter 'END' to exit: ");
            line = sc.nextLine();

            if (line.contentEquals("END")) {
                System.out.println("Exiting...");
                System.out.println("Sucessfully exited");
                break;
            } else if (line.contentEquals("GET_COINS")) {
                sm.getCointCount();
            } else if (line.contentEquals("GET_STATE")) {
                sm.getCurrentState();
            } else if (line.contentEquals("FIRE")) {
                sm.fire();
            } else if (line.contentEquals("SHROOM")) {
                sm.pick(Item.MUSHROOM);
            } else if (line.contentEquals("COIN")) {
                sm.pick(Item.COIN);
            } else if (line.contentEquals("FLOWER")) {
                sm.pick(Item.FLOWER);
            } else if (line.contentEquals("HIT")) {
                sm.receiveHit();
            }
        }
    }
}
