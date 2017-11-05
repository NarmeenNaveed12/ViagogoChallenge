public class Pairs {
   int x;
   int y;

public Pairs(int x, int y) {
      this.x = x;
      this.y = y;
}

public void setX(int x){
   this.x = x; 
}

public void setY(int y){ 
  this.y = y; 
}

public int getX() {
  return this.x;
}

public int getY() {
  return this.y;
}

public boolean equals(Object o) {
if (o == null || o.getClass() != this.getClass()) { 
  return false; 
}
  Pairs that = (Pairs) o;
  return (x == null ? that.x == null : x.equals(that.x))
  && (y == null ? that.y == null : y.equals(that.y));
}

public String toString(){
  return x + "," + y;
}

}
