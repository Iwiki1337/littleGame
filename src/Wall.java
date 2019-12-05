public class Wall implements Element{
  @Override
  public ObjectType getObjectType(){
    return ObjectType.WALL;
  }
  public String toString(){
    return "*";
  }
}