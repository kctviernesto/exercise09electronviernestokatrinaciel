import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int notfound = 0;
        int alreadycaptured = 0;
        int fullteam = 0;
        int notinteam = 0;
        
        Trainer player = new Trainer("Steve");
        Monster m0 = new Monster("Rattata", "Normal", "None", "None", 15, 5);
        Monster m1 = new Monster("Meowth", "Normal", "None", "None", 15, 5);
        Monster m2 = new Monster("Kangaskhan", "Normal", "None", "None", 15, 5);
        Monster m3 = new Monster("Tauros", "Normal", "None", "None", 15, 5);
        Monster m4 = new Monster("Ditto", "Normal", "None", "None", 15, 5);
        Monster m5 = new Monster("Eevee", "Normal", "None", "None", 15, 5);
        Monster m6 = new Monster("Porygon", "Normal", "None", "None", 15, 5);
        Monster m7 = new Monster("Snorlax", "Normal", "None", "None", 15, 5);
        Monster m8 = new Monster("Sentret", "Normal", "None", "None", 15, 5);
        Monster m9 = new Monster("Dunsparce", "Normal", "None", "None", 15, 5);
        
        String input = "";
        
        while(!input.equals("exit")){
            System.out.print("\nWhat will the trainer do? ");
            input = sc.nextLine();
            Monster selected = null;
            if(input.equals("catch") || input.equals("release")){
                System.out.print("Which monster? ");
                String name = sc.nextLine();
                try {
                  selected = Monster.selectMonster(name);
                }
                catch (MonsterNotFoundException e) {
                  notfound++;
                  System.out.println(e.getMessage());
                }
            }
            
            switch(input) {
                case "catch":
                    try {
                      player.sureCapture(selected);
                    }
                    catch (AlreadyCapturedException e) {
                      alreadycaptured++;
                      System.out.println(e.getMessage());
                    }
                    catch (FullTeamException e) {
                      fullteam++;
                      System.out.println(e.getMessage());
                    }
                    catch (Exception e) { // breaks the code if selected is null 
                    }
                    break;
                case "release":
                    try {
                      player.release(selected);
                    }
                    catch (NotInTeamException e) {
                      notinteam++;
                      System.out.println(e.getMessage());
                    }
                    catch (Exception e) { // breaks the code if selected is null 
                    }
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Invalid input.\n");
            }
        }
        
        System.out.printf("\nEncountered errors:%n"
                + "MonsterNotFoundException: %d%n"
                + "AlreadyCapturedException: %d%n"
                + "FullTeamException: %d%n"
                + "NotInTeamException: %d%n", 
                notfound, alreadycaptured, fullteam, notinteam);
    }
    
}
