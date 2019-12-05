public class Board {
  Player player = new Player();
  Wall wall = new Wall();
  Element[][] oneBoard= new Element[11][11];
    public Board() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                oneBoard[i][j] = new Nulll();
            }
        }

    }
    void fill(){
            for(int i = 0; i<10;i++){
                for (int j = 0; j<10;j++){
                    oneBoard[i][j]= new Nulll();
                }
            }

    }
    void print()
    {
      for(int i = 0; i<10;i++){
        System.out.println();
        for (int j = 0; j<10;j++){
          System.out.print(oneBoard[i][j].toString());
        }
      }
    }
  }