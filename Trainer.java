import java.util.*;

public class Trainer {
	private String name;
    private Monster activeMonster;
    private ArrayList<Monster> team;

    public Trainer(String n){
        this.name = n;
        this.activeMonster = null;
        this.team = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public Monster getActiveMonster(){
        return activeMonster;
    }
    public ArrayList<Monster> getTeam(){
        return team;
    }

    public void capture(Monster m){
        if(m.getHP() < m.getMaxHP()*0.2){
            team.add(m);
            System.out.println(this.getName() + " caught " + m.getName() + ".");
        }
        else{
            System.out.println(this.getName() + " failed to catch " + m.getName() + ".");
        }
    }
    public void battle(Monster m){
        activeMonster.attack(m);
    }
    public void battle(Trainer t){
        activeMonster.attack(t.getActiveMonster());
    }
    public void sureCapture(Monster m) throws AlreadyCapturedException, FullTeamException {
        boolean successfulCapture = true;
      
        if (team.contains(m)) {
          successfulCapture = false;
          throw new AlreadyCapturedException(m.getName() + " is already on the team.");
        }
      
        if (team.size() == 6) {
          successfulCapture = false;
          throw new FullTeamException("The team is full.");
        }

        if (successfulCapture) {
          team.add(m);
          System.out.printf("%s was successfully captured.\n", m.getName());
        }
    }
    public void release(Monster m) throws NotInTeamException {
        boolean successfulRelease = true;

        if (!team.contains(m)) {
          successfulRelease = false;
          throw new NotInTeamException(m.getName() + " is not on the team.");
        }

        if (successfulRelease) {
          team.remove(m);
          System.out.printf("%s was released from the team.\n", m.getName());
        }
    }
}
