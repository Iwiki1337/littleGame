import java.util.Scanner;

public class Obrabotka {
  Board map = new Board();
  Scanner scan = new Scanner(System.in);
  String[] commands = {"start", "add", "delete", "move", "fire", "print", "exit"};
  String[] secondCommands = {"player", "wall",  "left", "right", "up", "down","all"};
  String command;
  String nope = "Неправильно введена команда";
  int byteX;
  int byteY;
  byte start1 = 0;

  int x;
  int y;
  byte or=-1;
  byte op=-1;

  byte playerX;
  byte playerY;

  boolean bePlayer=false;
  public void check(){
    op=-1;
    or=-1;
    command = scan.nextLine();
    String[] split = command.split("\\s+");
    int size = split.length;

    if(size==1){
      for(byte i = 0; i <7; i++)
      {
        if(split[0].equalsIgnoreCase(commands[i]))
        {
          or = i;
        }
      }
      if (or ==-1){
        System.out.println(nope);
      }
    } else if(size==2) {
      for (byte i = 0; i < 7; i++) {
        if (split[0].equalsIgnoreCase(commands[i])) {
          or = i;
        }
      }
      for (byte i = 0; i < 7; i++) {
        if (split[1].equalsIgnoreCase(secondCommands[i])) {
          op = i;
        }
      }
      if (or ==-1){
        System.out.println(nope);
      }
    } else if(size==3){
      for (byte i = 0; i < 7; i++) {
        if (split[0].equalsIgnoreCase(commands[i])) {
          or = i;
        }
      }
      for (byte i = 0; i < 7; i++) {
        if (split[1].equalsIgnoreCase(secondCommands[i])) {
          op = i;
        }
      }
      char[] cords = split[size-1].toCharArray();
      if(cords.length == 3) {
        x = Character.getNumericValue(cords[0]);
        y = Character.getNumericValue(cords[2]);
      } else {
        System.out.println(nope);
      }
    } else {
      System.out.println(nope);
    }
    // or - Первое слово
    // op - второе слово
    // x - координаты по x в массиве
    // y - координаты по y в массиве
    // System.out.println(or +" " + op +" "+ x +" "+ y + " "+start1);
  }
  boolean isStarting()
  {
    if(or==0 && op == -1)
    {
      start1=1;
    } else if(start1!=1) {
      System.err.println("START");
      return false;
    }
    if (start1==1)
    {
      return true;
    }
    return false;
  }
  void end() {
    System.err.println("Пока");
    System.exit(0);
  }
  void add(){
      if(map.oneBoard[x][y].getObjectType()==ObjectType.NULLL){
      if(op==0&&bePlayer!=true){
        map.oneBoard[x][y]=new Player();
        bePlayer=true;
        playerX=(byte)x;
        playerY=(byte)y;
        System.out.println("Позиция успешно установлена");
      }else if(op==1) {
        map.oneBoard[x][y] = new Wall();
        System.out.println("Позиция успешно установлена");
      }else{
        System.err.println("Игрок может быть только один");
      }
  }
    else {
        System.out.println("На этом месте уже что-то стоит");
      }
  }
  void delete()
  {
    if(map.oneBoard[x][y].getObjectType()!=ObjectType.NULLL){
      if(op==-1){
        if(map.oneBoard[x][y].getObjectType()==ObjectType.PLAYER){
          bePlayer=false;
        }
        map.oneBoard[x][y]=new Nulll();
        System.out.println("Объект удалён");
      }else if(op==6){
        map.fill();
        System.out.println("Карта очищена");
      }

    }else{
        System.out.println("Здесь и так пусто");
      }
  }

  void move(){
    if(bePlayer){
    map.oneBoard[playerX][playerY]=new Nulll();
    if(op==2){
      if(playerY!=0) playerY--;
    else {
      System.err.println("Пропасть, сюда нельзя");
    }}
    if(op==3){
      if(playerY!=9)playerY++;
    else {
        System.err.println("Пропасть, сюда нельзя");
      }}
    if(op==4){
      if(playerX!=0)playerX--;
    else {
        System.err.println("Пропасть, сюда нельзя");
      }}
    if(op==5){
      if(playerX!=9)playerX++;
    else {
        System.err.println("Пропасть, сюда нельзя");
      }}
    map.oneBoard[playerX][playerY]=new Player();
    }
    else {
      System.err.println("Позиция игрока неизвестна");
    }
  }

  void fire(){
    if(bePlayer){
      if(op==2){
        if(map.oneBoard[playerX][playerY-1].getObjectType()==ObjectType.WALL && map.oneBoard[playerX][playerY+1].getObjectType()!=null){
          map.oneBoard[playerX][playerY-1]=new Nulll();
          System.out.println("Объект уничтожен");
        }else {
          System.err.println("Здесь ничего нет");
        }
      }
      if(op==3) {
        if(map.oneBoard[playerX][playerY+1].getObjectType()==ObjectType.WALL && map.oneBoard[playerX][playerY+1].getObjectType()!=null){
          map.oneBoard[playerX][playerY+1]=new Nulll();
          System.out.println("Объект уничтожен");
        }else {
          System.err.println("Здесь ничего нет");
        }
      }
      if(op==4){
        if(map.oneBoard[playerX][playerX-1].getObjectType()==ObjectType.WALL && map.oneBoard[playerX][playerY+1].getObjectType()!=null){
          map.oneBoard[playerX][playerX-1]=new Nulll();
          System.out.println("Объект уничтожен");
        }else {
          System.err.println("Здесь ничего нет");
        }
      }
      if(op==5){
        if(map.oneBoard[playerX][playerX+1].getObjectType()==ObjectType.WALL && map.oneBoard[playerX][playerY+1].getObjectType()!=null){
          map.oneBoard[playerX][playerX+1]=new Nulll();
          System.out.println("Объект уничтожен");
        }else {
          System.err.println("Здесь ничего нет");
        }
      }
    }
  }
  void checker()
  {
    if(or==6 && op==-1){
      end();
    }else if(or==1 && op!=-1 && op<2){
      add();
    }else if(or==5 && op==-1){
      map.print();
    }else if(or==2 && (op==-1 ||op == 6)){
      delete();
  }else if(or==3&& op>1 && op <6){
      move();
    }else if(or==4&& op>1&&op<6){
      fire();
    }
  }
}
