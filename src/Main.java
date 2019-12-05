import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Obrabotka checkCommand = new Obrabotka();
    Board map = new Board();
    System.out.println("Введи 'Start' для запуска");
    while (true)
    {
      checkCommand.check();
      while (checkCommand.isStarting())
      {
        checkCommand.check();
        checkCommand.checker();
      }



      /*Command = scan.nextLine();
      for(int i = 0; i<7;i++)
      {
        if(Command.equalsIgnoreCase(Commands[i]))
        {
          or = i;
        } else if (or ==-1 && i==6)
        {
          System.out.println();
          System.out.println("Введите комманду заново");
        }
      }
      if(or == 0){

      } else if(or == 1){
        System.out.println("Введите кого ставить");
        System.out.println("1-player 2-wall");
        int ob = scan.nextInt();
        System.out.println("Введите положение x");
        int x1 = scan.nextInt();
        System.out.println("Введите положение y");
        int y1 = scan.nextInt();
        rab.add(ob, x1, y1);
      } else if(or == 2){
        rab.delete();
      } else if(or == 3){
        rab.move();
      } else if(or == 4){
        rab.fire();
      } else if(or == 5){
        rab.print();
      } else if(or == 6){
        rab.exit();
      }*/
    }
  }
}